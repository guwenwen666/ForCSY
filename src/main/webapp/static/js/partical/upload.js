//var $filequeue, $filelist;

var file_index = 0;

$(document).ready(function() {
	$filequeue = $(".demo .filelist.queue");
	$filelist = $(".demo .filelist.complete");

	$(".uploadForm .dropped").dropper({
		action : getSpringPath()+"/common/upload/ABC.ms",
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
	$.each(files, function(index){
		var curFile = files[index];
		debugger;
	});
	
//	console.log(e, files);
//	console.log("start");
//	var html = '';
//
//	for (var i = 0; i < files.length; i++) {
//		html += '<li data-index="' + files[i].index + '"><span class="file">'
//				+ files[i].name
//				+ '</span><span class="progress">Queued</span></li>';
//	}
//
//	$filequeue.append(html);
}

function onComplete(e) {
//	console.log("Complete");
}

function onFileStart(e, file) {
//	console.log(e,file);
//	console.log("File Start");
//
//	$filequeue.find("li[data-index=" + file.index + "]").find(".progress")
//			.text("0%");
}

function onFileProgress(e, file, percent) {
//	console.log("File Progress");
//
//	$filequeue.find("li[data-index=" + file.index + "]").find(".progress")
//			.text(percent + "%");
}

function onFileComplete(e, file, response) {
//	console.log("File Complete");
//	if (response.trim() === "" || response.toLowerCase().indexOf("error") > -1) {
//		$filequeue.find("li[data-index=" + file.index + "]").addClass("error")
//				.find(".progress").text(response.trim());
//	} else {
//		var $target = $filequeue.find("li[data-index=" + file.index + "]");
//		$target.find(".file").text(file.name);
//		$target.find(".progress").remove();
//		$target.appendTo($filelist);
//	}
}

function onFileError(e, file, error) {
//	console.log("File Error");
//	$filequeue.find("li[data-index=" + file.index + "]").addClass("error").find(".progress").text("Error: " + error);
}