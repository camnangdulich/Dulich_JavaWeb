/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
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

import model.EnDeCryption;
import model.SlugsConverter;
import entities.Quyen;
import entities.Taikhoan;
import entities.Tintuc;
import entities.Tour;
import entities.Loaitin;
import entities.Chitiettin;
import entities.Congty;
import entities.Datphong;
import entities.Trangthai;
import entities.Khachsan;
import entities.Loaiphong;
import entities.Tinhthanh;
import entities.Chitietdichvu;
import entities.Dichvu;
import entities.Huong;

/**
 *
 * @author DuongNguyen
 */
@Transactional
@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;

	// --------------------- ModelAttribute -----------------------------
	// ------------------------------------------------------------------
	
	// Lấy tất cả thông tin tài khoản
	@ModelAttribute("tklist")
	public List<Taikhoan> gettk(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Taikhoan";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Taikhoan> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin quyền
	@ModelAttribute("qlist")
	public List<Quyen> getq(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Quyen";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Quyen> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin bài viết (Bảng Tintuc)
	@ModelAttribute("bvlist")
	public List<Tintuc> getbv(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tintuc";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Tintuc> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin chi tiết bài viết
	@ModelAttribute("ctbvlist")
	public List<Chitiettin> getctbv(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Chitiettin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Chitiettin> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin loại bài viết
	@ModelAttribute("lbvlist")
	public List<Loaitin> getlbv(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaitin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Loaitin> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin khách sạn
	@ModelAttribute("kslist")
	public List<Khachsan> getks(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Khachsan";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Khachsan> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin trạng thái
	@ModelAttribute("trtlist")
	public List<Trangthai> gettrt(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Trangthai";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Trangthai> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin tinh thanh
	@ModelAttribute("tthlist")
	public List<Tinhthanh> gettth(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tinhthanh";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Tinhthanh> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin chi tiết dịch vụ
	@ModelAttribute("ctdvlist")
	public List<Chitietdichvu> getctdv(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Chitietdichvu";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Chitietdichvu> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin dịch vụ
	@ModelAttribute("dvlist")
	public List<Dichvu> getdv(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Dichvu";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Dichvu> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin loại phòng
	@ModelAttribute("lplist")
	public List<Loaiphong> getlp(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaiphong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Loaiphong> list = query.list();
		return list;
	}
	
	// Lấy tất cả thông tin tỉnh thành
	@ModelAttribute("ttlist")
	public List<Tinhthanh> gettt(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tinhthanh";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Tinhthanh> list = query.list();
		return list;
	}
	// Lấy tất cả thông tin công ty
	@ModelAttribute("ctlist")
	public List<Congty> getct(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Congty";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Congty> list = query.list();
		return list;
	}
	// Lấy thông tin Tour
	@ModelAttribute("tulist")
	public List<Tour> gettu(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Tour";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Tour> list = query.list();
		return list;
	}
	//Lấy tất cả thông tin hướng
	@ModelAttribute("hulist")
	public List<Huong> geth(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Huong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Huong> list = query.list();
		return list;
	}
	//Lấy tất thông tin đặt phòng
	@ModelAttribute("dlist")
	public List<Datphong> getd(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Datphong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Datphong> list = query.list();
		return list;
	}
	
	
	// --------------------- PAGE Controller ----------------------------
	// ------------------------------------------------------------------
	
	// Trang điều khiển
	@RequestMapping("index")
	public String index(ModelMap model) {
		model.addAttribute("title", "Điều khiển");
		return "admin/index";
	}
	
	// Trang danh sách tài khoản
	@RequestMapping("dstaikhoan")
	public String taikhoands(ModelMap model) {
		model.addAttribute("title", "Danh sách tài khoản");
		return "admin/dstaikhoan";
	}
	
	// Trang danh sách quyền
	@RequestMapping("dsquyen")
	public String dsquyen(ModelMap model) {
		model.addAttribute("title", "Danh sách quyền");
		return "admin/dsquyen";
	}

	// Trang danh sách bài viết
	@RequestMapping("dsbaiviet")
	public String dsbaiviet(ModelMap model) {
		model.addAttribute("title", "Danh sách bài viết");
		return "admin/dsbaiviet";
	}
	
	// Trang danh sách khách sạn
	@RequestMapping("dskhachsan")
	public String dskhachsan(ModelMap model) {
		model.addAttribute("title", "Danh sách khách sạn");
		return "admin/dskhachsan";
	}
	
	// Trang loại bài viết
	@RequestMapping("dsloaibv")
	public String dsloaibv(ModelMap model) {
		model.addAttribute("title", "Danh loại bài viết");
		return "admin/dsloaibv";
	}
	
	// Trang loại phòng
	@RequestMapping("dsloaiphong")
	public String dsloaiphong(ModelMap model) {
		model.addAttribute("title", "Danh loại phòng");
		return "admin/dsloaiphong";
	}
	
	// Quản lý tỉnh thành 
	@RequestMapping("dstinhthanh")
	public String dstinhthanh(ModelMap model) {
		model.addAttribute("title", "Danh sách tỉnh thành");
		return "admin/dstinhthanh";
	}
	
	// Trang quản lý công ty
	@RequestMapping("dscongty")
	public String dscongty(ModelMap model) {
		model.addAttribute("title", "Danh sách công ty");
		return "admin/dscongty";
	}
	
	// Trang danh sách dịch vụ
	@RequestMapping("dsdichvu")
	public String dsdichvu(ModelMap model) {
		model.addAttribute("title", "Danh sách dịch vụ");
		return "admin/dsdichvu";
	}
	
	// Trang tour du lịch
	@RequestMapping("dstour")
	public String dstour(ModelMap model) {
		model.addAttribute("title", "Danh sách tour");
		return "admin/dstour";
	}
	//Trang danh sách đặt phòng
	@RequestMapping("dsdatphong")
	public String dsdatphong(ModelMap model) {
		model.addAttribute("title", "Danh sách đặt phòng");
		return "admin/dsdatphong";
	}
	
	
	
	// --------------------- ADD Controller -----------------------------
	// ------------------------------------------------------------------

	// Thêm tài khoản mới
	@RequestMapping("ttaikhoan")
	public String ttaikhoan(ModelMap model) {
		model.addAttribute("title", "Thêm tài khoản mới");
		return "admin/ttaikhoan";
	}
	
	@RequestMapping(value = "ttaikhoan", method = RequestMethod.POST)
	public String ttaikhoan(ModelMap model,
			@RequestParam("quyen") Integer quyen,
			@RequestParam("email") String email,
			@RequestParam("matkhau") String matkhau,
			@RequestParam("sdt") String sdt) throws InvalidKeyException {

		if(kiemtraEmail(email)){
			System.out.println("Email ton tai >< stop");
			model.addAttribute("title", "Thêm tài khoản mới");
			model.addAttribute("message", "email ton tai");
			return "admin/ttaikhoan";
		} else {
			System.out.println("Email khong ton tai >> next");
			Session session = factory.openSession();
			Date ngaytao = new Date();
			Quyen rl = (Quyen) session.get(Quyen.class, quyen);
			Trangthai trt = (Trangthai) session.get(Trangthai.class, 2);
			
			// Password encryption
			EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
	        String Matkhaumahoa = encryption.encoding(matkhau);

			Taikhoan tk = new Taikhoan(email, Matkhaumahoa, sdt, "av1.png", ngaytao, rl, trt);
			Transaction t = session.beginTransaction();
			try {
				session.save(tk);
				t.commit();
				System.out.println("Them tai khoan thanh cong");
				model.addAttribute("title", "Thêm tài khoản mới");
				model.addAttribute("message", "them tai khoan thanh cong");
				return "admin/ttaikhoan";
			} catch (Exception e) {
				t.rollback();
				System.out.println("Them tai khoan that bai");
				model.addAttribute("title", "Thêm tài khoản mới");
				model.addAttribute("message", "them tai khoan that bai");
			} finally {
				session.close();
			}
		}
		return "admin/ttaikhoan";
	}
	// ------------------------------------------------------------------
	
	
	// Thêm quyền mới
	@RequestMapping("tquyen")
	public String tquyen(ModelMap model) {
		model.addAttribute("title", "Thêm quyền mới");
		return "admin/tquyen";
	}
	
	@RequestMapping(value = "tquyen", method = RequestMethod.POST)
	public String ttaikhoan(ModelMap model,
			@RequestParam("tenquyen") String tenquyen,
			@RequestParam("mota") String mota) {

		if(kiemtraQuyen(tenquyen)){
			model.addAttribute("message", "quyen da ton tai");
			model.addAttribute("title", "Thêm quyền mới");
			return "admin/tquyen";
		} else {
			Session session = factory.openSession();
			Quyen q = new Quyen(tenquyen, mota);
			Transaction t = session.beginTransaction();
			try {
				session.save(q);
				t.commit();
				model.addAttribute("message", "them quyen thanh cong");
				model.addAttribute("title", "Thêm quyền mới");
				return "admin/tquyen";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "them quyen that bai");
				model.addAttribute("title", "Thêm quyền mới");
			} finally {
				session.close();
			}
		}
		return "admin/tquyen";
	}
	
	// ------------------------------------------------------------------
	
	
	// Thêm bài viết mới (Tin tức mới)
	@RequestMapping("tbaiviet")
	public String tbaiviet(ModelMap model) {
		model.addAttribute("title", "Thêm bài viết mới");
		return "admin/tbaiviet";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "tbaiviet", method = RequestMethod.POST)
	public String tbaiviet(ModelMap model,
			@RequestParam("hinhanh") MultipartFile image,
			@RequestParam("idtk") Integer idtk,
			@RequestParam("tieude") String tieude,
			@RequestParam("tomtat") String tomtat,
			@RequestParam("noidung") String noidung,
			@RequestParam("nguon") String nguon,
			@RequestParam("loaitin") List loaitin) {

		// Tạo session
		Session session = factory.openSession();
		
		// Tạo đường dẫn hình ảnh lưu vào biến photoPath
		String photoPath = context.getRealPath("/files/tintuc/" + image.getOriginalFilename());
		
		// Lưu hình ảnh
		try {
			image.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Tạo ngày đăng bài viết mới
		Date ngaydang = new Date();
		
		// Lấy tài khoản theo idtk
		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtk);
		
		// Tạo tin tức mới với các thông tin của tin tức
		Tintuc tintuc = new Tintuc(taikhoan, image.getOriginalFilename(), tieude, tomtat, noidung, ngaydang, nguon);
		
		// Khởi tạo Transaction
		Transaction t = session.beginTransaction();
		
		try {
			
			// Lưu tin tức vào session
			session.save(tintuc);
			
			// Lấy idtintuc mới tạo
			int idtintuc = tintuc.getIdtintuc();
			
			// Lấy tin tức theo idtintuc
			Tintuc tt = (Tintuc) session.get(Tintuc.class, idtintuc);
			
			// Lấy loại tin tức mới
			Loaitin ltm = (Loaitin) session.get(Loaitin.class, 1);
			
			// Lưu tin tức với loại tin mới
			Chitiettin cttm = new Chitiettin(ltm, tt);
			session.save(cttm);
			
			// Vòng lặp lấy lưu thông tin các loại tin tức
			for ( int x = 0; x < loaitin.size(); x++ ){
				
				// Lấy idloaitin của từng loại tin
				Object oj_idloaitin = loaitin.get(x);
				
				// Chuyển kiểu của từng idloaitin sang int
				int idloaitin = Integer.valueOf((String) oj_idloaitin);
				
				// Lấy loại tin theo idloaitin
				Loaitin lt = (Loaitin) session.get(Loaitin.class, idloaitin);
				
				// Tạo mới Chitiettin với các thông tin cần lưu
				Chitiettin ctt = new Chitiettin(lt, tt);
				
				try {
					// Lưu Chitiettin vào session
					session.save(ctt);
				} catch (Exception e) {
					// Hủy tất cả thay đổi thực thi truy vấn
					t.rollback();
				}
			}
			
			// Thực thi lưu vào database với các session đã lưu
			t.commit();
			
			// Thông báo thực thi thành công
			System.out.println("Them thanh cong!");
			
			// Chuyển về trang thêm bài viết
			return "admin/tbaiviet";
			
		} catch (Exception e) {
			// Hủy tất cả thay đổi thực thi truy vấn
			t.rollback();
			// Thông báo thực thi thất bại (lỗi)
			model.addAttribute("message", "Thêm loại sản phẩm thất bại!");
		} finally {
			// Đóng session
			session.close();
		}
		
		// Chuyển về trang thêm bài viết
		return "admin/tbaiviet";
	}
	// ------------------------------------------------------------------
	
	
	// Thêm khách sạn mới
//	@RequestMapping("tkhachsan")
//	public String tkhachsan(ModelMap model) {
//		model.addAttribute("title", "Thêm khách sạn");
//		return "admin/tkhachsan";
//	}
//	
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value = "tkhachsan", method = RequestMethod.POST)
//	public String tkhachsan(ModelMap model,
//			@RequestParam("hinhanh") MultipartFile image,
//			@RequestParam("idtk") Integer idtk,
//			@RequestParam("tenks") String tenks,
//			@RequestParam("dichvu") List dichvu,
//			@RequestParam("tinhthanh") Integer idtinhthanh,
//			@RequestParam("diachi") String diachi,
//			@RequestParam("sdt") String sdt,
//			@RequestParam("trangthai") Integer idtrangthai) {
//
//		Session session = factory.openSession();
//		
//		// Tạo đường dẫn hình ảnh lưu vào biến photoPath
//		String photoPath = context.getRealPath("/files/khachsan/" + image.getOriginalFilename());
//		
//		// Lưu hình ảnh
//		try {
//			image.transferTo(new File(photoPath));
//		} catch (IllegalStateException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// Tạo ngày đăng khách sạn
//		Date ngaydang = new Date();
//		
//		// Lấy tài khoản, tỉnh thành, trạng thái theo id
//		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtk);
//		Tinhthanh tth = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
//		Trangthai trt = (Trangthai) session.get(Trangthai.class, idtrangthai);
//		
//		// Tạo khách sạn mới với các thông tin của khách sạn
//		Khachsan khs = new Khachsan(taikhoan, tth, trt, tenks, image.getOriginalFilename(), sdt, diachi, ngaydang);
//		
//		Transaction t = session.beginTransaction();
//		
//		try {
//			
//			// Lưu khách sạn vào session
//			session.save(khs);
//			
//			// Lấy idkhachsan mới tạo
//			int idkhachsan = khs.getIdkhachsan();
//			
//			// Lấy khách sạn và dịch vụ theo id
//			Khachsan ks = (Khachsan) session.get(Khachsan.class, idkhachsan);
//			Dichvu dv = (Dichvu) session.get(Dichvu.class, 1);
//			
//			// Lưu khách sạn với dịch vụ trên
//			Chitietdichvu ctdv = new Chitietdichvu(dv, ks);
//			session.save(ctdv);
//			
//			// Vòng lặp lấy lưu thông tin các loại dịch vụ khác
//			for ( int x = 0; x < dichvu.size(); x++ ){
//				
//				// Lấy iddichvu của từng loại dịch vụ
//				Object oj_iddichvu = dichvu.get(x);
//				
//				// Chuyển kiểu của từng iddichvu sang int
//				int iddichvu = Integer.valueOf((String) oj_iddichvu);
//				
//				// Lấy dịch vụ theo iddichvu
//				Dichvu dhv = (Dichvu) session.get(Dichvu.class, iddichvu);
//				
//				// Tạo mới Chitietdichvu với các thông tin cần lưu
//				Chitietdichvu chtdv = new Chitietdichvu(dhv, ks);
//				
//				try {
//					session.save(chtdv);
//				} catch (Exception e) {
//					t.rollback();
//				}
//			}
//			t.commit();
//			System.out.println("Them thanh cong!");
//			return "admin/tkhachsan";
//		} catch (Exception e) {
//			t.rollback();
//			System.out.println("Them that bai!");
//		} finally {
//			session.close();
//		}
//		return "admin/tkhachsan";
//	}
	// ------------------------------------------------------------------
	
	
	// Thêm loai phòng
	@RequestMapping("tloaiphong")
	public String tloaiphong(ModelMap model) {
		model.addAttribute("title", "Thêm loại phòng mới");
		return "admin/tloaiphong";
	}
	
	@RequestMapping(value = "tloaiphong", method = RequestMethod.POST)
	public String tloaiphong(ModelMap model,
			@RequestParam("tenloai") String tenloai,
			@RequestParam("mota") String mota,
			@RequestParam("themgiuong") Integer themgiuong,
			@RequestParam("huong") Integer idhuong,
			@RequestParam("hinhanh") MultipartFile hinhanh,
			@RequestParam("gia") Integer gia) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Huong huong = (Huong) session.get(Huong.class, idhuong);
		
		// Tạo đường dẫn lưu hình ảnh
		String photoPath = "";
		if(hinhanh.getOriginalFilename().equals("")){
			photoPath = context.getRealPath("/files/phong/Connecting room.jpg");
		} else {
			photoPath = context.getRealPath("/files/phong/" + hinhanh.getOriginalFilename());
		}
		
		// Lưu hình ảnh
		try {
			hinhanh.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(hinhanh.getOriginalFilename().equals("")){
			Loaiphong lp = new Loaiphong(tenloai, mota, themgiuong, huong, "Connecting room.jpg", gia);
			try {
				session.save(lp);
				t.commit();
				model.addAttribute("message", "Thêm loại phòng thành công!");
				return "admin/tloaiphong";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm loại phòng thất bại!");
			} finally {
				session.close();
			}

		} else {
			Loaiphong lp = new Loaiphong(tenloai, mota, themgiuong, huong, hinhanh.getOriginalFilename(), gia);
			try {
				session.save(lp);
				t.commit();
				model.addAttribute("message", "Thêm loại phòng thành công!");
				return "admin/tloaiphong";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm loại phòng thất bại!");
			} finally {
				session.close();
			}

		}
		return "admin/tloaiphong";
	}
	
	// ------------------------------------------------------------------
	
	
	// Thêm tỉnh thành
	@RequestMapping("ttinhthanh")
	public String ttinhthanh(ModelMap model) {
		model.addAttribute("title", "Thêm tỉnh thành mới");
		return "admin/ttinhthanh";
	}
	
	@RequestMapping(value = "ttinhthanh", method = RequestMethod.POST)
	public String ttaikhoan(ModelMap model,
			@RequestParam("hinhanh") MultipartFile hinhanh,
			@RequestParam("tentinh") String tentinh,
			@RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		// Tao duong dan luu hinh anh
		String photoPath = "";
		if(hinhanh.getOriginalFilename().equals("")){
			photoPath = context.getRealPath("/files/tinhthanh/Connecting room.jpg");
		} else {
			photoPath = context.getRealPath("/files/phong/" + hinhanh.getOriginalFilename());
		}
		
		// Luu hình anh
		try {
			hinhanh.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(hinhanh.getOriginalFilename().equals("")){
			Tinhthanh tinh = new Tinhthanh(hinhanh.getOriginalFilename(), tentinh, mota);
			try {
				session.save(tinh);
				t.commit();
				model.addAttribute("message", "Thêm tỉnh thành công!");
				return "admin/ttinhthanh";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm tỉnh thất bại!");
			} finally {
				session.close();
			}

		} else {
			Tinhthanh tinh = new Tinhthanh(hinhanh.getOriginalFilename(), tentinh, mota);
			try {
				session.save(tinh);
				t.commit();
				model.addAttribute("message", "Thêm tỉnh thành công!");
				return "admin/ttinhthanh";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm tỉnh thất bại!");
			} finally {
				session.close();
			}

		}
		return "admin/ttinhthanh";
	}
	// ------------------------------------------------------------------
	
	
	// Thêm công ty mới
//	@RequestMapping("tcongty")
//	public String tcongty(ModelMap model) {
//		model.addAttribute("title", "Thêm công ty mới");
//		return "admin/tcongty";
//	}
//	
//	@RequestMapping(value = "tcongty", method = RequestMethod.POST)
//	public String tcongty(ModelMap model,
//			@RequestParam("tencongty") String tencongty,
//			@RequestParam("diachi") String diachi,
//			@RequestParam("mota") String mota,
//			@RequestParam("email") String email,
//			@RequestParam("sodienthoai") String sodienthoai){
//
//		Session session = factory.openSession();
//		Date ngaytao = new Date();
//		Congty c = new Congty(tencongty, diachi, email, sodienthoai, ngaytao);
//		Transaction t = session.beginTransaction();
//		try {
//			session.save(c);
//			t.commit();
//			model.addAttribute("message", "Thêm công ty thành công!");
//			return "admin/tcongty";
//		} catch (Exception e) {
//			t.rollback();
//			model.addAttribute("message", "Thêm công ty thất bại!");
//		} finally {
//			session.close();
//		}
//		return "admin/tcongty";
//	}
	// ------------------------------------------------------------------
	
	
	// Thêm dịch vụ mới
	@RequestMapping("tdichvu")
	public String tdichvu(ModelMap model) {
		model.addAttribute("title", "Thêm dịch vụ mới");
		return "admin/tdichvu";
	}
	
	@RequestMapping(value = "tdichvu", method = RequestMethod.POST)
	public String tdichvu(ModelMap model,
			@RequestParam("tendichvu") String tendichvu,
			@RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Dichvu d = new Dichvu(tendichvu, mota);
		Transaction t = session.beginTransaction();
		try {
			session.save(d);
			t.commit();
			model.addAttribute("message", "Thêm dịch vụ thành công!");
			return "admin/tdichvu";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm dịch vụ thất bại!");
		} finally {
			session.close();
		}
		return "admin/tdichvu";
	}
	
	
	// --------------------- EDIT Controller ----------------------------
	// ------------------------------------------------------------------
	
	// Sửa thông tin tài khoản
	@RequestMapping("staikhoan/{id}")
	public String staikhoan(ModelMap model, @PathVariable("id") Integer idtk) {
		model.addAttribute("title", "Sửa tài khoản");
		Session session = factory.getCurrentSession();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, idtk);
		model.addAttribute("user", tk);
		return "admin/staikhoan";
	}
	
	@RequestMapping(value = "updatetk", method = RequestMethod.POST )
	public String staikhoan(ModelMap model,
			@RequestParam("idtk") Integer idtk,
			@RequestParam("quyen") Integer quyen,
			@RequestParam("email") String email,
			@RequestParam("matkhau") String matkhau,
			@RequestParam("sdt") String sdt,
			@RequestParam("hodem") String hodem,
			@RequestParam("ten") String ten,
			@RequestParam("diachi") String diachi,
			@RequestParam("avatar") MultipartFile image){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, idtk);
		Quyen rl = (Quyen) session.get(Quyen.class, quyen);
		String photoPath = context.getRealPath("/files/" + image.getOriginalFilename());
		
		tk.setQuyen(rl);
		tk.setEmail(email);
		tk.setMatkhau(matkhau);
		tk.setSodienthoai(sdt);
		tk.setHodem(hodem);
		tk.setTen(ten);
		tk.setDiachi(diachi);
		
		try {
			if(image.getOriginalFilename().equals("")){
				session.update(tk);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong khong them anh");
				return "redirect:/admin/staikhoan/"+idtk+".html";
			}else{
				image.transferTo(new File(photoPath));
				tk.setAvatar(image.getOriginalFilename());
				session.update(tk);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong co them anh");
				return "redirect:/admin/staikhoan/"+idtk+".html";
			}
		} 
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/tintuc/"+idtk+".html";
		}
		finally {
			session.close();
		}
	}
	// ------------------------------------------------------------------

	// Sửa thông tin quyền
	@RequestMapping("squyen/{id}")
	public String squyen(ModelMap model, @PathVariable("id") Integer idquyen) {
		model.addAttribute("title", "Sửa quyền");
		Session session = factory.getCurrentSession();
		Quyen q = (Quyen) session.get(Quyen.class, idquyen);
		model.addAttribute("role", q);
		return "admin/squyen";
	}
	
	@RequestMapping(value = "squyen", method = RequestMethod.POST )
	public String squyen(ModelMap model,
			@RequestParam("idquyen") Integer idquyen,
			@RequestParam("tenquyen") String tenquyen,
			@RequestParam("mota") String mota){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Quyen q = (Quyen) session.get(Quyen.class, idquyen);
		q.setQuyen(tenquyen);
		q.setMota(mota);
		try {
			session.update(q);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa quyền thành công !");
			return "redirect:/admin/squyen/"+idquyen+".html";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa quyền thất bại !" + e.getMessage());
			System.out.println("Thất bại");
			return "redirect:/admin/tintuc/"+idquyen+".html";
		}finally {
			session.close();
		}
	}
	
	// ------------------------------------------------------------------

	
	//Sửa thông tin loại phòng
	@RequestMapping("sloaiphong/{id}")
	public String sloaiphong(ModelMap model, @PathVariable("id") Integer idlp) {
		model.addAttribute("title", "Sửa loại phòng");
		Session session = factory.getCurrentSession();
		Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, idlp);
		
		model.addAttribute("lstlp", lp);
		return "admin/sloaiphong";
	}
	
	@RequestMapping(value = "sloaiphong", method = RequestMethod.POST )
	public String sloaiphong(ModelMap model,
			@RequestParam("idlp") Integer idlp,
			@RequestParam("tenloai") String tenloai,
			@RequestParam("mota") String mota,
			@RequestParam("themgiuong") Integer themgiuong,
			@RequestParam("huong") Integer idhuong,
			@RequestParam("hinhanh") MultipartFile hinhanh,
			@RequestParam("gia") Integer gia){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String photoPath = context.getRealPath("/files/phong/" + hinhanh.getOriginalFilename());
		Huong hg = (Huong) session.get(Huong.class, idhuong);
		Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, idlp);
		
		lp.setTenloai(tenloai);;
		lp.setMota(mota);
		lp.setThemgiuong(themgiuong);
		lp.setGia(gia);
		lp.setHuong(hg);
		try {
			if(hinhanh.getOriginalFilename().equals("")){
				session.update(lp);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa loại phòng thành công !");
				System.out.println("Thành công không thêm ảnh");
				return "redirect:/admin/sloaiphong/"+idlp+".html";
			}else{
				hinhanh.transferTo(new File(photoPath));
				lp.setHinhanh(hinhanh.getOriginalFilename());
				session.update(lp);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa loại phòng thành công !");
				System.out.println("Thành công có ảnh");
				return "redirect:/admin/sloaiphong/"+idlp+".html";
			}
		} 
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa loại phòng thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/tintuc/"+idlp+".html";
		}
		finally {
			session.close();
		}
	}
	
	// ------------------------------------------------------------------
	
	//Sua thông tin công ty
	@RequestMapping("scongty/{id}")
	public String scongty(ModelMap model, @PathVariable("id") Integer idcongty) {
		model.addAttribute("title", "Sửa thông tin");
		Session session = factory.getCurrentSession();
		Congty c = (Congty) session.get(Congty.class, idcongty);
		
		model.addAttribute("com", c);
		return "admin/scongty";
	}
	
	@RequestMapping(value = "scongty", method = RequestMethod.POST )
	public String scongty(ModelMap model,
			@RequestParam("idcongty") Integer idcongty,
			@RequestParam("tencongty") String tencongty,
			@RequestParam("diachi") String diachi,
			@RequestParam("mota") String mota,
			@RequestParam("email") String email,
			@RequestParam("sodienthoai") String sodienthoai){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Congty c = (Congty) session.get(Congty.class, idcongty);
		c.setTencongty(tencongty);
		c.setDiachi(diachi);
		c.setMota(mota);
		c.setEmail(email);
		c.setSodienthoai(sodienthoai);
		
		try {
			session.update(c);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa thông tin thành công!");
			return "redirect:/admin/scongty/"+idcongty+".html";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh thông tin thất bại !" + e.getMessage());
			System.out.println("Thất bại");
			return "redirect:/admin/tintuc/"+idcongty+".html";
		}finally {
			session.close();
		}
	}
	//Sửa thông tin dịch vụ
	@RequestMapping("sdichvu/{id}")
	public String sdichvu(ModelMap model, @PathVariable("id") Integer iddv) {
		model.addAttribute("title", "Sửa dịch vụ");
		Session session = factory.getCurrentSession();
		Dichvu d = (Dichvu) session.get(Dichvu.class, iddv);
		
		model.addAttribute("di", d);
		return "admin/sdichvu";
	}
	
	@RequestMapping(value = "sdichvu", method = RequestMethod.POST )
	public String sdichvu(ModelMap model,
			@RequestParam("iddichvu") Integer iddichvu,
			@RequestParam("tendichvu") String tendichvu,
			@RequestParam("mota") String mota){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Dichvu d = (Dichvu) session.get(Dichvu.class, iddichvu);
		d.setTendichvu(tendichvu);
		d.setMota(mota);
		try {
			session.update(d);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa dịch vụ thành công !");
			return "redirect:/admin/sdichvu/"+iddichvu+".html";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa dịch vụ thất bại !" + e.getMessage());
			System.out.println("Thất bại");
			return "redirect:/admin/tintuc/"+iddichvu+".html";
		}finally {
			session.close();
		}
	}
	
	// Sửa thông tin bài viết
	@RequestMapping("sbaiviet/{id}")
	public String sbaiviet(ModelMap model, @PathVariable("id") Integer idbv) {
		model.addAttribute("title", "Sửa bài viết");
		Session session = factory.getCurrentSession();
		Tintuc tt = (Tintuc) session.get(Tintuc.class, idbv);
		model.addAttribute("baiviet", tt);
		return "admin/sbaiviet";
	}
	
	// Sửa thông tin loại của bài viết
	@RequestMapping("sbaiviet/lbaiviet/{id}")
	public String slbvcbaiviet(ModelMap model, @PathVariable("id") Integer idbv) {
		model.addAttribute("title", "Sửa loại bài viết");
		Session session = factory.getCurrentSession();
		String hql = "from Chitiettin where idtintuc = :idbv";
        Query query = session.createQuery(hql);
        query.setParameter("idbv", idbv);
        @SuppressWarnings("unchecked")
		List<Chitiettin> list = query.list();
        model.addAttribute("loaitinbv", list);
		return "admin/slbvcbaiviet";
	}
	
	
	//Sửa thông tin tỉnh thành
	@RequestMapping("stinhthanh/{id}")
	public String stinhthanh(ModelMap model, @PathVariable("id") Integer idtt) {
		model.addAttribute("title", "Sửa tỉnh thành");
		Session session = factory.getCurrentSession();
		Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, idtt);
		
		model.addAttribute("tinh", tt);
		return "admin/stinhthanh";
	}
	
//	@RequestMapping(value = "stinhthanh", method = RequestMethod.POST )
//	public String stinhthanh(ModelMap model,
//			@RequestParam("idtinhthanh") Integer idtinhthanh,
//			@RequestParam("hinhanh") MultipartFile hinhanh,
//			@RequestParam("tentinh") String tentinh,
//			@RequestParam("mota") String mota) {
//		
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
//		String photoPath = context.getRealPath("/files/" + hinhanh.getOriginalFilename());
//		
//		tt.setTentinh(tentinh);
//		tt.setMota(mota);
//		
//		try {
//			if(hinhanh.getOriginalFilename().equals("")){
//				session.update(tt);
//				t.commit();
//				model.addAttribute("message", "Chỉnh tỉnh thành thành công !");
//				System.out.println("thanh cong khong them anh");
//				return "redirect:/admin/stinhthanh/"+idtinhthanh+".html";
//			}else{
//				hinhanh.transferTo(new File(photoPath));
//				tt.setHinhanh(hinhanh.getOriginalFilename());
//				session.update(tt);
//				t.commit();
//				model.addAttribute("message", "Chỉnh sửa tỉnh thành thành công !");
//				System.out.println("thanh cong co them anh");
//				return "redirect:/admin/stinhthanh/"+idtinhthanh+".html";
//			}
//		} 
//		catch (Exception e) {
//			t.rollback();
//			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
//			System.out.println("that bai");
//			return "redirect:/admin/tintuc/"+idtinhthanh+".html";
//		}
//		finally {
//			session.close();
//		}
//	}
	
	
	// --------------------- DELETE Controller --------------------------
	// ------------------------------------------------------------------
	
	// Xóa tài khoản
	@RequestMapping("xtaikhoan/{id}")
	public String xtaikhoan(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, idxoa);
		Transaction t = session.beginTransaction();
		try {
			session.delete(tk);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:/admin/dstaikhoan.html";
	}
	
	
	// --------------------- CHECK Controller ---------------------------
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
            if(lstTaikhoans.size() != 0){
                return kt;
            }else{
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
	
	// Kiểm tra quyền có tồn tại không
	public boolean kiemtraQuyen(String tenquyen) {
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();
        boolean kt = true;
        try {
            String hql = "from Quyen where quyen = :quyen";
            Query query = session.createQuery(hql);
            query.setParameter("quyen", tenquyen);
            @SuppressWarnings("unchecked")
            List<Quyen> lstQuyen = query.list();
            t.commit();
            if(lstQuyen.size() != 0){
                return kt;
            }else{
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
	
	
	// --------------------- SLUG Tool Controller -----------------------
	// ------------------------------------------------------------------
	
	// Slug tool
	@RequestMapping("slugtool")
	public String slugtool(ModelMap model) {
		model.addAttribute("title", "Slug tool");
		return "admin/slugtool";
	}
	
	@RequestMapping(value = "slugtool", method = RequestMethod.POST)
	public String slugtool(ModelMap model, @RequestParam("tukhoa") String tukhoa) {

		String slug = SlugsConverter.toSlug(tukhoa);
		model.addAttribute("slug", slug);
		return "admin/slugtool";
	}
	
	
	
	
	
	@RequestMapping(value="kt-email-ajax", method = RequestMethod.POST)
	public String ktemailajax(HttpServletResponse response, @RequestBody String emaildata){
		try {
			System.out.println("EMAIL : " + emaildata);
			boolean ktmail =  kiemtraEmail(emaildata);
			response.getWriter().print(ktmail);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
