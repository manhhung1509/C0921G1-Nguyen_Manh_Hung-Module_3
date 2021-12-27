<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit product</h2>
<form action="/controller.EditServlet" method="post">
    <div>
        Id of product wanna edit:
        <input type="text" name="idToEdit">
    </div>
    <div>
        Name:
        <input type="text" name="productName">
    </div>
    <div>
        Address:
        <input type="text" name="address">
    </div>
    <div>
        identify:
        <input type="text" name="id">
    </div>
    <div>
        email:
        <input type="text" name="email">
    </div>
    <div>
        <input type="submit" value="edit">
    </div>
</form>
<h3>
    <c:out value="${message}"/>
</h3>
</body>
</html>