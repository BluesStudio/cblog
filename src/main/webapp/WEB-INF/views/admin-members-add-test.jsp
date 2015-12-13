<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form method="POST" action="/cblog/students/create">
	 <input name="stuImg" value="dee92e78883240bf8f57467df4c8da30.png"/>
	 <input type="text" id="user-name" placeholder="输入学生姓名 / Name" name="stuName">
	 <input type="text" id="user-id" placeholder="输入学生学号 / Id" name="stuId">
	 <input type="text" id="user-age" placeholder="输入学生年龄 / Age" name="age">
	 <input type="text" id="user-age" placeholder="输入学生性别 / Gender" name="gender">
	 <input type="text" id="user-age" placeholder="输入学生座右铭/ Motto" name="motto">
	 <input type="submit">
 </form>
</body>
</html>