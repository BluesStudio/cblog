<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cBlog - 班级博客</title>
        <link rel="stylesheet" type="text/css" href="/cblog/css/index-style.css">
        <link rel="stylesheet" type="text/css" href="/cblog/css/font-awesome.min.css">
    </head>
    <body>
        <!-- 背景 -->
        <img id="wallpaper" name="wallpaper" src="http://congm.in/bing.php"/>
        <!-- //背景 -->
        <div class="black_overlay"></div>
        <div class="white_content">
        	<!-- 首页 -->
            <div class="logo">
                <img src="/cblog/img/logo.png" id="logo" />
                <h1>班级博客系统</h1>
                <div class="main-box" id="mainBox">
        			<!-- 表单1: 进入班级 -->
                    <form method="post" action="class-home.html" autocomplete="off">
                        <input class="search" type="text" value="输入班级编号，进入该班级博客" />
                        <button type="submit" id="enterclass"></button>
                    </form>
	                <!-- //表单1: 进入班级 -->
                    <div class="clickbox clickapply toapplybox"><span>申请班级博客</span></div>
                    <div class="clickbox clicklogin tologinbox"><span>登录</span></div>
                    <div class="clickbox clicklogin toregisterbox"><span>注册</span></div>
                    <div class="int-banner-more" id="tomore">
                        <p class="int-banner-mask">发现更多</p>
                        <i class="ie-rot45 ani-down-1"></i>
                        <i class="ie-rot45 ani-down-2"></i>
                    </div>
                </div>
            </div>
        	<!-- //首页 -->
            <!-- 申请博客 -->
            <div class="apply ibox" id="applyBox">
                <img class="iboxclose" src="/cblog/img/close.png" />
                <div class="applytxt ibox-title"><h2><span>申请班级博客</span></h2></div>
        		<!-- 表单2: 申请博客 -->
                <form method="post" action="/cblog/admins/register" autocomplete="off">
                    <input type="text" name="username" id="classid" class="login-input" value="" placeholder="管理员用户名">
                    <input type="text" name="" id="classname" class="login-input" value="" placeholder="班级名">
                    <input type="password" name="passwd" id="password" class="login-input" value="" placeholder="管理员密码">
                    <input type="text" name="" id="ccap" class="login-input" value="" placeholder="验证码">
                    <img class="ccap" src="/cblog/img/ccap.png" />
                    <div class="login-button">
                        <button type="submit" class="toapply"><span>申请班级管理员</span></button>
                    </div>
                    <div class="tomore toadminloginbox"><span>已有管理员帐户登录</span></div>
                </form>
        		<!-- //表单2: 申请博客 -->
            </div>
            <!-- //申请博客 -->
            <!-- 用户登录 -->
            <div class="login ibox" id="loginBox">
                <img class="iboxclose" src="/cblog/img/close.png" />
                <div class="logintxt ibox-title"><h2><span>登录</span></h2></div>
        		<!-- 表单3: 用户登录 -->
                <form method="post" action="user.html" autocomplete="off" class="user-form">
                    <input type="text" name="" id="username" class="login-input" value="" placeholder="用户名">
                    <input type="password" name="" id="password" class="login-input" value="" placeholder="密码">
                    <input type="text" name="" id="ccap" class="login-input" value="" placeholder="验证码">
                    <img class="ccap" src="/cblog/img/ccap.png" />
                    <div class="login-button">
                        <button type="button" class="toregister toregisterbox"><span>切换至注册</span></button>
                        <button type="submit" class="tologin"><span>登录</span></button>
                    </div>
                    <div class="tomore toadminloginbox"><span>班级管理员登录</span></div>
                    <div class="tomore"><span>忘记密码</span></div>
                </form>
        		<!-- //表单3: 用户登录 -->
            </div>
            <!-- //用户登录 -->
            <!-- 用户注册 -->
            <div class="register ibox" id="registerBox">
                <img class="iboxclose" src="/cblog/img/close.png" />
                <div class="registertxt ibox-title"><h2><span>注册</span></h2></div>
        		<!-- 表单4: 注册 -->
                <form method="post" action="user.html" autocomplete="off" class="user-form">
                    <input type="text" name="" id="username" class="login-input" value="" placeholder="用户名">
                    <input type="password" name="" id="password" class="login-input" value="" placeholder="密码">
                    <input type="password" name="" id="password2" class="login-input" value="" placeholder="确认密码">
                    <input type="text" name="" id="ccap" class="login-input" value="" placeholder="验证码">
                    <img class="ccap" src="/cblog/img/ccap.png" />
                    <div class="login-button">
                        <button type="submit" class="toregister"><span>注册</span></button>
                        <button type="button" class="tologin tologinbox"><span>切换至登录</span></button>
                    </div>
                    <div class="tomore"><span>忘记密码</span></div>
                </form>
        		<!-- //表单4: 注册 -->
            </div>
            <!-- //用户注册 -->
            <!-- 班级管理员登录 -->
            <div class="adminlogin ibox" id="adminLoginBox">
                <img class="iboxclose" src="/cblog/img/close.png" />
                <div class="admintxt ibox-title"><h2><span>班级管理员登录</span></h2></div>
                <!-- 表单5: 管理登录 -->
                <form method="post" action="admin.html" autocomplete="off">
                    <input type="text" name="" id="username" class="login-input" value="" placeholder="管理员用户名">
                    <input type="password" name="" id="password" class="login-input" value="" placeholder="密码">
                    <input type="text" name="" id="ccap" class="login-input" value="" placeholder="验证码">
                    <img class="ccap" src="/cblog/img/ccap.png" />
                    <div class="login-button">
                        <button type="submit" class="toadminlogin"><span>登录</span></button>
                    </div>
                    <div class="tomore"><span>忘记密码</span></div>
                </form>
                <!-- //表单5: 管理登录 -->
            </div>
            <!-- //班级管理员登录 -->
            <!-- 实时动态 -->
            <div id="moreBox">
                <div class="cblog-menu">
                    <a title="展开/关闭所有"><i class="fa fa-bars"></i></a>
                    <a title="刷新"><i class="fa fa-refresh"></i></a>
                </div>
                <div class="cblog-more">
                    <ul>
                        <li class="cblog-more-box">
                            <div class="more-box-hd"><span class="more-box-bt"></span></div>
                            <a href="class-home.html" target="_blank"><div class="more-box-class">0401308班 <i class="fa fa-rss"></i></div></a>
                            <a href="class-article.html" target="_blank"><p class="more-box-title">学校第十届田径运动会隆重开幕</p></a>
                            <div class="more-box-time">今天 10:10</div>
                            <div class="more-box-bd">
                                <img src="/cblog/img/class/index/img001.jpg" class="more-box-bd-img">
                                <div class="preview">
                                    <p>4月16日上午，伴随着锣鼓喧天，昂扬着澎湃激情，我校第十届田径运动会在太极体育场隆重开幕。校领导方海洋、李银国、游敏惠、符明秋、郑白玲、吕翊、刘宴兵以及老领导聂能、徐仲伟出席开幕式，副校长符明秋主持开幕式。</p>
                                    <p>八点整，伴随着欢快的进行曲，开幕式正式开始。朝气蓬勃的青年学生迈着矫健的步伐，护拥着国旗、校旗、校徽走进体育场。紧接着，裁判员方队、各学院代表队、研究生代表队、教职工代表队喊着嘹亮的口号，踏着稳健的步伐依次入场，展现了重邮人的昂扬斗志。各代表队入场后，全场响起庄严的国歌声，升国旗仪式举行，在全体师生的注目下，国旗迎风飘扬，冉冉升起。</p>
                                    <p>校长李银国在开幕式上致辞，代表学校热烈祝贺第十届田径运动会顺利召开，向为本次运动会付出辛勤努力的老师们和同学们表示衷心感谢。他指出，大学教育致力培养学生们德智体美的全面发展，高校作为国家高层次人才培养的重要基地，师生们的体质与健康事关国家和民族的未来。李银国强调，学校将不断增设和完善体育设施，进一步提高体育活动的组织、管理与服务水平，不断提升全校师生的运动、健康水平。他希望参赛运动员们把赛场当成一个收获的舞台，奋勇拼搏、勇创佳绩。</p>
                                    <p>随后，运动员代表和裁判员代表分别上台进行宣誓。由计算机学院组织编排的腰鼓、啦啦操、红旗方阵等表演气势磅礴，激情昂扬，充分展现出了重邮学子朝气蓬勃的精神面貌以及爱国爱校的情怀。在最后的方阵表演中，他们别出心裁地运用多彩折扇，用红、黄、蓝三种颜色，通过默契的配合，向老师和同学们呈现了能代表学校发展和特色的“中国梦”、“重邮”、“BIG  DATA”、“重邮校徽”、“无线网络”等字样和图案，充分展现出重邮人积极向上，团结共进的拼搏精神，也预示学校的明天将会更加美好。</p>
                                </div>
                            </div>
                        </li>
                        <li class="cblog-more-box">
                            <div class="more-box-hd"><span class="more-box-bt"></span></div>
                            <a href="class-home.html" target="_blank"><div class="more-box-class">0401308班 <i class="fa fa-rss"></i></div></a>
                            <a href="class-article.html" target="_blank"><p class="more-box-title">大学入学</p></a>
                            <div class="more-box-time">2015年5月4日 10:10</div>
                            <div class="more-box-bd">
                                <img src="/cblog/img/class/index/img000.jpg" class="more-box-bd-img">
                                <div class="preview">
                                    <p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
                                    <p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
                                    <p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
                                    <p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
                                    <p>同学们，相逢即是缘！</p>
                                </div>
                            </div>
                        </li>
                        <li class="cblog-more-box">
                            <div class="more-box-hd"><span class="more-box-bt"></span></div>
                            <a href="class-home.html" target="_blank"><div class="more-box-class">0401308班 <i class="fa fa-rss"></i></div></a>
                            <a href="class-article.html" target="_blank"><p class="more-box-title">学校第十届田径运动会隆重开幕</p></a>
                            <div class="more-box-time">今天 10:10</div>
                            <div class="more-box-bd">
                                <img src="/cblog/img/class/index/img001.jpg" class="more-box-bd-img">
                                <div class="preview">
                                    <p>4月16日上午，伴随着锣鼓喧天，昂扬着澎湃激情，我校第十届田径运动会在太极体育场隆重开幕。校领导方海洋、李银国、游敏惠、符明秋、郑白玲、吕翊、刘宴兵以及老领导聂能、徐仲伟出席开幕式，副校长符明秋主持开幕式。</p>
                                    <p>八点整，伴随着欢快的进行曲，开幕式正式开始。朝气蓬勃的青年学生迈着矫健的步伐，护拥着国旗、校旗、校徽走进体育场。紧接着，裁判员方队、各学院代表队、研究生代表队、教职工代表队喊着嘹亮的口号，踏着稳健的步伐依次入场，展现了重邮人的昂扬斗志。各代表队入场后，全场响起庄严的国歌声，升国旗仪式举行，在全体师生的注目下，国旗迎风飘扬，冉冉升起。</p>
                                    <p>校长李银国在开幕式上致辞，代表学校热烈祝贺第十届田径运动会顺利召开，向为本次运动会付出辛勤努力的老师们和同学们表示衷心感谢。他指出，大学教育致力培养学生们德智体美的全面发展，高校作为国家高层次人才培养的重要基地，师生们的体质与健康事关国家和民族的未来。李银国强调，学校将不断增设和完善体育设施，进一步提高体育活动的组织、管理与服务水平，不断提升全校师生的运动、健康水平。他希望参赛运动员们把赛场当成一个收获的舞台，奋勇拼搏、勇创佳绩。</p>
                                    <p>随后，运动员代表和裁判员代表分别上台进行宣誓。由计算机学院组织编排的腰鼓、啦啦操、红旗方阵等表演气势磅礴，激情昂扬，充分展现出了重邮学子朝气蓬勃的精神面貌以及爱国爱校的情怀。在最后的方阵表演中，他们别出心裁地运用多彩折扇，用红、黄、蓝三种颜色，通过默契的配合，向老师和同学们呈现了能代表学校发展和特色的“中国梦”、“重邮”、“BIG  DATA”、“重邮校徽”、“无线网络”等字样和图案，充分展现出重邮人积极向上，团结共进的拼搏精神，也预示学校的明天将会更加美好。</p>
                                </div>
                            </div>
                        </li>
                        <li class="cblog-more-box">
                            <div class="more-box-hd"><span class="more-box-bt"></span></div>
                            <a href="class-home.html" target="_blank"><div class="more-box-class">0401308班 <i class="fa fa-rss"></i></div></a>
                            <a href="class-article.html" target="_blank"><p class="more-box-title">大学入学</p></a>
                            <div class="more-box-time">2015年5月4日 10:10</div>
                            <div class="more-box-bd">
                                <img src="/cblog/img/class/index/img000.jpg" class="more-box-bd-img">
                                <div class="preview">
                                    <p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
                                    <p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
                                    <p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
                                    <p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
                                    <p>同学们，相逢即是缘！</p>
                                </div>
                            </div>
                        </li>
                        <li class="cblog-more-box">
                            <div class="more-box-hd"><span class="more-box-bt"></span></div>
                            <a href="class-home.html" target="_blank"><div class="more-box-class">0401308班 <i class="fa fa-rss"></i></div></a>
                            <a href="class-article.html" target="_blank"><p class="more-box-title">学校第十届田径运动会隆重开幕</p></a>
                            <div class="more-box-time">今天 10:10</div>
                            <div class="more-box-bd">
                                <img src="/cblog/img/class/index/img001.jpg" class="more-box-bd-img">
                                <div class="preview">
                                    <p>4月16日上午，伴随着锣鼓喧天，昂扬着澎湃激情，我校第十届田径运动会在太极体育场隆重开幕。校领导方海洋、李银国、游敏惠、符明秋、郑白玲、吕翊、刘宴兵以及老领导聂能、徐仲伟出席开幕式，副校长符明秋主持开幕式。</p>
                                    <p>八点整，伴随着欢快的进行曲，开幕式正式开始。朝气蓬勃的青年学生迈着矫健的步伐，护拥着国旗、校旗、校徽走进体育场。紧接着，裁判员方队、各学院代表队、研究生代表队、教职工代表队喊着嘹亮的口号，踏着稳健的步伐依次入场，展现了重邮人的昂扬斗志。各代表队入场后，全场响起庄严的国歌声，升国旗仪式举行，在全体师生的注目下，国旗迎风飘扬，冉冉升起。</p>
                                    <p>校长李银国在开幕式上致辞，代表学校热烈祝贺第十届田径运动会顺利召开，向为本次运动会付出辛勤努力的老师们和同学们表示衷心感谢。他指出，大学教育致力培养学生们德智体美的全面发展，高校作为国家高层次人才培养的重要基地，师生们的体质与健康事关国家和民族的未来。李银国强调，学校将不断增设和完善体育设施，进一步提高体育活动的组织、管理与服务水平，不断提升全校师生的运动、健康水平。他希望参赛运动员们把赛场当成一个收获的舞台，奋勇拼搏、勇创佳绩。</p>
                                    <p>随后，运动员代表和裁判员代表分别上台进行宣誓。由计算机学院组织编排的腰鼓、啦啦操、红旗方阵等表演气势磅礴，激情昂扬，充分展现出了重邮学子朝气蓬勃的精神面貌以及爱国爱校的情怀。在最后的方阵表演中，他们别出心裁地运用多彩折扇，用红、黄、蓝三种颜色，通过默契的配合，向老师和同学们呈现了能代表学校发展和特色的“中国梦”、“重邮”、“BIG  DATA”、“重邮校徽”、“无线网络”等字样和图案，充分展现出重邮人积极向上，团结共进的拼搏精神，也预示学校的明天将会更加美好。</p>
                                </div>
                            </div>
                        </li>
                        <li class="cblog-more-box">
                            <div class="more-box-hd"><span class="more-box-bt"></span></div>
                            <a href="class-home.html" target="_blank"><div class="more-box-class">0401308班 <i class="fa fa-rss"></i></div></a>
                            <a href="class-article.html" target="_blank"><p class="more-box-title">大学入学</p></a>
                            <div class="more-box-time">2015年5月4日 10:10</div>
                            <div class="more-box-bd">
                                <img src="/cblog/img/class/index/img000.jpg" class="more-box-bd-img">
                                <div class="preview">
                                    <p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
                                    <p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
                                    <p>在拼搏的黑色六月之后，在一万次梦里的憧憬之后，怀着渐渐成熟的生命里缤纷的梦想，怀着敢闯敢拼的青春里倔强的执着，我们热情洋溢，我们相逢于0401308班。</p>
                                    <p>大学是一个新的起点，我们都对大学有着无限憧憬。但当务之急是要迅速进入角色，适应新的生活。大学生活是宽松与自主并存的新环境，只要不懈怠、不退缩，保持学习冲劲、学习独立思考和生活、维持良好的人际关系，就能为美好的梦打下基础。班级，就是这个梦开始的地方！</p>
                                    <p>同学们，相逢即是缘！</p>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        	<!-- //实时动态 -->
        </div>
        <a href="http://bing.com" target="_blank"><div id="from_bing">bing每日壁纸</div></a>
        <div id="about">
            <a href="aboutus.html">© cBlog</a>
        </div>
        <!-- script -->
        <script src="/cblog/js/jquery.min.js" type="text/javascript"></script>
        <script src="/cblog/js/smoothscroll.js" type="text/javascript"></script>
        <script type="text/javascript" charset="utf-8">
        $(function(){
            var logoimg = $("#logo");
            var iboxclose = $(".iboxclose");
            var tomore = $("#tomore");
            var toapplybox = $(".toapplybox");
            var tologinbox = $(".tologinbox");
            var toregisterbox = $(".toregisterbox");
            var toadminloginbox = $(".toadminloginbox");
            logoimg.click(function(){
                showBox.showMainBox();
            });
            iboxclose.click(function(){
                showBox.showMainBox();
            });
            toapplybox.click(function(){
                showBox.showApplyBox();
            });
            tologinbox.click(function(){
                showBox.showLoginBox();
            });
            toregisterbox.click(function(){
                showBox.showRegisterBox();
            });
            toadminloginbox.click(function(){
                showBox.showAdminLoginBox();
            });
            tomore.click(function(){
                showBox.showMoreBox();
            });
            var logobox = $(".logo");
            var logotxt = $(".logo h1");
            var showBox = {
                showMainBox: function(){
                    toggleBox({"mainBox": 1});
                    logobox.stop(true).animate({top: "50px", marginTop: "0px"},500);
                    logoimg.stop(true).animate({width: "400px"},500);
                    logotxt.stop(true).animate({fontSize: "30px"},500);
                    logotxt.text("班级博客系统");
                },
                showApplyBox: function(){
                    toggleBox({"applyBox": 1});
                    logobox.stop(true).animate({top: "0px"},500);
                    logoimg.stop(true).animate({width: "250px"},500);
                    logotxt.stop(true).animate({fontSize: "16px"},500);
                },
                showLoginBox: function(){
                    toggleBox({"loginBox": 1});
                    logobox.stop(true).animate({top: "0px"},500);
                    logoimg.stop(true).animate({width: "250px"},500);
                    logotxt.stop(true).animate({fontSize: "16px"},500);
                },
                showRegisterBox: function(){
                    toggleBox({"registerBox": 1});
                    logobox.stop(true).animate({top: "0px"},500);
                    logoimg.stop(true).animate({width: "250px"},500);
                    logotxt.stop(true).animate({fontSize: "16px"},500);
                },
                showAdminLoginBox: function(){
                    toggleBox({"adminLoginBox": 1});
                    logobox.stop(true).animate({top: "0px"},500);
                    logoimg.stop(true).animate({width: "250px"},500);
                    logotxt.stop(true).animate({fontSize: "16px"},500);
                },
                showMoreBox: function(){
                    toggleBox({"moreBox": 1});
                    logobox.stop(true).animate({top: "0px", marginTop: "-70px"},750);
                    logoimg.stop(true).animate({width: "150px"},750);
                    logotxt.stop(true).animate({fontSize: "14px"},750);
                    logotxt.text("班级动态");
                }
            };
            var hash = window.location.hash;
            switch (hash){
                case "#apply":
                    showBox.showApplyBox();
                    break;
                case "#login":
                    showBox.showLoginBox();
                    break;
                case "#register":
                    showBox.showRegisterBox();
                    break;
                case "#adminlogin":
                    showBox.showAdminLoginBox();
                    break;
                default:
                    showBox.showMainBox();
            }
            /* whichBox对象:
             * 键为mainBox, applyBox, loginBox, registerBox, adminLoginBox, moreBox
             * 值为1则表示出现, 0表示隐藏
             * */
            function toggleBox(whichBox){
                var settingBox = function(which){
                    return whichBox[which]?whichBox[which]:0;
                };
                var Boxs = {
                    "mainBox": "fade",
                    "applyBox": "slide",
                    "loginBox": "slide",
                    "registerBox": "slide",
                    "adminLoginBox": "slide",
                    "moreBox": "fade"
                };
                var BoxStatus = {};
                $.each(Boxs, function(i, e){
                    BoxStatus[i] = settingBox(i);
                });
                for(var i in Boxs){
                    if(Boxs.hasOwnProperty(i)){
                        if(BoxStatus[i] && Boxs[i]=="fade"){
                            $('#'+ i).fadeIn(500);
                        }else if((!BoxStatus[i]) && Boxs[i]=="fade"){
                            $('#'+ i).fadeOut(300);
                        }else if(BoxStatus[i] && Boxs[i]=="slide"){
                            $('#'+ i).slideDown(500);
                        }else if((!BoxStatus[i]) && Boxs[i]=="slide"){
                            $('#'+ i).slideUp(300);
                        }
                    }
                }
            }
        });

        $(function(){
            var moreboxhd = $(".more-box-hd");
            var moreboxbd = $(".more-box-bd");
            moreboxhd.click(function(){
                $(this).siblings(".more-box-bd").stop(true).slideToggle(750);
            });
            var morebars = $(".fa-bars");
            var morerefresh = $(".fa-refresh");
            morebars.click(function(){
                moreboxbd.stop(true).slideToggle(750);
            });
            morerefresh.click(function(){
                $(this).addClass("fa-spin");
            });
        });
        $(function(){
        $('.search').bind({
        focus:function(){
        if (this.value == this.defaultValue){
        this.value="";
        }
        },
        blur:function(){
        if (this.value == ""){
        this.value = this.defaultValue;
        }
        }
        });
        })
        $(function(){
        	var o = $("#wallpaper");
	        o.error(function(){
	        	$(this).attr("src", "img/bg.jpg");
	        });
        });
        </script>
    </body>
</html>