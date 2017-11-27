<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<!-- Breadcrumbs -->
	<ol class="breadcrumb" style="margin-top: 20px;">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">Đặt phòng</li>
	</ol>

	<div class="row">
		<!-- Thông tin liên hệ -->
		<div class="col-lg-6">
			<div class="card my-4">
				<h5 class="card-header">Thông tin liên hệ</h5>
				<div class="card-body">
					<form class="form-horizontal">
						<div class="form-group row">
							<label class="col-4 col-form-label">Loại phòng zz</label>
							<div class="col-8">
								<select name="loaiphong" class="form-control">
									<option selected="selected" disabled="disabled">-- Chọn loại phòng --</option>
									<c:forEach var="lp" items="${loaiplist}">
										<option value="">${lp.tenloai}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Ngày nhận phòng</label>
							<div class="col-8">
								<input class="form-control" type="date" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Ngày trả phòng</label>
							<div class="col-8">
								<input class="form-control" type="date" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Số lượng phòng</label>
							<div class="col-8">
								<input class="form-control" type="number" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Họ đêm</label>
							<div class="col-8">
								<input class="form-control" type="text" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Tên</label>
							<div class="col-8">
								<input class="form-control" type="text" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Số điện thoại</label>
							<div class="col-8">
								<input class="form-control" type="text" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Email</label>
							<div class="col-8">
								<input class="form-control" type="email" value="">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-check">
								<label class="custom-control custom-checkbox"> <input
									type="checkbox" class="custom-control-input"> <span
									class="custom-control-indicator"></span> <span
									class="custom-control-description">Tôi đã đọc và chấp
										nhận các chính sách của khách sạn, điều khoản, điều kiện và
										chính sách quyền riêng tư</span>
								</label>
							</div>
							<div class="col-md-12 text-center">
								<button class="btn btn-success" style="width: 200px;">Đặt
									phòng</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- Thông tin phòng -->
		<div class="col-lg-6">
			<div class="card my-4">
				<h5 class="card-header">Thông tin phòng</h5>
				<div class="card-body">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-6 ih-item square effect7"
								style="height: 100%; padding: 0;">
								<a href="#">
									<div class="img">
										<img class="img-fluid rounded"
											src="http://placehold.it/700x450" alt="">
									</div>
									<div class="info">
										<h3>Heading here</h3>
										<p>Description goes here</p>
									</div>
								</a>
							</div>
							<div class="col-md-6">
								<h4 class="card-title">88 Hilltop Hostel & Villa</h4>
								<hr>
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span class="fa fa-star"></span>
							</div>
							<div class="row">
								<div class="col-md-12">
									<hr>
									<p>
										<i class="fa fa-location-arrow"></i> Trần Hưng Đạo, Khu Phố 7,
										Thị Trấn Dương Đông, TP. Phú Quốc
									</p>
									<p>
										<i class="fa fa-phone"></i> 0123456789
									</p>
									<p>
										<i class="fa fa-clock-o"></i> Mở cửa từ: 12:00 AM - 11:30 PM
									</p>
									<p class="p-fx">
										Thiết kế đơn giản, thực tế và thanh lịch.<br> Nội thất
										hiện đại, đầy đủ tiện nghi.<br> Đội ngũ phục vụ chu đáo,
										tận tâm.
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.row -->
</div>