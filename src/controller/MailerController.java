package controller;

import java.security.InvalidKeyException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Taikhoan;
import model.EnDeCryption;
import model.Mailer;
import model.RandomString;

@Controller
@RequestMapping("/mailer/")
public class MailerController {
	
	@Autowired
	Mailer mailer;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("repwd_mailer")
	public String repwd_mailer( ModelMap model, @RequestParam("email") String to ) throws InvalidKeyException {
		
		Session session = factory.getCurrentSession();
		Transaction t = session.beginTransaction();
		String from = "kakaassasin123@gmail.com";
		String pass = RandomString.randomString(10);
		EnDeCryption cryption = new EnDeCryption("RHVvbmdOZ3V5ZW4=");
		String passmahoa = cryption.encoding(pass);
		String subject = "Lấy Lại Mật Khẩu";
		String body = "Mật Khẩu Mới :" + pass;
		
		System.out.println("Email nhap vao: " + to);
		String hql = "from Taikhoan where email = :emailtk";
		Query query = session.createQuery(hql);
		query.setParameter("emailtk", to);
		Taikhoan users = (Taikhoan) query.uniqueResult();
		Integer test = users.getIdtaikhoan();
		System.out.println("Email trong CSDL: " + test);
		
//		users.setMatkhau(pass);
//		session.save(users);
//		t.commit();
		
		users.setMatkhau(pass);
		session.saveOrUpdate(users);
		t.commit();
		session.close();
		
//		try {
			
//			System.out.println("Email nhap vao: " + to);
//			String hql = "from Taikhoan where email = :emailtk";
//			Query query = session.createQuery(hql);
//			query.setParameter("emailtk", to);
//
//			Taikhoan users = (Taikhoan) query.uniqueResult();
//			
//			users.setMatkhau(passmahoa);
//			session.update(users);
//			t.commit();
//			
//			String test = users.getEmail();
//			System.out.println("Email trong CSDL: " + test);
//			
//			// Tạo mail
//			MimeMessage mail = mailer.createMimeMessage();
//			// Sử dụng lớp trợ giúp
//			MimeMessageHelper helper = new MimeMessageHelper(mail);
//			helper.setFrom(from, from);
//			helper.setTo(to);
//			helper.setReplyTo(from, from);
//			helper.setSubject(subject);
//			helper.setText(body, true);
//			
//			// Gửi mail
//			mailer.send(mail);
//			
//			System.out.println("Mailer success!");
//			model.addAttribute("message", "Gửi email thành công !");
//		} catch (Exception ex) {
//			System.out.println("Mailer failse!");
//			model.addAttribute("message", "Gửi email thất bại !");
//		}
		
		try {
			//mailer.send(from, to, subject, body);
			System.out.println("Mailer success!");
			model.addAttribute("message", "Gửi email thành công !");
		} catch (Exception e) {
			System.out.println("Mailer failse!");
			model.addAttribute("message", "Gửi email thất bại !");
		}
		
		return "home/phanhoi";
	}
	
}
