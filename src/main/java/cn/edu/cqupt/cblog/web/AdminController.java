package cn.edu.cqupt.cblog.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		Admin admin=Admin.findAdmin(1L);
		Map<String, String> properties=new HashMap<String, String>();
		properties.put("clazzName", admin.getClazz().getClazzName());
		properties.put("dispose", "unsolved");
		List<UserRequest> userRequests=UserRequest.findUserRequestsByProperties(properties);
//System.out.println(ReflectionToStringBuilder.toString(admin, ToStringStyle.SIMPLE_STYLE));
//System.out.println(ReflectionToStringBuilder.toString(userRequests, ToStringStyle.SIMPLE_STYLE));

//没有总评论数
		session.setAttribute("admin", admin);
		model.addAttribute("userRequests", userRequests);
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
}
