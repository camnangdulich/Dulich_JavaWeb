/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import entities.Chitiettin;
import entities.Congty;
import entities.Danhgia;
import entities.Datphong;
import entities.Dattour;
import entities.Dichvu;
import entities.Khachsan;
import entities.Loaiphong;
import entities.Loaitin;
import entities.Phanhoi;
import entities.Quyen;
import entities.Taikhoan;
import entities.Tinhthanh;
import entities.Tintuc;
import entities.Tour;
import entities.Trangthai;
import entities.Chitietdichvu;
import entities.Chitietloaiphong;
import model.EnDeCryption;
import model.Mailer;
import model.RandomString;
import model.SlugsConverter;

/**
 *
 * @author DuongNguyen
 */
@Transactional
@Controller
@RequestMapping("/home/")
public class HomeController {

	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;

	@Autowired
	Mailer mailer;

	// --------------------- Home ModelAttribute ------------------------
	// ------------------------------------------------------------------

	// Lấy thông tin tỉnh thành
	@ModelAttribute("lsttinhthanh")
	public List<Tinhthanh> lsttinhthanh(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql_tth = "from Tinhthanh";//Câu truy vấn lấy thông tin tỉnh thành
		Query query_tth = session.createQuery(hql_tth);//Chạy câu truy vấn
		@SuppressWarnings("unchecked")
		List<Tinhthanh> lsttinhthanh = query_tth.list();//Tạo danh sách tỉnh thành có tên là lsttinhthanh
		return lsttinhthanh;//Trả về danh sách tỉnh thành
	}

	// Lấy thông tin tin tức mới nhất
	@ModelAttribute("lsttintucmoi")
	public List<Tintuc> lsttintucmoi(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 8;//Tạo biến int ttmSize lấy 8 tin mới nhất
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";//Câu truy vấn lấy tin tức mới nhất
		Query query_ttm = session.createQuery(hql_ttm);//Chạy câu truy vấn 
		query_ttm.setMaxResults(ttmSize);//Set giới hạn số lượng tin mới nhất
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttintucmoi = query_ttm.list();//Tạo danh sách tin tức mới nhất có tên là lsttintucmoi
		return lsttintucmoi;//Trả về danh sách các tin tức mới nhất
	}

	// Lấy thông tin tin liên quan
	@ModelAttribute("lsttinlienquan")
	public List<Tintuc> lsttinlienquan(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 5;// Biến kiểu int để lấy số lượng tin liên quan
		//Câu truy vấn lấy tin liên quan theo tin mới nhất
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";
		Query query_ttm = session.createQuery(hql_ttm);// Thực hiện câu truy vấn
		query_ttm.setMaxResults(ttmSize);// Sét giới hạn số lượng tin liên quan
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttinlienquan = query_ttm.list();//Tạo danh sách tin liên quan
		return lsttinlienquan;// Trả về danh sách tin liên quan
	}

	// Lấy thông tin tin tức mới nhất SIBAR
	@ModelAttribute("lstsibarttm")
	public List<Tintuc> lstsibarttm(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 3;//tạo biến in ttmSize = 3 để đổ vào SiBAR
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";//Lấy tin tức mới nhất SIBAR
		Query query_ttm = session.createQuery(hql_ttm);//Thực hiện câu truy vấn
		query_ttm.setMaxResults(ttmSize);// Set giới hạn tin tức mới nhất SIBAR
		@SuppressWarnings("unchecked")
		List<Tintuc> lstsibarttm = query_ttm.list();//Tạo danh sách tin tức mới SIBAR có tên lstsibarttm
		return lstsibarttm;//Trả về danh sách tin tức mới SIBAR
	}

	// Lấy tin tức có lượt xem nhiều nhất
	@ModelAttribute("lsttinxemnhieu")
	public List<Tintuc> lsttinxemnhieu(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttxnSize = 8;// Biến int ttxnSize giới hạn số lượng tin có lượt xem nhiều nhất 
		String hql_ttxn = "from Tintuc tt ORDER BY tt.luotxem DESC";// Câu truy vấn lấy tin tức  có lượt xem nhiều nhất
		Query query_ttxn = session.createQuery(hql_ttxn);// Thực hiện câu truy vấn
		query_ttxn.setMaxResults(ttxnSize);// Set giới hạn tin có lượt xem nhiều nhất
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttinxemnhieu = query_ttxn.list();// Tạ danh sách tin tức được xem nhiều nhất có tên lsttinxemnhieu
		return lsttinxemnhieu;// Trả về danh sách tin tức có lượt xem nhiều nhất 
	}

	// Lấy tin tức có lượt xem nhiều nhất SIBAR
	@ModelAttribute("lstsibarttxn")
	public List<Tintuc> lstsibarttxn(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttxnSize = 3;// Tạo biến có kiểu int giới hạn số lượng tin có nhiều lượt xem SIBAR
		// Câu truy vấn lấy thông tin tin tức có lượt xem nhiều nhất
		String hql_ttxn = "from Tintuc ORDER BY luotxem DESC";
		Query query_ttxn = session.createQuery(hql_ttxn);// Thực hiện câu truy vấn
		query_ttxn.setMaxResults(ttxnSize);// Set giới hạn số tin có lượt xem nhiều nhất
		@SuppressWarnings("unchecked")
		List<Tintuc> lstsibarttxn = query_ttxn.list();// Tạo danh sách tin tức có lượt xem nhiều
		return lstsibarttxn;// Trả về danh sách tin tức có lượt xem nhiều nhất
	}

	// Lấy đánh giá khách sạn có sao nhiều nhất
	@ModelAttribute("lstdanhgiakhachsan")
	public List<Danhgia> lstdanhgiakhachsan(ModelMap model) {
		Session session = factory.getCurrentSession();
		int dgksSize = 8;//biến kiểu int số lượng khách sạn có sao nhiều nhất
		//Câu truy vấn lấy khách sạn có nhiều sao nhất 
		String hql_dgks = "from Danhgia group by idkhachsan having avg(star) >= 3 ORDER BY star DESC";
		Query query_dgks = session.createQuery(hql_dgks);//THực hiện câu truy vấn 
		query_dgks.setMaxResults(dgksSize);// Set sô lượng khách sạn có nhiều sao nhất
		@SuppressWarnings("unchecked")
		List<Danhgia> lstdanhgiakhachsan = query_dgks.list();//Tạo danh sách khách sạn có nhiều sao 
		return lstdanhgiakhachsan;//Trả về danh sách khách sạn có nhiều sao nhất
	}
	
	// Lấy đánh giá khách sạn
	@ModelAttribute("lstdgks")
	public List<Danhgia> lstdgks(ModelMap model) {
		Session session = factory.getCurrentSession();
		int dgksSize = 8;//biến kiểu int số lượng khách sạn có sao nhiều nhất
		//Câu truy vấn lấy khách sạn có nhiều sao nhất 
		String hql_dgks = "from Danhgia group by idkhachsan";
		Query query_dgks = session.createQuery(hql_dgks);//THực hiện câu truy vấn 
		query_dgks.setMaxResults(dgksSize);// Set sô lượng khách sạn có nhiều sao nhất
		@SuppressWarnings("unchecked")
		List<Danhgia> lstdanhgiakhachsan = query_dgks.list();//Tạo danh sách khách sạn có nhiều sao 
		return lstdanhgiakhachsan;//Trả về danh sách khách sạn có nhiều sao nhất
	}

