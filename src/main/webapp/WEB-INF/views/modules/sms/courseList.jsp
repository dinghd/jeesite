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
        <title>课程列表</title>
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
            <li class="active"><a href="${ctx}/sms/course/list">课程列表</a></li>
            <li>
                <a href="${ctx}/sms/course/form?id=${course.id}">课程${not empty site.id?'修改':'添加'}</a>
            </li>
        </ul>
        <form:form id="searchForm" modelAttribute="course" action="${ctx}/sms/course/" method="post" class="breadcrumb form-search">
            <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
            <label>课程名称：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
        </form:form>
        <sys:message content="${message}"/>
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <thead>
                <tr>
                    <th>书籍名称</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.list}" var="course">
                <tr>
                    <td>${course.name}</td>
                    <td>
                        <a href="${ctx}/sms/course/form?id=${course.id}">修改</a>
                        <a href="${ctx}/sms/course/delete?id=${course.id}${course.delFlag ne 0?'&isRe=true':''}" onclick="return confirmx('确认要${course.delFlag ne 0?'恢复':''}删除该站点吗？', this.href)" >${course.delFlag ne 0?'恢复':''}删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pagination">${page}</div>
    </body>
</html>
