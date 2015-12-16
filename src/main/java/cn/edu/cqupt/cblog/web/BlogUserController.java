package cn.edu.cqupt.cblog.web;

import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import cn.edu.cqupt.cblog.domain.BlogUser;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.domain.Student;
import cn.edu.cqupt.cblog.domain.UserRequest;
import cn.edu.cqupt.cblog.service.BlogUserService;
import cn.edu.cqupt.cblog.util.MultipartFileResolver;


@Controller
@RequestMapping("/blogUsers")
public class BlogUserController {

	@Autowired
	private BlogUserService blogUserService;
	
	public BlogUserService getBlogUserService() {
		return blogUserService;
	}
	public void setBlogUserService(BlogUserService blogUserService) {
		this.blogUserService = blogUserService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> register(@ModelAttribute("blogUser") BlogUser blogUser, BindingResult result) {
		System.out.println(ReflectionToStringBuilder.toString(blogUser, ToStringStyle.SIMPLE_STYLE));
		blogUserService.register(blogUser, result);
		
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
	public ResponseEntity<String> login(@ModelAttribute("blogUser") BlogUser blogUser, BindingResult result, HttpSession session){
		blogUserService.login(blogUser, result);
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
        blogUser=BlogUser.findBlogUser(blogUser.getId());
        session.setAttribute("blogUser", blogUser);
        return new ResponseEntity<String>("{\"success\":\"true\"}", headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(HttpSession session){
		//session.setAttribute("blogUser", BlogUser.findBlogUser(1L));
		return "user";
	}
	
	@RequestMapping(value="/user-setting", method=RequestMethod.GET)
	public String userSetting(HttpSession session){
		//session.setAttribute("blogUser", BlogUser.findBlogUser(1L));
		return "user-setting";
	}
	
	@RequestMapping(value="/user-setting", method=RequestMethod.POST)
	public String updateInfo(@ModelAttribute("blogUser") BlogUser blogUserTemp, BindingResult bindingResult, HttpSession session){
		
		
		BlogUser blogUser=(BlogUser)session.getAttribute("blogUser");
		Student student=blogUserTemp.getStudent();
		if(student==null){
			student=new Student();
		}
		student.setStuName(blogUserTemp.getStudent().getStuName());
		student.setGender(blogUserTemp.getStudent().getGender());
		student.setAge(blogUserTemp.getStudent().getAge());
		student.setStuId(blogUserTemp.getStudent().getStuId());
		student.setMotto(blogUserTemp.getStudent().getMotto());
		if(blogUserTemp.getStudent()==null){
			student.persist();
		}else{
			student.merge();
		}
		blogUser.setStudent(student);
		blogUser.merge();
		session.setAttribute("blogUser", blogUser);
		return "redirect:/blogUsers/user-setting";
	}
	
	@RequestMapping(value="/modifyStuImg", method=RequestMethod.POST)
	public String modifyStuImg(@ModelAttribute("stuImg") MultipartFile stuImg, HttpSession session ){
		BlogUser blogUser=(BlogUser)session.getAttribute("blogUser");
		blogUser.getStudent().setStuImg(MultipartFileResolver.resolveMultipartFile(stuImg));
		System.out.println("modifyStuImg:"+blogUser.getStudent().getStuImg());
		blogUser.getStudent().merge();
		return "redirect:/blogUsers/user-setting";
	}
	
	@RequestMapping(value="/modifyPasswd", method=RequestMethod.GET)
	public String modifyPasswd(){
		return "redirect:/blogUsers/user-setting";
	}
	
	@RequestMapping(value="/modifyPasswd", method=RequestMethod.POST)
	public String modifyPasswd(@ModelAttribute("oldPasswd") String oldPasswd, @ModelAttribute("newPasswd") String newPasswd, @ModelAttribute("newPasswd2") String newPasswd2, BindingResult bindingResult, HttpSession session, Model model){
		BlogUser blogUser=(BlogUser)session.getAttribute("blogUser");
		
		if(oldPasswd==null||oldPasswd.trim().equals("")){
			bindingResult.reject("oldPasswd_required", "请输入原密码");
		}else if(!oldPasswd.equals(blogUser.getPasswd())){
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
			return "user-setting";
		}
		blogUser.setPasswd(newPasswd);
		session.setAttribute("blogUser", blogUser.merge());
		return "redirect:/blogUsers/user-setting";
	}
	
	
	//修改班级
	@RequestMapping(value="/modifyClazz", method=RequestMethod.POST)
	public String modifyClazz(@ModelAttribute("userRequest") UserRequest userRequest, BindingResult bindingResult, HttpSession session){
		if(userRequest==null){
			bindingResult.reject("userRequest.clazzName", "班级编号不能为空");
			bindingResult.reject("userRequest.stuName", "姓名不能为空");
			bindingResult.reject("userRequest.stuId", "学号编号不能为空");
			bindingResult.reject("userRequest.reason", "申请理由不能为空");
		}else{
			if(userRequest.getClazzName()==null||userRequest.getClazzName().trim().equals("")){
				bindingResult.reject("userRequest.clazzName", "班级编号不能为空");
			}else{
				Map<String, Object> properties=new HashMap<String, Object>();
				properties.put("clazzName", userRequest.getClazzName());
				if(Clazz.findClazzsByProperties(properties).size()==0){
					bindingResult.reject("userRequest.clazzName", "该班级不存在");
				}
			}
			if(userRequest.getStuName()==null||userRequest.getStuName().trim().equals("")){
				bindingResult.reject("userRequest.stuName", "姓名不能为空");
			}
			if(userRequest.getStuId()==null||userRequest.getStuId().trim().equals("")){
				bindingResult.reject("userRequest.stuId", "学号编号不能为空");
			}
			if(userRequest.getReason()==null||userRequest.getReason().trim().equals("")){
				bindingResult.reject("userRequest.reason", "申请理由不能为空");
			}
		}
		if(bindingResult.hasErrors()){
			return "user-setting";
		}
		userRequest.setDispose("unresolved");
		userRequest.setBlogUser((BlogUser)session.getAttribute("blogUser"));
		userRequest.setUserRequestDate(new Date());
		userRequest.persist();
		return "redirect:/blogUsers/user-setting";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("blogUser");
		return "redirect:/index";
	}
}
