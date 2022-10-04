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
<a href="<spring:url value="/doctors/all"/>">Назад</a>
<form action="<spring:url value="/doctors/create"/>" method="post" >
    Ім'я : <input type="text" name="firstName" />
    Прізвище : <input type="text" name="lastName" />
    По-батькові : <input type="text" name="middleName" />
    Номер телефону : <input type="text" name="phoneNumber" />
    Адреса : <input type="text" name="address" />
    <input type="submit" />
</form>
</body>
</html>
