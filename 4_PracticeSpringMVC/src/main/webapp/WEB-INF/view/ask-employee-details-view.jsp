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
        <form:errors path="name"/>
        <br><br>
        Surname <form:input path="surname"/>
        <form:errors path="surname"/>
        <br><br>
        Salary <form:input path="salary"/>
        <form:errors path="salary"/>
        <br><br>
        Phone number <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
        <br><br>
        Email <form:input path="email"/>
        <form:errors path="email"/>
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
        <br><br>
        Languages ?
<%--        EN <form:checkbox path="languages" value="English"/>
        DE <form:checkbox path="languages" value="Deutch"/>
        FR <form:checkbox path="languages" value="French"/>--%>
        <br><br>
        <form:checkboxes path="languages" items="${employee.languageList}"/>
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