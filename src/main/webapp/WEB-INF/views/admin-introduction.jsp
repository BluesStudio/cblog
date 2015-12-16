<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> </a></li>
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
          <li><a href="admin-album.html"><span class="am-icon-calendar"></span> 照片列表<span class="am-badge am-badge-success am-margin-right am-fr">45</span></a></li>
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
      <li class="admin-sidebar-list-hover"><a href="admin-introduction.html"><span class="am-icon-check"></span> 班级简介管理</a></li>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">班级简介</strong> / <small>introduction</small></div>
    </div>

   <div class="am-g">
      <div class="am-u-md-6">
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-1'}">概述<span class="am-icon-chevron-down am-fr" ></span></div>
          <form action="/cblog/clazzs/mergeOverview" method="POST" enctype="multipart/form-data">
          <div class="am-panel-bd am-collapse am-in" id="collapse-panel-1">
           <div class="am-g am-margin-top">
            <label class="am-u-md-2 am-text-right">
              简述
            </label>
            <div class="am-u-md-10 am-u-end col-end">
              <textarea class="am-form-field change-disabled" rows="5" id="doc-ta-1" disabled name="overview">${admin.clazz.overview }</textarea>
            </div>
           </div>
           <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              图片
            </label>
            <div class="am-u-md-10 am-u-end col-end am-form-file">
              <button type="button" class="am-btn am-btn-default change-disabled" disabled>
                <i class="am-icon-cloud-upload"></i> 选择要上传的图片</button>
                <div class="am-fr change-btn"><button type="button" class="am-btn am-btn-danger change-disabled-btn">修改</button>
              <button type="submit" class="am-btn am-btn-primary save-disabled-btn">保存</button></div>
              <input id="doc-form-file" class="change-disabled" type="file" accept="image/*" multiple="" disabled name="clazzImg">
              <div id="file-list"></div>
              <c:if test="${admin.clazz.clazzImg!=null }">
              <img src="http://xiaofeig.image.alimmdn.com/cblog/${admin.clazz.clazzImg }" class="admin-introduction-img am-margin-top am-img-thumbnail">
              </c:if>
              
            </div>
            </div>
          </div>
          </form>
        </div>

        <div class="am-panel am-panel-default">
        
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">荣誉<span class="am-icon-chevron-down am-fr" ></span></div>
          <div id="collapse-panel-2" class="am-panel-bd am-in am-collapse">
          <form action="/cblog/clazzHonors/create" method="POST">
            <div class="am-g am-margin-top">
            <label class="am-u-md-2 am-text-right">
              班级
              荣誉
            </label>
            <div class="am-u-md-10 am-u-end col-end">
              <div class="honortext">
              <c:forEach items="${admin.clazz.clazzHonors }" var="clazzHonor">
              	<p>${clazzHonor.honorName } <button type="button" class="am-close am-icon-times"></button></p>
              </c:forEach>
              </div>
              <div class="am-input-group am-input-group-sm am-margin-top am-margin-right">
		      <input type="text" class="am-form-field change-disabled" placeholder="${clazzHonor_required==null? '添加班级荣誉':clazzHonor_required }" name="clazzHonor">
		      <span class="am-input-group-btn">
		        <button class="am-btn am-btn-default" type="submit">提交</button>
		      </span>
		      </div>
            </div>
           </div>
           </form>
           <form action="/cblog/personalHonors/create" method="POST">
           <div class="am-g am-margin-top">
            <label class="am-u-md-2 am-text-right">
              个人
              荣誉
            </label>
            <div class="am-u-md-10 am-u-end col-end">
              <div class="honortext">
              <c:forEach items="${admin.clazz.personalHonors }" var="personalHonor">
              	<p>${personalHonor.student.stuName}：${personalHonor.award } <button type="button" class="am-close am-icon-times"></button></p>
              </c:forEach>
           	  </div>
              <div class="am-input-group-sm am-margin-top am-margin-right">
		      <input type="text" class="am-form-field change-disabled admin-add-ph-bd" placeholder="${award_required==null? '添加个人荣誉':award_required }" value="${award_required==null? award:''}" name="award">
		      </div>
		      <div class="am-input-group am-input-group-sm am-margin-right admin-add-nm-group">
		      <input type="text" class="am-form-field change-disabled admin-add-ph-nm" placeholder="${stuName_required==null? '添加姓名':stuName_required }" value="${stuName_required==null? stuName:'' }" name="stuName">
		      <span class="am-input-group-btn">
		        <button class="am-btn am-btn-default admin-add-ph-btn" type="submit">提交</button>
		      </span>
		      </div>
            </div>
           </div>
           </form>
           <form action="/cblog/honorWalls/create" method="POST" enctype="multipart/form-data">
           <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              荣誉墙
            </label>
            <div class="am-u-md-10 am-u-end col-end am-form-file">
              <button type="button" class="am-btn am-btn-default change-disabled" disabled>
                <i class="am-icon-cloud-upload"></i> 添加图片</button>
              <div class="am-fr change-btn"><button type="button" class="am-btn am-btn-danger change-disabled-btn">修改</button>
              <button type="submit" class="am-btn am-btn-primary save-disabled-btn">保存</button></div>
              <input id="doc-form-file" class="change-disabled" type="file" accept="image/*" multiple="" name="honorWall">
              <div id="file-list"></div>
              
            </div>
            <div class="honorwall">
            <c:forEach items="${admin.clazz.honorWalls }" var="honorWall">
            <img src="http://xiaofeig.image.alimmdn.com/cblog/${honorWall.image }" class="admin-introduction-img am-margin-top am-img-thumbnail"><button type="button" class="am-margin am-close am-close-alt am-icon-times"></button>
            </c:forEach>
              </div>
            </div>
            </form>
          </div>
        </div>

      </div>

      <div class="am-u-md-6">
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-3'}">标语<span class="am-icon-chevron-down am-fr" ></span></div>
          <form action="/cblog/clazzs/mergeSlogan" method="POST">
           <div id="collapse-panel-3" class="am-panel-bd am-collapse am-in">
            <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              标语
            </label>
            <div class="am-u-md-10 am-u-end col-end">
              <textarea class="am-form-field change-disabled" rows="3" id="doc-ta-1" disabled name="slogan">${admin.clazz.slogan }</textarea>
            </div>
           </div>
          <div class="am-g change-btn"> 
           <div class="am-u-sm-10 am-u-sm-push-2">
              <button type="button" class="am-btn am-btn-danger change-disabled-btn">修改</button>
              <button type="submit" class="am-btn am-btn-primary save-disabled-btn">保存</button>
            </div>
          </div>
          </div>
          </form>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-4'}">班旗<span class="am-icon-chevron-down am-fr" ></span></div>
          <form action="/cblog/clazzs/mergeFlagImg" method="POST" enctype="multipart/form-data">
          <div class="am-panel-bd am-collapse am-in" id="collapse-panel-4">
           <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              班旗
            </label>

            <div class="am-u-md-10 am-u-end col-end am-form-file">
              <button type="button" class="am-btn am-btn-default change-disabled" disabled>
                <i class="am-icon-cloud-upload"></i> 选择要上传的图片</button>
              <div class="am-fr change-btn"><button type="button" class="am-btn am-btn-danger change-disabled-btn">修改</button>
              <button type="submit" class="am-btn am-btn-primary save-disabled-btn">保存</button></div>
              <input id="doc-form-file" class="change-disabled" type="file" accept="image/*" multiple="" disabled name="flagImg">
              <div id="file-list"></div>
              
              <img src="http://xiaofeig.image.alimmdn.com/cblog/${admin.clazz.flagImg }" class="admin-introduction-img am-margin-top am-img-thumbnail">
            </div>
          
          </div>
          
          </div>
          </form>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-5'}">班歌<span class="am-icon-chevron-down am-fr" ></span></div>
          <form action="/cblog/clazzs/mergeSong" method="POST" enctype="multipart/form-data">
          <div class="am-panel-bd am-collapse am-in" id="collapse-panel-5">
          <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              歌名
            </label>
            <div class="am-u-md-10">
              <input class="am-form-field change-disabled" type="text" disabled name="songTitle" value="${admin.clazz.songTitle }">
            </div>
            </div>
          <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              歌词
            </label>
            <div class="am-u-md-10 am-u-end col-end">
              <textarea class="am-form-field change-disabled" rows="8" id="doc-ta-1" disabled name="lyric">${admin.clazz.lyric }</textarea>
            </div>
           </div>
           <div class="am-g am-margin">
            <label class="am-u-md-2 am-text-right">
              地址
            </label>
            <div class="am-u-md-10">
              <input class="am-form-field change-disabled" type="text" disabled name="song" value="http://xiaofeig.image.alimmdn.com/cblog/${admin.clazz.song }">
              <small class="admin-task-meta">请输入正确音乐的地址（http://开头）</small>
            </div>
            <div class="am-u-md-10 am-u-sm-push-2 am-u-end col-end am-form-file">
              <button type="button" class="am-btn am-btn-default change-disabled" disabled>
                <i class="am-icon-cloud-upload"></i> 或者选择要上传的音乐</button>
                <div class="am-fr change-btn"><button type="button" class="am-btn am-btn-danger change-disabled-btn">修改</button>
              <button type="submit" class="am-btn am-btn-primary save-disabled-btn">保存</button></div>
              <input id="doc-form-file" class="change-disabled" type="file" accept="audio/*" multiple="" disabled name="songFile">
              <div id="file-list"></div>
              <audio class="admin-bange am-margin-top" controls="controls" height="100" width="100">
					<source src="http://xiaofeig.image.alimmdn.com/cblog/${admin.clazz.song }" type="audio/mpeg">
	              <embed height="100" width="100" src="http://xiaofeig.image.alimmdn.com/cblog/${admin.clazz.song }">
	           </audio>
            </div>
            </div>
          </div>
          </form>
        </div>

      </div>
    </div>
  <hr/>
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
<script src="/cblog/js/textarea.js"></script>
<script>
  $(function(){
  	var text = $("textarea");
  	text.each(function(){
  		autoTextarea(this);
  	}); 
  });
  $(function() {
    $('#doc-form-file').on('change', function() {
      var fileNames = '';
      $.each(this.files, function() {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
      });
      $('#file-list').html(fileNames);
    });
  });

  $(function(){
    var changedisabledbtn = $(".change-disabled-btn");
    changedisabledbtn.click(function(){
      $(this).parents(".am-panel").find(".change-disabled").attr("disabled",false);
      $(this).hide();
      $(this).siblings(".save-disabled-btn").show(); 
     });
  });
</script>
</body>
</html>
