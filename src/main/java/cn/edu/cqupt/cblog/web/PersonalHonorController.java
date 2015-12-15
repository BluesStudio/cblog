package cn.edu.cqupt.cblog.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.PersonalHonor;
import cn.edu.cqupt.cblog.domain.Student;

@Controller
@RequestMapping("/personalHonors")
public class PersonalHonorController {

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@ModelAttribute("award")String award, @ModelAttribute("stuName") String stuName, BindingResult bindingResult, HttpSession session, Model model){
		if(award==null){
			bindingResult.reject("award_required", "个人荣誉名称不能为空");
			bindingResult.reject("stuName_required", "学生姓名不能为空");
		}else{
			if(award==null||award.trim().equals("")){
				bindingResult.reject("award_required", "个人荣誉名称不能为空");
			}
			if(stuName==null||stuName.trim().equals("")){
				bindingResult.reject("stuName_required", "学生姓名不能为空");
			}else{
				Map<String, Object> properties=new HashMap<String, Object>();
				properties.put("stuName", stuName);
				Admin admin=(Admin)session.getAttribute("admin");
				properties.put("clazz.id", admin.getClazz().getId());
				List<Student> students=Student.findStudentsByProperties(properties);
				if(students.size()==0){
					bindingResult.reject("stuName_required", "学生姓名有误或该学生不存在");
				}
			}
		}
		if(bindingResult.hasErrors()){
			for(ObjectError error: bindingResult.getAllErrors()){
				model.addAttribute(error.getCode(), error.getDefaultMessage());
			}
			return "admin-introduction";
		}
		
		for(FieldError error: bindingResult.getFieldErrors()){
			System.out.println(error.getDefaultMessage());
		}
		PersonalHonor honor=new PersonalHonor();
		honor.setPersonalHonorDate(new Date());
		honor.setAward(award);
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("stuName", stuName);
		Admin admin=(Admin)session.getAttribute("admin");
		properties.put("clazz.id", admin.getClazz().getId());
		List<Student> students=Student.findStudentsByProperties(properties);
		honor.setStudent(students.get(0));
		honor.setClazz(admin.getClazz());
		honor.persist();
		session.setAttribute("admin", Admin.findAdmin(admin.getId()));
		return "redirect:/clazzs/admin-introduction";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String create(@PathVariable("id") Long id, BindingResult bindingResult, HttpSession session){
		PersonalHonor personalHonor=PersonalHonor.findPersonalHonor(id);
		Admin admin=(Admin)session.getAttribute("admin");
		if(personalHonor==null||personalHonor.getClazz()==null||personalHonor.getClazz().getId().equals(admin.getClazz().getId())){
			bindingResult.reject("personalHonor.id.required", "个人荣誉已删除或不存在");
			return "redirect:/clazzs/admin-introduction";
		}
		personalHonor.remove();
		session.setAttribute("admin", Admin.findAdmin(admin.getId()));
		return "redirect:/clazzs/admin-introduction";
	}
}
