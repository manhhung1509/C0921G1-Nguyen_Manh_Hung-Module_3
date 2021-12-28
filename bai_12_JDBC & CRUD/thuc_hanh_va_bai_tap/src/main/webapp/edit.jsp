<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit User</h2>
<form action="/EditServlet" method="post">
    <div>
        Id of User wanna edit:
        <input type="text" name="idToEdit">
    </div>
    <div>
        Name:
        <input type="text" name="userName">
    </div>
    <div>
        Email:
        <input type="text" name="email">
    </div>
    <div>
        Country:
        <input type="text" name="country">
    </div>
    <div>
        <input type="submit" value="edit">
    </div>
</form>
<h3>
    <c:out value="${message}"/>
</h3>
</body>
</html>
