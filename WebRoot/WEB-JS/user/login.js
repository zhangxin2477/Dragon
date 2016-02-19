function login_check() {
	var params = $("form").serialize();
	$.ajax({
		type : "GET",
		async : true,
		url : "checkuser",
		data : params,
		dataType : "json",
		success : function(data) {
			if (data.result == "success") {
				layer.msg("登录成功！");
				window.location = "main";
			} else {
				layer.msg("登录失败！");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("登录失败！");
			return false;
		}
	});
}