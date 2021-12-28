<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<form action="/FindByCountryServlet" method="post">
    <div>
        country of user wanna search:
        <input type="text" name="country">
    </div>
    <div>
        <input type="submit" value="search">
    </div>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">email</th>
        <th scope="col">County</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
        </tr>
    </c:forEach>>
    </tbody>
</table>
<h3>
    <c:out value="${message}"/>
</h3>
</body>
</html>
