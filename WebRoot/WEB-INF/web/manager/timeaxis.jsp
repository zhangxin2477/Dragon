<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div id="arrow">
	<ul>
		<li class="arrowup"></li>
		<li class="arrowdown"></li>
	</ul>
</div>

<div id="history">

	<div class="title">
		<h2>网站成长史</h2>
		<div id="circle">
			<div class="cmsk"></div>
			<div class="circlecontent">
				<div thisyear="2013" class="timeblock">
					<span class="numf"></span> <span class="nums"></span> <span
						class="numt"></span> <span class="numfo"></span>
					<div class="clear"></div>
				</div>
				<div class="timeyear">YEAR</div>
			</div>
			<a href="#" class="clock"></a>
		</div>
	</div>

	<div id="content">
		<ul class="list">
			<li style="margin-top:-110px;">
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span> <span class="md">0905</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">HTML5 CSS3 发展历程 发布</a>
						</div>
						<div class="hisct">修正了上一版本中的错误，欢迎大家测试，如果发现问题请联系我们,谢谢。</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span> <span class="md">0807</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">HTML5 CSS3 发展历程 发布</a>
						</div>
						<div class="hisct">随着用户的访问量增大,功能不能满足需求，我们进行了重大更新，对设计和功能都进行大幅度的升级,增加了原创，欣赏版块</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span> <span class="md">0528</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">官方微博</a>
						</div>
						<div class="hisct">推出了HTML5 CSS3 官方微博</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">

					<div class="lileft">
						<div class="date">
							<span class="year">2013</span> <span class="md">0524</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">HTML5 CSS3 发展历程 上线</a>
						</div>
						<div class="hisct">虽然功能还未健全，但是我们已迫不及待的让它去接受广大用户的火眼金睛</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span> <span class="md">0508</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">初期讨论</a>
						</div>
						<div class="hisct">在集体探讨下，发现目前的HTML5 CSS3
							发展历程已经不能满足需求，集体讨论=，这时候，韩老师之前的设计稿被端上了会议桌。</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2012</span> <span class="md">0701</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">灵感迸发</a>
						</div>
						<div class="hisct">某天晚上的凌晨三点一刻，预想建立这样一个功能的网站，专为网页设计师。</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">

					<div class="lileft">
						<div class="date">
							<span class="year">2012</span> <span class="md">0524</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">HTML5 CSS3 发展历程 上线</a>
						</div>
						<div class="hisct">虽然功能还未健全，但是我们已迫不及待的让它去接受广大用户的火眼金睛</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span> <span class="md">3月1日</span>
						</div>
					</div>

					<div class="point">
						<b></b>
					</div>

					<div class="liright">
						<div class="histt">
							<a href="#">初见成效</a>
						</div>
						<div class="hisct">代码笔记第一版上线</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>
