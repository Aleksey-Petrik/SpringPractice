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
<%--        Department <form:select path="department">
            <form:option value="Information Technology" label="IT"/>
            <form:option value="Human Resources" label="HR"/>
            <form:option value="Sales" label="Sales"/>
        </form:select>--%>
        Department <form:select path="department">
            <form:options items="${employee.departments}"/>
        </form:select>
        <br><br>
        Car Brand?
<%--        <form:radiobutton path="carBrand" label="BMW"  value="BMW"/>
        <form:radiobutton path="carBrand" label="LADA" value="LADA"/>
        <form:radiobutton path="carBrand" label="OPEL" value="OPEL"/>--%>
        <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
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