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
	//Kiểm tra sửa quyền
	if (message == 'sua quyen thanh cong') {
		swal({
			title : "Sửa quyền thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'quyen da ton tai') {
		swal({
			title : "Sửa quyền thất bại!",
			type : "error",
			text : "Tên quyền đã tồn tại, bạn vui lòng sử dụng một tên quyền khác!",
			showConfirmButton : true
		});
	} else if (message == 'sua quyen that bai') {
		swal({
			title : "Sửa quyền thất bại!",
			type : "error",
			text : "Sửa quyền thất bại!",
			showConfirmButton : true
		});
	}
	//Kiểm tra loại bài viết
	if (message == 'them loai bai viet thanh cong') {
		swal({
			title : "Thêm loại bài thành công!",
			type : "success",
			timer : 1500,
			showConfirmButton : false
		});
	} else if (message == 'ten loai da ton tai') {
		swal({
			title : "Thêm thất bại!",
			type : "error",
			text : "Tên loại bài viết đã tồn tại, bạn vui lòng sử dụng một tên khác!",
			showConfirmButton : true
		});
	} else if (message == 'them loai bai that bai') {
		swal({
			title : "Thêm loại bài thất bại!",
			type : "error",
			text : "Thêm loại bài thất bại!",
			showConfirmButton : true
		});
	}
	
	// Do something
	// ...
	
};
