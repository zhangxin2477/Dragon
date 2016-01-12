<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<c:import url="/WEB-INF/web/common/common.jsp" />

<link href="${path}/WEB-CSS/main.css" rel="stylesheet" />
<link href="${path}/WEB-CSS/offcanvas.css" rel="stylesheet" />

</head>

<body>
	<c:import url="/WEB-INF/web/common/top.jsp" />

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">更多信息</button>
				</p>

				<div class="jumbotron">最新内容</div>

				<div class="list-group">
					<c:forEach var="s" begin="1" end="20">
						<div class="list-group-item">
							<span class="badge">0</span>
							<table>
								<thead>
									<tr>
										<td><a href="#"><img
												class="img-circle image_size_small" alt="Brand"
												src="${path}/WEB-RES/image/default.png" /></a></td>
										<td style="padding-left:15px;"><a href="content"
											class="list-group-item-heading" style="font-size:20px;">${s}0000000</a>
											<ol class="list-group-item-text breadcrumb"
												style="background-color:#FFFFFF">
												<li><a href="#">用户</a></li>
												<li>0人关注</li>
												<li>0人浏览</li>
												<li>时间</li>
											</ol></td>
									</tr>
								</thead>
							</table>
						</div>
					</c:forEach>
				</div>

				<div class="page" style="text-align:center;"></div>

			</div>

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				style="margin-top:15px;margin-bottom:15px;">
				<div class="list-group">
					<a href="publish" class="list-group-item active text-center">发表</a>
				</div>

				<div class="panel panel-primary">
					<div class="panel-heading">用户</div>
					<div class="panel-body">
						<div>用户：XX</div>
						<div>等级：XX</div>
					</div>
				</div>

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
							src="${path}/WEB-RES/image/tiaoma.png" />
					</div>
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
			</div>

		</div>
	</div>

	<script src="${path}/WEB-JS/main.js"></script>
	<c:import url="/WEB-INF/web/common/bottom.jsp"></c:import>
</body>
</html>
