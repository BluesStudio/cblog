<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>cBlog-后台管理-0401308班</title>
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
    <a href="index.html" target="_blank"><strong>cBlog</strong></a> <small>班级博客后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
    <li><a><span class="am-icon-star"></span> 0401308班 </a></li>
      <li><a href="class-home.html" target="_blank"><span class="am-icon-home"></span> 进入博客主页 </a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-user"></span> mcc108 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="admin-setting.html"><span class="am-icon-cog"></span> 更多设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
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
      <li><a href="admin.html"><span class="am-icon-home"></span> 首页<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 班级文章管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
          <li><a href="admin-article.html"><span class="am-icon-calendar"></span> 文章列表<span class="am-badge am-badge-secondary am-margin-right am-fr">13</span></a></li>
          <li><a href="admin-article-edit.html"><span class="am-icon-pencil-square-o"></span> 写文章</a></li>
        </ul>
      </li>
      <li class="admin-parent">
      <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-th"></span> 班级相册管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
      	<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
          <li class="admin-sidebar-list-hover"><a href="admin-album.html"><span class="am-icon-calendar"></span> 照片列表<span class="am-badge am-badge-success am-margin-right am-fr">45</span></a></li>
          <li><a href="admin-album-upload.html"><span class="am-icon-upload"></span> 上传照片</a></li>
        </ul>
      </li>
      <li class="admin-parent">
      <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-users"></span> 班级成员管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="admin-members.html"><span class="am-icon-calendar"></span> 成员列表<span class="am-badge am-badge-warning am-margin-right am-fr">27</span></a></li>
          <li><a href="admin-members-add.html"><span class="am-icon-plus"></span> 添加成员</a></li>
          <li><a href="admin-members-apply.html"><span class="am-icon-user-md"></span> 绑定申请核实<span class="am-badge am-badge-danger am-margin-right am-fr am-round">+2</span></a></li>
        </ul>
      </li>
      <li><a href="admin-introduction.html"><span class="am-icon-check"></span> 班级简介管理</a></li>
      <li><a href="admin-setting.html"><span class="am-icon-cog"></span> 更多设置</a></li>
      <li><a href="#"><span class="am-icon-sign-out"></span> 退出</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 系统公告</p>
        <p>cBlog：班级博客系统</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> ©cBlog <a href="aboutus.html" target="_blank" class="am-panel-bd-aboutus">关于我们</a></p>
        <p>网站设计与前端开发：闵聪<br>网站后台开发：高小飞<br>安卓移动端开发：王春河</p>
      </div>
    </div>
    
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">班级相册</strong> / <small>album</small></div>
    </div>
    
    <ul class="am-avg-sm-1 am-avg-md-5 am-margin am-padding am-text-center admin-content-list ">
      <li><a href="admin-article.html" class="am-text-secondary"><span class="am-icon-btn am-icon-file-text"></span><br/>班级文章<br/>13</a></li>
      <li><a href="admin-album.html" class="am-text-success"><span class="am-icon-btn am-icon-th"></span><br/>班级照片<br/>45</a></li>
      <li><a href="admin-members.html" class="am-text-warning"><span class="am-icon-btn am-icon-users"></span><br/>班级成员<br/>27</a></li>
      <li><a class="am-text-danger""am-text-warning"><span class="am-icon-btn am-icon-copy"></span><br/>总评论数<br/>22</a></li>
      <li><a class="am-text-warning"><span class="am-icon-btn am-icon-recycle"></span><br/>访问量<br/>2333</a></li>
    </ul>
    
    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
          <a href="admin-album-upload.html"><div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 上传新图片</button>
          </div></a>
        </div>
      </div>
    </div>

    <ul data-am-widget="gallery" class="am-gallery am-gallery-overlay am-avg-sm-2 am-avg-md-4 am-avg-lg-4 am-margin gallery-list" data-am-gallery="{ pureview: true }">
    
    <c:forEach var="album" items="${albums }">
      <li>
        <header data-am-widget="header" class="am-header am-header-default admin-members-hd">
          <div class="am-header-left am-header-nav admin-members-hd-nav"><p><span class="am-icon-photo"></span> <fmt:formatDate value="${album.albumDate }" pattern="yyyy.MM.dd"/> </p></div>
          <div class="am-dropdown am-header-right am-header-nav admin-members-hd-nav" data-am-dropdown>
            <div class="am-dropdown-toggle admin-members-hd-btn" data-am-dropdown-toggle><span class="am-icon-bars"></span></div>
            <ul class="am-dropdown-content admin-members-dd-ul">
              <li><a href="#" data-am-modal="{target: '#album-discuss'}"><span class="am-icon-check"></span> 查看照片评论</a></li>
              <li><a href="#"><span class="am-icon-times"></span> 删除照片</a></li>
            </ul>
          </div>
        </header>
        <a href="http://xiaofeig.image.alimmdn.com/cblog/${album.image }">
          <img class="am-img-thumbnail am-img-bdrs" src="http://xiaofeig.image.alimmdn.com/cblog/${album.image }" alt='${album.albumDate }'/>
        </a>
      </li>
    </c:forEach>
      <!-- 
      <li>
        <header data-am-widget="header" class="am-header am-header-default admin-members-hd">
          <div class="am-header-left am-header-nav admin-members-hd-nav"><p><span class="am-icon-photo"></span> 2014.10.01 </p></div>
          <div class="am-dropdown am-header-right am-header-nav admin-members-hd-nav" data-am-dropdown>
            <div class="am-dropdown-toggle admin-members-hd-btn" data-am-dropdown-toggle><span class="am-icon-bars"></span></div>
            <ul class="am-dropdown-content admin-members-dd-ul">
              <li><a href="#" data-am-modal="{target: '#album-discuss'}"><span class="am-icon-check"></span> 查看照片评论</a></li>
              <li><a href="#"><span class="am-icon-times"></span> 删除照片</a></li>
            </ul>
          </div>
        </header>
        <a href="img/class/album/0.jpg">
          <img class="am-img-thumbnail am-img-bdrs" src="/cblog/img/class/album/0.jpg" alt="2014.10.01"/>
        </a>
      </li>
      <li>
        <header data-am-widget="header" class="am-header am-header-default admin-members-hd">
          <div class="am-header-left am-header-nav admin-members-hd-nav"><p><span class="am-icon-photo"></span> 2014.10.01 </p></div>
          <div class="am-dropdown am-header-right am-header-nav admin-members-hd-nav" data-am-dropdown>
            <div class="am-dropdown-toggle admin-members-hd-btn" data-am-dropdown-toggle><span class="am-icon-bars"></span></div>
            <ul class="am-dropdown-content admin-members-dd-ul">
              <li><a href="#" data-am-modal="{target: '#album-discuss'}"><span class="am-icon-check"></span> 查看照片评论</a></li>
              <li><a href="#"><span class="am-icon-times"></span> 删除照片</a></li>
            </ul>
          </div>
        </header>
        <a href="img/class/album/0.jpg">
          <img class="am-img-thumbnail am-img-bdrs" src="/cblog/img/class/album/0.jpg" alt="2014.10.01"/>
        </a>
      </li>
      <li>
        <header data-am-widget="header" class="am-header am-header-default admin-members-hd">
          <div class="am-header-left am-header-nav admin-members-hd-nav"><p><span class="am-icon-photo"></span> 2014.10.02 </p></div>
          <div class="am-dropdown am-header-right am-header-nav admin-members-hd-nav" data-am-dropdown>
            <div class="am-dropdown-toggle admin-members-hd-btn" data-am-dropdown-toggle><span class="am-icon-bars"></span></div>
            <ul class="am-dropdown-content admin-members-dd-ul">
              <li><a href="#" data-am-modal="{target: '#album-discuss'}"><span class="am-icon-check"></span> 查看照片评论</a></li>
              <li><a href="#"><span class="am-icon-times"></span> 删除照片</a></li>
            </ul>
          </div>
        </header>
        <a href="img/class/album/1.jpg">
          <img class="am-img-thumbnail am-img-bdrs" src="/cblog/img/class/album/1.jpg" alt="2014.10.02"/>
        </a>
      </li>
       -->
    </ul>


    <div class="am-margin am-cf">
      <hr/>
      <p class="am-fl">每页最多 16 条记录</p>
      <ol class="am-pagination am-fr">
        <li class="am-disabled"><a href="#">&laquo;</a></li>
        <li class="am-active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
      </ol>
    </div>

