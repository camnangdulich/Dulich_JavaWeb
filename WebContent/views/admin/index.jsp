<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="admin/dieu-khien.html">Điều khiển</a>
        </li>
    </ol>
    
    
    
    
    <c:choose>
    
    	<c:when test="${loguser.quyen.idquyen == 1}">
			<!-- Icon Cards-->
		    <div class="row">
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-primary o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-user"></i>
		                    </div>
		                    <div class="mr-5">Quản lý tài khoản</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-tai-khoan.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-warning o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-user-circle"></i>
		                    </div>
		                    <div class="mr-5">Quản lý quyền</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-quyen.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-success o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-newspaper-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý bài viết</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-bai-viet.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-danger o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-file-text-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý loại bài viết</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-loai-bai-viet.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-success o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-building"></i>
		                    </div>
		                    <div class="mr-5">Quản lý khách sạn</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-khach-san.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-danger o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-building-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý loại phòng</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-loai-phong.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-warning o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-contao"></i>
		                    </div>
		                    <div class="mr-5">Quản lý công ty</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-cong-ty.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-success o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-user-md"></i>
		                    </div>
		                    <div class="mr-5">Quản lý dịch vụ</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-dich-vu.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		    </div>    	
    	</c:when>
    	
    	<c:when test="${loguser.quyen.idquyen == 2}">
			<!-- Icon Cards-->
		    <div class="row">
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-success o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-newspaper-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý bài viết</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-bai-viet.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-danger o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-file-text-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý loại bài viết</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-loai-bai-viet.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		    </div>    	
    	</c:when>
    	
    	<c:when test="${loguser.quyen.idquyen == 3}">
    	 	<!-- Icon Cards-->
		    <div class="row">
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-warning o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-contao"></i>
		                    </div>
		                    <div class="mr-5">Thông tin công ty</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/thong-tin-cong-ty.html">
		                    <span class="float-left">Xem thông tin công ty</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-warning o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-leaf"></i>
		                    </div>
		                    <div class="mr-5">Quản lý tour du lịch</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-tour-du-lich.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-primary o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-file-text-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý đơn đặt tour</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-don-dat-tour.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		    </div>
    	</c:when>
    	
    	<c:when test="${loguser.quyen.idquyen == 4}">
    		<!-- Icon Cards-->
		    <div class="row">
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-success o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-building"></i>
		                    </div>
		                    <div class="mr-5">Thông tin khách sạn</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/thong-tin-khach-san.html">
		                    <span class="float-left">Xem thông tin khách sạn</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		        <div class="col-xl-3 col-sm-6 mb-3">
		            <div class="card text-white bg-danger o-hidden h-100">
		                <div class="card-body">
		                    <div class="card-body-icon">
		                        <i class="fa fa-fw fa-file-text-o"></i>
		                    </div>
		                    <div class="mr-5">Quản lý đơn đặt phòng</div>
		                </div>
		                <a class="card-footer text-white clearfix small z-1" href="admin/danh-sach-don-dat-phong.html">
		                    <span class="float-left">Tới trang quản lý</span>
		                    <span class="float-right">
		                        <i class="fa fa-angle-right"></i>
		                    </span>
		                </a>
		            </div>
		        </div>
		    </div>
    	</c:when>
    	
    </c:choose>
    
</div>