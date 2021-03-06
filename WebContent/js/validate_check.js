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
	
	
	// ------------- Phản hồi	---------------------
	// -------------------------------------------------------
	$("#khphanhoi").validate({
		rules : {
			hoten : 'required',
			email :{ 
				required:true,
				email: true
			},
			noidung : 'required'
		},
		messages : {
			hoten : 'Vui lòng nhập họ tên',
			email :{ 
				required:'Vui lòng nhập email',
				email: 'Định dạng email sai'
			},
			noidung: 'Vui lòng nhập nội phản hồi'
		
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
	
	// ------------- Kiểm tra form tạo khách sạn -----------------
	// -------------------------------------------------------
	$("#taokhachsan_form").validate({
		rules : {
			tenkhachsan : {
				required : true,
				minlength : 5
			},
			sodienthoai : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			idtinhthanh : {
				required : true
			},
			diachi : {
				required : true,
				minlength : 10
			},
			hinhanh : {
				required : true
			}
		},
		messages : {
			tenkhachsan : {
				required : 'Vui lòng nhập tên khách sạn',
				minlength : 'Vui lòng nhập ít nhất 5 ký tự'
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Vui lòng chỉ nhập số',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			idtinhthanh : {
				required : 'Vui lòng chọn một tỉnh thành'
			},
			diachi : {
				required : 'Vui lòng nhập địa chỉ',
				minlength : 'Địa chỉ ít nhât 10 ký tự'
			},
			hinhanh : {
				required : 'Vui lòng chọn hình ảnh'
			}
		}
	});
	
	// ------------- Kiểm tra form thông tin khách sạn -----------------
	// -------------------------------------------------------
	$("#ttks_form").validate({
		rules : {
			tenkhachsan : {
				required : true,
				minlength : 5
			},
			sodienthoai : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			diachi : {
				required : true,
				minlength : 10
			}
		},
		messages : {
			tenkhachsan : {
				required : 'Vui lòng nhập tên khách sạn',
				minlength : 'Vui lòng nhập ít nhất 5 ký tự'
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Vui lòng chỉ nhập số',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			diachi : {
				required : 'Vui lòng nhập địa chỉ',
				minlength : 'Địa chỉ ít nhât 10 ký tự'
			}
		}
	});
	
	// ------------- Kiểm tra form thông tin công ty -----------------
	// -------------------------------------------------------
	$("#ttct_form").validate({
		rules : {
			tencongty : {
				required : true,
				minlength : 5
			},
			sodienthoai : {
				required : true,
				number : true,
				rangelength : [ 10, 11 ]
			},
			diachi : {
				required : true,
				minlength : 10
			}
		},
		messages : {
			tencongty : {
				required : 'Vui lòng nhập tên công ty',
				minlength : 'Vui lòng nhập ít nhất 5 ký tự'
			},
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại',
				number : 'Vui lòng chỉ nhập số',
				rangelength : 'Số điện thoại phải từ 10 đến 11 số'
			},
			diachi : {
				required : 'Vui lòng nhập địa chỉ',
				minlength : 'Địa chỉ ít nhât 10 ký tự'
			}
		}
	});
	
//	// ------------- Kiểm tra form sửa tour -----------------
//	// -------------------------------------------------------
//	$("#suatour").validate({
//		rules : {
//			tentour : {
//				required : true,
//				minlength : 10
//			},
//			diemdi : {
//				required : true
//			},
//			diemden : {
//				required : true
//			},
//			ngaykhoihanh : {
//				required : true
//			},
//			gia : {
//				required : true,
//				number : true,
//				min : 500000,
//				max : 9999999
//			},
//			lichtrinh : {
//				required : true
//			}
//		},
//		messages : {
//			tentour : {
//				required : 'Vui lòng nhập tên tour',
//				minlength : 'Vui lòng nhập ít nhất 10 ký tự'
//			},
//			diemdi : {
//				required : 'Vui lòng chọn một điểm đi'
//			},
//			diemden : {
//				required : 'Vui lòng chọn một điểm đến'
//			},
//			ngaykhoihanh : {
//				required : 'Vui lòng nhập thời gian khởi hành'
//			},
//			gia : {
//				required : 'Vui lòng nhập giá',
//				number : 'Vui lòng chỉ nhập số',
//				min : 'Vui lòng nhập ít nhất 500,000 VNĐ',
//				max : 'Vui lòng nhập nhiều nhất 9,999,999 VNĐ'
//			},
//			lichtrinh : {
//				required : 'Vui lòng nhập lịch trình'
//			}
//		}
//	});
//	
//	// ------------- Kiểm tra form th tour -----------------
//	// -------------------------------------------------------
//	$("#suatour").validate({
//		rules : {
//			tentour : {
//				required : true,
//				minlength : 10
//			},
//			diemdi : {
//				required : true
//			},
//			diemden : {
//				required : true
//			},
//			ngaykhoihanh : {
//				required : true
//			},
//			gia : {
//				required : true,
//				number : true,
//				min : 500000,
//				max : 9999999
//			},
//			lichtrinh : {
//				required : true
//			}
//		},
//		messages : {
//			tentour : {
//				required : 'Vui lòng nhập tên tour',
//				minlength : 'Vui lòng nhập ít nhất 10 ký tự'
//			},
//			diemdi : {
//				required : 'Vui lòng chọn một điểm đi'
//			},
//			diemden : {
//				required : 'Vui lòng chọn một điểm đến'
//			},
//			ngaykhoihanh : {
//				required : 'Vui lòng nhập thời gian khởi hành'
//			},
//			gia : {
//				required : 'Vui lòng nhập giá',
//				number : 'Vui lòng chỉ nhập số',
//				min : 'Vui lòng nhập ít nhất 500,000 VNĐ',
//				max : 'Vui lòng nhập nhiều nhất 9,999,999 VNĐ'
//			},
//			lichtrinh : {
//				required : 'Vui lòng nhập lịch trình'
//			}
//		}
//	});

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
