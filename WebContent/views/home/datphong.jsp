<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<!-- Breadcrumbs -->
	<ol class="breadcrumb" style="margin-top: 20px;">
		<li class="breadcrumb-item"><a href="home/trang-chu.html">Trang chủ</a></li>
		<li class="breadcrumb-item active">Đặt phòng</li>
	</ol>
	
	<div class="row">
		<!-- Thông tin liên hệ -->
		<div class="col-lg-6">
			<div class="card my-4">
				<h5 class="card-header">Thông tin liên hệ</h5>
				<div class="card-body">
					<form action="home/dat-phong-ks.html" method="post" id="datphong_form">
						<input name="idloaiphong" value="${loaiphong.idloaiphong}" hidden="">
						<input name="idkhachsan" value="${khachsan.idkhachsan}" hidden="">
						<div class="form-group row">
							<label class="col-4 col-form-label">Ngày nhận phòng</label>
							<div class="col-8">
								<input id="Ngaydatphong-getdate" name="ngaynhanphong" class="form-control" type="date">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Ngày trả phòng</label>
							<div class="col-8">
								<input id="Ngaytraphong-getdate" name="ngaytraphong" class="form-control" type="date">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Số lượng phòng</label>
							<div class="col-8">
								<input name="soluongphong" class="form-control" type="text" placeholder="Nhập số lượng phòng">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Họ đêm</label>
							<div class="col-8">
								<input name="hodem" class="form-control" type="text" value="${loguser.hodem}" placeholder="Nhập họ đệm">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Tên</label>
							<div class="col-8">
								<input name="ten" class="form-control" type="text" value="${loguser.ten}" placeholder="Nhập tên">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Số điện thoại</label>
							<div class="col-8">
								<input name="sodienthoai" class="form-control" type="text" value="${loguser.sodienthoai}" placeholder="Nhập số điện thoại">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-4 col-form-label">Email</label>
							<div class="col-8">
								<input name="email" class="form-control" type="email" value="${loguser.email}" placeholder="Nhập địa chỉ email">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-check">
								<label class="custom-control custom-checkbox">
								<input name="chapnhan" type="checkbox" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Tôi đã đọc và chấp nhận các 
									<a target="_blank" href="home/chinh-sach-khach-san.html">chính sách của khách sạn</a>, 
									<a target="_blank" href="home/dieu-khoan-dieu-kien.html">điều khoản, điều kiện</a> và
									<a target="_blank" href="home/chinh-sach-quyen-rieng-tu.html">chính sách quyền riêng tư</a></span>
								</label>
							</div>
							<div class="col-md-12 text-center">
								<button type="submit" class="btn btn-success" style="width: 200px;">Đặt phòng</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- Thông tin phòng -->
		<div class="col-lg-6">
			<div class="card my-4">
				<h5 class="card-header">Thông tin khách sạn và phòng</h5>
				<div class="card-body">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-6 ih-item square effect7"
								style="height: 100%; padding: 0;">
								<a target="_blank" href="home/khach-san/${khachsan.slug}.html">
									<div class="img">
										<img class="img-fluid rounded" src="files/khachsan/${khachsan.hinhanh}" alt="">
									</div>
									<div class="info">
										<h3>${khachsan.tenkhachsan}</h3>
										<p>${khachsan.diachi}</p>
									</div>
								</a>
							</div>
							<div class="col-md-6">
								<h4 class="card-title">${khachsan.tenkhachsan}</h4>
								<hr>
								<c:choose>
									<c:when test="${dgs.star == 5}">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
									</c:when>
									<c:when test="${dgs.star == 4}">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when test="${dgs.star == 3}">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when test="${dgs.star == 2}">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:otherwise>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="row">
								<div class="col-md-12">
									<hr>
									<p><i class="fa fa-location-arrow" style="padding-right: 5px;"></i> Địa chỉ : ${khachsan.diachi}</p>
						            <p><i class="fa fa-phone" style="padding-right: 5px;"></i> Số điện thoại : ${khachsan.sodienthoai}</p>
						            <p><i class="fa fa-map-marker" style="padding-right: 5px;"></i> Thuộc tỉnh thành : ${khachsan.tinhthanh.tinhthanh}</p>
						            <hr>
						            <p><i class="fa fa-bed" aria-hidden="true" style="padding-right: 5px;"></i> Loại phòng: ${loaiphong.tenloai}</p>
						            <p><i class="fa fa-search" aria-hidden="true" style="padding-right: 5px;"></i> Chi tiết phòng: ${loaiphong.mota}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.row -->
	<script type="text/javascript">
		/* ---------------------------------------------------------------------- */
		/* ------------------------- Giới hạn ngày ------------------------------------
		/* ---------------------------------------------------------------------- */
		$(function getdate() {
		    var today = new Date();
		    var dd = today.getDate();
		    var mm = today.getMonth() + 1; //January is 0!
		    var yyyy = today.getFullYear();
	
		    if (dd < 10) {
		        dd = '0' + dd
		    }
	
		    if (mm < 10) {
		        mm = '0' + mm
		    }
		    today = yyyy + '-' + mm + '-' + dd;
		    document.getElementById("Ngaydatphong-getdate").setAttribute("min", today);
		    document.getElementById("Ngaytraphong-getdate").setAttribute("min", today);
		});
	</script>
</div>