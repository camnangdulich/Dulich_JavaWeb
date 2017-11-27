/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.InvalidKeyException;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Chitiettin;
import entities.Danhgia;
import entities.Loaitin;
import entities.Quyen;
import entities.Taikhoan;
import entities.Tinhthanh;
import entities.Tintuc;
import entities.Tour;
import entities.Trangthai;
import model.EnDeCryption;

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
    
	// --------------------- Home Index Show ----------------------------
	// ------------------------------------------------------------------
    
	// Lấy thông tin tỉnh thành
	@ModelAttribute("lsttinhthanh")
	public List<Tinhthanh> lsttinhthanh(ModelMap model) {
		Session session = factory.getCurrentSession();
		int tthSize = 7;
		String hql_tth = "from Tinhthanh";
		Query query_tth = session.createQuery(hql_tth);
		query_tth.setMaxResults(tthSize);
		@SuppressWarnings("unchecked")
		List<Tinhthanh> lsttinhthanh = query_tth.list();
		return lsttinhthanh;
	}
	
	// Lấy thông tin tin tức mới nhất
	@ModelAttribute("lsttintucmoi")
	public List<Tintuc> lsttintucmoi(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 8;
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";
		Query query_ttm = session.createQuery(hql_ttm);
		query_ttm.setMaxResults(ttmSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttintucmoi = query_ttm.list();
		return lsttintucmoi;
	}
	
	// Lấy thông tin tin tức mới nhất SIBAR
	@ModelAttribute("lstsibarttm")
	public List<Tintuc> lstsibarttm(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttmSize = 3;
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";
		Query query_ttm = session.createQuery(hql_ttm);
		query_ttm.setMaxResults(ttmSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lstsibarttm = query_ttm.list();
		return lstsibarttm;
	}
	
	// Lấy tin tức có lượt xem nhiều nhất
	@ModelAttribute("lsttinxemnhieu")
	public List<Tintuc> lsttinxemnhieu(ModelMap model) {
		Session session = factory.getCurrentSession();
		int ttxnSize = 8;
		String hql_ttxn = "from Tintuc ORDER BY luotxem DESC";
		Query query_ttxn = session.createQuery(hql_ttxn);
		query_ttxn.setMaxResults(ttxnSize);
		@SuppressWarnings("unchecked")
		List<Tintuc> lsttinxemnhieu = query_ttxn.list();
		return lsttinxemnhieu;
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
		String hql_dgks = "from Danhgia ORDER BY star DESC";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	// --------------------- PAGE Controller ----------------------------
	// ------------------------------------------------------------------
    
    @RequestMapping("index")
    public String index(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
        model.addAttribute("title", "Cẩm nang du lịch");
        return "home/index";
    }

    // Đăng nhập
    @RequestMapping(value = "dangnhap", method = RequestMethod.POST)
    public String dangnhap(ModelMap model,
            @RequestParam("login_email") String email,
            @RequestParam("login_password") String pwd,
            HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) throws InvalidKeyException {

        Session session = factory.getCurrentSession();
        Taikhoan tk = null;
        try {
            String hql = "from Taikhoan where email = :emailtk";
            Query query = session.createQuery(hql);
            query.setParameter("emailtk", email);
            tk = (Taikhoan) query.uniqueResult();
            
            // Password encryption
    		EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
            String Matkhaumahoa = encryption.encoding(pwd);
            
            if (!tk.getMatkhau().equals(Matkhaumahoa)) {
            	System.out.println("dang nhap that bai");
            	model.addAttribute("title", "Cẩm nang du lịch");
                model.addAttribute("message", "dang nhap that bai");
                return "home/index";
            } else if (tk.getTrangthai().getIdtrangthai() == 2) {
            	System.out.println("tai khoan chua kich hoat");
            	model.addAttribute("title", "Cẩm nang du lịch");
                model.addAttribute("message", "tai khoan chua kich hoat");
                return "home/index";
            } else if(tk.getTrangthai().getIdtrangthai() == 3){
            	System.out.println("tai khoan bi khoa");
            	model.addAttribute("title", "Cẩm nang du lịch");
                model.addAttribute("message", "tai khoan bi khoa");
                return "home/index";
            } else {
            	httpSession.setAttribute("loguser", tk);
            	System.out.println("dang nhap thanh cong");
            	model.addAttribute("title", "Cẩm nang du lịch");
                model.addAttribute("message", "dang nhap thanh cong");
            }
        } catch (Exception e) {
        	System.out.println("dang nhap that bai");
        	model.addAttribute("title", "Cẩm nang du lịch");
            model.addAttribute("message", "dang nhap that bai");
            return "home/index";
        }
        return "home/index";
    }
    
	// Đăng xuất
	@RequestMapping("dangxuat")
	public String dangxuat(HttpSession httpSession) {
		httpSession.removeAttribute("loguser");
		return "redirect:/home/index.html";
	}
    
	// Đăng ký (register form)
	@RequestMapping(value = "dangky", method = RequestMethod.POST)
	public String Register(ModelMap model, 
			@RequestParam("reg_email") String email,
			@RequestParam("reg_matkhau") String matkhau,
			@RequestParam("reg_sdt") String sdt) throws InvalidKeyException {

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
			//model.addAttribute("u", user); // Auto login
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
	@RequestMapping("tin-tuc/{id}")
	public String dstintuc(ModelMap model, @PathVariable("id") Integer idlt, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		
		Session session = factory.getCurrentSession();
		int total = 0, pageSize = 10;
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
	@RequestMapping("tin-tuc/bai-viet/{id}")
	public String cttintuc(ModelMap model, @PathVariable("id") Integer idtt) {
		Session session = factory.getCurrentSession();
		String hql = "from Tintuc where idtintuc = :idtt";
        Query query = session.createQuery(hql);
        query.setParameter("idtt", idtt);
        Tintuc tt = (Tintuc) query.uniqueResult();
        String tieude = tt.getTieude();
        
		model.addAttribute("cttt", tt);
		model.addAttribute("title", tieude);
		
		return "home/tintuc_ct";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    @RequestMapping("tinhthanh")
    public String tinhthanh(ModelMap model) {
        model.addAttribute("title", "Tỉnh thành");
        return "home/tinhthanh";
    }


    @RequestMapping("tintucct")
    public String tintucct(ModelMap model) {
        model.addAttribute("title", "Chi tiết tin tức");
        return "home/tintuc_ct";
    }

    @RequestMapping("tour")
    public String tour(ModelMap model) {
        model.addAttribute("title", "Tour du lịch");
        return "home/tour";
    }

    @RequestMapping("khachsan")
    public String khachsan(ModelMap model) {
        model.addAttribute("title", "Khách sạn");
        return "home/khachsan";
    }

//    @RequestMapping("datphong")
//    public String datphong(ModelMap model) {
//        model.addAttribute("title", "Đặt phòng");
//        return "home/datphong";
//    }

    @RequestMapping("tttaikhoan")
    public String tttaikhoan(ModelMap model) {
        model.addAttribute("title", "Thông tin tài khoản");
        return "home/tttaikhoan";
    }

    @RequestMapping("gioithieu")
    public String gioithieu(ModelMap model) {
        model.addAttribute("title", "Giới thiệu");
        return "home/gioithieu";
    }

    @RequestMapping("phanhoi")
    public String phanhoi(ModelMap model) {
        model.addAttribute("title", "Phản hồi");
        return "home/phanhoi";
    }
    
    
    
    
}
