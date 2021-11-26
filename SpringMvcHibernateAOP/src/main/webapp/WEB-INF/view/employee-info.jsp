<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.11.2021
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        Name <form:input path="name"/><br><br>
        Surname <form:input path="surName"/><br><br>
        Department <form:input path="department"/><br><br>
        Salary <form:input path="salary"/><br><br>
        <input type="submit" value="OK">
    </form:form>
</body>
</html>
