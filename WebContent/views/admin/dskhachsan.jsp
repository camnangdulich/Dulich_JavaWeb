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
        <li class="breadcrumb-item active">Danh sách khách sạn</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu khách sạn</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                    <thead>
                        <tr>
                            <th>Ảnh</th>
                            <th>Tên khách sạn</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Người đăng</th>
                            <th>Tỉnh thành</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                        	<th>Ảnh</th>
                            <th>Tên khách sạn</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Người đăng</th>
                            <th>Tỉnh thành</th>
                            <th>Trạng thái</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="ks" items="${kslist}">
                            <tr>
                            	<td style="width: 50px;"><img src="files/khachsan/${ks.hinhanh}" height="50px"></td>
                                <td>${ks.tenkhachsan}</td>
                                <td>${ks.sodienthoai}</td>
                                <td>${ks.diachi}</td>
                                <td>${ks.taikhoan.email}</td>
                                <td>${ks.tinhthanh.tinhthanh}</td>
                                <c:choose>
								    <c:when test="${ks.trangthai.idtrangthai == 1}">
								       <td>
								       	<a style="cursor: pointer; color: #5cb85c;" onclick="khoakhachsan('${ks.idkhachsan}','${ks.tenkhachsan}')">${ks.trangthai.trangthai}</a>
								       	</td>
								    </c:when>
								    <c:when test="${ks.trangthai.idtrangthai == 2}">
								        <td>
								        	<a style="cursor: pointer; color: #f0ad4e;" onclick="xacnhankhachsan('${ks.idkhachsan}','${ks.tenkhachsan}')">${ks.trangthai.trangthai}</a>
								        </td>
								    </c:when>
								    <c:otherwise>
								        <td style="color: red;">${ks.trangthai.trangthai}</td>
								    </c:otherwise>
								</c:choose>
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