<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Validation</title>
</head>
<body>

<table border="2">
<tr>
    <th>Path</th>
    <th>Message</th>
</tr>
<c:forEach items="${fieldErrors}" var="error">
    <tr>
        <td>${error.path}</td>
        <td>${error.message}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
