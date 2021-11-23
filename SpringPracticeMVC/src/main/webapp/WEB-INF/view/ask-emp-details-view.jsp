<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.11.2021
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Your name or message?</h2>
    <form:form action="showDetails" modelAttribute="employee"><%--modelAttribute задается обькт поля которого будут связаны с текстовыми полями формы--%>
        First name <form:input path="firstName"/><br><br><%--поля ввода текстовой информации--%>
        Last name <form:input path="lastName"/><br><br>
        Salary <form:input path="salary"/><br><br>
        Department <form:input path="department"/><br><br>
        <input type="submit" value="OK"><br><br>
    </form:form>
<%--
    <form action="showDetails" method="get">
        <input type="text" name="employeeName" placeholder="write your name"/>
        <input type="submit">
    </form>
--%>
</body>
</html>
