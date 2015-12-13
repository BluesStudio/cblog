package cn.edu.cqupt.cblog.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String introductionForm(){
		return "admin-introduction-test";
	}
	
	@RequestMapping(value="/mergeOverview", method=RequestMethod.POST)
	public String mergeIntroduction(@ModelAttribute("overview") String overview, @ModelAttribute("clazzImg") MultipartFile clazzImg, HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=admin.getClazz();
		clazz.setOverview(overview);
		clazz.setClazzImg(MultipartFileResolver.resolveMultipartFile(clazzImg));
		admin.setClazz(clazz.merge());
		
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
}
