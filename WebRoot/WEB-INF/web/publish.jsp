<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发布内容</title>
<c:import url="/WEB-INF/web/common/common.jsp" />
<!-- 百度富文本 -->
<link
	href="${path}/WEB-PLUGIN/editor/themes/default/css/ueditor.min.css"
	rel="stylesheet">
<script src="${path}/WEB-PLUGIN/editor/ueditor.config.js"></script>
<script src="${path}/WEB-PLUGIN/editor/ueditor.all.js"></script>

<link href="${path}/WEB-CSS/publish.css" rel="stylesheet"></link>
</head>
<body>
	<c:import url="/WEB-INF/web/common/top.jsp"></c:import>
	<div class="container">
		<ol class="breadcrumb">
			<li><a>首页</a></li>
			<li>XX</li>
			<li class="active">XX</li>
		</ol>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2 class="panel-title">发表帖子</h2>
			</div>
			<div class="panel-body">

				<div class="input-group">
					<span class="input-group-addon" id="sizing-addon1"><b>标题</b></span><input
						type="text" id="id_title" class="form-control" placeholder="标题">
				</div>
				<script type="text/plain" id="editor"
					style="width:100%;height:100%;"></script>
				<div class="radio">
					<label> <input type="radio" name="blankRadio"
						id="id_limit1" value="0" checked="checked" aria-label="公开" />公开
					</label> <label> <input type="radio" name="blankRadio"
						id="id_limit2" value="1" aria-label="私有" />私有
					</label>
				</div>
				<button type="button" class="btn btn-primary" onclick="publishArticle()">发表帖子</button>
			</div>
		</div>
	</div>
	<script src="${path}/WEB-JS/publish.js" type="text/javascript"></script>
	<c:import url="/WEB-INF/web/common/bottom.jsp" />
</body>
</html>
