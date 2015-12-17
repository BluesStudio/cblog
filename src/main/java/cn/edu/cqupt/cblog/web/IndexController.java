package cn.edu.cqupt.cblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(Model model){
		/*Admin admin=new Admin();
		admin.setClazz(new Clazz());
		model.addAttribute("admin", admin);*/
		return "index";
	}
	
	@RequestMapping("/aboutUs")
	public String aboutUs(){
		return "aboutus";
	}
	@RequestMapping("/404")
	public String error_404(){
		return "404";
	}
}
