<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.errors{
	color:red;
}
</style>
</head>
<body>
<h1>사원등록</h1>
<form:form action="empInsert" method="post" modelAttribute="emp">
<c:if test="${not empty emp.employeeId}">
<form:input path="employeeId" readonly="true" /><br>
</c:if>
<spring:message code="firstName"></spring:message>
<form:input path="firstName" placeholder="firstName" /><br>
<form:errors path="firstName" cssClass="errors" htmlEscape="false" /><br>

<spring:message code="lastName"></spring:message>
<form:input path="lastName" placeholder="lastName"/><br>
<form:errors path="lastName" cssClass="errors" htmlEscape="false"/><br>

<spring:message code="email"></spring:message>
<form:input path="email" placeholder="email"/><br>
<form:errors path="email" cssClass="errors" htmlEscape="false"/><br>

<form:select path="jobId">
	<form:option value="">job선택</form:option>
	<form:options items="${jobs}"
				itemLabel="jobTitle"
				itemValue="jobId"/>
</form:select><br>
<form:errors path="jobId" cssClass="errors" htmlEscape="false"/><br>

<form:input path="hireDate" placeholder="hireDate"/><br>
<form:errors path="hireDate" cssClass="errors"/><br>

<form:checkboxes items="${jobs}" path="departmentId"
						itemLabel="jobTitle"
						itemValue="jobId"/>
<form:select path="departmentId" items="${departments}"
				itemLabel="departmentName" itemValue="departmentId"/><br>
<form:errors path="departmentId" cssClass="errors"/><br>

<form:button>등록</form:button>
</form:form>
</body>
</html>