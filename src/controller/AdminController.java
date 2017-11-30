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

import entities.Chitiettin;
import entities.Khachsan;
import entities.Loaitin;
import entities.Quyen;
import entities.Taikhoan;
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
	//Lấy tất cả loại bài viết(loại tin tức)
	@ModelAttribute("loaibvlist")
	public List<Loaitin> getlt(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Loaitin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Loaitin> list = query.list();
		return list;
	}
	//Lấy tất cả thông tin quyền
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
	//Lấy tất cả thông tin chi tiết bài viết
	@ModelAttribute("ctbvlist")
	public List<Chitiettin> getctbv(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "from Chitiettin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Chitiettin> list = query.list();
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
	
	// Trang danh sách bài viết
	@RequestMapping("dsbaiviet")
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
	@RequestMapping("tbaiviet")
	public String tbaiviet(ModelMap model) {
		model.addAttribute("title", "Thêm bài viết mới");
		return "admin/tbaiviet";
	}
	
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value = "tbaiviet", method = RequestMethod.POST)
//	public String tbaiviet(ModelMap model,
//			@RequestParam("hinhanh") MultipartFile image,
//			@RequestParam("idtk") Integer idtk,
//			@RequestParam("tieude") String tieude,
//			@RequestParam("tomtat") String tomtat,
//			@RequestParam("noidung") String noidung,
//			@RequestParam("nguon") String nguon,
//			@RequestParam("loaitin") List loaitin) {
//
//		// Tạo session
//		Session session = factory.openSession();
//		
//		// Tạo đường dẫn hình ảnh lưu vào biến photoPath
//		String photoPath = context.getRealPath("/files/tintuc/" + image.getOriginalFilename());
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
//		// Tạo ngày đăng bài viết mới
//		Date ngaydang = new Date();
//		
//		// Lấy tài khoản theo idtk
//		Taikhoan taikhoan = (Taikhoan) session.get(Taikhoan.class, idtk);
//		
//		// Tạo tin tức mới với các thông tin của tin tức
//		Tintuc tintuc = new Tintuc(taikhoan, image.getOriginalFilename(), tieude, tomtat, noidung, ngaydang, nguon);
//		
//		// Khởi tạo Transaction
//		Transaction t = session.beginTransaction();
//		
//		try {
//			
//			// Lưu tin tức vào session
//			session.save(tintuc);
//			
//			// Lấy idtintuc mới tạo
//			int idtintuc = tintuc.getIdtintuc();
//			
//			// Lấy tin tức theo idtintuc
//			Tintuc tt = (Tintuc) session.get(Tintuc.class, idtintuc);
//			
//			// Lấy loại tin tức mới
//			Loaitin ltm = (Loaitin) session.get(Loaitin.class, 1);
//			
//			// Lưu tin tức với loại tin mới
//			Chitiettin cttm = new Chitiettin(ltm, tt);
//			session.save(cttm);
//			
//			// Vòng lặp lấy lưu thông tin các loại tin tức
//			for ( int x = 0; x < loaitin.size(); x++ ){
//				
//				// Lấy idloaitin của từng loại tin
//				Object oj_idloaitin = loaitin.get(x);
//				
//				// Chuyển kiểu của từng idloaitin sang int
//				int idloaitin = Integer.valueOf((String) oj_idloaitin);
//				
//				// Lấy loại tin theo idloaitin
//				Loaitin lt = (Loaitin) session.get(Loaitin.class, idloaitin);
//				
//				// Tạo mới Chitiettin với các thông tin cần lưu
//				Chitiettin ctt = new Chitiettin(lt, tt);
//				
//				try {
//					// Lưu Chitiettin vào session
//					session.save(ctt);
//				} catch (Exception e) {
//					// Hủy tất cả thay đổi thực thi truy vấn
//					t.rollback();
//				}
//			}
//			
//			// Thực thi lưu vào database với các session đã lưu
//			t.commit();
//			
//			// Thông báo thực thi thành công
//			System.out.println("Them thanh cong!");
//			
//			// Chuyển về trang thêm bài viết
//			return "admin/tbaiviet";
//			
//		} catch (Exception e) {
//			// Hủy tất cả thay đổi thực thi truy vấn
//			t.rollback();
//			// Thông báo thực thi thất bại (lỗi)
//			model.addAttribute("message", "Thêm loại sản phẩm thất bại!");
//		} finally {
//			// Đóng session
//			session.close();
//		}
//		
//		// Chuyển về trang thêm bài viết
//		return "admin/tbaiviet";
//	}
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
        
        String hqllbv = "from Loaitin";
        Query querylbv = session.createQuery(hqllbv);
        @SuppressWarnings("unchecked")
		List<Loaitin> listlt = querylbv.list();
        
        model.addAttribute("loaitinbv", list);
        model.addAttribute("lbvlist", listlt);
		return "admin/slbvcbaiviet";
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
	
//	//Xóa loai bài viết(loaitin)
	@RequestMapping("xloaibv/{id}")
	public String xloaibv(ModelMap model, @PathVariable("id") int idxoa) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Chitiettin where idloaitin=:idlt";
        Query query = session.createQuery(hql);
        query.setParameter("idlt", idxoa);
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
