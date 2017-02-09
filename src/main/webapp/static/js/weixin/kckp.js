/**
 * 快处快赔流程
 * @author wangqiang
 * @description
 */
$(function(){
	
	$.ajax({
		type: "post",
		url: "https://api.weixin.qq.com/sns/oauth2/access_token",
		data: {
			appid: $("#wx_appid").val(),
			secret: $("#wx_appsecret").val(),
			code: $("#wx_code").val(),
			grant_type: "authorization_code"
		},
		async: false,
		success: function(rst){
			alert(rst);
		},
		error: function(e1,e2,e3){
			alert(e1);
			alert(e2);
		}
	});
});