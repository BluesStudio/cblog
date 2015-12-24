package cn.edu.cqupt.cblog.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.util.MultipartFileResolver;

@Controller
@RequestMapping("/clazzs")
public class ClazzController {
	
	@RequestMapping(value="/admin-introduction", method=RequestMethod.GET)
	public String introductionForm(HttpSession session, Model model){
		Admin admin=(Admin)session.getAttribute("admin");
		session.setAttribute("admin", Admin.findAdmin(admin.getId()));
		return "admin-introduction";
	}
	@RequestMapping(value="/admin-setting", method=RequestMethod.GET)
	public String adminSettingForm(){
		return "admin-setting";
	}
	
	@RequestMapping(value="/mergeOverview", method=RequestMethod.POST)
	public String mergeIntroduction(@ModelAttribute("overview") String overview, @ModelAttribute("clazzImg") MultipartFile clazzImg, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=Clazz.findClazz(admin.getClazz().getId());
		clazz.setOverview(overview);
		if(clazzImg.getOriginalFilename()!=null&&!clazzImg.getOriginalFilename().equals("")){
			clazz.setClazzImg(MultipartFileResolver.resolveMultipartFile(clazzImg));
		}
		clazz.merge();
		admin=Admin.findAdmin(admin.getId());
		session.setAttribute("admin", admin);
		return "redirect:/clazzs/admin-introduction";
	}
	
	@RequestMapping(value="/mergeSlogan", method=RequestMethod.POST)
	public String mergeSlogan(@ModelAttribute("slogan") String slogan, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=admin.getClazz();
		clazz.setSlogan(slogan);
		admin.setClazz(clazz.merge());
		return "redirect:/clazzs/admin-introduction";
	}
	
	@RequestMapping(value="/mergeFlagImg", method=RequestMethod.POST)
	public String mergeFlagImg(@ModelAttribute("flagImg") MultipartFile flagImg, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=admin.getClazz();
		clazz.setFlagImg(MultipartFileResolver.resolveMultipartFile(flagImg));
		admin.setClazz(clazz.merge());
		return "redirect:/clazzs/admin-introduction";
	}
	
	@RequestMapping(value="/mergeSong", method=RequestMethod.POST)
	public String mergeSong(@ModelAttribute("songTitle") String songTitle,@ModelAttribute("lyric") String lyric, @ModelAttribute("song") String song, @ModelAttribute("songFile") MultipartFile songFile, HttpSession session){
		
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=admin.getClazz();
		clazz.setSongTitle(songTitle);
		clazz.setLyric(lyric);
		clazz.setSong(song);
		if(songFile!=null)
			clazz.setSong(MultipartFileResolver.resolveMultipartFile(songFile));
		admin.setClazz(clazz.merge());
		return "redirect:/clazzs/admin-introduction";
	}
	
	

	
	//显示主页
	@RequestMapping(value="/class-home/{clazzName}", method=RequestMethod.GET)
	public String clazz_home(@PathVariable("clazzName") String clazzName, Model model){
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazzName", clazzName);
		model.addAttribute("clazz", Clazz.findClazzsByProperties(properties).get(0));
		return "class-home";
	}
	
	//显示简介
	@RequestMapping(value="/clazzIntroduction/{clazzName}", method=RequestMethod.GET)
	public String clazz_introduction(@PathVariable("clazzName") String clazzName, Model model){
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazzName", clazzName);
		model.addAttribute("clazz", Clazz.findClazzsByProperties(properties).get(0));
		return "class-introduction";
	}
	//显示相册
	@RequestMapping(value="/class-album/{clazzName}", method=RequestMethod.GET)
	public String clazz_album(@PathVariable("clazzName") String clazzName, Model model){
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazzName", clazzName);
		model.addAttribute("clazz", Clazz.findClazzsByProperties(properties).get(0));
		return "class-album";
	}
	//显示成员
	@RequestMapping(value="/class-members/{clazzName}", method=RequestMethod.GET)
	public String clazz_members(@PathVariable("clazzName") String clazzName, Model model){
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazzName", clazzName);
		model.addAttribute("clazz", Clazz.findClazzsByProperties(properties).get(0));
		return "class-members";
	}
}
