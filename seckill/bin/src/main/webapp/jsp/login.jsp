<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=utf-8"
             pageEncoding="utf-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>海内存知己</title>
    <link rel="stylesheet" href="./css/login.css">
    <script type="application/javascript" src="js/login.js"></script>
</head>
<body>
<div class="login">
    <form action="Login1" name="form" onsubmit="return yanzheng()" method="POST">
        <h2>登录</h2>
        <p>用户名</p>
        <input type="text" name="username" id="username">
        <p>密码</p>
        <input type="password" name="psw">
        <input type="submit" value="登录" class="login-btn">
        <input type="button" value="注册" class="login-btn submit" onclick=window.open('register.jsp')><!-- 在新窗口打开注册页面 -->
    </form>
    <a href="sad">注解</a>
</div>
</body>
</html>