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
	
});
