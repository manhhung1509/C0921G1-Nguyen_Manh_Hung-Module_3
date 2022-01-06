<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer</title>
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
                <h2>Update Customer</h2>
                <h4>Furama would love to hear from you !</h4>
            </div>
        </div>
        <div class="col-md-9" style="padding-top: 5px">
            <div style="padding-left: 12px; margin-bottom: 25px">
                <span><a style="font-size: 20px; color: red" href="/customerServlet?action=showList"><i class="fas fa-arrow-circle-left"></i></a></span>
                <span style="padding-left: 5px"><a style="font-size: 20px; color: red" href="/customerServlet?action=showList">Quay Lại</a></span>
            </div>
            <form action="/customerServlet" method="post">
                <div class="contact-form">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="cId">Customer Id:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cId" name="cId" value="${customer.getCustomerId()}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="name">Customer Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" value="${customer.getCustomerName()}">
                        </div>
                        <p style="color: red">${msgName}</p>
                    </div>
                    <div class="form-group">
                        <label class="col-12 float-left mt-1" for="exampleInputPosition">Customer type:</label>
                        <select name="id_customer_type" id="exampleInputPosition" class="form-control float-left" style="margin-left: 14px; width: 586px">
                            <option>Chose option ...</option>
                            <c:forEach var="type" items="${customerType}">
                                <c:choose>
                                    <c:when test="${type.getCustomerTypeId() == customer.getCustomerType().getCustomerTypeId()}">
                                        <option value="${type.getCustomerTypeId()}" selected> ${type.getCustomerTypeName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${type.getCustomerTypeId()}">${type.getCustomerTypeName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="birthday">Birthday:</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="birthday" name="birthday" value="${customer.getCustomerBirthday()}">
                        </div>
                        <p style="color: red">${msgDayOfBirth}</p>
                    </div>
                    <div class="form-group">
                        <span style="margin-left: 13px">Customer gender:</span>
                        <span style="margin-left: 12px"><label class="control-label" ><input id="gender1" name="gender" type="radio" value="1" />Male </label></span>
                        <span style="margin-left: 7px"><label class="control-label" ><input id="gender2" name="gender" type="radio" value="0" />Female</label></span>
                        <p style="color: red">${msgGender}</p>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="idCard">Customer id card:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="idCard"  name="idCard" value="${customer.getCustomerIdCard()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="phone">Customer phone:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone" name="phone" value="${customer.getCustomerPhone()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Customer email:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" name="email" value="${customer.getCustomerEmail()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="address">Customer address:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" name="address" value="${customer.getCustomerAddress()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <span><input type="submit" name="action" value="update" class="btn btn-default"></span>
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