<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!DOCTYPE html>
<html>
<head>
<title>管理</title>
<c:import url="/WEB-INF/web/common.jsp" />

<link href="${path}/WEB-CSS/content.css" rel="stylesheet" />
<link href="${path}/WEB-CSS/offcanvas.css" rel="stylesheet" />

</head>

<body>
	<c:import url="/WEB-INF/web/top.jsp" />

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-left">
			<!-- 菜单 -->
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				style="margin-bottom:15px;">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">平台信息</h3>
					</div>
					<div class="panel-body" style="padding:0px;">
						<div class="list-group" style="margin-bottom:0px;">
							<a href="#" class="list-group-item active">主题管理</a> <a href="#"
								class="list-group-item">菜单管理</a> <a href="#"
								class="list-group-item">用户管理</a>
						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">基本信息</h3>
					</div>
					<div class="panel-body" style="padding:0px;">
						<div class="list-group" style="margin-bottom:0px;">
							<a href="#" class="list-group-item active">用户管理</a> <a href="#"
								class="list-group-item">内容管理</a> <a href="#"
								class="list-group-item">评论管理</a>
						</div>
					</div>
				</div>
			</div>
			<!-- 内容 -->
			<div class="col-xs-12 col-sm-9">
				<p class="pull-left visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">菜单</button>
				</p>

				<div class="page-header">
					<h1>广告(●'◡'●)</h1>
				</div>

				<c:if test="${param.menu == '1'}">
					<c:import url="/WEB-INF/web/manager/theme.jsp"></c:import>
				</c:if>
				<c:if test="${param.menu == '2'}">
					<c:import url="/WEB-INF/web/manager/directory.jsp"></c:import>
				</c:if>

			</div>
		</div>
	</div>

	<script src="${path}/WEB-JS/manager/manager.js"></script>
	<c:import url="/WEB-INF/web/bottom.jsp"></c:import>
</body>
</html>
