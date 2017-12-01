<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="admin/dieu-khien.html">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Thông tin khách sạn</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-12 col-md-auto">
                    <form action="admin/tbaiviet.html" method="post" enctype="multipart/form-data">
                    	<input name="idtk" type="hidden" value="1">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <label class="custom-file" style="display: none;">
                                    <input name="hinhanh" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)">
                                </label>
                                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
                                	<img id="myimage" src="files/khachsan/${loguserks.hinhanh}" style="max-height: 120px;">
                                </a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                           		<select class="form-control" style="width: 80%; margin-right: 20px; float: left;">
	                               	 <c:forEach var="a" items="${ctdvlist}">
	                               	 	<c:if test="${a.khachsan.idkhachsan == loguserks.idkhachsan}" >
	                                   	 	<option value="${a.dichvu.iddichvu}">${a.dichvu.tendichvu}</option>
	                                   	 </c:if>
	                                 </c:forEach>
	                            </select>
                                 <i class="fa fa-pencil"></i><a href="#" style="color: green;"> Chỉnh sửa dịch vụ</a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                           		<select class="form-control" style="width: 80%; margin-right: 20px; float: left;">
	                               	 <c:forEach var="a" items="${ctlplist}">
	                               	 	<c:if test="${a.khachsan.idkhachsan == loguserks.idkhachsan}" >
	                                   	 	<option value="${a.loaiphong.idloaiphong}">${a.loaiphong.tenloai}</option>
	                                   	 </c:if>
	                                 </c:forEach>
	                            </select>
                                 <i class="fa fa-pencil"></i><a href="#" style="color: green;"> Chỉnh sửa loại phòng</a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input name="tenkhachsan" value="${loguserks.tenkhachsan}" type="text" class="form-control" placeholder="Nhập tên khách sạn">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input name="sodienthoai" value="${loguserks.sodienthoai}" type="text" class="form-control" placeholder="Nhập số điện thoại">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                           		<select name="tinhthanh" class="form-control">
                           			<option selected="selected" hidden="" value="${loguserks.tinhthanh.idtinhthanh}">${loguserks.tinhthanh.tinhthanh}</option>
	                               	 <c:forEach var="a" items="${tinhthanhlst}">
                                   	 	<option value="${a.idtinhthanh}">${a.tinhthanh}</option>
	                                 </c:forEach>
	                            </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input name="diachi" value="${loguserks.diachi}" type="text" class="form-control" placeholder="Nhập địa chỉ">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12 offset-md-3">
                                <button type="submit" class="btn btn-primary">Sửa thông tin khách sạn</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>