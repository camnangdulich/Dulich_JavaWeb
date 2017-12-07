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
