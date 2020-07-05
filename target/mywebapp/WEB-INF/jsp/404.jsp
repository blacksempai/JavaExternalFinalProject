<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>404</title>
    </head>
    <body>
        <div class="header">
            <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
        </div>
        <div id="er" class="error">
            ERROR 404 <br>
            PAGE NOT FOUND <br>
            <img src="/graphics/trueno.gif" onclick="document.getElementById('er').className='error-alternative'">
        </div>
    </body>
</html>