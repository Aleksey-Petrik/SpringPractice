<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="saveEmployee" modelAttribute="employee">
        Name <form:input path="name"/><form:errors path="name"/><br>
        Surname <form:input path="surname"/><form:errors path="surname"/><br>
        Department <form:input path="department"/><form:errors path="department"/><br>
        Salary <form:input path="salary" value = "0.00"/><form:errors path="salary"/><br>
        <input type="submit" value="OK">
    </form:form>
</body>
</html>
