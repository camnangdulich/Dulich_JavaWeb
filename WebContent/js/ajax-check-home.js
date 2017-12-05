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

//Kiểm tra trùng số điện thoại form đăng ký tài khoản
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
