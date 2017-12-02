<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <base href="${pageContext.servletContext.contextPath}/">
        <link rel="icon" href="files/home/minilogo.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:choose>
        	<c:when test="${title == null}">
        		<title>Cẩm nang du lịch</title>
        	</c:when>
        	<c:otherwise>
        		<title>${title}</title>
        	</c:otherwise>
        </c:choose>
        <link rel="icon" type="image/png" href="img/av2.png">
		<!--Sweetalert.min-->
		<script src="js/sweetalert.min.js" type="text/javascript"></script>
		<!--Sweetalert css-->
		<link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <!-- Validation -->
        <script src="lib/jquery.js"></script>
        <script src="lib/jquery.mockjax.js"></script>
		<script src="lib/jquery.form.js"></script>
		<script src="dist/jquery.validate.js"></script>
		<!-- Validation custom -->
		<script src="js/validate_check.js"></script>
		<script src="js/validate_check-huy.js"></script>
    </head>
    <body class="fixed-nav sticky-footer bg-dark" id="page-top" onload="alert_admin_check('${message}')">
    
    
    
    <c:choose>
    
    	<c:when test="${loguser.quyen.idquyen == 1}">
    		<!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	            <a class="navbar-brand" href="admin/dieu-khien.html"><img src="files/home/logo.png" style="position: absolute; top: 10px; left: 20px; width: 130px;"></a>
	            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" 
	                    data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarResponsive">
	                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/index.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Điều khiển</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltaikhoan" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user"></i>
	                            <span class="nav-link-text">Quản lý tài khoản</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltaikhoan">
	                            <li>
	                                <a href="admin/dstaikhoan.html"><i class="fa fa-fw fa-list"></i> Danh sách tài khoản</a>
	                            </li>
	                            <li>
	                                <a href="admin/ttaikhoan.html"><i class="fa fa-fw fa-plus"></i> Thêm tài khoản mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlquyen" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user-circle"></i>
	                            <span class="nav-link-text">Quản lý quyền</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlquyen">
	                            <li>
	                                <a href="admin/dsquyen.html"><i class="fa fa-fw fa-list"></i> Danh sách quyền</a>
	                            </li>
	                            <li>
	                                <a href="admin/tquyen.html"><i class="fa fa-fw fa-plus"></i> Thêm quyền mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlbaiviet" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-newspaper-o"></i>
	                            <span class="nav-link-text">Quản lý bài viết</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlbaiviet">
	                            <li>
	                                <a href="admin/dsbaiviet.html"><i class="fa fa-fw fa-list"></i> Danh sách bài viết</a>
	                            </li>
	                            <li>
	                                <a href="admin/tbaiviet.html"><i class="fa fa-fw fa-plus"></i> Thêm bài viết mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qllbaiviet" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-file-text-o"></i>
	                            <span class="nav-link-text">Quản lý loại bài viết</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qllbaiviet">
	                            <li>
	                                <a href="admin/dsloaibv.html"><i class="fa fa-fw fa-list"></i> Danh sách loại bài viết</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm loại bài viết mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlkhachsan" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-building"></i>
	                            <span class="nav-link-text">Quản lý khách sạn</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlkhachsan">
	                            <li>
	                                <a href="admin/dskhachsan.html"><i class="fa fa-fw fa-list"></i> Danh sách khách sạn</a>
	                            </li>
	                            <li>
	                                <a href="admin/tkhachsan.html"><i class="fa fa-fw fa-plus"></i> Thêm khách sạn mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qllphong" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-building-o"></i>
	                            <span class="nav-link-text">Quản lý loại phòng</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qllphong">
	                            <li>
	                                <a href="admin/dsloaiphong.html"><i class="fa fa-fw fa-list"></i> Danh sách loại phòng</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm loại phòng mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltinhthanh" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-map-marker"></i>
	                            <span class="nav-link-text">Quản lý tỉnh thành</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltinhthanh">
	                            <li>
	                                <a href="admin/dstinhthanh.html"><i class="fa fa-fw fa-list"></i> Danh sách tỉnh thành</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm tỉnh thành mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlcongty" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-contao"></i>
	                            <span class="nav-link-text">Quản lý công ty</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlcongty">
	                            <li>
	                                <a href="admin/dscongty.html"><i class="fa fa-fw fa-list"></i> Danh sách công ty</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm công ty mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltour" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-leaf"></i>
	                            <span class="nav-link-text">Quản lý tour du lịch</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltour">
	                            <li>
	                                <a href="admin/dstour.html"><i class="fa fa-fw fa-list"></i> Danh sách tour du lịch</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm tour du lịch mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qldichvu" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user-md"></i>
	                            <span class="nav-link-text">Quản lý dịch vụ</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qldichvu">
	                            <li>
	                                <a href="admin/dsdichvu.html"><i class="fa fa-fw fa-list"></i> Danh sách dịch vụ</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm dịch vụ mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="#">
	                            <i class="fa fa-fw fa-file-text"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt phòng</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="#">
	                            <i class="fa fa-fw fa-file"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt tour</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/slugtool.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Slug tool</span>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav sidenav-toggler">
	                    <li class="nav-item">
	                        <a class="nav-link text-center" id="sidenavToggler">
	                            <i class="fa fa-fw fa-angle-left"></i>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            <i class="fa fa-fw fa-bell"></i>
	                            <span class="indicator text-warning d-none d-lg-block">
	                                <i class="fa fa-fw fa-circle"></i>
	                            </span>
	                        </a>
	                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
	                            <h6 class="dropdown-header">Thông báo:</h6>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-danger">
	                                    <strong><i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span><br>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item small" href="#">View all alerts</a>
	                        </div>
	                    </li>
	                    <li class="nav-item">
	                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
	                            <div class="input-group">
	                                <input class="form-control" type="text" placeholder="Tìm kiếm...">
	                                <span class="input-group-btn">
	                                    <button class="btn btn-primary" type="button">
	                                        <i class="fa fa-search"></i>
	                                    </button>
	                                </span>
	                            </div>
	                        </form>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
	                            <i class="fa fa-fw fa-sign-out"></i>Đăng xuất</a>
	                    </li>
	                </ul>
	            </div>
	        </nav>
    	</c:when>
    	
    	<c:when test="${loguser.quyen.idquyen == 2}">
	    	<!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	            <a class="navbar-brand" href="admin/index.html">CamNangDuLich</a>
	            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" 
	                    data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarResponsive">
	                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/index.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Điều khiển</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltaikhoan" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user"></i>
	                            <span class="nav-link-text">Quản lý tài khoản</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltaikhoan">
	                            <li>
	                                <a href="admin/dstaikhoan.html"><i class="fa fa-fw fa-list"></i> Danh sách tài khoản</a>
	                            </li>
	                            <li>
	                                <a href="admin/ttaikhoan.html"><i class="fa fa-fw fa-plus"></i> Thêm tài khoản mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlquyen" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user-circle"></i>
	                            <span class="nav-link-text">Quản lý quyền</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlquyen">
	                            <li>
	                                <a href="admin/dsquyen.html"><i class="fa fa-fw fa-list"></i> Danh sách quyền</a>
	                            </li>
	                            <li>
	                                <a href="admin/tquyen.html"><i class="fa fa-fw fa-plus"></i> Thêm quyền mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlbaiviet" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-newspaper-o"></i>
	                            <span class="nav-link-text">Quản lý bài viết</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlbaiviet">
	                            <li>
	                                <a href="admin/dsbaiviet.html"><i class="fa fa-fw fa-list"></i> Danh sách bài viết</a>
	                            </li>
	                            <li>
	                                <a href="admin/tbaiviet.html"><i class="fa fa-fw fa-plus"></i> Thêm bài viết mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qllbaiviet" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-file-text-o"></i>
	                            <span class="nav-link-text">Quản lý loại bài viết</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qllbaiviet">
	                            <li>
	                                <a href="admin/dsloaibv.html"><i class="fa fa-fw fa-list"></i> Danh sách loại bài viết</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm loại bài viết mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlkhachsan" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-building"></i>
	                            <span class="nav-link-text">Quản lý khách sạn</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlkhachsan">
	                            <li>
	                                <a href="admin/dskhachsan.html"><i class="fa fa-fw fa-list"></i> Danh sách khách sạn</a>
	                            </li>
	                            <li>
	                                <a href="admin/tkhachsan.html"><i class="fa fa-fw fa-plus"></i> Thêm khách sạn mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qllphong" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-building-o"></i>
	                            <span class="nav-link-text">Quản lý loại phòng</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qllphong">
	                            <li>
	                                <a href="admin/dsloaiphong.html"><i class="fa fa-fw fa-list"></i> Danh sách loại phòng</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm loại phòng mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltinhthanh" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-map-marker"></i>
	                            <span class="nav-link-text">Quản lý tỉnh thành</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltinhthanh">
	                            <li>
	                                <a href="admin/dstinhthanh.html"><i class="fa fa-fw fa-list"></i> Danh sách tỉnh thành</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm tỉnh thành mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlcongty" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-contao"></i>
	                            <span class="nav-link-text">Quản lý công ty</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlcongty">
	                            <li>
	                                <a href="admin/dscongty.html"><i class="fa fa-fw fa-list"></i> Danh sách công ty</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm công ty mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltour" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-leaf"></i>
	                            <span class="nav-link-text">Quản lý tour du lịch</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltour">
	                            <li>
	                                <a href="admin/dstour.html"><i class="fa fa-fw fa-list"></i> Danh sách tour du lịch</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm tour du lịch mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qldichvu" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user-md"></i>
	                            <span class="nav-link-text">Quản lý dịch vụ</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qldichvu">
	                            <li>
	                                <a href="admin/dsdichvu.html"><i class="fa fa-fw fa-list"></i> Danh sách dịch vụ</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm dịch vụ mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="#">
	                            <i class="fa fa-fw fa-file-text"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt phòng</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="#">
	                            <i class="fa fa-fw fa-file"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt tour</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/slugtool.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Slug tool</span>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav sidenav-toggler">
	                    <li class="nav-item">
	                        <a class="nav-link text-center" id="sidenavToggler">
	                            <i class="fa fa-fw fa-angle-left"></i>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            <i class="fa fa-fw fa-bell"></i>
	                            <span class="indicator text-warning d-none d-lg-block">
	                                <i class="fa fa-fw fa-circle"></i>
	                            </span>
	                        </a>
	                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
	                            <h6 class="dropdown-header">Thông báo:</h6>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-danger">
	                                    <strong><i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span><br>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item small" href="#">View all alerts</a>
	                        </div>
	                    </li>
	                    <li class="nav-item">
	                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
	                            <div class="input-group">
	                                <input class="form-control" type="text" placeholder="Tìm kiếm...">
	                                <span class="input-group-btn">
	                                    <button class="btn btn-primary" type="button">
	                                        <i class="fa fa-search"></i>
	                                    </button>
	                                </span>
	                            </div>
	                        </form>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
	                            <i class="fa fa-fw fa-sign-out"></i>Đăng xuất</a>
	                    </li>
	                </ul>
	            </div>
	        </nav>
    	</c:when>
    	
    	<c:when test="${loguser.quyen.idquyen == 3}">
    		<!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	            <a class="navbar-brand" href="admin/index.html">CamNangDuLich</a>
	            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" 
	                    data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarResponsive">
	                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/index.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Điều khiển</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltaikhoan" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user"></i>
	                            <span class="nav-link-text">Quản lý tài khoản</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltaikhoan">
	                            <li>
	                                <a href="admin/dstaikhoan.html"><i class="fa fa-fw fa-list"></i> Danh sách tài khoản</a>
	                            </li>
	                            <li>
	                                <a href="admin/ttaikhoan.html"><i class="fa fa-fw fa-plus"></i> Thêm tài khoản mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlquyen" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user-circle"></i>
	                            <span class="nav-link-text">Quản lý quyền</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlquyen">
	                            <li>
	                                <a href="admin/dsquyen.html"><i class="fa fa-fw fa-list"></i> Danh sách quyền</a>
	                            </li>
	                            <li>
	                                <a href="admin/tquyen.html"><i class="fa fa-fw fa-plus"></i> Thêm quyền mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlbaiviet" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-newspaper-o"></i>
	                            <span class="nav-link-text">Quản lý bài viết</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlbaiviet">
	                            <li>
	                                <a href="admin/dsbaiviet.html"><i class="fa fa-fw fa-list"></i> Danh sách bài viết</a>
	                            </li>
	                            <li>
	                                <a href="admin/tbaiviet.html"><i class="fa fa-fw fa-plus"></i> Thêm bài viết mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qllbaiviet" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-file-text-o"></i>
	                            <span class="nav-link-text">Quản lý loại bài viết</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qllbaiviet">
	                            <li>
	                                <a href="admin/dsloaibv.html"><i class="fa fa-fw fa-list"></i> Danh sách loại bài viết</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm loại bài viết mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlkhachsan" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-building"></i>
	                            <span class="nav-link-text">Quản lý khách sạn</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlkhachsan">
	                            <li>
	                                <a href="admin/dskhachsan.html"><i class="fa fa-fw fa-list"></i> Danh sách khách sạn</a>
	                            </li>
	                            <li>
	                                <a href="admin/tkhachsan.html"><i class="fa fa-fw fa-plus"></i> Thêm khách sạn mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qllphong" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-building-o"></i>
	                            <span class="nav-link-text">Quản lý loại phòng</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qllphong">
	                            <li>
	                                <a href="admin/dsloaiphong.html"><i class="fa fa-fw fa-list"></i> Danh sách loại phòng</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm loại phòng mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltinhthanh" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-map-marker"></i>
	                            <span class="nav-link-text">Quản lý tỉnh thành</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltinhthanh">
	                            <li>
	                                <a href="admin/dstinhthanh.html"><i class="fa fa-fw fa-list"></i> Danh sách tỉnh thành</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm tỉnh thành mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qlcongty" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-contao"></i>
	                            <span class="nav-link-text">Quản lý công ty</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qlcongty">
	                            <li>
	                                <a href="admin/dscongty.html"><i class="fa fa-fw fa-list"></i> Danh sách công ty</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm công ty mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qltour" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-leaf"></i>
	                            <span class="nav-link-text">Quản lý tour du lịch</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qltour">
	                            <li>
	                                <a href="admin/dstour.html"><i class="fa fa-fw fa-list"></i> Danh sách tour du lịch</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm tour du lịch mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#qldichvu" data-parent="#exampleAccordion">
	                            <i class="fa fa-fw fa-user-md"></i>
	                            <span class="nav-link-text">Quản lý dịch vụ</span>
	                        </a>
	                        <ul class="sidenav-second-level collapse" id="qldichvu">
	                            <li>
	                                <a href="admin/dsdichvu.html"><i class="fa fa-fw fa-list"></i> Danh sách dịch vụ</a>
	                            </li>
	                            <li>
	                                <a href="#"><i class="fa fa-fw fa-plus"></i> Thêm dịch vụ mới</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="#">
	                            <i class="fa fa-fw fa-file-text"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt phòng</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="#">
	                            <i class="fa fa-fw fa-file"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt tour</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/slugtool.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Slug tool</span>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav sidenav-toggler">
	                    <li class="nav-item">
	                        <a class="nav-link text-center" id="sidenavToggler">
	                            <i class="fa fa-fw fa-angle-left"></i>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            <i class="fa fa-fw fa-bell"></i>
	                            <span class="indicator text-warning d-none d-lg-block">
	                                <i class="fa fa-fw fa-circle"></i>
	                            </span>
	                        </a>
	                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
	                            <h6 class="dropdown-header">Thông báo:</h6>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-danger">
	                                    <strong><i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span><br>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item small" href="#">View all alerts</a>
	                        </div>
	                    </li>
	                    <li class="nav-item">
	                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
	                            <div class="input-group">
	                                <input class="form-control" type="text" placeholder="Tìm kiếm...">
	                                <span class="input-group-btn">
	                                    <button class="btn btn-primary" type="button">
	                                        <i class="fa fa-search"></i>
	                                    </button>
	                                </span>
	                            </div>
	                        </form>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
	                            <i class="fa fa-fw fa-sign-out"></i>Đăng xuất</a>
	                    </li>
	                </ul>
	            </div>
	        </nav>
    	</c:when>
    	
    	<c:when test="${loguser.quyen.idquyen == 4}">
	    	<!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	            <a class="navbar-brand" href="admin/dieu-khien.html"><img src="files/home/logo.png" style="position: absolute; top: 10px; left: 20px; width: 130px;"></a>
	            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" 
	                    data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarResponsive">
	                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/dieu-khien.html">
	                            <i class="fa fa-fw fa-dashboard"></i>
	                            <span class="nav-link-text">Điều khiển</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/thong-tin-khach-san.html">
	                            <i class="fa fa-fw fa-building"></i>
	                            <span class="nav-link-text">Thông tin khách sạn</span>
	                        </a>
	                    </li>
	                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
	                        <a class="nav-link" href="admin/danh-sach-don-dat-phong.html">
	                            <i class="fa fa-fw fa-file-text"></i>
	                            <span class="nav-link-text">Danh sách đơn đặt phòng</span>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav sidenav-toggler">
	                    <li class="nav-item">
	                        <a class="nav-link text-center" id="sidenavToggler">
	                            <i class="fa fa-fw fa-angle-left"></i>
	                        </a>
	                    </li>
	                </ul>
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item dropdown">
	                        <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            <i class="fa fa-fw fa-bell"></i>
	                            <span class="indicator text-warning d-none d-lg-block">
	                                <i class="fa fa-fw fa-circle"></i>
	                            </span>
	                        </a>
	                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
	                            <h6 class="dropdown-header">Thông báo:</h6>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-danger">
	                                    <strong><i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="#">
	                                <span class="text-success">
	                                    <strong><i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
	                                </span>
	                                <span class="small float-right text-muted">11:21 AM</span><br>
	                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
	                            </a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item small" href="#">View all alerts</a>
	                        </div>
	                    </li>
	                    <li class="nav-item">
	                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
	                            <div class="input-group">
	                                <input class="form-control" type="text" placeholder="Tìm kiếm...">
	                                <span class="input-group-btn">
	                                    <button class="btn btn-primary" type="button">
	                                        <i class="fa fa-search"></i>
	                                    </button>
	                                </span>
	                            </div>
	                        </form>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
	                            <i class="fa fa-fw fa-sign-out"></i>Đăng xuất</a>
	                    </li>
	                </ul>
	            </div>
	        </nav>
    	</c:when>
    	
    	<c:otherwise>
    		<%
				response.sendRedirect(request.getContextPath()+"/error/stop.html");
			%>
    	</c:otherwise>
    	
    </c:choose>
    
        <div class="content-wrapper">

            <jsp:include page="${param.view}" />
            
            <!-- /.content-wrapper-->
            <footer class="sticky-footer">
                <div class="container">
                    <div class="text-center">
                        <small>Copyright © Your Website 2017</small>
                    </div>
                </div>
            </footer>
            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fa fa-angle-up"></i>
            </a>
            <!-- Logout Modal-->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Đăng xuất?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Bạn chắc chắn muốn thực hiện đăng xuất? 
                            Chọn "Đăng xuất" để thoát khỏi hệ thống
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Hủy</button>
                            <a class="btn btn-primary" href="login.html">Đăng xuất</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Bootstrap core JavaScript-->
            <script src="vendor/popper/popper.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
            <!-- Page level plugin JavaScript-->
            <!--<script src="vendor/chart.js/Chart.min.js"></script>-->
            <script src="vendor/datatables/jquery.dataTables.js"></script>
            <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin.min.js"></script>
            <!-- Custom scripts for this page-->
            <script src="js/sb-admin-datatables.min.js"></script>
            <!--<script src="js/sb-admin-charts.min.js"></script>-->
            <!-- Alert check js-->
	        <script src="js/alert-check.js" type="text/javascript"></script>
	        <script src="js/alert-check-huy.js" type="text/javascript"></script>
	        <!-- Image load js-->
	        <script src="js/img-load.js" type="text/javascript"></script>
        </div>
    </body>

</html>