<!-- 相册评论框 -->
      <div class="am-popup" id="album-discuss">
       <div class="am-popup-inner discuss-bd">
         <div class="am-popup-hd">
        <h4 class="am-popup-title">照片评论</h4>
        <span data-am-modal-close
              class="am-close">&times;</span>
      </div>
      <div class="am-popup-bd" id="article-discuss-bd">
        <div class="am-panel-bd am-collapse am-in am-cf">
            <ul class="am-comments-list admin-content-comment">
              <li class="am-comment">
                <a href="#"><img src="/cblog/img/class/members/1.jpg" alt="" class="am-comment-avatar" id="article-discuss-user-logo"></a>
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

              <li class="am-comment">
                <a href="#"><img src="/cblog/img/class/members/1.jpg" alt="" class="am-comment-avatar" width="48" height="48"></a>
                <div class="am-comment-main">
                  <header class="am-comment-hd">
                    <div class="am-comment-meta"><a class="am-comment-author">闵聪</a> 评论于 <time>2014-7-12 15:30</time></div>
                    <div class="am-fr">
                    <button type="button" class="am-btn am-btn-default admin-article-discuss-sc">删除</button>
                    </div>
                  </header>
                  <div class="am-comment-bd"><p>666</p>
                  </div>
                </div>
              </li>
              
              <li class="am-comment">
                <a href="#"><img src="/cblog/img/class/members/1.jpg" alt="" class="am-comment-avatar" width="48" height="48"></a>
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

<script src="/cblog/js/jquery.min.js"></script>
<script src="/cblog/js/amazeui.min.js"></script>
<script src="/cblog/js/app.js"></script>
</body>
</html>
