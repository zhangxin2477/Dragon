<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<a id="back-to-top" title="回到顶部"
	style="position: fixed; bottom: 50px; right: 15px; cursor: pointer; display: block;">
	<img src="${path}/WEB-RES/image/gotop.gif"
	style="width:35px; height:35px;">
</a>

<nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div class="container text-center" style="color:#fff;">Copyright
		©2015 Dragon</div>
</nav>