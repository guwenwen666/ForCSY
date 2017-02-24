/**
 * 快处快赔流程
 * @author wangqiang
 * @description
 */
var app = angular.module("myApp", ["ui.router"]);

app.config(function ($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('detail', {
		url: '/detail',
    	params: {data: undefined},
		templateUrl: 'detail.html',
		controller: 'detail'
    }).state('/',{
    	url: '/',
    	template: ''
    });
});

app.controller("detail", function($scope, $stateParams, $state){
	if(!$stateParams.data){
		$state.go("/");
	}
	
	$scope.formatterTime = function(date){
		return new Date(date.time).format("yyyy-MM-dd hh:mm:ss");
	};
	
	$scope.info = $stateParams.data;
});

app.controller("myCtrl", function($scope, $http, $state){
	
	$scope.pages = [];
	$scope.pageNum = 1;
	$scope.noMoreData = false;
	
	/*图片加载类*/
	$scope.loadPage = function(pageIndex){
		$http({
			method: "post",
			url: rootPath + "/wx/getKckpPageInfo",
			params: {
				pageNum: pageIndex
			}
		}).success(function(data,status,config,headers){
			//有数据的时候才进行填充
			if(data.list.length>0){
				$scope.pages[data.pageNum-1] = data;
				if(data.endRow<data.total){
					$scope.pageNum++;
				}else{
					$scope.noMoreData = true;
				}
			}
		}).error(function(data,status,hedaers,config){
			console.log(data);
		});
	};
	//默认加载一页
	$scope.loadPage(1);
	
	$scope.formatterTime = function(date){
		return new Date(date.time).format("yyyy年MM月dd日");
	};

	$scope.formatterPosition = function(info){
		var geocoder = new qq.maps.Geocoder();
		var latLng = new qq.maps.LatLng(info.latitude, info.longitude);
		geocoder.getAddress(latLng);//对指定经纬度进行解析
		geocoder.setComplete(function(result) {
			$scope.$apply(function(){
				if(!!result.detail.address){
					var address = result.detail.addressComponents;
					info.position = address.city+address.district+address.streetNumber;
				}else{
					info.position = "经度:"+info.longitude+",纬度:"+info.latitude;
				}
			});
		});
		//若服务请求失败，则运行以下函数
		geocoder.setError(function() {
			$scope.$apply(function(){
				info.position = "经度:"+info.longitude+",纬度:"+info.latitude;
			});
		});
	};
	
	$scope.detail = function(info){
		$state.go("detail", {data:info});
	};
});
