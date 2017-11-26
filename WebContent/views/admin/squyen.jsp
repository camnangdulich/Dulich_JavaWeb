<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Điều khiển</a></li>
		<li class="breadcrumb-item active">Sửa Quyền</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-10 col-md-auto">
					<form action="admin/squyen.html" method="post" id="squyen">
						<input name="idquyen" type="hidden" value="${role.idquyen}">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Quyền</label>
							<div class="col-sm-10" id="label-validation">
								<input name="tenquyen" type="text" class="form-control" placeholder="Nhập tên quyền" value="${role.quyen }">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Mô tả</label>
							<div class="col-sm-10" id="label-validation">
								<input name="mota" type="text" class="form-control"
									placeholder="Mô tả quyền" value="${role.mota }">
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