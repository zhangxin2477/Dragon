<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

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
					<th>序号</th>
					<th>父菜单</th>
					<th>子菜单</th>
					<th>主题</th>
					<th style="display:none;">选择</th>
				</tr>
			</thead>
			<tbody id="directory-par">
				<c:forEach var="s" begin="1" end="5">
					<tr onclick="selPar(this)">
						<th scope="row">${s}</th>
						<td>XX</td>
						<td>XX</td>
						<td>XX</td>
						<td style="display:none;">0</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page" style="text-align:center;"></div>
	</div>
</div>

<script src="${path}/WEB-JS/manager/directory_par.js"></script>
