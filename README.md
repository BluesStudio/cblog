# `CBlog`班级博客 #
`12/9/2015 8:24:35 PM`

## 问题反馈 ##

1. index.html页面使用了#之后，切换不流畅，浏览器地址框未改变
2. 注册表单部分没有用来显示错误信息的位置
3. index.html的子页面如#apply命名不规范，建议如下：
	- 管理员注册博客：#adminRegister
	- 管理员登录：#adminLogin
	- 用户注册：#userRegister
	- 用户登录:#userLogin
4. admin-members-add.html这个页面没有错误信息的位置，还有些写文章的那个也是
5. admin-members-add.html这个页面保存修改按钮不起作用

	

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

#### 1.1 获取文章列表 ####

##### 1.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/articles/list
	
##### 1.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|page|否|请求分页的页码，默认为1|
|size|否|分页大小，默认为15|
|sortFieldName|否|排序属性，默认为publishDate，可选值为publishDate、activityDate、id|
|sortOrder|否|排序方式，默认为DESC，可选值为ASC、DESC|
|clazzId|否|班级编号，不提交则获取所有班级|

##### 1.1.3 返回参数说明 #####

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

评论什么的暂木哟

##### 1.1.4 请求示例 #####

	无
	
##### 1.1.5 返回参数示例 #####

	无

### 3. 相册album的接口  ###

#### 1.1 获取相册列表 ####

##### 1.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/albums/list
	
##### 1.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|page|否|请求分页的页码，默认为1|
|size|否|分页大小，默认为15|
|sortFieldName|否|排序属性，默认为albumDate，可选值为albumDate、id|
|sortOrder|否|排序方式，默认为DESC，可选值为ASC、DESC|
|clazzId|否|班级编号，不提交则获取所有班级|

##### 1.1.3 返回参数说明 #####

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

##### 1.1.4 请求示例 #####

	无
	
##### 1.1.5 返回参数示例 #####

	无

### 4. 学生student的接口  ###

#### 1.1 获取学生列表 ####

##### 1.1.1 接口调用请求说明 #####

	http请求方式：POST
	http://125.87.199.38:8080/cblog/students/list
	
##### 1.1.2 请求参数说明 #####

|参数|是否必须|说明|
|:---:|:---:|:---:|
|page|否|请求分页的页码，默认为1|
|size|否|分页大小，默认为15|
|sortFieldName|否|排序属性，默认为id，可选值为id|
|sortOrder|否|排序方式，默认为DESC，可选值为ASC、DESC|
|clazzId|否|班级编号，不提交则获取所有班级|

##### 1.1.3 返回参数说明 #####

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

##### 1.1.4 请求示例 #####

	无
	
##### 1.1.5 返回参数示例 #####

	无
