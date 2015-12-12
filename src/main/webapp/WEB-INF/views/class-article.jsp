<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${article.clazz.clazzName }班-班级文章-${article.title }</title>
	<link href="../css/class-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 大图 -->
<div id="outerdiv">
	<div id="black_overlay"></div>
	<div id="innerdiv">
		<img id="bigimg" class="bigimg" src="" />
	</div>
</div>
<!-- 回到顶部 -->
<a id="returnTop" href="#">回到顶部</a> 

<div id="header">
	<div class="content">
		<div id="logo">${article.clazz.clazzName }</div>
		<ul class="menu">
			<li><a href="class-home.html" class="clicked"><span>主页</span></a></li>
			<li><a href="class-introduction.html"><span>简介</span></a></li>
			<li><a href="class-album.html"><span>相册</span></a></li>
			<li><a href="class-members.html"><span>成员</span></a></li>
			<li><a href="index.html"><span>登录</span></a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="content">
		<h1 class="content-title">${article.title }</h1>
		<div class="article-tag"><span>时间：<fmt:formatDate value="${article.activityDate }" pattern="yyyy年MM月dd日"/></span><span>地点：${article.site }</span><span>参与者：${article.participant }</span></div>
		<hr />
		<div class="article-content">
			${article.content }
		<div class="article-more">
			<a href="#" class="more-btn"><img src="../img/class/zan.png">赞+<span>1</span></a>
			<a href="#" class="more-btn"><img src="../img/class/discuss.png">评论(<span>2</span>)</a>
			<a href="#" class="more-btn"><img src="../img/class/share.png">分享</a>
		</div>
		</div>
		<hr />
		<div class="article-discuss">
			<h3>文章评论(<strong>0</strong>条评论)</h3>
			<img src="../img/class/members/1.jpg" class="userlogo">
			<form action="" class="article-discuss-box">
				<textarea maxlength="250"placeholder="评论一下，250字以内"></textarea>
				<button type="submit">发表</button>
			</form>
			<div class="article-discuss-main">
				<h3>最新评论</h3>
				<div class="article-discuss-mainbox">
					<div class="nonediscuss">还没有评论，快来抢沙发吧！</div>
					<div class="article-discuss-mainarea">
						<div class="article-discuss-i">
							<img src="../img/class/members/1.jpg" class="userminilogo" />
							<div class="article-discuss-bd">
								<div class="article-discuss-bdhd">
									<div class="article-discuss-bdhd-left">
									<span class="article-discuss-username">闵聪</span><a target="_blank" href="class-home.html" class="article-discuss-classid">[0401308班-重庆邮电大学]</a>
									</div>
									<div class="article-discuss-bdhd-right">
										<span class="article-discuss-time">2015年6月2日 14:42</span>
									</div>
								</div>
								<div class="article-discuss-bdp">
									<p>棒棒哒</p>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="article-footer">
	<p>Copyright © <a href="index.html">cBlog</a></p>
</div>
<!--  script  -->
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/smoothscroll.js" type="text/javascript"></script>
<script src="../js/big.js" type="text/javascript"></script>
<script src="../js/top.js" type="text/javascript"></script>
</body>
</html>