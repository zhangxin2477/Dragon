function register_check() {
	var params = $("form").serialize();
	var result = $.ajax({
		type : "POST",
		async : false,
		url : "register",
		data : params
	}).responseJSON;
	if (result == "success") {
		layer.msg("注册成功！");
		window.location = "login";
	} else {
		layer.msg("注册失败！");
	}
}