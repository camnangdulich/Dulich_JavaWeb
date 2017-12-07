/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Kiểm tra trùng email form đăng ký tài khoản
function kiemtrathongtinkhachsansuadichvu() {
	var varemail = $('#dichvu').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/kt-iddv-ajax.html",
		data : varemail,
		success : function(result) {
			if (result == "true") {
				document.getElementById("suadvttks_form").setAttribute("onsubmit", "return false;");
				$('#tbtrungdv').css('display', 'block');
				$('#tbtrungdv').text("Dịch vụ đã có, vui lòng chọn dịch vụ khác");
			} else {
				document.getElementById("suadvttks_form").setAttribute("onsubmit", "return true;");
				$('#tbtrungdv').css('display', 'none');
			}
		},
		error : function(e) {
			alert("Lỗi ! Kiểm tra dịch vụ");
		}
	});
}

//Kiểm tra trùng tên bài viết form bài viết
function kiemtratieudebaiviet() {
	var varemail = $('#tieude').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/kt-tdbv-ajax.html",
		data : varemail,
		success : function(result) {
			if (result == "true") {
				document.getElementById("thembaiviet").setAttribute("onsubmit", "return false;");
				$('#tbtrungtd').css('display', 'block');
				$('#tbtrungtd').text("Tiêu đề này đã có, vui lòng sử dụng tiêu đề khác");
			} else {
				document.getElementById("thembaiviet").setAttribute("onsubmit", "return true;");
				$('#tbtrungtd').css('display', 'none');
			}
		},
		error : function(e) {
			alert("Lỗi ! Kiểm tra bài viết");
		}
	});
}
