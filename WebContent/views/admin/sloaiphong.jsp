<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Sửa loại phòng</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-10 col-md-auto">
                    <form action="admin/sloaiphong.html" method="post" enctype="multipart/form-data">
                    	<input name="idlp" type="hidden" value="${lstlp.idloaiphong}">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Loại phòng</label>
                            <div class="col-sm-10">
                                <input name="tenloai" type="text" class="form-control" value="${lstlp.tenloai}" placeholder="Nhập tên loại phòng">
  								<small class="form-text text-muted"></small>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Mô tả</label>
                            <div class="col-sm-10">
                                <input name="mota" type="text" class="form-control" value="${lstlp.mota}" placeholder="Mô tả loại phòng">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Diện tích</label>
                            <div class="col-sm-10">
                                <input name="dientich" type="text" class="form-control" value="${lstlp.dientich}" placeholder="Nhập diện tích">
                            </div>
                        </div>
                        <hr>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Số người</label>
                            <div class="col-sm-10">
                                <input name="songuoi" type="text" class="form-control" value="${lstlp.songuoi}" placeholder="Nhập số người">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Loại giường</label>
                            <div class="col-sm-10">
                                <input name="loaigiuong" type="text" class="form-control" value="${lstlp.loaigiuong}" placeholder="Nhập loại giường">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Thêm giường</label>
                            <div class="col-sm-10">
                                <input name="themgiuong" type="text" class="form-control" value="${lstlp.themgiuong}" placeholder="Thêm giường">
                            </div>
                        </div>
                         <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Hướng phòng</label>
                            <div class="col-sm-10">
                                <input name="huong" type="text" class="form-control" value="${lstlp.huong}" placeholder="Sửa hướng">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Ảnh đại diện</label>
                            <div class="col-sm-10">
                                <label class="custom-file" style="display: none;">
                                    <input name="hinhanh" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)">
                                </label>
                                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
                                	<img id="myimage" src="files/${lstlp.hinhanh}" style="max-width: 120px; max-height: 120px;">
                                </a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Khách sạn</label>
                            <div class="col-sm-10">
                                <select name="khachsan" class="form-control">
                                	<option selected="selected" hidden value="${lstlp.khachsan.idkhachsan}">${lstlp.khachsan.tenkhachsan}</option>
                                	<c:forEach var="ks" items="${kslist}">
                                    	<option value="${ks.idkhachsan}">${ks.tenkhachsan}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <hr>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-10 offset-md-3">
                                <button type="submit" class="btn btn-primary">Sửa loại phòng</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>