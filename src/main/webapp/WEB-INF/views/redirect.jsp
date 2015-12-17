<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>正在跳转</title>
    <link rel="stylesheet" href="../css/amazeui.min.css"/>
</head>
<body>
    <h2>${message }，正在跳转至<a id="redirect" href="${url }">${redirectPage }</a></h2>
    <script>
        var src = document.getElementById("redirect").href;
        var h2 = document.getElementsByTagName("h2")[0];
        setTimeout(function(){
            h2.innerHTML += ".";
        }, 500);
        setTimeout(function(){
            h2.innerHTML += ".";
        }, 1500);
        setTimeout(function(){
            h2.innerHTML += ".";
        }, 2500);
        setTimeout(function(){
            window.location.href = src;
        }, 3000);
    </script>
</body>
</html>