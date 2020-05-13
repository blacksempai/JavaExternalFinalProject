<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
    <head>
        <link rel="stylesheet" href="/css/styles.css">
        <meta charset="UTF-8">
    </head>
    <body>
    <div class="logo">
    TAX REPORTING
    <a href="/"><img id="home-logo" src="/graphics/home.png" height="20" width="20"></a>
    </div>
    <div class="home">
    <c:if test="${user!=null}">
            <a class="nav-link" href="/user/profile">${user.login}</a>
            <a class="nav-link" href="/user/all-reports">мои отчеты</a>
            <a class="nav-link" href="/user/new-report">новый отчет</a>
            <a class="nav-link" href="/auth/sign-out">выход</a>
    </c:if>
    <c:if test="${inspector!=null}">
            <a class="nav-link" href="/inspector/profile">${inspector.login}</a>
            <a class="nav-link" href="/inspector/reports">новые отчеты</a>
            <a class="nav-link" href="/auth/sign-out">выход</a>
    </c:if>

    <c:if test="${admin!=null}">
            <a class="nav-link" href="/admin/panel">admin panel</a>
            <a class="nav-link" href="/auth/sign-out">выход</a>
    </c:if>

    <c:if test="${user==null&&inspector==null&&admin==null}">
            <a class="nav-link" href="/auth/sign-up">регистрация</a>
            <a class="nav-link" href="/auth/sign-in">вход</a>
    </c:if>
    </div>
    </body>
</html>
