<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>


</head>
<body>

<jsp:include page="menu.jsp"/>

    <form:form method="post" modelAttribute="book">

        <label>Title:
            <form:input path="title"/>
            <form:errors path="title" element="div" cssStyle="color:red"/>
        </label>
        <label>Rating:
            <form:select path="rating">
                <c:forEach begin="1" end="10" var="number">
                    <form:option value="${number}"/>
                </c:forEach>
            </form:select>
            <form:errors path="rating" element="div" cssStyle="color:red"/>

        </label>

        <br><br>

        <label>Pages:
            <form:input path="pages"/>
            <form:errors path="pages" element="div" cssStyle="color:red"/>
        </label>

        <br><br>

        <label>Description:
            <form:input path="description"/>
            <form:errors path="description" element="div" cssStyle="color:red"/>
        </label>

        <br><br>

        <label>Publisher:
            <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" />
            <form:errors path="publisher" element="div" cssStyle="color:red"/>
        </label>

        <br><br>

        <label>Authors:
            <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id" />
            <form:errors path="authors" element="div" cssStyle="color:red"/>
        </label>


        <input type="submit" value="Save">


    </form:form>

</body>
</html>
