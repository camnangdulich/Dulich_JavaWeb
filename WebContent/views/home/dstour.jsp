<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="home/trang-chu.html">Trang chủ</a>
        </li>
        <li class="breadcrumb-item active">Danh sách tour</li>
    </ol>
    <hr>
    <div class="row">
	    <c:forEach var="tur" items="${tourds}">
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
     <!-- Pagination -->
	<ul class="pagination justify-content-center mb-4">
		<c:if test="${currentpage > 1 }">
			<li class="page-item">
				<a class="page-link" href="home/danh-sach-tin-tuc/2.html?page=${currentpage - 1}">&larr; Trước</a>
			</li>
		</c:if>

		<c:forEach begin="1" end="${pagecount }" varStatus="status">
			<c:choose>
				<c:when test="${status.index == currentpage }">
					<li class="page-item active">
						<a class="page-link">${status.index }
							<span class="sr-only">(current)</span>
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="admin/taikhoands.htm?page=${status.index }">${status.index }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${currentpage < pagecount }">
			<li>
				<li class="page-item">
					<a class="page-link" href="home/danh-sach-tin-tuc/2.html?page=${currentpage + 1}">Tiếp &rarr;</a>
				</li>
			</li>
		</c:if>
	</ul>
    <hr>

</div>