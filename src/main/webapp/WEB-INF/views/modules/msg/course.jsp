<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/8/1
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>课程管理</title>
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
        <a href="${ctx}/msg/course/">课程列表</a>
    </li>
        <shiro:hasPermission name="msg:course:edit">
    <li>
        <a href="${ctx}/msg/course/form">添加课程</a>
    </li>
        </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="course" action="${ctx}/msg/course/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <%--<label>类型：</label><form:select id="type" path="type" class="input-medium"><form:option value="" label=""/><form:options items="${typeList}" htmlEscape="false"/></form:select>
    &nbsp;&nbsp;--%>
    <label>描述 ：</label>
    <form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
    &nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
     <tr>
         <th>选择</th>
         <th>序号</th>
         <th>课程名</th>
             <shiro:hasPermission name="msg:course:edit">
         <th>操作</th>
             </shiro:hasPermission>
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="course" varStatus="vars">
     <tr>
         <
         <td>${vars.count}</td>
         <td>${course.name}</td>
         <shiro:hasPermission name="msg:course:edit"><td>
             <a href="${ctx}/msg/course/form?id=${course.id}">修改</a>
             <a href="${ctx}/msg/course/delete?id=${course.id}" onclick="return confirmx('确认要删除该课程吗？', this.href)">删除</a>
         </td></shiro:hasPermission>
     </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
