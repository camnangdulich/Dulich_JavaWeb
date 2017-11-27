<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Điều khiển</a></li>
		<li class="breadcrumb-item active">Thêm tỉnh thành</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-10 col-md-auto">
					<form action="admin/ttinhthanh.html" method="post" id="themtinh"
						enctype="multipart/form-data">
						<div class="form-group row">
                            <label class="col-sm-2 col-form-label">Ảnh </label>
                            <div class="col-sm-10">
                                <label class="custom-file" style="display: none;">
                                    <input name="hinhanh" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)">
                                </label>
                                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
                                	<img id="myimage" src="files/tinhthanh/An Giang.jpg" style="max-width: 120px; max-height: 120px;">
                                </a>
                            </div>
                        </div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Tỉnh thành</label>
							<div class="col-sm-10" id="label-validation">
								<input name="tentinh" type="text" class="form-control"
									placeholder="Nhập tên Tỉnh">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Mô tả</label>
							<div class="col-sm-10" id="label-validation">
								<input name="mota" type="text" class="form-control"
									placeholder="Mô tả Tỉnh">${message}
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10 offset-md-3">
								<button type="submit" class="btn btn-primary">Thêm Tỉnh</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>