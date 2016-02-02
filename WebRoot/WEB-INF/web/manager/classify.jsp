<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<!-- START:分类 -->
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">分类管理</div>
	<div class="panel-body">
		<div class="text-right">
			<button id="add" type="button" class="btn btn-primary">新增分类</button>
			<button id="edit" type="button" class="btn btn-primary">修改分类</button>
			<button id="delete" type="button" class="btn btn-primary">删除分类</button>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th style="display:none;">id</th>
					<th style="display:none;">theme_id</th>
					<th>序号</th>
					<th>主题</th>
					<th>分类名称</th>
					<th>层次</th>
					<th>级别</th>
					<th style="display:none;">parent_id</th>
					<th>父类名称</th>
				</tr>
			</thead>
			<tbody id="classify"></tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/common/common.js"></script>
<script src="${path}/WEB-JS/manager/classify.js"></script>
<!-- END:分类 -->