<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="admin/dieu-khien.html">Điều khiển</a>
        </li>
        <li class="breadcrumb-item">
        	<a href="admin/thong-tin-khach-san.html">Thông tin khách sạn</a>
		</li>
        <li class="breadcrumb-item active">Sửa loại phòng</li>
    </ol>
    <div class="container">
	    <div class="row">
	    	<div class="col-md-4">
		    	<div class="card mb-3">
		    		<div class="card-header">
			            <i class="fa fa-table"></i> Bảng loại phòng
			        </div>
		    		<form action="admin/thong-tin-khach-san/sua-loai-phong.html" method="post" style="padding-left: 20px; padding-top: 20px;">
                    	<input name="idks" type="hidden" value="${loguserks.idkhachsan}">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                 <c:forEach var="a" items="${loaiphonglst}">
	                                <div class="form-check form-check-inline">
									  	<label class="custom-control custom-checkbox form-check-label">
									        <input name="loaiphong" type="checkbox" class="custom-control-input" value="${a.idloaiphong}">
										  	<span class="custom-control-indicator"></span>
										  	<span class="custom-control-description">${a.tenloai}</span>
										</label>
									</div><br>
								 </c:forEach>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12 offset-md-3">
                                <button type="submit" class="btn btn-primary">Thêm loại phòng</button>
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
	    	<div class="col-md-8">
	    	    <!-- Example DataTables Card-->
			    <div class="card mb-3">
			        <div class="card-header">
			            <i class="fa fa-table"></i> Bảng loại phòng trong khách sạn</div>
			        <div class="card-body">
			            <div class="table-responsive">
			                <table class="table table-bordered" id="dataTable">
			                    <thead>
			                        <tr>
			                        	<th style="width: 20px;">ID</th>
			                            <th>Tên loại phòng</th>
			                            <th style="width: 10px;"><i class="fa fa-cog"></i></th>
			                        </tr>
			                    </thead>
			                    <tfoot>
			                        <tr>
			                        	<th>ID</th>
			                            <th>Tên loại phòng</th>
			                            <th></th>
			                        </tr>
			                    </tfoot>
			                    <tbody>
			                    	<c:forEach var="a" items="${ctlplist}">
			                    		<c:if test="${a.khachsan.idkhachsan == loguserks.idkhachsan}" >
		                            		<tr>
		                            			<td>${a.idchitietloaiphong}</td>
		                                   	 	<td>${a.loaiphong.tenloai}</td>
			                                	<td>
					                                <a style="color: red; cursor: pointer;" 
					                                onclick="kiemtraxoalp('${a.idchitietloaiphong}')">
					                                	<i class="fa fa-times" title="Xóa chi tiết loại phòng"></i>
					                                </a>
												</td>
		                            		</tr>
		                             	</c:if>
		                            </c:forEach>
			                    </tbody>
			                </table>
			            </div>
			        </div>
			        <%
			            DateFormat dateFormat = new SimpleDateFormat("HH:mm a - dd/MM/yyyy ");
			            Date date = new Date();
			        %>
			        <div class="card-footer small text-muted">Cập nhật lúc <%= dateFormat.format(date)%></div>
			    </div>
	    	</div>
	    </div>
    </div>
</div>
<!-- /.container-fluid-->