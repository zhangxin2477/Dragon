<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">用户管理</div>
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
					<th>序号</th>
					<th>账号</th>
					<th>昵称</th>
					<th>主题</th>
					<th>类型</th>
				</tr>
			</thead>
			<tbody id="user_list">
				<c:forEach var="s" begin="1" end="5">
					<tr onclick="selUser(this)">
						<td style="display:none;">0</td>
						<td scope="row">${s}</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/manager/user_list.js"></script>
