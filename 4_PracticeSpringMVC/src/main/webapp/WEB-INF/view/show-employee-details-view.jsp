<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--param.employeeName это имя текстового поля из которого мы берем значение после нажатия кнопки--%>
    <%--<h2>Hello employee ${param.employeeName}, ${employeeName}</h2>--%>
    <h4>Name - ${employee.name}</h4>
    <h4>Surname - ${employee.surname}</h4>
    <h4>Salary - ${employee.salary}</h4>
    <h4>Department - ${employee.department}</h4>
    <h4>Car Brand - ${employee.carBrand}</h4>
    <h4>Phone number - ${employee.phoneNumber}</h4>
    <h4>Email - ${employee.email}</h4>
    <h4>Languages:</h4>
    <ul>
        <c:forEach var="lang" items="${employee.languages}">
            <li>${lang}</li>
        </c:forEach>
    </ul>
</body>
</html>
