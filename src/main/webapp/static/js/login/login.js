$(function() {
	// 初始化执行一些函数
	init();

	//表单验证
	formValidate();
	
	$('#fullpage').fullpage({
		'verticalCentered' : false,
		'css3' : true,
		anchors : [ 'loginWindow', 'pic2', 'pic3', 'pic4' ],
		'navigation' : true,
		'loopBottom' : true,
		'navigationPosition' : 'right',
		'navigationTooltips' : [ 'loginWindow', 'pic2', 'pic3', 'pic4' ],
	});
});

function init() {
	// 手机注册按钮 暂不可用
	$(".safeLogin").tooltip({
		title : "扫码登录方式暂未提供",
		placement : "right"
	});

	// disabled标记的内容不允许点击
	$(".disabled").bind('click mousedown', function(e) {
		e.preventDefault();
		return false;
	});
	
	// 解决firefox下input有默认值的问题
	$(".loginForm")[0].reset();
	
	$("#securityCodeImg").parents("a").click(function(){
		var imgUrl = $("#securityCodeImg").attr("src");
		var index = imgUrl.lastIndexOf("?");
		if(index > -1){
			imgUrl.substring(0, index);
		}
		$("#securityCodeImg").attr("src",imgUrl+"?a="+Math.random());
	});
	
	$("#account,#password,#securityCode").blur(function(){
		$(this).popover("hide");
	});
}

function formValidate() {
	$('.loginForm').bootstrapValidator({
		message : '验证未通过!',
		feedbackIcons: { 
			valid: 'glyphicon glyphicon-ok', 
			invalid: 'glyphicon glyphicon-remove', 
			validating: 'glyphicon glyphicon-refresh' 
		},
		fields : {
			account:{
				validators:{
					callback:{
						message:'<div></div>',
						callback: function(value,validate,jQuerydom){
							if(!value){
								jQuerydom.popover({
									selector: "#account",
									content: "帐号不可为空!",
									placement: "top" 
								}).popover("show");
								return false;
							}
							jQuerydom.popover("destroy");
							return true;
						}
					}
				}
			},
			password:{
				validators:{
					callback:{
						message:'<div></div>',
						callback: function(value,validate,jQuerydom){
							if(!value){
								jQuerydom.popover({
									selector: "#password",
									content: "密码不可为空!",
									placement: "top" 
								}).popover("show");
								return false;
							}
							jQuerydom.popover("destroy");
							return true;
						}
					}
				}
			},
			securityCode:{
				validators:{
					callback:{
						message:'<div></div>',
						callback: function(value,validate,jQuerydom){
							if($("#securityCodeDiv").hasClass("hidden")){
								return true;
							}
							if(!value){
								jQuerydom.popover({
									selector: "#securityCode",
									content: "验证码不可为空!",
									placement: "top" 
								}).popover("show");
								return false;
							}else{
								jQuerydom.popover("destroy");
							}
							return true;
						}
					}
				}
			}
		}
	}).on("success.form.bv",function(e){
		if(!$("#securityCodeDiv").hasClass("hidden")){
			var isTure = false;
			$.ajax({
				type: "post",
				url: getSpringPath()+"/login/securityCodeCheck",
				data: {
					securityCode: $("#securityCode").val()
				},
				async: false,
				success: function(rst){
					if(rst=="true"){
						isTure = true;
					}else{
						$("#securityCode").popover({
							selector: "#password",
							content: "验证码不正确!",
							placement: "top" 
						}).popover("show");
						$("#securityCodeImg").parents("a").click();
					}
				}
			});
			if(!isTure){
				return false;
			}
			$("#securityCode").popover("destroy");
		}
		
		$.ajax({
			type: "post",
			url: getSpringPath()+"/login/accountLogin",
			data: $(".loginForm").serializeArray(),
			dataType: "json",
			success: function(rst, textStatus){
				if(!!rst.errorMsg){
					$("#account").popover({
						selector: "#account",
						content: rst.errorMsg,
						placement: "top"
						}).popover("show");
					if(rst.securityCode){
						$("#securityCodeDiv").removeClass("hidden");
						$("#securityCodeImg").parents("a").click();
					}
					return;
				}
				window.open(getSpringPath()+"/"+rst.account+"/index","_self");
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$("#account").popover({
					selector: "#account",
					content:"登录异常!"+ XMLHttpRequest.status + ":" + XMLHttpRequest.statusText,
					placement: "top"
					}).popover("show");
			}
		});
		e.preventDefault();
		return false;
	});	
}