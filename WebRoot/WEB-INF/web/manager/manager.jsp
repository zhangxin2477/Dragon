<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!DOCTYPE html>
<html>
<head>
<title>管理</title>
<c:import url="/WEB-INF/web/common/common.jsp" />

<link href="${path}/WEB-CSS/content.css" rel="stylesheet" />
<link href="${path}/WEB-CSS/offcanvas.css" rel="stylesheet" />

</head>

<body>
	<c:import url="/WEB-INF/web/common/top.jsp" />

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
							<c:choose>
								<c:when test="${param.menu=='1'}">
									<a href="?menu=1" class="list-group-item active">主题管理</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=1" class="list-group-item">主题管理</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${param.menu=='2'}">
									<a href="?menu=2" class="list-group-item active">父菜单管理</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=2" class="list-group-item">父菜单管理</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${param.menu=='3'}">
									<a href="?menu=3" class="list-group-item active">子菜单管理</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=3" class="list-group-item">子菜单管理</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${param.menu=='4'}">
									<a href="?menu=4" class="list-group-item active">用户管理</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=4" class="list-group-item">用户管理</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">基本信息</h3>
					</div>
					<div class="panel-body" style="padding:0px;">
						<div class="list-group" style="margin-bottom:0px;">
							<c:choose>
								<c:when test="${param.menu=='5'}">
									<a href="?menu=5" class="list-group-item active">用户信息</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=5" class="list-group-item">用户信息</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${param.menu=='6'}">
									<a href="?menu=6" class="list-group-item active">内容管理</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=6" class="list-group-item">内容管理</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${param.menu=='7'}">
									<a href="?menu=7" class="list-group-item active">评论管理</a>
								</c:when>
								<c:otherwise>
									<a href="?menu=7" class="list-group-item">评论管理</a>
								</c:otherwise>
							</c:choose>
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
					<c:import url="/WEB-INF/web/manager/directory_par.jsp"></c:import>
				</c:if>
				<c:if test="${param.menu == '3'}">
					<c:import url="/WEB-INF/web/manager/directory_sub.jsp"></c:import>
				</c:if>
				<c:if test="${param.menu == '4'}">
					<c:import url="/WEB-INF/web/manager/user_list.jsp"></c:import>
				</c:if>
				<c:if test="${param.menu == '5' }">
				<c:import url="/WEB-INF/web/user_info.jsp"></c:import>
				</c:if>
				<c:if test="${param.menu == '6'}">
					<c:import url="/WEB-INF/web/manager/body.jsp"></c:import>
				</c:if>
				<c:if test="${param.menu == '7' }">
				<c:import url="/WEB-INF/web/manager/comment.jsp"></c:import>
				</c:if>
			</div>
		</div>
	</div>

	<script src="${path}/WEB-JS/manager/manager.js"></script>
	<c:import url="/WEB-INF/web/common/bottom.jsp"></c:import>
</body>
</html>
