<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<form:form method="post" modelAttribute="author">

    <label>First name:
        <form:input type="text" path="firstName"/>
    </label>

    <br><br>

    <label>Last name:
        <form:input type="text" path="lastName"/>
    </label>

    <br><br>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
