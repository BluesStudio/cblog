<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${clazz.clazzName }班-班级成员</title>
	<link href="/cblog/css/class-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 大图评论 -->
<div id="outerdiv">
	<div id="black_overlay"></div>
	<div id="innerdiv">
		<div id="members-said">
			<img src="/cblog/img/class/close.png" id="closesaid" />
			<div class="members-info">
				<img id="simg" class="simg" src="" />
				<div class="members-said">
					<h1>寄语</h1>
					<p>青春是一场远行，回不去了；</p>
					<p>青春是一场相逢，忘不掉了；</p>
					<p>青春是一场伤痛，来不及了。</p>
				</div>
			</div>
			<div class="members-discuss">
				<h1>评价</h1>
				<div class="members-discuss-tag">
					<span>帅气</span>
					<span>帅气</span>
					<span>帅气逼人</span>
					<span>帅气</span>
					<span>帅气逼人</span>
					<span>帅气逼人</span>
				</div>
				<form class="members-discuss-addtag" method="post" action="#" autocomplete="off">
					<input type="text" placeholder="评价">
					<button type="submit">提交</button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- 回到顶部 -->
<a id="returnTop" href="#">回到顶部</a> 


<div id="header">
	<div class="content">
		<div id="logo">${clazz.clazzName }</div>
		<ul class="menu">
			<li><a href="/cblog/clazzs/class-home/${clazz.clazzName }"><span>主页</span></a></li>
			<li><a href="/cblog/clazzs/clazzIntroduction/${clazz.clazzName }"><span>简介</span></a></li>
			<li><a href="/cblog/clazzs/class-album/${clazz.clazzName }"><span>相册</span></a></li>
			<li><a href="#" class="clicked"><span>成员</span></a></li>
			<li><a href="/cblog/index"><span>登录</span></a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="content">
		<h1 class="content-title">班级成员</h1>
		<table class="members">
		</table>
	</div>
</div>
<div id="footer">
	<img src="/cblog/img/class/grass.png" class="grass">
</div>

<!-- handlebars -->
<script id="list-item" type="text/x-handlebars-template">
    {{#list this}}
    <img src="http://xiaofeig.image.alimmdn.com/cblog/{{stuImg}}" class="members-img mimg">
    {{/list}}
</script>
<!--  script  -->
<script src="/cblog/js/jquery.min.js" type="text/javascript"></script>
<script src="/cblog/js/smoothscroll.js" type="text/javascript"></script>
<script src="/cblog/js/big.js" type="text/javascript"></script>
<script src="/cblog/js/top.js" type="text/javascript"></script>
<script type="text/javascript" src="/cblog/js/handlebars.js"></script>
<script type="text/javascript">
	$(function(){
		var members = $(".members");
		var list_source = $("#list-item").html();
		var list_template = Handlebars.compile(list_source);
		var clazzName = "${clazz.clazzName }";
		$.ajax({
			type: "POST",
			url: "/cblog/students/list",
			dataType: "json",
			data: {
				"clazzName": clazzName
			},
			success: function(data){
				var list_data = data.students;
				Handlebars.registerHelper('list', function(items, options) {
					var out = "";
                    var n = 6;
					for(var i = 0, l = items.length; i <= Math.floor(l/n); i++) {
						out += "<tr>";
						for (var j = 0; j < Math.min(n, l-n*i); j++) {
							out += "<td>" + options.fn(items[n*i+j]) + "</td>";
						}
						out += "</tr>";
					}
					return out;
				});
                members.append(list_template(list_data));
			}
		});
	})
</script>
</body>
</html>