<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>
    Your Word: <c:out value ="${word}" />
</h4>
<h4>
    translate: <c:out value ="${Result}" />
</h4>
</body>
</html>
