<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="admin/index.html">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Danh sách loại phòng</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu loại phòng</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" >
                    <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Tên loại</th>
                            <th>Mô tả</th>
                            <th>Thêm giường</th>
                            <th>Hướng</th>
                            <th>Giá</th>
                            <th><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Tên loại</th>
                            <th>Mô tả</th>
                            <th>Thêm giường</th>
                            <th>Hướng</th>
                            <th>Giá</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="lp" items="${lplist}">
                            <tr>
                            	<td style="width: 50px;"><img src="files/phong/${lp.hinhanh}" width="150px"></td>
                                <td>${lp.tenloai}</td>
                                <td>${lp.mota.substring(0,30)}...</td>
                                <td>${lp.themgiuong}</td>
                                <td>${lp.huong.tenhuong}</td>
                                <td>${lp.gia}</td>
                                <td>
                                	<a href="#" style="padding-right: 5px;">
	                                	<i class="fa fa-pencil" title="Sửa loại phòng"></i> 
	                                </a>
	                                <a id="xoataikhoan" style="color: red; cursor: pointer;" onclick="">
	                                	<i class="fa fa-times" title="Xóa tài khoản"></i>
	                                </a>
								</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%
            DateFormat dateFormat = new SimpleDateFormat("HH:mm a - dd/MM/yyyy ");
            Date date = new Date();
        %>
        <div class="card-footer small text-muted">Cập nhật lúc <%= dateFormat.format(date)%></div>
    </div>
</div>
<!-- /.container-fluid-->