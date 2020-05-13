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
         <h2>User info:</h2>
                         <label class="form-label">id:</label>
                         <label>${user.id}</label><br/><br/>

                         <label class="form-label">login:</label>
                         <label>${user.login}</label><br/><br/>

                         <label class="form-label">company name:</label>
                         <label>${user.company}</label><br/><br/>

                         <label class="form-label">email:</label>
                         <label>${user.email}</label><br/><br/>

                         <label class="form-label">full name:</label>
                         <label>${user.fullName}</label><br/><br/>
        </div>
    </body>
</html>