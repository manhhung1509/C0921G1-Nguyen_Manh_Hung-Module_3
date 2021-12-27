<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Delete Customer</h2>
<form action="/DeleteServlet" method="post">
    <div>
        Id of customer wanna delete:
        <input type="text" name="idToDelete">
    </div>
    <div>
        <input type="submit" value="delete">
    </div>
</form>
<h3>
    <c:out value="${message}"/>
</h3>
</body>
</html>
