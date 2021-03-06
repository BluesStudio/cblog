# `CBlog`班级博客 #
`12/9/2015 8:24:35 PM`

## 问题反馈 ##

1. ~~index.html页面使用了#之后，切换不流畅，浏览器地址框未改变~~
2. ~~注册表单部分没有
3. 用来显示错误信息的位置~~
4. ~~index.html的子页面如#apply命名不规范，建议如下：~~
	- ~~管理员注册博客：#adminRegister~~
	- ~~管理员登录：#adminLogin~~
	- ~~用户注册：#userRegister~~
	- ~~用户登录:#userLogin~~
5. ~~admin-members-add.html这个页面没有错误信息的位置，还有些写文章的那个也是~~
6. ~~admin-members-add.html这个页面保存修改按钮不起作用~~
7. ~~admin-introduction.html班级简介这个页面的按钮都不能用~~
8. ~~首页表单切换卡顿~~
8. ~~admin-setting.html没有显示错误信息的地方，修改成功后无任何提示信息~~
10. ~~user-setting.html页面表单提交按钮不行~~


## 新问题 ##

1. ~~admin-album-upload.html ，表单提交失败~~
2. ~~文章列表、照片列表、成员列表 怎样传递clazzName参数~~
3. ~~admin-members-add.html表单提交按钮，图片异步提交~~

问题待明天反馈
`12/15/2015 12:01:25 AM`
 

## 最新问题 ##

1. ~~admin-introduction.html中叉叉都没得什么用哦~~
2. ~~admin-setting.html中不知如何反馈错误消息给用户（密码修改成功）~~
3. ~~admin-article.html中文章没有显示出来，但已请求了数据库~~
4. ~~开启全屏失败~~
5. class-home.html没做诶
6. ~~班级相册班级成员图片均无点击效果~~
7. ~~user-setting.html个人信息保存按钮么用~~

## 闵聪小同学，你的html又出问题咯 ##
`12/17/2015 11:05:56 PM` 

1. ~~全屏依旧开启失败，忘了你上次是不是说这取消了，但是某些页面中还是有，user的页面~~
2. admin-article.html分页按钮按了两次就不能按了 (跨域问题,待测试)
3. ~~admin-article.html分页中每篇文章的编辑、删除和展开评论需动态生成链接，链接见如下表格~~(待测试)
4. ~~redirect.html字体略粗时间略短~~
5. class-home.html没弄好 (跨域问题,待测试)
`12/18/2015 1:03:32 AM` 


