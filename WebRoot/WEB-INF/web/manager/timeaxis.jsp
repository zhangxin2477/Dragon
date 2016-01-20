<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<link href="${path}/WEB-PLUGIN/timeaxis/css/history.css"
	rel="stylesheet">


<!-- 代码 开始 -->
<div class="head-warp">
	<div class="head">
		<div class="nav-box">
			<ul>
				<li class="cur"
					style="text-align:center;">大事记时间轴</li>
			</ul>
		</div>
	</div>
</div>
<div class="main">
	<div class="history" style="height:100%; display: block;">

		<c:forEach var="s" begin="1" end="5">
			<div class="history-date">
				<ul>
					<h2 class="bounceInDown comm">
						<a href="#nogo" style="display: inline-block;">201${s}年</a>
					</h2>

					<c:forEach var="sp" begin="1" end="5">
						<li class="bounceInDown comm_li">
							<h3 style="display: block;">
								${sp}<span></span>
							</h3>
							<dl style="display: block;">
								<dt>
									标题 <span>内容</span>
								</dt>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
	</div>
</div>

<script src="${path}/WEB-PLUGIN/timeaxis/js/main.js"></script>
