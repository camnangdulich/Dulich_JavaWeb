<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <div class="row" style="margin-top: 20px;">
        <div class="col-lg-6">
            <div class="ih-item square effect6 bottom_to_top" style="width: 100%; height: 100%;">
                <a>
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
		                            <th style="width: 120px;">Đặt phòng</th>
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
		                    	<c:forEach var="lp" items="${ctlplist}">
		                    		<c:if test="${lp.khachsan.idkhachsan ==  ctks.idkhachsan}">
		                    			<tr>
			                                <td style="width: 190px;">
		                                		<img style="padding: 0px;" src="files/phong/${lp.loaiphong.hinhanh}" alt="${lp.loaiphong.hinhanh}">
			                                </td>
			                                <td>${lp.loaiphong.tenloai}</td>
			                                <td>${String.format("%,d", lp.loaiphong.gia)} VNĐ</td>
			                                <td>
			                                	<form action="home/dat-phong.html" method="get">
			                                		<input name="khachsan" value="${ctks.slug}" hidden="">
			                                		<input name="loaiphong" value="${lp.loaiphong.slug}" hidden="">
			                                		<button class="btn btn-success">Đặt phòng</button>
			                                	</form>
											</td>
			                            </tr>
		                    		</c:if>
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
		                            <th style="width: 200px;">Tên loại</th>
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
						    "showChars" : 120,
						    "moreText"  : " ...xem thêm",
						    "lessText"  : " ...rút gọn",
						});
					</script>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="danhgia">
                    <div class="modal-body tt-bv">
                    	<c:choose>
                    		<c:when test="${loguser != null}">
		                    	<div class="card md-4">
									<form action="home/danhgiakhachsan.html" method="post" class="card-body" id="dgkhachsan_form">
										<div class="col-md-12 row" style="padding: 0px; margin: 0px;">
											<div class="col-md-2" style="padding: 0px;">
												<a href="home/thong-tin-tai-khoan.html"> <img
													style="padding: 0px; border-radius: 0; width: 100px;"
													class="card-img-top" src="files/avatar/${loguser.avatar}" alt="${loguser.avatar}">
												</a>
											</div>
											<div class="col-md-10" style="padding-right: 0px;">
												<h6 class="card-title">
													<a href="home/thong-tin-tai-khoan.html">${loguser.hodem} ${loguser.ten}</a>
												</h6>
												<div class="form-group">
													<label for="exampleSelect1">Đánh giá khách sạn ${ctks.tenkhachsan}</label>
													<input name="idtaikhoan" value="${loguser.idtaikhoan}" hidden="">
													<input name="idkhachsan" value="${ctks.idkhachsan}" hidden="">
													<select name="star" class="form-control">
														<option selected="selected" disabled="disabled">-- Chọn đánh giá --</option>
														<option value="5">Rất tốt</option>
														<option value="4">Rất hài lòng</option>
														<option value="3">Hài lòng</option>
														<option value="2">Không hài lòng</option>
														<option value="1">Quá tệ</option>
													</select>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="exampleTextarea">Nội dung đánh giá</label>
											<textarea name="noidung" class="form-control" id="exampleTextarea" rows="5"></textarea>
										</div>
										<button type="submit" class="btn btn-success">Bình luận</button>
									</form>
								</div>
		                    </c:when>
		                    <c:otherwise>
		                    	<button onclick="loginpp()" class="btn btn-success">Vui lòng đăng nhập để thực hiện đánh giá</button>
		                    </c:otherwise>
                    	</c:choose>
						<hr>
						<div class="card mb-4">
			                <div class="card-body">
			                    <h5>Các đánh giá cho khách sạn này</h5><hr>
			                    <div class="row">
				                    <c:forEach var="dg" items="${listdgks}" end="9">
				                        <div class="col-lg-12 portfolio-item">
				                            <div class="card h-80">
				                                <div class="card-body">
				                                	<div class="col-md-12 row" style="padding-right: 0px;">
					                                	<div class="col-md-2" style="padding: 0px;">
					                                		<a>
					                                		<img style="padding: 0px; border-radius: 0;" class="card-img-top" 
					                                			src="files/avatar/${dg.taikhoan.avatar}" alt="${dg.taikhoan.avatar}">
					                                		</a>
					                                	</div>
					                                	<div class="col-md-10" style="padding-right: 0px;">
					                                		<c:if test="${dg.taikhoan.idtaikhoan == loguser.idtaikhoan || loguser.idtaikhoan == 1}">
						                                		<a onclick="kiemtraxoadanhgiakhachsan(${dg.iddanhgia})">
							                                		<i title="Xóa đánh giá này" class="fa fa-times" aria-hidden="true" 
							                                		style="float: right; font-size: 13px; color: red;"></i>
							                                	</a>
						                                	</c:if>
						                                	<h6 class="card-title">
						                                        <a>${dg.taikhoan.hodem} ${dg.taikhoan.ten}</a>
						                                    </h6>
						                                    <c:choose>
																<c:when test="${dg.star == 5}">
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																</c:when>
																<c:when test="${dg.star == 4}">
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star"></span>
																</c:when>
																<c:when test="${dg.star == 3}">
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star checked"></span>
																	<span class="fa fa-star"></span>
																	<span class="fa fa-star"></span>
																</c:when>
																<c:when test="${dg.star == 2}">
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
						                                    <p style="font-size: 13px; padding-top: 7px;" class="card-text rgnd">${dg.noidung}</p>
					                                    </div>
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				                    </c:forEach>
			                    </div>
			                    <script type="text/javascript">
									$(".rgnd").shorten({
									    "showChars" : 150,
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
	                                <a href="home/tour/${tur.slug}.html"><img style="border-radius: 0;" class="card-img-top" src="files/tour/${tur.hinhtour}" alt="${tur.hinhtour}"></a>
	                                <div class="card-body">
	                                    <h6 class="card-title">
	                                        <a href="home/tour/${tur.slug}.html">${tur.tentour}</a>
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
	                	<c:if test="${ks.idkhachsan != ctks.idkhachsan}">
	                		<div class="portfolio-item">
		                        <div class="card h-80">
		                            <a href="home/khach-san/${ks.slug}.html"><img style="border-radius: 0;" class="card-img-top" src="files/khachsan/${ks.hinhanh}" alt="${ks.hinhanh}"></a>
		                            <div class="card-body">
		                                <h5 class="card-title">
		                                    <a href="home/khach-san/${ks.slug}.html">${ks.tenkhachsan}</a>
		                                </h5>
		                                <p class="p-fx">${ks.diachi}</p>
		                            </div>
		                        </div>
		                    </div>
	                	</c:if>
	                </c:forEach>
                </div>
            </div>
        </div>
    </div>

</div>
