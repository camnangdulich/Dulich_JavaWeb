/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {

	// ------------- Kiểm form thêm quyền --------------------
	// -------------------------------------------------------
	$("#themquyen").validate({
		rules : {
			tenquyen : 'required'
		},
		messages : {
			tenquyen : 'Vui lòng nhập tên quyền'
		}
	});

	// ------------- Kiểm form sửa quyền ---------------------
	// -------------------------------------------------------
	$("#squyen").validate({
		rules : {
			tenquyen : 'required'
		},
		messages : {
			tenquyen : 'Vui lòng nhập tên quyền'
		}
	});
	
	// ------------- Kiểm thêm loại phòng ---------------------
	// -------------------------------------------------------
	$("#themlp").validate({
		rules : {
			tenloai : 'required',
			gia : {
				required : true,
				digits : true
			},
			themgiuong : {
				digits : true
			}

		},
		messages : {
			tenloai : 'Vui lòng nhập tên loại phòng',
			gia : {
				required : 'Vui lòng nhập giá loại phòng',
				digits : 'Giá phải là sô',
			},
			themgiuong : {
				digits : 'Phải là số'
			}
		}
	});
	
	// ------------- Kiểm sửa loại phòng ---------------------
	// -------------------------------------------------------
	$("#sualp").validate({
		rules : {
			tenloai : 'required',
			gia : {
				required : true,
				digits : true
			},
			themgiuong : {
				digits : true
			}
		},
		messages : {
			tenloai : 'vui lòng nhập tên loại phòng',
			gia : {
				required : 'Vui lòng nhập giá loại phòng',
				digits : 'Giá phải là sô'
			},
			themgiuong : {
				digits : 'Phải là số'
			}
		}
	});
	// ------------- Kiểm thêm dịch vụ---------------------
	// -------------------------------------------------------
	$("#tdichvu").validate({
		rules : {
			tendichvu : 'required'
		},
		messages : {
			tendichvu : 'Không được để trống'
		}
	});
	
	// ------------- Kiểm sửa dịch vụ---------------------
	// -------------------------------------------------------
	$("#sdichvu").validate({
		rules : {
			tendichvu : 'required'
		},
		messages : {
			tendichvu : 'Không được để trống'
		}
	});
	
	// ------------- Kiểm thêm tỉnh thành---------------------
	// -------------------------------------------------------
	$("#themtinh").validate({
		rules : {
			tentinh : 'required'
		},
		messages : {
			tentinh : 'Không được để trống'
		}
	});
	
	// ------------- Kiểm sửa tỉnh thành---------------------
	// -------------------------------------------------------
	$("#suatt").validate({
		rules : {
			tentinh : 'required'
		},
		messages : {
			tentinh : 'Không được để trống'
		}
	});
	
	// ------------- Kiểm thêm loại bài viết---------------------
	// -------------------------------------------------------
	$("#themlbv").validate({
		rules : {
			tenloaibv : 'required'
		},
		messages : {
			tenloaibv : 'Không được để trống'
		}
	});
	
	// ------------- Kiểm sửa loại bài viết---------------------
	// -------------------------------------------------------
	$("#sualbv").validate({
		rules : {
			tenloai : 'required'
		},
		messages : {
			tenloai : 'Không được để trống'
		}
	});
	// ------------- Kiểm thêm công ty---------------------
	// -------------------------------------------------------
	$("#themcongty").validate({
		rules : {
			taikhoan : 'required',
			tencongty: 'required',
			diachi: 'required',
			email :{
				required : true,
				email : true
			},
			sodienthoai : {
				required : true,
				digits : true,
				rangelength : [ 10, 11 ]
			}
		},
		messages : {
			taikhoan : 'Vui lòng chọn quyền bạn muốn thêm',
			tencongty: 'Tên công ty không được để trống',
			diachi: 'Vui lòng nhập địa chỉ',
			email :{
				required : 'Vui lòng nhập email',
				email : 'Định dạng email không hợp lệ'
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				digits : 'Phải là số',
				rangelength : 'Số điện thoại phải 10 or 11 ký tự'
			}
		}
	});
	// ------------- Kiểm sửa công ty---------------------
	// -------------------------------------------------------
	$("#suacongty").validate({
		rules : {
			taikhoan : 'required',
			tencongty: 'required',
			diachi: 'required',
			email :{
				required : true,
				email : true
			},
			sodienthoai : {
				required : true,
				digits : true,
				rangelength : [ 10, 11 ]
			}
		},
		messages : {
			taikhoan : 'Vui lòng chọn quyền bạn muốn thêm',
			tencongty: 'Tên công ty không được để trống',
			diachi: 'Vui lòng nhập địa chỉ',
			email :{
				required : 'Vui lòng nhập email',
				email : 'Định dạng email không hợp lệ'
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				digits : 'Phải là số',
				rangelength : 'Số điện thoại phải 10 or 11 ký tự'
			}
		}
	});
	
	
});
