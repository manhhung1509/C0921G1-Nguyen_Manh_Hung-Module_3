<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/DiscountServlet" method="post">
    <input type="text" name="description" placeholder="Description of product: "/>
    <input type="text" name="price" placeholder="List Price: "/>
    <input type="text" name="discount" placeholder="Discount Percent: "/>
    <input type = "submit" id = "submit" value = "calculate"/>
</form>
</body>
</html>
