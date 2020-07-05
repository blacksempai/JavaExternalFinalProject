<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<c:if test="${empty param.cookieLocale}">
<fmt:setLocale value="${cookie['lang'].value}" />
</c:if>
<c:if test="${not empty param.cookieLocale}">
<fmt:setLocale value="${param.cookieLocale}" />
</c:if>
<fmt:setBundle basename="site" />
<html>
    <head>
        <link rel="stylesheet" href="/css/styles.css">
        <meta charset="UTF-8">
    </head>
    <body>
    <div class="logo">
        TAX REPORTING
        <a href="/"><img id="home-logo" src="/graphics/home.png" height="20" width="30"></a>
        <a class="nav-link" href="/?cookieLocale=us"><img src="/graphics/us.png" height="20" width="30"></a>
        <a class="nav-link" href="/?cookieLocale=ua"><img src="/graphics/ua.png" height="20" width="30"></a>
        <a class="nav-link" href="/?cookieLocale=ru"><img src="/graphics/ru.png" height="20" width="30"></a>
        <a class="nav-link" href="/?cookieLocale=jp"><img src="/graphics/jp.png" height="20" width="30"></a>
    </div>
    <div class="home">
        <c:if test="${user!=null}">
                <a class="nav-link" href="/user/profile">${user.login}</a>
                <a class="nav-link" href="/user/all-reports"><fmt:message key="label.my-rep"/></a>
                <a class="nav-link" href="/user/new-report"><fmt:message key="label.new-rep"/></a>
                <a class="nav-link" href="/auth/sign-out"><fmt:message key="label.exit"/></a>
        </c:if>
        <c:if test="${inspector!=null}">
                <a class="nav-link" href="/inspector/profile">${inspector.login}</a>
                <a class="nav-link" href="/inspector/reports"><fmt:message key="label.ins-rep"/></a>
                <a class="nav-link" href="/auth/sign-out"><fmt:message key="label.exit"/></a>
        </c:if>

        <c:if test="${admin!=null}">
                <a class="nav-link" href="/admin/panel"><fmt:message key="label.panel"/></a>
                <a class="nav-link" href="/auth/sign-out"><fmt:message key="label.exit"/></a>
        </c:if>

        <c:if test="${user==null&&inspector==null&&admin==null}">
                <a class="nav-link" href="/auth/sign-up"><fmt:message key="label.reg"/></a>
                <a class="nav-link" href="/auth/sign-in"><fmt:message key="label.log"/></a>
        </c:if>
    </div>
    </body>
</html>