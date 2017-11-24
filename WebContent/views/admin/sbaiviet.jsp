<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Sửa bài viết</li>
    </ol>
    <!-- Icon Cards-->
    <div class="row">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-12 col-md-auto">
                    <form action="admin/tbaiviet.html" method="post" enctype="multipart/form-data">
                    	<input name="idtk" type="hidden" value="1">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <label class="custom-file" style="display: none;">
                                    <input name="hinhanh" id="my_file" type="file" class="custom-file-input" onchange="onFileSelected(event)">
                                </label>
                                <a onclick="document.getElementById('my_file').click();" style="cursor: pointer;">
                                	<img id="myimage" src="files/avatar/av1.png" style="max-height: 120px;">
                                </a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                           		<select class="form-control" style="width: 80%; margin-right: 20px; float: left;">
	                               	 <c:forEach var="a" items="${ctbvlist}">
	                               	 	<c:if test="${a.tintuc.idtintuc == baiviet.idtintuc}" >
	                                   	 	<option value="${a.loaitin.loaitin}">${a.loaitin.loaitin}</option>
	                                   	 </c:if>
	                                 </c:forEach>
	                            </select>
                                 <i class="fa fa-pencil"></i><a href="#" style="color: green;"> Chỉnh sửa loại tin</a>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input name="tieude" type="text" class="form-control" placeholder="Nhập tiêu đề">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input name="tomtat" type="text" class="form-control" placeholder="Nhập tóm tắt">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input name="nguon" type="text" class="form-control" placeholder="Nhập nguồn">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <div id="sample">
                                    <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script>
                                    <script type="text/javascript">
                                        bkLib.onDomLoaded(function () {
                                            nicEditors.allTextAreas()
                                        });
                                    </script>
                                    <textarea name="noidung" style="width: 100%; height: 500px;">
                                    </textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12 offset-md-3">
                                <button type="submit" class="btn btn-primary">Thêm bài viết</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>