<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
	<c:when test="${loguser == null}">
		<script>
			$(document).ready(function() {
				window.location = "error/stop.html";
			});
		</script>
	</c:when>
	<c:otherwise>
		<div class="container">
		    <!-- Breadcrumbs -->
		    <ol class="breadcrumb" style="margin-top: 20px;">
		        <li class="breadcrumb-item">
		            <a href="index.html">Home</a>
		        </li>
		        <li class="breadcrumb-item active">Thông tin tài khoản</li>
		    </ol>
		
		    <div class="row">
		        <!-- Thông tin liên hệ -->
		        <div class="col-lg-3" style="margin-top: 20px;">
		            <div class="ih-item circle effect1">
		                <a href="#">
		                    <div class="spinner"></div>
		                    <div class="img"><img src="img/av1.png" alt="img"></div>
		                    <div class="info">
		                        <div class="info-back">
		                            <h3>Heading here</h3>
		                            <p>Description goes here</p>
		                        </div>
		                    </div>
		                </a>
		            </div>
		        </div>
		
		        <!-- Thông tin phòng -->
		        <div class="col-lg-9">
		            <div class="card my-4">
		                <h5 class="card-header">Thông tin tài khoản</h5>
		                <div class="card-body">
		                    <div class="col-md-12">
		                        <form>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Email</label>
		                                <div class="col-sm-10">
		                                    <input type="email" class="form-control" placeholder="Nhập Email">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Mật khẩu</label>
		                                <div class="col-sm-10">
		                                    <input type="password" class="form-control" placeholder="Nhập mật khẩu">
		                                </div>
		                            </div>
		                        </form>
		                    </div>
		                </div>
		                <h5 class="card-header">Thông tin cá nhân</h5>
		                <div class="card-body">
		                    <div class="col-md-12">
		                        <form>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Họ đệm</label>
		                                <div class="col-sm-10">
		                                    <input type="text" class="form-control" placeholder="Nhập họ đệm">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Tên</label>
		                                <div class="col-sm-10">
		                                    <input type="text" class="form-control" placeholder="Nhập tên">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Số điện thoại</label>
		                                <div class="col-sm-10">
		                                    <input type="text" class="form-control" placeholder="Nhập số điện thoại">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Địa chỉ</label>
		                                <div class="col-sm-10">
		                                    <input type="text" class="form-control" placeholder="Nhập địa chỉ">
		                                </div>
		                            </div>
		                            <button class="btn btn-success" style="float: right;">Chỉnh sửa thông tin</button>
		                        </form>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- /.row -->
		</div>
	</c:otherwise>
</c:choose>
