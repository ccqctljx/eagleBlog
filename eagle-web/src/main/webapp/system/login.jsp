<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if IE 8]><html lang="en" class="ie8 no-js"><![endif]-->
<!--[if IE 9]><html lang="en" class="ie9 no-js"><![endif]-->
<!--[if !IE]><!-->
<!--<![endif]-->
<head>
    <title>登录</title>
    <jsp:include page="../common/common_js.jsp"/>
    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/system/css/azmind_css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/system/css/azmind_css/supersized.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/system/css/azmind_css/style.css">

    <script type="text/javascript">
        var path = '${path}';
    </script>
    <!-- Javascript -->
    <script src="${pageContext.request.contextPath}/system/js/azmind_js/supersized.3.2.7.min.js"></script>
    <script src="${pageContext.request.contextPath}/system/js/azmind_js/supersized-init.js"></script>
    <script src="${pageContext.request.contextPath}/system/js/azmind_js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/system/js/login.js"></script>
</head>
<body>
<div class="page-container">
    <h1>Login</h1>
    <form action="" method="post">
        <input type="text" name="username" id="username" class="username" placeholder="请输入姓名">
        <input type="password" name="password" id="password" class="password" placeholder="请输入密码">
        <button type="submit" class="button login-btn" onclick="submitFunc()">登录</button>
        <div class="error"><span>+</span></div>
    </form>
    <div class="connect">
        <p>Or connect with:</p>
        <p>
            <a class="facebook" href=""></a>
            <a class="twitter" href=""></a>
        </p>
    </div>
</div>
</body>
</html>

