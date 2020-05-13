<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <label class="form-label">login:</label>
                <input type="text" name="login" value="${param.login}"><label style="color:red;">*</label><br/><br/>

                <label class="form-label">password:</label>
                <input type="password" name="password"><label style="color:red;">*</label><br/><br/>

                <label class="form-label">password again:</label>
                <input type="password" name="passwordConfirm"><label style="color:red;">*</label><br/><br/>

                <label class="form-label">email:</label>
                <input type="text" name="email" value="${param.email}"><label style="color:red;">*</label><br/><br/>

                <label class="form-label">full name:</label>
                <input type="text" name="full_name" value="${param.full_name}"><br/><br/>

                <label class="form-label">company name:</label>
                <input type="text" name="company" value="${param.company}"><br/><br/>

                <input type="submit">
            </form>
        </div>
    </body>
</html>