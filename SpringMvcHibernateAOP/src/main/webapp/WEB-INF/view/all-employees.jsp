<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.11.2021
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <th>${employee.name}</th>
                <th>${employee.surName}</th>
                <th>${employee.department}</th>
                <th>${employee.salary}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
