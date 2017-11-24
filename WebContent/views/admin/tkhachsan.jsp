<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Thêm khách sạn mới</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-10 col-md-auto">
                    <form action="admin/tkhachsan.html" method="post" enctype="multipart/form-data">
                   		<input name="idtk" type="hidden" value="1">
                    	<div class="form-group row">
                    		<label class="col-sm-2 col-form-label">Ảnh khách sạn</label>
                            <div class="col-sm-10">
                                <label class="custom-file" style="display: none;">
                                    <input name="hinhanh" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)">
                                </label>
                                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
                                	<img id="myimage" src="files/avatar/av1.png" style="max-height: 120px;">
                                </a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Tên khách sạn</label>
                            <div class="col-sm-10">
                                <input name="tenks" type="text" class="form-control" placeholder="Nhập Tên khách sạn">
                            </div>
                        </div>
                        <div class="form-group row">
                       	 <label class="col-sm-2 col-form-label">Dịch vụ</label>
                       	 	<div class="col-sm-10">
                                 <c:forEach var="dv" items="${dvlist}">
                                 <c:choose>
                                 	<c:when test="${dv.iddichvu == 1}">
                                 	</c:when>
                                 	<c:otherwise>
                                 		<div class="form-check form-check-inline">
										  	<label class="custom-control custom-checkbox form-check-label">
										        <input name="dichvu" type="checkbox" class="custom-control-input" value="${dv.iddichvu}">
											  	<span class="custom-control-indicator"></span>
											  	<span class="custom-control-description">${dv.tendichvu}</span>
											</label>
										</div>
                                 	</c:otherwise>
									</c:choose>
								 </c:forEach>
							</div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Tỉnh thành</label>
                            <div class="col-sm-10">
                                <select name="tinhthanh" class="form-control">
                                	<option selected="selected" disabled>-- Chọn tỉnh thành --</option>
                                	<c:forEach var="tth" items="${tthlist}">
                                    	<option value="${tth.idtinhthanh}">${tth.tinhthanh}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Địa chỉ</label>
                            <div class="col-sm-10">
                                <input name="diachi" type="text" class="form-control" placeholder="Nhập địa chỉ">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Số điện thoại</label>
                            <div class="col-sm-10">
                                <input name="sdt" type="text" class="form-control" placeholder="Nhập số điện thoại">
                                <small class="form-text text-muted">${message}</small>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Trạng thái</label>
                            <div class="col-sm-10">
                                <select name="trangthai" class="form-control">
                                	<option selected="selected" disabled>-- Chọn trạng thái --</option>
                                	<c:forEach var="trt" items="${trtlist}">
                                    	<option value="${trt.idtrangthai}">${trt.trangthai}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-10 offset-md-3">
                                <button type="submit" class="btn btn-primary">Thêm khách sạn</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>