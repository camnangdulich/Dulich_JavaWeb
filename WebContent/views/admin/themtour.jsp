<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Điều khiển</a></li>
		<li class="breadcrumb-item active">Thêm tour</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-10 col-md-auto">
					<form action="admin/themtour.html" method="post"
						enctype="multipart/form-data" id="themtour">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Hình ảnh</label>
							<div class="col-sm-10" id="label-validation">
								<label class="custom-file" style="display: none;"> <input
									name="hinhanh" id="my_file" type="file"
									class="custom-file-input" onchange="onFileSelected(event)">
								</label> <a onclick="document.getElementById('my_file').click();"
									style="cursor: pointer;"> <img id="myimage"
									src="files/tour/tour1.jpg"
									style="max-width: 120px; max-height: 120px;">
								</a>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Tên tour</label>
							<div class="col-sm-10" id="label-validation">
								<input name="tentour" type="text" class="form-control"
									placeholder="Tên tour">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Công ty</label>
							<div class="col-sm-10" id="label-validation">
								<select name="congty" class="form-control">
									<option selected="selected" disabled>--Chọn công ty--</option>
									<c:forEach var="ct" items="${ctlist}">
										<option value="${ct.idcongty}">${ct.tencongty}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Điểm đi</label>
							<div class="col-sm-10" id="label-validation">
								<select name="diemdi" class="form-control">
									<option selected="selected" disabled>--Chọn tỉnh
										thành--</option>
									<c:forEach var="tt" items="${ttlist}">
										<option value="${tt.idtinhthanh}">${tt.tinhthanh}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Điểm đến</label>
							<div class="col-sm-10" id="label-validation">
								<select name="diemden" class="form-control">
									<option selected="selected" disabled>--Chọn tỉnh
										thành--</option>
									<c:forEach var="tt" items="${ttlist}">
										<option value="${tt.idtinhthanh}">${tt.tinhthanh}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Ngay khởi hành</label>
							<div class="col-sm-10" id="label-validation">
								<input name="ngaykhoihanh" type="text" class="form-control"
									placeholder="Ngày khởi hành">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Lịch trình</label>
							<div class="col-sm-10" id="label-validation">
								<input name="lichtrinh" type="text" class="form-control"
									placeholder="Lịch trình">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Giá</label>
							<div class="col-sm-10" id="label-validation">
								<input name="gia" type="text" class="form-control"
									placeholder="Giá">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Lưu ý</label>
							<div class="col-sm-10" id="label-validation">
								<input name="luuy" type="text" class="form-control"
									placeholder="Lưu ý">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Mô tả</label>
							<div class="col-sm-10" id="label-validation">
								<input name="mota" type="text" class="form-control"
									placeholder="Mô tả tour">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10 offset-md-3">
								<button type="submit" class="btn btn-primary">Thêm tour</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>