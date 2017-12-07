<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Page Content -->
<div class="container">

	<h3 class="h3-fx">Tìm kiếm</h3>
    <hr>
		<form id="command" action="home/timkiem.html" method="get">
            <div class="input-group">
                <input name="tukhoa" type="text" class="form-control" placeholder="Tìm kiếm theo khách sạn, tour du lịch và bài viết...">
                <span class="input-group-btn">
                    <button class="btn btn-secondary" type="submit">Tìm!</button>
                </span>
            </div>
        </form>
	
    <!-- Khách sạn -->
    <h3 class="h3-fx">Khách sạn</h3>
    <hr>
    <div class="row">
    	<c:forEach var="ks" items="${ks}" varStatus="stt">
    		<c:if test="${ks.trangthai.idtrangthai == 1}">
		        <div class="col-lg-3 col-sm-6 portfolio-item">
		        	<div class="card h-80">
		                <a href="home/khach-san/${ks.slug}.html"><img class="card-img-top" 
		                src="files/khachsan/${ks.hinhanh}" alt="${ks.hinhanh}"></a>
		                <div class="card-body">
		                    <h6 class="card-title">
		                        <a href="home/khach-san/${ks.slug}.html">${ks.tenkhachsan}</a>
		                    </h6>
		                    <p class="p-fx" class="card-text" style="font-size: 14px; margin-bottom: 5px;">${ks.diachi}</p>
		                    <c:forEach var="dg" items="${lstdgks}">
		                    	<c:if test="${dg.khachsan.idkhachsan == ks.idkhachsan }">
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
		                    	</c:if>
		                    </c:forEach>
		                </div>
		            </div>
		        </div>
	        </c:if>
         </c:forEach>
    </div>
    <hr>
    <!-- /.row -->

    <!-- Tour du lịch -->
    <h3 class="h3-fx">Tour du lịch</h3>
    <hr>
    <div class="row">
	    <c:forEach var="tur" items="${t}">
	            <div class="col-lg-3 col-sm-6 portfolio-item">
	            <div class="card h-80">
	                <a href="home/tour/${tur.slug}.html"><img class="card-img-top" src="files/tour/${tur.hinhtour}" alt="${tur.hinhtour}"></a>
	                <div class="card-body">
	                    <h6 class="card-title">
	                        <a href="home/tour/${tur.slug}.html">${tur.tentour}</a>
	                    </h6>
	                    <p style="font-size: 13px;" class="card-text">${tur.diemdi} <i class="fa fa-long-arrow-right"></i> ${tur.tinhthanh.tinhthanh}</p>
	                    <h5 style="color: green;"><i class="fa fa-money"></i> ${String.format("%,d", tur.gia)}  VNĐ</h5>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
    </div>
    <hr>
    
    <h3 class="h3-fx">Tin tức du lịch</h3>
    <hr>
    <div class="row">
		<c:forEach var="dst" items="${tintuc}">
			<div class="col-md-3">
				<!-- Blog Post -->
				<div class="card mb-4">
					<a href="home/tin-tuc/bai-viet/${dst.slug}.html"><img class="card-img-top" src="files/tintuc/${dst.hinhanh}" alt="Card image cap"></a>
					<div class="card-body">
						<a href="home/tin-tuc/bai-viet/${dst.slug}.html"><h5 class="card-title rgtd">${dst.tieude}</h5></a>
						<p class="card-text p-fx">${dst.tomtat}</p>
					</div>
					<div class="card-footer text-muted sp-ttm">
						<i class="fa fa-fw fa-clock-o ft-lh"></i> Đăng lúc ${dst.thoigian} - <i class="fa fa-fw fa-share-alt ft-lh"></i> ${dst.taikhoan.ten}
					</div>
				</div>
			</div>
		</c:forEach>
    </div>
    <script type="text/javascript">
		$(".p-fx").shorten({
		    "showChars" : 100,
		    "moreText"  : "...",
		    "lessText"  : " ...",
		});
		$(".rgtd").shorten({
		    "showChars" : 60,
		    "moreText"  : "",
		    "lessText"  : "",
		});
	</script>
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
