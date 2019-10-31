<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposition List</title>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a proposition '" + title + "'?")) {
                window.location.href = "/propositions/delete/" + id;
            }
        }
    </script>
</head>
<body>

<jsp:include page="menu.jsp"/>

<table border="1">
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${props}" var="proposition">
        <tr>
            <td>${proposition.title}</td>
            <td>${proposition.description}</td>
            <td>
                <a href="/propositions/update/${proposition.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${proposition.id}, '${proposition.title}')">  Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
