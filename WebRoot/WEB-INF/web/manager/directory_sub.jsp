<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!-- start:dir_sub -->
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">菜单管理</div>
	<div class="panel-body">
		<div class="text-right">
			<button id="add-sub" type="button" class="btn btn-primary">新增子菜单</button>
			<button id="edit-sub" type="button" class="btn btn-primary">修改</button>
			<button id="delete-sub" type="button" class="btn btn-primary">删除</button>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th style="display:none;">id</th>
					<th style="display:none;">s_id</th>
					<th>序号</th>
					<th>子菜单</th>
				</tr>
			</thead>
			<tbody id="directory-sub"></tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/common/common.js"></script>
<script src="${path}/WEB-JS/manager/directory_sub.js"></script>
<!-- end:dir_sub -->
