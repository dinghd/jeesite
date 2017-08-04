<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<title>成绩管理</title>
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
			<li><a href="${ctx}/sms/score/">成绩列表</a></li>
			<li class="active">
				<a href="${ctx}/sms/score/form?id=${score.id}">成绩${not empty score.id?'修改':'添加'}</a>
			</li>
		</ul><br/>
		<form:form id="inputForm" modelAttribute="score" action="${ctx}/sms/score/save" method="post" class="form-horizontal">
			<form:hidden path="id"/>
			<sys:message content="${message}"/>
			<div class="form-group">
				<label class="control-label">学生:</label>
				<c:choose>
					<c:when test="${not empty score.id}">
						<div class="controls">
							<input type="text" value="${score.student.name}" disabled class="input-xlarge required"	/>
						</div>
					</c:when>
					<c:otherwise>
						<div class="controls">
							<form:select path="student.name" items="${students}" itemLabel="name" itemValue="name" cssStyle="width: 30%;"/>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label">课程:</label>
				<c:choose>
					<c:when test="${not empty score.id}">
						<div class="controls">
							<input type="text" value="${score.course.name}" disabled class="input-xlarge required"	/>
						</div>
					</c:when>
					<c:otherwise>
						<div class="controls">
							<form:select path="course.name" items="${courses}" itemLabel="name" itemValue="name" cssStyle="width: 30%;" />
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label">成绩:</label>
				<div class="controls">
					<form:input path="score" htmlEscape="false" maxlength="200" class="input-xlarge required digits"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</form:form>
	</body>
</html>