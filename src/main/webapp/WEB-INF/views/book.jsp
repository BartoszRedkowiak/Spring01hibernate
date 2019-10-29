<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>


</head>
<body>

    <form:form method="post" modelAttribute="book">

        <label>Title:
            <form:input path="title"/>
        </label>
        <label>Rating:
            <form:select path="rating">
                <c:forEach begin="1" end="10" var="number">
                    <form:option value="${number}"/>
                </c:forEach>
            </form:select>
        </label>

        <br><br>

        <label>Description:
            <form:input path="description"/>
        </label>

        <br><br>

        <label>Publisher:
            <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" />
        </label>

        <br><br>

        <label>Authors:
            <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id" />
        </label>


        <input type="submit" value="Save">


    </form:form>

</body>
</html>
