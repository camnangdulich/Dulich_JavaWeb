<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="home/trang-chu.html">Trang chủ</a>
        </li>
        <li class="breadcrumb-item active">Danh sách khách sạn</li>
    </ol>
    <hr>
    <div class="row">
    	<c:forEach var="ks" items="${khachsands}">
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
		                    <c:forEach var="dg" items="${dgks}">
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