<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%--<table class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">ID</th>--%>
<%--        <th scope="col">Name</th>--%>
<%--        <th scope="col">email</th>--%>
<%--        <th scope="col">County</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="user" items="${listUser}">--%>
<%--        <tr>--%>
<%--            <td>${user.id}</td>--%>
<%--            <td>${user.name}</td>--%>
<%--            <td>${user.email}</td>--%>
<%--            <td>${user.country}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>>--%>
<%--    </tbody>--%>
<%--</table>--%>

<table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>EMail</th>
            <th>Country</th>
            <th>Choice</th>
        </tr>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>
                <a href="userControllerServlet?userID=${user.id}">Edit</a>
                <a href="#" onclick="showMessage(${user.id})">Delete</a>
            </td>
        </tr>
    </c:forEach>>
</table>
<a href="create.jsp">Create User</a>
</body>
<script>
    function showMessage(id){
        let  option = confirm("Are you sure to delete");
        if (option === true){
            window.location.href = "userControllerServlet?userID="+id;
        }
    }
</script>
</html>
