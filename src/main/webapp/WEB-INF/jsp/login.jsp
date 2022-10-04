<%--
  Created by IntelliJ IDEA.
  User: us804
  Date: 9/12/2022
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>First Web Application</title>
</head>

<body>
<font color="red">${errorMessage}</font>
<form method="post">
    Name : <input type="text" name="name" />
    Password : <input type="password" name="password" />
    <input type="submit" />
</form>
</body>

</html>