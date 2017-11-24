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
        <li class="breadcrumb-item active">Danh sách tài khoản</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu tài khoản</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" >
                    <thead>
                        <tr>
                            <th>Avatar</th>
                            <th>Email</th>
                            <th>Mật khẩu</th>
                            <th>Họ và tên</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Quyền</th>
                            <th>Trạng thái</th>
                            <th><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Avatar</th>
                            <th>Email</th>
                            <th>Mật khẩu</th>
                            <th>Họ và tên</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Quyền</th>
                            <th>Trạng thái</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="u" items="${tklist}">
                            <tr>
                                <td style="width: 50px;"><img src="files/avatar/${u.avatar}" width="50px" height="50px"></td>
                                <td>${u.email}</td>
                                <td>${u.matkhau}</td>
                                <td>${u.hodem} ${u.ten}</td>
                                <td>${u.sodienthoai}</td>
                                <td>${u.diachi}</td>
                                <td>${u.quyen.quyen}</td>
                                <c:choose>
								    <c:when test="${u.trangthai.idtrangthai == 1}">
								       <td style="color: #5cb85c;">${u.trangthai.trangthai}</td>
								    </c:when>
								    <c:when test="${u.trangthai.idtrangthai == 2}">
								        <td style="color: #f0ad4e;">${u.trangthai.trangthai}</td>
								    </c:when>
								    <c:otherwise>
								        <td style="color: red;">${u.trangthai.trangthai}</td>
								    </c:otherwise>
								</c:choose>
                                <td>
                                	<a href="admin/staikhoan/${u.idtaikhoan}.html" style="padding-right: 5px;">
	                                	<i class="fa fa-pencil" title="Sửa tài khoản"></i> 
	                                </a>
	                                <a id="xoataikhoan" style="color: red; cursor: pointer;" onclick="kiemtraxoataikhoan('${u.idtaikhoan}','${u.email}')">
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