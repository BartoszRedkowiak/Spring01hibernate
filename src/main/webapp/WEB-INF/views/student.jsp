<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>

<form:form method="post" action="/students/add" modelAttribute="student">

    <div>
    <label>First name
        <form:input type="text" path="firstName"/>
    </label>
    </div>

    <div>
    <label>Last name
        <form:input type="text" path="lastName"/>
    </label>
    </div>

    <div>Gender
        <label>Male:
            <form:radiobutton path="gender" value="male"/>
        </label>
        <label>Female:
            <form:radiobutton path="gender" value="female"/>
        </label>
    </div>

    <div>
    <label>Country
        <form:select path="country" items="${countries}"/>
    </label>
    </div>

    <div>
    <label>Notes
        <form:textarea path="notes" rows="3" cols="20"/>
    </label>
    </div>

    <div>
    <label for="mailingListId">Mailing list
        <form:checkbox path="mailingList" id="mailingListId"/>
    </label>
    </div>

    <div>
    <label for="skillId">Programming skills
        <form:select path="programmingSkills" items="${skills}" id="skillId"/>
    </label>
    </div>

    <div>
    <label for="hobbiesId">Hobbies
        <form:checkboxes path="hobbies" items="${hobbies}" id="hobbiesId"/>
    </label>
    </div>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
