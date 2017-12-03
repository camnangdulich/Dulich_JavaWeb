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
        <li class="breadcrumb-item active">Danh sách đơn đặt tour</li>
    </ol>
    <!-- Example DataTables Card-->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fa fa-table"></i> Bảng dữ liệu đơn đặt tour</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                    <thead>
                        <tr>
                            <th style="width: 200px;">Họ và tên</th>
                            <th style="width: 100px;">Điện thoại</th>
                            <th style="width: 200px;">Email</th>
                            <th style="width: 70px;">Số người</th>
                            <th style="width: 60px;">Tour ID</th>
                            <th>Yêu cầu</th>
                            <th style="width: 100px;">Trạng thái</th>
                            <th style="width: 10px;"><i class="fa fa-cog"></i></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                        	<th>Họ và tên</th>
                            <th>Điện thoại</th>
                            <th>Email</th>
                            <th>Số người</th>
                            <th>Tour ID</th>
                            <th>Yêu cầu</th>
                            <th>Trạng thái</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="dp" items="${dondattourlst}">
                            <tr>
                            	<c:if test="${dp.tour.congty.idcongty == loguserct.idcongty}">
	                            	<td>${dp.hodem} ${dp.ten}</td>
	                                <td>${dp.dienthoai}</td>
	                                <td>${dp.email}</td>
	                                <td>${dp.songuoi}</td>
	                                <td>${dp.tour.idtour}</td>
	                                <td>${dp.yeucau}</td>
	                                <c:choose>
									    <c:when test="${dp.trangthai.idtrangthai == 1}">
									       <td style="color: #5cb85c;">${dp.trangthai.trangthai}</td>
									    </c:when>
									    <c:when test="${dp.trangthai.idtrangthai == 2}">
									        <td style="color: #f0ad4e;">${dp.trangthai.trangthai}</td>
									    </c:when>
									    <c:otherwise>
									        <td style="color: red;">${dp.trangthai.trangthai}</td>
									    </c:otherwise>
									</c:choose>
	                                <td>
		                                <a  style="color: red; cursor: pointer;" onclick="">
		                                	<i class="fa fa-times" title="Xóa đơn dặt phòng"></i>
		                                </a>
									</td>
                            	</c:if>
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