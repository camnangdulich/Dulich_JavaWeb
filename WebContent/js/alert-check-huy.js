/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function alert_home_check(message) {
	
	
	// Do something
	// ...
	
};

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
			text : "Tên loại bài viết đã tồn tại, bạn vui lòng sử dụng một tên loại bài viết khác!",
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
			text : "Tên loại bài viết đã tồn tại, bạn vui lòng sử dụng một tên loại bài viết khác!",
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
			text : "Tên loại bài viết đã tồn tại, bạn vui lòng sử dụng một tên loại bài viết khác!",
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
	
	
	
	//================================DELETE=============================
		
		
	//Kiểm tra Xóa thông tin loại bài viết
	function kiemtraxoaloaibv(idloaitin, loaitin) {
		swal({
			title : "Bạn chắc chắn muốn loại bài viết này không",
			text : "Nếu bạn xóa, tất cả thông tin của loại bài viết " + loaitin
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
				swal("Xóa loại bài viết!", "Tài khoản và các thông tin của " + loaitin
						+ " sẽ bị xóa...", "success");
				setTimeout(function() {
					window.location = "admin/xloaibv/" + idloaitin + ".html";
				}, 1500);
			}
		});
	};
		
		
	
	
};

