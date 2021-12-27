<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create product</h2>
<form action="/controller.CreateServlet" method="post">
    <div>
        Name:
        <input type="text" name="productName">
    </div>
    <div>
        address
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
        <input type="submit" value="create">
    </div>
</form>
<h3>
    <c:out value="${message}"/>
</h3>
</body>
</html>