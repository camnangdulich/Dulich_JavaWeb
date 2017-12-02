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
import model.EnDeCryption;
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
	
	
	
	
	
	
	
	
	
	
	// --------------------- PAGE Controller ----------------------------
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
	
	// Trang tour du lịch
	@RequestMapping("dstour")
	public String dstour(ModelMap model) {
		model.addAttribute("title", "Danh sách tour");
		return "admin/dstour";
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
	
	
	
	
	
	// Thêm bài viết mới (Tin tức mới)
	@RequestMapping("them-bai-viet")
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

		Session session = factory.openSession();
		String photoPath = context.getRealPath("/files/tintuc/" + image.getOriginalFilename());
		try {
			image.transferTo(new File(photoPath));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Date ngaydang = new Date();
		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtk);
		String slugtintuc = SlugsConverter.toSlug(tieude);
		Tintuc tintuc = new Tintuc(taikhoan, image.getOriginalFilename(), tieude, tomtat, noidung, ngaydang, nguon, slugtintuc, 0);
		Transaction t = session.beginTransaction();
		try {
			session.save(tintuc);
			int idtintuc = tintuc.getIdtintuc();
			Tintuc tt = (Tintuc) session.get(Tintuc.class, idtintuc);
			Loaitin ltm = (Loaitin) session.get(Loaitin.class, 1);
			Chitiettin cttm = new Chitiettin(ltm, tt);
			session.save(cttm);
			
			for ( int x = 0; x < loaitin.size(); x++ ){
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
		return "admin/tbaiviet";
	}
	// ------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
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
	
	
	
	
	
//	// Sửa thông tin bài viết
//	@RequestMapping("sbaiviet/{id}")
//	public String sbaiviet(ModelMap model, @PathVariable("id") Integer idbv) {
//		model.addAttribute("title", "Sửa bài viết");
//		Session session = factory.getCurrentSession();
//		Tintuc tt = (Tintuc) session.get(Tintuc.class, idbv);
//		model.addAttribute("baiviet", tt);
//		return "admin/sbaiviet";
//	}
//	
//	
//	
//	
//	// Sửa thông tin loại của bài viết
//	@RequestMapping("sbaiviet/lbaiviet/{id}")
//	public String slbvcbaiviet(ModelMap model, @PathVariable("id") Integer idbv) {
//		model.addAttribute("title", "Sửa loại bài viết");
//		Session session = factory.getCurrentSession();
//		String hql = "from Chitiettin where idtintuc = :idbv";
//        Query query = session.createQuery(hql);
//        query.setParameter("idbv", idbv);
//        @SuppressWarnings("unchecked")
//		List<Chitiettin> list = query.list();
//        
//        String hqllbv = "from Loaitin";
//        Query querylbv = session.createQuery(hqllbv);
//        @SuppressWarnings("unchecked")
//		List<Loaitin> listlt = querylbv.list();
//        
//        model.addAttribute("loaitinbv", list);
//        model.addAttribute("lbvlist", listlt);
//		return "admin/slbvcbaiviet";
//	}
	
	
	
	
	
	// Trang thông tin khách sạn
	@RequestMapping("thong-tin-khach-san")
	public String thongtinkhachsan(ModelMap model) {
		model.addAttribute("title", "Thông tin khách sạn");
		return "admin/ttkhachsan";
	}
	
	// Sửa thông tin khách sạn
	@RequestMapping(value = "thong-tin-khach-san", method = RequestMethod.POST )
	public String suattks(ModelMap model, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("idks") Integer idks,
			@RequestParam("tenkhachsan") String tenkhachsan,
			@RequestParam("sodienthoai") String sodienthoai,
			@RequestParam("tinhthanh") Integer idtinhthanh,
			@RequestParam("diachi") String diachi,
			@RequestParam("hinhanh") MultipartFile image){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Khachsan ks = (Khachsan) session.get(Khachsan.class, idks);
		Tinhthanh tth = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
		String photoPath = context.getRealPath("/files/khachsan/" + image.getOriginalFilename());
		
		ks.setTenkhachsan(tenkhachsan);
		ks.setSodienthoai(sodienthoai);
		ks.setTinhthanh(tth);
		ks.setDiachi(diachi);
		
		try {
			if(image.getOriginalFilename().equals("")){
				session.update(ks);
				t.commit();
				httpSession.setAttribute("loguserks", ks);
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong khong them anh");
				return "admin/ttkhachsan";
			}else{
				image.transferTo(new File(photoPath));
				ks.setHinhanh(image.getOriginalFilename());
				session.update(ks);
				t.commit();
				httpSession.setAttribute("loguserks", ks);
				model.addAttribute("message", "Chỉnh sửa tin tức thành công !");
				System.out.println("thanh cong co them anh");
				return "admin/ttkhachsan";
			}
		} 
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
			System.out.println("that bai");
		}
		finally {
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
	@RequestMapping(value = "thong-tin-khach-san/sua-dich-vu", method = RequestMethod.POST )
	public String suadichvukhachsan(ModelMap model, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("dichvu") List dichvu,
			@RequestParam("idks") Integer idks){
		Session session = factory.openSession();
		Khachsan ks = (Khachsan) session.get(Khachsan.class, idks);
		Transaction t = session.beginTransaction();
		try {
			
			for ( int x = 0; x < dichvu.size(); x++ ){
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
			System.out.println("Them thanh cong!");
			return "admin/sdvcttkhachsan";
		} catch (Exception e) {
			t.rollback();
			System.out.println("Them that bai!");
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
	@RequestMapping(value = "thong-tin-khach-san/sua-loai-phong", method = RequestMethod.POST )
	public String sualoaiphongkhachsan(ModelMap model, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("loaiphong") List loaiphong,
			@RequestParam("idks") Integer idks){
		Session session = factory.openSession();
		Khachsan ks = (Khachsan) session.get(Khachsan.class, idks);
		Transaction t = session.beginTransaction();
		try {
			
			for ( int x = 0; x < loaiphong.size(); x++ ){
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
			System.out.println("Them thanh cong!");
			return "admin/slpcttkhachsan";
		} catch (Exception e) {
			t.rollback();
			System.out.println("Them that bai!");
		} finally {
			session.close();
		}
		return "admin/slpcttkhachsan";
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
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
	
	// Xóa loai bài viết(loaitin)
	@RequestMapping("xloaibv/{id}")
	public String xloaibv(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Chitiettin where idloaitin=:idlt";
        Query query = session.createQuery(hql);
        query.setParameter("idlt", idxoa);
		@SuppressWarnings("unchecked")
		List<Chitiettin> lstcct = query.list();
		if(lstcct.size() == 0){
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
			System.out.println("idd"  + idxoa);
			queryxcct.setParameter("idlt", idxoa);
			for(int x = 0; x < lstcct.size(); x++){
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
//		try {
//			session.delete(tk);
//			t.commit();
//		} catch (Exception e) {
//			t.rollback();
//		} finally {
//			session.close();
//		}
		return "redirect:/admin/dsloaibv.html";
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
	
	
	
	
	
	
	
	
	
	
	// --------------------- AJAX CHECK Controller ----------------------
	// ------------------------------------------------------------------
	
	// Check email
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
	
	
	
	
	
}
