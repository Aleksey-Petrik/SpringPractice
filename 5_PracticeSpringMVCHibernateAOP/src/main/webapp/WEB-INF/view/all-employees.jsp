<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" value="Add" onclick="window.location.href = 'addEmployee'">
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th colspan="2">Operations</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <c:url var="editButton" value="/editEmployee">
                <c:param name="empId" value="${employee.id}"/>
            </c:url>
            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="empId" value="${employee.id}"/>
            </c:url>
            <tr>
                <th>${employee.name}</th>
                <th>${employee.surname}</th>
                <th>${employee.department}</th>
                <th>${employee.salary}</th>
                <th><input type="button" value="Edit" onclick="window.location.href = '${editButton}'"></th>
                <th><input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"></th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>