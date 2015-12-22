<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${clazz.clazzName }班-班级博客</title>
	<link href="/cblog/css/class-style.css" rel="stylesheet" type="text/css">
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
		<div id="logo">${clazz.clazzName }</div>
		<ul class="menu">
			<li><a href="#" class="clicked"><span>主页</span></a></li>
			<li><a href="/cblog/clazzs/clazzIntroduction/${clazz.clazzName }"><span>简介</span></a></li>
			<li><a href="/cblog/clazzs/class-album/${clazz.clazzName }"><span>相册</span></a></li>
			<li><a href="/cblog/clazzs/class-members/${clazz.clazzName }"><span>成员</span></a></li>
			<li><a href="/cblog/index"><span>登录</span></a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="content">
		<h1 class="content-title">时间轴</h1>
		<ul id="timeline">

		</ul>
	</div>
</div>
<div id="index-footer">
	 <p>Copyright © <a href="index.html">cBlog</a> .</p>
</div>
<!-- handlebars -->
<script id="article-item" type="text/x-handlebars-template">
    {{#articles}}
	<li>
	    <div class="timeline-left">
            <div class="year">{{activityY}}</div>
            <div class="date">{{activityD}}</div>
            <div class="place">{{site}}</div>
		</div>
        <div class="ci"></div>
        <div class="post">
			<a href="class-article.html">
			    <h2 class="post-title">{{title}}</h2>
			</a>
			<div class="post-tag">
			    <span class="tag-who">{{participant}}</span>
			    <span class="tag-when">{{activityDate}}</span>
	            <span class="tag-where">{{site}}</span>
			</div>
			<div class="post-entry">
			    <a href="class-article.html">
                    <div class="preview">
                        {{{content}}}
                    </div>
	            </a>
	            <div class="more">
			        <a href="#" class="more-btn">
			            <img src="/cblog/img/class/discuss.png">评论(<span>2</span>)
	                </a>
	                <a href="#" class="more-btn">
			            <img src="/cblog/img/class/zan.png">赞+<span>1</span>
                    </a>
			    </div>
			</div>
        </div>
    </li>
    {{/articles}}
</script>
<!--  script  -->
<script src="/cblog/js/jquery.min.js" type="text/javascript"></script>
<script src="/cblog/js/smoothscroll.js" type="text/javascript"></script>
<script src="/cblog/js/big.js" type="text/javascript"></script>
<script src="/cblog/js/top.js" type="text/javascript"></script>
<script type="text/javascript" src="/cblog/js/handlebars.js"></script>
<script type="text/javascript">
    var timeline = $("#timeline");
    var list_source = $("#article-item").html();
    var list_template = Handlebars.compile(list_source);
    var clazzName = "${clazz.clazzName }";
    $.ajax({
        type: "POST",
        url: "/cblog/articles/list",
        dataType: "json",
        data: {
            "clazzName": clazzName
        },
        success: function(data){
            $.each(data.articles, function(i, e){
                var year = e.activityDate.slice(0,5), date = e.activityDate.slice(5);
                data.articles[i].activityY = year;
                data.articles[i].activityD = date;
            });
			timeline.append(list_template(data));
        }
    });
</script>
</body>
</html>