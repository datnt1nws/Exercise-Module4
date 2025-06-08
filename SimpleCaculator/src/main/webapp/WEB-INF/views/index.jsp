<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Calculator</title></head>
<body>
<h1>Calculator</h1>
<form action="calculator" method="get">
    <input type="number" name="num1" value="12" step="any" required><br>
    <input type="number" name="num2" value="12" step="any" required><br>
    <input type="submit" name="operation" value="addition(+)">
    <input type="submit" name="operation" value="subtraction(-)">
    <input type="submit" name="operation" value="multiplication(X)">
    <input type="submit" name="operation" value="division(/)">
</form>
</body>
</html>