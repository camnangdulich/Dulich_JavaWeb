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
        <li class="breadcrumb-item active">Danh sách Tỉnh Thành</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu tỉnh thành</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                    <thead>
                        <tr>
                            <th style="width: 50px;">ID</th>
                            <th>Tên tour</th>
                            <th>Mô tả</th>
                            <th>Giá</th>
                            <th>Điểm đi</th>
                            <th>Điểm đến</th>
                            <th>Công ty</th>
                            <th>Giờ khởi hành</th>
                            <th>Lịch trình</th>
                            <th>Lưu ý</th>
                            <th style="width: 50px;"><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                        	 <th style="width: 50px;">ID</th>
                            <th>Tên tour</th>
                            <th>Mô tả</th>
                            <th>Giá</th>
                            <th>Điểm đi</th>
                            <th>Điểm đến</th>
                            <th>Công ty</th>
                            <th>Giờ khởi hành</th>
                            <th>Lịch trình</th>
                            <th>Lưu ý</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="tu" items="${tulist}">
                            <tr>
                                <td>${tu.idtour}</td>
                                <td>${tu.tentour}</td>
                                <td>${tu.mota}</td>
                                <td>${tu.gia}</td>
                                <td>${tu.tinhthanhByDiemdi.tentinh}</td>
                                <td>${tu.tinhthanhByDiemden.tentinh}</td>
                                <td>${tu.congty.tencongty}</td>
                                <td>${tu.giokhoihanh}</td>
                                <td>${tu.lichtrinh}</td>
                                <td>${tu.luuy}</td>
                                <td>
                                	<a href="#" style="padding-right: 5px;">
	                                	<i class="fa fa-pencil" title="Sửa tỉnh thành"></i> 
	                                </a>
	                                <a id="xoataikhoan" style="color: red; cursor: pointer;" onclick="kiemtraxoataikhoan('',2)">
	                                	<i class="fa fa-times" title="Xóa xóa tỉnh thành"></i>
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