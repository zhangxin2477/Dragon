<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<link rel="icon" href="${path}/WEB-RES/image/dragon_logo.ico"
	type="image/x-icon">
<link rel="shortcut icon" href="${path}/WEB-RES/image/dragon_logo.ico"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit" />
<link href="${path}/WEB-PLUGIN/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- IE 8、9 -->
<script src="${path}/WEB-JS/respond-1.4.2.min.js"></script>
<script src="${path}/WEB-JS/html5shiv-3.7.3.min.js"></script>
<script src="${path}/WEB-JS/jquery-1.11.3.min.js"></script>
<script src="${path}/WEB-PLUGIN/bootstrap3/js/bootstrap.min.js"></script>
<script src="${path}/WEB-PLUGIN/layer/layer.js"></script>
<script src="${path}/WEB-PLUGIN/layer/laypage.js"></script>
<script src="${path}/WEB-JS/IECheck.js"></script>
<script src="${path}/WEB-JS/user.js"></script>

<!-- 百度富文本 -->
<link href="${path}/WEB-PLUGIN/editor/themes/default/css/ueditor.min.css" rel="stylesheet">

<script src="${path}/WEB-PLUGIN/editor/ueditor.config.js"></script>
<script src="${path}/WEB-PLUGIN/editor/ueditor.all.js"></script>