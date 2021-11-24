<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Ask details</title>
</head>
<body>
    <h2>Your name or message?</h2>
    <form:form action="showDetails" modelAttribute="employee"><%--modelAttribute задается обькт поля которого будут связаны с текстовыми полями формы--%>
        First name <form:input path="firstName"/><%--поля ввода текстовой информации--%>
        <form:errors path="firstName"/>
        <br><br>
        Last name <form:input path="lastName"/>
        <form:errors path="lastName"/>
        <br><br>
        Salary <form:input path="salary"/>
        <form:errors path="salary"/>
        <br><br>
        Department:
        <form:select path="department"><%--форма выбора из открывающегося списка--%>
            <form:options items="${employee.departments}"/>
        </form:select>
        <br>
        <h4>Which car do yuo want?</h4>
        <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
        <br>
        <h4>Foreign Language(s)</h4>
        <form:checkboxes path="languages" items="${employee.listLanguages}"/>
        <br><br>
        Phone number <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
        <br><br>
        Email <form:input path="email"/>
        <form:errors path="email"/>
        <br><br>
        <input type="submit" value="OK"><br><br>
    </form:form>
    <%--форма выбора из открывающегося списка
    <form:select path="department">
        <form:option value="Information Tehnology" label="IT"/>
        <form:option value="Human Resources" label="HR"/>
        <form:option value="Sales" label="Sales"/>
    </form:select>

    <form:radiobutton path="carBrand" value="BMW"/> BMW
    <form:radiobutton path="carBrand" value="OPEL"/> OPEL
    <form:radiobutton path="carBrand" value="LADA"/> LADA

    EN <form:checkbox path="languages" value="English"/>
    DE <form:checkbox path="languages" value="Deutch"/>
    FR <form:checkbox path="languages" value="French"/>
    --%>
    <%--
    <form action="showDetails" method="get">
        <input type="text" name="employeeName" placeholder="write your name"/>
        <input type="submit">
    </form>
    --%>
</body>
</html>
