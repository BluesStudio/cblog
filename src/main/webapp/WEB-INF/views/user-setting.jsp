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
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
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
      <li>
      <c:choose>
      	<c:when test="${blogUser.student.clazz==null&&blogUser.student.clazz.clazzName==null }">
      		<a href="#" target="_blank"><span class="am-icon-home"></span> 进入本班博客 </a>	
      	</c:when>
      	<c:otherwise>
      		<a href="/cblog/clazzs/class-home/${blogUser.student.clazz.clazzName }" target="_blank"><span class="am-icon-home"></span> 进入本班博客 </a>
      	</c:otherwise>
      </c:choose>
      </li>
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
        <p>用户名：${blogUser.username }<br>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">更多设置</strong> /
                <small>setting</small>
            </div>
        </div>

        <div class="am-cf am-margin am-padding admin-content-list user-box">

            <h2 class="user-title">个人信息</h2>

            <div class="am-u-md-2 user-logo">
                <img class="am-img-thumbnail" src="http://xiaofeig.image.alimmdn.com/cblog/${blogUser.student.stuImg==null? 'ea4398e5806943f487c67b28c1f3e6d5.png':blogUser.student.stuImg }">

                <form method="post" action="/cblog/blogUsers/modifyStuImg" id="fileUpload-form" enctype="multipart/form-data" class="am-form">
                    <div class="am-form-group am-form-file">
                        <button type="button" class="am-btn am-btn-default am-btn-sm user-tx-upload">
                            选择图片
                        </button>
                        <button type="submit" class="am-btn am-btn-danger am-btn-sm user-tx-submit"><i
                                class="am-icon-cloud-upload"></i></button>
                        <input id="doc-form-file" type="file" accept="image/*" multiple="" name="stuImg">
                        <div id="file-list"></div>
                    </div>
                </form>
            </div>
            <form action="/cblog/blogUsers/user-setting" method="POST">
            <!-- 
                <button type="submit" class="am-btn am-btn-danger user-change-btn user-changeok">保存</button>
                <a class="am-btn am-btn-primary user-change-btn user-change user-none">修改</a>
                 -->
                 <button type="submit" class="am-btn am-btn-danger user-change-btn">保存</button>
                <div class="am-u-md-3">
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">姓名</label>
                        <input class="am-form-field user-m" type="text" name="stuName" value="${blogUser.student.stuName }">
                    </div>
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">用户名</label>
                        <input class="am-form-field user-n" type="text" value="${blogUser.username }" disabled>
                    </div>
                </div>
                <div class="am-u-md-3">
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">性别</label>
                        <input class="am-form-field user-m" type="text" name="gender" value="${blogUser.student.gender }">
                    </div>
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">班级</label>
                        <c:if test="${blogUser.student.clazz==null }">
                        <input class="am-form-field user-n" type="text" value="" disabled>
                        </c:if>
                        <c:if test="${blogUser.student.clazz!=null }">
                        <input class="am-form-field user-n" type="text" value="${blogUser.student.clazz.clazzName }" disabled>
                        </c:if>
                    </div>
                </div>
                <div class="am-u-md-4">
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">年龄</label>
                        <input class="am-form-field user-m" type="text" name="age" value="${blogUser.student.gender }">
                    </div>
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">学号</label>
                        <input class="am-form-field user-m" type="text" name="stuId" value="${blogUser.student.stuId }">
                    </div>
                </div>
                <div class="am-u-md-10">
                    <div class="am-input-group user-group">
                        <label class="am-input-group-label">座右铭</label>
                        <input class="am-form-field user-m" type="text" name="motto"
                               value="${blogUser.student.motto }">
                    </div>
                    <small class="admin-task-meta"><span class="am-icon-angle-right"></span> 如需修改班级，请到本页下方进行操作。</small>
                </div>
            </form>
        </div>

        <hr/>
        <h2 class="user-title">其他设置</h2>

        <div class="am-cf am-margin">
            <div class="am-u-md-6">
                <form data-am-validator action="/cblog/blogUsers/modifyPasswd" method="POST">
                    <div class="am-panel am-panel-default">
                        <div class="am-panel-bd">
                            <h2 class="user-title">修改密码</h2>
                            <input class="am-form-field" type="password" id="doc-vld-name-2" placeholder="${oldPasswd_required==null? '原密码':oldPasswd_required }" name="oldPasswd" value="${oldPasswd_required==null? oldPasswd:'' }"/>
                            <input class="am-margin-top am-form-field" type="password" id="doc-vld-pwd-1"
                                   placeholder="${newPasswd_required==null? '新密码':newPasswd_required }" required name="newPasswd" />
                            <input class="am-margin-top am-form-field" type="password" id="doc-vld-pwd-2"
                                   placeholder="${newPasswd2_required==null? '确认新密码':newPasswd2_required }" data-equal-to="#doc-vld-pwd-1" required name="newPasswd2" />
                            <button class="am-margin-top am-btn am-btn-secondary" type="submit">提交</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="am-u-md-6">
                <form action="/cblog/blogUsers/modifyClazz" method="POST">
                    <div class="am-panel am-panel-default">
                        <div class="am-panel-bd">
                            <h2 class="user-title">添加/修改班级</h2>

                            <div class="am-input-group user-class-group">
                                <label class="am-input-group-label">原班级</label>
                               <c:if test="${blogUser.student.clazz==null }">
                               <input class="am-form-field user-n" type="text" value="" disabled>
		                        </c:if>
		                        <c:if test="${blogUser.student.clazz!=null }">
		                        <input class="am-form-field user-n" type="text" value="${blogUser.student.clazz.clazzName }" disabled>
		                        </c:if> 
                                
                            </div>
                            <div class="am-input-group user-class-group">
                                <label class="am-input-group-label">选择新班级</label>
                                <input class="am-form-field user-n" type="text" name="clazzName" placeholder="输入班级编号">
                            </div>
                            <ul class="am-avg-sm-2 am-thumbnails">
                                <li>
                                    <div class="am-input-group">
                                        <label class="am-input-group-label">姓名</label>
                                        <input class="am-form-field user-n" type="text" name="stuName"
                                               placeholder="输入你的姓名">
                                    </div>
                                </li>
                                <li>
                                    <div class="am-input-group">
                                        <label class="am-input-group-label">学号</label>
                                        <input class="am-form-field user-n" type="text" name="stuId"
                                               placeholder="输入你的学号">
                                    </div>
                                </li>
                            </ul>
                            <div class="am-input-group user-class-group">
                                <label class="am-input-group-label">理由</label>
                                <input class="am-form-field user-n" type="text" name="reason" placeholder="输入申请理由">
                            </div>
                            <small class="admin-task-meta">该班管理员申请同意后方可添加/修改班级成功。</small>
                            <button class="am-btn am-btn-secondary" type="submit">向该班管理员申请</button>
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
<script>
    $(function () {
        var userchangeok = $(".user-changeok");
        var userchange = $(".user-change");
        userchange.click(function () {
            var userm = $(this).parents(".user-box").find(".user-m");
            userm.each(function () {
                $(this).replaceWith('<input class="am-form-field user-m" type="text" name="" value="' + $(this).html() + '" />');
            });
            $(this).hide();
            $(this).siblings(".user-changeok").show();
        });
        userchangeok.click(function () {
            var userm = $(this).parents(".user-box").find(".user-m");
            userm.each(function () {
                var valuetext = $(this).val();
                if (!valuetext) {
                    valuetext = "-";
                }
                $(this).replaceWith('<span class="user-m">' + valuetext + '</span>');
            });
            $(this).hide();
            $(this).siblings(".user-change").show();
        });
    });
</script>
</body>
</html>
