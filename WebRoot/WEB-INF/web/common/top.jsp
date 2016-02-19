<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main"> <img alt="Brand"
				src="${path}/WEB-RES/image/dragon_logo.png"
				style='height: 30px; padding-left: 1rem'>
			</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main">首页<span class="sr-only">(current)</span></a></li>
				<c:forEach items="${classifyList}" var="classify">
					<c:if test="${classify.classParentid==null}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">${classify.className}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:forEach items="${classifyList}" var="sub" varStatus="vs">
									<c:if test="${vs.index==0}"></c:if>
									<c:if test="${classify.id==sub.classParentid}">
										<li><a href="#">${sub.className}</a></li>
										<li role="separator" class="divider"></li>
									</c:if>
								</c:forEach>
							</ul></li>
					</c:if>
				</c:forEach>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group input-group">
					<input type="text" class="form-control" placeholder="搜索"> <span
						class="input-group-btn">
						<button class="btn btn-info" type="button">搜索</button>
					</span>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${users!=null}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><img style="width:20px;height:20px;"
								class="img-circle image_size_small"
								src="${path}/WEB-RES/image/default.png" />&nbsp;${users.name}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="loginout">退出</a></li>
								<li role="separator"></li>
								<li role="separator" class="divider"></li>
								<li><a href="manager">设置</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li><a href="login">登录</a></li>
						<li><a href="register">注册</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>