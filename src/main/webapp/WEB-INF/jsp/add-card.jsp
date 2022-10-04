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
<a href="<spring:url value="/cards/all"/>">Назад</a>
<form action="<spring:url value="/cards/create"/>" method="post" >
    Ім'я : <input type="text" name="firstName" />
    Прізвище : <input type="text" name="lastName" />
    По-батькові : <input type="text" name="middleName" />
    Номер телефону : <input type="text" name="phoneNumber" />
    Адреса : <input type="text" name="address" />
    Місце роботи : <input type="text" name="workPlace" />
    <input type="submit" />
</form>
</body>
</html>
