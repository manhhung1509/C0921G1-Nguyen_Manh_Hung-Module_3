<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/main.css">
</head>

<body style="width: 100%; overflow-x: hidden;">

<nav class="navbar navbar-expand-lg navbar-light row d-flex" style="background-color: #272882;height: 120px">
    <div class="col-lg-3">
        <img src="https://codegym.vn/wp-content/uploads/2021/08/CodeGym-Logo.webp" width="290" height="50" alt="CodeGym" id="logo" data-height-percentage="70" data-actual-width="1263.33" data-actual-height="217.812">
    </div>
    <div class="col-lg-5"></div>
    <div class="col-lg-4 d-flex">
        <div style="margin-left: 45px; padding-right: 25px"><a href="#" style="color: white; font-size: 35px"><i class="fas fa-search"></i></a></div>
        <div><a href="#" style="color: white; font-size: 35px"><i class="fas fa-bell"></i></a></div>
        <div style="color: white; font-size: 20px; padding-left: 20px">Nguyễn Mạnh Hùng</div>
        <div class="avatar avatar-online current pl-3">
            <img src="photo/f2.png" alt="abc" style="width: 35px; height: 35px; border-radius: 20px; margin-bottom: 9px; margin-right: 3px">
        </div>
    </div>
</nav>
<nav class="navbar navbar-expand-lg navbar-light row d-flex" style=" height: 85px; background: #f3ced4">
    <div class="collapse navbar-collapse row" id="navbarSupportedContent">
        <div class="navbar-nav col-lg-9">
            <a style="font-size: 25px; padding-left: 39px" class="nav-item nav-link active" href="/servletHome">Home <span class="sr-only">(current)</span></a>
            <a style="font-size: 25px; padding-left: 39px" class="nav-item nav-link" href="/employeeServlet?action=showList">Employee</a>
            <a style="font-size: 25px; padding-left: 39px" class="nav-item nav-link" href="/customerServlet?action=showList">Customer</a>
            <a style="font-size: 25px; padding-left: 39px" class="nav-item nav-link " href="/serviceServlet?action=showList">Service</a>
            <a style="font-size: 25px; padding-left: 39px" class="nav-item nav-link " href="/contractServlet?action=showList">Contract</a>
            <a style="font-size: 25px; padding-left: 39px" class="nav-item nav-link " href="/customerUsingServlet?action=showList">Customer current</a>
        </div>
        <div class="navbar-nav col-lg-3">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="row container-fluid" style="padding-right: 0">
    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-9" style="padding-top: 26px; padding-left: 20%">
                <form method="get">
                    <input style="border-radius: 60px; border: solid 2px; color:#217ee9 ;text-align: center" type="text" name="findCustomerName" placeholder="Nhập tên customer">
                    <input style="border-radius: 60px; border: solid 2px; color:#217ee9 ;text-align: center" type="text" name="findCustomerId" placeholder="Nhập customer Id">
                    <input style="border-radius: 60px; border: solid 2px; color:#217ee9 ;text-align: center" type="text" name="findCustomerPhone" placeholder="Nhập phone">
                    <button style="border-radius: 60px; border: solid 2px; color:red;background: #f3d0d6 ;text-align: center" type="submit" name="action" value="findCustomer">TÌm kiếm</button>
                </form>
            </div>
            <div class="col-lg-3" style="padding-top: 26px">
                <div>
                    <span><a href="/customerServlet?action=create" style="font-size: 20px;color: #3f48eb; padding-left: 99px">Create Customer</a></span>
                    <span><a href="/customerServlet?action=create" style="font-size: 20px;color: red"><i class="fas fa-user-plus"></i></a></span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12" style="padding-left: 2%">
                <table id="tableStudent" class="table table-responsive table-striped table-bordered scrollit" style="width:100%; text-align: center; overflow-y:scroll">
                    <thead>
                    <tr style="height: 50px; background: #f7b6c1" class="text-center">
                        <th style="padding-right: 71px">Action</th>
                        <th>Customer Id</th>
                        <th>Customer Type Id</th>
                        <th>Customer Type Name</th>
                        <th>Customer Name</th>
                        <th>Customer BirthDay</th>
                        <th>Customer Gender</th>
                        <th>Customer Id Card</th>
                        <th>Customer Phone</th>
                        <th>Customer Email</th>
                        <th>Customer Adress</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${requestScope['customerList']}" varStatus="count">
                        <tr>
                            <td class="text-center">
                                <a style="background: #f3d0d6" href="/customerServlet?action=edit&id=${customer.getCustomerId()}"
                                   role="button" class="btn btn-large btn-warning">sửa</a>
                                <button style="background:#ea1313" type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#exampleModal-${customer.getCustomerId()}">
                                    Xóa
                                </button>
                            </td>
                            <td>${customer.getCustomerId()}</td>
                            <td>${customer.getCustomerType().getCustomerTypeId()}</td>
                            <td>${customer.getCustomerType().getCustomerTypeName()}</td>
                            <td>${customer.getCustomerName()}</td>
                            <td>${customer.getCustomerBirthday()}</td>
                            <td>${customer.getCustomerGender()}</td>
                            <td>${customer.getCustomerIdCard()}</td>
                            <td>${customer.getCustomerPhone()}</td>
                            <td>${customer.getCustomerEmail()}</td>
                            <td>${customer.getCustomerAddress()}</td>
                        </tr>
                        <div class="modal fade" id="exampleModal-${customer.getCustomerId()}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header" style="background: #eda3b0">
                                        <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body" style="background: #f3d0d6">
                                        Bạn có chắc muốn xóa customer: ${customer.getCustomerName()}, có Id = ${customer.getCustomerId()}
                                    </div>
                                    <div class="modal-footer" style="background: #f3d0d6">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <a style="width: 64px; height: 36px;border-radius: 7px;" href="/customerServlet?action=delete&id=${customer.getCustomerId()}" role="button" class="btn-danger">confirm</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>


