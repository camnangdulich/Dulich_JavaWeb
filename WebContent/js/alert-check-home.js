/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// -------------------------------------- Modal-Form --------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------
// Open Login form
function loginpp() {
	document.getElementById('register_pp').style.display = 'none';
	document.getElementById('login_pp').style.display = 'block';
	document.getElementById('repwd_pp').style.display = 'none';
	document.getElementById('taokhachsan_pp').style.display = 'none';
};

// Open register form
function registerpp() {
	document.getElementById('register_pp').style.display = 'block';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'none';
	document.getElementById('taokhachsan_pp').style.display = 'none';
};

// Open repass form
function repasspp() {
	document.getElementById('register_pp').style.display = 'none';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'block';
	document.getElementById('taokhachsan_pp').style.display = 'none';
};

//Open Tạo khách sạn form
function taokhachsanpp() {
	document.getElementById('register_pp').style.display = 'none';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'none';
	document.getElementById('taokhachsan_pp').style.display = 'block';
};

// Close form
function closepp() {
	document.getElementById('register_pp').style.display = 'none';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'none';
	document.getElementById('taokhachsan_pp').style.display = 'none';
};

// Get the modal
var modal_login = document.getElementById('login_pp');
var modal_register = document.getElementById('register_pp');
var modal_repwd = document.getElementById('repwd_pp');
var modal_taokhachsan = document.getElementById('taokhachsan_pp');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal_login) {
		modal_login.style.display = "none";
	}
	if (event.target == modal_register) {
		modal_register.style.display = "none";
	}
	if (event.target == modal_repwd) {
		modal_repwd.style.display = "none";
	}
	if (event.target == modal_taokhachsan) {
		modal_taokhachsan.style.display = "none";
	}
}

// -------------------------------------- Home_Alert_Check --------------------------------------------------
// ----------------------------------------------------------------------------------------------------------

// Đăng xuất
function dangxuat() {
	swal({
		title : "Đăng xuất hệ thống?",
		text : "Chọn đăng xuất để đăng xuất khỏi hệ thống hoặc hủy để kết thúc thao tác",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "Đăng xuất!",
		cancelButtonText : "Hủy!",
		closeOnConfirm : false,
		closeOnCancel : true,
		showLoaderOnConfirm : true
	}, function(isConfirm) {
		if (isConfirm) {
			swal("Đăng xuất", "Đang đăng xuất khỏi hệ thống...", "success");
			setTimeout(function() {
				window.location = "home/dangxuat.html";
			}, 1500);
		}
	});
};

