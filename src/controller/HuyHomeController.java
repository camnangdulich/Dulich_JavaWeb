package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Datphong;
import entities.Dattour;
import entities.Loaiphong;
import entities.Tour;
import entities.Trangthai;

@Transactional
@Controller
@RequestMapping("/home/")
public class HuyHomeController {

	

    @Autowired
    SessionFactory factory;
    @Autowired
    ServletContext context;
   
 // --------------------- ModelAttribute -----------------------------
 		// ------------------------------------------------------------------
 // Lấy tất cả thông tin loại phòng
 		@ModelAttribute("loaiplist")
 		public List<Loaiphong> getlp(ModelMap model) {
 			Session session = factory.getCurrentSession();
 			String hql = "from Loaiphong";
 			Query query = session.createQuery(hql);
 			@SuppressWarnings("unchecked")
 			List<Loaiphong> list = query.list();
 			return list;
 		}
 		//Lấy tất cả thông tin tour
 		@ModelAttribute("tourlist")
 		public List<Tour> gett(ModelMap model) {
 			Session session = factory.getCurrentSession();
 			String hql = "from Tour";
 			Query query = session.createQuery(hql);
 			@SuppressWarnings("unchecked")
 			List<Tour> list = query.list();
 			return list;
 		}
    
 // --------------------- ADD Controller -----------------------------
 	// ------------------------------------------------------------------
// 	//Đặt phòng 
 		@RequestMapping("datphong")
 		public String datphong(ModelMap model) {
 			model.addAttribute("title", "Thêm công ty mới");
 			return "home/datphong";
 		}
 		
 		@RequestMapping(value = "datphong", method = RequestMethod.POST)
 		public String datphong(ModelMap model,
 				@RequestParam("loaiphong") Integer loaiphong,
 				@RequestParam("ngaynhanphong") String ngaynhanphong,
 				@RequestParam("ngaytraphong") String ngaytraphong,
 				@RequestParam("soluong") Integer soluong,
 				@RequestParam("hodem") String hodem,
 				@RequestParam("ten") String ten,
 				@RequestParam("sodienthoai") String sodienthoai,
 				@RequestParam("email") String email){
 			
 			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 			try {
 				Date ngaynhanDate = (Date)formatter.parse(ngaynhanphong);
 				Date ngaytraDate = (Date)formatter.parse(ngaytraphong);
 				Session session = factory.openSession();
 	 			Trangthai trang = (Trangthai) session.get(Trangthai.class, 2);
 	 			Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, loaiphong);
 	 			Date ngaytao = new Date();
 	 			Datphong dp = new Datphong(lp, trang, ngaynhanDate, ngaytraDate, soluong, hodem, ten, sodienthoai, email);
 	 			Transaction t = session.beginTransaction();
 	 			try {
 	 				session.save(dp);
 	 				t.commit();
 	 				model.addAttribute("message", "Đặt phòng thành công!");
 	 				return "home/datphong";
 	 			} catch (Exception e) {
 	 				t.rollback();
 	 				model.addAttribute("message", "Đặt phòng thất bại!");
 	 			} finally {
 	 				session.close();
 	 			}
 			} catch (ParseException e) {
 				e.printStackTrace();
 			}
 			
 			return "home/datphong";
 		}
 		
 		
 		
 		
 		//Đặt tour
 		@RequestMapping("dattour")
 		public String dattour(ModelMap model) {
 			model.addAttribute("title", "Đặt tour");
 			return "home/dattour";
 		}
 		
 		@RequestMapping(value = "dattour", method = RequestMethod.POST)
 		public String dattour(ModelMap model,
 				@RequestParam("tour") Integer tour,
 				@RequestParam("hodem") String hodem,
 				@RequestParam("ten") String ten,
 				@RequestParam("songuoi") Integer songuoi,
 				@RequestParam("sodienthoai") String sodienthoai,
 				@RequestParam("email") String email,
 				@RequestParam("yeucau") String yeucau){
 			

 				Session session = factory.openSession();
 	 			Trangthai trang = (Trangthai) session.get(Trangthai.class, 2);
 	 			Tour tuor = (Tour) session.get(Tour.class, tour);
 	 			Dattour dt = new Dattour(tuor, trang,  hodem, ten, songuoi, sodienthoai, email, yeucau);
 	 			Transaction t = session.beginTransaction();
 	 			try {
 	 				session.save(dt);
 	 				t.commit();
 	 				model.addAttribute("message", "Đặt tour thành công!");
 	 				return "home/dattour";
 	 			} catch (Exception e) {
 	 				t.rollback();
 	 				model.addAttribute("message", "Đặt tour thất bại!");
 	 			} finally {
 	 				session.close();
 	 			}
 			
 			return "home/dattour";
 		}
}


