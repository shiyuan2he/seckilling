<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀列表页</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <c:if test="${sso_key_user_session.mobile != null}">
                    <h4>${sso_key_user_session.mobile}</h4>
                    <span id="logout" onclick="login.logout();"><h4>退出</h4></span>
                </c:if>
                <c:if test="${sso_key_user_session.mobile == null}">
                    <a href="/"><h4>登陆</h4></a>
                </c:if>
            </div>
            <div class="panel-heading text-center">
                <h2>秒杀列表</h2>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>名称</th>
                            <th>库存</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>创建时间</th>
                            <th>详情</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="seckilling">
                            <tr>
                                <td>${seckilling.name}</td>
                                <td>${seckilling.number}</td>
                                <td><fmt:formatDate value="${seckilling.startTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                                <td><fmt:formatDate value="${seckilling.endTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                                <td><fmt:formatDate value="${seckilling.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                                <td>
                                    <a class="btn btn-info" href="/seckilling/${seckilling.id}/detail" target="_blank">link</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="<%=basePath%>/resources/script/login.js"></script>
</body>
</html>
