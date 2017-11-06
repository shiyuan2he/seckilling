<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<html>
<head>
    <title>注册</title>
    <%@include file="../common/head.jsp"%>
</head>
<body>
    <div class="container">
        <h2 class="text-center">注册</h2>
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
                <label for="password" class="text-left">
                    重复密码:
                    <input type="password" class="form-control" id="repassword" placeholder="请再次输入密码">
                </label>
            </div>
            <div class="form-group">
                <label for="verifyCode" class="text-left">
                    验证码:
                    <input type="text" class="form-control" id="verifyCode" placeholder="请输入验证码">
                </label>
            </div>
            <%--<div class="form-group">
                <label for="password" class="text-left">
                    短信验证码:
                    <input type="password" class="form-control" id="password" placeholder="请输入短信验证码">
                </label>
            </div>--%>
            <input type="button" onclick="javascript:reg.doReg();" class="btn btn-info text-center" value="注册" />
        </form>
    </div>
    <script type="text/javascript" src="<%=basePath%>/resources/java-resource/script/js/ajax.js"></script>
    <script type="text/javascript" >var path = '<%=basePath%>' ;</script>
    <script type="text/javascript" src="<%=basePath%>/resources/script/reg.js"></script>
</body>
</html>
