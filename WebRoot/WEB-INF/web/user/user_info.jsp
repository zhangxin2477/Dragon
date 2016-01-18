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
					style="height:27px;" /></td>
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
				<td>XX</td>
			</tr>
			<tr>
				<td class="user_table_left">所在地：</td>
				<td><div class="info">
						<div>
							<select id="s_province" name="s_province"></select>   <select
								id="s_city" name="s_city"></select>   <select id="s_county"
								name="s_county"></select>
							<script class="resources library" src="area.js"
								type="text/javascript"></script>

							<script type="text/javascript">
								_init_area();
							</script>
						</div>
						<div id="show"></div>
					</div> <script type="text/javascript">
						var Gid = document.getElementById;
						var showArea = function() {
							Gid('show').innerHTML = "<h3>省"
									+ Gid('s_province').value + " - 市"
									+ Gid('s_city').value + " - 县/区"
									+ Gid('s_county').value + "</h3>"
						}
						Gid('s_county').setAttribute('onchange', 'showArea()');
					</script></td>
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
