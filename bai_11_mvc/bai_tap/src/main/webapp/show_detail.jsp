<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Show detail product</h2>
<form action="/ShowDetailProductServlet" method="post">
    <div>
        Enter id you wanna show detail :
        <input type="text" name="id">
    </div>
    <div>
        <input type="submit" value="show">
    </div>
</form>

<table>
    <c:forEach var="product" items="${productList}">
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
