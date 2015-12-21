<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> /
                <small>admin</small>
            </div>
        </div>

        <ul class="am-avg-sm-1 am-avg-md-5 am-margin am-padding am-text-center admin-content-list ">
            <li><a href="/cblog/articles/admin-article" class="am-text-secondary"><span
                    class="am-icon-btn am-icon-file-text"></span><br/>班级文章<br/>${fn:length(clazz.articles) }</a></li>
            <li><a href="/cblog/albums/admin-album" class="am-text-success"><span class="am-icon-btn am-icon-th"></span><br/>班级照片<br/>${fn:length(clazz.albums) }</a>
            </li>
            <li><a href="/cblog/students/admin-members" class="am-text-warning"><span
                    class="am-icon-btn am-icon-users"></span><br/>班级成员<br/>${fn:length(clazz.students) }</a></li>
            <li><a class="am-text-danger am-text-warning"><span class="am-icon-btn am-icon-copy"></span><br/>总评论数<br/>${fn:length(clazz.albums) }</a>
            </li>
            <li><a class="am-text-warning"><span class="am-icon-btn am-icon-recycle"></span><br/>访问量<br/>2333</a></li>
        </ul>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
          <a href="admin-article-edit.html"><div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 发表新文章</button>
          </div></a>
        </div>
      </div>
      <div class="am-u-sm-12 am-u-md-3">
        <div class="am-input-group am-input-group-sm">
          <input type="text" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
        </div>
      </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
		  <!-- 文章列表 -->
          <table class="am-table am-table-striped am-table-hover table-main">
           <thead>
              <tr>
                <th class="table-id">ID</th><th class="table-adate am-hide-sm-only">活动日期</th><th class="table-pdate am-hide-sm-only">发表时间</th><th class="table-title">标题</th><th class="table-set">操作</th>
              </tr>
          </thead>
              <tbody class="admin-article-list"></tbody>
        </table>
          <div id="admin-article-pagination">
              <p class="am-fl am-margin-left">第 <span class="am-pagination-indexpage">1</span> / <span class="am-pagination-totalpage">1</span> 页</p>
              <ol class="am-pagination am-fr">
              </ol>
          </div>
        </form>
      </div>

    </div>

<!-- 文章讨论框 -->
      <div class="am-popup" id="article-discuss">
       <div class="am-popup-inner discuss-bd">
         <div class="am-popup-hd">
        <h4 class="am-popup-title">文章评论</h4>
        <span data-am-modal-close
              class="am-close">&times;</span>
      </div>
      <div class="am-popup-bd" id="article-discuss-bd">
        <div class="am-panel-bd am-collapse am-in am-cf">
        <h3 class="article-discuss-title"><a href="class-article.html" target="_blank">学校第十届田径运动会隆重开幕</a></h3>
            <ul class="am-comments-list admin-content-comment">
              <li class="am-comment">
                <a href="#"><img src="../img/class/members/1.jpg" alt="" class="am-comment-avatar" id="article-discuss-user-logo"></a>
                <div class="am-comment-main">
                  <header class="am-comment-hd">
                    <div class="am-comment-meta"><a class="am-comment-author">闵聪</a> 评论于 <time>2014-7-12 15:30</time></div>
                    <div class="am-fr">
                    <button type="button" class="am-btn am-btn-default admin-article-discuss-sc">删除</button>
                    </div>
                  </header>
                  <div class="am-comment-bd"><p>棒棒哒</p>
                  </div>          
                </div>
              </li>
            </ul>
            <hr/>
          </div>
      </div>
    </div>
  </div>

  </div>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">Copyright © 2015 <a href="index.html" target="_blank">cBlog.</a></p>
</footer>
<!-- handlebars -->
<script id="admin-article-item" type="text/x-handlebars-template">
    {{#articles}}
    <tr>
        <td>{{tableId ../page @index}}</td>
        <td class="am-hide-sm-only">{{activityDate}}</td>
        <td class="am-hide-sm-only">{{publishDate}}</td>
        <td><a href="class-article.html" target="_blank">{{title}}</a></td>
        <td>
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                    <div class="am-btn am-btn-default am-btn-xs am-hide-sm-only article-discuss-openbutton" data-am-modal="{target: '#article-discuss'}"><span class="am-icon-copy"></span> 展开评论 （<span>1</span>）</div>
                </div>
            </div>
        </td>
    </tr>
    {{/articles}}
</script>
<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>
<script type="text/javascript" src="../js/handlebars.js"></script>
<script type="text/javascript">
$(function(){
    var clazzName = "${clazz.clazzName }";
    $.ajax({
        type: "POST",
        url: "/cblog/articles/list",
        dataType: "json",
        data: {
            "clazzName": clazzName
        },
        success: function(data){
            Handlebars.registerHelper('tableId', function(page, index) {
                return (page-1) * 15 + index + 1;
            });
            showItem("admin-article", data);
            get_pagination("admin-article", data.page, data.maxPage, this.url, clazzName);
        }
    });
});
</script>
</body>
</html>
