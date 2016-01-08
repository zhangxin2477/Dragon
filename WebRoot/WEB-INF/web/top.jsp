<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> <img alt="Brand"
				src="${path}/WEB-RES/image/dragon_logo.png"
				style='height: 30px; padding-left: 1rem'>
			</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">首页<span class="sr-only">(current)</span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">父级菜单<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">子菜单</a></li>
						<li><a href="#">子菜单</a></li>
						<li><a href="#">子菜单</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">子菜单</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">子菜单</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group input-group">
					<input type="text" class="form-control" placeholder="搜索">
					<span class="input-group-btn">
						<button class="btn btn-info" type="button">搜索</button>
					</span>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="javascript:register()">注册</a></li>
				<li><a href="javascript:login()">登录</a></li>
			</ul>
		</div>
	</div>
</nav>