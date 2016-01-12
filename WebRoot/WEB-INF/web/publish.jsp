<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!DOCTYPE html>
<html>
<head>
<title>发布内容</title>
<c:import url="/WEB-INF/web/common/common.jsp" />
<link href="${path}/WEB-CSS/publish.css" rel="stylesheet" />
<script src="${path}/WEB-JS/publish.js" type="text/javascript"></script>
</head>

<body>

	<c:import url="/WEB-INF/web/common/top.jsp" />

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
						type="text" class="form-control" placeholder="标题"
						aria-describedby="sizing-addon1">
				</div>
				<br>
				<script type="text/plain" id="editor"
					style="width:100%;height:100%;"></script>
				<div class="radio">
					<label> <input type="radio" name="blankRadio"
						id="blankRadio1" value="option1" checked="true" aria-label="公开" />公开
					</label> <label> <input type="radio" name="blankRadio"
						id="blankRadio2" value="option2" aria-label="私有" />私有
					</label>
				</div>
				<button type="button" class="btn btn-primary">发表帖子</button>
				<button type="button" class="btn btn-info">保存草稿</button>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/web/common/bottom.jsp" />
</body>
</html>
