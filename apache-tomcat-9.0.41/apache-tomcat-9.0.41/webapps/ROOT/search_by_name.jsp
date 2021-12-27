<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<h2>Search by name</h2>
<form action="/SearchByNameServlet" method="post">
    <div>
        Enter name you wanna show detail :
        <input type="text" name="name">
    </div>
    <div>
        <input type="submit" value="search">
    </div>
</form>
<table>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.email}</td>
            <td>${product.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
