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
        <li class="breadcrumb-item active">Danh sách tour du lịch</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu tour du lịch</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                    <thead>
                        <tr>
                        	<th style="width: 20px">ID</th>
                            <th style="width: 50px;">Ảnh</th>
                            <th>Tên tour</th>
                            <th>Giá</th>
                            <th>Điểm đi</th>
                            <th>Điểm đến</th>
                            <th>Thời gian</th>
                            <th style="width: 20px;"><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                        	<th>ID</th>
                        	<th>Ảnh</th>
                            <th>Tên tour</th>
                            <th>Giá</th>
                            <th>Điểm đi</th>
                            <th>Điểm đến</th>
                            <th>Thời gian</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="tu" items="${tulist}">
                        	<c:if test="${tu.congty.idcongty == loguserct.idcongty}">
	                        	<tr>
	                        		<td>${tu.idtour}</td>
	                                <td><img src="files/tour/${tu.hinhtour}" width="80px"></td>
	                                <td>${tu.tentour}</td>
	                                <td style="width: 150px;">${String.format("%,d", tu.gia)}  VNĐ</td>
	                                <td style="width: 150px;">${tu.diemdi}</td>
	                                <td style="width: 150px;">${tu.tinhthanh.tinhthanh}</td>
	                                <td style="width: 200px;">${tu.thoigiankhoihanh}</td>
	                                <td>
	                                	<a href="admin/danh-sach-tour-du-lich/sua-tour/${tu.slug}.html" style="padding-right: 5px;">
		                                	<i class="fa fa-pencil" title="Sửa Tour"></i> 
		                                </a>
		                                <a  style="color: red; cursor: pointer;" 
		                                onclick="kiemtraxoat('${tu.idtour}','${tu.tentour }')">
		                                	<i class="fa fa-times" title="Xóa Tour"></i>
		                                </a>
									</td>
	                            </tr>
                        	</c:if>
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