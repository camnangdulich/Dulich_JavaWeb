<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <!-- Breadcrumbs -->
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li class="breadcrumb-item">
            <a href="home/trang-chu.html">Trang chủ</a>
        </li>
        <li class="breadcrumb-item active">Tin tức</li>
        <li class="breadcrumb-item active">Tin mới</li>
    </ol>

    <div class="row">
        <!-- Blog Entries Column -->
        <div class="col-md-8">
			<div class="row">
				<c:forEach var="dst" items="${dslt}">
					<div class="col-md-6">
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

			<!-- Pagination -->
			<ul class="pagination justify-content-center mb-4">
				<c:if test="${currentpage > 1 }">
					<li class="page-item">
						<a class="page-link" href="home/tin-tuc/tin-moi.html?page=${currentpage - 1}">&larr; Trước</a>
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
								<a class="page-link" href="home/tin-tuc/tin-moi.html?page=${status.index }">${status.index }</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${currentpage < pagecount }">
					<li>
						<li class="page-item">
							<a class="page-link" href="home/tin-tuc/tin-moi.html?page=${currentpage + 1}">Tiếp &rarr;</a>
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
                	<a href="home/tin-tuc/tin-moi.html" class="list-group-item">Tin mới</a>
                	<a href="home/tin-tuc/tin-xem-nhieu.html" class="list-group-item">Tin xem nhiều</a>
                	<c:forEach var="dmtt" items="${loaitinlst}">
                		<c:choose>
				        	<c:when test="${dmtt.idloaitin == idloaitin}">
				        		<a href="home/tin-tuc/${dmtt.slug}.html" class="list-group-item active">${dmtt.loaitin}</a>
				        	</c:when>
				        	<c:otherwise>
				        		<a href="home/tin-tuc/${dmtt.slug}.html" class="list-group-item">${dmtt.loaitin}</a>
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
	                        <a href="home/tin-tuc/bai-viet/${ttm.slug}.html"><img style="border-radius: inherit;" class="card-img-top" src="files/tintuc/${ttm.hinhanh}" alt="${ttm.hinhanh}"></a>
	                        <div class="card-body">
	                            <a href="home/tin-tuc/bai-viet/${ttm.slug}.html"><h6 class="card-title">${ttm.tieude}</h6></a>
	                            <div class="card-footer text-muted sp-ttm">
									<i class="fa fa-fw fa-clock-o ft-lh"></i> ${ttm.thoigian}
								</div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
                <ul class="pagination justify-content-center mb-4">
                    <li class="page-item">
                        <a class="page-link" href="home/tin-tuc/tin-moi.html">Xem thêm &rarr;</a>
                    </li>
                </ul>
            </div>

            <!-- Tin xem nhiều nhất -->
            <div class="card my-4">
                <h5 class="card-header">Xem nhiều nhất</h5>
                <div class="card-body">
                    <c:forEach var="ttm" items="${lstsibarttxn}">
	                	<div class="card mb-4">
	                        <a href="home/tin-tuc/bai-viet/${ttm.slug}.html"><img style="border-radius: inherit;" class="card-img-top" src="files/tintuc/${ttm.hinhanh}" alt="${ttm.hinhanh}"></a>
	                        <div class="card-body">
	                            <a href="home/tin-tuc/bai-viet/${ttm.slug}.html"><h6 class="card-title">${ttm.tieude}</h6></a>
	                            <div class="card-footer text-muted sp-ttm">
									<i class="fa fa-fw fa-eye ft-lh"></i> ${ttm.luotxem} lượt xem
								</div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
                <ul class="pagination justify-content-center mb-4">
                    <li class="page-item">
                        <a class="page-link" href="home/tin-tuc/tin-xem-nhieu.html">Xem thêm &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>