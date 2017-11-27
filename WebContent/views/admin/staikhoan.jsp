<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Sửa tài khoản</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-10 col-md-auto">
                    <form action="admin/updatetk.html" method="post" enctype="multipart/form-data" id="staikhoan">
                    	<input name="idtk" type="hidden" value="${user.idtaikhoan}">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Ảnh đại diện</label>
                            <div class="col-sm-10">
                                <label class="custom-file" style="display: none;">
                                    <input name="avatar" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)">
                                </label>
                                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
                                	<img id="myimage" src="files/avatar/av1.png" style="max-width: 120px; max-height: 120px;">
                                </a>
                            </div>
                        </div>
                        <hr>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Quyền</label>
                            <div class="col-sm-10">
                                <select name="quyen" class="form-control">
                                	<option selected="selected" hidden value="${user.quyen.idquyen}">${user.quyen.quyen}</option>
                                	<c:forEach var="q" items="${quyenlist}">
                                    	<option value="${q.idquyen}">${q.quyen}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <hr>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-10" id="label-validation">
                                <input name="email" type="email" class="form-control" value="${user.email}" placeholder="Nhập Email">
  								<small class="form-text text-muted">${message}</small>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Mật khẩu</label>
                            <div class="col-sm-10" id="label-validation">
                                <input name="matkhau" type="password" class="form-control" value="${user.matkhau}" placeholder="Nhập mật khẩu">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Số điện thoại</label>
                            <div class="col-sm-10" id="label-validation">
                                <input name="sdt" type="text" class="form-control" value="${user.sodienthoai}" placeholder="Nhập số điện thoại">
                            </div>
                        </div>
                        <hr>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Họ đệm</label>
                            <div class="col-sm-10" id="label-validation">
                                <input name="hodem" type="text" class="form-control" value="${user.hodem}" placeholder="Nhập họ đệm">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Tên</label>
                            <div class="col-sm-10">
                                <input name="ten" type="text" class="form-control" value="${user.ten}" placeholder="Nhập tên">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Địa chỉ</label>
                            <div class="col-sm-10">
                                <input name="diachi" type="text" class="form-control" value="${user.diachi}" placeholder="Nhập địa chỉ">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-10 offset-md-3">
                                <button type="submit" class="btn btn-primary">Sửa tài khoản</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>