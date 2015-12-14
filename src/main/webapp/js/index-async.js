//所有提交可回车实现
$(".ccapInput").keydown(function(e){
    if (e.which == 13) {
        $(this).parent(".ibox").find("button[type='submit']").click();
    }
});
//申请博客
$(".toapply").on("click", function(){
    $.ajax({
        type: "POST",
        url: "http://125.87.199.252:8080/cblog/admins/register",
        dataType: "json",
        data: {
            "username": $("#applyAdminName").val(),
            "clazz.clazzName": $("#applyClassName").val(),
            "passwd": $("#applyPassword").val()
        },
        success: function(data){
            if(!data.success){
                var error_text = "申请失败：";
                var error = [];
                $.each(data, function(i, e){
                    error.push(e);
                });
                error_text += error;
                alert(error_text);
            }else{
                alert("申请成功！请以管理员用户方式登录。");
                window.location.href = "index.html#adminLogin";
            }
        }
    });
});

//管理员登录
$(".toadminlogin").on("click", function(){
    $.ajax({
        type: "POST",
        url: "http://125.87.199.252:8080/cblog/admins/login",
        dataType: "json",
        data: {
            "username": $("#adminName").val(),
            "passwd": $("#adminPassword").val()
        },
        success: function(data){
            if(!data.success){
                var error_text = "登录失败：";
                var error = [];
                $.each(data, function(i, e){
                    error.push(e);
                });
                error_text += error;
                alert(error_text);
            }else{
                window.location.href = "admin.html";
            }
        }
    });
});

//用户注册
$(".toregister").on("click", function(){
    $.ajax({
        type: "POST",
        url: "http://125.87.199.252:8080/cblog/blogUsers/register",
        dataType: "json",
        data: {
            "username": $("#userRegisterName").val(),
            "passwd": $("#userRegisterPassword").val()
        },
        success: function(data){
            if(!data.success){
                var error_text = "登录失败：";
                var error = [];
                $.each(data, function(i, e){
                    error.push(e);
                });
                error_text += error;
                alert(error_text);
            }else{
                alert("注册成功！请登录。");
                window.location.href = "index.html#userLogin";
            }
        }
    });
});

//用户登录
$(".tologin").on("click", function(){
    $.ajax({
        type: "POST",
        url: "http://125.87.199.252:8080/cblog/blogUsers/login",
        dataType: "json",
        data: {
            "username": $("#userName").val(),
            "passwd": $("#userPassword").val()
        },
        success: function(data){
            if(!data.success){
                var error_text = "登录失败：";
                var error = [];
                $.each(data, function(i, e){
                    error.push(e);
                });
                error_text += error;
                alert(error_text);
            }else{
                alert("登录成功！");
                window.location.href = "user.html";
            }
        }
    });
});