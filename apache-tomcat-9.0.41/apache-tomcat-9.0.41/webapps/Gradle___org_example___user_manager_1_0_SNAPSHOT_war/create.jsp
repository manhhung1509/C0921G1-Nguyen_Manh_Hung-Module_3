<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h2>Create User</h2>--%>
<%--<form action="/CreateServlet" method="post">--%>
<%--    <div>--%>
<%--        Name--%>
<%--        <input type="text" name="userName">--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        Email:--%>
<%--        <input type="text" name="email">--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        Country:--%>
<%--        <input type="text" name="country">--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type="submit" value="create">--%>
<%--    </div>--%>
<%--</form>--%>
<%--<h3>--%>
<%--    <c:out value="${message}"/>--%>
<%--</h3>--%>
<form action="/userControllerServlet" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td>
                <input type="text" name="id">
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
                <input type="submit" value="Create">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
