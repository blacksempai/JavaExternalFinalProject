<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<c:if test="${empty param.cookieLocale}">
<fmt:setLocale value="${cookie['lang'].value}" />
</c:if>
<c:if test="${not empty param.cookieLocale}">
${cookieLocale}
<fmt:setLocale value="${param.cookieLocale}" />
</c:if>
<fmt:setBundle basename="site" />

<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div class="header">
            <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
        </div>
        <div class="content"">
            <h1 align="center"><fmt:message key="label.name"/></h1>
            <p>
                <fmt:message key="label.text1"/>
            </p>
            <p>
                <fmt:message key="label.text2"/><br>
            </p>
            <p align="center">
                <b><fmt:message key="label.text3"/></b><br>
                <a href="https://tax.gov.ua"><img src="/graphics/banner_us.PNG"></a>

            </p>
        </div>
    </body>
</html>
