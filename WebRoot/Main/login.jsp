<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<c:import url="/common.jsp"></c:import>
<link href="<%=basePath%>Main/css/login.css" rel="stylesheet" />
<script src="<%=basePath%>Main/js/user.js"></script>
</head>

<body>
	<c:import url="/Main/top.jsp"></c:import>
	<br>
	<br>
	<br>
	<br>
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading text-center">用户登录</div>
			<div class="panel-body">
				<form class="bs-example bs-example-form" role="form" >
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">用户名：</span>
						<input id="nametxt" type="text" class="form-control" placeholder="Username"
							name="user.account" />
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon2">密&nbsp;&nbsp;&nbsp;码：</span>
						<input id="pwtxt" type="password" class="form-control" placeholder="Password"
							name="user.password" />
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							记住我
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="button"
						onclick="javascript:login_check()">登录</button>
				</form>
			</div>
		</div>
	</div>
	<c:import url="/Main/bottom.jsp"></c:import>
</body>
</html>
