<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <div class="row" style="margin-top: 20px;">
        <div class="col-lg-6">
            <div class="ih-item square effect9 right_to_left" style="width: 100%; height: 100%;">
                <a href="#">
                    <div class="img" ><img class="img-fluid rounded" src="files/tour/${cttour.hinhtour}" alt=""></div>
                    <div class="info">
                        <div class="info-back">
                            <h3>${cttour.tentour}</h3>
                            <p style="padding-bottom: 0;"><i class="fa fa-address-card" style="padding-right: 5px;"></i> Công ty cung cấp: ${cttour.congty.tencongty}</p>
				            <p style="padding: 0;"><i class="fa fa-phone" style="padding-right: 5px;"></i> Số điện thoại : ${cttour.congty.sodienthoai}</p>
				            <p style="padding: 0;"><i class="fa fa-fw fa-envelope" style="padding-right: 5px;"></i> Email công ty : ${cttour.congty.taikhoan.email}</p>
            				<p style="padding: 0;"><i class="fa fa-map-marker" style="padding-right: 5px;"></i> Thuộc tỉnh thành : ${cttour.tinhthanh.tinhthanh}</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-6">
            <h3 class="card-title">${cttour.tentour}</h3>
            <hr>
            <p><i class="fa fa-money"></i> Giá 1 người: <span style="font-weight: bolder; color: green;"> ${String.format("%,d", cttour.gia)} VNĐ</span></p>
            <p><i class="fa fa-address-card"></i> Công ty cung cấp: ${cttour.congty.tencongty}</p>
            <p><i class="fa fa-phone"></i> Số điện thoại : ${cttour.congty.sodienthoai}</p>
            <p><i class="fa fa-fw fa-envelope"></i> Email công ty : ${cttour.congty.taikhoan.email}</p>
			<p><i class="fa fa-map-marker"></i> Thuộc tỉnh thành : ${cttour.tinhthanh.tinhthanh}</p>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-8">
            <ul class="nav nav-tabs" role="tablist">
            	<li class="nav-item">
                    <a class="nav-link active" href="#lichtrinh" role="tab" data-toggle="tab">Lịch trình Tour</a>
                </li>
            	<li class="nav-item">
                    <a class="nav-link" href="#kskhuvuc" role="tab" data-toggle="tab">Khách sạn trong khu vực</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#chitiet" role="tab" data-toggle="tab">Chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#luuy" role="tab" data-toggle="tab">Lưu ý</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#nhacungcap" role="tab" data-toggle="tab">Nhà cung cấp</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
            	<div role="tabpanel" class="tab-pane in active" id="lichtrinh">
                    <div class="modal-body tt-bv">
                    	${cttour.lichtrinh}
                        <hr>
                    </div>
                </div>
            	<div role="tabpanel" class="tab-pane fade" id="kskhuvuc">
                    <div class="modal-body tt-bv">
	                    <div class="row">
		                    <c:forEach var="tur" items="${lstkhachsan}">
		                        <div class="col-lg-4 col-sm-6 portfolio-item">
		                            <div class="card h-80">
		                                <a href="#"><img style="border-radius: 0; padding: 0;" class="card-img-top" 
		                                src="files/khachsan/${tur.hinhanh}" alt="${tur.hinhanh}"></a>
		                                <div class="card-body">
		                                    <h6 class="card-title">
		                                        <a href="#">${tur.tenkhachsan}</a>
		                                    </h6>
		                                    <p style="font-size: 13px;" class="card-text">${tur.diachi}</p>
		                                </div>
		                            </div>
		                        </div>
		                    </c:forEach>
	                    </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="chitiet">
                    <div class="modal-body tt-bv">
                        ${cttour.mota}
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="luuy">
                    <div class="modal-body tt-bv">
                        ${cttour.luuy}
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="nhacungcap">
                    <div class="modal-body tt-bv">
                    	<hr>
                        <p><i class="fa fa-address-card"></i> Công ty cung cấp: ${cttour.congty.tencongty}</p>
			            <p><i class="fa fa-phone"></i> Số điện thoại : ${cttour.congty.sodienthoai}</p>
			            <p><i class="fa fa-fw fa-envelope"></i> Email công ty : ${cttour.congty.taikhoan.email}</p>
						<p><i class="fa fa-map-marker"></i> Thuộc tỉnh thành : ${cttour.tinhthanh.tinhthanh}</p>
						<hr>
                    </div>
                </div>
            </div>

            <div class="card mb-4">
                <div class="card-body">
                    <h4>Các Tour đặc biệt</h4><hr>
                    <div class="row">
	                    <c:forEach var="tur" items="${lsttourdacbiet}">
	                        <div class="col-lg-4 col-sm-6 portfolio-item">
	                            <div class="card h-80">
	                                <a href="#"><img style="border-radius: 0;" class="card-img-top" src="files/tour/${tur.hinhtour}" alt="${tur.hinhtour}"></a>
	                                <div class="card-body">
	                                    <h6 class="card-title">
	                                        <a href="#">${tur.tentour}</a>
	                                    </h6>
	                                    <p style="font-size: 13px;" class="card-text">${tur.diemdi} <i class="fa fa-long-arrow-right"></i> ${tur.tinhthanh.tinhthanh}</p>
	                                </div>
	                            </div>
	                        </div>
	                    </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <!-- Tin xem nhiều nhất -->
            <div class="card my-4">
                <h5 class="card-header">Đặt tour du lịch</h5>
                <div class="card-body">
                <form action="home/tour.html" method="post" >
						<input name="tentour" value="${cttour.idtour}" hidden="">
						<div class="form-group">
							<input name="hodem" class="form-control" type="text" placeholder="Nhập họ đệm" value="${loguser.hodem}">
						</div>
						<div class="form-group">
							<input name="ten" class="form-control" type="text" placeholder="Nhập tên" value="${loguser.ten}">
						</div>
						<div class="form-group">
							<input name="songuoi" class="form-control" type="number" placeholder="Số người" value="">
						</div>
						<div class="form-group">
							<input name="sodienthoai" class="form-control" type="text" placeholder="Nhập số điện thoại" value="${loguser.sodienthoai}">
						</div>
						<div class="form-group">
							<input name="email" class="form-control" type="email" placeholder="Nhập email" value="${loguser.email}">
						</div>
						<div class="form-group">
							<input name="yeucau" class="form-control" type="text" placeholder="Nhập yêu cầu" value="">
						</div>
						<p>thong bao: ${message }</p>
						<button style="width: 100%" type="submit" class="btn btn-success">Đặt tour</button>
					</form>
                </div>
            </div>
        </div>
    </div>

</div>
