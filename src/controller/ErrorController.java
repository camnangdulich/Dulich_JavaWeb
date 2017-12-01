package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/")
public class ErrorController {

	@RequestMapping("opp")
	public String opp() {
		return "error/404";
	}
	
	@RequestMapping("stop")
	public String strop() {
		return "error/500";
	}
	
}
