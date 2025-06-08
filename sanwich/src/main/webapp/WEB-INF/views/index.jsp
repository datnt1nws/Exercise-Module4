<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/04/2025
  Time: 22:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sanwich Condiments</title>
</head>
<body>
    <h1>Sanwich Condiments</h1>
    <form action="/save" method="post">
        <c:forEach var="condiment" items="${condiments}">
            <input type="checkbox" name="condiment" value="${condiment}"> ${condiment}
        </c:forEach>
        <br><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
