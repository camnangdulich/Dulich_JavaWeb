/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.InvalidKeyException;
import java.util.Date;

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

import entities.Quyen;
import entities.Taikhoan;
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

    @RequestMapping("index")
    public String index(ModelMap model) {
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
            } else {
//                httpSession.setAttribute("ssuser", tk);
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
