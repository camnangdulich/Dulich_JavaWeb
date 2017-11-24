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
                            <th>ID</th>
                            <th>Tên loại</th>
                            <th>Mô tả</th>
                            <th>Diện tích</th>
                            <th>Số người</th>
                            <th>Loại giường</th>
                            <th>Thêm giường</th>
                            <th>Hướng</th>
                            <th>Hình ảnh</th>
                            <th>Khách sạn</th>
                            
                            <th><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                             <th>ID</th>
                            <th>Tên loại</th>
                            <th>Mô tả</th>
                            <th>Diện tích</th>
                            <th>Số người</th>
                            <th>Loại giường</th>
                            <th>Thêm giường</th>
                            <th>Hướng</th>
                            <th>Hình ảnh</th>
                            <th>Khách sạn</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="lp" items="${lplist}">
                            <tr>
                                <td>${lp.idloaiphong}</td>
                                <td>${lp.tenloai}</td>
                                <td>${lp.mota}</td>
                                <td>${lp.dientich}</td>
                                <td>${lp.songuoi}</td>
                                <td>${lp.loaigiuong}</td>
                                <td>${lp.themgiuong}</td>
                                <td>${lp.huong}</td>
                               <td style="width: 50px;"><img src="files/khachsan/${lp.hinhanh}" width="50px" height="50px"></td>
                                <td>${lp.khachsan.tenkhachsan}</td>
                                <td>
                                	<a href="#" style="padding-right: 5px;">
	                                	<i class="fa fa-pencil" title="Sửa loại phòng"></i> 
	                                </a>
	                                <a id="xoataikhoan" style="color: red; cursor: pointer;" onclick="kiemtraxoataikhoan('${u.email}',2)">
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