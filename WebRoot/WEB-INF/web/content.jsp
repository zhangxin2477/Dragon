<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!DOCTYPE html>
<html>
<head>
<title>详细内容</title>
<c:import url="/WEB-INF/web/common/common.jsp" />

<link href="${path}/WEB-CSS/content.css" rel="stylesheet" />
<link href="${path}/WEB-CSS/offcanvas.css" rel="stylesheet" />

</head>

<body>
	<c:import url="/WEB-INF/web/common/top.jsp" />

	<div class="container">
		<ol class="breadcrumb">
			<li><a>首页</a></li>
			<li>XX</li>
			<li class="active">XX</li>
		</ol>
		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">更多信息</button>
				</p>

				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">主题</div>
					<div class="panel-body">内容</div>
					<!-- List group -->
					<ul class="list-group">
						<c:forEach var="s" begin="1" end="10">
							<li class="list-group-item">回复</li>
						</c:forEach>
					</ul>
				</div>
				<div class="page" style="text-align:center;"></div>
			</div>

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				style="margin-bottom:15px;">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">广告</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">信息</h3>
					</div>
					<div class="panel-body">
						<img class="img-thumbnail" alt=""
							src="${path}/WEB-RES/image/my.png" />
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">信息</h3>
					</div>
					<div class="panel-body">
						<img class="img-thumbnail" alt=""
							src="${path}/WEB-RES/image/tiaoma.png" />
					</div>
				</div>
			</div>

		</div>
	</div>

	<script src="${path}/WEB-JS/content.js"></script>
	<c:import url="/WEB-INF/web/common/bottom.jsp"></c:import>
</body>
</html>
