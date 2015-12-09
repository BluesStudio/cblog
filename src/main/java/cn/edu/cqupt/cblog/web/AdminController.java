package cn.edu.cqupt.cblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cqupt.cblog.domain.Admin;

@Controller
@RequestMapping("/admins")
public class AdminController {

	
	@RequestMapping("/hello")
	public String hello(){
		Admin admin=new Admin();
		admin.setUsername("xiaoer");
		admin.setPasswd("12345678");
		admin.persist();
		return "hello";
	}
}
