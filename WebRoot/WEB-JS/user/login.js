function login_check() {
	var params = $("form").serialize();
	$.ajax({
		type : "GET",
		async : true,
		url : "login",
		data : params,
		dataType : "json",
		success : function(data) {
			layer.msg("登录成功！" + data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("登录失败！");
			return false;
		}
	});
}