<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="UserControllerServlet">Quay lại trang danh sách User</a>
<form action="UserControllerServlet" method="post">
    <table>
        <tr>
            <td>
                <input type="hidden" name="id" value="${userID}">
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>Country</td>
            <td>
                <input type="text" name="country">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="userChoice" value="update">
            </td>
        </tr>
    </table>
</form>
<h2 style="color: green">
    <c:out value="${massage}"/>
</h2>
</body>
</html>
