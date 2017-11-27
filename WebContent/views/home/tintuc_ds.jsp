<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Tin tức</li>
        <c:forEach var="tlt" items="${loaitinlst}">
        	<c:choose>
	        	<c:when test="${tlt.idloaitin == idloaitin}">
	        		<li class="breadcrumb-item active">${tlt.loaitin}</li>
	        	</c:when>
	        </c:choose>
        </c:forEach>
    </ol>

    <div class="row">
        <!-- Blog Entries Column -->
        <div class="col-md-8">
			<div class="row">
				<c:forEach var="dst" items="${dslt}">
					<div class="col-md-6">
						<!-- Blog Post -->
						<div class="card mb-4">
							<a href="#"><img class="card-img-top" src="files/tintuc/${dst.tintuc.hinhanh}" alt="Card image cap"></a>
							<div class="card-body">
								<a href="#"><h5 class="card-title rgtd">${dst.tintuc.tieude}</h5></a>
								<p class="card-text p-fx">${dst.tintuc.tomtat}</p>
							</div>
							<div class="card-footer text-muted sp-ttm">
								Đăng lúc ${dst.tintuc.thoigian} <a href="#">${dst.tintuc.taikhoan.ten}</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		   	<script type="text/javascript">
				$(".p-fx").shorten({
				    "showChars" : 100,
				    "moreText"  : "...",
				    "lessText"  : "",
				});
				$(".rgtd").shorten({
				    "showChars" : 60,
				    "moreText"  : "",
				    "lessText"  : "",
				});
			</script>

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