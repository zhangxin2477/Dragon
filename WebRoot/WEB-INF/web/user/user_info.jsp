<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<div class="panel-heading">用户信息</div>
	<div class="panel-body">
		<table style="width:100%;">
			<tr>
				<td class="user_table_left">登录名：</td>
				<td><input type="text" class="form-control" placeholder="登录名"
					style="height:27px;" disabled /></td>
			</tr>
			<tr>
				<td class="user_table_left">昵称：</td>
				<td><input type="text" class="form-control" placeholder="昵称"
					style="height:27px;" /></td>
			</tr>
			<tr>
				<td class="user_table_left">性别：</td>
				<td><label class="radio-inline"> <input type="radio"
						name="inlineRadioOptions" id="inlineRadio1" value="男"> 男
				</label> <label class="radio-inline"> <input type="radio"
						name="inlineRadioOptions" id="inlineRadio2" value="女"> 女
				</label><label class="radio-inline"> <input type="radio"
						name="inlineRadioOptions" id="inlineRadio3" value="保密"> 保密
				</label></td>
			</tr>
			<tr>
				<td class="user_table_left">年龄：</td>
				<td>100</td>
			</tr>
			<tr>
				<td class="user_table_left">生日：</td>
				<td><c:import url="/WEB-INF/web/common/birthday.jsp"></c:import></td>
			</tr>
			<tr>
				<td class="user_table_left">所在地：</td>
				<td><c:import url="/WEB-INF/web/common/area.jsp"></c:import></td>
			</tr>
			<tr>
				<td class="user_table_left">邮箱：</td>
				<td><input type="text" class="form-control" placeholder="邮箱"
					style="height:27px;" /></td>
			</tr>
			<tr>
				<td class="user_table_left">手机：</td>
				<td><input type="text" class="form-control" placeholder="手机"
					style="height:27px;" /></td>
			</tr>
			<tr>
				<td class="user_table_left">注册时间：</td>
				<td>2016年1月18日 21:35:30</td>
			</tr>
			<tr>
				<td class="user_table_left">最后登录时间：</td>
				<td>2016年1月18日 21:35:37</td>
			</tr>
		</table>
	</div>
</div>
