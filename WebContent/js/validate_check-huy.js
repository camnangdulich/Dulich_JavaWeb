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

	// ------------- Kiểm tra nhập thêm tour---------------------
	// -------------------------------------------------------
	$("#themtour").validate({
		rules : {
			congty : 'required',
			diemdi : 'required',
			diemden : 'required',
			tentour : 'required',
			ngaykhoihanh : 'required',
			lichtrinh : 'required',
			gia : {
				required : true,
				digits : true
			}
		},
		messages : {
			congty : 'Vui lòng chọn công ty',
			diemdi : 'Vui lòng chọn điểm đi',
			diemden : 'Vui lòng chọn điểm đến',
			tentour : 'Tên tour không được để trống',
			ngaykhoihanh : 'Ngày khởi hành không được để trống',
			lichtrinh : 'Vui lòng nhập lịch trình',
			gia : {
				required : 'Vui lòng nhập giá ',
				digits : 'Giá phải là sô'
			}
		}
	});
	
	
	
	// ------------- Kiểm tra nhập sưa tour---------------------
	// -------------------------------------------------------
	$("#suatour").validate({
		rules : {
			tentour : 'required',
			ngaykhoihanh : 'required',
			lichtrinh : 'required',
			gia : {
				required : true,
				digits : true
			}
		},
		messages : {
			tentour : 'Tên tour không được để trống',
			ngaykhoihanh : 'Ngày khởi hành không được để trống',
			lichtrinh : 'Vui lòng nhập lịch trình',
			gia : {
				required : 'Vui lòng nhập giá ',
				digits : 'Giá phải là sô'
			}
		}
	});
	
	// ------------- Kiểm tra nhập thêm công ty	---------------------
	// -------------------------------------------------------
	$("#themcongty").validate({
		rules : {
			tencongty : 'required',
			diachi : 'required',
			sodienthoai : {
				required : true,
				digits : true,
				rangelength : [ 10, 11 ]
			}
		},
		messages : {
			tencongty : 'Vui long nhập tên công ty',
			diachi : 'Vui lòng nhập địa chỉ',
			sodienthoai : {
				required : 'Vui lòng nhập số điện thoại ',
				digits : 'Phải là số',
				rangelength : "Số điện thoại phải gồm 10 hoặc 11 số"
					
			}
		}
	});
	

});
