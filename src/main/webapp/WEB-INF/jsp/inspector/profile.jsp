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
         <h2>Inspector info:</h2>
                         <label class="form-label">id:</label>
                         <label>${inspector.id}</label><br/><br/>

                         <label class="form-label">login:</label>
                         <label>${inspector.login}</label><br/><br/>

                         <label class="form-label">email:</label>
                         <label>${inspector.email}</label><br/><br/>

                         <label class="form-label">full name:</label>
                         <label>${inspector.fullName}</label><br/><br/>

                         <label class="form-label">complaints number:</label>
                         <label>${inspector.complaintNumber}</label><br/><br/>

                         <label class="form-label">reports in service:</label>
                         <label>${inspector.reportsInService}</label><br/><br/>
        </div>
    </body>
</html>