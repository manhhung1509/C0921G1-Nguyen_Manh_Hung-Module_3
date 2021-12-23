<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span><h4>Description: <%= request.getAttribute("description") %></h4></span>
<span><h4>Discount Amount: <%= request.getAttribute("Discount Amount") %></h4></span>
<span><h4>Discount Price: <%= request.getAttribute("Discount Price") %></h4></span>
</body>
</html>
