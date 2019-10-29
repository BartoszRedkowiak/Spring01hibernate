<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Publisher</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<form:form method="post" modelAttribute="publisher">

    <label>Name:
        <form:input type="text" path="name"/>
    </label>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
