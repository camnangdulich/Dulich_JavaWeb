<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Điều khiển</a></li>
		<li class="breadcrumb-item active">Sửa bài viết</li>
	</ol>
	<!-- Icon Cards-->
	<div class="row">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-12 col-md-auto">
					<form action="admin/sbaiviet.html" method="post"
						enctype="multipart/form-data" id="suabaiviet">
						<input name="idbv" type="hidden" value="1">
						<div class="form-group row">
							<div class="col-sm-12">
								<label class="custom-file" style="display: none;"> <input
									name="hinhanh" id="my_file" type="file"
									class="custom-file-input" onchange="onFileSelected(event)">
								</label> <a onclick="document.getElementById('my_file').click();"
									style="cursor: pointer;"> <img id="myimage"
									src="files/tintuc/${sbv.hinhanh }" style="max-height: 120px;">
								</a>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12" id="label-validation">
								<input name="tieude" type="text" class="form-control"
									placeholder="Nhập tiêu đề" value = "${sbv.tieude }">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12" id="label-validation">
								<input name="tomtat" type="text" class="form-control"
									placeholder="Nhập tóm tắt" value = "${sbv.tomtat}">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12" id="label-validation">
								<input name="nguon" type="text" class="form-control"
									placeholder="Nhập nguồn" value="${sbv.nguon }">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12" id="label-validation">
								<div id="sample">
									<textarea name="noidung" style="width: 100%; height: 500px;" 
									value = "${sbv.noidung }">
                                    </textarea>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12 offset-md-3">
								<button type="submit" class="btn btn-primary">Sửa bài viết</button>
							</div>
						</div>
					</form>
					<script type="text/javascript">
                       	// Các input thay đổi thì mới được submit
                        $('form')
                        .each(function(){
                            $(this).data('serialized', $(this).serialize())
                        })
                        .on('change input', function(){
                            $(this)             
                                .find('input:submit, button:submit')
                                    .prop('disabled', $(this).serialize() == $(this).data('serialized'))
                            ;
                         })
                        .find('input:submit, button:submit')
                            .prop('disabled', true);
                    </script>
				</div>
			</div>
		</div>
	</div>
</div>