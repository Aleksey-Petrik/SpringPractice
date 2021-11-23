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
    <h2>Your name or message!</h2>
    <br>
    <%--<h3>${param.employeeName}</h3>--%><%--взятие атрибута из имени поля--%>
    <%--<h3>${nameAttribute} - ${description}</h3><%--взятие атрибута из модели model--%>
    <h3>First name - ${employee.firstName}</h3>
    <h3>Last name - ${employee.lastName}</h3>
    <h3>Salary - ${employee.salary}</h3>
    <h3>Department - ${employee.department}</h3>
</body>
</html>
