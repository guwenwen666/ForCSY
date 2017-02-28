
$(function() {
	initResize();
	initComponent();
	loadLxk();
	restParam();
});
function initResize(){
	var  winWidth = $(window).width();//窗口宽度
	var  winHeight = $(window).height();//窗口高度
	$(".whole-div").width(winWidth); //整体的宽度
	$(".whole-div").height(winHeight - 45);//整体的高度
	$('#dataGrid').height($('.main-top').height() - $('.titleDiv').height());
	$('.main-top1').height($('.whole-div').height() - $('.main-top').height()-35);
	$('#mainDiv1').height($('.main-top1').height() - $('.titleDiv').height()-4);
	$('#mainDiv2').height($('.main-top1').height() - $('.titleDiv').height()-4);
	$('.main-top1').width($('.main-top').width());
}
//加载省份简称
var values = "";
function loadLxk(){
	$.ajax({
		type: "post",
		url: rootPath + "/xtpz",
		data: {
		},
		dataType: "json",
		async: false,
		success: function(rst){
			if(rst.error != ""){
				alert(rst.error);
				return ;
			}else{
				if(null != rst.data && rst.data.length > 0){
					$.each(rst.data, function (i, item) {
						jQuery("#list").append("<option value="+ item.id+">"+ item.dmxywm+"</option>");
					}); 
				}
				$("#values").html(rst.cysf.val);
				values = rst;
			}
		}
	});
}
//注册点击事件
function initComponent(){
	//查询按钮注册
	$("#vehicleSearchBtn").click(function(){
		btnSearch();
	});
	//重置按钮注册
	$("#vehicleSearchResetBtn").click(function(){
		restParam();
	});
}
//把条件参数重置成空
function restParam(){
	$("#list").val("-1");
	$('#wxh').val('');
	$('#hphmInput').val('');
	$('#kssj').val($('#hidden_kssj').val());
	$('#jssj').val($('#hidden_jssj').val());
}
//选中默认省份值改变对应的下拉框值
function Switch() {
    $("#list").val(values.cysf.description);
}
//查询方法
function btnSearch(){
	var hphm = "";
	for(var i = 0; i < values.data.length; i ++){
		if($("#list").val() == values.data[i].id){
			hphm = values.data[i].dmxywm;
		}
	}
	if($('#hphmInput').val() != "" && $('#hphmInput').val() != null){
		hphm = hphm + $('#hphmInput').val();
	}
	$.ajax({
		type: "post",
		url: rootPath + "/kckpcx",
		data: {
			kssj:$('#kssj').val(),
			jssj:$('#jssj').val(),
			wxzh:$('#wxh').val(),
			hphm:hphm
		},
		dataType: "json",
		async: false,
		success: function(data){
			if(data.error != ""){
				alert(data.error);
				return ;
			}else{
				$("#mainDiv1").empty(); 
				$("#mainDiv2").empty();
				if(data.length == 0){
					alert("没有查询到数据");
				}
				makeLeftTable(data);
			}
		}
	});
}
//左侧动态生成快处快赔查询列表
function makeLeftTable(data){
	if(data.data != null && data.data.length > 0){
		$.each(data.data, function (i, item) {
			var j = i + 1;
			$("#mainDiv1").append("<div id='main"+i+"' class='d_out' onmouseover='sizeOver("+i+")' onmouseout='sizeOut("+i+")' style='width: 99.5%;height:100px;border: 1px solid #d1d1d1;cursor:pointer' onclick='onClick(this,"+JSON.stringify(item)+")'></div>");
			$("#main"+i).append("<div id='divDiv"+i+"' style='width:25%;float: left;margin-top: 10px;text-align: center;position: relative'></div>");
			$("#divDiv"+i).append("<div id='text' style='position: absolute; top: 25px; left: 45%;'><p>"+j+"</p></div>");
			$("#divDiv"+i).append("<img  id='images' src='"+rootPath+"/static/img/common/background.png' />");
			$("#main"+i).append("<div id='divTable"+i+"' style='width:75%;float: right;margin-top: 10px;'></div>");
			$("#divTable"+i).append("<table id='table"+i+"'></table>");
			$("#table"+i).append("<tr id='tr1"+i+"'></tr>");
			$("#tr1"+i).append("<td style='height:20px;'>号牌号码:</td>");
			var hphm = "";
			if(item.bDriverInfos != null && item.bDriverInfos.length > 0){
				$.each(item.bDriverInfos, function (i, items) {
					if(items == null || items.hphm == ""){
						hphm = hphm + "无车牌  ";
					}else{
						hphm = hphm + items.hphm + " ";
					}
				});
			}
			$("#tr1"+i).append("<td style='height:20px;'>"+hphm+"</td>");
			$("#table"+i).append("<tr id='tr2"+i+"'></tr>");
			$("#tr2"+i).append("<td style='height:20px;'>微信号:</td>");
			$("#tr2"+i).append("<td style='height:20px;'>"+item.wxzh+"</td>");
			$("#table"+i).append("<tr id='tr3"+i+"'></tr>");
			$("#tr3"+i).append("<td style='height:20px;'>事故时间:</td>");
			$("#tr3"+i).append("<td style='height:20px;'>"+item.sgsj+"</td>");
		}); 
	}
}
//鼠标移入事件
function sizeOver(e){
	$("#main"+e).removeClass("d_out");
	$("#main"+e).addClass("d_over");
}
//鼠标移出事件
function sizeOut(e){
	$("#main"+e).removeClass("d_over");
	$("#main"+e).addClass("d_out");
}
//选中区域的点击事件
function onClick(value,data){
	codeLatLng(data);
}
//根据地图上面的经纬度来获取具体城市坐在位置名称
var sgwzmc = "";
function codeLatLng(data){
	var geocoder = new qq.maps.Geocoder();
	var latLng = new qq.maps.LatLng(data.sgwd,data.sgjd);
	geocoder.getAddress(latLng);//对指定经纬度进行解析
	geocoder.setComplete(function(result) {
		sgwzmc = result.detail.address;
		makeRightLane(data);
     });
	//若服务请求失败，则运行以下函数
    geocoder.setError(function() {
       alert("出错了，请输入正确的经纬度！！！");
    });

}
//点击图片进行放大
function onClickImage(e,url){
	window.open(url);
}
//右侧区域动态生成
function makeRightLane(data){
	$("#mainDiv2").empty();
	//微信
	$("#mainDiv2").append("<div id='right1' style='height: 20%;width: 99.7%;border: 1px solid #d1d1d1;'></div>");
	$("#right1").append("<table id='rightTable' style='width:100%;height:100%;'></table>");
	$("#rightTable").append("<tr id='rightTr'></tr>");
	$("#rightTr").append("<td></td>");
	$("#rightTr").append("<td style='text-align: center;width: 10%;'><img src='"+data.wxtx+"'></td>");
	$("#rightTr").append("<td style='text-align: left;width: 20%;'>"+data.wxzh+"</td>");
	$("#rightTr").append("<td></td>");
	//事故信息
	$("#mainDiv2").append("<div id='right2'style='height: 40%;width:99.7%;border: 1px solid #d1d1d1;'></div>");
	$("#right2").append("<div id='accident'style='width: 100%;height: 20%;'></div>");
	$("#accident").append("<div id='accidentdiv'style='padding-left:20px;margin-top: 10px;'></div>");
	$("#accidentdiv").append("<img style='float: left;' src='"+rootPath+"/static/img/common/accident.png'/>");
	$("#accidentdiv").append("<font color='#41D4FF' style='float: left;padding-left: 10px;'>事故信息</font>");
	$("#right2").append("<div id='accidentTable' style='width: 100%;height: 74%;'></div>");
	$("#accidentTable").append("<table id='accidenttable' style='width:100%;height:100%;border-collapse:collapse;'border='1' bordercolor='#d1d1d1' rules=rows></table>");
	$("#accidenttable").append("<tr id='accidenttr1'></tr>");
	$("#accidenttable").append("<tr id='accidenttr2'></tr>");
	if(data.sgms.length > 60){
		$("#accidenttr1").append("<td style='width:8%;' class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故时间</strong></td>");
		$("#accidenttr1").append("<td style='width:15%;'>"+data.sgsj+"</td>");
		$("#accidenttr1").append("<td style='width:8%;'class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故地点</strong></td>");
		$("#accidenttr1").append("<td style='width:69%;'>"+sgwzmc+"</td>");
		$("#accidenttr2").append("<td style='width:8%;'class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故责任</strong></td>");
		$("#accidenttr2").append("<td style='width:15%;'>"+data.sgzr+"</td>");
		$("#accidenttr2").append("<td style='width:8%;'class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故描述</strong></td>");
		$("#accidenttr2").append("<td style='width:69%;'>"+data.sgms+"</td>");
	}else{
		$("#accidenttr1").append("<td style='width:8%;' class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故时间</strong></td>");
		$("#accidenttr1").append("<td style='width:25%;'>"+data.sgsj+"</td>");
		$("#accidenttr1").append("<td style='width:8%;'class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故地点</strong></td>");
		$("#accidenttr1").append("<td style='width:59%;'>"+sgwzmc+"</td>");
		$("#accidenttr2").append("<td style='width:8%;'class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故责任</strong></td>");
		$("#accidenttr2").append("<td style='width:25%;'>"+data.sgzr+"</td>");
		$("#accidenttr2").append("<td style='width:8%;'class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>事故描述</strong></td>");
		$("#accidenttr2").append("<td style='width:59%;'>"+data.sgms+"</td>");
	}
	//驾驶员信息
	if(data.bDriverInfos != null && data.bDriverInfos.length > 0){
		$.each(data.bDriverInfos, function (i, items) {
			$("#mainDiv2").append("<div id='driverDiv"+i+"' style='height: 30%;width:99.7%;border: 1px solid #d1d1d1;'></div>");
			$("#driverDiv"+i).append("<div id='driverdiv"+i+"' style='width: 100%;height: 30%;'></div>");
			$("#driverdiv"+i).append("<div id='driverdiv1"+i+"' style='padding-left:20px;margin-top: 10px;'></div>");
			$("#driverdiv1"+i).append("<img style='float: left;' src='"+rootPath+"/static/img/common/driver.png'/>");
			if(items.name == ""){
				$("#driverdiv1"+i).append("<font color='#41D4FF' style='float: left;padding-left: 10px;'>第"+(i+1)+"位驾驶员信息</font>");
			}else{
				$("#driverdiv1"+i).append("<font color='#41D4FF' style='float: left;padding-left: 10px;'>"+items.name+"驾驶员信息</font>");
			}
			$("#driverDiv"+i).append("<div id='driver"+i+"' style='width: 100%;height: 62%;'></div>");
			$("#driver"+i).append("<table id='driverTable"+i+"' style='width:100%;height:100%;border-collapse:collapse;'border='1' bordercolor='#d1d1d1' rules=rows></table>");
			$("#driverTable"+i).append("<tr id='driverTr"+i+"'></tr>");
			$("#driverTr"+i).append("<td style='width:8%;' class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>姓名</strong></td>");
			$("#driverTr"+i).append("<td style='width:10%;'>"+items.name+"</td>");
			$("#driverTr"+i).append("<td style='width:8%;' class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>号牌号码</strong></td>");
			$("#driverTr"+i).append("<td style='width:10%;'>"+items.hphm+"</td>");
//			$("#driverTable"+i).append("<tr id='drivertr"+i+"'></tr>");
			$("#driverTr"+i).append("<td style='width:8%;' class='znjt-search-label znjt-color-background-5 znjt-text-align-center'><strong>联系方式</strong></td>");
			$("#driverTr"+i).append("<td style='width:10%;'>"+items.contact+"</td>");
			$("#driverTr"+i).append("<td style='width:46%;'></td>");
		});
	}
	//现场照片
	var imagePath = data.imagePath+"/"+data.sgsj.substring(0,10)+"/"+data.wxid+"/";
	if(data.liveImage != ""){
		$("#mainDiv2").append("<div id='imageDiv' style='height: 50%;width:99.7%;border: 1px solid #d1d1d1;'></div>");
		$("#imageDiv").append("<div id='imageFirst'style='width: 100%;height: 20%;'></div>");
		$("#imageFirst").append("<div id='imageTwo'style='padding-left:20px;margin-top: 10px;'></div>");
		$("#imageTwo").append("<img style='float: left;' src='"+rootPath+"/static/img/common/site.png'/>");
		$("#imageTwo").append("<font color='#41D4FF' style='float: left;padding-left: 10px;'>现场照片</font>");
		$("#imageDiv").append("<div id='imageFirst1'style='width: 100%;height: 73%;'></div>");
		$("#imageFirst1").append("<table id='imageTable' style='width:100%;height:100%;border-collapse:collapse;' border='1' bordercolor='#d1d1d1' rules=rows></table>");
		var str = data.liveImage.split(",");
		if(str != null && str.length > 0){
				for(var i = 0; i < str.length; i ++){
					if(i >= 5){//最多十张图片---一行是5张图片（2行）
						$("#imageDiv").height("85%");
						$("#imageFirst").height("10%");
						$("#imageFirst1").height("87%");
						$("#imageTable").append("<tr id='imageTr2'></tr>");
						$("#imageTr2").append("<td style='width:20%;text-align:center;'><img style='width:100px;height:100px;cursor:pointer'onclick='onClickImage(this,"+JSON.stringify(imagePath+str[i])+")' src='"+(imagePath+str[i])+"'/></td>");
					}else{
						$("#imageTable").append("<tr id='imageTr1'></tr>");
						$("#imageTr1").append("<td style='width:20%;text-align:center;'><img style='width:100px;height:100px;cursor:pointer'onclick='onClickImage(this,"+JSON.stringify(imagePath+str[i])+")' src='"+(imagePath+str[i])+"'/></td>");
					}
				}
		}
	}
	//现场录音
	if(data.liveVoice != ""){
		$("#mainDiv2").append("<div id='voiceDiv' style='height: 50%;width:99.7%;border: 1px solid #d1d1d1;'></div>");
		$("#voiceDiv").append("<div id='voiceFirst'style='width: 100%;height: 15%;'></div>");
		$("#voiceFirst").append("<div id='voiceTwo'style='padding-left:20px;margin-top: 10px;'></div>");
		$("#voiceTwo").append("<img style='float: left;' src='"+rootPath+"/static/img/common/voice.png'/>");
		$("#voiceTwo").append("<font color='#41D4FF' style='float: left;padding-left: 10px;'>现场录音</font>");
		$("#voiceDiv").append("<div id='voiceFirst1'style='width: 100%;height: 80%;'></div>");
		$("#voiceFirst1").append("<table id='voiceTable' style='width:100%;height:100%;border-collapse:collapse;' border='1' bordercolor='#d1d1d1' rules=rows></table>");
		var str = data.liveVoice.split(",");
		if(str != null && str.length > 0){
			for(var i = 0; i < str.length; i ++){
				if(i >= 2){
					$("#voiceDiv").height("85%");
					$("#voiceFirst").height("10%");
					$("#voiceFirst1").height("87%");
					$("#voiceTable").append("<tr id='voiceTr2'></tr>");
					$("#voiceTr2").append("<td style='width:30%;text-align:center;'><audio src='"+(imagePath+str[i])+"' preload='auto' controls></audio></td>");
				}else{
					$("#voiceTable").append("<tr id='voiceTr1'></tr>");
					$("#voiceTr1").append("<td style='width:30%;text-align:center;'><audio src='"+(imagePath+str[i])+"' preload='auto' controls></audio></td>");
				}
			}
		}
	}
}

