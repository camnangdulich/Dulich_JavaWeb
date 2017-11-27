<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Danh sách tin tức</li>
    </ol>

    <div class="row">
        <!-- Chi tiết bài viết -->
        <div class="col-lg-8 tt-bv">
            <!-- Preview Image -->
            <img class="img-fluid rounded" src="files/tintuc/${cttt.hinhanh}" alt="${cttt.hinhanh}">
            <hr>
            <!-- Date/Time -->
            <p><i class="fa fa-fw fa-share-alt ft-lh"></i> Được chia sẻ bởi: ${cttt.taikhoan.hodem} ${cttt.taikhoan.ten} - 
            <i class="fa fa-fw fa-clock-o ft-lh"></i> ${cttt.thoigian}</p>
            <hr>
            <!-- Post Content -->
            <h4>${cttt.tieude}</h4>
            <blockquote class="blockquote">
                <p style="font-size: 16px; font-style: italic; font-weight: 500;">${cttt.tomtat}</p>
            </blockquote>
            <div>${cttt.noidung}
            	<p>${cttt.nguon}</p>
            </div>
            <hr>
            <div class="card mb-4">
                <div class="card-body">
                    <h4>Tin liên quan</h4><hr>
                    <div class="row">
                        <div class="col-lg-5">
                            <a href="#">
                                <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="">
                            </a>
                        </div>
                        <div class="col-lg-7">
                            <h5 class="card-title">Post Title Lorem ipsum dolor sit amet, consectetur adipisicing elit.</h5>
                            <p class="card-text p-fx">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-lg-5">
                            <a href="#">
                                <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="">
                            </a>
                        </div>
                        <div class="col-lg-7">
                            <h5 class="card-title">Post Title Lorem ipsum dolor sit amet, consectetur adipisicing elit.</h5>
                            <p class="card-text p-fx">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-lg-5">
                            <a href="#">
                                <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="">
                            </a>
                        </div>
                        <div class="col-lg-7">
                            <h5 class="card-title">Post Title Lorem ipsum dolor sit amet, consectetur adipisicing elit.</h5>
                            <p class="card-text p-fx">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-lg-5">
                            <a href="#">
                                <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="">
                            </a>
                        </div>
                        <div class="col-lg-7">
                            <h5 class="card-title">Post Title Lorem ipsum dolor sit amet, consectetur adipisicing elit.</h5>
                            <p class="card-text p-fx">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-lg-5">
                            <a href="#">
                                <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="">
                            </a>
                        </div>
                        <div class="col-lg-7">
                            <h5 class="card-title">Post Title Lorem ipsum dolor sit amet, consectetur adipisicing elit.</h5>
                            <p class="card-text p-fx">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Sidebar -->
        <div class="col-md-4">
            <!-- Danh mục tin tức -->
            <div class="card mb-4">
                <h5 class="card-header" style="border: none;">Danh mục tin tức</h5>
                <div class="list-group" id="dmtt">
                	<c:forEach var="dmtt" items="${loaitinlst}">
                		<c:choose>
				        	<c:when test="${dmtt.idloaitin == idloaitin}">
				        		<a href="#" class="list-group-item active">${dmtt.loaitin}</a>
				        	</c:when>
				        	<c:otherwise>
				        		<a href="#" class="list-group-item">${dmtt.loaitin}</a>
				        	</c:otherwise>
				        </c:choose>
		            </c:forEach>
          		</div>
            </div>

            <!-- Tin mới nhất -->
            <div class="card my-4">
                <h5 class="card-header">Tin mới nhất</h5>
                <div class="card-body">
	                <c:forEach var="ttm" items="${lstsibarttm}">
	                	<div class="card mb-4">
	                        <img style="border-radius: inherit;" class="card-img-top" src="files/tintuc/${ttm.hinhanh}" alt="${ttm.hinhanh}">
	                        <div class="card-body">
	                            <h6 class="card-title">${ttm.tieude}</h6>
	                            <div class="card-footer text-muted sp-ttm">
									<i class="fa fa-fw fa-clock-o ft-lh"></i> ${ttm.thoigian}
								</div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
                <ul class="pagination justify-content-center mb-4">
                    <li class="page-item">
                        <a class="page-link" href="#">Xem thêm &rarr;</a>
                    </li>
                </ul>
            </div>

            <!-- Tin xem nhiều nhất -->
            <div class="card my-4">
                <h5 class="card-header">Xem nhiều nhất</h5>
                <div class="card-body">
                    <c:forEach var="ttm" items="${lstsibarttxn}">
	                	<div class="card mb-4">
	                        <img style="border-radius: inherit;" class="card-img-top" src="files/tintuc/${ttm.hinhanh}" alt="${ttm.hinhanh}">
	                        <div class="card-body">
	                            <h6 class="card-title">${ttm.tieude}</h6>
	                            <div class="card-footer text-muted sp-ttm">
									<i class="fa fa-fw fa-eye ft-lh"></i> ${ttm.luotxem} lượt xem
								</div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
                <ul class="pagination justify-content-center mb-4">
                    <li class="page-item">
                        <a class="page-link" href="#">Xem thêm &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>

    </div>
    <!-- /.row -->
</div>