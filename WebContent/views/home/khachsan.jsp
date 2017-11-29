<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <div class="row" style="margin-top: 20px;">
        <div class="col-lg-6">
            <div class="ih-item square effect9 right_to_left" style="width: 100%; height: 100%;">
                <a href="#">
                    <div class="img" ><img class="img-fluid rounded" src="files/khachsan/${ctks.hinhanh}" alt="${ctks.hinhanh}"></div>
                    <div class="info">
                        <div class="info-back">
                            <h3>${ctks.tenkhachsan}</h3>
                            <p style="padding-bottom: 0;"><i class="fa fa-location-arrow" style="padding-right: 5px;"></i> Địa chỉ : ${ctks.diachi}</p>
				            <p style="padding: 0;"><i class="fa fa-phone" style="padding-right: 5px;"></i> Số điện thoại : ${ctks.sodienthoai}</p>
				            <p style="padding: 0;"><i class="fa fa-clock-o" style="padding-right: 5px;"></i> Ngày thành lập : ${ctks.ngaydang}</p>
				            <p style="padding: 0;"><i class="fa fa-user" style="padding-right: 5px;"></i> Người tạo : ${ctks.taikhoan.hodem} ${ctks.taikhoan.ten}</p>
            				<p style="padding: 0;"><i class="fa fa-map-marker" style="padding-right: 5px;"></i> Thuộc tỉnh thành : ${ctks.tinhthanh.tinhthanh}</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-6">
            <h3 class="card-title">${ctks.tenkhachsan}</h3>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star"></span>
            <hr>
            <p><i class="fa fa-location-arrow" style="padding-right: 5px;"></i> Địa chỉ : ${ctks.diachi}</p>
            <p><i class="fa fa-phone" style="padding-right: 5px;"></i> Số điện thoại : ${ctks.sodienthoai}</p>
            <p><i class="fa fa-clock-o" style="padding-right: 5px;"></i> Ngày thành lập : ${ctks.ngaydang}</p>
            <p><i class="fa fa-user" style="padding-right: 5px;"></i> Người tạo : ${ctks.taikhoan.hodem} ${ctks.taikhoan.ten}</p>
            <p><i class="fa fa-map-marker" style="padding-right: 5px;"></i> Thuộc tỉnh thành : ${ctks.tinhthanh.tinhthanh}</p>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-8">
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" href="#danhsachphong" role="tab" data-toggle="tab">Danh sách phòng - Đặt phòng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#chitietphong" role="tab" data-toggle="tab">Chi tiết loại phòng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#danhgia" role="tab" data-toggle="tab">Đánh giá khách sạn</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane in active" id="danhsachphong">
                    <div class="modal-body tt-bv">
                        <table class="table table-bordered" id="dataTable" >
		                    <thead>
		                        <tr>
		                            <th>Hình ảnh</th>
		                            <th>Tên loại</th>
		                            <th>Giá</th>
		                            <th>Đặt phòng</th>
		                        </tr>
		                    </thead>
		                    <tfoot>
		                        <tr>
		                            <th>Hình ảnh</th>
		                            <th>Tên loại</th>
		                            <th>Giá</th>
		                            <th>Đặt phòng</th>
		                        </tr>
		                    </tfoot>
		                    <tbody>
		                    	<c:forEach var="lp" items="${loaiphonglst}">
		                    		<tr>
		                                <td style="width: 190px;">
	                                		<img style="padding: 0px;" src="files/phong/${lp.hinhanh}" alt="${lp.hinhanh}">
		                                </td>
		                                <td>${lp.tenloai}</td>
		                                <td>${String.format("%,d", lp.gia)} VNĐ</td>
		                                <td style="width: 10xp;">
		                                	<button class="btn btn-success">Đặt phòng</button>
										</td>
		                            </tr>
		                    	</c:forEach>
		                    </tbody>
		                </table>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="chitietphong">
                    <div class="modal-body tt-bv">
                        <table class="table table-bordered" id="dataTable" >
		                    <thead>
		                        <tr>
		                            <th>Hình ảnh</th>
		                            <th>Tên loại</th>
		                            <th>Mô tả</th>
		                        </tr>
		                    </thead>
		                    <tfoot>
		                        <tr>
		                            <th>Hình ảnh</th>
		                            <th>Tên loại</th>
		                            <th>Mô tả</th>
		                        </tr>
		                    </tfoot>
		                    <tbody>
		                    	<c:forEach var="lp" items="${loaiphonglst}">
		                    		<tr>
		                                <td style="width: 190px;">
	                                		<img style="padding: 0px;" src="files/phong/${lp.hinhanh}" alt="${lp.hinhanh}">
		                                </td>
		                                <td>${lp.tenloai}</td>
		                                <td class="motakhachsan">${lp.mota}</td>
		                            </tr>
		                    	</c:forEach>
		                    </tbody>
		                </table>
                    </div>
                    <script type="text/javascript">
						$(".motakhachsan").shorten({
						    "showChars" : 20,
						    "moreText"  : " ...xem thêm",
						    "lessText"  : " ...rút gọn",
						});
					</script>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="danhgia">
                    <div class="modal-body tt-bv">
                    	<div class="card md-4">
							<form class="card-body">
								<div class="form-group form-inline" style="display: block;">
									<label style="display: block; margin-bottom: 8px;">Họ và tên</label>
									<input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" placeholder="Họ đệm">
									<input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" placeholder="Tên">
								</div>
								<div class="form-group">
									<label for="exampleSelect1">Đánh giá</label> 
									<select class="form-control">
										<option selected="selected" disabled="disabled">-- Chọn đánh giá --</option>
										<option value="1">Không hài lòng</option>
										<option value="2">Bình thường</option>
										<option value="3">Hài lòng</option>
										<option value="4">Rất hài lòng</option>
										<option value="5">Rất tốt</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleTextarea">Nội dung đánh giá</label>
									<textarea class="form-control" id="exampleTextarea" rows="8"></textarea>
								</div>
								<button type="submit" class="btn btn-primary">Bình luận</button>
							</form>
						</div>
						<hr>
						<div class="card mb-4">
			                <div class="card-body">
			                    <h5>Các bình luận cho khách sạn này</h5><hr>
			                    <div class="row">
				                    <c:forEach var="dg" items="${listdgks}">
				                        <div class="col-lg-12 portfolio-item">
				                            <div class="card h-80">
				                                <div class="card-body">
				                                	<div class="col-md-12 row">
				                                	<div class="col-md-2" style="padding: 0px;">
				                                		<a href="#">
				                                		<img style="padding: 0px; border-radius: 0;" class="card-img-top" 
				                                			src="files/avatar/${dg.taikhoan.avatar}" alt="${dg.taikhoan.avatar}">
				                                		</a>
				                                	</div>
				                                	<div class="col-md-10">
				                                	<h6 class="card-title">
				                                        <a href="#">${dg.taikhoan.email}</a>
				                                    </h6>
				                                    <p style="font-size: 13px;" class="card-text rgnd">${dg.noidung}</div>
				                                    
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				                    </c:forEach>
			                    </div>
			                    <script type="text/javascript">
									$(".rgnd").shorten({
									    "showChars" : 200,
									    "moreText"  : " ...xem thêm",
									    "lessText"  : " ...rút gọn",
									});
								</script>
			                </div>
			            </div>
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
            <div class="card my-4">
                <h5 class="card-header">Khách sạn trong khu vực</h5>
                <div class="card-body">
	                <c:forEach var="ks" items="${lstkhachsan}">
	                	<div class="portfolio-item">
	                        <div class="card h-80">
	                            <a href="#"><img style="border-radius: 0;" class="card-img-top" src="files/khachsan/${ks.hinhanh}" alt="${ks.hinhanh}"></a>
	                            <div class="card-body">
	                                <h5 class="card-title">
	                                    <a href="#">${ks.tenkhachsan}</a>
	                                </h5>
	                                <p class="p-fx">${ks.diachi}</p>
	                            </div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
            </div>
        </div>
    </div>

</div>
