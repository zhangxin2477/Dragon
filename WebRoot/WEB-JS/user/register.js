function register_check() {
	var params = $("form").serialize();
	$.ajax({
		type : "POST",
		async : true,
		url : "register",
		data : params,
		dataType : "json",
		success : function(data) {
			layer.msg("注册成功！" + data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("注册失败！");
			return false;
		}
	});
}