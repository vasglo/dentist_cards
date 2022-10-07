<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vasa
  Date: 27.09.2022
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="../css/style.css"%></style>

</head>
<body>
<div class="create-box">
    <div class="create-box_header">Додати лікаря</div>
    <form action="<spring:url value="/doctors/create"/>" method="post" class="create-form" >
        Прізвище : <input type="text" name="lastName" />
        Ім'я : <input type="text" name="firstName" />
        По-батькові : <input type="text" name="middleName" />
        Номер телефону : <input type="text" name="phoneNumber" />
        Адреса : <input type="text" name="address" />
        <input type="submit" />
    </form>
    <a href="<spring:url value="/doctors/all"/>" class="btn-return">Назад</a>
</div>
</body>
</html>
