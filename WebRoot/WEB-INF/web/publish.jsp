<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<!DOCTYPE html>
<html>
<head>
<title>发布内容</title>
<c:import url="/WEB-INF/web/common.jsp" />
<link href="${path}/WEB-CSS/publish.css" rel="stylesheet" />
<script src="${path}/WEB-JS/publish.js" type="text/javascript"></script>
</head>

<body>

	<c:import url="/WEB-INF/web/top.jsp" />

	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h2 class="panel-title">发表帖子</h2>
			</div>
			<div class="panel-body">
			<script type="text/plain" id="editor" style="width:100%;height:100%;"></script>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/web/bottom.jsp" />
</body>
</html>