	// Lấy tour có lượt xem nhiều nhất
	@ModelAttribute("lsttournoibat")
	public List<Tour> lsttournoibat(ModelMap model) {
		Session session = factory.getCurrentSession();
		int tourSize = 8;//Tạo biến tourSize kiểu int để lấy 8 tour có lượt xem nhiều
		String hql_tour = "from Tour ORDER BY luotxem DESC";//Câu truy vấn lấy tour có lượt xem nhiều
		Query query_tour = session.createQuery(hql_tour);//Thực hiên câu truy vấn
		query_tour.setMaxResults(tourSize);//Set số lượng tour có lượt xem nhiều nhất
		@SuppressWarnings("unchecked")
		List<Tour> lsttournoibat = query_tour.list();//Tạo danh sách tour có lượt xem nhiều 
		return lsttournoibat;//Trả về danh sách tour có lượt xem nhiều
	}

	// Lấy tour đặc biệt
	@ModelAttribute("lsttourdacbiet")
	public List<Tour> lsttourdacbiet(ModelMap model) {
		Session session = factory.getCurrentSession();
		int tourSize = 6;// Biến kiểu int số lượng tour đặc biệt
		//Câu truy vấn lấy thông tin tour theo lượt xem
		String hql_tour = "from Tour ORDER BY luotxem DESC";
		Query query_tour = session.createQuery(hql_tour);// Thực hiện câu truy vấn
		query_tour.setMaxResults(tourSize);// Set số lượng tour đặc biệt
		@SuppressWarnings("unchecked")
		List<Tour> lsttourdacbiet = query_tour.list();// tạo danh sách tour đặc biệt
		return lsttourdacbiet;// Trả về danh sách tour đặc biệt
	}

