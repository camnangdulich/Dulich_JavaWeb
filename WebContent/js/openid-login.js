/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// -------------------------------------- Facebook - Login --------------------------------------------------
// ----------------------------------------------------------------------------------------------------------

// Mở Đăng Nhập Bằng Facebook
window.fbAsyncInit = function () {
    //SDK loaded, initialize it
    FB.init({
        appId: '299207463899707',
        xfbml: true,
        version: 'v2.2'
    });

    //check user session and refresh it
    FB.getLoginStatus(function (response) {
        if (response.status === 'connected') {
            //user is authorized
        } else if (response.status === 'not_authorized') {
            // the user is logged in to Facebook,
            // but has not authenticated your app
        } else {
            // the user isn't logged in to Facebook.
        }
    });
};

//load the JavaScript SDK
(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.com/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

document.getElementById('btn-facebook').addEventListener('click', function () {
    //do the login
    FB.login(function (response) {
        if (response.authResponse) {
            //user just authorized your app
            var accessToken = response.authResponse.accessToken;
            
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "home/signin-facebook.html",
                data: accessToken,
                success: function (result) {
                    location.reload();
                },
                error: function (e) {
                    alert("Lỗi ! Đăng Nhập Facebook");
                }
            });

        }
    }, {scope: 'email,public_profile', return_scopes: true});
}, false);
// Đóng Đăng Nhập Bằng Facebook

// Mở Đăng Xuất Bằng Facebook
function logoutFacebook() {
    FB.logout(function (response) {
    });
};
// Đóng Đăng Xuất Bằng Facebook








//-------------------------------------- Google - Login ----------------------------------------------------
//----------------------------------------------------------------------------------------------------------

// Mở Đăng Nhập Bằng Google
var googleUser = {};
var startApp = function () {
    gapi.load('auth2', function () {
        auth2 = gapi.auth2.init({
            client_id: '988534781661-a1ikie8ng4g7mapq54gphs97jehv4jg3.apps.googleusercontent.com',
            cookiepolicy: 'single_host_origin',
        });
        attachSignin(document.getElementById('btn-google'));
    });
};

function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function (googleUser) {
            var id_token = googleUser.getAuthResponse().id_token;
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "home/signin-google.html",
                data: id_token,
                success: function (result) {
                    location.reload();
                },
                error: function (e) {
                    alert("Lỗi ! Đăng Nhập Google");
                }
            });
        }, function (error) {
            //alert(JSON.stringify(error, undefined, 2)+"ĐÓng Của Sổ");
        });
}
startApp();
// Đóng Đăng Nhập Bằng Google


// Mở Đăng Xuất Bằng Google
function signOut() {
    firstLogin = 0;
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
    });
}
// ĐÓng Đăng Xuất Bằng Google
