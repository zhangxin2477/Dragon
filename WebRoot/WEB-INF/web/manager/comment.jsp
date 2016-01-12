<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">评论管理</div>
	<div class="panel-body">
		<div class="text-right">
			<button id="delete" type="button" class="btn btn-primary">删除</button>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="display:none;">选择</th>
					<th>序号</th>
					<th>标题</th>
					<th>回复人</th>
					<th>回复时间</th>
				</tr>
			</thead>
			<tbody id="theme">
				<c:forEach var="s" begin="1" end="5">
					<tr onclick="sel(this)">
						<td style="display:none;">0</td>
						<th scope="row">${s}</th>
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

<script src="${path}/WEB-JS/manager/comment.js"></script>
