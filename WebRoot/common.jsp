<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="icon" href="<%=basePath%>Main/image/dragon_logo.ico"
	type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>Main/image/dragon_logo.ico"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit" />
<link href="<%=basePath%>Main/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- IE 8、9 -->
<script src="<%=basePath%>Main/js/respond-1.4.2.min.js"></script>
<script src="<%=basePath%>Main/js/html5shiv-3.7.3.min.js"></script>
<script src="<%=basePath%>Main/js/jquery-1.11.3.min.js"></script>
<script src="<%=basePath%>Main/bootstrap3/js/bootstrap.min.js"></script>
<script src="<%=basePath%>Main/layer/layer.js"></script>
<script src="<%=basePath%>Main/layer/laypage.js"></script>
<script src="<%=basePath%>Main/js/IECheck.js"></script>
<script src="<%=basePath%>Main/js/user.js"></script>

<!-- 默认配置文件 -->
<script src="<%=basePath%>/Main/ueditor1_4_3/ueditor.config.js"></script>
<script src="<%=basePath%>/Main/ueditor1_4_3/ueditor.all.min.js"></script>
<!-- 语言文件 -->
<script src="<%=basePath%>/Main/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
<!-- 如果需要页面渲染的话引入 -->
<script src="<%=basePath%>/Main/ueditor1_4_3/ueditor.parse.min.js"></script>
