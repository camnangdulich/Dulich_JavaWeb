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
		            <a href="home/trang-chu.html">Trang chủ</a>
		        </li>
		        <li class="breadcrumb-item active">Thông tin tài khoản</li>
		    </ol>
		
		    <div class="row">
		        <!-- Thông tin liên hệ -->
		        <div class="col-lg-3" style="margin-top: 20px;">
		            <div class="ih-item circle effect1">
		                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
		                    <div class="spinner"></div>
		                    <div class="img"><img id="myimage" src="files/avatar/${loguser.avatar}" alt="img"></div>
		                    <div class="info">
		                        <div class="info-back">
		                            <h3>Đổi hình đại diện</h3>
		                            <p>Chọn ảnh đại diện của bạn sau đó chọn chỉnh sửa thông tin để thực hiện</p>
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
		                        <form action="home/thong-tin-tai-khoan.html" method="post" enctype="multipart/form-data" id="tttaikhoan_form">
		                        	<input name="idtk" value="${loguser.idtaikhoan}" hidden="">
		                            <input name="avatar" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)" hidden="">
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Email</label>
		                                <div class="col-sm-10">
		                                    <input disabled="disabled" type="email" class="form-control" value="${loguser.email}">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Số điện thoại</label>
		                                <div class="col-sm-10">
		                                    <input disabled="disabled" name="sdt" type="text" class="form-control" value="${loguser.sodienthoai}">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Loại tài khoản</label>
		                                <div class="col-sm-10">
		                                    <input disabled="disabled" type="email" class="form-control" value="${loguser.quyen.quyen}">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Mật khẩu</label>
		                                <div class="col-sm-10">
		                                    <input name="matkhau" type="password" class="form-control" placeholder="Nhập mật khẩu" value="${loguser.matkhau}">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Họ đệm</label>
		                                <div class="col-sm-10">
		                                    <input name="hodem" type="text" class="form-control" placeholder="Nhập họ đệm" value="${loguser.hodem}">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Tên</label>
		                                <div class="col-sm-10">
		                                    <input name="ten" type="text" class="form-control" placeholder="Nhập tên" value="${loguser.ten}">
		                                </div>
		                            </div>
		                            <div class="form-group row">
		                                <label class="col-sm-2 col-form-label">Địa chỉ</label>
		                                <div class="col-sm-10">
		                                    <input name="diachi" type="text" class="form-control" placeholder="Nhập địa chỉ" value="${loguser.diachi}">
		                                </div>
		                            </div>
		                            <button type="submit" class="btn btn-success" style="float: right;">Chỉnh sửa thông tin</button>
		                        </form>
		                        <script type="text/javascript">
		                        	// Các input thay đổi thì mới được submit
			                        $('form')
			                        .each(function(){
			                            $(this).data('serialized', $(this).serialize())
			                        })
			                        .on('change input', function(){
			                            $(this)             
			                                .find('input:submit, button:submit')
			                                    .prop('disabled', $(this).serialize() == $(this).data('serialized'))
			                            ;
			                         })
			                        .find('input:submit, button:submit')
			                            .prop('disabled', true);
		                        </script>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- /.row -->
		</div>
	</c:otherwise>
</c:choose>
