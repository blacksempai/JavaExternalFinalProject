<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Panel</title>
    </head>
    <body>
        <div class="header">
            <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
        </div>
        <c:if test="${message!=null}">
        <div style="color:red;">${message}</div><br/>
        </c:if>
        <table>
            <tr>
                <td>id</td>
                <td>login</td>
                <td>password</td>
                <td>full name</td>
                <td>email</td>
                <td>complaints</td>
                <td>service</td>
            </tr>
            <c:forEach var="i" items="${inspectors}">
            <form action="change?id=${i.id}" method="POST">
                <tr>
                    <td><input type="text" value="${i.id}" readonly/></td>
                    <td><input type="text" value="${i.login}" name="login"></td>
                    <td><input type="text" value="" name="password"></td>
                    <td><input type="text" value="${i.fullName}" name="full_name"></td>
                    <td><input type="text" value="${i.email}" name="email"></td>
                    <td><input type="text" value="${i.complaintNumber}" name="complaints"></td>
                    <td><input type="text" value="${i.reportsInService}" name="service"></td>
                    <td><input type="submit" value="Change"></td>
                </tr>
            </form>
            </c:forEach>

            <form action="add" method="POST">
            <tr>
                <td><input type="text" value="?" readonly/></td>
                <td><input type="text" value="" name="login"></td>
                <td><input type="text" value="" name="password"></td>
                <td><input type="text" value="" name="full_name"></td>
                <td><input type="text" value="" name="email"></td>
                <td><input type="text" value="" name="complaints"></td>
                <td><input type="text" value="" name="service"></td>
                <td><input type="submit" value="Add New"></td>
            </tr>
            </form>

        </table>
    </body>
</html>