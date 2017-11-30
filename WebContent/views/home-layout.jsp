<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
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
		<!--Sweetalert.min-->
		<script src="js/sweetalert.min.js" type="text/javascript"></script>
		<!--Sweetalert css-->
		<link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Images hover -->
        <link href="css/ihover.css" rel="stylesheet">
        <link href="css/ihover.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/modern-business.css" rel="stylesheet">
        <!-- Validation -->
        <script src="lib/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-latest.js"></script>
		<script type="text/javascript" src="js/jquery.shorten.1.0.js"></script>
        <script src="lib/jquery.mockjax.js"></script>
		<script src="lib/jquery.form.js"></script>
		<script src="dist/jquery.validate.js"></script>
		
		<!-- Validation custom -->
		<script src="js/validate_check.js"></script>
		<script src='https://www.google.com/recaptcha/api.js'></script>
		
		<!-- Google API Client -->
		<script src="https://apis.google.com/js/api:client.js"></script>
    </head>

    <body onload="alert_home_check('${message}')">
	<!-- Navigation -->
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="home/index.html"><img style="width: 130px;" src="files/home/logo.png"></a>
                <select class="sl_tinhthanh" onchange="location = this.value;">
                    <option value="" disabled selected hidden>Chọn tỉnh thành...</option>
                    <option value="home/tinhthanh.html">Hồ Chí Minh</option>
                    <option value="home/tinhthanh.html">Hà Nội</option>
                    <option value="home/tinhthanh.html">Buôn Mê Thuột</option>
                </select>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Tin tức
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                                <a class="dropdown-item" href="home/tintucds.html">Danh sách tin tức</a>
                                <a class="dropdown-item" href="home/tintucct.html">Chi tiết tin tức</a>
                                <a class="dropdown-item" href="home/khachsan.html">Chi tiết khách sạn</a>
                                <a class="dropdown-item" href="home/tour.html">Chi tiết tour</a>
                                <a class="dropdown-item" href="home/datphong.html">Đặt phòng khách sạn</a>
                                <a class="dropdown-item" href="home/tttaikhoan.html">Thông tin tài khoản</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="home/gioithieu.html">Giới thiệu</a>
                        </li>
                        <li class="nav-item" style="margin-right: 15px;">
                            <a class="nav-link" href="home/phanhoi.html">Phản hồi</a>
                        </li>
                        <li style="margin-right: 15px;">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Tìm kiếm...">
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="button">Tìm!</button>
                                </span>
                            </div>
                        </li>
                        
                        <c:choose>
                        	<c:when test="${loguser.quyen.idquyen == 5}">
                        		<li class="nav-item dropdown">
		                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                Xin chào: ${loguser.ten}
		                            </a>
		                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		                                <a onclick="taokhachsanpp()" class="dropdown-item" style="cursor: pointer;">Tạo khách sạn mới</a>
		                                <a class="dropdown-item" href="#">Thông tin tài khoản</a>
		                            </div>
		                            <li class="nav-item">
			                            <a onclick="dangxuat()" class="nav-link" style="cursor: pointer;">Đăng xuất</a>
			                        </li>
		                        </li>
                        	</c:when>
                        	<c:when test="${loguser.quyen.idquyen == 4}">
                        		<li class="nav-item dropdown">
		                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                Xin chào: ${loguser.ten}
		                            </a>
		                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		                                <a class="dropdown-item" href="#">Quản lý khách sạn</a>
		                                <a class="dropdown-item" href="#">Thông tin tài khoản</a>
		                            </div>
		                            <li class="nav-item">
			                            <a onclick="dangxuat()" class="nav-link" style="cursor: pointer;">Đăng xuất</a>
			                        </li>
		                        </li>
                        	</c:when>
                        	<c:when test="${loguser.quyen.idquyen == 3}">
                        		<li class="nav-item dropdown">
		                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                Xin chào: ${loguser.ten}
		                            </a>
		                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		                                <a class="dropdown-item" href="#">Quản lý tour du lịch</a>
		                                <a class="dropdown-item" href="#">Thông tin tài khoản</a>
		                            </div>
		                            <li class="nav-item">
			                            <a onclick="dangxuat()" class="nav-link" style="cursor: pointer;">Đăng xuất</a>
			                        </li>
		                        </li>
                        	</c:when>
                        	<c:when test="${loguser.quyen.idquyen == 2}">
                        		<li class="nav-item dropdown">
		                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                Xin chào: ${loguser.ten}
		                            </a>
		                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		                                <a class="dropdown-item" href="#">Quản lý bài viết</a>
		                                <a class="dropdown-item" href="#">Thông tin tài khoản</a>
		                            </div>
		                            <li class="nav-item">
			                            <a onclick="dangxuat()" class="nav-link" style="cursor: pointer;">Đăng xuất</a>
			                        </li>
		                        </li>
                        	</c:when>
                        	<c:when test="${loguser.quyen.idquyen == 1}">
                        		<li class="nav-item dropdown">
		                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                                Xin chào: ${loguser.ten}
		                            </a>
		                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
		                                <a class="dropdown-item" href="admin/index.html">Đến trang điều khiển</a>
		                                <a class="dropdown-item" href="#">Thông tin tài khoản</a>
		                            </div>
		                            <li class="nav-item">
			                            <a onclick="dangxuat()" class="nav-link" style="cursor: pointer;">Đăng xuất</a>
			                        </li>
		                        </li>
                        	</c:when>
                        	<c:otherwise>
                        		<li class="nav-item">
		                            <a onclick="loginpp()" class="nav-link" style="cursor: pointer;">Đăng nhập</a>
		                        </li>
		                        <li class="nav-item">
		                            <a onclick="registerpp()" class="nav-link" style="cursor: pointer;">Đăng ký</a>
		                        </li>
                        	</c:otherwise>
                        </c:choose>
                        
                    </ul>
                </div>
            </div>
        </nav>

        <jsp:include page="${param.view}" />

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <div class="row ft-fx">
                    <div class="col-md-3">
                        <h4>
                            <a class="ft-logo" href="index.html"><img src="files/home/logo.png"></a>
                        </h4>
                        <i class="fa fa-fw fa-phone text-white"></i><span class="text-white">Hotline:</span>
                        <span class="text-white" style="font-size: larger;">0123456789</span>
                        <p class="text-white" style="font-size: 15px; padding-top: 15px;">
                            CamNangDuLich luôn không ngừng đẩy mạnh hoạt động và phát triển, cả về sản phẩm,
                            dịch vụ và đội ngũ, nhằm đáp ứng rất tốt nhu cầu của khách hàng.</p>
                    </div>
                    <div class="col-md-2 ft-lk" style="padding-left: 35px;">
                        <h4>Liên kết</h4>
                        <a href="#">Trang chủ</a><br>
                        <a href="#">Địa điểm</a><br>
                        <a href="#">Khách sạn</a><br>
                        <a href="#">Tin tức</a><br>
                        <a href="#">Giới thiệu</a><br>
                        <a href="#">Phản hồi</a>
                    </div>
                    <div class="col-md-4">
                        <h4>Nhận tin mới</h4>
                        <p class="text-white" style="font-size: 15px;">
                            CamNangDuLich sẽ cập nhật thường xuyên về những ưu đãi,
                            khuyến mãi mới và hot trong tháng đến quý khách.
                        </p>
                        <div class="input-group">
                            <input type="email" class="form-control" placeholder="Email của bạn...">
                            <span class="input-group-btn">
                                <button class="btn btn-secondary" type="button">Nhận!</button>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-3" style="padding-left: 45px;">
                        <h4>Liên hệ</h4>
                        <i class="fa fa-fw fa-map-marker text-white ft-lh"></i><span class="text-white">Địa chỉ liên hệ</span><br>
                        <i class="fa fa-fw fa-phone text-white ft-lh"></i><span class="text-white">0123456789</span><br>
                        <i class="fa fa-fw fa-envelope text-white ft-lh"></i><span class="text-white">abc@gmail.com</span><br>
                        <i class="fa fa-fw fa-facebook text-white ft-lh"></i><span class="text-white">abc@facebook.com</span>
                    </div>
                </div>
                <hr style="border-top: 1px solid rgba(255, 255, 255, 0.13);">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>
            <!-- /.container -->
        </footer>


        <!-- Login Popup -->
        <div id="login_pp" class="modal">
            <div class="modal-content animate">
                <div class="container_log" style="padding-bottom: 0px;">
                    <h2 class="text-center">Đăng nhập</h2>
                    <hr>
                </div>

                <div class="container_log" style="padding-top: 0px;">
                	<form action="home/dangnhap.html" method="post" id="login_form">
	                    <label class="label_log"><i class="fa fa-envelope"></i><b> Email</b></label>
	                    <input type="email" placeholder="Nhập email của bạn" name="login_email" class="input_log" autofocus required>
	
	                    <br><label class="label_log"><i class="fa fa-lock"></i><b> Mật khẩu</b></label>
	                    <input type="password" placeholder="Nhập mật khẩu" name="login_password" class="input_log" required>
	
	                    <button type="submit" class="log"><i class="fa fa-sign-in"></i> Đăng nhập</button>
	                    <span>Chưa có tài khoản?</span><a onclick="registerpp()" style="cursor: pointer; color: green;"> Đăng ký ngay</a>
                    </form>
                    <hr>
                    <button id="btn-facebook" class="log_opid" style="background-color: #3a5a98;">
                        <i class="fa fa-facebook" style="padding-right: 5px;"></i> Đăng nhập bằng Facebook
                    </button>
                    <button id="btn-google" class="log_opid" style="background-color: #d34836; float: right;">
                        <i class="fa fa-google-plus"></i> Đăng nhập bằng Google+
                    </button>
                </div>

                <div class="container_log" style="background-color:#f1f1f1">
                    <button type="button" onclick="closepp()" class="cancelbtn log"><i class="fa fa-times"></i> Hủy</button>
                    <span class="psw">Lấy lại
                        <a onclick="repasspp()" style="cursor: pointer; color: green;"> Mật khẩu</a>
                    </span>

                </div>
            </div>
        </div>

        <!-- Register Popup -->
        <div id="register_pp" class="modal">
            <form class="modal-content animate" action="home/dangky.html" method="get" id="register_form">
                <div class="container_log" style="padding-bottom: 0px;">
                    <h2 class="text-center">Đăng ký</h2>
                    <hr>
                </div>

                <div class="container_log" style="padding-top: 0px;">
                    <input type="email" placeholder="Nhập email cửa bạn" name="reg_email" class="input_log" autofocus required>
                    <input type="password" placeholder="Nhập mật khẩu" name="reg_matkhau" class="input_log" required>
                    <input type="text" placeholder="Nhập số điện thoại" name="reg_sdt" class="input_log" required>
                    <input type="text" placeholder="Nhập họ đệm" name="hodem" class="input_log" required>
                    <input type="text" placeholder="Nhập tên của bạn" name="ten" class="input_log" required>
                    <button type="submit" class="log"><i class="fa fa-sign-in"></i> Đăng ký</button>
                    <div class="form-check">
                        <label class="custom-control custom-checkbox">
                            <input name="reg_checkbox" type="checkbox" class="custom-control-input" required>
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">
                                Tôi đã đọc và chấp nhận các <a href="#">chính sách của Website</a>,
                                <a href="#">điều khoản & điều kiện</a> và <a href="#">chính sách quyền riêng tư</a>
                            </span>
                        </label>
                    </div>
                </div>

                <div class="container_log" style="background-color:#f1f1f1">
                    <button type="button" onclick="closepp()" class="cancelbtn log"><i class="fa fa-times"></i> Hủy</button>
                    <span class="psw">Quay lại <a onclick="loginpp()" style="cursor: pointer; color: green;">Đăng nhập</a></span>
                </div>
            </form>
        </div>

        <!-- Repass Popup -->
        <div id="repwd_pp" class="modal">
            <form class="modal-content animate" action="home/passkeymailer.html" method="post" id="repass_form">
                <div class="container_log" style="padding-bottom: 0px;">
                    <h2 class="text-center">Lấy lại mật khẩu</h2>
                    <hr>
                </div>

                <div class="container_log" style="padding-top: 0px;">
                    <span>Điền Email của bạn vào form phía dưới, chúng tôi sẽ gửi mật khẩu mới về email của bạn!</span>
                    <br>
                    <label class="label_log"><i class="fa fa-envelope"></i><b> Email</b></label>
                    <input type="email" placeholder="Nhập email của bạn" name="email" class="input_log" autofocus>

                    <button id="btn-forgot" type="submit" class="log" disabled="disabled" hidden=""><i class="fa fa-paper-plane"></i> Gửi lại mật khẩu</button>
                    <div class="g-recaptcha" data-callback="recaptchaCallback" data-sitekey="6Le1uDoUAAAAABM0IPZMlTwNs6QQaXE470V0betd"></div>
                    <script>
	                    function recaptchaCallback() {
	                        $('#btn-forgot').removeAttr('disabled');
	                        $('#btn-forgot').removeAttr('hidden');
	                    };
                    </script>
                </div>

                <div class="container_log" style="background-color:#f1f1f1">
                    <button type="button" onclick="closepp()" class="cancelbtn log"><i class="fa fa-times"></i> Hủy</button>
                    <span class="psw">Quay lại <a onclick="loginpp()" style="cursor: pointer; color: green;">Đăng nhập</a></span>
                </div>
            </form>
        </div>
        
        <!-- Thêm khách sạn Popup -->
        <div id="taokhachsan_pp" class="modal">
            <form class="modal-content animate" action="#" method="post" id="taokhachsan_form">
                <div class="container_log" style="padding-bottom: 0px;">
                    <h2 class="text-center">Tạo khách sạn của bạn</h2>
                    <hr>
                </div>

                <div class="container_log" style="padding-top: 0px;">
                    <span>Chọn hình ảnh khách sạn của bạn</span>
                    <br>
                    <input type="file" name="hinhanh" value="cont">
                    <input type="text" placeholder="Nhập tên khách sạn của bạn" name="tenkhachsan" class="input_log" autofocus>
                    <input type="text" placeholder="Nhập số diện thoại liên hệ" name="sodienthoai" class="input_log">
                    <input type="text" placeholder="Nhập tỉnh thành" name="tenkhachsan" class="input_log">
                    <select class="form-control" id="exampleSelect1">
						<option selected="selected" disabled="disabled">-- Chọn tỉnh thành --</option>
						<c:forEach var="tt" items="${lsttinhthanh}">
							<option value="${tt.idtinhthanh}">${tt.tinhthanh}</option>
						</c:forEach>
					</select> 
					<input type="text" placeholder="Nhập địa chỉ khách sạn" name="diachi" class="input_log">
                    <button id="btn-forgot" type="submit" class="log" disabled="disabled" hidden=""><i class="fa fa-building-o"></i> Tạo khách sạn</button>
                    <div class="g-recaptcha" data-callback="recaptchaCallback" data-sitekey="6Le1uDoUAAAAABM0IPZMlTwNs6QQaXE470V0betd"></div>
                    <script>
	                    function recaptchaCallbacktaokhachsan() {
	                        $('#btn-forgot').removeAttr('disabled');
	                        $('#btn-forgot').removeAttr('hidden');
	                    };
                    </script>
                </div>

                <div class="container_log" style="background-color:#f1f1f1">
                    <button type="button" onclick="closepp()" class="cancelbtn log"><i class="fa fa-times"></i> Hủy</button>
                    <span class="psw">Quay lại <a onclick="loginpp()" style="cursor: pointer; color: green;">Đăng nhập</a></span>
                </div>
            </form>
        </div>
        
        <script src="js/openid-login.js" type="text/javascript"></script>
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- End Bootstrap core JavaScript -->
        <!-- Alert check js-->
	    <script src="js/alert-check.js" type="text/javascript"></script>
    </body>
</html>
