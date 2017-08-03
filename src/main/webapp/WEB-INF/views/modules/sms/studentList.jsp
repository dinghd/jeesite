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
        <title>学生列表</title>
        <meta name="decorator" content="default"/>
        <script type="text/javascript">
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
            <li class="active"><a href="${ctx}/sms/student/list">学生列表</a></li>
            <li>
                <a href="${ctx}/sms/student/form?id=${student.id}">学生${not empty site.id?'修改':'添加'}</a>
            </li>
        </ul>
        <form:form id="searchForm" modelAttribute="student" action="${ctx}/sms/student/" method="post" class="breadcrumb form-search">
            <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
            <label>姓名：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
        </form:form>
        <sys:message content="${message}"/>
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <thead>
                <tr>
                    <th>姓名</th>
                    <th>学号</th>
                    <th>年龄</th>
                    <th>年级</th>
                    <th>班级</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="student">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.no}</td>
                    <td>${student.age}</td>
                    <td>${student.grade}</td>
                    <td>${student.stuClass}</td>
                    <td>
                        <a href="${ctx}/sms/student/form?id=${student.id}">修改</a>
                        <a href="${ctx}/sms/student/delete?id=${student.id}${student.delFlag ne 0?'&isRe=true':''}" onclick="return confirmx('确认要${student.delFlag ne 0?'恢复':''}删除该站点吗？', this.href)" >${student.delFlag ne 0?'恢复':''}删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pagination">${page}</div>
    </body>
</html>
