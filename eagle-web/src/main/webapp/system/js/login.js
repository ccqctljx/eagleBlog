function submitFunc() {
    var userName = $('#username').val();
    var userPass = $('#password').val();

    if(!$.isEmptyStr(userName) || !$.isEmptyStr(userPass)){
        alert('用户名或密码为空。');
    }

    $.ajax({
        type: "POST",
        url: ctx + "/login_login",
        data: {"userName" : userName , "userPass" : userPass},
        success: function(data){
            console.log('data is ' + data);
            console.log('成功');
        },
        error:function (data) {
            console.log(data);
            console.log('失败');
        }
    });
}

/**
 * 回车键事件
 */
$(document).on("keydown",function(e) {
    if (e.keyCode == 13) {
        $("#submit-btn").trigger("click");
    }
});
