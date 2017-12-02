<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Page Content -->
<div class="container">

    <div class="tinhthanh" style="margin-top: 35px;">
        <div class="container-fluid bg-3 text-center">    
            <div class="row">
            	<c:forEach var="tth" items="${lsttinhthanh}" end="6">
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
            	<div class="col-sm-3 ih-item square effect13 top_to_bottom" style="width: 100%; height: 100%; padding: 0;">
                    <a href="#">
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

    <!-- Khách sạn tốt nhất -->
    <h3 class="h3-fx">Khách sạn tốt ở ${title}</h3>
    <hr>
    <div class="row">
	    <c:forEach var="ks" items="${listks}">
   			<div class="col-lg-3 col-sm-6 portfolio-item">
	            <div class="card h-80">
	                <a href="#"><img class="card-img-top" src="files/khachsan/${ks.hinhanh}" alt="${ks.hinhanh}"></a>
	                <div class="card-body">
	                    <h5 class="card-title">
	                        <a href="#">${ks.tenkhachsan}</a>
	                    </h5>
	                    <p class="p-fx" class="card-text">${ks.diachi}</p>
	                    <span class="fa fa-star checked"></span>
	                    <span class="fa fa-star checked"></span>
	                    <span class="fa fa-star checked"></span>
	                    <span class="fa fa-star checked"></span>
	                    <span class="fa fa-star checked"></span>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
    </div>
    <!-- /.row -->

    <!-- Tour du lịch nổi bật -->
    <h3 class="h3-fx">Tour du lịch nổi bật ở ${title}</h3>
    <hr>
    <div class="row">
    	<c:forEach var="tr" items="${listt}">
    		<div class="col-lg-3 col-sm-6 portfolio-item">
	            <div class="card h-80">
	                <a href="#"><img class="card-img-top" src="files/tour/${tr.hinhtour}" alt="${tr.hinhtour}"></a>
	                <div class="card-body">
	                    <h5 class="card-title">
	                        <a href="#">${tr.tentour}</a>
	                    </h5>
	                    <p style="font-size: 13px;" class="card-text">${tr.diemdi} <i class="fa fa-long-arrow-right"></i> ${tr.tinhthanh.tinhthanh}</p>
	                    <h5 style="color: green;"><i class="fa fa-money"></i> 2.000.000 VNĐ</h5>
	                </div>
	            </div>
	        </div>
    	</c:forEach>
    </div>
    <hr>


</div>
<!-- /.container -->
