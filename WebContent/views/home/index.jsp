<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
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
            	<c:forEach var="tth" items="${lsttinhthanh}">
	            	<div class="col-sm-3 ih-item square effect13 top_to_bottom" style="width: 100%; height: 100%; padding: 0;">
	                    <a href="#">
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
                    	<!-- Features Section -->
					    <div class="row">
					        <div class="col-lg-8">
					            <h5>Đi rồi trở lại homestay đẹp chất ngất Đà Lạt bình yên như nhà của mình</h5>
					            <i class="fa fa-fw fa-share-alt ft-lh"></i><span class="sp-ttm">Được chia sẻ bởi: <a href="#">Admin</a>
					                - <i class="fa fa-fw fa-clock-o ft-lh"></i>2 giờ trước</span>
					            <p class="p-fx">Để nhắc về cái tình của Đà Lạt thì có nói cả đời cũng không hết được mất. 
					                Đà Lạt đã luôn nổi tiếng với những không cảnh thơ mộng, 
					                dễ dàng làm tan chảy mọi con tim mạnh mẽ nhất thì khi có sự xuất hiện thêm
					                của loạt những homestay được đầu tư, thiết kế công phu, đẹp dịu dàng và ấm cúng...
					                càng là lí do níu chân của mọi du khách. Và Second house chính là 1 trong những
					                homestay điển hình như vậy mà mình thực sự muốn giới thiệu với các bạn trong bài viết này!
					            </p>
					            <i class="fa fa-fw fa-eye ft-lh"></i><span class="sp-ttm">1453 lượt xem</span>
					        </div>
					        <div class="col-lg-4">
					            <img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">
					        </div>
					    </div>
					    <hr>
					    <div class="row">
					        <div class="col-lg-8">
					            <h5>Đi rồi trở lại homestay đẹp chất ngất Đà Lạt bình yên như nhà của mình</h5>
					            <i class="fa fa-fw fa-share-alt ft-lh"></i><span class="sp-ttm">Được chia sẻ bởi: <a href="#">Admin</a>
					                - <i class="fa fa-fw fa-clock-o ft-lh"></i>2 giờ trước</span>
					            <p class="p-fx">Để nhắc về cái tình của Đà Lạt thì có nói cả đời cũng không hết được mất. 
					                Đà Lạt đã luôn nổi tiếng với những không cảnh thơ mộng, 
					                dễ dàng làm tan chảy mọi con tim mạnh mẽ nhất thì khi có sự xuất hiện thêm
					                của loạt những homestay được đầu tư, thiết kế công phu, đẹp dịu dàng và ấm cúng...
					                càng là lí do níu chân của mọi du khách. Và Second house chính là 1 trong những
					                homestay điển hình như vậy mà mình thực sự muốn giới thiệu với các bạn trong bài viết này!
					            </p>
					            <i class="fa fa-fw fa-eye ft-lh"></i><span class="sp-ttm">1453 lượt xem</span>
					        </div>
					        <div class="col-lg-4">
					            <img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">
					        </div>
					    </div>
					    <hr>
					    <div class="row">
					        <div class="col-lg-8">
					            <h5>Đi rồi trở lại homestay đẹp chất ngất Đà Lạt bình yên như nhà của mình</h5>
					            <i class="fa fa-fw fa-share-alt ft-lh"></i><span class="sp-ttm">Được chia sẻ bởi: <a href="#">Admin</a>
					                - <i class="fa fa-fw fa-clock-o ft-lh"></i>2 giờ trước</span>
					            <p class="p-fx">Để nhắc về cái tình của Đà Lạt thì có nói cả đời cũng không hết được mất. 
					                Đà Lạt đã luôn nổi tiếng với những không cảnh thơ mộng, 
					                dễ dàng làm tan chảy mọi con tim mạnh mẽ nhất thì khi có sự xuất hiện thêm
					                của loạt những homestay được đầu tư, thiết kế công phu, đẹp dịu dàng và ấm cúng...
					                càng là lí do níu chân của mọi du khách. Và Second house chính là 1 trong những
					                homestay điển hình như vậy mà mình thực sự muốn giới thiệu với các bạn trong bài viết này!
					            </p>
					            <i class="fa fa-fw fa-eye ft-lh"></i><span class="sp-ttm">1453 lượt xem</span>
					        </div>
					        <div class="col-lg-4">
					            <img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">
					        </div>
					    </div>
					    <hr>
					    <div class="row">
					        <div class="col-md-12 text-center"> 
					            <button class="btn btn-success">Xem thêm tin tức</button>
					        </div>
					    </div>
					    <!-- /.row -->
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="xemnhieu">
                    <div class="modal-body tt-bv">
                        Nội dung xem nhieu
                    </div>
                </div>
            </div>

        </div>
    </div>
    
    

    <!-- Khách sạn tốt nhất -->
    <h3 class="h3-fx">Khách sạn tốt nhất</h3>
    <hr>
    <div class="row">
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">88 Hilltop Hostel & Villa</a>
                    </h5>
                    <p class="p-fx" class="card-text">Trần Hưng Đạo, Khu Phố 7, Thị Trấn Dương Đông</p>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star checked"></span>
                    <span class="fa fa-star"></span>
                </div>
            </div>
        </div>
    </div>
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
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-sm-6 portfolio-item">
            <div class="card h-80">
                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">Tour du lịch ABC Hà Nội - TP.Hồ Chí Minh</a>
                    </h5>
                    <p style="font-size: 13px;" class="card-text">Hà Nội <i class="fa fa-long-arrow-right"></i> TP.Hồ Chí Minh</p>
                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
                </div>
            </div>
        </div>
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
            <a class="btn btn-lg btn-secondary btn-block" href="#">Khám phá ngay</a>
        </div>
    </div>

</div>
<!-- /.container -->
