<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="admin/dieu-khien.html">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Thông tin công ty</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-12 col-md-auto">
                    <form action="admin/thong-tin-cong-ty.html" method="post">
                    	<input name="idct" type="hidden" value="${loguserct.idcongty}">
                        <div class="form-group row">
                        	<label class="col-sm-2 col-form-label">Tên công ty</label>
                            <div class="col-sm-10">
                                <input name="tencongty" value="${loguserct.tencongty}" type="text" class="form-control" placeholder="Nhập tên công ty">
                            </div>
                        </div>
                        <div class="form-group row">
                        	<label class="col-sm-2 col-form-label">Số điện thoại</label>
                            <div class="col-sm-10">
                                <input name="sodienthoai" value="${loguserct.sodienthoai}" type="text" class="form-control" placeholder="Nhập số điện thoại">
                            </div>
                        </div>
                        <div class="form-group row">
                        	<label class="col-sm-2 col-form-label">Địa chỉ</label>
                            <div class="col-sm-10">
                                <input name="diachi" value="${loguserct.diachi}" type="text" class="form-control" placeholder="Nhập địa chỉ">
                            </div>
                        </div>
                        <div class="form-group row">
                        	<label class="col-sm-2 col-form-label">Mô tả công ty</label>
                            <div class="col-sm-10">
                                <input name="mota" value="${loguserct.mota}" type="text" class="form-control" placeholder="Nhập mô tả công ty">
                            </div>
                        </div>
                        <div class="form-group row">
                        	<div class="col-md-2"></div>
                            <div class="col-sm-10 offset-md-3">
                                <button type="submit" class="btn btn-primary">Sửa thông tin công ty</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>