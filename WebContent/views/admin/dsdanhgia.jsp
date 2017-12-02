<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="admin/index.html">Điều
				khiển</a></li>
		<li class="breadcrumb-item active">Danh sách đánh giá</li>
	</ol>
	<!-- Example DataTables Card-->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fa fa-table"></i> Bảng dữ liệu đánh giá
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable">
					<thead>
						<tr>
							<th>Id</th>
							<th>Tài khoản</th>
							<th>khách sạn</th>
							<th>Star</th>
							<th>Nội dung</th>
							<th>Thời gian</th>
							<th style="width: 50px;"><i class="fa fa-cog"></i></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>Tài khoản</th>
							<th>khách sạn</th>
							<th>Star</th>
							<th>Nội dung</th>
							<th>Thời gian</th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="dg" items="${dglist}">
							<tr>
								<td>${dg.iddanhgia}</td>
								<td>${dg.taikhoan.email}</td>
								<td>${dg.khachsan.tenkhachsan}</td>
								<td>${dg.star}</td>
								<td>${dg.noidung.substring(0,25)}...</td>
								<td>${dg.thoigian}</td>
								<td>
								<a style="color: red; cursor: pointer;"
									onclick="kiemtraxoadanhgia('${dg.iddanhgia}','${dg.khachsan.tenkhachsan}')">
										<i class="fa fa-times" title="Xóa xóa đánh giá"></i>
								</a></td>
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
		<div class="card-footer small text-muted">
			Cập nhật lúc
			<%=dateFormat.format(date)%></div>
	</div>
</div>
<!-- /.container-fluid-->