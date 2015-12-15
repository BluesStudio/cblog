<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${clazz.clazzName }班-班级简介</title>
	<link href="/cblog/css/class-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 大图 -->
<div id="outerdiv">
<div id="black_overlay"></div>
<div id="innerdiv">
	<img id="bigimg" class="bigimg" src="" />
</div></div>

<div id="header">
	<div class="content">
		<div id="logo">${clazz.clazzName }</div>
		<ul class="menu">
			<li><a href="/cblog/clazzs/class-home/${clazz.clazzName }"><span>主页</span></a></li>
			<li><a href="#" class="clicked"><span>简介</span></a></li>
			<li><a href="/cblog/clazzs/class-album/${clazz.clazzName }"><span>相册</span></a></li>
			<li><a href="/cblog/clazzs/class-members/${clazz.clazzName }"><span>成员</span></a></li>
			<li><a href="/cblog/index"><span>登录</span></a></li>
		</ul>
	</div>
</div>
<div id="content">
	<ul id="introduction-box">
		<li class="box1">
			<div class="introduction-box">
				<h2>班旗</h2>
				<div class="box-bd">
					<img src="http://xiaofeig.image.alimmdn.com/cblog/${clazz.flagImg }" class="banqi border bimg">
				</div>
			</div>
		</li>
		<li class="box2">
			<div class="introduction-box">
				<h2>班歌</h2>
				<div class="box-bd">
					<h3>${clazz.songTitle }</h3>
					<div class="bange">
					<audio controls="controls"height="100" width="100">
					<source src="http://xiaofeig.image.alimmdn.com/cblog/${clazz.song }" type="audio/mpeg" />
	                <embed height="100" width="100" src="http://xiaofeig.image.alimmdn.com/cblog/${clazz.song }" />
	                </audio>
	                </div>
	                <div class="bangeci">
		                ${clazz.lyric }
	                </div>
				</div>
			</div>
		</li>
		<li class="box3" id="box-selected">
			<div class="introduction-box">
				<h2>概述</h2>
				<div class="box-bd">
					<div class="box3-p">
						<p>${clazz.overview }</p>
					</div>
					<c:if test="${clazz.clazzImg==null }">
					<img src="/cblog/img/class/introduction/0.jpg" id="mainimg" class="border bimg">
					</c:if>
					<c:if test="${clazz.clazzImg!=null }">
					<img src="http://xiaofeig.image.alimmdn.com/cblog/${clazz.clazzImg }" id="mainimg" class="border bimg">
					</c:if>
				</div>
			</div>
		</li>
		<li class="box4">
			<div class="introduction-box">
				<h2>荣誉</h2>
				<div class="box-bd">
				<div class="class-rongyu">
					<h3>班级荣誉</h3>
					
					<c:forEach items="${clazz.clazzHonors }" var="clazzHonor">
					<p>${clazzHonor.honorName }</p>
					</c:forEach>
				</div>
				<hr/>
				<div class="stu-rongyu">
					<h3>个人荣誉</h3>
					<c:forEach items="${clazz.personalHonors }" var="personalHonor">
					<p>${personalHonor.student.stuName }:${personalHonor.award }</p>
					</c:forEach>
				</div>
				<hr/>
				<div class="rongyuqiang">
					<h3>荣誉墙</h3>
					<c:forEach items="${clazz.honorWalls }" var="honorWall">
					<img src="http://xiaofeig.image.alimmdn.com/cblog/${honorWall.image }" class="bimg border"/>
					</c:forEach>
				</div>
				</div>
			</div>
		</li>
		<li class="box5">
			<div class="introduction-box">
				<h2>标语</h2>
				<div class="box-bd">
					<div class="biaoyu">
					<h3>${clazz.slogan }</h3>
					</div>
				</div>
			<div>
		</li>
	</ul>
</div>
<div id="footer">
	<div class="content"></div>
</div>

<!--  script  -->
<script src="/cblog/js/jquery.min.js" type="text/javascript"></script>
<script src="/cblog/js/smoothscroll.js" type="text/javascript"></script>
<script src="/cblog/js/big.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	var oLi = $("#introduction-box li");
	for(var i = 0; i < oLi.length; i++){
	    oLi[i].onmouseover = function(){
    		oTimes = 1;
		    for(var i = 0; i < oLi.length; i++)
		    {
		        oLi[i].id = "";
		    }
		    this.id = "box-selected";
		}
	}
})
</script>
</body>
</html>