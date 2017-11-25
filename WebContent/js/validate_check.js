/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
	
	// ------------- Kiểm form Slug tool ---------------------
	// -------------------------------------------------------
	$("#slugtoolform").validate({
		rules : {
			tukhoa : 'required'
		},
		messages : {
			tukhoa : 'Vui lòng nhập từ khóa cần chuyển đồi'
		}
	});
	

	// ------------- Kiểm tra form thêm tài khoản ------------
	// -------------------------------------------------------
	$("#ttaikhoan").validate({
		rules : {
			quyen : 'required',
			email : {
				required : true,
				email : true,
				
			},
			matkhau : {
				required : true,
				minlength : 5
			},
			rematkhau : {
				required : true,
				minlength : 5,
				equalTo : "#matkhau"
			},
			sdt : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			}
		},
		
		messages : {
			quyen : 'Vui lòng chọn một quyền',
			email : {
				required : 'Vui lòng nhập email',
				email : 'Email chưa đúng định dạng'
			},
			matkhau : {
				required : 'Vui lòng nhập mật khẩu',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự'
			},
			rematkhau : {
				required : 'Vui lòng nhập mật khẩu',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự',
				equalTo : 'Mật khẩu không trùng'
			},
			sdt : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Số điện thoại không được chứa chữ',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			}
		}
	});
	

	// ------------- Kiểm tra form đăng nhập -----------------
	// -------------------------------------------------------
	$("#login_form").validate({
		rules : {
			login_email : {
				required : true,
				email : true
			},
			login_password : {
				required : true,
				minlength : 5
			}
		},
		messages : {
			login_email : {
				required : 'Vui lòng nhập email',
				email : 'Email chưa đúng định dạng'
			},
			login_password : {
				required : 'Vui lòng nhập mật khẩu',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự'
			}
		}
	});
	

	// ------------- Kiểm tra form đăng ký -------------------
	// -------------------------------------------------------
	$("#register_form").validate({
		rules : {
			reg_email : {
				required : true,
				email : true
			},
			reg_matkhau : {
				required : true,
				minlength : 5
			},
			reg_sdt : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			reg_checkbox : 'required'
		},
		messages : {
			reg_email : {
				required : 'Vui lòng nhập email',
				email : 'Email chưa đúng định dạng'
			},
			reg_matkhau : {
				required : 'Vui lòng nhập mật khẩu',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự'
			},
			reg_sdt : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Số điện thoại không được chứa chữ',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			reg_checkbox: '	'
		}
	});
	
	
	// ------------- Kiểm form lấy lại mật khẩu --------------
	// -------------------------------------------------------
	$("#repass_form").validate({
		rules : {
			email : {
				required : true,
				email : true
			}
		},
		messages : {
			email : {
				required : 'Vui lòng nhập email',
				email : 'Email chưa đúng định dạng'
			}
		}
	});
	
	
	// ------------- Kiểm form thêm quyền --------------------
	// -------------------------------------------------------
	$("#themquyen").validate({
		rules : {
			tenquyen : 'required'
		},
		messages : {
			tenquyen : 'Vui lòng nhập tên quyền'
		}
	})
	

	// ------------- Kiểm form sửa quyền ---------------------
	// -------------------------------------------------------
		$("#squyen").validate({
		rules : {
			tenquyen : 'required'
		},
		messages : {
			tenquyen : 'Vui lòng nhập tên quyền'
		}
	})
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
				digits: true
			}
			
		},
		messages : {
			tenloai : 'Vui lòng nhập tên loại phòng',
			gia : {
				required : 'Vui lòng nhập giá loại phòng',
				digits : 'Giá phải là sô',
			},
			themgiuong : {
				digits: 'Phải là số'
			}
		}
	})
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
				digits: true
			}
		},
		messages : {
			tenloai : 'vui lòng nhập tên loại phòng',
			gia : {
				required : 'Vui lòng nhập giá loại phòng',
				digits : 'Giá phải là sô'
			},
			themgiuong : {
				digits: 'Phải là số'
			}
		}
	})
});




