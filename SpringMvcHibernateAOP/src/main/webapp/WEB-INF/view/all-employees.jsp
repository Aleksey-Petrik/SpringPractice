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
            <!--формируем ссылку с параметром id работника-->
            <c:url var="updateButton" value="/updateInfo">
                <c:param name="empId" value="${employee.id}"/>
            </c:url>
            <tr>
                <td>${employee.name}</td>
                <td>${employee.surName}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td><input type="button" value="Update" id="${employee.id}" onclick="window.location.href = '${updateButton}'"/></td>
                <td><input type="button" value="Delete" onclick="window.location.href = ''"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="Add" onclick="window.location.href = 'addNewEmployee'"/>
</body>
</html>
