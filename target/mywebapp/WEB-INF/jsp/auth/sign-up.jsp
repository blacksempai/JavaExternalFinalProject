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
            <form method="POST" action="sign-up">
                <label class="form-label"><fmt:message key="label.login"/></label>
                <input class="reg-input" type="text" name="login" value="${param.login}"><label style="color:red;">*</label><br/><br/>

                <label class="form-label"><fmt:message key="label.password"/></label>
                <input class="reg-input" type="password" name="password"><label style="color:red;">*</label><br/><br/>

                <label class="form-label"><fmt:message key="label.password-a"/></label>
                <input class="reg-input" type="password" name="passwordConfirm"><label style="color:red;">*</label><br/><br/>

                <label class="form-label"><fmt:message key="label.email"/></label>
                <input class="reg-input" type="text" name="email" value="${param.email}"><label style="color:red;">*</label><br/><br/>

                <label class="form-label"><fmt:message key="label.full"/></label>
                <input class="reg-input" type="text" name="full_name" value="${param.full_name}"><label style="color:red;">*</label><br/><br/>

                <label class="form-label"><fmt:message key="label.company"/></label>
                <input class="reg-input" type="text" name="company" value="${param.company}"><br/><br/>

                <label class="form-label"><fmt:message key="label.passport"/></label>
                <input class="reg-input" type="text" name="passport" value="${param.passport}"><label style="color:red;">*</label><br/><br/>

                <label class="form-label"><fmt:message key="label.address"/></label>
                <input class="reg-input" type="text" name="address" value="${param.address}"><label style="color:red;">*</label><br/><br/>

                <label style="color:red;">*</label><label class="form-label"><fmt:message key="label.tax"/></label><br/>

                <label class="form-label"></label><label class="r-label"><fmt:message key="label.first"/></label>
                <input type="radio" name="group" value="first"><br>

                <label class="form-label"></label><label class="r-label"><fmt:message key="label.second"/></label>
                <input type="radio" name="group" value="second"><br>

                <label class="form-label"></label><label class="r-label"><fmt:message key="label.third"/></label>
                <input type="radio" name="group" value="third"><br><br>

                <input type="submit">
            </form>
        </div>
    </body>
</html>