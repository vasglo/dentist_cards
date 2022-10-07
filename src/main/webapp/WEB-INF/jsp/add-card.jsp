<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vasa
  Date: 21.09.2022
  Time: 00:16
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
    <div class="create-box_header">Створити пацієнта</div>
    <form action="<spring:url value="/cards/create"/>" method="post" class="create-form" >
        Ім'я : <input type="text" name="firstName" />
        Прізвище : <input type="text" name="lastName" />
        По-батькові : <input type="text" name="middleName" />
        Номер телефону : <input type="text" name="phoneNumber" />
        Адреса : <input type="text" name="address" />
        Місце роботи : <input type="text" name="workPlace" />
        <input type="submit" />
    </form>
    <a href="<spring:url value="/cards/all"/>" class="btn-return">Назад</a>
</div>

</body>
</html>
