/**
 * 快处快赔流程
 * @author wangqiang
 * @description
 */
$(function(){
	
	var option = {
        title: 'WeUI, 为微信 Web 服务量身设计',
        desc: 'WeUI, 为微信 Web 服务量身设计',
        link: "https://weui.io",
        imgUrl: 'https://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLA16apETUPXh9Q5GLpSic7lGuiaic0jqMt4UY8P4KHSBpEWgM7uMlbxxnVR7596b3NPjUfwg7cFbfCtA/0'
    };
	
	$.getJSON(rootPath+"/wx/sign?url=" + encodeURIComponent(location.href.split('#')[0]), function (res) {
        wx.config({
            debug: true,
            appId: res.appid,
            timestamp: res.timestamp,
            nonceStr: res.nonceStr,
            signature: res.signature,
            jsApiList: [
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo',
                'onMenuShareQZone',
                // 'setNavigationBarColor',
                'setBounceBackground'
            ]
        });
        wx.ready(function(rst){
//        	wx.invoke('setNavigationBarColor', {
////        		color: '#F8F8F8'
//        		color: '#ff0000'
//        	});
//            wx.invoke('setBounceBackground', {
//                'backgroundColor': '#F8F8F8',
//                'footerBounceColor' : '#F8F8F8'
//            });
//            wx.onMenuShareTimeline(option);
//            wx.onMenuShareQQ(option);
//            wx.onMenuShareAppMessage({
//                title: 'WeUI',
//                desc: '为微信 Web 服务量身设计',
//                link: location.href,
//                imgUrl: 'https://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLA16apETUPXh9Q5GLpSic7lGuiaic0jqMt4UY8P4KHSBpEWgM7uMlbxxnVR7596b3NPjUfwg7cFbfCtA/0'
//            });
        });
    });
});