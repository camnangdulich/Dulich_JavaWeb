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
        <li class="breadcrumb-item active">Danh sách Công ty</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu Công ty</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" >
                    <thead>
                        <tr>
                            <th>Tên công ty</th>
                            <th>Địa chỉ</th>
                            <th>Mô tả</th>
                            <th>Số điện thoại</th>
                            <th>Ngày tạo</th>
                            <th>Tài khoản</th>
                            <th><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Tên công ty</th>
                            <th>Địa chỉ</th>
                            <th>Mô tả</th>
                            <th>Số điện thoại</th>
                            <th>Ngày tạo</th>
                            <th>Tài khoản</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="ct" items="${ctlist}">
                            <tr>
                                <td>${ct.tencongty}</td>
                                <td>${ct.diachi}</td>
                                <td>${ct.mota}</td>
                                <td>${ct.sodienthoai}</td>
                                <td>${ct.ngaytao}</td>
                                <td>${ct.taikhoan.email}</td>
                                <td>
                                	<a href="#" style="padding-right: 5px;">
	                                	<i class="fa fa-pencil" title="Sửa tài khoản"></i> 
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