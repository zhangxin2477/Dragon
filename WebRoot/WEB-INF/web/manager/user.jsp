<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">用户管理</div>
	<div class="panel-body">
		<table class="table table-bordered table-hover">
			<caption>管理用户信息！</caption>
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th>序号</th>
					<th>账号</th>
					<th>昵称</th>
					<th></th>
					<th>更新时间</th>
					<th>阅读量</th>
					<th>属性</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody id="body_list">
				<c:forEach var="s" begin="1" end="5">
					<tr onclick="sel(this)">
						<td style="display:none;">0</td>
						<th scope="row">${s}</th>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button id="add" type="button" class="btn btn-primary">新增</button>
		<button id="edit" type="button" class="btn btn-primary">修改</button>
		<button id="delete" type="button" class="btn btn-primary">删除</button>
	</div>
</div>

<script src="${path}/WEB-JS/manager/body.js"></script>
