<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/04/2025
  Time: 22:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
    <h1> Selected Condiments:</h1>
    <ul>
        <c:forEach var="condiment" items="${selectedCondiments}">
            <li>${condiment}</li>
        </c:forEach>
    </ul>
    <a href="/">Back to form</a>
</body>
</html>
