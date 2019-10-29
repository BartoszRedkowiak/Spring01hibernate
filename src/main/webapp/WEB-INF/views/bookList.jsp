<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a book '" + title + "'?")) {
                window.location.href = "/books/delete/" + id;
            }
        }
    </script>
</head>
<body>

<table border="1">
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Publisher</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
            <td>
                <a href="/books/update/${book.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">  Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
