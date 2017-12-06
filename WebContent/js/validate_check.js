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
				email : false
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
				email : 'Email chưa đúng định dạng',
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
			reg_rematkhau : {
				required : true,
				minlength : 5,
				equalTo: '#reg_matkhau'
			},
			reg_sdt : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			reg_hodem : {
				required : true
			},
			reg_ten : {
				required : true
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
			reg_rematkhau : {
				required : 'Vui lòng nhập lại mật khẩu',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự',
				equalTo: 'Mật khẩu không trùng khớp'
			},
			reg_sdt : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Số điện thoại không được chứa chữ',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			reg_hodem : {
				required : 'Vui lòng nhập họ đệm'
			},
			reg_ten : {
				required : 'Vui lòng nhập tên'
			},
			reg_checkbox : ''
		}
	});
	
	// ------------- Kiểm tra form đặt lại mật khẩu -----------------
	// -------------------------------------------------------
	$("#datlaimatkhau_form").validate({
		rules : {
			matkhaumoi : {
				required : true,
				minlength : 5
			},
			rematkhaumoi : {
				required : true,
				minlength : 5,
				equalTo : "#matkhaumoi"
			}
		},
		messages : {
			matkhaumoi : {
				required : 'Vui lòng nhập mật khẩu mới',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự'
			},
			rematkhaumoi : {
				required : 'Vui lòng nhập lại mật khẩu',
				minlength : 'Vui lòng nhập ít nhất 5 kí tự',
				equalTo : 'Mật khẩu không trùng khớp'
			}
		}
	});
	
	// ------------- Kiểm tra form đánh giá khách sạn -----------------
	// -------------------------------------------------------
	$("#dgkhachsan_form").validate({
		rules : {
			star : {
				required : true
			},
			noidung : {
				required : true,
				minlength : 10
			}
		},
		messages : {
			star : {
				required : 'Vui lòng chọn một đánh giá'
			},
			noidung : {
				required : 'Vui lòng nhập nội dung bình luận',
				minlength : 'Vui lòng nhập ít nhất 10 kí tự'
			}
		}
	});
	
	// ------------- Kiểm tra form đặt tour -----------------
	// -------------------------------------------------------
	$("#dattour_form").validate({
		rules : {
			hodem : {
				required : true
			},
			ten : {
				required : true
			},
			songuoi : {
				required : true,
				number : true,
				max : 10
			},
			sodienthoai : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			email : {
				required : true,
				email : true
			}
		},
		messages : {
			hodem : {
				required : 'Vui lòng nhập họ đệm'
			},
			ten : {
				required : 'Vui lòng nhập tên'
			},
			songuoi : {
				required : 'Vui lòng nhập số người',
				number : 'Vui lòng nhập số',
				max : 'Số người không được quá 10 người'
					
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Số điện thoại không được chứa chữ',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			email : {
				required : 'Vui lòng nhập email',
				email : 'Email không đúng định dạng'
			}
		}
	});
	
	// ------------- Kiểm tra form đặt phòng -----------------
	// -------------------------------------------------------
	$("#datphong_form").validate({
		rules : {
			ngaynhanphong : {
				required : true
			},
			ngaytraphong : {
				required : true
			},
			soluongphong : {
				required : true,
				number : true,
				max : 10
			},
			hodem : {
				required : true
			},
			ten : {
				required : true
			},
			sodienthoai : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			email : {
				required : true,
				email : true
			},
			chapnhan : {
				required : true
			}
		},
		messages : {
			ngaynhanphong : {
				required : 'Vui lòng chọn ngày nhận phòng'
			},
			ngaytraphong : {
				required : 'Vui lòng chọn ngày trả phòng'
			},
			soluongphong : {
				required : 'Vui lòng nhập số lượng phòng',
				number : 'Vui lòng chỉ nhập số',
				max : 'Bạn có thể đặt tối đa 10 phòng'
			},
			hodem : {
				required : 'Vui lòng nhập họ đệm'
			},
			ten : {
				required : 'Vui lòng nhập tên'
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Số điện thoại không được chứa chữ',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			email : {
				required : 'Vui lòng nhập email',
				email : 'Email không đúng định dạng'
			},
			chapnhan : {
				required : ''
			}
		}
	});
	
	// ------------- Kiểm tra form thông tin tài khoản -----------------
	// -------------------------------------------------------
	$("#tttaikhoan_form").validate({
		rules : {
			matkhau : {
				required : true,
				minlength : 5
			},
			hodem : {
				required : true
			},
			ten : {
				required : true
			}
		},
		messages : {
			matkhau : {
				required : 'Vui lòng nhập mật khẩu',
				minlength : 'Nhập ít nhất 5 ký tự'
			},
			hodem : {
				required : 'Vui lòng nhập họ đệm'
			},
			ten : {
				required : 'Vui lòng nhập tên'
			}
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

});
