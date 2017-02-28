$(function() {
	// 初始化执行一些函数
	init();

	//表单验证
	formValidate();
	
	$('#fullpage').fullpage({
		'verticalCentered' : false,
		'css3' : true,
		//'anchors' : [ "head",'loginWindow', 'pic2', 'pic3', 'pic4' ],
		'navigation' : true,
		'loopBottom' : false,
		'navigationPosition' : 'right',
		//'navigationTooltips' : [ 'head','loginWindow', 'pic2', 'pic3', 'pic4' ],
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
	
	$("#account").popover({
		selector: "#account",
		placement: "top",
		content: "account"
	});
	
	$("#password").popover({
		selector: "#password",
		placement: "top",
		content: "password"
	});
	
	$("#securityCode").popover({
		selector: "#securityCode",
		placement: "top",
		content: "securityCode"
	});
	
	var resetPopoverContext = function(dom,msg){
		dom.popover("show");
		dom.nextAll(".popover").find(".popover-content").text(msg);
	};
	
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
								resetPopoverContext(jQuerydom,"帐号不可为空!");
								return false;
							}
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
								resetPopoverContext(jQuerydom,"密码不可为空!");
								return false;
							}
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
								resetPopoverContext(jQuerydom,"输入验证码!");
								return false;
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
				url: rootPath+"/login/securityCodeCheck",
				data: {
					securityCode: $("#securityCode").val()
				},
				async: false,
				success: function(rst){
					if(rst=="true"){
						isTure = true;
					}else{
						resetPopoverContext($("#securityCode"),"验证码不正确!");
						$("#securityCodeImg").parents("a").click();
					}
				}
			});
			//验证码不正确
			if(!isTure)
				return false;
		}
		
		$.ajax({
			type: "post",
			url: rootPath+"/login/accountLogin",
			data: $(".loginForm").serializeArray(),
			dataType: "json",
			success: function(rst, textStatus){
				if(!!rst.errorMsg){
					resetPopoverContext($("#account"), rst.errorMsg);
					if(rst.securityCode){
						$("#securityCodeDiv").removeClass("hidden");
						$("#securityCodeImg").parents("a").click();
					}
					return;
				}
//				window.open(rootPath+"/"+rst.account_id+"/cZone","_self");
				window.open(rootPath+"/lose?param=1","_self");
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				resetPopoverContext($("#account"), "登录异常!"+ XMLHttpRequest.status);
			}
		});
		e.preventDefault();
		return false;
	});	
}