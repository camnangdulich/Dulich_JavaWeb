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
            <a href="admin/index.html">Điều khiển</a>
        </li>
        <li class="breadcrumb-item active">Danh sách loại tin</li>
    </ol>
    <div class="container">
	    <div class="row">
	    	<div class="col-md-4">
		    	<div class="card mb-3">
		    		<div class="card-header">
			            <i class="fa fa-table"></i> Bảng dữ liệu loại tin
			        </div>
		    		<form action="" method="post" style="padding-left: 20px; padding-top: 20px;">
                    	<input name="idtk" type="hidden" value="1">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                 <c:forEach var="a" items="${lbvlist}">
                                 	<c:choose>
									    <c:when test="${a.idloaitin == 1}">
									    </c:when>
									    <c:otherwise>
			                                <div class="form-check form-check-inline">
											  	<label class="custom-control custom-checkbox form-check-label">
											        <input name="loaitin" type="checkbox" class="custom-control-input" value="${a.idloaitin}">
												  	<span class="custom-control-indicator"></span>
												  	<span class="custom-control-description">${a.loaitin}</span>
												</label>
											</div><br>
									   </c:otherwise>
									</c:choose>
								 </c:forEach>
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
	    	<div class="col-md-8">
	    	    <!-- Example DataTables Card-->
			    <div class="card mb-3">
			        <div class="card-header">
			            <i class="fa fa-table"></i> Bảng dữ liệu loại tin</div>
			        <div class="card-body">
			            <div class="table-responsive">
			                <table class="table table-bordered" id="dataTable">
			                    <thead>
			                        <tr>
			                            <th>Mô tả</th>
			                            <th style="width: 50px;"><i class="fa fa-cog"></i></th>
			                        </tr>
			                    </thead>
			                    <tfoot>
			                        <tr>
			                            <th>Mô tả</th>
			                            <th></th>
			                        </tr>
			                    </tfoot>
			                    <tbody>
			                        <c:forEach var="q" items="${loaitinbv}">
			                            <tr>
			                                <td>${q.loaitin.loaitin}</td>
			                                <td>
			                                	<a href="#" style="padding-right: 5px;">
				                                	<i class="fa fa-pencil" title="Sửa quyền"></i> 
				                                </a>
				                                <a id="xoataikhoan" style="color: red; cursor: pointer;" onclick="kiemtraxoataikhoan('1',2)">
				                                	<i class="fa fa-times" title="Xóa quyền"></i>
				                                </a>
											</td>
			                            </tr>
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