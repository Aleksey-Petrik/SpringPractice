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
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <th>${employee.name}</th>
                <th>${employee.surname}</th>
                <th>${employee.department}</th>
                <th>${employee.salary}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>