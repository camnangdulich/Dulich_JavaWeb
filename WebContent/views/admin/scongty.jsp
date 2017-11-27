<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Điều khiển</a></li>
		<li class="breadcrumb-item active">Thêm Quyền</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-10 col-md-auto">
					<form action="admin/scongty.html" method="post"
						enctype="multipart/form-data">
						<input name="idcongty" type="hidden" value="${com.idcongty}">
							<div class="form-group row">
                            <label class="col-sm-2 col-form-label">Tài khoản</label>
                            <div class="col-sm-10" id="label-validation">
                                <select name="taikhoan" class="form-control" >
                                	<option selected="selected" hidden value="${com.taikhoan.idtaikhoan}">${com.taikhoan.email}></option>
                                	<c:forEach var="tk" items="${tailist}">
                                    	<option value="${tk.idtaikhoan}">${tk.email}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Tên công ty</label>
							<div class="col-sm-10">
								<input name="tencongty"  type="text" class="form-control"
									placeholder="Nhập tên công ty" value = "${com.tencongty }">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Địa chỉ</label>
							<div class="col-sm-10">
								<input name="diachi" type="text" class="form-control"
									placeholder="Nhập địa chỉ" value = "${com.diachi }">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Mô tả</label>
							<div class="col-sm-10">
								<input name="mota" type="text" class="form-control"
									placeholder="Mô tả quyền" value = "${com.mota}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
								<input name="email" type="email" class="form-control"
									placeholder="Nhập Email"> <small
									class="form-text text-muted" value ="${com.email }"></small>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Số điện thoại</label>
							<div class="col-sm-10">
								<input name="sodienthoai" type="text" class="form-control"
									placeholder="nhập số điện thoại" value = "${com.sodienthoai }">${message}
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10 offset-md-3">
								<button type="submit" class="btn btn-primary">Sửa Cty</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>