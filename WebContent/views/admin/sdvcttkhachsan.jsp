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
        <li class="breadcrumb-item active">Sửa dịch vụ</li>
    </ol>
    <div class="container">
	    <div class="row">
	    	<div class="col-md-4">
		    	<div class="card mb-3">
		    		<div class="card-header">
			            <i class="fa fa-table"></i> Bảng dịch vụ
			        </div>
		    		<form action="admin/thong-tin-khach-san/sua-dich-vu.html" method="post" 
		    		style="padding-left: 20px; padding-top: 20px;" id="suadvttks_form">
                    	<input name="idks" type="hidden" value="${loguserks.idkhachsan}">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                 <c:forEach var="a" items="${dichvulst}">
	                                <div class="form-check form-check-inline">
									  	<label class="custom-control custom-checkbox form-check-label">
									        <input id="dichvu" name="dichvu" type="checkbox" class="custom-control-input" 
									        value="${a.iddichvu}">
										  	<span class="custom-control-indicator"></span>
										  	<span class="custom-control-description">${a.tendichvu}</span>
										</label>
									</div><br>
								 </c:forEach>
                            </div>
                            <label id="tbtrungdv" class="error" style="display: block; margin-bottom: 0px;"></label>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12 offset-md-3">
                                <button type="submit" class="btn btn-primary">Thêm dịch vụ</button>
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
			            <i class="fa fa-table"></i> Bảng dịch vụ trong khách sạn</div>
			        <div class="card-body">
			            <div class="table-responsive">
			                <table class="table table-bordered" id="dataTable">
			                    <thead>
			                        <tr>
			                        	<th style="width: 20px;">ID</th>
			                            <th>Tên dịch vụ</th>
			                            <th style="width: 10px;"><i class="fa fa-cog"></i></th>
			                        </tr>
			                    </thead>
			                    <tfoot>
			                        <tr>
			                        	<th>ID</th>
			                            <th>Tên dịch vụ</th>
			                            <th></th>
			                        </tr>
			                    </tfoot>
			                    <tbody>
			                    	<c:forEach var="a" items="${ctdvlist}" varStatus="stt">
			                    		<c:if test="${a.khachsan.idkhachsan == loguserks.idkhachsan}" >
		                            		<tr>
		                            			<td>${a.idchitietdichvu}</td>
		                                   	 	<td>${a.dichvu.tendichvu}</td>
			                                	<td>
					                                <a style="color: red; cursor: pointer;" 
					                                onclick="kiemtraxoactdv('${a.idchitietdichvu}')">
					                                	<i class="fa fa-times" title="Xóa loại dịch vụ này"></i>
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