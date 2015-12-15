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

			<li>
				<div class="timeline-left">
					<div class="year">2015年</div>
					<div class="date">04月16日</div>
					<div class="place">太极新操场</div>
				</div>
				<div class="ci"></div>
				<div class="post">
					<a href="class-article.html">
						<h2 class="post-title">学校第十届田径运动会隆重开幕</h2>
					</a>
					<div class="post-tag">
						<span class="tag-who">全学校</span>
						<span class="tag-when">2015年4月16日</span>
						<span class="tag-where">太极操场</span>
					</div>
					<div class="post-entry">
						<img src="/cblog/img/class/index/img001.jpg" class="alignleft border pimg bimg">
						<a href="class-article.html">
							<div class="preview">
								<p>计算机学院组织编排的腰鼓、啦啦操、红旗方阵等表演气势磅礴，激情昂扬，充分展现出了重邮学子朝气蓬勃的精神面貌以及爱国爱校的情怀。在最后的方阵表演中，他们别出心裁地运用多彩折扇，用红、黄、蓝三种颜色，通过默契的配合，向老师和同学们呈现了能代表学校发展和特色的字样和图案，充分展现出重邮人积极向上，团结共进的拼搏精神，也预示学校的明天将会更加美好。</p>
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

			<li>
				<div class="timeline-left">
					<div class="year">2014年</div>
					<div class="date">11月01日</div>
					<div class="place"></div>
				</div>
				<div class="ci"></div>
				<div class="post">
					<a href="class-article.html">
						<h2 class="post-title">大学入学</h2>
					</a>
					<div class="post-tag">
						<span class="tag-who">全班</span>
						<span class="tag-when">2013年9月11日</span>
						<span class="tag-where">重庆邮电大学</span>
					</div>
					<div class="post-entry">
						<img src="/cblog/img/class/index/img000.jpg" class="alignright border pimg bimg">
						<a href="class-article.html">
						<div class="preview">
							<p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
							<p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
							<p>同学们，相逢即是缘！</p>
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
		</ul>
	</div>
</div>
<div id="index-footer">
	 <p>Copyright © <a href="index.html">cBlog</a> .</p>
</div>

<!--  script  -->
<script src="/cblog/js/jquery.min.js" type="text/javascript"></script>
<script src="/cblog/js/smoothscroll.js" type="text/javascript"></script>
<script src="/cblog/js/big.js" type="text/javascript"></script>
<script src="/cblog/js/top.js" type="text/javascript"></script>
<script src="/cblog/js/class-async.js" type="text/javascript"></script>
</body>
</html>