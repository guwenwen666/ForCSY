/**
 * 快处快赔流程
 * @author wangqiang
 * @description
 */

var app = angular.module("myApp", ["ngTouch","ui.router"]);

app.config(function ($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('toast_ok', {
		url: '/toast_ok',
		templateUrl: 'toast_ok.html'
    }).state('toast_voice', {
    	url: '/toast_voice',
    	params : {
    		'fail': null
    	},
    	reload: true,
    	templateUrl: 'toast_voice.html',
    	controller: 'toastVoiceController'
    }).state('/', {
    	url: '/',
    	templateUrl: 'empty.html'
    });
});

app.controller("toastVoiceController", function($scope, $stateParams) {
	$scope.fail = $stateParams.fail;
});

app.controller("myCtrl", function($scope, $state ,$timeout) {
	
	//根据localID, 获取xxtp的json数据
	var getXxtpJSONByLocalId = function(localId){
		//获取总的列表
		var xxtps = [];
		for(var i in $scope.xxtps){
			xxtps.push($scope.xxtps[i].uploadUrl);
		}
		//获取当前上传的json
		var j = $.inArray(localId, xxtps);
		if(j>-1){
			return $scope.xxtps[j];
		}else{
			return null;
		}
	};
	
	var uploadSingleImage = function(localId, callback){
		//开始上传的设置
		var json1 = getXxtpJSONByLocalId(localId);
    	if(!!json1){
        	json1.uploadWaiting = true;
        	json1.uploading = true;
    	}
    	
		wx.uploadImage({
    	    localId: localId, 			// 需要上传的图片的本地ID，由chooseImage接口获得
    	    isShowProgressTips: 0, 				// 默认为1，显示进度提示
    	    success: function (res) {
    	    	var json = getXxtpJSONByLocalId(localId);
    	    	if(!!json){
        	        $scope.$apply(function(){
	        	    	json.uploadSuccess = true;
        	        	json.uploadError = 0;
        	        	json.uploadWaiting = false;
        	        	json.uploading = false;
        	        	json.serverId = res.serverId;	// 返回图片的服务器端ID
	        		});
    	    	}
    	    },
    	    fail: function(res){
    	    	var json = getXxtpJSONByLocalId(localId);
    	    	if(!!json){
        	    	$scope.$apply(function(){
	        	    	json.uploadSuccess = false;
        	        	json.uploadError++;
        	        	json.uploadWaiting = false;
        	        	json.uploading = false;
        	        	json.serverId = undefined;	// 返回图片的服务器端ID
	        		});
        	    	alert("上传失败: "+res.errMsg);
        	    	if(json.uploadError >= 3){
        	    		alert("失败次数过多,请删除并更换新的图片");
        	    	}
    	    	}
    	    },
    	    complete: function(){
    	    	if($.isFunction(callback)){
    	    		callback();
    	    	}
    	    }
    	});
	};
	
    //本地图片上传列表
    var uploadImageList = function(localIds, index){
    	if(!index) index = 0;
    	//本地选中元素还有
    	if(index <= localIds.length-1){
    		uploadSingleImage(localIds[index], function(localIds, newIndex){
    	    	return function(){
    	    		uploadImageList(localIds, newIndex);
    	    	};
    		}(localIds, ++index));
    	}
    };
	
	
	//事故描述字段及时提醒绑定
	$scope.getSgfsmsLenght = function() {
		if(!$scope.sgfsms){
			return 0;
		}else{
			return $scope.sgfsms.length;
		}
	};
	
	$scope.jsyxxIndex = function(number){
		return String.fromCharCode(number);
	};

	//驾驶员加载信息
	$scope.jsyxxs = [
//	                 {name:"",hphm:"",phone:""},
	                 {name:"",hphm:"",phone:""}
	                 ];
	
	//新增驾驶员事件绑定
	$scope.addJsy = function(){
		$scope.jsyxxs.push({name:"",hphm:"",phone:""});
		
		if($scope.jsyxxs.length >= 3){
			$scope.disableAddJsy = false;
		}else{
			$scope.disableAddJsy = true;
		}
	};
	
	//驾驶员删除操作
	$scope.deleteJsy = function(index){
		$scope.jsyxxs.splice(index, 1);

		if($scope.jsyxxs.length >= 3){
			$scope.disableAddJsy = false;
		}else{
			$scope.disableAddJsy = true;
		}
	};
	
	//图片上传操作初始化数据
	$scope.xxtps = [];
	//删除已经上传的图片
	$scope.deleteUpload = function($event, index){
		var rst = window.confirm("确定要删除该图片吗?");
		if(rst){
			$scope.xxtps.splice(index, 1);
		}
		$event.stopPropagation();
	};
	
	//上传元素点击事件(如果是已上传成功的图片,则打开预览界面,如果是上传失败的图片,点击重传)
	$scope.uploadClick = function(index){
		var xxtpJSON = $scope.xxtps[index];
		
		//在非编辑状态的前提下，上传失败且未还不在上传队列中的需要重新上传，
		if(!$scope.editUploder && xxtpJSON.uploadError > 0 && !xxtpJSON.uploadWaiting){
			uploadSingleImage(xxtpJSON.uploadUrl);
		}
		//其他元素直接预览即可
		else{
			var urls = [];
			for(var i in $scope.xxtps){
				urls.push($scope.xxtps[i].uploadUrl);
			}
			wx.previewImage({
			    current: $scope.xxtps[index].uploadUrl, 
			    urls: urls // 需要预览的图片http链接列表
			});
		}
	};
	
	//图片上传到本地
	$scope.uploadImgLocal = function(){
		wx.chooseImage({
		    count: 9, 
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        for(var i=0; i<localIds.length; i++){
		        	if($scope.xxtps.length >= 10){
		        		alert("最多可上传十张图片!");
		        		return;
		        	}
		        	$scope.$apply(function(){
		        		$scope.xxtps.push({
			        		uploadUrl: localIds[i],
			        		uploadSuccess: false,
			        		uploadError: 0,
			        		uploadWaiting: true,
			        		uploading: false,
			        		serverId: undefined
			        	});
		        	});
		        }

		        uploadImageList(localIds);
		    }
		});
	};
	
	$scope.onTouchMove = function(event){
		//录音状态下,禁止浏览器滚动
		if(!!$scope.inVoice){
			event.preventDefault();
			return false;
		}else{
			return true;
		}
	};
	
	//开始录音
	$scope.startRecord = function(){
		$scope.inVoice = !$scope.inVoice;
		wx.startRecord();
		//时间过短弹出框
		$state.go("toast_voice",{fail:false});
	};
	
	$scope.stopRecord = function(){
		//如果不再录音过程中,直接返回
		if(!$scope.inVoice)return;
		
		var rst = false;
		wx.stopRecord({
		    success: function (res) {
		    	rst = true;
		    	//录制成功关闭弹框
	    		$state.go("/");
		    	
//		        var localId = res.localId;
////		        wx.playVoice({
////		            localId: localId // 需要播放的音频的本地ID，由stopRecord接口获得
////		        });
		    },
		    fail: function(res){
		    	//录制失败,开启弹框
		    	if(res.errMsg.indexOf("tooshort")){
		    		$state.go("toast_voice",{fail:"时间太短"});
		    	}else{
		    		$state.go("toast_voice",{fail:"未知错误"});
		    	}
		    },
		    complete: function(res){
		    	$scope.$apply(function(){
		    		//有异常
		    		if(!rst){
			    		$timeout(function(){
				    		$state.go("/");
				    		$scope.inVoice = !$scope.inVoice;
			    		}, 1000, true);
		    		}else{
		    			$scope.inVoice = !$scope.inVoice;
		    		}
		    	});
		    }
		});
	};
});


