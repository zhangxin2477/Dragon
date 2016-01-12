<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">主题管理</div>
	<div class="panel-body">
		<table class="table table-bordered table-hover">
			<caption>主题代表网站唯一元素！</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>主题名称</th>
					<th>序列号</th>
					<th style="display:none;">选择</th>
				</tr>
			</thead>
			<tbody id="theme">
				<c:forEach var="s" begin="1" end="5">
					<tr onclick="sel(this)">
						<th scope="row">${s}</th>
						<td>XX</td>
						<td>XX</td>
						<td style="display:none;">0</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button id="add" type="button" class="btn btn-primary">新增</button>
		<button id="edit" type="button" class="btn btn-primary">修改</button>
		<button id="delete" type="button" class="btn btn-primary">删除</button>
	</div>
</div>

<script src="${path}/WEB-JS/manager/theme.js"></script>
