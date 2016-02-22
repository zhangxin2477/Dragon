/**
 * 
 */
$(document).ready(function() {
	var ue = UE.getEditor('editor', {
		initialFrameHeight : 400
	});
	console.info("手下留情！");
});

function publishArticle() {
	var title = document.getElementById("id_title").value;
	var content = UE.getEditor('editor').getContent();
	var classify_id = 13;
	var limit = null;
	if (document.getElementById("id_limit1").checked) {
		limit = 0;
	} else {
		limit = 1;
	}
	if (title != null && content != null && classify_id != null
			&& limit != null) {
		var result = $.ajax({
			type : "POST",
			url : "addarticle",
			data : "article.title=" + title + "&article.content=" + content
					+ "&article.classifyId=" + classify_id + "&article.limit="
					+ limit,
			async : false
		}).responseJSON;
		if (result == "success") {
			layer.msg("发布成功！");
			window.location = "main";
		} else if (result == "login_out") {
			window.location = "login";
		} else {
			layer.msg("发布失败！");
		}
	}
}