$(function(){
	$.getJSON(rootPath+"/wx/sign?url=" + encodeURIComponent(location.href.split('#')[0]), function (res) {
        wx.config({
            debug: false,
            appId: res.appid,
            timestamp: res.timestamp,
            nonceStr: res.nonceStr,
            signature: res.signature,
            jsApiList: [
				"getLocation",
				"openLocation",
				"chooseImage",
				"previewImage",
				"uploadImage",
				"startRecord",
				"stopRecord",
				"onVoiceRecordEnd",
				"playVoice",
				"stopVoice",
				"onVoicePlayEnd",
				"uploadVoice"
            ]
        });
        
        wx.ready(function(rst){
        	$("#position").click(function(){
        		getLocation();
        	});
        });
    });
	
	
	function getLocation(){
		wx.getLocation({
		    type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
		    success: function (res) {
		    	wx.openLocation({
		    	    latitude: res.latitude, // 纬度，浮点数，范围为90 ~ -90
		    	    longitude: res.longitude, // 经度，浮点数，范围为180 ~ -180。
		    	    name: '', // 位置名
		    	    address: '', // 地址详情说明
		    	    scale: 14, // 地图缩放级别,整形值,范围从1~28。默认为最大
		    	    infoUrl: 'http://weixin.qq.com' // 在查看位置界面底部显示的超链接,可点击跳转
		    	});
		    }
		});
	}
	
});