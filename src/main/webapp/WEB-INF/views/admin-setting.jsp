<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <a href="index.html" target="_blank"><strong>cBlog</strong></a>
        <small>班级博客后台管理</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

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
            <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span
                    class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar">
        <ul class="am-list admin-sidebar-list">
            <li><a href="admin.html"><span class="am-icon-home"></span> 首页<span
                    class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 班级文章管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                    <li><a href="admin-article.html"><span class="am-icon-calendar"></span> 文章列表<span
                            class="am-badge am-badge-secondary am-margin-right am-fr">13</span></a></li>
                    <li><a href="admin-article-edit.html"><span class="am-icon-pencil-square-o"></span> 写文章</a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-th"></span> 班级相册管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                    <li><a href="admin-album.html"><span class="am-icon-calendar"></span> 照片列表<span
                            class="am-badge am-badge-success am-margin-right am-fr">45</span></a></li>
                    <li><a href="admin-album-upload.html"><span class="am-icon-upload"></span> 上传照片</a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-users"></span>
                    班级成员管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
                    <li><a href="admin-members.html"><span class="am-icon-calendar"></span> 成员列表<span
                            class="am-badge am-badge-warning am-margin-right am-fr">27</span></a></li>
                    <li><a href="admin-members-add.html"><span class="am-icon-plus"></span> 添加成员</a></li>
                    <li><a href="admin-members-apply.html"><span class="am-icon-user-md"></span> 绑定申请核实<span
                            class="am-badge am-badge-danger am-margin-right am-fr am-round">+2</span></a></li>
                </ul>
            </li>
            <li><a href="admin-introduction.html"><span class="am-icon-check"></span> 班级简介管理</a></li>
            <li class="admin-sidebar-list-hover"><a href="admin-setting.html"><span class="am-icon-cog"></span> 更多设置</a>
            </li>
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
                <p><span class="am-icon-tag"></span> ©cBlog <a href="aboutus.html" target="_blank"
                                                               class="am-panel-bd-aboutus">关于我们</a></p>

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

    <div class="am-cf am-margin">
        <div class="am-u-md-6">
            <form data-am-validator action="/cblog/admins/modifyPasswd" method="POST">
                <div class="am-panel am-panel-default">
                    <div class="am-panel-bd">
                        <h2 class="user-title">修改密码</h2>
                        <input class="am-form-field" type="password" id="doc-vld-name-2" placeholder="原密码" name="oldPasswd"/>
                        <input class="am-margin-top am-form-field" type="password" id="doc-vld-pwd-1" placeholder="新密码" required name="newPasswd"/>
                        <input class="am-margin-top am-form-field" type="password" id="doc-vld-pwd-2" placeholder="确认新密码" data-equal-to="#doc-vld-pwd-1" required name="newPasswd2"/>
                        <button class="am-margin-top am-btn am-btn-secondary" type="submit">提交</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="am-u-md-6">
            <form data-am-validator>
                <div class="am-panel am-panel-default">
                    <div class="am-panel-bd">
                        <h2 class="user-title">修改博客主题风格</h2>
                        <div class="am-g">
                        <div class="am-u-md-6">
                            <label>
                                <input type="radio" name="doc-radio-1" value="option1" checked>
                                <span>默认</span>
                            </label>
                            <img src="/cblog/img/admin/default.png" class="setting-style">
                        </div>
                        <div class="am-u-md-6">
                            <label>
                                <input type="radio" name="doc-radio-1" value="option2" disabled>
                                <span>简约(未开通)</span>
                            </label>
                            <img src="/cblog/img/admin/simple.png" class="setting-style">
                        </div>
                        </div>
                        <div class="am-g"><button class="am-margin-top am-btn am-btn-secondary am-fr" type="submit">提交</button></div>
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
<script src="/cblog/js/app.js"></script>
</body>
</html>
