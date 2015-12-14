<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>cBlog - 关于我们</title>
	<link rel="stylesheet" type="text/css" href="/cblog/css/index-style.css">
</head>

<body>
	<img id="wallpaper" name="wallpaper" src="http://congm.in/bing.php"/>
	<div class="black_overlay"></div>
	<div class="white_content">
		<div class="logo" id="aboutus-logobox">
			<a href="index.html"><img src="/cblog/img/logo.png" id="aboutus-logo" /></a>
			<h1 id="aboutus-h1">关于我们</h1>
		</div>
		<div class="aboutus">
		<ul>
			<li class="aboutus-box">
				<h2>网站后台开发</h2>
				<img src="/cblog/img/gxf.png" class="mypic" />
				<h2>高小飞</h2>
				<div class="contact">
				<p>我的QQ：2264904543</p>
				<p>我的邮箱：<a href="#">xiaofei.g@qq.com</a></p>
				</div>
			</li>
			<li class="aboutus-box">
				<h2>前端设计与开发</h2>
				<img src="/cblog/img/mc.png" class="mypic" />
				<h2>闵聪</h2>
				<div class="contact">
				<p>我的网站：<a href="http://congm.in">congm.in</a></p>
				<p>我的邮箱：<a href="#">mincong@congm.in</a></p>
				</div>
			</li>
			<li class="aboutus-box">
				<h2>移动端开发</h2>
				<img src="/cblog/img/wch.png" class="mypic" />
				<h2>王春河</h2>
				<div class="contact">
				<p>我的QQ：296506696</p>
				<p>我的邮箱：<a href="#">296506696@qq.com</a></p>
				</div>
			</li>
		</div>
	</div>
	<a href="http://bing.com" target="_blank"><div id="from_bing">bing每日壁纸</div></a>
	<div id="about">
		<a href="#" target="_blank">重庆邮电大学 蓝山工作室</a>
	</div>
<!-- script -->
<script src="/cblog/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
$(function(){
	var o = $("#wallpaper");
	o.error(function(){
		$(this).attr("src", "img/bg.jpg");
	});
})
</script>
</body>
</html>