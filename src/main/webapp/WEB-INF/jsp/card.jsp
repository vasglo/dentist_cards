<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.example.demo.dvo.CardDVO" %>
<%@ page import="com.example.demo.dvo.VisitDVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
<%--    <link href="../css/style.css" rel="stylesheet" type="text/css">--%>
    <style><%@include file="../css/style.css"%></style>
</head>
<body>
<%
    CardDVO cardDVO = (CardDVO) request.getAttribute("cardById");
%>
<div class="create-box">
    <div class="create-box_header">Відвідування</div>
    <div class="create-form visiting">
        <label><span>Прізвище</span>
        <input type="text" name="lastName" value="<%=cardDVO.getLastName()%>">
    </label>
       <label> <span>Ім'я</span>
        <input type="text" name="firstName" value="<%=cardDVO.getFirstName()%>">
    </label>
       <label> <span>По-батькові</span>
        <input type="text" name="middleName" value="<%=cardDVO.getMiddleName()%>">
    </label>
        <label><span>Hомер телефону</span>
        <input type="text" name="phoneNumber" value="<%=cardDVO.getPhoneNumber()%>">
    </label>
       <label> <span>Адреса</span>
        <input type="text" name="address" value="<%=cardDVO.getAddress()%>">
    </label>
        <label><span>Місце роботи</span>
        <input type="text" name="workPlace" value="<%=cardDVO.getWorkPlace()%>">
    </label>
        <a href="<spring:url value="/cards/all"/>" class="btn-return">Назад</a>
    </div>

</div>

<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Дата</th>
        <th>Зуб</th>
        <th>Опис виконаної роботи</th>
        <th>Сума</th>
        <th>Лікар</th>
        <th>Дії</th>
        <spring:url value="/visit/new?cardId={id}" var="url" htmlEscape="true">
            <spring:param name="id" value="<%=cardDVO.getId().toString()%>"/>
        </spring:url>
        <th><a href="${url}">Створити відвідування</a></th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 1;
        List<VisitDVO> visitList = cardDVO.getVisitList();
    %>

    <%
        if (visitList==null) {
            visitList = new ArrayList<>();
        }
        for (VisitDVO v : visitList) {
    %>
    <tr>
        <td><%=i++%></td>
        <td><%=v.getDate()%></td>
        <td><%=v.getTeeth()%></td>
        <td><%=v.getWorkDesc()%></td>
        <td><%=v.getSum()%></td>
        <td><%=v.getDoctorName()%></td>
        <td>
            <spring:url value="/visit/{id}" var="editUrl" htmlEscape="true">
                <spring:param name="id" value="<%=v.getId().toString()%>"/>
            </spring:url>
            <button type="button" onclick="location.href='${editUrl}'">Редагувати</button>
            <form action="card.jsp" method="post">
                <spring:url value="/visit/delete?visitId={visitId}&cardId={cardId}" var="deleteUrl" htmlEscape="true">
                    <spring:param name="cardId" value="<%=cardDVO.getId().toString()%>"/>
                    <spring:param name="visitId" value="<%=v.getId().toString()%>"/>
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
