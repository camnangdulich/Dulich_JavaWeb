<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="home/trang-chu.html">Trang chủ</a>
        </li>
        <li class="breadcrumb-item active">Xác nhận tài khoản</li>
    </ol>

    <div class="row" style="margin-bottom: 30px;">
        <!-- Thông tin liên hệ -->
        <div class="col-lg-12 text-center" style="margin-top: 20px; margin-bottom: 30px;">
            <a class="ft-logo" href="home/trang-chu.html"><img src="files/home/logogioithieu.png"></a>
            <hr>
            <strong class="text-success"><i class="fa fa-check" aria-hidden="true"></i> Tài khoản của bạn đã được xác minh!</strong>
            <p>CamNangDuLich cảm ơn bạn ${tennguoidung} đã đăng ký và sử dụng website của chúng tôi</p>
            <hr>
            <b><i class="fa fa-book" aria-hidden="true"></i> Bạn vui lòng đọc các chính sách của website trước khi sủ dụng tài khoản</b><br>
            <a href="home/chinh-sach-khach-san.html"><i class="fa fa-chain-broken" aria-hidden="true"></i><span> Chính sách khách sạn</span></a><br>
            <a href="home/dieu-khoan-dieu-kien.html"><i class="fa fa-chain-broken" aria-hidden="true"></i><span> Điều khoản và điều kiện</span></a><br>
            <a href="home/chinh-sach-quyen-rieng-tu.html"><i class="fa fa-chain-broken" aria-hidden="true"></i><span> Chính sách quyền riêng tư</span></a>
            <hr>
            <i class="fa fa-fw fa-map-marker ft-lh"></i><span>27 Nguyễn Tất Thành, Tân Lợi, Thành phố Buôn Ma Thuột, Đắk Lắk</span><br>
            <i class="fa fa-fw fa-phone ft-lh"></i><span>5003 555 678</span><br>
            <i class="fa fa-fw fa-envelope ft-lh"></i><span>camnangdulich360@gmail.com</span><br>
            <i class="fa fa-fw fa-facebook ft-lh"></i><span>camnangdulich@facebook.com</span>
        </div>
    </div>
    <!-- /.row -->
</div>