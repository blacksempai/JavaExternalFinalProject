<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${empty param.cookieLocale}">
<fmt:setLocale value="${cookie['lang'].value}" />
</c:if>
<c:if test="${not empty param.cookieLocale}">
<fmt:setLocale value="${param.cookieLocale}" />
</c:if>
<fmt:setBundle basename="site" />
<html>
<head>
    <meta charset="UTF-8">
    <title>Reports</title>
</head>
<body>
    <div class="header">
        <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
    </div>
<div class="content">
<c:forEach var="report" items="${reports}">
    <c:if test="${report.status == 'PENDING'}">
        <label class="status-label" style="color:grey;">
        <a href="my-report?id=${report.id}"><fmt:message key="label.report"/>:${report.id} <fmt:message key="label.date"/>:${report.declarationSubmissionDate}</a>: status = ${report.status}</label>
        <label class="inspector-label"><fmt:message key="label.checker"/> ${report.inspector.fullName}</label>
        <a href="change-inspector?id=${report.id}"><fmt:message key="label.chng"/></a>
        <a href="delete-report?id=${report.id}"><fmt:message key="label.delete"/></a>
    </c:if>
    <c:if test="${report.status == 'DECLINED'}">
        <label class="status-label" style="color:red;">
        <a href="report-edit?id=${report.id}">Звіт:${report.id} Дата:${report.declarationSubmissionDate}</a>:status = ${report.status}</label>
        <label class="inspector-label">Перевіряючий: ${report.inspector.fullName}</label>
        <a href="change-inspector?id=${report.id}">змінити</a>
        <a href="delete-report?id=${report.id}">видалити</a>
    </c:if>
    <c:if test="${report.status == 'ACCEPTED'}">
        <label class="status-label" style="color:green;">
        <a href="my-report?id=${report.id}">Звіт:${report.id} Дата:${report.declarationSubmissionDate}</a>: status = ${report.status}</label>
        <label class="inspector-label">Перевіряючий: ${report.inspector.fullName}</label>
    </c:if>
    <br>
</c:forEach>
</div>
</body>
</html>