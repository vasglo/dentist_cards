<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.dvo.CardDVO" %>
<%@ page import="com.example.demo.dvo.DoctorDVO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: vasa
  Date: 20.09.2022
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="../css/style.css"%></style>

    <title>Title</title>
    <%--    <script type="text/javascript" src="cards-scripts.js"></script>--%>
    <script>
        function nameF() {
            let x = document.getElementById("mySelect").value;
            let y = document.getElementById("search").value;
            if (y){
                location.href = "/cards/all-by-last-name?lastName=" + y.toString()
            } else if (x){
                location.href = "/cards/all_by_doctor?doctorId=" + x
            }
        }
    </script>
</head>
<body>
<% List<DoctorDVO> doctorsDVOs = (List<DoctorDVO>) request.getAttribute("doctors");
    HashMap<Long, String> map = new HashMap<>();
    if (doctorsDVOs != null && !doctorsDVOs.isEmpty()) {
        for (DoctorDVO d : doctorsDVOs) {
            map.put(d.getId(), "".concat(d.getLastName()).concat(" ")
                    .concat(d.getFirstName()).concat(" ")
                    .concat(d.getMiddleName()));
        }
    }
%>
<a href="<spring:url value="/doctors/all"/>">Лікарі</a>
<a href="<spring:url value="/cards/create"/>">Створити картку</a>
<form>
    Лікар :<select id="mySelect" onchange="nameF()" name="doctorId">
    <%
        Long doctorId = (Long) request.getAttribute("doctorId");
        for (Map.Entry<Long, String> el : map.entrySet()) {
    %>
    <option value="<%=el.getKey()%>" <%if(el.getKey().equals(doctorId)){%>selected<%}%>><%=el.getValue()%>
    </option>
    <%
        }
    %>
</select>
</form>
<a href="<spring:url value="/cards/all"/>">Скинути</a>
<br>
<form>
    <input type="search" id="search" name="lastName" onchange="nameF()">
</form>
<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>ID</th>
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
        List<CardDVO> list = (List) request.getAttribute("cardsList");
    %>

    <%
        for (CardDVO c : list) {
    %>
    <tr>
        <td><%=i++%>
        </td>
        <td><%=c.getId()%>
        </td>
        <td><%=c.getLastName()%>
        </td>
        <td><%=c.getFirstName()%>
        </td>
        <td><%=c.getMiddleName()%>
        </td>
        <td><%=c.getPhoneNumber()%>
        </td>
        <td><%=c.getAddress()%>
        </td>
        <td>
            <spring:url value="/cards/{id}" var="url" htmlEscape="true">
                <spring:param name="id" value="<%=c.getId().toString()%>"/>
            </spring:url>
            <button type="button" onclick="location.href='${url}'">Редагувати</button>
            <spring:url value="/cards/delete?cardId={cardId}" var="deleteUrl" htmlEscape="true">
                <spring:param name="cardId" value="<%=c.getId().toString()%>"/>
            </spring:url>
            <button type="button" onclick="location.href='${deleteUrl}'">Видалити</button>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%--<script type="text/javascript" src="./cards-scripts.js"></script>--%>
</body>
</html>
