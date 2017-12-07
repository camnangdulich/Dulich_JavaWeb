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

import entities.Chitietdichvu;
import entities.Chitietloaiphong;
import entities.Chitiettin;
import entities.Congty;
import entities.Danhgia;
import entities.Datphong;
import entities.Dattour;
import entities.Dichvu;
import entities.Huong;
import entities.Khachsan;
import entities.Loaiphong;
import entities.Loaitin;
import entities.Quyen;
import entities.Taikhoan;
import entities.Tinhthanh;
import entities.Tintuc;
import entities.Tour;
import entities.Trangthai;
import model.EnDeCryption;
import model.Mailer;
import model.SlugsConverter;

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
	
	@Autowired
	Mailer mailer;

	// ------------------------------------------------------------------
	// ===================== ModelAttribute =============================
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

	// Lấy tất cả loại bài viết(loại tin tức)
	@ModelAttribute("loaibvlist")
	public List<Loaitin> getlt(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaitin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Loaitin> list = query.list();
		return list;
	}

	// Lấy tất cả thông tin quyền
	@ModelAttribute("quyenlist")
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

	// Lấy tất cả đơn đăt phòng
	@ModelAttribute("dondatphonglst")
	public List<Datphong> dondatphonglst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Datphong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Datphong> list = query.list();
		return list;
	}
	
	// Lấy tất cả đơn đăt tour
	@ModelAttribute("dondattourlst")
	public List<Dattour> dondattourlst(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Dattour";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Dattour> list = query.list();
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

	// Lấy tất thông tin đặt phòng
	@ModelAttribute("dlist")
	public List<Datphong> getd(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Datphong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Datphong> list = query.list();
		return list;
	}

	// Lấy tất cả trạng thái
	@ModelAttribute("tranglist")
	public List<Trangthai> gettrang(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Trangthai";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Trangthai> list = query.list();
		return list;
	}

	// Lấy tất cả danh sách đặt tour
	@ModelAttribute("datlist")
	public List<Dattour> getdt(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Dattour";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Dattour> list = query.list();
		return list;
	}

	// Lấy tất cả thông tin hướng
	@ModelAttribute("hulist")
	public List<Huong> geth(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Huong";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Huong> list = query.list();
		return list;
	}

	// Lấy tất cả thông tin đánh giá
	@ModelAttribute("dglist")
	public List<Danhgia> getdg(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Danhgia";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Danhgia> list = query.list();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	// ------------------------------------------------------------------
	// ===================== PAGE Controller ============================
	// ------------------------------------------------------------------

	// Trang điều khiển
	@RequestMapping("dieu-khien")
	public String index(ModelMap model) {
		model.addAttribute("title", "Điều khiển");
		return "admin/index";
	}

	// Trang danh sách tài khoản
	@RequestMapping("danh-sach-tai-khoan")
	public String taikhoands(ModelMap model) {
		model.addAttribute("title", "Danh sách tài khoản");
		return "admin/dstaikhoan";
	}

	// Trang danh sách bài viết
	@RequestMapping("danh-sach-bai-viet")
	public String dsbaiviet(ModelMap model) {
		model.addAttribute("title", "Danh sách bài viết");
		return "admin/dsbaiviet";
	}

	// Danh sách tour du lịch
	@RequestMapping("danh-sach-tour-du-lich")
	public String dstour(ModelMap model) {
		model.addAttribute("title", "Danh sách tour du lịch");
		return "admin/dstour";
	}

	// Trang danh sách đơn đặt phòng
	@RequestMapping("danh-sach-don-dat-phong")
	public String danhsachdondatphong(ModelMap model) {
		model.addAttribute("title", "Danh sách đơn đặt phòng");
		return "admin/dsdondatphong";
	}
	
	// Trang danh sách đơn đặt tour
	@RequestMapping("danh-sach-don-dat-tour")
	public String danhsachdondattour(ModelMap model) {
		model.addAttribute("title", "Danh sách đơn đặt tour");
		return "admin/dsdondattour";
	}

	// Trang danh sách khách sạn
	@RequestMapping("danh-sach-khach-san")
	public String dskhachsan(ModelMap model) {
		model.addAttribute("title", "Danh sách khách sạn");
		return "admin/dskhachsan";
	}

	// Trang danh sách quyền
	@RequestMapping("danh-sach-quyen")
	public String dsquyen(ModelMap model) {
		model.addAttribute("title", "Danh sách quyền");
		return "admin/dsquyen";
	}

	// Trang danh sách loại bài viết
	@RequestMapping("danh-sach-loai-bai-viet")
	public String dsloaibv(ModelMap model) {
		model.addAttribute("title", "Danh sách loại bài viết");
		return "admin/dsloaibv";
	}

	// Trang danh sách loại phòng
	@RequestMapping("danh-sach-loai-phong")
	public String dsloaiphong(ModelMap model) {
		model.addAttribute("title", "Danh sách loại phòng");
		return "admin/dsloaiphong";
	}

	// Trang danh sách tỉnh thành
	@RequestMapping("danh-sach-tinh-thanh")
	public String dstinhthanh(ModelMap model) {
		model.addAttribute("title", "Danh sách tỉnh thành");
		return "admin/dstinhthanh";
	}

	// Trang danh sách công ty
	@RequestMapping("danh-sach-cong-ty")
	public String dscongty(ModelMap model) {
		model.addAttribute("title", "Danh sách công ty");
		return "admin/dscongty";
	}

	// Trang danh sách dịch vụ
	@RequestMapping("danh-sach-dich-vu")
	public String dsdichvu(ModelMap model) {
		model.addAttribute("title", "Danh sách dịch vụ");
		return "admin/dsdichvu";
	}

	// Trang danh sách đặt tour
	@RequestMapping("danh-sach-dat-tour")
	public String dsdattour(ModelMap model) {
		model.addAttribute("title", "Danh sách đặt tour");
		return "admin/dsdattour";
	}

	// Trang danh sách đánh giá
	@RequestMapping("danh-sach-danh-gia")
	public String dsdanhgia(ModelMap model) {
		model.addAttribute("title", "Danh sách đánh giá");
		return "admin/dsdanhgia";
	}
	
	
	
	
	
	
	
	
	
	
	// ------------------------------------------------------------------
	// ===================== ADD Controller =============================
	// ------------------------------------------------------------------

	// Thêm tài khoản mới
	@RequestMapping("them-tai-khoan-moi")
	public String ttaikhoan(ModelMap model) {
		model.addAttribute("title", "Thêm tài khoản mới");
		return "admin/ttaikhoan";
	}
//	@RequestMapping(value = "them-tai-khoan-moi", method = RequestMethod.POST)
//	public String ttaikhoan(ModelMap model, @RequestParam("quyen") Integer quyen, @RequestParam("email") String email,
//			@RequestParam("matkhau") String matkhau, @RequestParam("sdt") String sdt) throws InvalidKeyException {
//
//		if (kiemtraEmail(email)) {
//			System.out.println("Email ton tai >< stop");
//			model.addAttribute("title", "Thêm tài khoản mới");
//			model.addAttribute("message", "email ton tai");
//			return "admin/ttaikhoan";
//		} else {
//			System.out.println("Email khong ton tai >> next");
//			Session session = factory.openSession();
//			Date ngaytao = new Date();
//			Quyen rl = (Quyen) session.get(Quyen.class, quyen);
//			Trangthai trt = (Trangthai) session.get(Trangthai.class, 2);
//
//			// Password encryption
//			EnDeCryption encryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
//			String Matkhaumahoa = encryption.encoding(matkhau);
//
//			Taikhoan tk = new Taikhoan(email, Matkhaumahoa, sdt, hodem, ten, "av1.png", ngaytao, rl, trt);
//			Transaction t = session.beginTransaction();
//			try {
//				session.save(tk);
//				t.commit();
//				System.out.println("Them tai khoan thanh cong");
//				model.addAttribute("title", "Thêm tài khoản mới");
//				model.addAttribute("message", "them tai khoan thanh cong");
//				return "admin/ttaikhoan";
//			} catch (Exception e) {
//				t.rollback();
//				System.out.println("Them tai khoan that bai");
//				model.addAttribute("title", "Thêm tài khoản mới");
//				model.addAttribute("message", "them tai khoan that bai");
//			} finally {
//				session.close();
//			}
//		}
//		return "admin/ttaikhoan";
//	}

	// Thêm bài viết mới (Tin tức mới)
	@RequestMapping("them-bai-viet-moi")
	public String tbaiviet(ModelMap model) {
		model.addAttribute("title", "Thêm bài viết mới");
		return "admin/tbaiviet";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "tbaiviet", method = RequestMethod.POST)
	public String tbaiviet(ModelMap model, @RequestParam("hinhanh") MultipartFile image,
			@RequestParam("idtk") Integer idtk, @RequestParam("tieude") String tieude,
			@RequestParam("tomtat") String tomtat, @RequestParam("noidung") String noidung,
			@RequestParam("nguon") String nguon, @RequestParam("loaitin") List loaitin) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Date ngaydang = new Date();
		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtk);
		String slugtintuc = SlugsConverter.toSlug(tieude);
		String photoPath = context.getRealPath("/files/tintuc/" + image.getOriginalFilename());
		
		if (image.getOriginalFilename().equals("")) {
			Tintuc tintuc = new Tintuc(taikhoan, "default.jpg", tieude, tomtat, noidung, ngaydang, nguon, slugtintuc, 0);
			try {
				session.save(tintuc);
				int idtintuc = tintuc.getIdtintuc();
				Tintuc tt = (Tintuc) session.get(Tintuc.class, idtintuc);
				Loaitin ltm = (Loaitin) session.get(Loaitin.class, 1);
				Chitiettin cttm = new Chitiettin(ltm, tt);
				session.save(cttm);

				for (int x = 0; x < loaitin.size(); x++) {
					Object oj_idloaitin = loaitin.get(x);
					int idloaitin = Integer.valueOf((String) oj_idloaitin);
					Loaitin lt = (Loaitin) session.get(Loaitin.class, idloaitin);
					Chitiettin ctt = new Chitiettin(lt, tt);
					try {
						session.save(ctt);
					} catch (Exception e) {
						t.rollback();
					}
				}
				t.commit();
				System.out.println("Them thanh cong!");
				return "admin/tbaiviet";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm loại sản phẩm thất bại!");
			} finally {
				session.close();
			}
		} else {
			try {
				image.transferTo(new File(photoPath));
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Tintuc tintuc = new Tintuc(taikhoan, image.getOriginalFilename(), tieude, tomtat, noidung, ngaydang, nguon, slugtintuc, 0);
			try {
				session.save(tintuc);
				int idtintuc = tintuc.getIdtintuc();
				Tintuc tt = (Tintuc) session.get(Tintuc.class, idtintuc);
				Loaitin ltm = (Loaitin) session.get(Loaitin.class, 1);
				Chitiettin cttm = new Chitiettin(ltm, tt);
				session.save(cttm);

				for (int x = 0; x < loaitin.size(); x++) {
					Object oj_idloaitin = loaitin.get(x);
					int idloaitin = Integer.valueOf((String) oj_idloaitin);
					Loaitin lt = (Loaitin) session.get(Loaitin.class, idloaitin);
					Chitiettin ctt = new Chitiettin(lt, tt);
					try {
						session.save(ctt);
					} catch (Exception e) {
						t.rollback();
					}
				}
				t.commit();
				System.out.println("Them thanh cong!");
				return "admin/tbaiviet";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm loại sản phẩm thất bại!");
			} finally {
				session.close();
			}
		}
		return "admin/tbaiviet";
	}
	
	// Thêm quyền mới
	@RequestMapping("them-quyen-moi")
	public String tquyen(ModelMap model) {
		model.addAttribute("title", "Thêm quyền mới");
		return "admin/tquyen";
	}
	@RequestMapping(value = "them-quyen-moi", method = RequestMethod.POST)
	public String tquyen(ModelMap model, @RequestParam("tenquyen") String tenquyen,
			@RequestParam("mota") String mota) {

		if (kiemtraQuyen(tenquyen)) {
			model.addAttribute("message", "quyen da ton tai");
			model.addAttribute("title", "Thêm quyền mới");
			return "admin/tquyen";
		} else {
			Session session = factory.openSession();
			String slugquyen = SlugsConverter.toSlug(tenquyen);
			Quyen q = new Quyen(tenquyen, mota, slugquyen);
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

	// Thêm loai phòng
	@RequestMapping("them-loai-phong-moi")
	public String tloaiphong(ModelMap model) {
		model.addAttribute("title", "Thêm loại phòng mới");
		return "admin/tloaiphong";
	}
	@RequestMapping(value = "them-loai-phong-moi", method = RequestMethod.POST)
	public String tloaiphong(ModelMap model, @RequestParam("huong") Integer idhuong,
			@RequestParam("tenloai") String tenloai, @RequestParam("mota") String mota,
			@RequestParam("themgiuong") Integer themgiuong, @RequestParam("hinhanh") MultipartFile hinhanh,
			@RequestParam("gia") Integer gia) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String slugloaiphong = SlugsConverter.toSlug(tenloai);
		Huong huong = (Huong) session.get(Huong.class, idhuong);

		// Tạo đường dẫn lưu hình ảnh
		String photoPath = "";
		if (hinhanh.getOriginalFilename().equals("")) {
			photoPath = context.getRealPath("/files/phong/Deluxe room.jpg");
		} else {
			photoPath = context.getRealPath("/files/phong/" + hinhanh.getOriginalFilename());
		}
		// Lưu hình ảnh
		try {
			hinhanh.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (hinhanh.getOriginalFilename().equals("")) {
			Loaiphong lp = new Loaiphong(huong, tenloai, mota, themgiuong, "Deluxe room.jpg", gia,slugloaiphong);
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
			Loaiphong lp = new Loaiphong(huong, tenloai, mota, themgiuong, hinhanh.getOriginalFilename(), gia, slugloaiphong);
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

	// Thêm tỉnh thành
	@RequestMapping("ttinhthanh")
	public String ttinhthanh(ModelMap model) {
		model.addAttribute("title", "Thêm tỉnh thành mới");
		return "admin/ttinhthanh";
	}
	@RequestMapping(value = "ttinhthanh", method = RequestMethod.POST)
	public String ttinhthanh(ModelMap model, @RequestParam("hinhanh") MultipartFile hinhanh,
			@RequestParam("tentinh") String tentinh, @RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		// Tao duong dan luu hinh anh
		String photoPath = "";
		if (hinhanh.getOriginalFilename().equals("")) {
			photoPath = context.getRealPath("/files/tinhthanh/An Giang.jpg");
		} else {
			photoPath = context.getRealPath("/files/tinhthanh/" + hinhanh.getOriginalFilename());
		}

		// Luu hình anh
		try {
			hinhanh.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (hinhanh.getOriginalFilename().equals("")) {
			Tinhthanh tinh = new Tinhthanh("An Giang.jpg", tentinh, mota);
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

	// Thêm công ty mới
	@RequestMapping("them-cong-ty-moi")
	public String tcongty(ModelMap model) {
		model.addAttribute("title", "Thêm công ty mới");
		return "admin/tcongty";
	}
	@RequestMapping(value = "them-cong-ty-moi", method = RequestMethod.POST)
	public String tcongty(ModelMap model, @RequestParam("taikhoan") Integer taikhoan,
			@RequestParam("tencongty") String tencongty, @RequestParam("diachi") String diachi,
			@RequestParam("mota") String mota, @RequestParam("sodienthoai") String sodienthoai) {

		if (kiemtracongty(tencongty)) {
			model.addAttribute("message", "cong ty da ton tai");
			model.addAttribute("title", "Thêm dịch vụ mới");
			return "admin/tcongty";
		} else {
			Session session = factory.openSession();
			Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, taikhoan);
			Date ngaytao = new Date();
			String slugcongty = SlugsConverter.toSlug(tencongty);
			Congty c = new Congty(tk, tencongty, diachi, mota, sodienthoai, ngaytao, slugcongty);
			Transaction t = session.beginTransaction();
			try {
				session.save(c);
				t.commit();
				model.addAttribute("message", "them cong ty thanh cong");
				return "admin/tcongty";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "them cong ty that bai");
			} finally {
				session.close();
			}
		}
		return "admin/tcongty";
	}

	// Thêm dịch vụ mới
	@RequestMapping("them-dich-vu-moi")
	public String tdichvu(ModelMap model) {
		model.addAttribute("title", "Thêm dịch vụ mới");
		return "admin/tdichvu";
	}
	@RequestMapping(value = "them-dich-vu-moi", method = RequestMethod.POST)
	public String tdichvu(ModelMap model, @RequestParam("tendichvu") String tendichvu,
			@RequestParam("mota") String mota) {

		if (kiemtradichvu(tendichvu)) {
			model.addAttribute("message", "dich vu da ton tai");
			model.addAttribute("title", "Thêm dịch vụ mới");
			return "admin/tdichvu";
		} else {
			Session session = factory.openSession();
			String slugdichvu = SlugsConverter.toSlug(tendichvu);
			Dichvu d = new Dichvu(tendichvu, mota, slugdichvu);
			Transaction t = session.beginTransaction();
			try {
				session.save(d);
				t.commit();
				model.addAttribute("message", "them dich vu thanh cong");
				return "admin/tdichvu";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "them dich vu that  bai");
			} finally {
				session.close();
			}
		}
		return "admin/tdichvu";
	}

	// Thêm loại bài viết
	@RequestMapping("them-loai-bai-viet-moi")
	public String tloaibv(ModelMap model) {
		model.addAttribute("title", "Thêm loại bìa viết mới");
		return "admin/tloaibv";
	}
	@RequestMapping(value = "them-loai-bai-viet-moi", method = RequestMethod.POST)
	public String tloaibv(ModelMap model, @RequestParam("tenloaibv") String tenloaibv,
			@RequestParam("mota") String mota) {

		if (kiemtraLBV(tenloaibv)) {
			model.addAttribute("message", "ten loai da ton tai");
			model.addAttribute("title", "Thêm loại bài viết mới");
			return "admin/tloaibv";
		} else {
			Session session = factory.openSession();
			String slugloaibv = SlugsConverter.toSlug(tenloaibv);
			Loaitin lbv = new Loaitin(tenloaibv, mota, slugloaibv);
			Transaction t = session.beginTransaction();
			try {
				session.save(lbv);
				t.commit();
				model.addAttribute("message", "them lbv thanh cong");
				model.addAttribute("title", "Thêm loại bài mới");
				return "admin/tloaibv";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "them lbv that bai");
				model.addAttribute("title", "Thêm loại bài mới");
			} finally {
				session.close();
			}
		}
		return "admin/tloaibv";
	}

	// Thêm tour du lịch
	@RequestMapping("them-tour-du-lich")
	public String themtour(ModelMap model) {
		model.addAttribute("title", "Thêm tour du lịch mới");
		return "admin/themtour";
	}
	@RequestMapping(value = "them-tour-du-lich", method = RequestMethod.POST)
	public String themtour(ModelMap model,
			@RequestParam("congty") Integer congty,
			@RequestParam("diemden") Integer diemden,
			@RequestParam("tentour") String tentour,
			@RequestParam("mota") String mota,
			@RequestParam("gia") Integer gia,
			@RequestParam("diemdi") String diemdi,
			@RequestParam("ngaykhoihanh") String ngaykhoihanh,
			@RequestParam("lichtrinh") String lichtrinh,
			@RequestParam("luuy") String luuy,
			@RequestParam("hinhanh") MultipartFile hinhtour) {

		if (kiemtratour(tentour)) {
			model.addAttribute("message", "ten tour da ton tai");
			model.addAttribute("title", "Thêm tour du lịch mới");
			return "admin/themtour";
		} else {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			String slugtour = SlugsConverter.toSlug(tentour);
			Congty ct = (Congty) session.get(Congty.class, congty);
			Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, diemden);
			// Tạo đường dẫn lưu hình ảnh
			String photoPath = "";
			photoPath = context.getRealPath("/files/tour/" + hinhtour.getOriginalFilename());

			if (hinhtour.getOriginalFilename().equals("")) {
				Tour to = new Tour(ct, tt, tentour, mota, gia, diemdi, ngaykhoihanh, lichtrinh, luuy, 0, "default.jpg", slugtour);
				try {
					session.save(to);
					t.commit();
					model.addAttribute("message", "them tour thanh cong");
					model.addAttribute("title", "Thêm tour du lịch mới");
					return "admin/themtour";
				} catch (Exception e) {
					t.rollback();
					model.addAttribute("message", "them tour that bai");
					model.addAttribute("title", "Thêm tour du lịch mới");
				} finally {
					session.close();
				}

			} else {
				// Lưu hình ảnh
				try {
					hinhtour.transferTo(new File(photoPath));
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Tour to = new Tour(ct, tt, tentour, mota, gia, diemdi, ngaykhoihanh, lichtrinh, luuy, 0, hinhtour.getOriginalFilename(), slugtour);
				try {
					session.save(to);
					t.commit();
					model.addAttribute("message", "them tour thanh cong");
					model.addAttribute("title", "Thêm tour du lịch mới");
					return "admin/themtour";
				} catch (Exception e) {
					t.rollback();
					model.addAttribute("message", "them tour that bai");
					model.addAttribute("title", "Thêm tour du lịch mới");
				} finally {
					session.close();
				}

			}
		}
		return "admin/themtour";
	}

	// Thêm khách sạn
	@RequestMapping("tkhachsan")
	public String tkhachsan(ModelMap model) {
		model.addAttribute("title", "Thêm thêm khách sạn mới");
		return "admin/tkhachsan";
	}
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "tkhachsan", method = RequestMethod.POST)
	public String tkhachsan(ModelMap model, @RequestParam("taikhoan") Integer taikhoan,
			@RequestParam("tinhthanh") Integer tinhthanh, @RequestParam("tenkhachsan") String tenkhachsan,
			@RequestParam("hinhanh") MultipartFile hinhanh, @RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("diachi") String diachi, @RequestParam("dichvu") List dichvu,
			@RequestParam("loaiphong") List loaiphong) {
		Session session = factory.openSession();
		String photoPath = context.getRealPath("/files/khachsan/" + hinhanh.getOriginalFilename());
		try {
			hinhanh.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Date ngaydang = new Date();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, taikhoan);
		Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, tinhthanh);
		Trangthai trang = (Trangthai) session.get(Trangthai.class, 2);
		if (hinhanh.getOriginalFilename().equals("")) {
			Khachsan ks = new Khachsan(tk, tt, trang, tenkhachsan, "ks001.jpg", sodienthoai, diachi, ngaydang);
			Transaction t = session.beginTransaction();
			try {
				session.save(ks);
				int idkhachsan = ks.getIdkhachsan();
				Khachsan khach = (Khachsan) session.get(Khachsan.class, idkhachsan);
				Dichvu dv = (Dichvu) session.get(Dichvu.class, 1);
				Loaiphong lphong = (Loaiphong) session.get(Loaiphong.class, 1);
				Chitietdichvu ctdv = new Chitietdichvu(dv, khach);
				session.save(ctdv);
				Chitietloaiphong chitietlp = new Chitietloaiphong(khach, lphong);
				session.save(chitietlp);
				for (int i = 0; i < dichvu.size(); i++) {
					Object obdichvu = dichvu.get(i);
					int iddichvu = Integer.valueOf((String) obdichvu);
					Dichvu dvu = (Dichvu) session.get(Dichvu.class, iddichvu);
					Chitietdichvu ctdvu = new Chitietdichvu(dv, khach);
					try {
						session.save(ctdv);
					} catch (Exception e) {
						t.rollback();
					}
				}
				// Vòng lặp lưu thông tin loại phong
				for (int j = 0; j < loaiphong.size(); j++) {
					// Lấy idloaiphong của từng loại tin
					Object obloaiphong = loaiphong.get(j);
					// Chuyển kiểu của idloaiphong sang String
					int iddloaiphong = Integer.valueOf((String) obloaiphong);
					// Lấy loại phòng theo idloaiphong
					Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, iddloaiphong);
					// Tạo mới Chi tiết loai phòng với các thông tin cần lưu
					Chitietloaiphong ctloaip = new Chitietloaiphong(khach, lphong);
					try {
						// Lưu Chitietloaiphong vào session
						session.save(ctloaip);
					} catch (Exception e) {
						// Hủy tất cả thay đổi thực thi truy vấn
						t.rollback();
					}
				}
				t.commit();
				return "admin/dskhachsan";

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm khách sạn thất bại");
			} finally {
				session.close();
			}
		} else {
			// Tạo tin tức mới với các thông tin của tin tức
			Khachsan ks = new Khachsan(tk, tt, trang, tenkhachsan, "ks001.jpg", sodienthoai, diachi, ngaydang);

			// Khởi tạo Transaction
			Transaction t = session.beginTransaction();
			try {
				// Lưu khach san vào session
				session.save(ks);
				// Lấy idkhachsan mới tạo
				int idkhachsan = ks.getIdkhachsan();
				// Lấy khách san theo idkhachsan
				Khachsan khach = (Khachsan) session.get(Khachsan.class, idkhachsan);
				// Lấy dich vu mới
				Dichvu dv = (Dichvu) session.get(Dichvu.class, 1);
				// Lấy loai phong mới
				Loaiphong lphong = (Loaiphong) session.get(Loaiphong.class, 1);
				// Lưu Khach san với dich vu mới
				Chitietdichvu ctdv = new Chitietdichvu(dv, khach);
				session.save(ctdv);
				// Lưu Khach san với loại phòng mới
				Chitietloaiphong chitietlp = new Chitietloaiphong(khach, lphong);
				session.save(chitietlp);
				// Vòng lặp lưu thông tin dịch vụ
				for (int i = 0; i < dichvu.size(); i++) {
					// Lấy iddichvu của từng loại tin
					Object obdichvu = dichvu.get(i);
					// Chuyển kiểu của iddichvu sang String
					int iddichvu = Integer.valueOf((String) obdichvu);
					// Lấy loại dịch vụ theo iddichvu
					Dichvu dvu = (Dichvu) session.get(Dichvu.class, iddichvu);
					// Tạo mới Chi tiết dịch vụ với các thông tin cần lưu
					Chitietdichvu ctdvu = new Chitietdichvu(dv, khach);
					try {
						session.save(ctdv);
					} catch (Exception e) {
						t.rollback();
					}
				}
				// Vòng lặp lưu thông tin loại phong
				for (int j = 0; j < loaiphong.size(); j++) {
					// Lấy idloaiphong của từng loại tin
					Object obloaiphong = loaiphong.get(j);
					// Chuyển kiểu của idloaiphong sang String
					int iddloaiphong = Integer.valueOf((String) obloaiphong);
					// Lấy loại phòng theo idloaiphong
					Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, iddloaiphong);
					// Tạo mới Chi tiết loai phòng với các thông tin cần lưu
					Chitietloaiphong ctloaip = new Chitietloaiphong(khach, lphong);
					try {
						// Lưu Chitietloaiphong vào session
						session.save(ctloaip);
					} catch (Exception e) {
						// Hủy tất cả thay đổi thực thi truy vấn
						t.rollback();
					}
				}
				t.commit();
				return "admin/dskhachsan";
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm khách sạn thất bại");
			} finally {
				// Đóng session
				session.close();
			}
		}

		return "admin/tkhachsan";
	}
	
	
	
	
	
	
	
	
	
	
	// ------------------------------------------------------------------
	// ===================== EDIT Controller ============================
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
	@RequestMapping(value = "updatetk", method = RequestMethod.POST)
	public String staikhoan(ModelMap model, @RequestParam("idtk") Integer idtk, @RequestParam("quyen") Integer quyen,
			@RequestParam("email") String email, @RequestParam("matkhau") String matkhau,
			@RequestParam("sdt") String sdt, @RequestParam("hodem") String hodem, @RequestParam("ten") String ten,
			@RequestParam("diachi") String diachi, @RequestParam("avatar") MultipartFile image) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, idtk);
		Quyen rl = (Quyen) session.get(Quyen.class, quyen);
		String slugtk = SlugsConverter.toSlug(email);
		String photoPath = context.getRealPath("/files/" + image.getOriginalFilename());

		tk.setQuyen(rl);
		tk.setEmail(email);
		tk.setMatkhau(matkhau);
		tk.setSodienthoai(sdt);
		tk.setHodem(hodem);
		tk.setTen(ten);
		tk.setDiachi(diachi);
		tk.setSluglink(slugtk);

		try {
			if (image.getOriginalFilename().equals("")) {
				session.update(tk);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong khong them anh");
				return "redirect:/admin/staikhoan/" + idtk + ".html";
			} else {
				image.transferTo(new File(photoPath));
				tk.setAvatar(image.getOriginalFilename());
				session.update(tk);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong co them anh");
				return "redirect:/admin/staikhoan/" + idtk + ".html";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/tintuc/" + idtk + ".html";
		} finally {
			session.close();
		}
	}

	//Sửa bài viết
	@RequestMapping("sbaiviet/{id}")
	public String sbaiviet(ModelMap model, @PathVariable("id") Integer idbv) {
		model.addAttribute("title", "Sửa bài viết");
		Session session = factory.getCurrentSession();
		Tintuc tintuc = (Tintuc) session.get(Tintuc.class, idbv);
		model.addAttribute("sbv", tintuc);
		return "admin/sbaiviet";
	}
	@RequestMapping(value = "sbaiviet", method = RequestMethod.POST)
	public String sbaiviet(ModelMap model, @RequestParam("idbv") Integer idbv, @RequestParam("hinhanh") MultipartFile image,
			 @RequestParam("tieude") String tieude,
			@RequestParam("tomtat") String tomtat, @RequestParam("noidung") String noidung,
			@RequestParam("nguon") String nguon) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Tintuc bv = (Tintuc) session.get(Tintuc.class, idbv);
		String slugbv = SlugsConverter.toSlug(tieude);
		String photoPath = context.getRealPath("/files/tintuc" + image.getOriginalFilename());

		bv.setTieude(tieude);
		bv.setTomtat(tomtat);
		bv.setNoidung(noidung);
		bv.setNguon(nguon);
		bv.setSlug(slugbv);
		try {
			if (image.getOriginalFilename().equals("")) {
				session.update(bv);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa bài viết thành công !");
				System.out.println("thanh cong khong them anh");
				return "redirect:/admin/sbaiviet/" + idbv + ".html";
			} else {
				image.transferTo(new File(photoPath));
				bv.setHinhanh(image.getOriginalFilename());
				session.update(bv);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong co them anh");
				return "redirect:/admin/sbaiviet/" + idbv + ".html";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa bài viết thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/tintuc/" + idbv + ".html";
		} finally {
			session.close();
		}
	}
	
	// Sửa thông tin công ty
	@RequestMapping("thong-tin-cong-ty")
	public String thongtincongty(ModelMap model) {
		model.addAttribute("title", "Thông tin công ty");
		return "admin/ttcongty";
	}
	@RequestMapping(value = "thong-tin-cong-ty", method = RequestMethod.POST)
	public String thongtincongty(ModelMap model, HttpSession httpSession,
			@RequestParam("idct") Integer idcongty,
			@RequestParam("tencongty") String tencongty,
			@RequestParam("diachi") String diachi, 
			@RequestParam("mota") String mota,
			@RequestParam("sodienthoai") String sodienthoai) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Congty ct = (Congty) session.get(Congty.class, idcongty);
		String slugcongty = SlugsConverter.toSlug(tencongty);
		ct.setTencongty(tencongty);
		ct.setDiachi(diachi);
		ct.setMota(mota);
		ct.setSodienthoai(sodienthoai);
		ct.setSlug(slugcongty);
		try {
			session.update(ct);
			t.commit();
			model.addAttribute("message", "ttct sua thanh cong");
			model.addAttribute("title", "Thông tin công ty");
			httpSession.setAttribute("loguserct", ct);
			return "admin/ttcongty";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "ttct sua that bai");
			model.addAttribute("title", "Thông tin công ty");
		} finally {
			session.close();
		}
		return "admin/ttcongty";
	}
	
	// Sửa thông tin khách sạn
	@RequestMapping("thong-tin-khach-san")
	public String thongtinkhachsan(ModelMap model) {
		model.addAttribute("title", "Thông tin khách sạn");
		return "admin/ttkhachsan";
	}
	@RequestMapping(value = "thong-tin-khach-san", method = RequestMethod.POST)
	public String suattks(ModelMap model, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("idks") Integer idks,
			@RequestParam("tenkhachsan") String tenkhachsan, @RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("tinhthanh") Integer idtinhthanh, @RequestParam("diachi") String diachi,
			@RequestParam("hinhanh") MultipartFile image) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Khachsan ks = (Khachsan) session.get(Khachsan.class, idks);
		String slugks = SlugsConverter.toSlug(tenkhachsan);
		Tinhthanh tth = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
		String photoPath = context.getRealPath("/files/khachsan/" + image.getOriginalFilename());

		ks.setTenkhachsan(tenkhachsan);
		ks.setSodienthoai(sodienthoai);
		ks.setTinhthanh(tth);
		ks.setDiachi(diachi);
		ks.setSlug(slugks);

		try {
			if (image.getOriginalFilename().equals("")) {
				session.update(ks);
				t.commit();
				httpSession.setAttribute("loguserks", ks);
				model.addAttribute("message", "ttks sua thanh cong");
				return "admin/ttkhachsan";
			} else {
				image.transferTo(new File(photoPath));
				ks.setHinhanh(image.getOriginalFilename());
				session.update(ks);
				t.commit();
				httpSession.setAttribute("loguserks", ks);
				model.addAttribute("message", "ttks sua thanh cong");
				return "admin/ttkhachsan";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "ttks sua that bai");
		} finally {
			session.close();
		}
		return "admin/ttkhachsan";
	}

	// Sửa thông tin dịch vụ của khách sạn
	@RequestMapping("thong-tin-khach-san/sua-dich-vu")
	public String suadichvukhachsan(ModelMap model) {
		model.addAttribute("title", "Sửa dịch vụ khách sạn");
		return "admin/sdvcttkhachsan";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "thong-tin-khach-san/sua-dich-vu", method = RequestMethod.POST)
	public String suadichvukhachsan(ModelMap model, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("dichvu") List dichvu, @RequestParam("idks") Integer idks) {
		Session session = factory.openSession();
		Khachsan ks = (Khachsan) session.get(Khachsan.class, idks);
		Transaction t = session.beginTransaction();
		try {

			for (int x = 0; x < dichvu.size(); x++) {
				Object oj_iddichvu = dichvu.get(x);
				int iddichvu = Integer.valueOf((String) oj_iddichvu);
				Dichvu dv = (Dichvu) session.get(Dichvu.class, iddichvu);
				Chitietdichvu ctdv = new Chitietdichvu(dv, ks);
				try {
					session.save(ctdv);
				} catch (Exception e) {
					t.rollback();
				}
			}
			t.commit();
			model.addAttribute("message", "ttks sua dich vu thanh cong");
			return "admin/sdvcttkhachsan";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "ttks sua dich vu that bai");
		} finally {
			session.close();
		}
		return "admin/sdvcttkhachsan";
	}

	// Sửa thông tin loại phòng của khách sạn
	@RequestMapping("thong-tin-khach-san/sua-loai-phong")
	public String sualoaiphongkhachsan(ModelMap model) {
		model.addAttribute("title", "Sửa loại phòng khách sạn");
		return "admin/slpcttkhachsan";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "thong-tin-khach-san/sua-loai-phong", method = RequestMethod.POST)
	public String sualoaiphongkhachsan(ModelMap model, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("loaiphong") List loaiphong,
			@RequestParam("idks") Integer idks) {
		Session session = factory.openSession();
		Khachsan ks = (Khachsan) session.get(Khachsan.class, idks);
		Transaction t = session.beginTransaction();
		try {

			for (int x = 0; x < loaiphong.size(); x++) {
				Object oj_idloaiphong = loaiphong.get(x);
				int idloaiphong = Integer.valueOf((String) oj_idloaiphong);
				Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, idloaiphong);
				Chitietloaiphong ctlp = new Chitietloaiphong(ks, lp);
				try {
					session.save(ctlp);
				} catch (Exception e) {
					t.rollback();
				}
			}
			t.commit();
			model.addAttribute("message", "ttks sua loai phong thanh cong");
			return "admin/slpcttkhachsan";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "ttks sua loai phong that bai");
		} finally {
			session.close();
		}
		return "admin/slpcttkhachsan";
	}

	// Sửa thông tin tour
	@RequestMapping("danh-sach-tour-du-lich/sua-tour/{slugtour}")
	public String sutour(ModelMap model, @PathVariable("slugtour") String slugtour) {
		model.addAttribute("title", "Sửa tour du lịch");
		Session session = factory.getCurrentSession();
		String hql = "from Tour where slug = :slugtour";
		Query query = session.createQuery(hql);
		query.setParameter("slugtour", slugtour);
		Tour tour = (Tour) query.uniqueResult();
		model.addAttribute("tua", tour);
		return "admin/stour";
	}
	@RequestMapping(value = "sutour", method = RequestMethod.POST)
	public String sutour(ModelMap model, @RequestParam("idtour") Integer idtour,
			@RequestParam("diemden") Integer diemden, @RequestParam("tentour") String tentour,
			@RequestParam("mota") String mota, @RequestParam("gia") Integer gia, @RequestParam("diemdi") String diemdi,
			@RequestParam("ngaykhoihanh") String ngaykhoihanh, @RequestParam("lichtrinh") String lichtrinh,
			@RequestParam("luuy") String luuy, @RequestParam("hinhanh") MultipartFile hinhanh) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Tour to = (Tour) session.get(Tour.class, idtour);
		String slugtour = to.getSlug();
		Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, diemden);
		String photoPath = context.getRealPath("/files/tour/" + hinhanh.getOriginalFilename());

		to.setTinhthanh(tt);
		to.setTentour(tentour);
		to.setMota(mota);
		to.setGia(gia);
		to.setDiemdi(diemdi);
		to.setThoigiankhoihanh(ngaykhoihanh);
		to.setLichtrinh(lichtrinh);
		to.setLuuy(luuy);
		
		try {
			if (hinhanh.getOriginalFilename().equals("")) {
				session.update(tt);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tour thành công !");
				System.out.println("Thành công không thêm ảnh");
				return "redirect:/admin/danh-sach-tour-du-lich/sua-tour/" + slugtour + ".html";
			} else {
				hinhanh.transferTo(new File(photoPath));
				to.setHinhtour(hinhanh.getOriginalFilename());
				session.update(tt);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tour thành công !");
				System.out.println("Thành công có thêm ảnh");
				return "redirect:/admin/danh-sach-tour-du-lich/sua-tour/" + slugtour + ".html";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/danh-sach-tour-du-lich/sua-tour/" + slugtour + ".html";
		} finally {
			session.close();
		}

	}

	// Sửa thông tin tỉnh thành
	@RequestMapping("stinhthanh/{id}")
	public String stinhthanh(ModelMap model, @PathVariable("id") Integer idtt) {
		model.addAttribute("title", "Sửa tỉnh thành");
		Session session = factory.getCurrentSession();
		Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, idtt);

		model.addAttribute("tinh", tt);
		return "admin/stinhthanh";
	}
	@RequestMapping(value = "stinhthanh", method = RequestMethod.POST)
	public String stinhthanh(ModelMap model, @RequestParam("idtinhthanh") Integer idtinhthanh,
			@RequestParam("hinhanh") MultipartFile hinhanh, @RequestParam("tentinh") String tentinh,
			@RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
		String photoPath = context.getRealPath("/files/tinhthanh/" + hinhanh.getOriginalFilename());

		tt.setTinhthanh(tentinh);
		tt.setMota(mota);

		try {
			if (hinhanh.getOriginalFilename().equals("")) {
				session.update(tt);
				t.commit();
				model.addAttribute("message", "Chỉnh tỉnh thành thành công !");
				System.out.println("thanh cong khong them anh");
				return "redirect:/admin/stinhthanh/" + idtinhthanh + ".html";
			} else {
				hinhanh.transferTo(new File(photoPath));
				tt.setHinhanh(hinhanh.getOriginalFilename());
				session.update(tt);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa tỉnh thành thành công !");
				System.out.println("thanh cong co them anh");
				return "redirect:/admin/stinhthanh/" + idtinhthanh + ".html";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/tintuc/" + idtinhthanh + ".html";
		} finally {
			session.close();
		}
	}

	// Sửa thông tin quyền
	@RequestMapping("squyen/{id}")
	public String squyen(ModelMap model, @PathVariable("id") Integer idquyen) {
		model.addAttribute("title", "Sửa quyền");
		Session session = factory.getCurrentSession();
		Quyen q = (Quyen) session.get(Quyen.class, idquyen);
		model.addAttribute("role", q);
		return "admin/squyen";
	}
	@RequestMapping(value = "squyen", method = RequestMethod.POST)
	public String squyen(ModelMap model, @RequestParam("idquyen") Integer idquyen,
			@RequestParam("tenquyen") String tenquyen, @RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String slugquyen = SlugsConverter.toSlug(tenquyen);
		Quyen q = (Quyen) session.get(Quyen.class, idquyen);
		q.setQuyen(tenquyen);
		q.setMota(mota);
		q.setSlug(slugquyen);
		try {
			session.update(q);
			t.commit();
			model.addAttribute("message", "sua quyen thanh cong");
			return "admin/squyen";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "sua quyen that bai");
			System.out.println("Thất bại");
			return "admin/squyen";
		} finally {
			session.close();
		}

	}

	// Sửa thông tin loại phòng
	@RequestMapping("sloaiphong/{id}")
	public String sloaiphong(ModelMap model, @PathVariable("id") Integer idlp) {
		model.addAttribute("title", "Sửa loại phòng");
		Session session = factory.getCurrentSession();
		Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, idlp);

		model.addAttribute("lstlp", lp);
		return "admin/sloaiphong";
	}
	@RequestMapping(value = "sloaiphong", method = RequestMethod.POST)
	public String sloaiphong(ModelMap model, @RequestParam("idlp") Integer idlp,
			@RequestParam("tenloai") String tenloai, @RequestParam("mota") String mota,
			@RequestParam("themgiuong") Integer themgiuong, @RequestParam("huong") Integer idhuong,
			@RequestParam("hinhanh") MultipartFile hinhanh, @RequestParam("gia") Integer gia) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String photoPath = context.getRealPath("/files/phong/" + hinhanh.getOriginalFilename());
		Huong hg = (Huong) session.get(Huong.class, idhuong);
		Loaiphong lp = (Loaiphong) session.get(Loaiphong.class, idlp);

		lp.setTenloai(tenloai);
		;
		lp.setMota(mota);
		lp.setThemgiuong(themgiuong);
		;
		lp.setGia(gia);
		lp.setHuong(hg);
		try {
			if (hinhanh.getOriginalFilename().equals("")) {
				session.update(lp);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa loại phòng thành công !");
				System.out.println("Thành công không thêm ảnh");
				return "redirect:/admin/sloaiphong/" + idlp + ".html";
			} else {
				hinhanh.transferTo(new File(photoPath));
				lp.setHinhanh(hinhanh.getOriginalFilename());
				session.update(lp);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa loại phòng thành công !");
				System.out.println("Thành công có ảnh");
				return "redirect:/admin/sloaiphong/" + idlp + ".html";
			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa loại phòng thất bại !" + e.getMessage());
			System.out.println("that bai");
			return "redirect:/admin/tintuc/" + idlp + ".html";
		} finally {
			session.close();
		}
	}

	// Sua thông tin công ty (ADMIN)
	@RequestMapping("suacongty/{id}")
	public String suacongty(ModelMap model, @PathVariable("id") Integer idcongty) {
		model.addAttribute("title", "Sửa thông tin");
		Session session = factory.getCurrentSession();
		Congty c = (Congty) session.get(Congty.class, idcongty);

		model.addAttribute("com", c);
		return "admin/suacongty";
	}
	@RequestMapping(value = "suacongty", method = RequestMethod.POST)
	public String suacongty(ModelMap model, @RequestParam("idcongty") Integer idcongty,
			@RequestParam("taikhoan") Integer taikhoan, @RequestParam("tencongty") String tencongty,
			@RequestParam("diachi") String diachi, @RequestParam("mota") String mota,
			@RequestParam("sodienthoai") String sodienthoai) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Congty ct = (Congty) session.get(Congty.class, idcongty);
		String slugct = SlugsConverter.toSlug(tencongty);
		Taikhoan tk = (Taikhoan) session.get(Taikhoan.class, taikhoan);
		ct.setTaikhoan(tk);
		ct.setTencongty(tencongty);
		ct.setDiachi(diachi);
		ct.setMota(mota);
		ct.setSodienthoai(sodienthoai);
		ct.setSlug(slugct);
		try {
			session.update(ct);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa thông tin thành công!");
			return "redirect:/admin/suacongty/" + idcongty + ".html";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh thông tin thất bại !" + e.getMessage());
			System.out.println("Thất bại");
			return "redirect:/admin/tintuc/" + idcongty + ".html";
		} finally {
			session.close();
		}
	}

	// Sửa thông tin dịch vụ
	@RequestMapping("sdichvu/{id}")
	public String sdichvu(ModelMap model, @PathVariable("id") Integer iddv) {
		model.addAttribute("title", "Sửa dịch vụ");
		Session session = factory.getCurrentSession();
		Dichvu d = (Dichvu) session.get(Dichvu.class, iddv);

		model.addAttribute("di", d);
		return "admin/sdichvu";
	}
	@RequestMapping(value = "sdichvu", method = RequestMethod.POST)
	public String sdichvu(ModelMap model, @RequestParam("iddichvu") Integer iddichvu,
			@RequestParam("tendichvu") String tendichvu, @RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Dichvu d = (Dichvu) session.get(Dichvu.class, iddichvu);
		String slugtdv = SlugsConverter.toSlug(tendichvu);
		d.setTendichvu(tendichvu);
		d.setMota(mota);
		d.setSlug(slugtdv);
		try {
			session.update(d);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa dịch vụ thành công !");
			return "redirect:/admin/sdichvu/" + iddichvu + ".html";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa dịch vụ thất bại !" + e.getMessage());
			System.out.println("Thất bại");
			return "redirect:/admin/tintuc/" + iddichvu + ".html";
		} finally {
			session.close();
		}
	}

	// Sửa thông tin loại bài viết
	@RequestMapping("sloaibv/{id}")
	public String sloaibv(ModelMap model, @PathVariable("id") Integer idbv) {
		model.addAttribute("title", "Sửa Loại bài viết");
		Session session = factory.getCurrentSession();
		Loaitin lt = (Loaitin) session.get(Loaitin.class, idbv);

		model.addAttribute("loait", lt);
		return "admin/sloaibv";
	}
	@RequestMapping(value = "sloaibv", method = RequestMethod.POST)
	public String sloaibv(ModelMap model, @RequestParam("idloaibv") Integer idloaibv,
			@RequestParam("tenloai") String tenloaibv, @RequestParam("mota") String mota) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String slugtlbv = SlugsConverter.toSlug(tenloaibv);
		Loaitin lt = (Loaitin) session.get(Loaitin.class, idloaibv);
		lt.setLoaitin(tenloaibv);
		lt.setMota(mota);
		lt.setSlug(slugtlbv);
		try {
			session.update(lt);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa loại bài viết thành công !");
			return "redirect:/admin/sloaibv/" + idloaibv + ".html";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa loại bài viết thất bại !" + e.getMessage());
			System.out.println("Thất bại");
			return "redirect:/admin/tintuc/" + idloaibv + ".html";
		} finally {
			session.close();
		}

	}
	
	
	// Xác nhận đơn đặt phòng
	@RequestMapping("xnddp/{iddondatphong}/{emaildatphong}")
	public String xnddp(ModelMap model, @PathVariable("iddondatphong") Integer iddondatphong,
			@PathVariable("emaildatphong") String email) {
		
		Session session = factory.getCurrentSession();
		Datphong dp = (Datphong) session.get(Datphong.class, iddondatphong);
		Trangthai trangthai = (Trangthai) session.get(Trangthai.class, 1);
		dp.setTrangthai(trangthai);
		
		String from = "camnangdulich360@gmail.com";
		String subject = "Xác nhận đơn đặt phòng - Camnangdulich";
//		String body = "Cảm ơn " + dp.getHodem() +" "+ dp.getTen()+ " đã quan tâm và sử dụng dịch vụ đặt phòng tại Camnangdulich!\n"
//				+ "Đơn đặt phòng của bạn tại khách sạn " + dp.getKhachsan().getTenkhachsan() + " đã được xác nhận với các thông tin sau:\n"
//				+ "Ngày nhận phòng: " + dp.getNgaynhanphong() + "\n"
//				+ "Ngày trả phòng: " + dp.getNgaytraphong() + "\n"
//				+ "Loại phòng: " + dp.getLoaiphong().getTenloai() + "\n"
//				+ "Số lượng phòng: " + dp.getSoluongphong() + "\n"
//				+ "Mô tả loại phòng: " + dp.getLoaiphong().getMota();
		String body = "Cảm ơn " + dp.getHodem() +" "+ dp.getTen()+ " ,đơn đặt phòng của bạn tại khách sạn "+ dp.getKhachsan().getTenkhachsan() + " đã được xác nhận!";
		mailer.send(from, email, subject, body);
		
		return "redirect:/admin/danh-sach-don-dat-phong.html";
	}

	
	
	
	
	
	
	
	
	
	// ------------------------------------------------------------------
	// ===================== DELETE Controller ==========================
	// ------------------------------------------------------------------

	// Xóa tin tức
	@RequestMapping("xtintuc/{id}")
	public String xtintuc(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Chitiettin where idtintuc =:idtt";
		Query query = session.createQuery(hql);
		query.setParameter("idtt", idxoa);
		@SuppressWarnings("unchecked")
		List<Chitiettin> lstctt = query.list();
		if (lstctt.size() == 0) {
			Tintuc tt = (Tintuc) session.get(Tintuc.class, idxoa);
			try {
				session.delete(tt);
				t.commit();
			} catch (Exception e) {
				t.rollback();
			} finally {
				session.close();
			}
		} else {
			String hqltt = "delete Chitiettin where idtintuc =:idtt";
			Query queryxcct = session.createQuery(hqltt);
			queryxcct.setParameter("idtt", idxoa);
			for (int x = 0; x < lstctt.size(); x++) {
				session.delete(lstctt.get(x));
			}
			Tintuc tt = (Tintuc) session.get(Tintuc.class, idxoa);
			try {
				session.delete(tt);
				t.commit();
			} catch (Exception e) {
				t.rollback();
			} finally {
				session.close();
			}

		}
		return "redirect:/admin/danh-sach-bai-viet.html";
	}

	// Xóa tour du lịch
	@RequestMapping("xoatour/{id}")
	public String xoatour(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Dattour where idtour =:idtour";
		Query query = session.createQuery(hql);
		query.setParameter("idtour", idxoa);
		@SuppressWarnings("unchecked")
		List<Dattour> lstdt = query.list();
		if (lstdt.size() == 0) {
			Tour tour = (Tour) session.get(Tour.class, idxoa);
			try {
				session.delete(tour);
				t.commit();
			} catch (Exception e) {
				t.rollback();
			} finally {
				session.close();
			}
		} else {
			String hqldt = "delete Dattour where idtour =:idtour";
			Query queryxcct = session.createQuery(hqldt);
			System.out.println("idd" + idxoa);
			queryxcct.setParameter("idtour", idxoa);
			for (int x = 0; x < lstdt.size(); x++) {
				session.delete(lstdt.get(x));
			}
			Tour tour = (Tour) session.get(Tour.class, idxoa);
			try {
				session.delete(tour);
				t.commit();
			} catch (Exception e) {
				t.rollback();
			} finally {
				session.close();
			}
		}
		return "redirect:/admin/danh-sach-tour-du-lich.html";
	}

	// Xóa loại bài viết
	@RequestMapping("xloaibv/{id}")
	public String xloaibv(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Chitiettin where idloaitin=:idlt";
		Query query = session.createQuery(hql);
		query.setParameter("idlt", idxoa);
		@SuppressWarnings("unchecked")
		List<Chitiettin> lstcct = query.list();
		if (lstcct.size() == 0) {
			System.out.println("Xoa loai tin khong co chi tiet tin");
			Loaitin lt = (Loaitin) session.get(Loaitin.class, idxoa);
			try {
				session.delete(lt);
				t.commit();
				System.out.println("Xoa loai tin khong co chi tiet tin (Thanh cong)");
			} catch (Exception e) {
				t.rollback();
				System.out.println("Xoa loai tin khong co chi tiet tin (That bai)");
			} finally {
				session.close();
			}
		} else {
			String hqlxctt = "delete Chitiettin where idloaitin= :idlt";
			Query queryxcct = session.createQuery(hqlxctt);
			System.out.println("idd" + idxoa);
			queryxcct.setParameter("idlt", idxoa);
			for (int x = 0; x < lstcct.size(); x++) {
				session.delete(lstcct.get(x));
				System.out.println("Xoa loai tin co chi tiet tin (Thanh cong)");
			}
			Loaitin lt = (Loaitin) session.get(Loaitin.class, idxoa);
			try {
				session.delete(lt);
				t.commit();
				System.out.println("Xoa loai tin co chi tiet tin (Thanh cong)");
			} catch (Exception e) {
				t.rollback();
				System.out.println("Xoa loai tin co chi tiet tin (That bai)");
			} finally {
				session.close();
			}
			System.out.println("Xóa thành công");

		}
		return "redirect:/admin/dsloaibv.html";
	}

	// Xóa dịch vụ
	@RequestMapping("xdichvu/{id}")
	public String xdichvu(ModelMap model, @PathVariable("id") int idxoabv) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Chitietdichvu where iddichvu=:iddv";
		Query query = session.createQuery(hql);
		query.setParameter("iddv", idxoabv);
		@SuppressWarnings("unchecked")
		List<Chitietdichvu> lsctdv = query.list();
		if (lsctdv.size() == 0) {
			Dichvu dvu = (Dichvu) session.get(Dichvu.class, idxoabv);
			try {
				session.delete(dvu);
				t.commit();
			} catch (Exception e) {
				t.rollback();
			} finally {
				session.close();
			}
		} else {
			String hqlxctdv = "delete Chitietdichvu where iddichvu= :iddv";
			Query queryxctdv = session.createQuery(hqlxctdv);
			System.out.println("idd" + idxoabv);
			queryxctdv.setParameter("iddv", idxoabv);
			for (int x = 0; x < lsctdv.size(); x++) {
				session.delete(lsctdv.get(x));
				System.out.println("Xoa loai tin co chi tiet dv (Thanh cong)");
			}
			Dichvu dvu = (Dichvu) session.get(Dichvu.class, idxoabv);
			try {
				session.delete(dvu);
				t.commit();
				System.out.println("Xoa loai tin co chi tiet dv (Thanh cong)");
			} catch (Exception e) {
				t.rollback();
				System.out.println("Xoa loai tin co chi tiet dv (That bai)");
			} finally {
				session.close();
			}
			System.out.println("Xóa thành công");

		}
		return "redirect:/admin/dsdichvu.html";
	}

	// Xóa đặt tour
	@RequestMapping("xdattour/{id}")
	public String xdattour(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Dattour dt = (Dattour) session.get(Dattour.class, idxoa);
		Transaction t = session.beginTransaction();
		try {
			session.delete(dt);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:/admin/dsdattour.html";
	}

	// Xóa đặt phòng
	@RequestMapping("xoadatphong/{id}")
	public String xoadatphong(ModelMap model, 
			HttpSession httpSession,
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Datphong dp = (Datphong) session.get(Datphong.class, idxoa);
		Transaction t = session.beginTransaction();
		try {
			session.delete(dp);
			t.commit();
			
			String email = dp.getEmail();
			String from = "camnangdulich360@gmail.com";
			String subject = "Hủy đơn đặt phòng - Camnangdulich";
			String body = "Đơn đặt phòng của bạn tại khách sạn " +dp.getKhachsan().getTenkhachsan()
					+ " đã bị hủy, vui lòng liên hệ với người quản trị để biết thêm chi tiết.";
			// Send mail thông báo hủy đơn đặt phòng này
			mailer.send(from, email, subject, body);
			
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:/admin/danh-sach-don-dat-phong.html";
	}

	// Xóa chi tiết dịch vụ
	@RequestMapping("xchitietdv/{id}")
	public String xchitietdv(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Chitietdichvu ctdv = (Chitietdichvu) session.get(Chitietdichvu.class, idxoa);
		Transaction t = session.beginTransaction();
		try {
			session.delete(ctdv);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:/admin/thong-tin-khach-san/sua-dich-vu.html";
	}

	// Xóa chi tiết dịch vụ
	@RequestMapping("xchitietlp/{id}")
	public String xchitietlp(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Chitietloaiphong ctlp = (Chitietloaiphong) session.get(Chitietloaiphong.class, idxoa);
		Transaction t = session.beginTransaction();
		try {
			session.delete(ctlp);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:/admin/thong-tin-khach-san/sua-loai-phong.html";
	}

	// Xóa đánh giá
	@RequestMapping("xoadanhgia/{id}")
	public String xoadanhgia(ModelMap model, @PathVariable("id") int idxoa) {
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
		return "redirect:/admin/dsdanhgia.html";
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
	
	// Kiểm tra số điện có tồn tại không
	public boolean kiemtraSdt(String sdt) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Taikhoan where sodienthoai = :sdt";
			Query query = session.createQuery(hql);
			query.setParameter("sdt", sdt);
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
			if (lstQuyen.size() != 0) {
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

	// Kiểm tra tên loại bài viết có tồn tại không
	public boolean kiemtraLBV(String loaitin) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Loaitin where loaitin = :loaibv";
			Query query = session.createQuery(hql);
			query.setParameter("loaibv", loaitin);
			@SuppressWarnings("unchecked")
			List<Loaitin> lstloaibv = query.list();
			t.commit();
			if (lstloaibv.size() != 0) {
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

	// Kiểm tra tên tour đã tồn tại
	public boolean kiemtratour(String tour) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Tour where tentour = :tourten";
			Query query = session.createQuery(hql);
			query.setParameter("tourten", tour);
			@SuppressWarnings("unchecked")
			List<Tour> lsttour = query.list();
			t.commit();
			if (lsttour.size() != 0) {
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

	// Kiểm tra tên dịch vụ đã tồn tại
	public boolean kiemtradichvu(String dichvu) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Dichvu where tendichvu = :tendv";
			Query query = session.createQuery(hql);
			query.setParameter("tendv", dichvu);
			@SuppressWarnings("unchecked")
			List<Dichvu> lstdv = query.list();
			t.commit();
			if (lstdv.size() != 0) {
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
	
	// Kiểm tra tên dịch vụ đã tồn tại
	public boolean kiemtradichvubyid(String iddichvu) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Dichvu where iddichvu = :iddichvu";
			Query query = session.createQuery(hql);
			query.setParameter("iddichvu", iddichvu);
			@SuppressWarnings("unchecked")
			List<Dichvu> lstdv = query.list();
			t.commit();
			if (lstdv.size() != 0) {
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

	// Kiểm tra tên công ty đã tồn tại
	public boolean kiemtracongty(String congty) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Congty where tencongty = :tenct";
			Query query = session.createQuery(hql);
			query.setParameter("tenct", congty);
			@SuppressWarnings("unchecked")
			List<Congty> lstcongty = query.list();
			t.commit();
			if (lstcongty.size() != 0) {
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
	
	// Kiểm tra tên khách sạn đã tồn tại
	public boolean kiemtrakhachsan(String khachsan) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		boolean kt = true;
		try {
			String hql = "from Khachsan where tenkhachsan = :tenks";
			Query query = session.createQuery(hql);
			query.setParameter("tenks", khachsan);
			@SuppressWarnings("unchecked")
			List<Khachsan> lstkhachsan = query.list();
			t.commit();
			if (lstkhachsan.size() != 0) {
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

	// ------------------------------------------------------------------
	// ===================== AJAX CHECK Controller ======================
	// ------------------------------------------------------------------

	// Check email
	@RequestMapping(value = "kt-email-ajax", method = RequestMethod.POST)
	public String ktemailajax(HttpServletResponse response, @RequestBody String emaildata) {
		try {
			boolean ktmail = kiemtraEmail(emaildata);
			response.getWriter().print(ktmail);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Check số điện thoại
	@RequestMapping(value = "kt-sdt-ajax", method = RequestMethod.POST)
	public String ktsdtajax(HttpServletResponse response, @RequestBody String sdtdata) {
		try {
			boolean ktsdt = kiemtraSdt(sdtdata);
			response.getWriter().print(ktsdt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Check tên khách sạn
	@RequestMapping(value = "kt-tks-ajax", method = RequestMethod.POST)
	public String kttksajax(HttpServletResponse response, @RequestBody String tksdata) {
		try {
			boolean kttks = kiemtrakhachsan(tksdata);
			response.getWriter().print(kttks);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Check id dịch vụ
	@RequestMapping(value = "kt-iddv-ajax", method = RequestMethod.POST)
	public String ktiddvajax(HttpServletResponse response, @RequestBody String iddvdata) {
		try {
			System.out.println("ID-DV: " + iddvdata);
			boolean ktiddvdata = kiemtradichvubyid(iddvdata);
			response.getWriter().print(ktiddvdata);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	// ------------------------------------------------------------------
	// ===================== SLUG Tool Controller =======================
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

}
