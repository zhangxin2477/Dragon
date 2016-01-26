<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!-- START:DIR_PAR -->
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">菜单管理</div>
	<div class="panel-body">
		<div class="text-right">
			<button id="add-par" type="button" class="btn btn-primary">新增父菜单</button>
			<button id="edit-par" type="button" class="btn btn-primary">修改</button>
			<button id="delete-par" type="button" class="btn btn-primary">删除</button>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th style="display:none;">id</th>
					<th style="display:none;">s_dir_id</th>
					<th style="display:none;">theme_id</th>
					<th>序号</th>
					<th>父菜单</th>
					<th>子菜单</th>
					<th>主题</th>
				</tr>
			</thead>
			<tbody id="directory-par"></tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/common/common.js"></script>
<script src="${path}/WEB-JS/manager/directory_par.js"></script>
<!-- END:DIR_PAR -->