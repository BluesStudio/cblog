<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> </a></li>
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
  <div class="am-form am-form-horizontal">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加成员</strong> / <small>add</small></div>
    </div>
    <hr/>
    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-5">
                <img class="am-img-circle am-img-thumbnail admin-members-img" src="/cblog/img/class/members/1.jpg" alt=""/>
              </div>
              <div class="am-u-md-7">
                  <form method="post" action="/cblog/fileUpload" id="fileUpload-form" enctype="multipart/form-data">
                      <div class="am-form-group am-form-file">
                          <button type="button" class="am-btn am-btn-default am-btn-sm">
                              <i class="am-icon-cloud-upload"></i> 选择要上传的图片</button>
                          <input id="doc-form-file" name="uploadFile" type="file" accept="image/*" multiple>
                          <div id="file-list"></div>
                      </div>
                      <button type="submit" class="am-btn am-btn-danger am-btn-sm" id="fileUpload-submit">选择</button>
                  </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <form action="/cblog/students/create" method="POST">
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">成员姓名 / Name</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" placeholder="${student_stuName_required==null? '输入学生姓名 / Name': student_stuName_required}" name="stuName" value="${student.stuName }">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-id" class="am-u-sm-3 am-form-label">学号 / Id</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-id" placeholder="${student_stuId_required==null? '输入学生学号 / Id': student_stuId_required}" name="stuId" value="${student.stuId }">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-age" class="am-u-sm-3 am-form-label">年龄 / Age</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-age" placeholder="${student_age_required==null? '输入学生年龄 / Age': student_age_required}" name="age" value="${student_age_required==null? student.age:'' }">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-gender" class="am-u-sm-3 am-form-label">性别 / Gender</label>
            <div class="am-u-sm-9">
              <select data-am-selected name="gender" > 
                <option value="unknown" ${student.gender=='unknown'? 'selected': ''}>未知</option>
                <option value="man" ${student.gender=='man'? 'selected': ''}>男 / Boy</option>
                <option value="woman" ${student.gender=='woman'? 'selected': ''}>女 / Girl</option>
              </select>
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">座右铭 / Motto</label>
            <div class="am-u-sm-9">
              <textarea class="" rows="5" id="user-intro" placeholder="座右铭将展示在班级成员页面/cblog." name="motto" >${student.motto }</textarea>
              <small>50字以内/cblog.</small>
            </div>
          </div>

          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="submit" class="am-btn am-btn-primary">保存修改</button>
                <input type="hidden" name="stuImg" >
            </div>
          </div>
        
      </div>
      </form>
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
<script src="/cblog/js/jquery.form.js"></script>
<script src="/cblog/js/app.js"></script>
<script>
  $(function() {
    $('#doc-form-file').on('change', function() {
      var fileNames = '';
      $.each(this.files, function() {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
      });
      $('#file-list').html(fileNames);
    });
      var fileUpload_form =  $("#fileUpload-form");
      fileUpload_form.ajaxForm({
          dataType: "json",
          success: function(data){
              $(".admin-members-img").attr("src","http://xiaofeig.image.alimmdn.com/cblog/" + data.filename);
              $("input[name='stuImg']").val(data.filename);
          }
      });
  });
</script>
</body>
</html>
