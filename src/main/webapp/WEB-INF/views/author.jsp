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
        <form:errors path="firstName" cssStyle="color: red"/>
    </label>

    <br><br>

    <label>Last name:
        <form:input type="text" path="lastName"/>
        <form:errors path="lastName" cssStyle="color: red"/>
    </label>

    <br><br>

    <label>Pesel:
        <form:input type="text" path="pesel"/>
        <form:errors path="pesel" cssStyle="color: red"/>
    </label>

    <br><br>

    <label>Email:
        <form:input type="text" path="email"/>
        <form:errors path="email" cssStyle="color: red"/>
    </label>

    <br><br>

    <label>Year of birth:
        <form:input type="number" path="yearOfBirth"/>
        <form:errors path="yearOfBirth" cssStyle="color: red"/>
    </label>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
