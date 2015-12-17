<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="12;url=/cblog/index">
<title>404错误页面</title>
<style>
body, div {
    margin: 0;
    padding: 0;
}
body {
    background: url("http://congmin.qiniudn.com/congmin/img/error_bg.jpg") repeat-x fixed 0 0 #67ACE4;
    overflow:hidden;
}
#container {
    margin: 0 auto;
    padding-top: 50px;
    text-align: center;
    width: 560px;
}
.png2{
	margin: 50px;
}
.png3{
	margin: 0px;
}
#cloud {
    background: url("http://congmin.qiniudn.com/congmin/img/error_cloud.png") repeat-x fixed bottom center transparent;
    bottom: 0;
    height: 170px;
    position: absolute;
    width: 100%;
}
</style>
<body>
<div id="container">
	<img class="png1" src="http://congmin.qiniudn.com/congmin/img/404.png" title="Image: http://congmin.qiniudn.com/congmin/img/404.png"><br>
	<img class="png2" src="http://congmin.qiniudn.com/congmin/img/404_msg.png"><br>
	<a href="/cblog/index"><img class="png3" src="http://congmin.qiniudn.com/congmin/img/404_to_index.png"></a>
</div>
<div id="cloud" class="png"></div>
</body>
</html>