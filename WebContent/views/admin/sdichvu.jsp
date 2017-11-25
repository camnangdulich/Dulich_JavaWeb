<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Điều khiển</a></li>
		<li class="breadcrumb-item active">Sửa Dịch vụ</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-10 col-md-auto">
					<form action="admin/sdichvu.html" method="post">
						<input name="iddichvu" type="hidden" value="${di.iddichvu}">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Dịch vụ</label>
							<div class="col-sm-10">
								<input name="tendichvu" type="text" class="form-control" placeholder="Nhập tên " value="${di.tendichvu }">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Mô tả</label>
							<div class="col-sm-10">
								<input name="mota" type="text" class="form-control"
									placeholder="Mô tả dich vụ" value="${di.mota }">${message}
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10 offset-md-3">
								<button type="submit" class="btn btn-primary">Sửa</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>