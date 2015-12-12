package cn.edu.cqupt.cblog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Article;
import cn.edu.cqupt.cblog.service.ArticleService;
import cn.edu.cqupt.cblog.web.validator.ArticleValidator;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleValidator articleValidator;

	
	public ArticleValidator getArticleValidator() {
		return articleValidator;
	}

	public void setArticleValidator(ArticleValidator articleValidator) {
		this.articleValidator = articleValidator;
	}
	@Override
	public void create(Article article, BindingResult bindingResult) {
		articleValidator.validate(article, bindingResult);
		if(!bindingResult.hasErrors()){
			article.persist();
		}
	}
	@Override
	public void update(Article article, BindingResult bindingResult, Long clazzId) {
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("id", article.getId());
		properties.put("clazz.id", clazzId);
		if(Article.findArticlesByProperties(properties).size()==0){
			bindingResult.reject("article.id.required", "修改的文章不存在");
		}
		articleValidator.validate(article, bindingResult);
		if(!bindingResult.hasErrors()){
			System.out.println("articleService.update");
			article.persist();
		}
	}
	

}
