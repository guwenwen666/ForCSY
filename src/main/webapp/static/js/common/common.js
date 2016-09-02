var rootPath = function(){
	return '/ForCsy';
}();

$(function(){
	
	//帐号组件的初始化
	accountInit();
	
	
	function accountInit(){
		if(!!$("#user-name-top")[0]){
			var user_name_topPopover = function(){
				var $listGroup = $("#user-name-top").find(".list-group");
				$listGroup.removeClass("sr-only");
				var $html = $listGroup[0].outerHTML;
				$listGroup.remove();
				return $html;
			}();
			
			$("#user-name-top").popover({
				container: ".head_wrapper",
				html: true,
				content: user_name_topPopover,
				placement: "bottom",
				trigger: "click"
			});
		}
	}
});