<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="admin/dieu-khien.html">Điều khiển</a></li>
		<li class="breadcrumb-item"><a href="admin/danh-sach-tour-du-lich.html">Danh sách tour du lịch</a></li>
		<li class="breadcrumb-item active">Sửa tour du lịch</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-10 col-md-auto">
					<form action="admin/sutour.html" method="post"
						enctype="multipart/form-data" id="suatour">
						<input name="idtour" type="hidden" value="${tua.idtour}">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Hình ảnh</label>
							<div class="col-sm-10">
								<label class="custom-file" style="display: none;"> <input
									name="hinhanh" id="my_file" type="file"
									class="custom-file-input" onchange="onFileSelected(event)">
								</label> <a onclick="document.getElementById('my_file').click();"
									style="cursor: pointer;"> <img id="myimage"
									src="files/tour/${tua.hinhtour}"
									style="max-width: 120px; max-height: 120px;">
								</a>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Tên tour</label>
							<div class="col-sm-10" id="label-validation">
								<input name="tentour" type="text" class="form-control"
									value="${tua.tentour}" placeholder="Nhập tên tour">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Mô tả</label>
							<div class="col-sm-10" id="label-validation">
								<input name="mota" type="text" class="form-control"
									value="${tua.mota}" placeholder="Nhập mô tả tour">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Điểm đi</label>
							<div class="col-sm-10" id="label-validation">
								<select name="diemdi" class="form-control">
									<option selected="selected" hidden="">${tua.diemdi}</option>
									<c:forEach var="tt" items="${ttlist}">
										<option value="${tt.tinhthanh}">${tt.tinhthanh}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Điểm đến</label>
							<div class="col-sm-10" id= "label-validation">
								<select name="diemden" class="form-control">
									<option hidden="" selected="selected" value="${tua.tinhthanh.idtinhthanh}">${tua.tinhthanh.tinhthanh}</option>
									<c:forEach var="tt" items="${ttlist}">
										<option value="${tt.idtinhthanh}">${tt.tinhthanh}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Khởi hành</label>
							<div class="col-sm-10" id="label-validation">
								<input name="ngaykhoihanh" type="text" class="form-control"
									value="${tua.thoigiankhoihanh}" placeholder="Nhập thời gian khởi hành">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Giá</label>
							<div class="col-sm-10" id="label-validation">
								<input name="gia" type="text" class="form-control"
									value="${tua.gia }" placeholder="Nhập giá tour">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Lưu ý</label>
                            <div class="col-sm-10">
                                <div id="sample">
                                    <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script>
                                    <script type="text/javascript">
                                        bkLib.onDomLoaded(function () {
                                            nicEditors.allTextAreas()
                                        });
                                    </script>
                                    <textarea name="luuy" style="width: 100%; height: 100px;" placeholder="Nhập lịch trình tour">
                                    	${tua.luuy}
                                    </textarea>
                                </div>
                            </div>
                        </div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Lịch trình</label>
                            <div class="col-sm-10">
                                <div id="sample">
                                    <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script>
                                    <script type="text/javascript">
                                        bkLib.onDomLoaded(function () {
                                            nicEditors.allTextAreas()
                                        });
                                    </script>
                                    <textarea name="lichtrinh" style="width: 100%; height: 500px;">
                                    	${tua.lichtrinh }
                                    </textarea>
                                </div>
                            </div>
                        </div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10 offset-md-3">
								<button type="submit" class="btn btn-primary">Sửa tour</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>