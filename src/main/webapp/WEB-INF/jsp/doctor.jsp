<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.example.demo.dvo.DoctorDVO" %><%--
  Created by IntelliJ IDEA.
  User: vasa
  Date: 21.09.2022
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="../css/style.css"%></style>
<%--    <script>--%>
<%--        function updateDoctorAndRedirect(){--%>

<%--            let xhr = new XMLHttpRequest();--%>
<%--            xhr.open("POST", "");--%>

<%--            xhr.setRequestHeader("Accept", "application/json");--%>
<%--            xhr.setRequestHeader("Content-Type", "application/json");--%>

<%--            let data = document.getElementById("update").value;--%>
<%--            xhr.send(data);--%>

<%--            location.href="/doctor/=" + data.id--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<%
    DoctorDVO doctor = (DoctorDVO) request.getAttribute("doctor");
%>
<form method="post" action="/doctors/update">
<label>
    <input type="text" hidden name="id" value="<%=doctor.getId()%>">
</label>
Прізвище<label>
    <input type="text" name="lastName" value="<%=doctor.getLastName()%>">
</label>
Ім'я<label>
    <input type="text" name="firstName" value="<%=doctor.getFirstName()%>">
</label>
По-батькові<label>
    <input type="text" name="middleName" value="<%=doctor.getMiddleName()%>">
</label>
Номер телефону<label>
    <input type="text" name="phoneNumber" value="<%=doctor.getPhoneNumber()%>">
</label>
Адрес<label>
    <input type="text" name="address" value="<%=doctor.getAddress()%>">
</label>
<button type="submit">Зберегти</button>
</form>
<a href="<spring:url value="/doctors/all"/>">Назад</a>
<br>

</body>
</html>
