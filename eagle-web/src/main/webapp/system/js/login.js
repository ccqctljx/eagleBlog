function submitFunc() {
    var userName = $('#userName').val();
    var userPass = $('#userPass').val();

    if(!$.isEmptyStr(userName) || !$.isEmptyStr(userPass)){
        alert('用户名或密码为空。');
    }

    $.ajax({
        type: "POST",
        url: ctx + "/system/login_login",
        data: {"userName" : userName , "passWord" : userPass},
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