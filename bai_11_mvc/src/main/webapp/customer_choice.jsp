<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Create student</h2>
    <form action="/CustomerServlet" method="post">
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
        <span>
            <input type="submit" name="choice" value="see">
        </span>
    </form>
</body>
</html>
