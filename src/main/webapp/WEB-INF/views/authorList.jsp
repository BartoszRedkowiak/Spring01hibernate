<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <script>
        function confirmDelete(id, fullName) {
            if (confirm("Do you want to delete an author '" + fullName + "'?")) {
                window.location.href = "/authors/delete/" + id;
            }
        }
    </script>
</head>
<body>

<jsp:include page="menu.jsp"/>

<table border="1">
    <thead>
    <tr>
        <th>Full Name</th>
        <th>Books</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.fullName}</td>
            <td>
                <ul>
                    <c:forEach items="${author.books}" var="book">
                    <li>${book.title}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <a href="/authors/update/${author.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${author.id}, '${author.fullName}')">  Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
