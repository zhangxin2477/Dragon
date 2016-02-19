<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="panel panel-default">
	<div class="panel-heading">用户信息</div>
	<div class="panel-body">
		<table style="width:100%;">
			<tr>
				<td class="user_table_left">登录名：</td>
				<td><input type="text" class="form-control" placeholder="登录名"
					style="height:27px;" disabled value="${userList[0][1]}" /></td>
			</tr>
			<tr>
				<td class="user_table_left">昵称：</td>
				<td><input type="text" class="form-control" placeholder="昵称"
					style="height:27px;" value="${userList[0][2]}" /></td>
			</tr>
			<tr>
				<td class="user_table_left">性别：</td>
				<td><label class="radio-inline"> <c:choose>
							<c:when test="${userList[0][11]=='男'}">
								<input type="radio" name="inlineRadioOptions" value="男" checked>
							</c:when>
							<c:otherwise>
								<input type="radio" name="inlineRadioOptions" value="男">
							</c:otherwise>
						</c:choose> 男
				</label> <label class="radio-inline"> <c:choose>
							<c:when test="${userList[0][11]=='女'}">
								<input type="radio" name="inlineRadioOptions" value="女" checked>
							</c:when>
							<c:otherwise>
								<input type="radio" name="inlineRadioOptions" value="女">
							</c:otherwise>
						</c:choose> 女
				</label><label class="radio-inline"> <c:choose>
							<c:when test="${userList[0][11]=='女'}">
								<input type="radio" name="inlineRadioOptions" value="保密" checked>
							</c:when>
							<c:otherwise>
								<input type="radio" name="inlineRadioOptions" value="保密">
							</c:otherwise>
						</c:choose> 保密
				</label></td>
			</tr>
			<tr>
				<td class="user_table_left">年龄：</td>
				<td>${userList[0][10]}</td>
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
					style="height:27px;" value="${userList[0][12]}" /></td>
			</tr>
			<tr>
				<td class="user_table_left">手机：</td>
				<td><input type="text" class="form-control" placeholder="手机"
					style="height:27px;" value="${userList[0][13]}" /></td>
			</tr>
			<tr>
				<td class="user_table_left">注册时间：</td>
				<td>${userList[0][5]}</td>
			</tr>
			<tr>
				<td class="user_table_left">最后登录时间：</td>
				<td>${userList[0][6]}</td>
			</tr>
		</table>
	</div>
</div>