function alert_home_check(message) {
	
	// Kiểm tra đăng nhập
	if (message == 'dang nhap thanh cong') {
		swal({
			title : "Đăng nhập thành công!",
			text : "Chờ xử lý đăng nhập...",
			type : "success",
			timer : 2000,
			showConfirmButton : false
		});
	} else if (message == 'dang nhap that bai') {
		swal({
			title : "Đăng nhập thất bại!",
			type : "error",
			text : "Email hoặc mật khẩu không chính xác\n<a onclick='loginpp()'><button autofocus >Đăng nhập lại!</button></a>",
			html : true,
			showConfirmButton : false
		});
	} else if (message == 'tai khoan chua kich hoat') {
		swal({
			title : "Đăng nhập thất bại!",
			type : "error",
			text : "Tài khoản của bạn chưa được kích hoạt!",
			showConfirmButton : true
		});
	} else if (message == 'tai khoan bi khoa') {
		swal({
			title : "Đăng nhập thất bại!",
			type : "error",
			text : "Tài khoản của bạn đã bị khóa!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra đăng ký
	if (message == 'dang ky thanh cong') {
		swal({
			title : "Đăng ký thành công!",
			type : "success",
			text : "Vui lòng kiểm tra email để xác minh tài khoản!",
			showConfirmButton : true
		});
	} else if (message == 'dang ky email ton tai') {
		swal({
			title : "Đăng ký thất bại!",
			type : "error",
			text : "Email đã tồn tại, bạn vui lòng sử dụng một email khác!",
			showConfirmButton : true
		});
	} else if (message == 'dang ky that bai') {
		swal({
			title : "Đăng ký thất bại!",
			type : "error",
			text : "Đăng ký tài khoản thất bại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra lấy lại mật khẩu
	if (message == 'repass mail thanh cong') {
		swal({
			title : "Gửi lại mật khẩu thành công!",
			type : "success",
			text : "Vui lòng kiểm tra email để đặt lại mật khẩu mới!",
			showConfirmButton : true
		});
	} else if (message == 'repass mail khong ton tai') {
		swal({
			title : "Gửi lại mật khẩu thất bại!",
			type : "error",
			text : "Email này không tồn tại, vui lòng kiểm tra lại email!",
			showConfirmButton : true
		});
	} else if (message == 'repass mail that bai') {
		swal({
			title : "Gửi lại mật khẩu thất bại!",
			type : "error",
			text : "Lỗi gửi lại mật khẩu, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra đặt lại mật khẩu
	if (message == 'dat lai mat khau thanh cong') {
		swal({
			title : "Thay đổi mật khẩu thành công!",
			type : "success",
			text : "<a onclick='loginpp()'><button autofocus >Đăng nhập ngay!</button></a>",
			html : true,
			showConfirmButton : false
		});
	} else if (message == 'dat lai mat khau that bai') {
		swal({
			title : "Thay đổi mật khẩu thất bại!",
			type : "error",
			text : "Lỗi đặt lại mật khẩu, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra đánh giá khách sạn
	if (message == 'danh gia thanh cong') {
		swal({
			title : "Đánh giá thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'danh gia that bai') {
		swal({
			title : "Đánh giá thất bại!",
			type : "error",
			text : "Đánh giá thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra đặt tour
	if (message == 'dat tour thanh cong') {
		swal({
			title : "Đặt tour thành công!",
			type : "success",
			text : "Chúng tôi sẽ gửi mail thông báo nếu đơn đặt tour của bạn được xác nhận \n Bạn vui lòng kiểm tra email trong thời gian này!",
			showConfirmButton : true
		});
	} else if (message == 'dat tour that bai') {
		swal({
			title : "Đặt tour thất bại!",
			type : "error",
			text : "Đặt tour thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra đặt phòng
	if (message == 'dat phong thanh cong') {
		swal({
			title : "Đặt phòng thành công!",
			type : "success",
			text : "Chúng tôi sẽ gửi mail thông báo nếu đơn đặt phòng của bạn được xác nhận \n Bạn vui lòng kiểm tra email trong thời gian này!",
			showConfirmButton : true
		});
	} else if (message == 'dat phong that bai') {
		swal({
			title : "Đặt phòng thất bại!",
			type : "error",
			text : "Đặt phòng thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra cập nhật tài khoản
	if (message == 'cap nhat tai khoan thanh cong') {
		swal({
			title : "Cập nhật tài khoản thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'cap nhat tai khoan that bai') {
		swal({
			title : "Cập nhật tài khoản thất bại!",
			type : "error",
			text : "Cập nhật tài khoản thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra tạo khách sạn
	if (message == 'tao khach san thanh cong') {
		swal({
			title : "Tạo khách sạn thành công!",
			type : "success",
			text : "Chúng tôi sẽ gửi mail thông báo nếu khách sạn của bạn được xác nhận \n Bạn vui lòng kiểm tra email trong thời gian này!",
			showConfirmButton : true
		});
	} else if (message == 'tao khach san that bai') {
		swal({
			title : "Tạo khách sạn thất bại!",
			type : "error",
			text : "Tạo khách sạn thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	} else if (message == 'khach san da tao cho xac minh') {
		swal({
			title : "Tạo khách sạn thất bại!",
			type : "error",
			text : "Bạn không thể tạo thêm khách sạn bởi vì tài khoản này đã đăng ký một khách sạn trước đó," +
					" bạn vui lòng chờ xác nhận khách sạn hoặc liên hệ với người quản trị",
			showConfirmButton : true
		});
	}
	
	// Do something
	// ...
	
};

// -------------------------------------- Delete_Alert_Check ------------------------------------------------
// ----------------------------------------------------------------------------------------------------------

// Kiểm tra Xóa thông tin tài khoản
function kiemtraxoataikhoan(idtaikhoan, email) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin của tài khoản " + email
				+ " đều sẽ bị xóa hết!",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "Xóa bỏ!",
		cancelButtonText : "Hủy bỏ!",
		closeOnConfirm : false,
		closeOnCancel : true,
		showLoaderOnConfirm : true
	}, function(isConfirm) {
		if (isConfirm) {
			swal("Xóa tài khoản!", "Tài khoản và các thông tin của " + email
					+ " sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xtaikhoan/" + idtaikhoan + ".html";
			}, 1500);
		}
	});
};

// Kiểm tra Xóa thông tin khách sạn
function kiemtraxoakhachsan() {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin của khách sạn sẽ bị xóa",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "Xóa bỏ!",
		cancelButtonText : "Hủy bỏ!",
		closeOnConfirm : false,
		closeOnCancel : true,
		showLoaderOnConfirm : true
	}, function(isConfirm) {
		if (isConfirm) {
			swal("Xóa khách sạn!",
					"Khách sạn và các thông tin của bạn sẽ bị xóa...",
					"success");
			setTimeout(function() {
				window.location = "admin/xkhachsan.html";
			}, 1500);
		}
	});
};

// Kiểm tra Xóa thông tin đánh giá khách sạn
function kiemtraxoadanhgiakhachsan(iddanhgia) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Đánh giá này của bạn sẽ bị xóa khỏi khách sạn này",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "Xóa bỏ!",
		cancelButtonText : "Hủy bỏ!",
		closeOnConfirm : false,
		closeOnCancel : true,
		showLoaderOnConfirm : true
	}, function(isConfirm) {
		if (isConfirm) {
			swal("Xóa đánh giá!", "Đánh giá này của bạn sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "home/xdgks/"+iddanhgia+".html";
			}, 1500);
		}
	});
};

// Xác nhân đơn đặt phòng
function xacnhandondatphong(iddongdatphong, tennguoidatphong, emaildatphong) {
	swal({
		title : "Xác nhận đơn đặt phòng!",
		text : "Xác nhận đơn đặt phòng của " + tennguoidatphong
				+ " và gửi mail thông báo!",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#5cb85c",
		confirmButtonText : "Xác nhận!",
		cancelButtonText : "Hủy bỏ!",
		closeOnConfirm : false,
		closeOnCancel : true,
		showLoaderOnConfirm : true
	}, function(isConfirm) {
		if (isConfirm) {
			swal("Xác nhận đơn!", "Đơn đặt phòng của " + tennguoidatphong
					+ " sẽ được kích hoạt...", "success");
			setTimeout(function() {
				window.location = "admin/xnddp/" + iddongdatphong + "/" + emaildatphong + ".html";
			}, 1500);
		}
	});
};
