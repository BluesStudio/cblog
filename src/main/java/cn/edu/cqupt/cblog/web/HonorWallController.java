package cn.edu.cqupt.cblog.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.HonorWall;
import cn.edu.cqupt.cblog.util.MultipartFileResolver;


@Controller
@RequestMapping("/honorWalls")
public class HonorWallController {

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@ModelAttribute("honorWall")MultipartFile honorWall, BindingResult bindingResult, HttpSession session){
		HonorWall wall=new HonorWall();
		Admin admin=(Admin)session.getAttribute("admin");
		wall.setClazz(admin.getClazz());
		wall.setImage(MultipartFileResolver.resolveMultipartFile(honorWall));
		wall.persist();
		return "admin-introduction";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String create(@PathVariable("id") Long id, BindingResult bindingResult, HttpSession session){
		HonorWall honorWall=HonorWall.findHonorWall(id);
		Admin admin=(Admin)session.getAttribute("admin");
		if(honorWall==null||honorWall.getClazz()==null||honorWall.getClazz().getId().equals(admin.getClazz().getId())){
			bindingResult.reject("honorWall.id.required", "荣誉墙图片已删除或不存在");
			return "admin-introduction";
		}
		honorWall.remove();
		return "admin-introduction";
	}
}
