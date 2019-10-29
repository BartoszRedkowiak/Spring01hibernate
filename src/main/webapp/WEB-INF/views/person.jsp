<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>

<form:form action="/persons/add" method="post" modelAttribute="person">
    <label>Login
        <form:input path="login"/>
    </label>
    <label>Password
        <form:password path="password"/>
    </label>
    <label>Email
        <form:input path="email"/>
    </label>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
