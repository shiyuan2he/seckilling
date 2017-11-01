<%@page contentType="text/html;charset=utf-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
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
            <div class="form-check">
                <label class="form-check-label">
                    <input class="form-check-input text-center" type="checkbox"> 记住我
                </label>
            </div>
            <input type="button" onclick="javascript:login.doLogin();" class="btn btn-info text-center" value="登陆" />
        </form>
    </div>
    <script type="text/javascript" src="<%=basePath%>/resources/script/login.js"></script>
</body>
</html>
