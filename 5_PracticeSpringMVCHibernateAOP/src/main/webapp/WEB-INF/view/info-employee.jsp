<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        Имя <form:input path="name"/><form:errors path="name"/><br>
        Фамилия <form:input path="surname"/><form:errors path="surname"/><br>
        Подразделение <form:input path="department"/><form:errors path="department"/><br>
        Зарплата <form:input path="salary"/><br>
        <input type="submit" value="OK">
    </form:form>
</body>
</html>
