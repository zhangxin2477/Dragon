<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">内容管理</div>
	<div class="panel-body">
		<div class="text-right">
			<button id="enable" type="button" class="btn btn-primary">启用</button>
			<button id="disable" type="button" class="btn btn-danger">禁用</button>
			<button id="delete" type="button" class="btn btn-primary">删除</button>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th style="display:none;">id</th>
					<th>序号</th>
					<th>标题</th>
					<th>所属分类</th>
					<th>发布时间</th>
					<th>更新时间</th>
					<th>被赞次数</th>
					<th>阅读量</th>
					<th>属性</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody id="article"></tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/common/common.js"></script>
<script src="${path}/WEB-JS/manager/article.js"></script>