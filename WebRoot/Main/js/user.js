function login() {
	var host = window.location.host;
	if (window.location.pathname.indexOf("Dragon") > 0) {
		window.location.href = "http://" + host + "/Dragon/login";
	} else {
		window.location.href = "http://" + host + "/login";
	}

}

function register() {
	var host = window.location.host;
	if (window.location.pathname.indexOf("Dragon") > 0) {
		window.location.href = "http://" + host + "/Dragon/register";
	} else {
		window.location.href = "http://" + host + "/register";
	}
}

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

function register_check() {
	var params = $("form").serialize();
	$.ajax({
		type : "POST",
		async : true,
		url : "register",
		data : params,
		dataType : "text",
		success : function(data) {
			layer.msg("注册成功！" + data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("注册失败！");
			return false;
		}
	});
}