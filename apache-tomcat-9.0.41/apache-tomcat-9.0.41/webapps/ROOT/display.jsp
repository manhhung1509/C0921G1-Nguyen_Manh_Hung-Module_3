<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${ListCustomer}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>>
    </tbody>
</table>
</body>
</html>
