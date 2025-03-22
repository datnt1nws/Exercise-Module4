<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Chuyển đổi USD sang VNĐ</title>
</head>
<body>
<h2>Chuyển đổi tiền tệ</h2>
<form:form method="post" modelAttribute="converterForm">
    Tỉ giá: <form:input path="rate" type="number" step="0.1" required="true"/><br>
    Số tiền USD: <form:input path="usd" type="number" step="0.01" required="true"/><br>
    <input type="submit" value="Chuyển Đổi">
</form:form>
<c:if test="${not empty result}">
    <h3>Kết Quả: ${result} VND</h3>
</c:if>
</body>
</html>