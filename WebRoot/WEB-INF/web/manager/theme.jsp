<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!-- start:theme -->
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">主题管理</div>
	<div class="panel-body">
		<div class="text-right">
			<button id="add" type="button" class="btn btn-primary">新增</button>
			<button id="edit" type="button" class="btn btn-primary">修改</button>
			<button id="delete" type="button" class="btn btn-primary">删除</button>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th style="display:none;">id</th>
					<th>序号</th>
					<th>中文名称</th>
					<th>英文名称</th>
					<th>密钥</th>
				</tr>
			</thead>
			<tbody id="theme"></tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/common/common.js"></script>
<script src="${path}/WEB-JS/manager/theme.js"></script>
<!-- end:theme -->
