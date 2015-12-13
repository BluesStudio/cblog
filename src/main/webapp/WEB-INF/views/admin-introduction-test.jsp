<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/cblog/clazzs/mergeOverview" enctype="multipart/form-data">
	overview:<input type="text" name="overview"/><br/>
	clazzImg:<input type="file" name="clazzImg"/><br/>
	<input type="submit"/><br/>
</form>
<form method="POST" action="/cblog/clazzs/mergeSlogan">
	slogan:<input type="text" name="slogan"/><br/>
	<input type="submit"/><br/>
</form>
<form method="POST" action="/cblog/clazzs/mergeFlagImg" enctype="multipart/form-data">
	flagImg:<input type="file" name="flagImg"/><br/>
	<input type="submit"/><br/>
</form>
<form method="POST" action="/cblog/clazzs/mergeSong" enctype="multipart/form-data">
	songTitle:<input type="text" name="songTitle"/><br/>
	lyric:<input type="text" name="lyric"/><br/>
	song:<input type="text" name="song"/><br/>
	songFile:<input type="file" name="songFile"/><br/>
	<input type="submit"/><br/>
</form>

</body>
</html>