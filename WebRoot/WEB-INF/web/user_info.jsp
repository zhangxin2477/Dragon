<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">用户信息</div>
	<div class="panel-body">
		
		<button id="add" type="button" class="btn btn-primary">新增</button>
		<button id="edit" type="button" class="btn btn-primary">修改</button>
		<button id="delete" type="button" class="btn btn-primary">删除</button>
	</div>
</div>

<script src="${path}/WEB-JS/manager/body.js"></script>
