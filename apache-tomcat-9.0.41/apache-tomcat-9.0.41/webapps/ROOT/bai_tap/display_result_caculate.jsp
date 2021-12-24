<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>result:</h3>
    <c:choose>

        <c:when test="${result - 0 == result}">
            <c:out value ="${firstOperand}" /> <c:out value ="${operator}" /> <c:out value ="${secondOperand}" /> = <c:out value ="${result}" />
        </c:when>

        <c:otherwise>
            ${Error}
        </c:otherwise>

    </c:choose>
</body>
</html>
