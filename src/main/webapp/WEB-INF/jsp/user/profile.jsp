<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${cookie['lang'].value}" />
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
         <h2>User info:</h2>
                         <label class="form-label">id:</label>
                         <label>${user.id}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.login"/></label>
                         <label>${user.login}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.company"/></label>
                         <label>${user.company}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.email"/></label>
                         <label>${user.email}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.full"/></label>
                         <label>${user.fullName}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.passport"/></label>
                         <label>${user.passport}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.address"/></label>
                         <label>${user.address}</label><br/><br/>

                         <label class="form-label"><fmt:message key="label.tax"/></label>
                         <label>${user.group}</label><br/><br/>
        </div>
    </body>
</html>