<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/8/3
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>学生管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {

        });
        function page(n,s){
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>

<ul class="nav nav-tabs">
    <li class="active">
        <a href="${ctx}/msg/student/">学生列表</a>
    </li>
    <shiro:hasPermission name="msg:student:edit">
        <li>
            <a href="${ctx}/msg/student/form">添加学生</a>
        </li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="student" action="${ctx}/msg/student/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <label>学生：</label>
    <%--<label>类型：</label>
    <form:select id="type" path="type" class="input-medium"><form:option value="" label=""/><form:options items="${typeList}" htmlEscape="false"/></form:select>
    &nbsp;&nbsp;--%>
    <%--<select style="margin-left:250px;float: left;width:100px;height: 40px" name="type" >
        <option value="name" name="">姓名</option>
        <option value="no">学号</option>
        <option value="age">年龄</option>
        <option value="grade">年级</option>
        <option value="stuclass">班级</option>
    </select>
    <%
    String temp=request.getParameter("type");
    %>
    <input maxlength="50" placeholder="请输入相关信息" class="input-medium"/>--%>
    <form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
    &nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>学号</th>
        <th>年龄</th>
        <th>年级</th>
        <th>班级</th>
        <shiro:hasPermission name="msg:student:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="student" varStatus="vars">
        <tr>
            <td>${vars.count}</td>
            <td>${student.name}</td>
            <td>${student.no}</td>
            <td>${student.age}</td>
            <td>${student.grade}</td>
            <td>${student.stuclass}</td>
            <shiro:hasPermission name="msg:student:edit">
            <td>
                <a href="">选课</a>
                <a href="${ctx}/msg/student/form?id=${student.id}">修改</a>
                <a href="${ctx}/msg/student/delete?id=${student.id}" onclick="return confirmx('确认要删除该课程吗？', this.href)">删除</a>
            </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>

