<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Phản hồi</li>
    </ol>

    <div class="row">
        <!-- Thông tin liên hệ -->
        <div class="col-lg-4" style="margin-top: 20px;">
            <h5>Thông tin liên hệ</h5>
            <hr>
            <i class="fa fa-fw fa-map-marker ft-lh"></i><span>Địa chỉ liên hệ</span><br>
            <i class="fa fa-fw fa-phone ft-lh"></i><span>0123456789</span><br>
            <i class="fa fa-fw fa-envelope ft-lh"></i><span>abc@gmail.com</span><br>
            <i class="fa fa-fw fa-facebook ft-lh"></i><span>abc@facebook.com</span>
            <hr>
        </div>

        <!-- Thông tin phòng -->
        <div class="col-lg-8">
            <div class="card my-4">
                <h5 class="card-header">Thông tin cá nhân</h5>
                <div class="card-body">
                    <div class="col-md-12">
                        <form action="mailer/repwd_mailer.html" method="post">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Họ và tên</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Nhập họ và tên">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Email</label>
                                <div class="col-sm-9">
                                    <input name="email" type="email" class="form-control" placeholder="Nhập email của bạn">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Nội dung phản hồi</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" rows="5">Ý kiếm phản hồi</textarea>
                                </div>
                                ${message}
                            </div>
                            <button type="submit" class="btn btn-success" style="float: right;">Gửi phản hồi</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>