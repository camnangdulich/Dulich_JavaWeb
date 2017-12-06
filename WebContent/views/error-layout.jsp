<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<title>Error page</title>
<link href="css/error_style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!--start-wrap--->
	<div class="wrap">
		<!---start-header---->
		<div class="header">
			<div class="logo">
				<h1>
					<a href="home/trang-chu.html"><img style="width: 130px;" src="files/home/logo.png"></a>
				</h1>
			</div>
		</div>
		<!---End-header---->
		<!--start-content------>
		<div class="content">
			<img src="files/errorpage/error-img.png" title="error" />
			<p>
				<jsp:include page="${param.view}" />
			</p>
			<a href="" onclick="onclick='window.history.go(-1)'">Trở lại trang trước</a>
			<div class="copy-right">
				<p>
					Copyright © Cẩm nang du lịch 2017
				</p>
			</div>
		</div>
		<!--End-Cotent------>
	</div>
	<!--End-wrap--->
</body>
</html>