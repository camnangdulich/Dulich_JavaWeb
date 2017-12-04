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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import entities.Dichvu;
import entities.Khachsan;
import entities.Loaiphong;
import entities.Loaitin;
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
		query_ttm.setMaxResults(ttmSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttintucmoi = query_ttm.list();//Tạo danh sách tin tức mới nhất có tên là lsttintucmoi
		return lsttintucmoi;//Trả về danh sách các tin tức mới nhất
	}

	// Lấy thông tin tin liên quan
	@ModelAttribute("lsttinlienquan")
	public List<Tintuc> lsttinlienquan(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 5;
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";
		Query query_ttm = session.createQuery(hql_ttm);
		query_ttm.setMaxResults(ttmSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttinlienquan = query_ttm.list();
		return lsttinlienquan;
	}

	// Lấy thông tin tin tức mới nhất SIBAR
	@ModelAttribute("lstsibarttm")
	public List<Tintuc> lstsibarttm(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 3;//tạo biến in ttmSize = 3 để đổ vào SiBAR
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";//Lấy tin tức mới nhất SIBAR
		Query query_ttm = session.createQuery(hql_ttm);//Thực hiện câu truy vấn
		query_ttm.setMaxResults(ttmSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lstsibarttm = query_ttm.list();//Tạo danh sách tin tức mới SIBAR có tên lstsibarttm
		return lstsibarttm;//Trả về danh sách tin tức mới SIBAR
	}

	// Lấy tin tức có lượt xem nhiều nhất
	@ModelAttribute("lsttinxemnhieu")
	public List<Tintuc> lsttinxemnhieu(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttxnSize = 8;//Biến int ttxnSize giới hạn số lượng tin có lượt xem nhiều nhất 
		String hql_ttxn = "from Tintuc tt ORDER BY tt.luotxem DESC";//Câu truy vấn lấy tin tức  có lượt xem nhiều nhất
		Query query_ttxn = session.createQuery(hql_ttxn);//THực hiện câu truy vấn
		query_ttxn.setMaxResults(ttxnSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttinxemnhieu = query_ttxn.list();//Tạ danh sách tin tức được xem nhiều nhất có tên lsttinxemnhieu
		return lsttinxemnhieu;//Trả về danh sách tin tức có lượt xem nhiều nhất 
	}

	// Lấy tin tức có lượt xem nhiều nhất SIBAR
	@ModelAttribute("lstsibarttxn")
	public List<Tintuc> lstsibarttxn(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttxnSize = 3;
		String hql_ttxn = "from Tintuc ORDER BY luotxem DESC";
		Query query_ttxn = session.createQuery(hql_ttxn);
		query_ttxn.setMaxResults(ttxnSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lstsibarttxn = query_ttxn.list();
		return lstsibarttxn;
	}

	// Lấy đánh giá khách sạn có sao nhiều nhất
	@ModelAttribute("lstdanhgiakhachsan")
	public List<Danhgia> lstdanhgiakhachsan(ModelMap model) {
		Session session = factory.getCurrentSession();
		int dgksSize = 8;
		String hql_dgks = "from Danhgia group by idkhachsan having avg(star) >= 3 ORDER BY star DESC";
		Query query_dgks = session.createQuery(hql_dgks);
		query_dgks.setMaxResults(dgksSize);
		@SuppressWarnings("unchecked")
		List<Danhgia> lstdanhgiakhachsan = query_dgks.list();
		return lstdanhgiakhachsan;
	}

	// Lấy tour có lượt xem nhiều nhất
	@ModelAttribute("lsttournoibat")
	public List<Tour> lsttournoibat(ModelMap model) {
		Session session = factory.getCurrentSession();
		int tourSize = 8;
		String hql_tour = "from Tour ORDER BY luotxem DESC";
		Query query_tour = session.createQuery(hql_tour);
		query_tour.setMaxResults(tourSize);
		@SuppressWarnings("unchecked")
		List<Tour> lsttournoibat = query_tour.list();
		return lsttournoibat;
	}

	// Lấy tour đặc biệt
	@ModelAttribute("lsttourdacbiet")
	public List<Tour> lsttourdacbiet(ModelMap model) {
		Session session = factory.getCurrentSession();
		int tourSize = 6;
		String hql_tour = "from Tour ORDER BY luotxem DESC";
		Query query_tour = session.createQuery(hql_tour);
		query_tour.setMaxResults(tourSize);
		@SuppressWarnings("unchecked")
		List<Tour> lsttourdacbiet = query_tour.list();
		return lsttourdacbiet;
	}

	// Lấy tất cả loại tin tức
	@ModelAttribute("loaitinlst")
	public List<Loaitin> loaitinlst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaitin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Loaitin> list = query.list();
		return list;
	}

	// Lấy tất cả loại phòng
	@ModelAttribute("loaiphonglst")
	public List<Loaiphong> loaiphonglst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaiphong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Loaiphong> list = query.list();
		return list;
	}
	
	// Lấy tất cả dịch vụ
	@ModelAttribute("dichvulst")
	public List<Dichvu> dichvulst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Dichvu";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Dichvu> list = query.list();
		return list;
	}
	
	// Lấy tất cả tỉnh thành
	@ModelAttribute("tinhthanhlst")
	public List<Tinhthanh> tinhthanhlst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tinhthanh order by tinhthanh";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Tinhthanh> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin chi tiết loại phòng
	@ModelAttribute("ctlplist")
	public List<Chitietloaiphong> getctlp(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Chitietloaiphong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Chitietloaiphong> list = query.list();
		return list;
	}

	
	
	
	
	
	
	
	
	
	// --------------------- PAGE Controller ----------------------------
	// ------------------------------------------------------------------

	@RequestMapping("trang-chu")
	public String index(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		model.addAttribute("title", "Cẩm nang du lịch");
		
		return "home/index";
	}

	
	
	
	
	// Đăng nhập
	@RequestMapping(value = "dangnhap", method = RequestMethod.POST)
	public String dangnhap(ModelMap model, @RequestParam("login_email") String email, @RequestParam("lockacc") Integer lockacc,
			@RequestParam("login_password") String pwd, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws InvalidKeyException {

		String referer = request.getHeader("Referer");
		Session session = factory.getCurrentSession();
		Taikhoan tk = null;
		Khachsan ks = null;
		Congty ct = null;
		try {
			// Kiểm tra thông tin tài khoản
			String hql = "from Taikhoan where email = :emailtk";
			Query query = session.createQuery(hql);
			query.setParameter("emailtk", email);
			tk = (Taikhoan) query.uniqueResult();
			EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
			String Matkhaumahoa = encryption.encoding(pwd);
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

			if (!tk.getMatkhau().equals(Matkhaumahoa)) {
				System.out.println("dang nhap that bai");
//				model.addAttribute("title", "Cẩm nang du lịch");
//				model.addAttribute("message", "dang nhap that bai");
				redirectAttributes.addFlashAttribute("message", "dang nhap that bai");
				return "redirect:"+ referer;
			} else if (tk.getTrangthai().getIdtrangthai() == 2) {
				System.out.println("tai khoan chua kich hoat");
//				model.addAttribute("title", "Cẩm nang du lịch");
//				model.addAttribute("message", "tai khoan chua kich hoat");
				redirectAttributes.addFlashAttribute("message", "tai khoan chua kich hoat");
				return "redirect:"+ referer;
			} else if (tk.getTrangthai().getIdtrangthai() == 3) {
				System.out.println("tai khoan bi khoa");
//				model.addAttribute("title", "Cẩm nang du lịch");
//				model.addAttribute("message", "tai khoan bi khoa");
				redirectAttributes.addFlashAttribute("message", "tai khoan bi khoa");
				return "redirect:"+ referer;
			} else {
				httpSession.setAttribute("loguser", tk);
				if(ks != null){
					httpSession.setAttribute("loguserks", ks);
				}
				if(ct != null){
					httpSession.setAttribute("loguserct", ct);
				}
				System.out.println("dang nhap thanh cong");
//				model.addAttribute("title", "Cẩm nang du lịch");
//				model.addAttribute("message", "dang nhap thanh cong");
				redirectAttributes.addFlashAttribute("message", "dang nhap thanh cong");
			}
		} catch (Exception e) {
			System.out.println("dang nhap that bai");
//			model.addAttribute("title", "Cẩm nang du lịch");
//			model.addAttribute("message", "dang nhap that bai");
			redirectAttributes.addFlashAttribute("message", "dang nhap that bai");
			return "redirect:"+ referer;
		}
		return "redirect:"+ referer;
	}

	
	
	
	
	// Đăng xuất
	@RequestMapping("dangxuat")
	public String dangxuat(HttpSession httpSession) {
		httpSession.removeAttribute("loguser");
		httpSession.removeAttribute("loguserks");
		httpSession.removeAttribute("loguserct");
		return "redirect:/home/trang-chu.html";
	}

	
	
	
	
	// Đăng ký (register form)
	@RequestMapping(value = "dangky", method = RequestMethod.POST)
	public String Register(ModelMap model, @RequestParam("reg_email") String email,
			@RequestParam("reg_matkhau") String matkhau, @RequestParam("reg_sdt") String sdt)
					throws InvalidKeyException {

		Session session = factory.openSession();
		// Get role = 3 (member)
		Quyen rl = (Quyen) session.get(Quyen.class, 3);
		// Get trangthai = 2 (not activated)
		Trangthai trt = (Trangthai) session.get(Trangthai.class, 2);
		// Get ngaytao (getdate)
		Date ngaytao = new Date();

		// Password encryption
		EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
		String Matkhaumahoa = encryption.encoding(matkhau);
		// Create new Taikhoan
		Taikhoan user = new Taikhoan(email, Matkhaumahoa, sdt, "av1.png", ngaytao, rl, trt);

		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
			System.out.println("Register Compelete");
			model.addAttribute("message", "Đăng ký thành công !");
			// model.addAttribute("u", user); // Auto login
			return "home/tttaikhoan";
		} catch (Exception e) {
			System.out.println("Register Failse");
			t.rollback();
			model.addAttribute("message", "Đăng ký thất bại !");
			model.addAttribute("login_check", 0);
		} finally {
			session.close();
		}
		return "home/index";
	}

	
	
	
	
	// Danh sách tin tức
	@RequestMapping("tin-tuc/{slugloaitintuc}")
	public String dstintuc(ModelMap model, @PathVariable("slugloaitintuc") String slugloaitintuc, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {

		Session session = factory.getCurrentSession();
		String hqllt = "from Loaitin where slug = :slugloaitintuc";
		Query querylt = session.createQuery(hqllt);
		querylt.setParameter("slugloaitintuc", slugloaitintuc);
		Loaitin loaitin = (Loaitin) querylt.uniqueResult();
		Integer idlt = loaitin.getIdloaitin();
		
		int total = 0, pageSize = 12;
		String hql = "from Chitiettin where idloaitin = :idlt";
		Query query = session.createQuery(hql);
		query.setParameter("idlt", idlt);

		total = query.list().size();
		query.setFirstResult(pageSize * (page - 1));
		query.setMaxResults(pageSize);
		int pageCount = (total) / pageSize + (total % pageSize > 0 ? 1 : 0);

		@SuppressWarnings("unchecked")
		List<Chitiettin> list = query.list();

		Loaitin lt = (Loaitin) session.get(Loaitin.class, idlt);
		String tenloaitin = lt.getLoaitin();

		model.addAttribute("title", tenloaitin);
		model.addAttribute("dslt", list);
		model.addAttribute("idloaitin", idlt);
		model.addAttribute("currentpage", page);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("pagecount", pageCount);

		return "home/tintuc_ds";
	}

	
	
	
	
	// Chi tiết tin tức
	@RequestMapping("tin-tuc/bai-viet/{slugbaiviet}")
	public String cttintuc(ModelMap model, @PathVariable("slugbaiviet") String slugbaiviet) {
		Session session = factory.getCurrentSession();
		String hql = "from Tintuc where slug = :slugbaiviet";
		Query query = session.createQuery(hql);
		query.setParameter("slugbaiviet", slugbaiviet);
		Tintuc tt = (Tintuc) query.uniqueResult();
		tt.setLuotxem(tt.getLuotxem() + 1);
		String tieude = tt.getTieude();

		model.addAttribute("cttt", tt);
		model.addAttribute("title", tieude);

		return "home/tintuc_ct";
	}

	
	
	
	
	// Chi tiết khách sạn
	@RequestMapping("khach-san/{slugkhachsan}")
	public String ctkhachsan(ModelMap model, @PathVariable("slugkhachsan") String slugkhachsan) {
		Session session = factory.getCurrentSession();
		//String hql = "from Khachsan where idkhachsan = :idks";
		String hql = "from Khachsan where slug = :slugkhachsan";
		Query query = session.createQuery(hql);
		query.setParameter("slugkhachsan", slugkhachsan);
		Khachsan ks = (Khachsan) query.uniqueResult();
		String tenkhachsan = ks.getTenkhachsan();
		Integer idtt = ks.getTinhthanh().getIdtinhthanh();
		Integer idks = ks.getIdkhachsan();

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
		
		model.addAttribute("dgs", dgs);
		model.addAttribute("listdgks", listdgks);
		model.addAttribute("lstkhachsan", listks);
		model.addAttribute("ctks", ks);
		model.addAttribute("title", tenkhachsan);

		return "home/khachsan";
	}
	
	
	
	
	
	// Chi tiết tour
	@RequestMapping("tour/{slugtour}")
	public String cttour(ModelMap model, @PathVariable("slugtour") String slugtour) {
		Session session = factory.getCurrentSession();
		String hql = "from Tour where slug = :slugtour";
		Query query = session.createQuery(hql);
		query.setParameter("slugtour", slugtour);
		Tour tour = (Tour) query.uniqueResult();
		String tentour = tour.getTentour();
		Integer idtt = tour.getTinhthanh().getIdtinhthanh();

		String hqlkstkv = "from Khachsan where idtinhthanh = :idtt";
		Query querykstkv = session.createQuery(hqlkstkv);
		querykstkv.setParameter("idtt", idtt);
		querykstkv.setMaxResults(12);
		@SuppressWarnings("unchecked")
		List<Khachsan> listks = querykstkv.list();

		model.addAttribute("lstkhachsan", listks);
		model.addAttribute("cttour", tour);
		model.addAttribute("title", tentour);

		return "home/tour";
	}
	
	
	
	

	// Chi tiết tỉnh thành
	@RequestMapping("tinh-thanh/{slugtinhthanh}")
	public String cttinhthanh(ModelMap model, @PathVariable("slugtinhthanh") String slugtinhthanh) {
		Session session = factory.getCurrentSession();
		String hql = "from Tinhthanh where slug = :slugtinhthanh";
		Query query = session.createQuery(hql);
		query.setParameter("slugtinhthanh", slugtinhthanh);
		Tinhthanh tihthanh = (Tinhthanh) query.uniqueResult();
		String tentinh = tihthanh.getTinhthanh();
		Integer idtth = tihthanh.getIdtinhthanh();
		
		String hqlksttt = "from Khachsan where idtinhthanh = :idtt";
		Query queryksttt = session.createQuery(hqlksttt);
		queryksttt.setParameter("idtt", idtth);
		queryksttt.setMaxResults(8);
		@SuppressWarnings("unchecked")
		List<Khachsan> listks = queryksttt.list();
		
		String hqltttt = "from Tour where diemden = :idtt";
		Query querytttt = session.createQuery(hqltttt);
		querytttt.setParameter("idtt", idtth);
		querytttt.setMaxResults(8);
		@SuppressWarnings("unchecked")
		List<Khachsan> listt = querytttt.list();

		model.addAttribute("listt", listt);
		model.addAttribute("listks", listks);
		model.addAttribute("title", tentinh);

		return "home/tinhthanh";
	}
	
	
	
	
	
	// Danh sách tỉnh thành
	@RequestMapping("tinh-thanh/danh-sach")
	public String dstinhthanh(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 12;
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
	
	
	
	
	
	
	
	
	
	
	// Tạo khách sạn mới
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "taokhachsan", method = RequestMethod.POST)
	public String taokhachsan(ModelMap model,
			@RequestParam("hinhanh") MultipartFile image,
			@RequestParam("tenkhachsan") String tenkhachsan,
			@RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("idtinhthanh") Integer idtinhthanh,
			@RequestParam("diachi") String diachi,
			@RequestParam("idtaikhoantao") Integer idtaikhoantao,
			@RequestParam("lstdichvu") List lstdichvu,
			@RequestParam("lstloaiphong") List lstloaiphong) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Khachsan ks = null;
		String hql = "from Khachsan where idtaikhoan = :idtaikhoan";
		Query query = session.createQuery(hql);
		query.setParameter("idtaikhoan", idtaikhoantao);
		ks = (Khachsan) query.uniqueResult();
		
		if(ks == null){
			String photoPath = context.getRealPath("/files/khachsan/" + image.getOriginalFilename());
			try {
				image.transferTo(new File(photoPath));
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			Date ngaydang = new Date();
			Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtaikhoantao);
			Tinhthanh tinhthanh = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
			Trangthai trangthai = (Trangthai) session.get(Trangthai.class, 2);
			String slugkhachsan = SlugsConverter.toSlug(tenkhachsan);
			
			Khachsan khachsan = new Khachsan(tenkhachsan, image.getOriginalFilename(), sodienthoai, diachi, taikhoan, ngaydang, tinhthanh, trangthai, slugkhachsan);
			
			try {
				session.save(khachsan);
				int idkhachsan = khachsan.getIdkhachsan();
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
				System.out.println("Them thanh cong!");
				return "home/index";
			} catch (Exception e) {
				t.rollback();
				System.out.println("Them that bai!");
			} finally {
				session.close();
			}
		} else {
			String tenks = ks.getTenkhachsan();
			System.out.println("Ban da co khach san ten : " +tenks+ "  Vui long cho xac minh");
		}
		
		return "home/index";
	}
	
	
	@RequestMapping(value = "danhgiakhachsan", method = RequestMethod.POST)
	public String danhgiakhachsan(ModelMap model, 
			HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("idtaikhoan") Integer idtaikhoan,
			@RequestParam("idkhachsan") Integer idkhachsan,
			@RequestParam("star") Integer star,
			@RequestParam("noidung") String noidung) {
		String referer = request.getHeader("Referer");
		Session session = factory.openSession();
		Date thoigiandanhgia = new Date();
		Khachsan khachsan = (Khachsan) session.get(Khachsan.class, idkhachsan);
		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtaikhoan);
		Danhgia danhgia = new Danhgia(khachsan, taikhoan, star, noidung, thoigiandanhgia);
		Transaction t = session.beginTransaction();
		try {
			session.save(danhgia);
			t.commit();
			redirectAttributes.addFlashAttribute("message", "danh gia thanh cong");
			return "redirect:"+ referer;
		} catch (Exception e) {
			t.rollback();
			redirectAttributes.addFlashAttribute("message", "danh gia that bai");
		} finally {
			session.close();
		}
		return "redirect:"+ referer;
	}
	
	
	
	
	// Trang đặt phòng
	@RequestMapping("dat-phong")
	public String datphong(ModelMap model, HttpSession httpsession,
			@RequestParam("khachsan") String slugkhachsan,
			@RequestParam("loaiphong") String slugloaiphong) {
		
		Session session = factory.getCurrentSession();
		
		String hqlks = "from Khachsan where slug = :slugkhachsan";
		Query queryks = session.createQuery(hqlks);
		queryks.setParameter("slugkhachsan", slugkhachsan);
		Khachsan khachsan = (Khachsan) queryks.uniqueResult();
		Integer idks = khachsan.getIdkhachsan();

		String hqllp = "from Loaiphong where slug = :slugloaiphong";
		Query querylp = session.createQuery(hqllp);
		querylp.setParameter("slugloaiphong", slugloaiphong);
		Loaiphong loaiphong = (Loaiphong) querylp.uniqueResult();
		
		String hqldgs = "from Danhgia where idkhachsan = :idks group by idkhachsan";
		Query querydgs = session.createQuery(hqldgs);
		querydgs.setParameter("idks", idks);
		Danhgia dgs = (Danhgia) querydgs.uniqueResult();
		
		model.addAttribute("title", "Đặt phòng");
		model.addAttribute("khachsan", khachsan);
		model.addAttribute("loaiphong", loaiphong);
		model.addAttribute("dgs", dgs);
		
		return "home/datphong";
	}
	@RequestMapping(value = "dat-phong-ks", method = RequestMethod.POST)
	public String datphong(ModelMap model, 
			HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("ngaynhanphong") String ngaynhanphong,
			@RequestParam("ngaytraphong") String ngaytraphong,
			@RequestParam("soluongphong") Integer soluongphong,
			@RequestParam("hodem") String hodem,
			@RequestParam("ten") String ten,
			@RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("email") String email,
			@RequestParam("idloaiphong") Integer idloaiphong,
			@RequestParam("idkhachsan") Integer idkhachsan) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date datenhanphong = df.parse(ngaynhanphong);
		Date datetraphong = df.parse(ngaytraphong);
		
		String referer = request.getHeader("Referer");
		Session session = factory.openSession();
		Khachsan khachsan = (Khachsan) session.get(Khachsan.class, idkhachsan);
		Loaiphong loaiphong = (Loaiphong) session.get(Loaiphong.class, idloaiphong);
		Trangthai trangthai = (Trangthai) session.get(Trangthai.class, 2);
		Datphong datphong = new Datphong(khachsan, loaiphong, trangthai, datenhanphong, datetraphong, soluongphong, hodem, ten, sodienthoai, email);
		Transaction t = session.beginTransaction();
		try {
			session.save(datphong);
			t.commit();
			System.out.println("Dat phong thanh cong");
			redirectAttributes.addFlashAttribute("message", "dat phong thanh cong");
			return "redirect:"+ referer;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Dat phong that bai");
			redirectAttributes.addFlashAttribute("message", "dat phong that bai");
		} finally {
			session.close();
		}
		return "redirect:"+ referer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping("thong-tin-tai-khoan")
	public String tttaikhoan(ModelMap model) {
		model.addAttribute("title", "Thông tin tài khoản");
		return "home/tttaikhoan";
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
	
	
	
	
	
	
	
	
	
	
	// ------------------- Send mail Controller -------------------------
	// ------------------------------------------------------------------

	// ------------------- Send Mail Lấy lại mật khẩu -------------------
	@RequestMapping(value = "passkeymailer", method = RequestMethod.POST)
	public String passkeymailer(ModelMap model, HttpServletRequest request, @RequestParam("email") String email)
			throws InvalidKeyException {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		String from = "kakaassasin123@gmail.com";
		String random = RandomString.randomString(20);
		EnDeCryption cryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
		String passmahoa = cryption.encoding(random);
		String subject = "Lấy Lại Mật Khẩu";
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/dat-lai-mat-khau/" + random;
		String body = "Nhấn vào đường dẫn để đặt lại mật khẩu :\n" + url;

		String hql = "from Taikhoan where email = :emailtk";
		Query query = session.createQuery(hql);
		query.setParameter("emailtk", email);
		Taikhoan tk = (Taikhoan) query.uniqueResult();
		tk.setMatkhau(passmahoa);

		try {
			session.update(tk);
			t.commit();
			// Gửi mail
			mailer.send(from, email, subject, body);
			System.out.println("thanh cong");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/index.html";
		} finally {
			session.close();
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
		String email = "fb" + me.getId() + "@mailcamnangdulich.com";
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
				
				taikhoan = new Taikhoan(email, matkhaumahoa, sdt, hinhanh, ngaytao, quyen, trt);
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
					model.addAttribute("login_check", 0);
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
        			taikhoan = new Taikhoan(email, matkhaumahoa, sdt, pictureUrl, ngaytao, quyen, trt);
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
        				model.addAttribute("login_check", 0);
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
