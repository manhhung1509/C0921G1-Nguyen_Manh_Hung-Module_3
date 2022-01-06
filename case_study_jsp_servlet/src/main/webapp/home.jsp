<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Home</title>
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
<nav class="navbar navbar-expand-lg navbar-light row d-flex" style=" height: 85px;background: #e1dedc">
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

<section class="py-5" style="background: #f0e9e4;">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" style="background: #f0e9e4;">
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Sale 10%</div>
                    <img class="card-img-top" src="photo/foru1.png" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">Twin Room</h5>
                            $40.00 - $80.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Sale 25%</div>
                    <img class="card-img-top" src="photo/four-points-sheraton-danang-chinh-thuc-mo-cua-danang-fantasticity-com-02.jpg" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">King room</h5>
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            <span class="text-muted text-decoration-line-through">$20.00-</span>
                            $18.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Big Sale 60%</div>
                    <img class="card-img-top" src="photo/Four-Points-by-Sheraton-Da-Nang-ivivu-3.jpg" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">suite Room</h5>
                            <span class="text-muted text-decoration-line-through">$50.00-</span>
                            $25.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Sale 5%</div>
                    <img class="card-img-top" src="photo/khach-san-four-points-by-sheraton-da-nang-15-800x450.png" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder" style="margin-bottom: 0">Normal Room</h5>
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            $40.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Sale 35%</div>
                    <img class="card-img-top" src="photo/novo1.jpg" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">Deluxe Room</h5>
                            <span class="text-muted text-decoration-line-through">$50.00-</span>
                            $25.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Sale 10%</div>
                    <img style="height: 203px" class="card-img-top" src="photo/novo2.jpg" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">Superior Room</h5>
                            $120.00 - $280.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem;background: #e52304 ;right: 0.5rem">Sale 50%</div>
                    <img style="height: 203px" class="card-img-top" src="photo/363-khach-san-novotel-da-nang.jpg" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">Base Room</h5>
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            <span class="text-muted text-decoration-line-through">$20.00-</span>
                            $18.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <div class="badge text-white position-absolute" style="top: 0.5rem; background: #e52304 ;right: 0.5rem">Sale 10%</div>
                    <img class="card-img-top" src="photo/novo5.jpg" alt="..." />
                    <div class="card-body p-4">
                        <div class="text-center">
                            <h5 class="fw-bolder">Single Bed Room</h5>
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            $40.00
                        </div>
                    </div>
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div style="margin-right:0;margin-left: 0;padding-right: 0;height: 400px; background: #f0e9e4;" class="row container-fluid" >
    <div class="col-lg-12" style="padding-right: 0">
        <div class="row">
            <div class="col-lg-4">
                <h2 style="margin-left: 35px; margin-top: 42px; font-size: 30px;color: #cbbe73;line-height: 36px;text-align: left;font-family:Playfair Display;
                font-weight:700;font-style:normal" class="vc_custom_heading">
                    KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.
                </h2>
            </div>
            <div class="col-lg-4" style="padding-top: 39px; padding-left: 0; padding-right: 0">
                <img style="height: 329px" width="1000" height="754" src="photo/four-points-da-nang-5-sao.jpg"
                     class="img-fluid" alt="" srcset="photo/four-points-da-nang-5-sao.jpg" sizes="(max-width: 1000px) 100vw, 1000px">
            </div>
            <div class="col-lg-4">
                <p style="text-align: justify">
                    <p style="font-size: 17px; padding-top: 17px">
                    Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến
                    với 3 di sản văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng.
                    196 phòng hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng
                    đều được trang trí trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến
                    trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá nhất tại Việt Nam –
                    vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện
                    ảnh và các nhà lãnh đạo kinh doanh quốc tế.
                    </p>
                </p>
            </div>
        </div>
        <div class="row"></div>
    </div>
</div>
<div class="row container-fluid" style="margin-left: 0; margin-right: 0;height: 200px;background: #f0e9e4;">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <div>
            <h2 style="font-size: 24px;color: #cbbe73;line-height: 36px;text-align: center;font-family:Playfair Display;font-weight:700;font-style:normal" class="vc_custom_heading">CÁC LOẠI PHÒNG</h2>
        </div>
        <div>
            <p style="text-align: center;">
                Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với phong cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi biển.
            </p>
        </div>
    </div>
    <div class="col-lg-3"></div>
</div>

<footer class="new_footer_area bg_color">
    <div class="new_footer_top">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="f_widget company_widget wow fadeInLeft" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
                        <h3 class="f-title f_600 t_color f_size_18">Furama</h3>
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

</body>
</html>