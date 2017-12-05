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
            <a href="admin/dieu-khien.html">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Danh sách đơn đặt phòng</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu đơn đặt phòng</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                    <thead>
                        <tr>
                            <th>Họ và tên</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Loại phòng</th>
                            <th>Số lượng</th>
                            <th>Ngày nhận</th>
                            <th>Ngày trả</th>
                            <th>Trạng thái</th>
                            <th style="width: 10px;"><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                        	<th>Họ và tên</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Loại phòng</th>
                            <th>Số lượng</th>
                            <th>Ngày nhận</th>
                            <th>Ngày trả</th>
                            <th>Trạng thái</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="dp" items="${dondatphonglst}">
                        	<c:if test="${dp.khachsan.idkhachsan == loguserks.idkhachsan}">
                            	<tr>
	                            	<td>${dp.hodem} ${dp.ten}</td>
	                                <td>${dp.sodienthoai}</td>
	                                <td>${dp.email}</td>
	                                <td>${dp.loaiphong.tenloai}</td>
	                                <td>${dp.soluongphong}</td>
	                                <td>${dp.ngaynhanphong}</td>
	                                <td>${dp.ngaytraphong}</td>
	                                <c:choose>
									    <c:when test="${dp.trangthai.idtrangthai == 1}">
									       <td style="color: #5cb85c;">${dp.trangthai.trangthai}</td>
									    </c:when>
									    <c:when test="${dp.trangthai.idtrangthai == 2}">
									        <td>
									        	<a onclick="xacnhandondatphong('${dp.iddatphong}', '${dp.hodem} ${dp.ten}', '${dp.email}')" 
									        	style="color: #f0ad4e; cursor: pointer;">${dp.trangthai.trangthai}</a>
									        </td>
									    </c:when>
									    <c:otherwise>
									        <td style="color: red;">${dp.trangthai.trangthai}</td>
									    </c:otherwise>
									</c:choose>
	                                <td>
		                                <a  style="color: red; cursor: pointer;" 
		                                onclick="kiemtraxoadatphong('${dp.iddatphong}','${dp.ten}')">
		                                	<i class="fa fa-times" title="Xóa đơn dặt phòng"></i>
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