<footer class="new_footer_area bg_color">
    <div class="new_footer_top">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="f_widget company_widget wow fadeInLeft" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
                        <h3 class="f-title f_600 t_color f_size_18">Get in Touch</h3>
                        <p>Don’t miss any updates of our new templates and extensions.!</p>
                        <form action="#" class="f_subscribe_two mailchimp" method="post" novalidate="true" _lpchecked="1">
                            <input type="text" name="EMAIL" class="form-control memail" placeholder="Email">
                            <button class="btn btn_get btn_get_two" type="submit">Subscribe</button>
                            <p class="mchimp-errmessage" style="display: none;"></p>
                            <p class="mchimp-sucmessage" style="display: none;"></p>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: fadeInLeft;">
                        <h3 class="f-title f_600 t_color f_size_18">Download</h3>
                        <ul class="list-unstyled f_list">
                            <li><a href="#">Company</a></li>
                            <li><a href="#">Android App</a></li>
                            <li><a href="#">ios App</a></li>
                            <li><a href="#">Desktop</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">My tasks</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.6s" style="visibility: visible; animation-delay: 0.6s; animation-name: fadeInLeft;">
                        <h3 class="f-title f_600 t_color f_size_18">Help</h3>
                        <ul class="list-unstyled f_list">
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">Term &amp; conditions</a></li>
                            <li><a href="#">Reporting</a></li>
                            <li><a href="#">Documentation</a></li>
                            <li><a href="#">Support Policy</a></li>
                            <li><a href="#">Privacy</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="f_widget social-widget pl_70 wow fadeInLeft" data-wow-delay="0.8s" style="visibility: visible; animation-delay: 0.8s; animation-name: fadeInLeft;">
                        <h3 class="f-title f_600 t_color f_size_18">Team Solutions</h3>
                        <div class="f_social_icon">
                            <a href="#" class="fab fa-facebook"></a>
                            <a href="#" class="fab fa-twitter"></a>
                            <a href="#" class="fab fa-linkedin"></a>
                            <a href="#" class="fab fa-pinterest"></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer_bg">
            <div class="footer_bg_one"></div>
            <div class="footer_bg_two"></div>
        </div>
    </div>
    <div class="footer_bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-sm-7">
                    <p class="mb-0 f_400">© cakecounter Inc.. 2019 All rights reserved.</p>
                </div>
                <div class="col-lg-6 col-sm-5 text-right">
                    <p>Made with <i class="icon_heart"></i> in <a href="#">CakeCounter</a></p>
                </div>
            </div>
        </div>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
