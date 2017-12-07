/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Kiểm tra trùng email form đăng ký tài khoản
function kiemtraemailformdangky() {
	var varemail = $('#reg_email').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/kt-email-ajax.html",
		data : varemail,
		success : function(result) {
			if (result == "true") {
				document.getElementById("register_form").setAttribute("onsubmit", "return false;");
				$('#tbtrungemail').css('display', 'block');
				$('#tbtrungemail').text("Email này đã tồn tại, vui lòng sử dụng email khác");
			} else {
				document.getElementById("register_form").setAttribute("onsubmit", "return true;");
				$('#tbtrungemail').css('display', 'none');
			}
		},
		error : function(e) {
			alert("Lỗi ! Kiểm tra email");
		}
	});
}

// Kiểm tra trùng số điện thoại form đăng ký tài khoản
function kiemtrasdtformdangky() {
	var varemail = $('#reg_sdt').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/kt-sdt-ajax.html",
		data : varemail,
		success : function(result) {
			if (result == "true") {
				document.getElementById("register_form").setAttribute("onsubmit", "return false;");
				$('#tbtrungsdt').css('display', 'block');
				$('#tbtrungsdt').text("Số điện thoại này đã được đăng ký");
			} else {
				document.getElementById("register_form").setAttribute("onsubmit", "return true;");
				$('#tbtrungsdt').css('display', 'none');
			}
		},
		error : function(e) {
			alert("Lỗi ! Kiểm tra số điện thoại");
		}
	});
}

// Kiểm tra email form lấy lại mật khẩu
function kiemtraemailformrepass() {
	var varemail = $('#repass_email').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/kt-email-ajax.html",
		data : varemail,
		success : function(result) {
			if (result == "true") {
				document.getElementById("repass_form").setAttribute("onsubmit", "return true;");
				$('#tbemailkoco').css('display', 'none');
			} else {
				document.getElementById("repass_form").setAttribute("onsubmit", "return false;");
				$('#tbemailkoco').css('display', 'block');
				$('#tbemailkoco').text("Email này chưa đăng ký, vui lòng kiểm tra lại!");
			}
		},
		error : function(e) {
			alert("Lỗi ! Kiểm tra số điện thoại");
		}
	});
}

//Kiểm tra tên khách sạn form tạo khách sạn
function kiemtratenkhachsanformtaokhachsan() {
	var varemail = $('#tenkhachsan_taoks').val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/kt-tks-ajax.html",
		data : varemail,
		success : function(result) {
			if (result == "true") {
				document.getElementById("taokhachsan_form").setAttribute("onsubmit", "return false;");
				$('#tbtrungtks').css('display', 'block');
				$('#tbtrungtks').text("Tên khách sạn này đã được sử dụng");
			} else {
				document.getElementById("taokhachsan_form").setAttribute("onsubmit", "return true;");
				$('#tbtrungtks').css('display', 'none');
			}
		},
		error : function(e) {
			alert("Lỗi ! Kiểm tra tên khách sạn");
		}
	});
}