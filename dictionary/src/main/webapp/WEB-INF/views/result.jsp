<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Kết quả tra cứu</title>
</head>
<body>
<h2>Kết quả:</h2>
<% if (request.getAttribute("word") != null) { %>
<p><strong>Từ:</strong> <%= request.getAttribute("word") %></p>
<p><strong>Nghĩa:</strong> <%= request.getAttribute("meaning") %></p>
<% } else { %>
<p><%= request.getAttribute("message") %></p>
<% } %>
<a href="/">Tra từ khác</a>
</body>
</html>
