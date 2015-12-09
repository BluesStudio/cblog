package cn.edu.cqupt.cblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Clazz;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(Model model){
		Admin admin=new Admin();
		admin.setClazz(new Clazz());
		model.addAttribute("admin", admin);
		return "index";
	}
}
