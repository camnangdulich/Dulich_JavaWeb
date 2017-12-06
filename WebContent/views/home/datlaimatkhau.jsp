<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="home/trang-chu.html">Trang chủ</a>
        </li>
        <li class="breadcrumb-item active">Đặt lại mật khẩu</li>
    </ol>

    <div class="row">
        <div class="col-lg-2" style="margin-top: 20px;">
        </div>

        <!-- Thông tin phòng -->
        <div class="col-lg-8 text-center">
        	<a class="ft-logo" href="home/trang-chu.html"><img src="files/home/logogioithieu.png"></a>
            <hr>
            <p>CamNangDuLich cảm ơn bạn ${taikhoan.hodem} ${taikhoan.ten} đã đăng ký và sử dụng website của chúng tôi</p>
            <hr>
            <b><i class="fa fa-book" aria-hidden="true"></i> Bạn vui lòng đọc các chính sách của website trước khi sủ dụng tài khoản</b><br>
            <a href="home/chinh-sach-khach-san.html"><i class="fa fa-chain-broken" aria-hidden="true"></i><span> Chính sách khách sạn</span></a><br>
            <a href="home/dieu-khoan-dieu-kien.html"><i class="fa fa-chain-broken" aria-hidden="true"></i><span> Điều khoản và điều kiện</span></a><br>
            <a href="home/chinh-sach-quyen-rieng-tu.html"><i class="fa fa-chain-broken" aria-hidden="true"></i><span> Chính sách quyền riêng tư</span></a>
            <hr>
            <div class="card my-4">
                <h5 class="card-header">Đối mật khẩu mới</h5>
                <div class="card-body">
                    <div class="col-md-12">
                        <form action="home/dat-lai-mat-khau.html" method="post" id="datlaimatkhau_form">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Mật khẩu mới</label>
                                <input name="idtk" value="${taikhoan.idtaikhoan}" hidden="">
                                <div class="col-sm-9">
                                    <input id="matkhaumoi" name="matkhaumoi" type="password" class="form-control" placeholder="Nhập mật khẩu mới">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Nhập lại mật khẩu</label>
                                <div class="col-sm-9">
                                    <input name="rematkhaumoi" type="password" class="form-control" placeholder="Nhập lại mật khẩu">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-success" style="float: right;">Thay đổi mật khẩu</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>