	// Lấy tất cả loại tin tức
	@ModelAttribute("loaitinlst")
	public List<Loaitin> loaitinlst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaitin";//Câu truy vấn lấy tất cả thông tin loại tin tức
		Query query = session.createQuery(hql);//Thực hiện câu truy vấn 
		@SuppressWarnings("unchecked")
		List<Loaitin> list = query.list();//Tạo danh sách loại tin tức 
		return list;//Trả về danh sách loại tin tức
	}

	// Lấy tất cả loại phòng
	@ModelAttribute("loaiphonglst")
	public List<Loaiphong> loaiphonglst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaiphong";//Câu truy vấn lấy tất cả thông tin loại phòng
		Query query = session.createQuery(hql);//Thực hiện câu truy vấn
		@SuppressWarnings("unchecked")
		List<Loaiphong> list = query.list();//Tạo danh sách loại phòng
		return list;//Trả về danh sách loại phòng
	}
	
	// Lấy tất cả dịch vụ
	@ModelAttribute("dichvulst")
	public List<Dichvu> dichvulst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Dichvu";//Câu truy vấn lấy tất cả thông tin dịch vụ
		Query query = session.createQuery(hql);//Thực hiện câu truy vấn
		@SuppressWarnings("unchecked")
		List<Dichvu> list = query.list();//Tạo danh sách dịch vụ 
		return list;// Trả về danh sách dịch vụ
	}
	
	// Lấy tất cả tỉnh thành
	@ModelAttribute("tinhthanhlst")
	public List<Tinhthanh> tinhthanhlst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tinhthanh order by tinhthanh";//	Câu truy vấn lấy tỉnh thành
		Query query = session.createQuery(hql);//Thực hiện câu truy vấn
		@SuppressWarnings("unchecked")
		List<Tinhthanh> list = query.list();//Tạo danh sách tỉnh thành 
		return list;//Trả về danh sách tỉnh thành
	}
	
	// Lấy tất cả thông tin chi tiết loại phòng
	@ModelAttribute("ctlplist")
	public List<Chitietloaiphong> getctlp(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Chitietloaiphong";//Lấy thông tin chi tiết loại phòng 
		Query query = session.createQuery(hql);//Thực hiện câu truy vấn
		@SuppressWarnings("unchecked")
		List<Chitietloaiphong> list = query.list();//Tạo danh sách chi tiết loại phòng
		return list;//Trả về danh sách chi tiết loại phòng 
	}
	
	// Lấy tất cả thông tin loại phòng
	@ModelAttribute("loaiplist")
	public List<Loaiphong> getlp(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaiphong";// Câu truy vấn lấy thông tin loại phòng
		Query query = session.createQuery(hql);// Thực hiện câu truy vấn 
		@SuppressWarnings("unchecked")
		List<Loaiphong> list = query.list();// Tạo danh sách Loại phòng có tên list
		return list; // Trả về danh sách loại phòng
	}

	// Lấy tất cả thông tin tour
	@ModelAttribute("tourlist")
	public List<Tour> gett(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tour";// Câu truy vấn lấy thông tin các tour
		Query query = session.createQuery(hql);// Thực hiện câu truy vấn
		@SuppressWarnings("unchecked")
		List<Tour> list = query.list();// Tạo danh sách tour có tên là list
		return list;// Trả vê danh sách tour
	}

	
	
	
	
	
	
	
	
	
	// --------------------- PAGE Controller ----------------------------
	// ------------------------------------------------------------------

	@RequestMapping("trang-chu")
	public String index(ModelMap model) {
		model.addAttribute("title", "Cẩm nang du lịch");
		return "home/index";//Trả về trang chủ 
	}
	
	@RequestMapping("chinh-sach-khach-san")
	public String chinhsachkhachsan(ModelMap model) {
		model.addAttribute("title", "Chính sách khách sạn");
		return "home/chinhsach";
	}
	
	@RequestMapping("chinh-sach-quyen-rieng-tu")
	public String chinhsachquyenriengtu(ModelMap model) {
		model.addAttribute("title", "Chính sách quyền riêng tư");
		return "home/chinhsachquyenriengtu";
	}
	
	@RequestMapping("dieu-khoan-dieu-kien")
	public String dieukhoandieukien(ModelMap model) {
		model.addAttribute("title", "Điều khoản - điều kiện");
		return "home/dieukhoan-dieukien";
	}
	
	@RequestMapping("gioi-thieu")
	public String gioithieu(ModelMap model) {
		model.addAttribute("title", "Giới thiệu");
		return "home/gioithieu";
	}

	@RequestMapping("phan-hoi")
	public String phanhoi(ModelMap model) {
		model.addAttribute("title", "Phản hồi");
		return "home/phanhoi";
	}

	
	
	
	
	// Đăng nhập
	@RequestMapping(value = "dangnhap", method = RequestMethod.POST)
	//Lấy thông tin từ các input
	public String dangnhap(ModelMap model, @RequestParam("login_email") String email, @RequestParam("lockacc") Integer lockacc,
			@RequestParam("login_password") String pwd, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws InvalidKeyException {

		String referer = request.getHeader("Referer");//Đường dẫn trả về 
		Session session = factory.getCurrentSession();
		Taikhoan tk = null;//Tạo 1 tài khoản mới rỗng tên là tk
		Khachsan ks = null;//Tạo 1 khách sạn mới rỗng tên là ks
		Congty ct = null;//Tạo 1 công ty mới rỗng tên là ct
		try {
			// Kiểm tra thông tin tài khoản
			String hql = "from Taikhoan where email = :emailtk";//Câu truy vấn kiểm tra email
			Query query = session.createQuery(hql);//thực hiện câu truy vấn
			query.setParameter("emailtk", email);
			tk = (Taikhoan) query.uniqueResult();
			EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");// Tạo key mã hóa mật khẩu
			String Matkhaumahoa = encryption.encoding(pwd);// Mã hóa mật khẩu vowis key ở trên 
			Integer idtk = tk.getIdtaikhoan();
			
			// Kiểm tra thông tin khách sạn
			String hqlks = "from Khachsan where idtaikhoan = :idtk";
			Query queryks = session.createQuery(hqlks);
			queryks.setParameter("idtk", idtk);
			ks = (Khachsan) queryks.uniqueResult();
			
			// Kiểm tra thông tin công ty
			String hqlct = "from Congty where idtaikhoan = :idtk";
			Query queryct = session.createQuery(hqlct);
			queryct.setParameter("idtk", idtk);
			ct = (Congty) queryct.uniqueResult();

			if (!tk.getMatkhau().equals(Matkhaumahoa)) {// Điều kiện khi nhập sai mật khẩu
				System.out.println("dang nhap that bai");
				redirectAttributes.addFlashAttribute("message", "dang nhap that bai");
				return "redirect:"+ referer;// Trả về trang đăng nhập
			} else if (tk.getTrangthai().getIdtrangthai() == 2) { // Điều kiện khi id trang thái = 2
				System.out.println("tai khoan chua kich hoat");
				redirectAttributes.addFlashAttribute("message", "tai khoan chua kich hoat");
				return "redirect:"+ referer;//Trả về trang đăng nhập
			} else if (tk.getTrangthai().getIdtrangthai() == 3) { // Điều kiện khi idgtrangthai= 3
				System.out.println("tai khoan bi khoa");
				redirectAttributes.addFlashAttribute("message", "tai khoan bi khoa");
				return "redirect:"+ referer;//Trả về trang đăng nhập
			} else {
				httpSession.setAttribute("loguser", tk);// Lưu tài khoản đăng nhập 
				if(ks != null){
					httpSession.setAttribute("loguserks", ks);// Lưu khách sạn của tài khoản đăng nhập
				}
				if(ct != null){
					httpSession.setAttribute("loguserct", ct);// Lưu công ty của tài khoản đăng nhập
				}
				// Thông báo đăng nhập thành  công
				redirectAttributes.addFlashAttribute("message", "dang nhap thanh cong");
			}
		} catch (Exception e) {
			// Thông báo đăng nhập thất bại
			redirectAttributes.addFlashAttribute("message", "dang nhap that bai");
			return "redirect:"+ referer; // Trả về trang đăng nhập
		}
		return "redirect:"+ referer;
	}

	
	
	
	
	// Đăng xuất
	@RequestMapping("dangxuat")
	public String dangxuat(HttpSession httpSession) {
		httpSession.removeAttribute("loguser");// remove tài khoản đăng nhập
		httpSession.removeAttribute("loguserks");// Remove khách sạn của tài khoản đăng nhập
		httpSession.removeAttribute("loguserct");// Remove công ty của tài khoản đăng nhập
		return "redirect:/home/trang-chu.html";//Trả về trang chủ
	}

	
	
	
	
	// Đăng ký (register form)
	@RequestMapping(value = "dangky", method = RequestMethod.POST)
	// Lấy thông tin từ các input với các name
	public String Register(ModelMap model,
			RedirectAttributes redirectattributes,
			HttpSession httpSession,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("reg_email") String email,
			@RequestParam("reg_matkhau") String matkhau, 
			@RequestParam("reg_sdt") String sdt,
			@RequestParam("reg_hodem") String hodem,
			@RequestParam("reg_ten") String ten) throws InvalidKeyException {

		if (kiemtraEmail(email)){
			redirectattributes.addFlashAttribute("message", "dang ky email ton tai");
			return "redirect:/home/trang-chu.html";
		} else {
			Session session = factory.openSession();
			// Get role = 3 (member)
			Quyen rl = (Quyen) session.get(Quyen.class, 5);
			// Get trangthai = 2 (not activated)
			Trangthai trt = (Trangthai) session.get(Trangthai.class, 2);
			// Get ngaytao (getdate)
			Date ngaytao = new Date();

			// Password encryption
			EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
			String Matkhaumahoa = encryption.encoding(matkhau);
			// Create new Taikhoan
			String random = RandomString.randomString(20);
			Taikhoan user = new Taikhoan(email, Matkhaumahoa, sdt, hodem, ten, "default.jpg", ngaytao, rl, trt, random);

			Transaction t = session.beginTransaction();
			try {
				session.save(user);
				t.commit();
				redirectattributes.addFlashAttribute("message", "dang ky thanh cong");
				String from = "camnangdulich360@gmail.com";
				String subject = "Xác nhận tài khoản - Camnangdulich";
				String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/home/xac-nhan-tai-khoan/" + random + ".html";
				String body = "Nhấn vào đường dẫn để xác nhận tài khoản :\n" + url;
				mailer.send(from, email, subject, body);
				return "redirect:/home/trang-chu.html";
			} catch (Exception e) {
				t.rollback();
				redirectattributes.addFlashAttribute("message", "dang ky that bai");
			} finally {
				session.close();
			}
		}
		return "redirect:/home/trang-chu.html";
	}
	
	// Xác nhận tài khoản
	@RequestMapping("xac-nhan-tai-khoan/{keypass}")
	public String xacnhantaikhoan(ModelMap model, @PathVariable("keypass") String keypass) {

		Session session = factory.getCurrentSession();
		// Câu truy vấn lấy thông tin theo Loại tin theo slug
		String hql = "from Taikhoan where keypass = :keypass";
		Query query = session.createQuery(hql);// Thực hiện câu truy vấn 
		query.setParameter("keypass", keypass);
		Taikhoan taikhoan = (Taikhoan) query.uniqueResult();
		
		if(taikhoan == null){
			return "error/404";
		}else{
			Trangthai trangthai = (Trangthai) session.get(Trangthai.class, 1);
			taikhoan.setTrangthai(trangthai);
			taikhoan.setKeypass(null);
			String tennguoidung = taikhoan.getHodem() +" "+ taikhoan.getTen();
			model.addAttribute("tennguoidung",tennguoidung);
			return "home/xntaikhoan";
		}
	}
	
	
	// Đặt lại mật khẩu
	@RequestMapping("dat-lai-mat-khau/{keypass}")
	public String datlaimatkhau(ModelMap model, @PathVariable("keypass") String keypass) {

		Session session = factory.getCurrentSession();
		String hql = "from Taikhoan where keypass = :keypass";
		Query query = session.createQuery(hql);// Thực hiện câu truy vấn 
		query.setParameter("keypass", keypass);
		Taikhoan taikhoan = (Taikhoan) query.uniqueResult();
		
		if (taikhoan == null){
			return "error/404";
		} else {
			model.addAttribute("taikhoan",taikhoan);
			return "home/datlaimatkhau";
		}
	}
	
	// Đặt lại mật khẩu Action
	@RequestMapping(value = "dat-lai-mat-khau", method = RequestMethod.POST)
	public String datlaimatkhauac(ModelMap model, RedirectAttributes redirectattributes,
			@RequestParam("idtk") Integer idtaikhoan,
			@RequestParam("matkhaumoi") String matkhau) throws InvalidKeyException {

		EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
		String mkmahoa = encryption.encoding(matkhau);
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, idtaikhoan);

		tk.setMatkhau(mkmahoa);
		tk.setKeypass(null);

		try {
			session.update(tk);
			t.commit();
			redirectattributes.addFlashAttribute("message", "dat lai mat khau thanh cong");
			return "redirect:/home/trang-chu.html";
		} catch (Exception e) {
			t.rollback();
			redirectattributes.addFlashAttribute("message", "dat lai mat khau that bai");
			return "redirect:/home/trang-chu.html";
		} finally {
			session.close();
		}
		
		
		
		
	}

	
	
	
	
	// Danh sách tin tức
	@RequestMapping("tin-tuc/{slugloaitintuc}")
	public String dstintuc(ModelMap model, @PathVariable("slugloaitintuc") String slugloaitintuc, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {

		Session session = factory.getCurrentSession();
		// Câu truy vấn lấy thông tin theo Loại tin theo slug
		String hqllt = "from Loaitin where slug = :slugloaitintuc";
		Query querylt = session.createQuery(hqllt);// Thực hiện câu truy vấn 
		querylt.setParameter("slugloaitintuc", slugloaitintuc);
		Loaitin loaitin = (Loaitin) querylt.uniqueResult();
		Integer idlt = loaitin.getIdloaitin();
		
		int total = 0, pageSize = 12;
		// Câu truy vấn lấy thông tin Chitiettin theo idloaitin
		String hql = "from Chitiettin where idloaitin = :idlt";
		Query query = session.createQuery(hql);// Thực hiện câu truy vấn 
		query.setParameter("idlt", idlt);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Chitiettin> list = query.list();

		Loaitin lt = (Loaitin) session.get(Loaitin.class, idlt);
		String tenloaitin = lt.getLoaitin();
		String slugloaitin = lt.getSlug();

		model.addAttribute("title", tenloaitin);
		model.addAttribute("slugloaitin", slugloaitin);
		model.addAttribute("dslt", list);
		model.addAttribute("idloaitin", idlt);
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/tintuc_ds";// Trả về trang danh sách tin tức
	}

	
	
	
	
	// Chi tiết tin tức
	@RequestMapping("tin-tuc/bai-viet/{slugbaiviet}")
	public String cttintuc(ModelMap model, @PathVariable("slugbaiviet") String slugbaiviet) {
		Session session = factory.getCurrentSession();
		//Câu truy vấn lấy thông tin theo slug
		String hql = "from Tintuc where slug = :slugbaiviet";
		Query query = session.createQuery(hql);// thực hiện câu truy vấn 
		query.setParameter("slugbaiviet", slugbaiviet);
		Tintuc tt = (Tintuc) query.uniqueResult();
		tt.setLuotxem(tt.getLuotxem() + 1);
		String tieude = tt.getTieude();

		model.addAttribute("cttt", tt);// Lưu tin tức
		model.addAttribute("title", tieude);// Lưu tiêu đề của tin tức

		return "home/tintuc_ct"; //Trả về trang chi tiết của tin tức
	}

	
	
	
	
	// Chi tiết khách sạn
	@RequestMapping("khach-san/{slugkhachsan}")
	public String ctkhachsan(ModelMap model, @PathVariable("slugkhachsan") String slugkhachsan) {
		Session session = factory.getCurrentSession();
		// Câu truy vấn lấy thông tin khách sạn theo slug
		String hql = "from Khachsan where slug = :slugkhachsan";
		Query query = session.createQuery(hql);// thực hiện câu truy vấn 
		query.setParameter("slugkhachsan", slugkhachsan);
		Khachsan ks = (Khachsan) query.uniqueResult();
		String tenkhachsan = ks.getTenkhachsan();
		Integer idtt = ks.getTinhthanh().getIdtinhthanh();
		Integer idks = ks.getIdkhachsan();

		// Câu truy vấn lấy thông tin khách sạn theo idtinhthanh
		String hqlkstkv = "from Khachsan where idtinhthanh = :idtt";
		Query querykstkv = session.createQuery(hqlkstkv);
		querykstkv.setParameter("idtt", idtt);
		querykstkv.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<Khachsan> listks = querykstkv.list();

		// Lấy đánh giá khách sạn
		String hqldg = "from Danhgia where idkhachsan = :idks order by thoigian desc";
		Query querydg = session.createQuery(hqldg);
		querydg.setParameter("idks", idks);
		@SuppressWarnings({ "unchecked" })
		List<Danhgia> listdgks = querydg.list();
		
		// Lấy đánh giá khách sạn (*)
		String hqldgs = "from Danhgia where idkhachsan = :idks group by idkhachsan";
		Query querydgs = session.createQuery(hqldgs);
		querydgs.setParameter("idks", idks);
		Danhgia dgs = (Danhgia) querydgs.uniqueResult();
		
		// Lưu đánh giá của khách sạn
		model.addAttribute("dgs", dgs);
		model.addAttribute("listdgks", listdgks);// 
		model.addAttribute("lstkhachsan", listks);
		model.addAttribute("ctks", ks);
		model.addAttribute("title", tenkhachsan);

		return "home/khachsan";// Trả về trang khách sạn
	}
	
	
	
	
	
	// Chi tiết tour
	@RequestMapping("tour/{slugtour}")
	public String cttour(ModelMap model, @PathVariable("slugtour") String slugtour) {
		Session session = factory.getCurrentSession();
		//Lấy thông tin tour theo slug
		String hql = "from Tour where slug = :slugtour";
		Query query = session.createQuery(hql);
		query.setParameter("slugtour", slugtour);
		Tour tour = (Tour) query.uniqueResult();
		tour.setLuotxem(tour.getLuotxem() + 1);
		String tentour = tour.getTentour();
		Integer idtt = tour.getTinhthanh().getIdtinhthanh();

		//Lấy thông tin khách sạn theo idtinhthanh
		String hqlkstkv = "from Khachsan where idtinhthanh = :idtt";
		Query querykstkv = session.createQuery(hqlkstkv);
		querykstkv.setParameter("idtt", idtt);
		querykstkv.setMaxResults(12);
		@SuppressWarnings("unchecked")
		// Tạo danh sách khách sạn 
		List<Khachsan> listks = querykstkv.list();

		model.addAttribute("lstkhachsan", listks);
		model.addAttribute("cttour", tour);
		model.addAttribute("title", tentour);

		return "home/tour";// Trả về trang tour
	}
	
	
	
	

	// Chi tiết tỉnh thành
	@RequestMapping("tinh-thanh/{slugtinhthanh}")
	public String cttinhthanh(ModelMap model, @PathVariable("slugtinhthanh") String slugtinhthanh) {
		Session session = factory.getCurrentSession();
		
		// Lấy thông tin tỉnh thành 
		String hql = "from Tinhthanh where slug = :slugtinhthanh";
		Query query = session.createQuery(hql);
		query.setParameter("slugtinhthanh", slugtinhthanh);
		Tinhthanh tihthanh = (Tinhthanh) query.uniqueResult();
		String tentinh = tihthanh.getTinhthanh();
		Integer idtth = tihthanh.getIdtinhthanh();
		
		// Lấy thông tin Khách sạn
		String hqlksttt = "from Khachsan where idtinhthanh = :idtt";
		Query queryksttt = session.createQuery(hqlksttt);
		queryksttt.setParameter("idtt", idtth);
		queryksttt.setMaxResults(8);
		@SuppressWarnings("unchecked")
		List<Khachsan> listks = queryksttt.list();
		
		//Lấy thông tin Tour
		String hqltttt = "from Tour where diemden = :idtt";
		Query querytttt = session.createQuery(hqltttt);
		querytttt.setParameter("idtt", idtth);
		querytttt.setMaxResults(8);
		@SuppressWarnings("unchecked")
		List<Khachsan> listt = querytttt.list();

		model.addAttribute("listt", listt);
		model.addAttribute("listks", listks);
		model.addAttribute("title", tentinh);

		return "home/tinhthanh";// Trả về trang tỉnh thành
	}
	
	
	
	
	
	// Danh sách tỉnh thành
	@RequestMapping("tinh-thanh/danh-sach")
	public String dstinhthanh(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 16;
		String hql = "from Tinhthanh";
		Query query = session.createQuery(hql);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Tinhthanh> list = query.list();

		model.addAttribute("tinhthanhds", list);
		model.addAttribute("title", "Danh sách tỉnh thành");
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/tinhthanh_ds";
	}
	
	
	// Danh sách tin tức mới
	@RequestMapping("tin-tuc/tin-moi")
	public String dstintucmoi(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 12;
		String hql = "from Tintuc ORDER BY thoigian DESC";
		Query query = session.createQuery(hql);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Tintuc> list = query.list();

		model.addAttribute("dslt", list);
		model.addAttribute("title", "Tin mới");
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/tintucmoi_ds";
	}
	
	// Danh sách tin tức xem nhiều
	@RequestMapping("tin-tuc/tin-xem-nhieu")
	public String dstintucxemnhieu(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 12;
		String hql = "from Tintuc ORDER BY luotxem DESC";
		Query query = session.createQuery(hql);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Tintuc> list = query.list();

		model.addAttribute("dslt", list);
		model.addAttribute("title", "Tin xem nhiều");
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/tinxemnhieu_ds";
	}
	
	
	
	
	
	
	
	
	
	// Danh sách khách sạn
	@RequestMapping("khach-san/danh-sach")
	public String dskhachsan(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 20;
		
		String hql = "from Khachsan";
		Query query = session.createQuery(hql);
		
		String hqls = "from Danhgia group by idkhachsan";
		Query querys = session.createQuery(hqls);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Khachsan> list = query.list();
		@SuppressWarnings("unchecked")
		List<Danhgia> lists = querys.list();

		model.addAttribute("khachsands", list);
		model.addAttribute("dgks", lists);
		model.addAttribute("title", "Danh sách khách sạn");
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/dskhachsan";
	}
	
	
	
	
	
	
	
	
	// Danh sách tour du lich
	@RequestMapping("tour/danh-sach")
	public String dstourdulich(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 20;
		String hql = "from Tour order by idtour desc";
		Query query = session.createQuery(hql);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Tour> list = query.list();

		model.addAttribute("tourds", list);
		model.addAttribute("title", "Danh sách tour du lịch");
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/dstour";
	}
	
	
	
	
	
	
	
	
	
	
	// Tạo khách sạn mới
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "taokhachsan", method = RequestMethod.POST)
	public String taokhachsan(ModelMap model,
			//Lấy thông tin từ các input với các name
			@RequestParam("hinhanh") MultipartFile image,
			@RequestParam("tenkhachsan") String tenkhachsan,
			@RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("idtinhthanh") Integer idtinhthanh,
			@RequestParam("diachi") String diachi,
			@RequestParam("idtaikhoantao") Integer idtaikhoantao,
			@RequestParam("lstdichvu[]") List lstdichvu,
			@RequestParam("lstloaiphong[]") List lstloaiphong) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Khachsan ks = null; //Tạo khách sạn mới rỗng có tên ks
		String hql = "from Khachsan where idtaikhoan = :idtaikhoan";//Câu truy vấn kiểm tra tài khoản 
		Query query = session.createQuery(hql);//Thực hiện câu truy vấn
		query.setParameter("idtaikhoan", idtaikhoantao);
		ks = (Khachsan) query.uniqueResult();
		
		//	Tạo đường dẫn lưu hình ảnh
		if(ks == null){
			String photoPath = context.getRealPath("/files/khachsan/" + image.getOriginalFilename());
			// Lưu hinnhf ảnh
			try {
				image.transferTo(new File(photoPath));
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			Date ngaydang = new Date(); // Tạo biến ngày kiểu date
			// Lấy tài khoản theo id tài khoản
			Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtaikhoantao);
			// Lấy tỉnh thành theo id tỉnh thành
			Tinhthanh tinhthanh = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
			// Lây trang thái có id = 2
			Trangthai trangthai = (Trangthai) session.get(Trangthai.class, 2);
			String slugkhachsan = SlugsConverter.toSlug(tenkhachsan);
			// Create new Khachsan
			Khachsan khachsan = new Khachsan(tenkhachsan, image.getOriginalFilename(), sodienthoai, diachi, taikhoan, ngaydang, tinhthanh, trangthai, slugkhachsan);
			
			try {
				session.save(khachsan);
				int idkhachsan = khachsan.getIdkhachsan();
				// Lấy Khách sạn theo id khách sạn
				Khachsan khachsanmoitao = (Khachsan) session.get(Khachsan.class, idkhachsan);
				
				// Vòng lặp thêm dich vụ
				for ( int x = 0; x < lstdichvu.size(); x++ ){
					Object oj_iddichvu = lstdichvu.get(x);
					int iddichvu = Integer.valueOf((String) oj_iddichvu);
					Dichvu dv = (Dichvu) session.get(Dichvu.class, iddichvu);
					Chitietdichvu ctdv = new Chitietdichvu(dv, khachsanmoitao);
					try {
						session.save(ctdv);
					} catch (Exception e) {
						t.rollback();
					}
				}
				
				// Vòng lặp thêm loại phòng
				for ( int x = 0; x < lstloaiphong.size(); x++ ){
					Object oj_idloaiphong = lstloaiphong.get(x);
					int idloaiphong = Integer.valueOf((String) oj_idloaiphong);
					Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, idloaiphong);
					Chitietloaiphong ctlp = new Chitietloaiphong(khachsanmoitao, lp);
					try {
						session.save(ctlp);
					} catch (Exception e) {
						t.rollback();
					}
				}
				
				t.commit();
				model.addAttribute("message", "tao khach san thanh cong");
				return "home/index";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "tao khach san that bai");
			} finally {
				session.close();
			}
		} else {
			model.addAttribute("message", "khach san da tao cho xac minh");
		}
		
		return "home/index";
	}
	
	
	@RequestMapping(value = "danhgiakhachsan", method = RequestMethod.POST)
	public String danhgiakhachsan(ModelMap model, 
			HttpServletRequest request, RedirectAttributes redirectAttributes,
			//Lấy thông tin từ các input với các name
			@RequestParam("idtaikhoan") Integer idtaikhoan,
			@RequestParam("idkhachsan") Integer idkhachsan,
			@RequestParam("star") Integer star,
			@RequestParam("noidung") String noidung) {
		String referer = request.getHeader("Referer");//Đường dẫn trả về
		Session session = factory.openSession();
		Date thoigiandanhgia = new Date();//Tạo biến thoigiandanhgia kiểu Date
		// Lây khách sạn theo id khách sạn
		Khachsan khachsan = (Khachsan) session.get(Khachsan.class, idkhachsan);
		// Lấy tài khoản theo idtaikhoan
		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtaikhoan);
		// Create new Danhgia
		Danhgia danhgia = new Danhgia(khachsan, taikhoan, star, noidung, thoigiandanhgia);
		Transaction t = session.beginTransaction();
		try {
			session.save(danhgia);
			t.commit();
			// Thông báo thành công
			redirectAttributes.addFlashAttribute("message", "danh gia thanh cong");
			return "redirect:"+ referer;
		} catch (Exception e) {
			t.rollback();
			// Thông báo thất bại
			redirectAttributes.addFlashAttribute("message", "danh gia that bai");
		} finally {
			session.close();
		}
		return "redirect:"+ referer;
	}
	
	
	
	
	// Trang đặt phòng
	@RequestMapping("dat-phong")
	public String datphong(ModelMap model, HttpSession httpsession,
			//Lấy thông tin từ các input với các name
			@RequestParam("khachsan") String slugkhachsan,
			@RequestParam("loaiphong") String slugloaiphong) {
		
		Session session = factory.getCurrentSession();
		// Lấy thông tin khách sạn 
		String hqlks = "from Khachsan where slug = :slugkhachsan";
		Query queryks = session.createQuery(hqlks);
		queryks.setParameter("slugkhachsan", slugkhachsan);
		Khachsan khachsan = (Khachsan) queryks.uniqueResult();
		Integer idks = khachsan.getIdkhachsan();
		
		//Lấy thông tin loại phòng
		String hqllp = "from Loaiphong where slug = :slugloaiphong";
		Query querylp = session.createQuery(hqllp);
		querylp.setParameter("slugloaiphong", slugloaiphong);
		Loaiphong loaiphong = (Loaiphong) querylp.uniqueResult();
		
		// Lấy thông tin đánh giá
		String hqldgs = "from Danhgia where idkhachsan = :idks group by idkhachsan";
		Query querydgs = session.createQuery(hqldgs);
		querydgs.setParameter("idks", idks);
		Danhgia dgs = (Danhgia) querydgs.uniqueResult();
		
		model.addAttribute("title", "Đặt phòng"); //Lưu đặt phòng
		model.addAttribute("khachsan", khachsan);// Lưu khách sạn của đặt phòng
		model.addAttribute("loaiphong", loaiphong);// Lưu loại phòng đặt
		model.addAttribute("dgs", dgs);// Lưu đánh giá Khách sạn
		
		return "home/datphong";// Trả về trang đặt phòng
	}
	@RequestMapping(value = "dat-phong-ks", method = RequestMethod.POST)
	public String datphong(ModelMap model, 
			HttpServletRequest request, RedirectAttributes redirectAttributes,
			//Lấy thông tin từ input với các name
			@RequestParam("ngaynhanphong") String ngaynhanphong,
			@RequestParam("ngaytraphong") String ngaytraphong,
			@RequestParam("soluongphong") Integer soluongphong,
			@RequestParam("hodem") String hodem,
			@RequestParam("ten") String ten,
			@RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("email") String email,
			@RequestParam("idloaiphong") Integer idloaiphong,
			@RequestParam("idkhachsan") Integer idkhachsan) throws ParseException {
		
		//Format lại năm tháng ngày
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date datenhanphong = df.parse(ngaynhanphong);
		Date datetraphong = df.parse(ngaytraphong);
		
		String referer = request.getHeader("Referer");// Đường dẫn trả về
		Session session = factory.openSession();
		// Get khachsan =  idkhachsan
		Khachsan khachsan = (Khachsan) session.get(Khachsan.class, idkhachsan);
		//Get loaiphong = idloaiphong
		Loaiphong loaiphong = (Loaiphong) session.get(Loaiphong.class, idloaiphong);
		// Get  trangthai id=2
		Trangthai trangthai = (Trangthai) session.get(Trangthai.class, 2);
		//Create new ưdatphong
		Datphong datphong = new Datphong(khachsan, loaiphong, trangthai, datenhanphong, datetraphong, soluongphong, hodem, ten, sodienthoai, email);
		Transaction t = session.beginTransaction();
		try {
			session.save(datphong);// Lưu thông tin đặt phòng
			t.commit();
			// Thông báo dặt phòng thành công
			redirectAttributes.addFlashAttribute("message", "dat phong thanh cong");
			return "redirect:"+ referer;
		} catch (Exception e) {
			t.rollback();
			// Thông báo thất bại
			redirectAttributes.addFlashAttribute("message", "dat phong that bai");
		} finally {
			session.close();
		}
		return "redirect:"+ referer; // Trả về trang đặt phòng
	}
	
	
	
	
	
	// Tìm kiếm
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "timkiem", method = RequestMethod.GET)
	public String TimKiem(Model model, @RequestParam(value = "tukhoa", defaultValue = "") String tukhoa) {
		Session session = factory.openSession();
		List<Khachsan> ks = null;// Tạo danh sách khác sạn rỗng
		List<Tour> t = null;// Tạo danh sách tour rỗng
		List<Tintuc> tt = null;// Tạo danh sách tin tức rỗng

		try {
			// Lấy khách sạn theo từ khóa
			String hqlks = "from Khachsan ks where ks.tenkhachsan like '%" + tukhoa + "%'";
			Query queryks = session.createQuery(hqlks);
			ks = queryks.list();
			// Lấy tour theo từ khóa 
			String hqlt = "from Tour t where t.tentour like '%" + tukhoa + "%'";
			Query queryt = session.createQuery(hqlt);
			t = queryt.list();
			// Lấy Tin túc theo từ khóa
			String hqltt = "from Tintuc tt where tt.tieude like '%" + tukhoa + "%' " + "or tt.tomtat like '%" + tukhoa
					+ "%' or tt.noidung like '%" + tukhoa + "%' ";
			Query querytt = session.createQuery(hqltt);
			tt = querytt.list();

			if (tt != null) {// Nếu từ khóa like tiêu đề tin tức
				model.addAttribute("tintuc", tt);
			}
			if (ks != null) { // nếu từ khóa like tên khách sạn 
				model.addAttribute("ks", ks);
			}
			if (t != null) {// Nếu từ khóa like tên tour
				model.addAttribute("t", t);
			}

		} catch (Exception e) {
		} finally {
			session.close();
		}
		return "home/timkiem";
	}
	
	
	
	// Đặt tour
	@RequestMapping(value = "tour", method = RequestMethod.POST)
	public String tour(ModelMap model,
			//Lấy thông tin tứ các input 
			@RequestParam("tentour") Integer tentour,
			@RequestParam("hodem") String hodem,
			@RequestParam("ten") String ten,
			@RequestParam("songuoi") Integer songuoi,
			@RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("email") String email,
			@RequestParam("yeucau") String yeucau, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes){
			
			String referer = request.getHeader("Referer");
			Session session = factory.openSession();
 			Trangthai trang = (Trangthai) session.get(Trangthai.class, 2);//Lấy trạng thái có id là 2
 			Tour tuor = (Tour) session.get(Tour.class, tentour);//Lấy tour có id bằng iput có name là tour
 			//Tạo  Dattour với các thuộc tính của Dattour
 			Dattour dt = new Dattour(tuor, trang, hodem, ten, songuoi, sodienthoai, email, yeucau);
 			Transaction t = session.beginTransaction();
 			try {
 				session.save(dt);//Lưu các thuộc tính Datuor
 				t.commit();//Thực hiện update lên cơ sở dữ liệu
 				redirectAttributes.addFlashAttribute("message", "dat tour thanh cong");
 				return "redirect:"+ referer;
 			} catch (Exception e) {
 				t.rollback();
 				redirectAttributes.addFlashAttribute("message", "dat tour that bai");
 			} finally {
 				session.close();//Đóng session
 			}
 			return "redirect:"+ referer;
	}
	
	// Phản hồi
	@RequestMapping(value = "phan-hoi", method = RequestMethod.POST)
	public String phanhoi(ModelMap model, @RequestParam("hoten") String hoten,
			@RequestParam("email") String email,
			@RequestParam("noidung") String noidung) {

			Session session = factory.openSession();
			Phanhoi ph = new Phanhoi(hoten, email, noidung);
			Transaction t = session.beginTransaction();
			try {
				session.save(ph);
				t.commit();
				model.addAttribute("message", "Phản hồi thành công!");
				
				String from = "kakaassasin123@gmail.com";
				String subject = "Phản hồi - Camnangdulich";
				String body = "Người phản hồi: "+hoten+" ("+email+") - Nội dung: "+noidung;
				mailer.send(from, "camnangdulich360@gmail.com", subject, body);
				
				return "home/phanhoi";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Phản hồi thất bại!");
			} finally {
				session.close();
			}
		
		return "home/phanhoi";
	}
	
	
	
	
	
	
	
	
	
	
	// Thông tin tài khoản
	@RequestMapping("thong-tin-tai-khoan")
	public String tttaikhoan(ModelMap model) {
		model.addAttribute("title", "Thông tin tài khoản");
		return "home/tttaikhoan";
	}
	@RequestMapping(value = "thong-tin-tai-khoan", method = RequestMethod.POST)
	public String stttaikhoan(ModelMap model, 
			HttpSession httpSession,
			HttpServletRequest request,
			HttpServletResponse response, 
			@RequestParam("idtk") Integer idtk, 
			@RequestParam("matkhau") String matkhau,
			@RequestParam("hodem") String hodem, 
			@RequestParam("ten") String ten,
			@RequestParam("diachi") String diachi, 
			@RequestParam("avatar") MultipartFile image) throws InvalidKeyException {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, idtk);
		String photoPath = context.getRealPath("/files/avatar/" + image.getOriginalFilename());
		
		EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
		String Matkhaumahoa = encryption.encoding(matkhau);

		tk.setMatkhau(Matkhaumahoa);
		tk.setHodem(hodem);
		tk.setTen(ten);
		tk.setDiachi(diachi);

		try {
			if (image.getOriginalFilename().equals("")) {
				session.update(tk);
				t.commit();
				httpSession.setAttribute("loguser", tk);
				model.addAttribute("message", "cap nhat tai khoan thanh cong");
				return "home/tttaikhoan";
			} else {
				image.transferTo(new File(photoPath));
				tk.setAvatar(image.getOriginalFilename());
				session.update(tk);
				t.commit();
				httpSession.setAttribute("loguser", tk);
				model.addAttribute("message", "cap nhat tai khoan thanh cong");
				return "home/tttaikhoan";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "cap nhat tai khoan that bai");
			return "home/tttaikhoan";
		} finally {
			session.close();
		}
	}
	
	
	
	
	


	
	
	
	// ------------------------------------------------------------------
	// ===================== DELETE Controller ===========================
	// ------------------------------------------------------------------
	
	// Xóa đánh giá khách sạn
	@RequestMapping("xdgks/{id}")
	public String xdgks(ModelMap model, 
			@PathVariable("id") int idxoa,
			HttpSession httpSession,
			HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		String referer = request.getHeader("Referer");
		Session session = factory.openSession();
		Danhgia dg = (Danhgia) session.get(Danhgia.class, idxoa);
		Transaction t = session.beginTransaction();
		try {
			session.delete(dg);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:"+ referer;
	}
	
	
	
	
	
	
	
	// ------------------------------------------------------------------
	// ===================== CHECK Controller ===========================
	// ------------------------------------------------------------------

	// Kiểm tra email có tồn tại không
	public boolean kiemtraEmail(String email) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Taikhoan where email = :mail";
			Query query = session.createQuery(hql);
			query.setParameter("mail", email);
			@SuppressWarnings("unchecked")
			List<Taikhoan> lstTaikhoans = query.list();
			t.commit();
			if (lstTaikhoans.size() != 0) {
				return kt;
			} else {
				return false;
			}
		} catch (Exception ex) {
			if (!(t == null)) {
				t.rollback();
			}
		} finally {
			session.close();
		}
		return kt;
	}
	
	
	
	
	
	
	
	
	
	
	// ------------------- Send mail Controller -------------------------
	// ------------------------------------------------------------------

	// ------------------- Send Mail Lấy lại mật khẩu -------------------
	@RequestMapping(value = "passkeymailer", method = RequestMethod.POST)
	public String passkeymailer(ModelMap model, 
			HttpServletRequest request,
			@RequestParam("email") String email)
			throws InvalidKeyException {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		String from = "camnangdulich360@gmail.com";
		String random = RandomString.randomString(20);
		String subject = "Đặt lại mật khẩu - Camnangdulich";
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/home/dat-lai-mat-khau/" + random + ".html";
		String body = "Nhấn vào đường dẫn để đặt lại mật khẩu :\n" + url;

		String hql = "from Taikhoan where email = :emailtk";
		Query query = session.createQuery(hql);
		query.setParameter("emailtk", email);
		Taikhoan tk = (Taikhoan) query.uniqueResult();
		
		if (tk == null){
			model.addAttribute("message", "repass mail khong ton tai");
		} else {
			tk.setKeypass(random);
			try {
				session.update(tk);
				t.commit();
				// Gửi mail
				mailer.send(from, email, subject, body);
				model.addAttribute("message", "repass mail thanh cong");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "repass mail that bai");
				return "home/index";
			} finally {
				session.close();
			}

		}
		return "home/index";
	}
	
	
	
	
	
	
	
	
	
	
	// ------------------- Đăng nhập bằng mạng xã hội -------------------
	// ------------------------------------------------------------------
	
	// ------------------- Facebook Login -------------------------------
	@RequestMapping(value = "signin-facebook", method = RequestMethod.POST)
	public String signinFacebook(@RequestBody String accessToken, ModelMap model,
			HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response) throws InvalidKeyException {
		System.out.println("Facebook TokenID : " + accessToken);
		@SuppressWarnings("deprecation")
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		User me = fbClient.fetchObject("me", User.class, Parameter.with("fields", "picture,first_name,last_name,gender,name,email"));

		System.out.println("Facebook Picture URL : " + me.getPicture().getUrl());
		System.out.println("Facebook ID : " + me.getId());
		System.out.println("Facebook Email : " + me.getEmail());
		System.out.println("Facebook Name : " + me.getName());
		System.out.println("Facebook FirstName : " + me.getFirstName());
		System.out.println("Facebook LastName : " + me.getLastName());
		System.out.println("Facebook About : " + me.getAbout());
		System.out.println("Facebook Bio : " + me.getBio());
		System.out.println("Facebook Birthday : " + me.getBirthday());
		System.out.println("Facebook Gender : " + me.getGender());
		System.out.println("Facebook HometownName : " + me.getHometownName());
		System.out.println("Facebook Hometown : " + me.getHometown());
		System.out.println("Facebook Link : " + me.getLink());
		System.out.println("Facebook Locale : " + me.getLocale());
			
		Session session = factory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Taikhoan taikhoan = null;
		String email = me.getId() + "@fbmail.com";
		String hql = "from Taikhoan where email = :emailtk";
		Query query = session.createQuery(hql);
		query.setParameter("emailtk", email);
		taikhoan = (Taikhoan) query.uniqueResult();
		
		try {
			if (taikhoan == null) {
				// Ngày tạo
				Date ngaytao = new Date();
				System.out.println("Tai khoan chua dang ky --> Auto dang ky");
				// Random mật khẩu mới
				String matkhau = RandomString.randomString(20);
				// Tạo key mã hóa mật khẩu
				EnDeCryption cryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
				// Mã hóa mật khẩu mới tạo
				String matkhaumahoa = cryption.encoding(matkhau);
				// Lấy quyền id = 6 ( Quyền Facebook )
				Quyen quyen = (Quyen) session.get(Quyen.class, 6);
				// Lấy trạng thái id = 1 ( Trạng thái tài khoản được kích hoạt )
				Trangthai trt = (Trangthai) session.get(Trangthai.class, 1);
				// Tạo mới tài khoản với thông tin người dùng
				
				String sdt = "Facebook ID : "+me.getId();
				String hinhanh = me.getPicture().getUrl();
				String hodem = me.getLastName();
				String ten = me.getFirstName();
				
				taikhoan = new Taikhoan(email, matkhaumahoa, sdt, hodem, ten, hinhanh, ngaytao, quyen, trt);
				try {
					session.save(taikhoan);
					t.commit();
					System.out.println("Facebook Register Compelete");
					model.addAttribute("message", "Đăng ký thành công !");
					return "home/tttaikhoan";
				} catch (Exception e) {
					System.out.println("Facebook Register Failse");
					t.rollback();
					model.addAttribute("message", "Đăng ký thất bại !");
				} finally {
					session.close();
				}
			}
			System.out.println("Tai khoan da dang ky --> Auto dang nhap");
			System.out.println(taikhoan.getEmail());
			httpSession.setAttribute("loguser", taikhoan); // Auto login
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return "home/index";
	}
	
	
	
	
	
	// ------------------- Google Login -------------------------------
	private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
	
	@RequestMapping(value = "signin-google", method = RequestMethod.POST)
    public String String(@RequestBody String idtoken, ModelMap model,
			HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response) {
        System.out.println("Google TokenID :" + idtoken);

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(TRANSPORT, JSON_FACTORY).setAudience(Collections
                        .singletonList("988534781661-a1ikie8ng4g7mapq54gphs97jehv4jg3.apps.googleusercontent.com")).build();
        GoogleIdToken idToken;
        Taikhoan taikhoan = null;
        try {
            idToken = verifier.verify(idtoken);
            if (idToken != null) {
                Payload payload = idToken.getPayload();

                // Print user identifier
                String userId = payload.getSubject();
                System.out.println("User ID: " + userId);

                // Get profile information from payload
                String email = payload.getEmail();
                System.out.println("User Email: " + email);
                
                String name = (String) payload.get("name");
                System.out.println("User Name: " + name);
                
                String pictureUrl = (String) payload.get("picture");
                System.out.println("User pictureUrl: " + pictureUrl);
                
                String locale = (String) payload.get("locale");
                System.out.println("User locale: " + locale);
                
                String familyName = (String) payload.get("family_name");
                System.out.println("User familyName: " + familyName);
                
                String givenName = (String) payload.get("given_name");
                System.out.println("User givenName: " + givenName);
                
                System.out.println("GOOOGLE NEF : " + givenName +"--"+ familyName);
                
        		Session session = factory.getCurrentSession();
        		String hql = "from Taikhoan where email = :emailtk";
        		Query query = session.createQuery(hql);
        		query.setParameter("emailtk", email);
        		taikhoan = (Taikhoan) query.uniqueResult();
        		
        		if (taikhoan == null) {
        			// Ngày tạo
        			Date ngaytao = new Date();
        			System.out.println("Tai khoan chua dang ky --> Auto dang ky");
        			// Random mật khẩu mới
        			String matkhau = RandomString.randomString(20);
        			// Tạo key mã hóa mật khẩu
        			EnDeCryption cryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
        			// Mã hóa mật khẩu mới tạo
        			String matkhaumahoa = cryption.encoding(matkhau);
        			// Lấy quyền id = 7 ( Quyền Google )
        			Quyen quyen = (Quyen) session.get(Quyen.class, 7);
        			// Lấy trạng thái id = 1 ( Trạng thái tài khoản được kích hoạt )
        			Trangthai trt = (Trangthai) session.get(Trangthai.class, 1);
        			// Tạo mới tài khoản với thông tin người dùng
        			
        			String sdt = "Google ID : " + userId;
        			String hodem = " ";
        			String ten = familyName;
        			taikhoan = new Taikhoan(email, matkhaumahoa, sdt, hodem, ten, pictureUrl, ngaytao, quyen, trt);
        			Transaction t = session.beginTransaction();
        			try {
        				session.save(taikhoan);
        				t.commit();
        				System.out.println("Facebook Register Compelete");
        				model.addAttribute("message", "Đăng ký thành công !");
        				return "home/tttaikhoan";
        			} catch (Exception e) {
        				System.out.println("Facebook Register Failse");
        				t.rollback();
        				model.addAttribute("message", "Đăng ký thất bại !");
        			} finally {
        				session.close();
        			}
        		}
        		System.out.println("Tai khoan da dang ky --> Auto dang nhap");
        		httpSession.setAttribute("loguser", taikhoan); // Auto login
        		return "home/index";
            } else {
                System.out.println("Invalid ID token.");
            }
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();

        }
        return "home/index";
    }

	
	

	
}
