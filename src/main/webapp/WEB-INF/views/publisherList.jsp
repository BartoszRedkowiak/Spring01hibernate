<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher List</title>
    <script>
        function confirmDelete(id, name) {
            if (confirm("Do you want to delete a publisher '" + name + "'?")) {
                window.location.href = "/publishers/delete/" + id;
            }
        }
    </script>
</head>
<body>

<jsp:include page="menu.jsp"/>

<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Books</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td>
                <ul>
                    <c:forEach items="${publisher.books}" var="book">
                        <li>${book.title}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <a href="/publishers/update/${publisher.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${publisher.id}, '${publisher.name}')">  Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
