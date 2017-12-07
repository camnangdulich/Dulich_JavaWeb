/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// -------------------------------------- Admin_Alert_Check -------------------------------------------------
// ----------------------------------------------------------------------------------------------------------

function alert_admin_check(message) {
//==================================Thêm=========================================
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
	
	//Thêm loại bài viết
	if (message == 'them lbv thanh cong') {
		swal({
			title : "Thêm thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ten loai da ton tai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Tên loại bài viết đã tồn tại, bạn vui lòng sử dụng một tên loại bài viết khác!",
			showConfirmButton : true
		});
	} else if (message == 'them lbv that bai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Thêm thất bại!",
			showConfirmButton : true
		});
	}
	
	
	//Thêm  tour
	if (message == 'them tour thanh cong') {
		swal({
			title : "Thêm thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ten tour da ton tai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Tên  tour đã tồn tại, bạn vui lòng sử dụng một tên khác!",
			showConfirmButton : true
		});
	} else if (message == 'them tour that bai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Thêm thất bại!",
			showConfirmButton : true
		});
	}
	
	
	//Thêm  dịch vụ
	if (message == 'them dich vu thanh cong') {
		swal({
			title : "Thêm thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'dich vu da ton tai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Tên dịch vụ đã tồn tại, bạn vui lòng sử dụng một tên khác!",
			showConfirmButton : true
		});
	} else if (message == 'them dich vu that  bai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Thêm thất bại!",
			showConfirmButton : true
		});
	}
	
	//Thêm  công ty
	if (message == 'them cong ty thanh cong') {
		swal({
			title : "Thêm thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'cong ty da ton tai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Tên công ty  đã tồn tại, bạn vui lòng sử dụng một tên khác!",
			showConfirmButton : true
		});
	} else if (message == 'them cong ty that bai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Thêm thất bại!",
			showConfirmButton : true
		});
	}
	
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
	
	// Kiểm tra ttks sửa dịch vụ
	if (message == 'ttks sua dich vu thanh cong') {
		swal({
			title : "Thêm dịch vụ thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ttks sua dich vu that bai') {
		swal({
			title : "Thêm dịch vụ thất bại!",
			type : "error",
			text : "Thêm dịch vụ thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra ttks sửa loại phòng
	if (message == 'ttks sua loai phong thanh cong') {
		swal({
			title : "Thêm loại phòng thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ttks sua loai phong that bai') {
		swal({
			title : "Thêm loại phòng thất bại!",
			type : "error",
			text : "Thêm loại phòng thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra sửa thông tin khách sạn
	if (message == 'ttks sua thanh cong') {
		swal({
			title : "Sửa thông tin khách sạn thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ttks sua thanh cong') {
		swal({
			title : "Sửa thông tin khách sạn thất bại!",
			type : "error",
			text : "Sửa thông tin khách sạn thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra sửa thông tin công ty
	if (message == 'ttct sua thanh cong') {
		swal({
			title : "Sửa thông tin công ty thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ttct sua that bai') {
		swal({
			title : "Sửa thông tin công ty thất bại!",
			type : "error",
			text : "Sửa thông tin công ty thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra sửa thông tin tour du lịch
	if (message == 'sua tour thanh cong') {
		swal({
			title : "Sửa thông tin tour thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'sua tour that bai') {
		swal({
			title : "Sửa thông tin tour thất bại!",
			type : "error",
			text : "Sửa thông tin tour thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra thêm bài viết
	if (message == 'them bai viet thanh cong') {
		swal({
			title : "Thêm bài viết thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'them bai viet that bai') {
		swal({
			title : "Thêm bài viết thất bại!",
			type : "error",
			text : "Thêm bài viết thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra sửa bài viết
	if (message == 'sua bai viet thanh cong') {
		swal({
			title : "Sửa bài viết thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'sua bai viet that bai') {
		swal({
			title : "Sửa bài viết thất bại!",
			type : "error",
			text : "Sửa bài viết thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra sửa loai bài viết
	if (message == 'sua loai bai viet thanh cong') {
		swal({
			title : "Sửa loại bài viết thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'sua loai bai viet that bai') {
		swal({
			title : "Sửa loại bài viết thất bại!",
			type : "error",
			text : "Sửa loại bài viết thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
	// Kiểm tra sửa tài khoản
	if (message == 'chinh sua tai khoan thanh cong') {
		swal({
			title : "Sửa tài khoản thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'chinh sua tai khoan that bai') {
		swal({
			title : "Sửa tài khoản thất bại!",
			type : "error",
			text : "Sửa tài khoản thất bại, vui lòng kiểm tra lại!",
			showConfirmButton : true
		});
	}
	
		
	
	
};



//================================DELETE=============================
//================================DELETE=============================
//================================DELETE=============================
//================================DELETE=============================


//Kiểm tra Xóa thông tin loại bài viết
function kiemtraxoaloaibaiviet(idloaibaiviet, tenloaibaiviet) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin của loại bài viết " + tenloaibaiviet
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
			swal("Xóa loại bài viết!", "Loại bài viết này và các thông tin liên quan đến loại bài viết " + tenloaibaiviet
					+ " sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xloaibv/" + idloaibaiviet + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};


//Kiểm tra Xóa thông tin dịch vụ
function kiemtraxoadichvu(idloaidichvu, tenloaidichvu) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin của dịch vụ " + tenloaidichvu
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
			swal("Xóa dịch vụ này!", "Dịch vụ này và các thông tin liên quan đến dịch vụ " + tenloaidichvu
					+ " sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xdichvu/" + idloaidichvu + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};


//Kiểm tra Xóa thông tin tour
function kiemtraxoatour(idtour, tentour) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin " + tentour
				+ " đã dặt đều sẽ bị xóa hết!",
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
			swal("Xóa đặt Tour!", "Tour và các thông tin liên quan đến" + tentour
					+ " đã đặt sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xdattour/" + idtour + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};



//===================Kiểm tra xóa tour===============
function kiemtraxoat(idloaitour, tenloaitour) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin của tour " + tenloaitour
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
			swal("Xóa Tour!", "Tour và các thông tin liên quan đến tour " + tenloaitour
					+ " sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xoatour/" + idloaitour + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};



//===================Kiểm tra xóa Tin tức===============
function kiemtraxoatintuc(idtintuc, tieudetintuc) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin của bài viết " + tieudetintuc
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
			swal("Xóa bài viết!", "Bài viết này và các thông tin liên quan đến bài viết " + tieudetintuc
					+ " sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xtintuc/" + idtintuc + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};


//===================KIỂM TRA XÓA ĐẶT PHÒNG===============
function kiemtraxoadatphong(iddatphong, Tenphongdat) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, thông tin của đơn đặt phòng này sẽ bị xóa!",
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
			swal("Xóa thông tin đặt phòng", "Đơn đặt phòng và các thông tin liên quan đến đơn đặt phòng này sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xoadatphong/" + iddatphong + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};



//===================KIỂM TRA XÓA ĐẶT TOUR===============
function kiemtraxoadattour(iddattour, tentour) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, thông tin của đơn đặt tour này sẽ bị xóa!",
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
			swal("Xóa thông tin đặt tour", "Đơn đặt tour và các thông tin liên quan đến đơn đặt tour này sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xdattour/" + iddattour + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};




//===================KIỂM TRA XÓA CHI TIẾT DỊCH VỤ===============
function kiemtraxoactdv(idchitietdv, tenctdichvu) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả thông tin dịch vụ đều sẽ bị xóa hết!",
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
			swal("Xóa dịch vụ", "Các thông tin dịch vụ sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xchitietdv/" + idchitietdv + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};


//===================KIỂM TRA XÓA CHI TIẾT LOẠI PHÒNG===============
function kiemtraxoalp(idchitietlp) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, thông tin loại phòng của khách sạn này sẽ bị xóa!",
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
			swal("Xóa loại phòng", "Thông tin loại phòng này của khách sạn sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xchitietlp/" + idchitietlp + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};


//===================KIỂM TRA XÓA CHI TIẾT LOẠI PHÒNG===============
function kiemtraxoadanhgia(iddanhgia, tenkhachsan) {
	swal({
		title : "Bạn chắc chắn muốn xóa?",
		text : "Nếu bạn xóa, tất cả dánh giá về khách sạn "+tenkhachsan+" đều sẽ bị xóa hết!",
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
			swal("Xóa đánh giá", "Các thông tin đánh giá khách sạn "+tenkhachsan+" sẽ bị xóa...", "success");
			setTimeout(function() {
				window.location = "admin/xoadanhgia/" + iddanhgia + ".html"; // Sửa đường dẫn xóa
			}, 1500);
		}
	});
};


//Xác nhân đơn đặt phòng
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

//Xác nhân đơn đặt tour
function xacnhandondattour(iddondattour, tennguoidattour, emaildattour) {
	swal({
		title : "Xác nhận đơn đặt tour!",
		text : "Xác nhận đơn đặt tour của " + tennguoidattour
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
			swal("Xác nhận đơn!", "Đơn đặt tour của " + tennguoidattour
					+ " sẽ được kích hoạt...", "success");
			setTimeout(function() {
				window.location = "admin/xnddt/" + iddondattour + "/" + emaildattour + ".html";
			}, 1500);
		}
	});
};

//Xác nhận khách sạn
function xacnhankhachsan(idkhachsan, tenkhachsan) {
	swal({
		title : "Xác nhận khách sạn!",
		text : "Xác nhận khách sạn " + tenkhachsan
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
			swal("Xác nhận khách sạn!", "Khách sạn " + tenkhachsan + " sẽ được kích hoạt...", "success");
			setTimeout(function() {
				window.location = "admin/xnks/" + idkhachsan +".html";
			}, 1500);
		}
	});
};

//Khóa khách sạn
function khoakhachsan(idkhachsan, tenkhachsan) {
	swal({
		title : "Khóa khách sạn!",
		text : "Khóa khách sạn " + tenkhachsan
				+ " và gửi mail thông báo!",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "red",
		confirmButtonText : "Khóa!",
		cancelButtonText : "Hủy bỏ!",
		closeOnConfirm : false,
		closeOnCancel : true,
		showLoaderOnConfirm : true
	}, function(isConfirm) {
		if (isConfirm) {
			swal("Khóa khách sạn!", "Khách sạn " + tenkhachsan
					+ " sẽ bị khóa...", "success");
			setTimeout(function() {
				window.location = "admin/blockks/" + idkhachsan +".html";
			}, 1500);
		}
	});
};

//Kiểm tra Xóa thông tin tài khoản
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


