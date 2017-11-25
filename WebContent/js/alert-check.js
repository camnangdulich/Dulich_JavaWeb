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
};

// Open register form
function registerpp() {
	document.getElementById('register_pp').style.display = 'block';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'none';
};

// Open repass form
function repasspp() {
	document.getElementById('register_pp').style.display = 'none';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'block';
};

// Close form
function closepp() {
	document.getElementById('register_pp').style.display = 'none';
	document.getElementById('login_pp').style.display = 'none';
	document.getElementById('repwd_pp').style.display = 'none';
};

// Get the modal
var modal_login = document.getElementById('login_pp');
var modal_register = document.getElementById('register_pp');
var modal_repwd = document.getElementById('repwd_pp');

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
	
	// Do something
	// ...
	
};

// -------------------------------------- Admin_Alert_Check -------------------------------------------------
// ----------------------------------------------------------------------------------------------------------

function alert_admin_check(message) {

	// Kiểm tra thêm tài khoản
	if (message == 'them tai khoan thanh cong') {
		swal({
			title : "Thêm tài khoản thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'email ton tai') {
		swal({
			title : "Thêm tài khoản thất bại!",
			type : "error",
			text : "Email đã tồn tại, bạn vui lòng sử dụng một email khác!",
			showConfirmButton : true
		});
	} else if (message == 'them tai khoan that bai') {
		swal({
			title : "Thêm tài khoản thất bại!",
			type : "error",
			text : "Thêm tài khoản thất bại!",
			showConfirmButton : true
		});
	}
	
	//Kiểm tra thêm quyền
	if (message == 'them quyen thanh cong') {
		swal({
			title : "Thêm quyền thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'quyen da ton tai') {
		swal({
			title : "Thêm quyền thất bại!",
			type : "error",
			text : "Tên quyền đã tồn tại, bạn vui lòng sử dụng một tên quyền khác!",
			showConfirmButton : true
		});
	} else if (message == 'them quyen that bai') {
		swal({
			title : "Thêm quyền thất bại!",
			type : "error",
			text : "Thêm quyền thất bại!",
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
