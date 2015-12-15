<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${clazz.clazzName }班-班级相册</title>
	<link href="/cblog/css/class-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 大图评论 -->
<div id="outerdiv">
<div id="black_overlay"></div>
<div id="innerdiv">
	<img src="/cblog/img/class/close.png" id="closesaid" />
	<img id="bigimg" class="bigimg albumimg" src="" />
	<div class="album-dicuss">
	<div class="album-discuss-main">
		<h3>照片评论(<strong>1</strong>条评论)</h3>
		<div class="ablum-discuss-mainbox">
		<div class="nonediscuss">还没有评论，快来抢沙发吧！</div>
		<div class="ablum-discuss-mainarea">
			<div class="ablum-discuss-i">
				<img src="/cblog/img/class/members/1.jpg" class="ablumuserminilogo" />
				<div class="ablum-discuss-bd">
					<div class="ablum-discuss-bdhd">
						<span class="ablum-discuss-username">闵聪</span><a target="_blank" href="class-home.html" class="ablum-discuss-classid">[0401308班-重庆邮电大学]</a>
					</div>
					<div class="ablum-discuss-bdp">
						<p>棒棒哒</p>
					</div>
					<div class="ablum-discuss-time">2015年6月2日 14:42</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	</div>
	<form action="" class="ablum-discuss-box">
		<textarea maxlength="50" placeholder="评论一下，50字以内"></textarea>
		<button type="submit">发表</button>
	</form>
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
			<li><a href="#" class="clicked"><span>相册</span></a></li>
			<li><a href="/cblog/clazzs/class-members/${clazz.clazzName }"><span>成员</span></a></li>
			<li><a href="/cblog/index"><span>登录</span></a></li>
		</ul>
	</div>
</div>
<div id="content">
	<h1 class="content-title">班级相册</h1>
	<div id="album"></div>
</div>
<div id="footer">
	<img src="/cblog/img/class/grass.png" class="grass">
</div>
<!-- handlebars -->
<script id="show-item" type="text/x-handlebars-template">
    <div id="pho-show">
        <ul>
            {{#each this}}
            <li><div class="cimgbox"><img src="http://xiaofeig.image.alimmdn.com/cblog/{{image}}" class="cimg"></div></li>
            {{/each}}
        </ul>
    </div>
</script>
<script id="list-item" type="text/x-handlebars-template">
    <table id="pho-list">
        {{#list this}}
            <div class="dimgbox"><img class="dimg" src="http://xiaofeig.image.alimmdn.com/cblog/{{image}}"></div>
        {{/list}}
    </table>
</script>
<!--  script  -->
<script src="/cblog/js/jquery.min.js" type="text/javascript"></script>
<script src="/cblog/js/smoothscroll.js" type="text/javascript"></script>
<script src="/cblog/js/big.js" type="text/javascript"></script>
<script src="/cblog/js/top.js" type="text/javascript"></script>
<script type="text/javascript" src="/cblog/js/handlebars.js"></script>
<script type="text/javascript">
$(function(){
    var album = $("#album");
    var show_source = $("#show-item").html();
    var show_template = Handlebars.compile(show_source);
	var list_source = $("#list-item").html();
	var list_template = Handlebars.compile(list_source);
    var clazzName = "${clazz.clazzName }";
    $.ajax({
        type: "POST",
        url: "/cblog/albums/list",
        dataType: "json",
        data: {
            "clazzName": clazzName
        },
        success: function(data){
            var show_data = data.albums.slice(0,7);
			var list_data = data.albums.slice(7);
			Handlebars.registerHelper('list', function(items, options) {
                var out = "";
                var n = 4;
                for(var i = 0, l = items.length; i <= Math.floor(l/n); i++) {
                    out += "<tr>";
                    for (var j = 0; j < Math.min(n, l-n*i); j++) {
                        out += "<td>" + options.fn(items[n*i+j]) + "</td>";
                    }
                    out += "</tr>";
                }
                return out;
			});
			album.append(show_template(show_data));
			album.append(list_template(list_data));
            var oImg=$(".cimgbox");
            $(oImg[3]).attr("id","spe");
            for(var i=0;i<oImg.length;i++){
                $(oImg[i]).hover(function(){
                    for(var i=0;i<oImg.length;i++){
                        $(oImg[i]).attr("id","");
                    }
                    $(this).attr("id","spe");
                },function(){
                    $(this).attr("id","");
                    $(oImg[3]).attr("id","spe");
                });
            }
        }
    });
})
</script>
</body>
</html>