|URL|Description|
|:---:|:---:|
|/cblog/articles/update/{article.id}|更新文章|
|/cblog/articles/delete/{article.id}|删除文章|
|/cblog/articles/{article.id}|查看某篇文章|
|/cblog/********|文章评论（还木有）|

## 小飞的待解决问题 ##

1. ~~文章发表无错误信息提示~~
2. ~~管理员密码修改错误无提示~~
3. ~~绑定申请核实小数字~~
4. ~~页面改到user-setting.jsp页面~~
5. ~~用户修改密码无提示~~
6. 一些搜索框没做
7. 评论没做
8. ~~文章更新无错误信息提示~~


## 清空数据重新测试 ##

1. 首页-~~简介班旗图片显示失败、概述图片错误显示~~
2. 首页-主页Copyright条框显示异常
3. 首页-班级相册下面绿色部分显示异常
4. 首页-成员下面绿色部分显示异常
5. ~~admins/index页面首页链接改成当前页（其它页面也要改）~~
6. ~~发表成功也可以使用redirect.jsp，发表成功之后文章列表数字未更新~~
7. ~~文章删除不支持GET~~
8. ~~发表新文章按钮链接错误~~
9. ~~上传新照片按钮链接错误~~
10. ~~上传新照片之后可以使用redirect.jsp，上传成功之后照片列表数字未更新~~
11. ~~添加新成员按钮链接错误，添加成员不要显示闵聪头像，可以显示那个默认头像~~
12. ~~添加成员失败，不支持GET方法~~，显示成员无图片可显示默认头像（这个需要闵聪解决，图片链接http://xiaofeig.image.alimmdn.com/cblog/ea4398e5806943f487c67b28c1f3e6d5.png）
13. ~~班级简介中班旗图片不显示，概述图片可设置不强制提交，概述照片没有显示没有，主页也是，班歌地址栏应为空，进入博客首页链接错误，退出失败，名字显示错误，班级名称错误，关于错误~~
14. ~~个人信息也内容为空时设置为-，个人信息修改提交失败（急急急，闵聪你的表单提交不行诶），进入本班级博客链接修改，基本信息中用户名没显示~~

## 接口 ##

### 1. 管理员模块  ###

#### 1.1 申请博客 ####

##### 1.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/admins/register
	
##### 1.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|username|是|用户名|
|passwd|是|密码|
|clazz.clazzName|是|班级名称|

##### 1.1.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|success|是否申请成功，值为`true`或`false`，若为`true`，不返回下面参数|
|admin.username.required|username参数提交失败，值为**`用户名不能为空`**、**`用户名长度只能为3-20`**、**`该用户名已存在`**|
|admin.passwd.required|passwd参数提交失败，值为**`密码不能为空`*、*`密码长度只能为6-60`**|
|admin.clazz.clazzName.required|clazz.clazzName参数提交失败，值为**`班级名称不能为空`**、**`班级名称长度只能为1-50`**、**`该班级名称已存在`**|

##### 1.1.4 请求示例 #####

	无
	
##### 1.1.5 返回参数示例 #####

	无


#### 1.2 登录 ####

##### 1.2.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/admins/login
	
##### 1.2.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|username|是|用户名|
|passwd|是|密码|

##### 1.2.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|success|是否申请成功，值为`true`或`false`，若为`true`，不返回下面参数|
|admin.username.required|username参数提交失败，值为**`用户名不能为空`**、**`该用户名尚未注册`**|
|admin.passwd.required|passwd参数提交失败，值为**`密码不能为空`*、*`密码错误`**|

##### 1.2.4 请求示例 #####

	无
	
##### 1.2.5 返回参数示例 #####

	无

### 2. 文章article的接口  ###

#### 2.1 获取文章列表 ####

##### 2.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/articles/list
	
##### 2.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|page|否|请求分页的页码，默认为1|
|size|否|分页大小，默认为15|
|sortFieldName|否|排序属性，默认为publishDate，可选值为publishDate、activityDate、id|
|sortOrder|否|排序方式，默认为DESC，可选值为ASC、DESC|
|clazzId|否|班级编号，不提交则获取所有班级|

##### 2.1.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|page|当前页码，若你觉得多余，可以让我把它删掉|
|maxPage|最大页数|
|articles|文章，数组的表现形式|

articles属性说明

|参数|说明|
|:---:|:---:|
|id|文章编号|
|clazzId|班级编号|
|activityDate|活动日期|
|publishDate|文章发布日期|
|title|文章标题|
|content|文章内容，管理员那里面没有这个属性，但其它地方需要|
|site|地点|
|participant|地点|

评论什么的暂木哟

##### 2.1.4 请求示例 #####

	无
	
##### 2.1.5 返回参数示例 #####

	无

### 3. 相册album的接口  ###

#### 3.1 获取相册列表 ####

##### 3.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/albums/list
	
##### 3.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|page|否|请求分页的页码，默认为1|
|size|否|分页大小，默认为15|
|sortFieldName|否|排序属性，默认为albumDate，可选值为albumDate、id|
|sortOrder|否|排序方式，默认为DESC，可选值为ASC、DESC|
|clazzId|否|班级编号，不提交则获取所有班级|

##### 3.1.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|page|当前页码，若你觉得多余，可以让我把它删掉|
|maxPage|最大页数|
|albums|相册，数组的表现形式|

albums属性说明

|参数|说明|
|:---:|:---:|
|id|相册编号|
|clazzId|班级编号|
|albumDate|相册日期|
|image|相册图片，访问路径为http://xiaofeig.image.alimmdn.com/cblog/{image}|

评论什么的暂木哟

##### 3.1.4 请求示例 #####

	无
	
##### 3.1.5 返回参数示例 #####

	无

### 4. 学生student的接口  ###

#### 4.1 获取学生列表 ####

##### 4.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/students/list
	
##### 4.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|page|否|请求分页的页码，默认为1|
|size|否|分页大小，默认为15|
|sortFieldName|否|排序属性，默认为id，可选值为id|
|sortOrder|否|排序方式，默认为DESC，可选值为ASC、DESC|
|clazzId|否|班级编号，不提交则获取所有班级|

##### 4.1.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|page|当前页码，若你觉得多余，可以让我把它删掉|
|maxPage|最大页数|
|students|学生，数组的表现形式|

albums属性说明

|参数|说明|
|:---:|:---:|
|id|编号|
|clazzId|班级编号|
|stuId|学号|
|stuName|姓名|
|age|年龄|
|gender|性别（unknown、man、woman）|
|stuImg|照片，访问路径为http://xiaofeig.image.alimmdn.com/cblog/{image}|
|motto|座右铭|

评论什么的暂木哟

##### 4.1.4 请求示例 #####

	无
	
##### 4.1.5 返回参数示例 #####

	无

#### 4.2 上传文件接口 ####

##### 4.2.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/fileUpload
	
##### 4.2.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|uploadFile|是|上传的文件|

##### 4.2.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|filename|返回的文件名，文件访问路径为http://xiaofeig.image.alimmdn.com/cblog/{image}|

##### 4.2.4 请求示例 #####

	无
	
##### 4.2.5 返回参数示例 #####

	无


### 5. 用户模块  ###

#### 5.1 注册 ####

##### 5.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/blogUsers/register
	
##### 5.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|username|是|用户名|
|passwd|是|密码|

##### 5.1.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|success|是否申请成功，值为`true`或`false`，若为`true`，不返回下面参数|
|blogUser.username.required|username参数提交失败，值为**`用户名不能为空`**、**`用户名长度只能为3-20`**、**`该用户名已存在`**|
|blogUser.passwd.required|passwd参数提交失败，值为**`密码不能为空`*、*`密码长度只能为6-60`**|

##### 5.1.4 请求示例 #####

	无
	
##### 5.1.5 返回参数示例 #####

	无


#### 5.2 登录 ####

##### 5.2.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/blogUsers/login
	
##### 5.2.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|username|是|用户名|
|passwd|是|密码|

##### 5.2.3 返回参数说明 #####

|参数|说明|
|:---:|:---:|
|success|是否申请成功，值为`true`或`false`，若为`true`，不返回下面参数|
|blogUser.username.required|username参数提交失败，值为**`用户名不能为空`**、**`该用户名尚未注册`**|
|blogUser.passwd.required|passwd参数提交失败，值为**`密码不能为空`*、*`密码错误`**|

##### 5.2.4 请求示例 #####

	无
	
##### 5.2.5 返回参数示例 #####

	无