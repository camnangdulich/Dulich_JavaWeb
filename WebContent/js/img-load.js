/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Image load
function onFileSelected(event) {
	var selectedFile = event.target.files[0];
	var reader = new FileReader();
	var imgtag = document.getElementById("myimage");
	imgtag.title = selectedFile.name;
	reader.onload = function(event) {
		imgtag.src = event.target.result;
	};
	reader.readAsDataURL(selectedFile);
}