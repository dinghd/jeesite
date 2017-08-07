<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2017/8/2
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>提交表单</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#name").focus();
            $("#inputForm").validate({
                submitHandler: function(form){
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function(error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/msg/course/">课程列表</a></li>
    <li class="active">
        <a href="${ctx}/msg/course/form?id=${course.id}">课程
            <shiro:hasPermission name="msg:course:edit">
                ${not empty course.id ? '修改' : '添加'}
            </shiro:hasPermission>
            <shiro:lacksPermission name="msg:course:edit">
                查看
            </shiro:lacksPermission>
        </a>
    </li>
</ul><br/>
<form:form id="inputForm" modelAttribute="course" action="${ctx}/msg/course/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>

    <div class="control-group">
        <label class="control-label">课程名：</label>
        <div class="controls">
            <%--<input id="oldCourseName" name="oldCourseName" type="hidden" value="${course.name}">--%>
            <form:input path="name" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>

    <div class="form-actions">
        <%--<c:if test="${course.status ne '1'}">--%>
            <shiro:hasPermission name="msg:course:edit">
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
            </shiro:hasPermission>
        <%--</c:if>--%>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>
