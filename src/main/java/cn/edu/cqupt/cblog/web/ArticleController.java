package cn.edu.cqupt.cblog.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Article;
import cn.edu.cqupt.cblog.service.ArticleService;

@Controller
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * 创建文章生成表单
	 * @since 2015-12-10
	 * */
	@RequestMapping(params="form", produces="text/html")
	public String createForm(){
		return "admin-article-edit";
	}
	
	/**
	 * 提交创建的文章
	 * */
	@RequestMapping(method=RequestMethod.POST, produces="text/html")
	public String create(@ModelAttribute("article") Article article, BindingResult bindingResult, HttpSession session){
		article.setClazz(((Admin)session.getAttribute("admin")).getClazz());
		article.setPublishDate(new Date());
		//System.out.println(ReflectionToStringBuilder.toString(article, ToStringStyle.SIMPLE_STYLE));
		articleService.create(article, bindingResult);
		/*System.out.println("------------------------------");
		System.out.println(ReflectionToStringBuilder.toString(bindingResult, ToStringStyle.SIMPLE_STYLE));
		System.out.println("------------------------------");*/
		if(bindingResult.hasErrors()){
			return "admin-article-edit";
		}
		return "admin-article";
	}
	
	
	/**
	 * 更新文章生成表单
	 * @since 2015-12-10
	 * */
	@RequestMapping(value="/{id}", params="form", produces="text/html")
	public String updateForm(@PathVariable("id") Long id, Model model){
		model.addAttribute("article", Article.findArticle(id));
		return "admin-article-update";
	}
	
	/**
	 * 提交更新的文章
	 * @since 2015-12-12
	 * */
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="text/html")
	public String update(@ModelAttribute("article") Article temp, BindingResult bindingResult, HttpSession session, Model model){
		System.out.println("article.update");
		Admin admin=(Admin)session.getAttribute("admin");
		
		Article article=Article.findArticle(temp.getId());
		article.setTitle(temp.getTitle());
		article.setActivityDate(temp.getActivityDate());
		article.setSite(temp.getSite());
		article.setParticipant(temp.getParticipant());
		article.setContent(temp.getContent());
		article.setPublishDate(new Date());
		
		Long clazzId=admin.getClazz().getId();
		articleService.update(article, bindingResult, clazzId);
		if(bindingResult.hasErrors()){
			for(FieldError error:bindingResult.getFieldErrors()){
				System.out.println(error.getDefaultMessage());
			}
			
			model.addAttribute("article", article);
			return "admin-article-update";
		}
		return "redirect:/articles?clazzId="+clazzId;
	}
	
	@RequestMapping(value="/{id}", produces="text/html")
	public String show(@PathVariable("id") Long id, Model model){
		model.addAttribute("article", Article.findArticle(id));
		return "class-article";
	}
	
	//这个方法可增加一些参数
	/**
	 * 文章分页
	 * */
	@RequestMapping(produces="text/html")
	public String list(@RequestParam(value="page", required=false) Integer page, @RequestParam(value="size", required=false) Integer size, @RequestParam(value="sortFieldName", required=false) String sortFieldName, @RequestParam(value="sortOrder", required=false) String sortOrder, @RequestParam(value="clazzId", required=false) Long clazzId, Model model){
		Integer pageNum=page==null? 1:page;
		Integer sizeNum=size==null? 15:size;
		String sortFieldNameStr=sortFieldName==null? "publishDate":sortFieldName;
		String sortOrderStr=sortOrder==null? "DESC":sortOrder;
		
		int firstResult=(pageNum-1)*sizeNum;
		int maxResults=sizeNum;
		List<Article> articles=null;
		if(clazzId!=null){
			Map<String, Object> properties=new HashMap<String, Object>();
			properties.put("clazz.id", clazzId);
			articles=Article.findArticleEntriesByProperties(firstResult, maxResults, sortFieldNameStr, sortOrderStr, properties);
		}else{
			articles=Article.findArticleEntries(firstResult, maxResults, sortFieldNameStr, sortOrderStr);
		}
		
		model.addAttribute("articles", articles);

		/*for(Article article: articles){
			System.out.println("article.id:"+article.getId());
		}*/
		
		return "admin-article";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces="text/html")
	public String delete(){
		return "";
	}
}