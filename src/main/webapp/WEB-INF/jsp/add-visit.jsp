<%@ page import="com.example.demo.dvo.DoctorDVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.demo.dvo.CardDVO" %>
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

<%--    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>--%>
<%--    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>--%>
<%--    <script>--%>
<%--        $( function() {--%>
<%--            $( "#datepicker" ).datepicker();--%>
<%--        } );--%>
<%--    </script>--%>
</head>
<body>
<% List<DoctorDVO> doctorsDVOs = (List<DoctorDVO>) request.getAttribute("doctors");
   CardDVO card = (CardDVO) request.getAttribute("card");
    HashMap<Long, String> map = new HashMap<>();
    for (DoctorDVO d : doctorsDVOs) {
        map.put(d.getId(),"".concat(d.getLastName()).concat(" ")
                .concat(d.getFirstName()).concat(" ")
                .concat(d.getMiddleName()));
    }
%>
<spring:url value="/cards/{cardId}" var="card" htmlEscape="true">
    <spring:param name="cardId" value="<%=card.getId().toString()%>"/>
</spring:url>

<div class="create-box">

    <div class="create-box_header">Створити відвідування</div>
    <form action="<spring:url value="/visit"/>" method="post" class="create-form" >
        Дата : <input type="date" id="datepicker" autocomplete="off" name="date" />
        Опис роботи : <input type="text" name="workDesc" />
        Зуб : <input type="text" name="teeth" />
        Сума : <input type="text" name="sum" />
        Пацієнт : <input type="text" disabled value="<%=card.getLastName()%>"/>
        <input type="text" hidden name="cardId" value="<%=card.getId()%>"/>
        Лікар :<select name="doctorId">
        <%
            for (Map.Entry<Long,String> el: map.entrySet()) {
        %>
        <option value="<%=el.getKey()%>"><%=el.getValue()%></option>
        <%
            }
        %>
    </select>
        <input type="submit" />
    </form>
    <a href="${card}" class="btn-return">Назад</a>
</div>
</body>
</html>
