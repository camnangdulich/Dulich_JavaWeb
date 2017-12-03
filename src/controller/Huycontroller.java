package controller;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	

	// --------------------- PAGE Controller ----------------------------
	// ------------------------------------------------------------------



	// ===========================THÊM====================
	// =================================================

	

	// --------------------- EDIT Controller ----------------------------
	// ------------------------------------------------------------------

}
