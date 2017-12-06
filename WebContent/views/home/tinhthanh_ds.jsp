<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Page Content -->
<div class="container">

    <div class="tinhthanh" style="margin-top: 35px;">
        <div class="container-fluid bg-3 text-center">    
            <div class="row">
            	<c:forEach var="tth" items="${tinhthanhds}">
	            	<div class="col-sm-3 ih-item square effect13 top_to_bottom" style="width: 100%; height: 100%; padding: 0;">
	                    <a href="home/tinh-thanh/${tth.slug}.html">
	                        <div class="img">
	                        	<img src="files/tinhthanh/${tth.hinhanh}" class="img-responsive" style="width:100%" alt="${tth.tinhthanh}">
	                        	<div class="card-footer sp-ttm">${tth.tinhthanh}</div>
	                        </div>
	                        <div class="info">
	                            <h3>${tth.tinhthanh}</h3>
	                            <p>${tth.mota}</p>
	                        </div>
	                    </a>
	                </div>
            	</c:forEach>
            </div>
            <!-- Pagination -->
			<ul class="pagination justify-content-center mb-4" style="margin-top: 25px;">
				<c:if test="${currentpage > 1 }">
					<li class="page-item">
						<a class="page-link" href="home/tinh-thanh/danh-sach.html?page=${currentpage - 1}">&larr; Trước</a>
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
								<a class="page-link" href="home/tinh-thanh/danh-sach.html?page=${status.index }">${status.index }</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${currentpage < pagecount }">
					<li>
						<li class="page-item">
							<a class="page-link" href="home/tinh-thanh/danh-sach.html?page=${currentpage + 1}">Tiếp &rarr;</a>
						</li>
					</li>
				</c:if>
			</ul>
        </div>
    </div>
    <hr>


</div>
<!-- /.container -->
