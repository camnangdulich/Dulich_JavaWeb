package controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import entities.Congty;
import entities.Datphong;
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

@Transactional
@Controller
@RequestMapping("/admin/")
public class Huycontroller {

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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	// --------------------- ADD Controller -----------------------------
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
		String photoPath = context.getRealPath("/files/phong/" + hinhanh.getOriginalFilename());
		
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
	
	
	//Thêm loại bài viết
//	@RequestMapping("tloaibv")
//	public String tloaibv(ModelMap model) {
//		model.addAttribute("title", "Thêm loại bìa viết mới");
//		return "admin/tloaibv";
//	}
//	
//	@RequestMapping(value = "tloaibv", method = RequestMethod.POST)
//	public String tloaibv(ModelMap model,
//			@RequestParam("tenloaibv") String tenloaibv,
//			@RequestParam("mota") String mota) {
//
//		Session session = factory.openSession();
//		Loaitin lbv = new Loaitin(tenloaibv, mota);
//		Transaction t = session.beginTransaction();
//		try {
//			session.save(lbv);
//			t.commit();
//			model.addAttribute("message", "Thêm loại bài viết thành công!");
//			return "admin/tloaibv";
//		} catch (Exception e) {
//			t.rollback();
//			model.addAttribute("message", "Thêm loại bài viết thất bại!");
//		} finally {
//			session.close();
//		}
//		return "admin/tloaibv";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// --------------------- EDIT Controller ----------------------------
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
		
		
		
		// Sửa thông tin loại của bài viết
//		@RequestMapping("sbaiviet/lbaiviet/{id}")
//		public String slbvcbaiviet(ModelMap model, @PathVariable("id") Integer idbv) {
//			model.addAttribute("title", "Sửa loại bài viết");
//			Session session = factory.getCurrentSession();
//			String hql = "from Chitiettin where idtintuc = :idbv";
//	        Query query = session.createQuery(hql);
//	        query.setParameter("idbv", idbv);
//	        @SuppressWarnings("unchecked")
//			List<Chitiettin> list = query.list();
//	        model.addAttribute("loaitinbv", list);
//			return "admin/slbvcbaiviet";
//		}
		
		
		
		
		//Sửa thông tin tỉnh thành
		@RequestMapping("stinhthanh/{id}")
		public String stinhthanh(ModelMap model, @PathVariable("id") Integer idtt) {
			model.addAttribute("title", "Sửa tỉnh thành");
			Session session = factory.getCurrentSession();
			Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, idtt);
			
			model.addAttribute("tinh", tt);
			return "admin/stinhthanh";
		}
		
//		@RequestMapping(value = "stinhthanh", method = RequestMethod.POST )
//		public String stinhthanh(ModelMap model,
//				@RequestParam("idtinhthanh") Integer idtinhthanh,
//				@RequestParam("hinhanh") MultipartFile hinhanh,
//				@RequestParam("tentinh") String tentinh,
//				@RequestParam("mota") String mota) {
//			
//			Session session = factory.openSession();
//			Transaction t = session.beginTransaction();
//			Tinhthanh tt = (Tinhthanh) session.get(Tinhthanh.class, idtinhthanh);
//			String photoPath = context.getRealPath("/files/" + hinhanh.getOriginalFilename());
//			
//			tt.setTentinh(tentinh);
//			tt.setMota(mota);
//			
//			try {
//				if(hinhanh.getOriginalFilename().equals("")){
//					session.update(tt);
//					t.commit();
//					model.addAttribute("message", "Chỉnh tỉnh thành thành công !");
//					System.out.println("thanh cong khong them anh");
//					return "redirect:/admin/stinhthanh/"+idtinhthanh+".html";
//				}else{
//					hinhanh.transferTo(new File(photoPath));
//					tt.setHinhanh(hinhanh.getOriginalFilename());
//					session.update(tt);
//					t.commit();
//					model.addAttribute("message", "Chỉnh sửa tỉnh thành thành công !");
//					System.out.println("thanh cong co them anh");
//					return "redirect:/admin/stinhthanh/"+idtinhthanh+".html";
//				}
//			} 
//			catch (Exception e) {
//				t.rollback();
//				model.addAttribute("message", "Chỉnh sửa tin tức thất bại !" + e.getMessage());
//				System.out.println("that bai");
//				return "redirect:/admin/tintuc/"+idtinhthanh+".html";
//			}
//			finally {
//				session.close();
//			}
//		}
		
		
		
		
		
	
	
	

		
		
		
		
	
	
	
	
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
	
}
