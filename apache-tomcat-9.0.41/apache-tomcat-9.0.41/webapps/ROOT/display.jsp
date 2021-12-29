<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<form action="UserControllerServlet" method="post">
    <div>
        Enter name of country you wanna search:
        <input type="text" name="country">
    </div>
    <div>
        <input type="submit" name="userChoice" value="search">
    </div>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">email</th>
        <th scope="col">County</th>
        <th scope="col">Choice</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>
                <a href="UserControllerServlet?userId=${user.id}">Edit</a>
                <a href="#" onclick="showMessage(${user.id})">Delete</a>
            </td>
        </tr>
    </c:forEach>>
    </tbody>
</table>
<a href="create.jsp">Create User</a>
<%--<a href="search_by_country.jsp">Search by name</a>--%>
<form action="UserControllerServlet" method="post">
    <input type="submit" name="userChoice" value="sort">
</form>
</body>
<script>
    function showMessage(id) {
        let option = confirm("Are you sure to delete");
        if (option === true) {
            window.location.href = "UserControllerServlet?userDeleteId=" + id;
        }
    }
</script>
</html>
