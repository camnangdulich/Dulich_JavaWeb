package controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("/admin/")
public class Huycontroller {

	// new
	@RequestMapping("new")
	public String index(ModelMap model) {
		model.addAttribute("title", "Điều khiển");
		return "admin/new";
	}
	
}
