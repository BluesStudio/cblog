package cn.edu.cqupt.cblog.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.domain.PersonalHonor;
import cn.edu.cqupt.cblog.domain.Student;

@Controller
@RequestMapping("/personalHonors")
public class PersonalHonorController {

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@ModelAttribute("personalHonor")PersonalHonor personalHonor, BindingResult bindingResult, HttpSession session){
		if(personalHonor==null){
			bindingResult.reject("personalHonor.award.required", "个人荣誉名称不能为空");
			bindingResult.reject("personalHonor.student.stuName.required", "学生姓名不能为空");
		}
		
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=admin.getClazz();
		
		
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("stuName", personalHonor.getStudent().getStuName());
		properties.put("clazz.id", personalHonor.getStudent().getClazz().getId());
		List<Student> students=Student.findStudentsByProperties(properties);
		if(students.size()==0){
			bindingResult.reject("personalHonor.student.stuName.required", "学生姓名有误或该学生不存在");
		}
		if(bindingResult.hasErrors()){
			return "admin-introduction";
		}
		
		for(FieldError error: bindingResult.getFieldErrors()){
			System.out.println(error.getDefaultMessage());
		}
		personalHonor.setPersonalHonorDate(new Date());
		personalHonor.setStudent(students.get(0));
		personalHonor.setClazz(clazz);
		
		personalHonor.persist();
		return "admin-introduction";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String create(@PathVariable("id") Long id, BindingResult bindingResult, HttpSession session){
		PersonalHonor personalHonor=PersonalHonor.findPersonalHonor(id);
		Admin admin=(Admin)session.getAttribute("admin");
		if(personalHonor==null||personalHonor.getClazz()==null||personalHonor.getClazz().getId().equals(admin.getClazz().getId())){
			bindingResult.reject("personalHonor.id.required", "个人荣誉已删除或不存在");
			return "admin-introduction";
		}
		personalHonor.remove();
		return "admin-introduction";
	}
}
