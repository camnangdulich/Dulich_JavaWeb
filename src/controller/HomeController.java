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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Danhgia;
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
    
    @SuppressWarnings("unchecked")
    @RequestMapping("index")
    public String index(ModelMap model, HttpSession httpsession,
			@RequestParam(value = "page", defaultValue = "1") int page) {
        model.addAttribute("title", "Cẩm nang du lịch");
        
		Session session = factory.getCurrentSession();
		int tthSize = 7, ttmSize = 8, ttxnSize = 8, dgksSize = 8, tourSize = 8;

		// Lấy thông tin tỉnh thành
		String hql_tth = "from Tinhthanh";
		Query query_tth = session.createQuery(hql_tth);

		// Lấy thông tin tin tức mới nhất
		String hql_ttm = "from Tintuc ORDER BY thoigian DESC";
		Query query_ttm = session.createQuery(hql_ttm);
		
		// Lấy tin tức có lượt xem nhiều nhất
		String hql_ttxn = "from Tintuc ORDER BY luotxem DESC";
		Query query_ttxn = session.createQuery(hql_ttxn);
		
		// Lấy đánh giá khách sạn có sao nhiều nhất
		String hql_dgks = "from Danhgia ORDER BY star DESC";
		Query query_dgks = session.createQuery(hql_dgks);
		
		// Lấy tour có lượt xem nhiều nhất
		String hql_tour = "from Tour ORDER BY luotxem DESC";
		Query query_tour = session.createQuery(hql_tour);

		query_tth.setFirstResult(tthSize * (page - 1));
		query_tth.setMaxResults(tthSize);

		query_ttm.setFirstResult(ttmSize * (page - 1));
		query_ttm.setMaxResults(ttmSize);
		
		query_ttxn.setFirstResult(ttxnSize * (page - 1));
		query_ttxn.setMaxResults(ttxnSize);
		
		query_dgks.setFirstResult(dgksSize * (page - 1));
		query_dgks.setMaxResults(dgksSize);
		
		query_tour.setFirstResult(tourSize * (page - 1));
		query_tour.setMaxResults(tourSize);

		List<Tinhthanh> lsttinhthanh = query_tth.list();
		List<Tintuc> lsttintucmoi = query_ttm.list();
		List<Tintuc> lsttinxemnhieu = query_ttxn.list();
		List<Danhgia> lstdanhgiakhachsan = query_dgks.list();
		List<Tour> lsttournoibat = query_tour.list();

		model.addAttribute("lsttinhthanh", lsttinhthanh);
		model.addAttribute("lsttintucmoi", lsttintucmoi);
		model.addAttribute("lsttinxemnhieu", lsttinxemnhieu);
		model.addAttribute("lstdanhgiakhachsan", lstdanhgiakhachsan);
		model.addAttribute("lsttournoibat", lsttournoibat);

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

    @RequestMapping("tinhthanh")
    public String tinhthanh(ModelMap model) {
        model.addAttribute("title", "Tỉnh thành");
        return "home/tinhthanh";
    }

    @RequestMapping("tintucds")
    public String tintucds(ModelMap model) {
        model.addAttribute("title", "Danh sách tin tức");
        return "home/tintuc_ds";
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

    @RequestMapping("datphong")
    public String datphong(ModelMap model) {
        model.addAttribute("title", "Đặt phòng");
        return "home/datphong";
    }

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
