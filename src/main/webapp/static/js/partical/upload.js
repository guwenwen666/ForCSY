/**
 * 通用上传组件
 * @author wangqiang
 * @description
 * 		通用上传组件用于快速创造一个上传文件窗口
 * 		使用要求:
 * 		1.上传文件的类型, 一定要通过后台审核（在后台配置不同上传文件类型的存储路径）。
 *  
 */
$(document).ready(function() {
	$(".uploadForm .dropped").dropper({
		label : "拖拽或点击选择文件进行上传",
		action : getSpringPath()+"/common/upload/ABC.ms",
		maxQueue : 2,
		maxSize : 300*1024*1024
	}).on("start.dropper", onStart)
	.on("complete.dropper", onComplete)
	.on("fileStart.dropper", onFileStart)
	.on("fileProgress.dropper", onFileProgress)
	.on("fileComplete.dropper", onFileComplete)
	.on("fileError.dropper", onFileError);

	$(window).one("pronto.load", function() {
		$(".demo .dropped").dropper("destroy").off(".dropper");
	});
});

function onStart(e, files) {
	
	var getFileSize = function(fireSize){
		if(fireSize < 1024){
			fireSize = fireSize + "B";
		}else if(fireSize < 1024*1024){
			fireSize = (fireSize/1024).toFixed(2) + "KB";
		}else if(fireSize < 1024*1024*1024){
			fireSize = (fireSize/1024/1024).toFixed(2) + "M";
		}else if(fireSize < 1024*1024*1024*1024){
			fireSize = (fireSize/1024/1024/1024).toFixed(2) + "G";
		}
		return fireSize;
	};
	
	$.each(files, function(index){
		var curFile = files[index];
		var $tr = $("<tr></tr>");
		var $link = $("<a href='javascript:;'>").text(curFile.name).attr("title",curFile.name);
		$tr.append($("<td class='fileIndex'>").append(curFile.index+1));
		$tr.append($("<td class='fileLink'>").append($link));
		$tr.append($("<td class='fileSize'>").append(getFileSize(curFile.size)));
		$tr.append($("<td class='fileStatue'>").append("等待上传"));
		//将td存储在file对象中,方便后续的操作
		curFile.tr = $tr;
		console.log(curFile);
		$(".uploadList").append($tr);
	});
}

function onComplete(e) {
	console.log("Complete");
}

function onFileStart(e, file){
	var $progress = $("<div class='progress' style='margin-bottom: 0px;'>" +
				"<div class='progress-bar progress-bar-success progress-bar-striped active' " +
				"role='progressbar' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100' " +
				"style='width: 0%;min-width: 2em;'>" +
					"0%" +
				"</div>" +
			"</div>");
	file.tr.find(".fileStatue").empty().html($progress);
}

function onFileProgress(e, file, percent) {
	var $progressBar = file.tr.find(".fileStatue .progress-bar");
	
	$progressBar.attr("aria-valuenow", percent);
	$progressBar.css("width", percent+"%");
	$progressBar.html(percent+"%");
}

function onFileComplete(e, file, rst) {
	var errorFuc = function(errorMsg){
		var $errorTip = $("<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'>");
		var $errorCnt = $("<span>").text(errorMsg);
		var $errorMsg = $("<span class='text-danger'>").append($errorTip).append($errorCnt);
		file.tr.addClass("danger");
		file.tr.find(".fileStatue").html($errorMsg);
	};
	if(rst.error){
		errorFuc(rst.error);
	}else if(rst.result[file.name] != "success"){
		errorFuc(rst.result[file.name]);
	}else{
		var $successTip = $("<span class='glyphicon glyphicon-ok-sign' aria-hidden='true'>");
		var $successCnt = $("<span>").text("上传成功!");
		var $successMsg = $("<span class='text-success'>").append($successTip).append($successCnt);
		file.tr.addClass("success");
		file.tr.find(".fileStatue").html($successMsg);
	}
}

function onFileError(e, file, error) {
	var $errorMsg = $("<p class='text-danger'>").html(error);
	file.tr.find(".fileStatue").html($errorMsg);
}