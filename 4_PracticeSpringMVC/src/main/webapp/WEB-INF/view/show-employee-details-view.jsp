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
</body>
</html>
