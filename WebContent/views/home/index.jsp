<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    	<!--
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        -->
        <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('./files/home/home1.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Du lịch khắp Việt Nam</h3>
                    <p>Khám phá ngay những địa điểm du lịch hoài không chán</p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('./files/home/home2.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Khách sạn lý tưởng</h3>
                    <p>Tìm kiếm và khám phá những khách sạn nơi bạn muốn đi du lịch</p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('./files/home/home3.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Các Tour du lịch hấp dẫn</h3>
                    <p>Cập nhật các tour du lịch hấp dẫn và đặc biệt</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <div class="tinhthanh" style="margin-top: 35px;">
        <div class="container-fluid bg-3 text-center">    
            <div class="row">
            	<c:forEach var="tth" items="${lsttinhthanh}" end="6">
	            	<div class="col-sm-3 ih-item square effect13 top_to_bottom" style="width: 100%; height: 100%; padding: 0;">
	                    <a href="home/tinh-thanh/${tth.slug}.html">
	                        <div class="img">
	                        	<img src="files/tinhthanh/${tth.hinhanh}" class="img-responsive" style="width:100%" alt="${tth.tinhthanh}">
	                        </div>
	                        <div class="info">
	                            <h3>${tth.tinhthanh}</h3>
	                            <p>${tth.mota}</p>
	                        </div>
	                    </a>
	                </div>
            	</c:forEach>
            	<div class="col-sm-3 ih-item square effect13 top_to_bottom" style="width: 100%; height: 100%; padding: 0;">
                    <a href="home/tinh-thanh/danh-sach.html">
                        <div class="img">
                        	<img src="files/tinhthanh/Tất cả.jpg" class="img-responsive" style="width:100%" alt="Xem thêm tỉnh thành">
                        </div>
                        <div class="info">
                            <h3>Xem thêm</h3>
                            <p>Xem thêm các tỉnh thành ở Việt Nam</p>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <h3 class="h3-fx">Tin tức du lịch</h3>
    <hr>
    
    <div class="row">
        <div class="col-md-12">
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" href="#tinmoi" role="tab" data-toggle="tab">Bài đăng mới nhất</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#xemnhieu" role="tab" data-toggle="tab">Được xem nhiều nhất</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane in active" id="tinmoi">
                    <div class="modal-body tt-bv">
	                    <c:forEach var="ttm" items="${lsttintucmoi}">
		                    <!-- Features Section -->
						    <div class="row">
						        <div class="col-lg-8">
						            <a href="home/tin-tuc/bai-viet/${ttm.slug}.html"><h5>${ttm.tieude}</h5></a>
						            <i class="fa fa-fw fa-share-alt ft-lh"></i><span class="sp-ttm">Được chia sẻ bởi: 
						            ${ttm.taikhoan.hodem} ${ttm.taikhoan.ten}
						                - <i class="fa fa-fw fa-clock-o ft-lh"></i>${ttm.thoigian}</span>
						            <p class="p-fx">${ttm.tomtat}</p>
						            <i class="fa fa-fw fa-eye ft-lh"></i><span class="sp-ttm">${ttm.luotxem} lượt xem</span>
						        </div>
						        <div class="col-lg-4 ih-item square effect7" style="padding: 0px;">
						            <a href="home/tin-tuc/bai-viet/${ttm.slug}.html">
										<div class="img">
											<img class="img-fluid rounded" src="files/tintuc/${ttm.hinhanh}" alt="${ttm.hinhanh}">
										</div>
										<div class="info">
											<h3>Xem tiếp</h3>
											<p style="padding-bottom: 0;">
												<i class="fa fa-fw fa-share-alt" style="padding-right: 5px;"></i> 
													Được chia sẻ bởi : ${ttm.taikhoan.hodem} ${ttm.taikhoan.ten}
											</p>
								            <p style="padding: 0;">
								            	<i class="fa fa-clock-o" style="padding-right: 5px;"></i>
								             	Thời gian : ${ttm.thoigian}
								             </p>
								            <p style="padding: 0;">
								            	<i class="fa fa-fw fa-eye ft-lh" style="padding-right: 5px;"></i>
								            	 Lượt xem : ${ttm.luotxem}
								            </p>
										</div>
									</a>
						        </div>
						    </div>
						    <hr>
	                    </c:forEach>
					    <div class="row">
					        <div class="col-md-12 text-center"> 
					            <a href="home/tin-tuc/tin-moi.html"><button class="btn btn-success">Xem thêm tin tức</button></a>
					        </div>
					    </div>
					    <!-- /.row -->
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="xemnhieu">
                    <div class="modal-body tt-bv">
                        <c:forEach var="txn" items="${lsttinxemnhieu}">
		                    <!-- Features Section -->
						    <div class="row">
						        <div class="col-lg-8">
						            <a href="home/tin-tuc/bai-viet/${txn.slug}.html"><h5>${txn.tieude}</h5></a>
						            <i class="fa fa-fw fa-share-alt ft-lh"></i><span class="sp-ttm">Được chia sẻ bởi: 
						            ${txn.taikhoan.hodem} ${txn.taikhoan.ten}
						                - <i class="fa fa-fw fa-clock-o ft-lh"></i>${txn.thoigian}</span>
						            <p class="p-fx">${txn.tomtat}</p>
						            <i class="fa fa-fw fa-eye ft-lh"></i><span class="sp-ttm">${txn.luotxem} lượt xem</span>
						        </div>
						        <div class="col-lg-4 ih-item square effect7" style="padding: 0px;">
						            <a href="home/tin-tuc/bai-viet/${txn.slug}.html">
										<div class="img">
											<img class="img-fluid rounded" src="files/tintuc/${txn.hinhanh}" alt="${txn.hinhanh}">
										</div>
										<div class="info">
											<h3>Xem tiếp</h3>
											<p style="padding-bottom: 0;">
												<i class="fa fa-fw fa-share-alt" style="padding-right: 5px;"></i> 
													Được chia sẻ bởi : ${txn.taikhoan.hodem} ${txn.taikhoan.ten}
											</p>
								            <p style="padding: 0;">
								            	<i class="fa fa-clock-o" style="padding-right: 5px;"></i>
								             	Thời gian : ${txn.thoigian}
								             </p>
								            <p style="padding: 0;">
								            	<i class="fa fa-fw fa-eye ft-lh" style="padding-right: 5px;"></i>
								            	 Lượt xem : ${txn.luotxem}
								            </p>
										</div>
									</a>
						        </div>
						    </div>
						    <hr>
	                    </c:forEach>
                    </div>
                </div>
            </div>

        </div>
    </div>
    
    

    <!-- Khách sạn tốt nhất -->
    <h3 class="h3-fx">Khách sạn tốt nhất</h3>
    <hr>
    <div class="row">
    	<c:forEach var="kstn" items="${lstdanhgiakhachsan}">
	        <div class="col-lg-3 col-sm-6 portfolio-item">
	        	<div class="card h-80">
	                <a href="#"><img class="card-img-top" src="files/khachsan/${kstn.khachsan.hinhanh}" alt="${kstn.khachsan.hinhanh}"></a>
	                <div class="card-body">
	                    <h6 class="card-title">
	                        <a href="#">${kstn.khachsan.tenkhachsan}</a>
	                    </h6>
	                    <p class="p-fx" class="card-text" style="font-size: 14px; margin-bottom: 5px;">${kstn.khachsan.diachi}</p>
	                    <c:choose>
	                    	<c:when test="${kstn.star == 5}">
	                    		<span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
	                    	</c:when>
	                    	<c:when test="${kstn.star == 4}">
	                    		<span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
	                    	</c:when>
	                    	<c:when test="${kstn.star == 3}">
	                    		<span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
	                    	</c:when>
	                    	<c:when test="${kstn.star == 2}">
	                    		<span class="fa fa-star checked"></span>
			                    <span class="fa fa-star checked"></span>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<span class="fa fa-star checked"></span>
	                    	</c:otherwise>
	                    </c:choose>
	                </div>
	            </div>
	        </div>
         </c:forEach>
    </div>
   	<script type="text/javascript">
		$(".card-title").shorten({
		    "showChars" : 60,
		    "moreText"  : "",
		    "lessText"  : "",
		});
	</script>
    <hr>
    <div class="row">
        <div class="col-md-12 text-center"> 
            <button class="btn btn-success">Xem thêm các khách sạn khác</button>
        </div>
    </div>
    <!-- /.row -->

    <!-- Tour du lịch nổi bật -->
    <h3 class="h3-fx">Tour du lịch nổi bật</h3>
    <hr>
    <div class="row">
	    <c:forEach var="tur" items="${lsttournoibat}">
	            <div class="col-lg-3 col-sm-6 portfolio-item">
	            <div class="card h-80">
	                <a href="#"><img class="card-img-top" src="files/tour/${tur.hinhtour}" alt="${tur.hinhtour}"></a>
	                <div class="card-body">
	                    <h6 class="card-title">
	                        <a href="#">${tur.tentour}</a>
	                    </h6>
	                    <p style="font-size: 13px;" class="card-text">${tur.diemdi} <i class="fa fa-long-arrow-right"></i> ${tur.tinhthanh.tinhthanh}</p>
	                    <h5 style="color: green;"><i class="fa fa-money"></i> ${String.format("%,d", tur.gia)}  VNĐ</h5>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-12 text-center"> 
            <button class="btn btn-success">Xem thêm các Tour du lịch khác</button>
        </div>
    </div>
    <hr>

    <!-- Khám phá -->
    <div class="row mb-4">
        <div class="col-md-8">
            <p>Khám phá thêm nhiều địa điểm du lịch và khách sạn tốt nhất tại nhiều tỉnh thành khác nhau.<br>
                Hãy bắt đầu khám phá ngay với CamNangDuLich ^^!</p>
        </div>
        <div class="col-md-4">
            <a class="btn btn-lg btn-secondary btn-block" href="home/tinh-thanh/danh-sach.html">Khám phá ngay</a>
        </div>
    </div>

</div>
<!-- /.container -->
