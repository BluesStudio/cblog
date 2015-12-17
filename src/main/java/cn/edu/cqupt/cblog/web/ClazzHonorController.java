package cn.edu.cqupt.cblog.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.ClazzHonor;

@Controller
@RequestMapping("/clazzHonors")
public class ClazzHonorController {

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@ModelAttribute("clazzHonor")String clazzHonor, BindingResult bindingResult, HttpSession session, Model model){
		if(clazzHonor==null||clazzHonor.trim().equals("")){
			//bindingResult.reject("clazzHonor.required", "班级荣誉名称不能为空");
			model.addAttribute("clazzHonor_required", "班级荣誉名称不能为空");
			return "admin-introduction";
		}
		
		Admin admin=(Admin)session.getAttribute("admin");
		ClazzHonor honor=new ClazzHonor();
		honor.setClazz(admin.getClazz());
		honor.setClazzHonorDate(new Date());
		honor.setHonorName(clazzHonor);
		honor.persist();
		session.setAttribute("admin", Admin.findAdmin(admin.getId()));
		return "redirect:/clazzs/admin-introduction";
	}
	
	
	@RequestMapping(value="/delete/{id}")
	public String create(@PathVariable("id") Long id, HttpSession session){
		ClazzHonor clazzHonor=ClazzHonor.findClazzHonor(id);
		Admin admin=(Admin)session.getAttribute("admin");
		if(clazzHonor==null||clazzHonor.getClazz()==null||!clazzHonor.getClazz().getId().equals(admin.getClazz().getId())){
			//bindingResult.reject("clazzHonor.id.required", "班级荣誉已删除或不存在");
			System.out.println("null");
			return "redirect:/clazzs/admin-introduction";
		}
		clazzHonor.remove();
		session.setAttribute("admin", Admin.findAdmin(admin.getId()));
		return "redirect:/clazzs/admin-introduction";
	}
	
}
