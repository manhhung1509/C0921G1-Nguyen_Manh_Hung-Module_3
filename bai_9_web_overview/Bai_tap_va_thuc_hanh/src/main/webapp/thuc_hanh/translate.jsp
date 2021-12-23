
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span><h4>your word: <%= request.getAttribute("word") %></h4></span>
<span><h4>result: <%= request.getAttribute("Result") %></h4></span>
</body>
</html>
