<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>cBlog-后台管理-${clazz.clazzName }班</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/cblog/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/cblog/css/admin-style.css">
  <link rel="stylesheet" href="/cblog/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <a href="/cblog/index" target="_blank"><strong>cBlog</strong></a>
        <small>班级博客后台管理</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li><a><span class="am-icon-star"></span> ${clazz.clazzName }班 </a></li>
            <li><a href="/cblog/clazzs/clazzIntroduction/${admin.clazz.clazzName}" target="_blank"><span class="am-icon-home"></span> 进入博客主页 </a></li>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-user"></span> ${username } <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="/cblog/clazzs/admin-setting"><span class="am-icon-cog"></span> 更多设置</a></li>
                    <li><a href="/cblog/admins/logout"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar">
        <ul class="am-list admin-sidebar-list">
            <li class="admin-sidebar-list-hover"><a href="/cblog/index"><span class="am-icon-home"></span> 首页<span
                    class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 班级文章管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                    <li><a href="/cblog/articles/admin-article"><span class="am-icon-calendar"></span> 文章列表<span
                            class="am-badge am-badge-secondary am-margin-right am-fr">${fn:length(clazz.articles) }</span></a></li>
                    <li><a href="/cblog/articles/create"><span class="am-icon-pencil-square-o"></span> 写文章</a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-th"></span> 班级相册管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                    <li><a href="/cblog/albums/admin-album"><span class="am-icon-calendar"></span> 照片列表<span
                            class="am-badge am-badge-success am-margin-right am-fr">${fn:length(clazz.albums) }</span></a></li>
                    <li><a href="/cblog/albums/create"><span class="am-icon-upload"></span> 上传照片</a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-users"></span>
                    班级成员管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
                    <li><a href="/cblog/students/admin-members"><span class="am-icon-calendar"></span> 成员列表<span
                            class="am-badge am-badge-warning am-margin-right am-fr">${fn:length(clazz.students) }</span></a></li>
                    <li><a href="/cblog/students/create"><span class="am-icon-plus"></span> 添加成员</a></li>
                    <li><a href="/cblog/userRequests/admin-members-apply"><span class="am-icon-user-md"></span> 绑定申请核实<span
                            class="am-badge am-badge-danger am-margin-right am-fr am-round">+${userRequests_size }</span></a></li>
                </ul>
            </li>
            <li><a href="/cblog/clazzs/admin-introduction"><span class="am-icon-check"></span> 班级简介管理</a></li>
            <li><a href="/cblog/clazzs/admin-setting"><span class="am-icon-cog"></span> 更多设置</a></li>
            <li><a href="/cblog/admins/logout"><span class="am-icon-sign-out"></span> 退出</a></li>
        </ul>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-bookmark"></span> 系统公告</p>

                <p>cBlog：班级博客系统</p>
            </div>
        </div>


        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-tag"></span> ©cBlog <a href="/cblog/aboutUs" target="_blank"
                                                               class="am-panel-bd-aboutus">关于我们</a></p>

                <p>网站设计与前端开发：闵聪<br>网站后台开发：高小飞<br>安卓移动端开发：王春河</p>
            </div>
        </div>

    </div>
    <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">申请核实</strong> / <small>apply</small></div>
    </div>
    <div class="am-u-sm-12">
    <table class="am-table am-table-striped am-table-hover table-main">
       <thead>
          <tr>
            <th class="table-id">ID</th><th class="table-username">用户名</th><th class="table-username">学号</th><th class="table-name">姓名</th><th class="table-why am-hide-sm-only">理由</th><th class="table-set">操作</th>
          </tr>
      </thead>
      <tbody>
	    <c:set var="count" value="1"></c:set>
		<c:forEach items="${userRequests }" var="userRequest">
		<tr>
          <td>${count }</td>
          <td>${userRequest.blogUser.username }</td>
          <td class="am-hide-sm-only">${userRequest.stuId }</td>
          <td class="am-hide-sm-only">${userRequest.stuName }</td>
          <td>${userRequest.reason }</td>
          <td>
            <div class="am-btn-toolbar">
              <div class="am-btn-group am-btn-group-xs">
              <c:if test="${userRequest.dispose=='unresolved' }">
                <a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="/cblog/userRequests/update?dispose=agreed&userRequestId=${userRequest.id }"><span class="am-icon-check"></span> 同意</a>
                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" href="/cblog//userRequests/update?dispose=disagreed&userRequestId=${userRequest.id }"><span class="am-icon-trash-o"></span> 驳回</a>
                </c:if>
                <c:if test="${userRequest.dispose=='agreed' }">
                <a class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-check"></span> 已同意</a>
                </c:if>
                <c:if test="${userRequest.dispose=='disagreed' }">
                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 已驳回</a>
                </c:if>
              </div>
            </div>
          </td>
          <div>	
          </div>
        </tr>
        <c:set var="count" value="${count+1 }"/>
		</c:forEach>
        <!-- 
        <tr>
          <td>2</td>
          <td>wenhui</td>
          <td class="am-hide-sm-only">2013211649</td>
          <td class="am-hide-sm-only">文慧</td>
          <td>我是文明慧</td>
          <td>
            <div class="am-btn-toolbar">
              <div class="am-btn-group am-btn-group-xs">
                <a class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-check"></span> 同意</a>
                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 驳回</a>
              </div>
            </div>
          </td>
          <div>	
          </div>
        </tr>
         -->
        </tbody>
      </table><hr>
     </div>
 	
  </div>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">Copyright © 2015 <a href="index.html" target="_blank">cBlog.</a></p>
</footer>

<script src="/cblog/js/jquery.min.js"></script>
<script src="/cblog/js/amazeui.min.js"></script>
<script src="/cblog/js/app.js"></script>
</body>
</html>
