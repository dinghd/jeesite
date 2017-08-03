<%--
  Created by IntelliJ IDEA.
  User: Gaowang
  Date: 2017-08-01
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>书籍管理</title>
    <meta name="decorator" content="default"/>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sms/book/list">书籍列表</a></li>
</ul>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead><tr><th>书籍名称</th><th>作者</th></tr></thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
