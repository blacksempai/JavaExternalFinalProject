<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Reports</title>
    </head>
    <body>
        <div class="header">
            <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
        </div>
        <div align="center">
            <c:if test="${empty reports}">
                Нових декларацій немає
            </c:if>
            <c:forEach var="report" items="${reports}">
                <a href="review?id=${report.id}">Звіт:${report.id} Дата:${report.declarationSubmissionDate} Пользователь:${report.user.login}</a><br>
            </c:forEach>
        </div>
    </body>
</html>