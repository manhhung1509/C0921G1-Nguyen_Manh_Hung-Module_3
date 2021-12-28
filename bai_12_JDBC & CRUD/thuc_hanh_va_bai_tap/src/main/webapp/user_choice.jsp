<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>User Choice</h2>
<form action="/UserControllerServlet" method="post">
        <span>
            <input type="submit" name="choice" value="create">
        </span>
    <span>
            <input type="submit" name="choice" value="edit">
        </span>
    <span>
            <input type="submit" name="choice" value="delete">
        </span>
    <span>
            <input type="submit" name="choice" value="display">
        </span>
    </span>
    <span>
            <input type="submit" name="choice" value="find by country">
        </span>
    </span>
    <span>
            <input type="submit" name="choice" value="sort by name">
        </span>
</form>
</body>
</html>
