<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bai_tap/css/bootstrap.min.css">

</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Tên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
    <tr>
        <th scope="row">1</th>
        <td>${customer.name}</td>
        <td>${customer.birthday}</td>
        <td>${customer.address}</td>
        <td><img src="${customer.photo}"  width="50px" height="50px"/></td>
    </tr>
    </c:forEach>>
    </tbody>
</table>
</body>
</html>
