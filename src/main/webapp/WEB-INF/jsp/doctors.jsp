<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.example.demo.entity.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.dvo.DoctorDVO" %><%--
  Created by IntelliJ IDEA.
  User: vasa
  Date: 20.09.2022
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="../css/style.css"%></style>

</head>
<body>
<a href="<spring:url value="/cards/all"/>">Картки</a>
<a href="<spring:url value="/doctors/create"/>">Додати лікаря</a>

<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По-батькові</th>
        <th>Телефон</th>
        <th>Адреса</th>
        <th>Дії</th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 1;
        List<DoctorDVO> list = (List) request.getAttribute("doctors");
    %>

    <%
        for (DoctorDVO d : list) {
    %>
    <tr>
        <td><%=i++%></td>
        <td><%=d.getLastName()%></td>
        <td><%=d.getFirstName()%></td>
        <td><%=d.getMiddleName()%></td>
        <td><%=d.getPhoneNumber()%></td>
        <td><%=d.getAddress()%></td>
        <td>
            <spring:url value="/doctors/{id}" var="editUrl" htmlEscape="true">
                <spring:param name="id" value="<%=d.getId().toString()%>"/>
            </spring:url>
            <button type="button" onclick="location.href='${editUrl}'">Редагувати</button>
            <form action="card.jsp" method="post">
                <spring:url value="/doctors/delete?doctorId={doctorId}" var="deleteUrl" htmlEscape="true">
                    <spring:param name="doctorId" value="<%=d.getId().toString()%>"/>
                </spring:url>
                <button type="button" onclick="location.href='${deleteUrl}'">Видалити</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
