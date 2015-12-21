<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>cBlog-用户个人中心</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/cblog/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/cblog/css/admin-style.css">
  <link rel="stylesheet" href="/cblog/css/admin.css">
  <link rel="stylesheet" href="/cblog/css/user-style.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <a href="/cblog/blogUsers/index" target="_blank"><strong>cBlog</strong></a> <small>用户个人中心</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="user-so-li">
          <form>
          <input type="text" class="user-so" placeholder="搜索班级进入主页">
          <button type="submit" class="user-so-btn"><span class="am-icon-search"></span></button>
          </form>
      </li>
      <li><a href="/cblog/clazzs/class-home/${blogUser.student.clazz.clazzName }" target="_blank"><span class="am-icon-home"></span> 进入本班博客 </a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-user"></span> ${blogUser.student.stuName } <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="/cblog/blogUsers/user-setting"><span class="am-icon-cog"></span> 更多设置</a></li>
          <li><a href="/cblog/blogUsers/logout"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li class="admin-sidebar-list-hover"><a href="/cblog/blogUsers/index"><span class="am-icon-home"></span> 首页<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
      <li><a href="/cblog/blogUsers/user-setting"><span class="am-icon-cog"></span> 更多设置</a></li>
      <li><a href="/cblog/blogUsers/logout"><span class="am-icon-sign-out"></span> 退出</a></li>
    </ul>
    
    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 基本信息</p>
        <p>用户名：${blogUser.student.stuName }<br>
        姓名：${blogUser.student.stuName }<br>
        所在班级：${blogUser.student.clazz.clazzName }班<a href="/cblog/blogUsers/user-setting"> 修改</a></p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-volume-down"></span> 系统公告</p>
        <p>cBlog：班级博客系统</p>
      </div>
    </div>
    
    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> ©cBlog <a href="/cblog/aboutUs" target="_blank" class="am-panel-bd-aboutus">关于我们</a></p>
        <p>网站设计与前端开发：闵聪<br>网站后台开发：高小飞<br>安卓移动端开发：王春河</p>
      </div>
    </div>
    
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>admin</small></div>
    </div>
    <div class="am-cf am-margin am-padding admin-content-list user-box">
      <a class="am-btn am-btn-primary user-change-btn" href="/cblog/blogUsers/user-setting">修改</a>
      <h2 class="user-title">个人信息</h2>
      <div class="am-u-md-2 user-logo">
      <img class="am-img-thumbnail" src="http://xiaofeig.image.alimmdn.com/cblog/${blogUser.student.stuImg==null? 'ea4398e5806943f487c67b28c1f3e6d5.png':blogUser.student.stuImg }">
      </div>
      <div class="am-u-md-3">
        <div class="am-input-group user-group">
            <label class="am-input-group-label">姓名</label>
             <span class="user-m">${blogUser.student.stuName }</span>
        </div>
        <div class="am-input-group user-group">
            <label class="am-input-group-label">用户名</label>
             <span class="user-n">${blogUser.username }</span>
        </div>
      </div>
      <div class="am-u-md-3">
        <div class="am-input-group user-group">
            <label class="am-input-group-label">性别</label>
             <span class="user-m">${blogUser.student.gender }</span>
        </div>
        <div class="am-input-group user-group">
            <label class="am-input-group-label">班级</label>
            <c:if test="${blogUser.student.clazz==null }">
            	<span class="user-n"></span>
            </c:if>
            <c:if test="${blogUser.student.clazz!=null }">
            	<span class="user-n">${blogUser.student.clazz.clazzName }班</span>
            </c:if>
        </div>
      </div>
      <div class="am-u-md-4">
        <div class="am-input-group user-group">
            <label class="am-input-group-label">年龄</label>
             <span class="user-m">${blogUser.student.age }</span>
        </div>
        <div class="am-input-group user-group">
            <label class="am-input-group-label">学号</label>
             <span class="user-m">${blogUser.student.stuId }</span>
        </div>
      </div>
      <div class="am-u-md-10">
        <div class="am-input-group user-group">
            <label class="am-input-group-label">座右铭</label>
             <span class="user-m">${blogUser.student.motto }</span>
        </div>
      </div>
    </div>
    <hr/>

    <h2 class="user-title">我的评论</h2>
    <ul class="am-list am-avg-sm-2 am-margin user-discuss">
     <li>
     <div class="am-padding">
        <div class="admin-task-meta"><span class="am-icon-pencil-square-o am-text-lg"></span> 我对 <a href="class-home.html">0422222班</a> 的 <a><span class="am-icon-photo"></span> 2015.5.22</a> 评论：</div>
        <div class="admin-task-bd user-discuss-text">
          <p>青春是一场远行，回不去了；青春是一场相逢，忘不掉了；青春是一场伤痛，来不及了。</p>
        </div>
        <div class="am-cf am-margin-top">
          <div class="am-btn-toolbar am-fr">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default user-discuss-editok"><span class="am-icon-check"></span> 保存</button>
              <button type="button" class="am-btn am-btn-default user-discuss-edit"><span class="am-icon-pencil"></span> 编辑</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-times"></span> 删除</button>
            </div>
          </div>
        </div>
        </div>
      </li>
      <li>
     <div class="am-padding">
        <div class="admin-task-meta"><span class="am-icon-pencil-square-o am-text-lg"></span> 我对 <a href="class-home.html">0422222班</a> 的 <a><span class="am-icon-file-text"></span> 计算机学院院运动会</a> 评论：</div>
        <div class="admin-task-bd user-discuss-text">
          <p>棒棒哒</p>
        </div>
        <div class="am-cf am-margin-top">
          <div class="am-btn-toolbar am-fr">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default user-discuss-editok"><span class="am-icon-check"></span> 保存</button>
              <button type="button" class="am-btn am-btn-default user-discuss-edit"><span class="am-icon-pencil"></span> 编辑</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-times"></span> 删除</button>
            </div>
          </div>
        </div>
        </div>
      </li>
      <li>
      <div class="am-padding">
        <div class="admin-task-meta"><span class="am-icon-pencil-square-o am-text-lg"></span> 我对 <a href="class-home.html">0401308班</a> 的 <a><span class="am-icon-user"></span> 闵聪</a> 评论：</div>
        <div class="admin-task-bd user-discuss-text">
          <p>帅气</p>
        </div>
        <div class="am-cf am-margin-top">
          <div class="am-btn-toolbar am-fr">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default user-discuss-editok"><span class="am-icon-check"></span> 保存</button>
              <button type="button" class="am-btn am-btn-default user-discuss-edit"><span class="am-icon-pencil"></span> 编辑</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-times"></span> 删除</button>
            </div>
          </div>
        </div>
        </div>
      </li>


    </ul>
    <hr/>
  </div>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">Copyright © 2015 <a href="/cblog/index" target="_blank">cBlog.</a></p>
</footer>

<script src="/cblog/js/jquery.min.js"></script>
<script src="/cblog/js/amazeui.min.js"></script>
<script src="/cblog/js/app.js"></script>
<script>
  $(function(){
    var userdiscusseditok = $(".user-discuss-editok");
    var userdiscussedit = $(".user-discuss-edit");
    userdiscussedit.click(function(){
      var userdiscusstextp = $(this).parents("li").find(".user-discuss-text p");
      userdiscusstextp.replaceWith('<textarea>'+ userdiscusstextp.html() +'</textarea>');
      $(this).hide();
      $(this).siblings(".user-discuss-editok").show(); 
    });
    userdiscusseditok.click(function(){
      var userdiscusstextarea = $(this).parents("li").find(".user-discuss-text textarea");
      userdiscusstextarea.replaceWith('<p>'+ userdiscusstextarea.html() +'</p>');
      $(this).hide();
      $(this).siblings(".user-discuss-edit").show(); 
    });
  });
</script>
</body>
</html>
