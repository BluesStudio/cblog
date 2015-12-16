package cn.edu.cqupt.cblog.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.UserRequest;
import cn.edu.cqupt.cblog.service.AdminService;
import cn.edu.cqupt.cblog.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService=new AdminServiceImpl();
	
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazzName", admin.getClazz().getClazzName());
		properties.put("dispose", "unresolved");
		List<UserRequest> userRequests=UserRequest.findUserRequestsByProperties(properties);
//System.out.println(ReflectionToStringBuilder.toString(admin, ToStringStyle.SIMPLE_STYLE));
//System.out.println(ReflectionToStringBuilder.toString(userRequests, ToStringStyle.SIMPLE_STYLE));

//没有总评论数
		//session.setAttribute("admin", admin);
		admin=Admin.findAdmin(admin.getId());
		session.setAttribute("admin", admin);
		session.setAttribute("clazz", admin.getClazz());
		session.setAttribute("userRequests_size", userRequests.size());
		System.out.println("userRequests.size():"+userRequests.size());
		return "admin";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> register(@ModelAttribute("admin") Admin admin, BindingResult result) {
		//System.out.println(ReflectionToStringBuilder.toString(admin, ToStringStyle.SIMPLE_STYLE));
		adminService.register(admin, result);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if(result.hasErrors()){
			List<ObjectError> errors=result.getAllErrors();
			StringBuffer errorsBuffer=new StringBuffer();
			for(ObjectError error:errors){
				errorsBuffer.append(",\""+error.getCode()+"\":\""+error.getDefaultMessage()+"\"");
			}
			
			String errorsJson="{"+errorsBuffer.toString().substring(1)+"}";
			return new ResponseEntity<String>(errorsJson, headers, HttpStatus.OK);
		}
        return new ResponseEntity<String>("{\"success\":\"true\"}", headers, HttpStatus.OK);
    }
	
	@RequestMapping(value="/login", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> login(@ModelAttribute("admin") Admin admin, BindingResult result, HttpSession session){
		adminService.login(admin, result);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if(result.hasErrors()){
			List<ObjectError> errors=result.getAllErrors();
			StringBuffer errorsBuffer=new StringBuffer();
			for(ObjectError error:errors){
				errorsBuffer.append(",\""+error.getCode()+"\":\""+error.getDefaultMessage()+"\"");
			}
			
			String errorsJson="{"+errorsBuffer.toString().substring(1)+"}";
			return new ResponseEntity<String>(errorsJson, headers, HttpStatus.OK);
		}
        admin=Admin.findAdmin(admin.getId());
        session.setAttribute("admin", admin);
        return new ResponseEntity<String>("{\"success\":\"true\"}", headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/modifyPasswd", method=RequestMethod.GET)
	public String modifyPasswd(){
		return "admin-setting";
	}
	
	@RequestMapping(value="/modifyPasswd", method=RequestMethod.POST)
	public String modifyPasswd(@ModelAttribute("oldPasswd") String oldPasswd, @ModelAttribute("newPasswd") String newPasswd, @ModelAttribute("newPasswd2") String newPasswd2, BindingResult bindingResult, HttpSession session, Model model){
		Admin admin=(Admin)session.getAttribute("admin");
		
		if(oldPasswd==null||oldPasswd.trim().equals("")){
			bindingResult.reject("oldPasswd_required", "请输入原密码");
		}else if(!oldPasswd.equals(admin.getPasswd())){
			bindingResult.reject("oldPasswd_required", "原密码输入错误");
		}
		if(newPasswd==null||newPasswd.trim().equals("")){
			bindingResult.reject("newPasswd_required", "请输入新密码");
		}else if(newPasswd.length()<6||newPasswd.length()>60){
			bindingResult.reject("newPasswd_required", "新密码长度只能为6-60");
		}
		if(newPasswd2==null||newPasswd2.trim().equals("")){
			bindingResult.reject("newPasswd2_required", "请确认新密码");
		}else if(!newPasswd2.equals(newPasswd)){
			bindingResult.reject("newPasswd2_required", "两次新密码不一致");
		}
		if(bindingResult.hasErrors()){
			
			for(ObjectError error: bindingResult.getAllErrors()){
				model.addAttribute(error.getCode(), error.getDefaultMessage());
			}
			return "admin-setting";
		}
//这个待会儿试一下，看是不是游离态		
		admin.setPasswd(newPasswd);
		session.setAttribute("admin", admin.merge());
		return "redirect:/admins/modifyPasswd";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("admin");
		return "redirect:/index";
	}
}
