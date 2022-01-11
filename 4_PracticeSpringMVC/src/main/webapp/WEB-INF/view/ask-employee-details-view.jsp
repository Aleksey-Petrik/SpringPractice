<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="showDetails" modelAttribute="employee">
        Name <form:input path="name"/>
        <br><br>
        Surname <form:input path="surname"/>
        <br><br>
        Salary <form:input path="salary"/>
        <br><br>
        <input type="submit" value="OK">
    </form:form>
<%--
    <form action="showDetails" method="get">
        <input type="text" name="employeeName" placeholder="Write your name"/>
        <input type="submit">
    </form>
--%>
</body>
</html>