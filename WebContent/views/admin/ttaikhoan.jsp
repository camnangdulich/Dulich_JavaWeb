<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid" onload="swal('Any fool can use a computer')">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Thêm tài khoản mới</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-10 col-md-auto">
                    <form action="admin/ttaikhoan.html" method="post" enctype="multipart/form-data" id="ttaikhoan">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Quyền</label>
                            <div class="col-sm-10" id="label-validation">
                                <select name="quyen" class="form-control">
                                	<option selected="selected" disabled>-- Chọn quyền --</option>
                                	<c:forEach var="q" items="${qlist}">
                                    	<option value="${q.idquyen}">${q.quyen}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-10" id="label-validation">
                                <input id="email" name="email" type="email" class="form-control" placeholder="Nhập Email">
                                <small id="loieml"></small>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Mật khẩu</label>
                            <div class="col-sm-10" id="label-validation">
                                <input id="matkhau" name="matkhau" type="password" class="form-control" placeholder="Nhập mật khẩu">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Nhập lại</label>
                            <div class="col-sm-10" id="label-validation">
                                <input name="rematkhau" type="password" class="form-control" placeholder="Nhập lại mật khẩu">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Số điện thoại</label>
                            <div class="col-sm-10" id="label-validation">
                                <input name="sdt" type="text" class="form-control" placeholder="Nhập số điện thoại">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-10 offset-md-3">
                                <button id="btn-themtaikhoan" type="button" class="btn btn-primary">Thêm tài khoản</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>