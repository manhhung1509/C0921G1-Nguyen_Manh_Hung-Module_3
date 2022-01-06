<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/form_insert.css">
    <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css">
</head>
<body>
<div class="container contact">
    <div class="row">
        <div class="col-md-3">
            <div class="contact-info">
                <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                <h2>Create Employee</h2>
                <h4>Furama would love to hear from you !</h4>
            </div>
        </div>
        <div class="col-md-9" style="padding-top: 5px">
            <div style="padding-left: 12px; margin-bottom: 25px">
                <span><a style="font-size: 20px; color: red" href="/employeeServlet?action=showList"><i class="fas fa-arrow-circle-left"></i></a></span>
                <span style="padding-left: 5px"><a style="font-size: 20px; color: red" href="/employeeServlet?action=showList">Quay Lại</a></span>
            </div>
            <form action="/employeeServlet" method="post">
                <div class="contact-form">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="name">Employee Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" placeholder="Enter Customer Name" name="name" value="${customer.getEmployeeName()}">
                        </div>
                        <p style="color: red">${msgName}</p>
                    </div>
                    <div class="form-group">
                        <label class="col-12 float-left mt-1" for="exampleInputPosition">Position:</label>
                        <select name="idPosition" id="exampleInputPosition" class="form-control float-left" style="margin-left: 14px; width: 586px">
                            <option>Chose option ... </option>
                            <c:forEach var="position" items="${requestScope['positionList']}">
                                <c:choose>
                                    <c:when test="${position.getPositionId() == employee.getPosition().getPositionId()}">
                                        <option value="${position.getPositionId()}" selected> ${position.getPositionId()} - ${position.getPositionName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${position.getPositionId()}"> ${position.getPositionId()} - ${position.getPositionName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="col-12 float-left mt-1" for="exampleInputPosition1">Education Degree:</label>
                        <select name="idEducation" id="exampleInputPosition1" class="form-control float-left" style="margin-left: 14px; width: 586px">
                            <option>Chose option ... </option>
                            <c:forEach var="education" items="${requestScope['educationDegreeList']}">
                                <c:choose>
                                    <c:when test="${education.getEducationDegreeId() == employee.getEducationDegree().getEducationDegreeId()}">
                                        <option value="${education.getEducationDegreeId()}" selected> ${education.getEducationDegreeId()} - ${education.getEducationDegreeName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${education.getEducationDegreeId()}"> ${education.getEducationDegreeId()} - ${education.getEducationDegreeName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="col-12 float-left mt-1" for="exampleInputPosition2">Devision:</label>
                        <select name="idDevision" id="exampleInputPosition2" class="form-control float-left" style="margin-left: 14px; width: 586px">
                            <option>Chose option ... </option>
                            <c:forEach var="devision" items="${requestScope['devisionList']}">
                                <c:choose>
                                    <c:when test="${devision.getDevisionId() == employee.getDevision().getDevisionId()}">
                                        <option value="${devision.getDevisionId()}" selected> ${devision.getDevisionId()} - ${devision.getDevisionName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${devision.getDevisionId()}"> ${devision.getDevisionId()} - ${devision.getDevisionName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="col-12 float-left mt-1" for="exampleInputPosition3">User:</label>
                        <select name="userName" id="exampleInputPosition3" class="form-control float-left" style="margin-left: 14px; width: 586px">
                            <option>Chose option ... </option>
                            <c:forEach var="user" items="${requestScope['userList']}">
                                <c:choose>
                                    <c:when test="${user.getUserName().equals(employee.getUser().getUserName())}">
                                        <option value="${user.getUserName()}" selected> ${user.getUserName()} - ${user.getPassword()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${user.getUserName()}"> ${user.getUserName()} - ${user.getPassword()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="birthday">Birthday:</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="birthday" placeholder="Birthday" name="birthday" value="${employee.getEmployeeBirthday()}">
                        </div>
                        <p style="color: red">${msgDayOfBirth}</p>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="idCard">Employee id card:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="idCard" placeholder="Enter Employee id card" name="idCard" value="${employee.getEmployeeIdCard()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="salary">Salary:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="salary" placeholder="Enter Employee id card" name="salary" value="${employee.getEmployeeSalary()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="phone">Employee phone:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone" placeholder="Enter Employee phone" name="phone" value="${employee.getEmployeePhone()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Employee email:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" placeholder="Enter Employee email" name="email" value="${employee.getEmployeeEmail()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="address">Employee address:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" value="${employee.getEmployeeAddress()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <span><input type="submit" name="action" value="create" class="btn btn-default"></span>
                            <span style="padding-left: 50px">
                                <p style="color: blue">${msgSuccess}</p>
                            </span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

