<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>登陆</title>
    <%@include file="../common/head.jsp"%>
</head>
<body>
    <div class="container">
        <h2 class="text-center">登陆</h2>
        <form class="text-center">
            <div class="form-group">
                <label for="mobile" class="text-left">
                    手机号:
                    <input type="mobile" class="form-control" id="mobile" placeholder="请输入手机号">
                </label>
            </div>
            <div class="form-group">
                <label for="password" class="text-left">
                    密 码:
                    <input type="password" class="form-control" id="password" placeholder="请输入密码">
                </label>
            </div>
            <div class="form-group">
                <label for="codeImage" class="text-left">
                    验证码:
                    <input type="text" class="form-control" id="codeImage" placeholder="请输入验证码">
                    <img src="http://localhost:8080/sso/image/kaptchaCode" onclick="javascript:login.changeImageCode();" id="codeImg" />
                </label>
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    <input class="form-check-input text-center" type="checkbox"> 记住我
                </label>
            </div>
            <input type="button" onclick="javascript:login.doLogin();" class="btn btn-info text-center" value="登陆" />
        </form>
    </div>
    <script type="text/javascript" src="<%=basePath%>/resources/java-resource/script/js/ajax.js"></script>
    <script type="text/javascript" >var path = '<%=basePath%>' ;</script>
    <script type="text/javascript" src="<%=basePath%>/resources/script/login.js"></script>
</body>
</html>
