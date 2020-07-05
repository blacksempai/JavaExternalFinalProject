<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Sign Up</title>
    </head>
    <body>
        <div class="header">
            <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
        </div>
        <div class="sign-form">
            <c:if test="${message!=null}">
                 <div style="color:red;">${message}</div><br/>
            </c:if>
            <form method="POST" action="sign-in">
                <label class="form-label"><fmt:message key="label.login"/></label>
                <input type="text" name="login" value="${param.login}"><br/><br/>

                <label class="form-label"><fmt:message key="label.password"/></label>
                <input type="password" name="password"><br/><br/>

                <input type="submit">
            </form>
        </div>
    </body>
</html>