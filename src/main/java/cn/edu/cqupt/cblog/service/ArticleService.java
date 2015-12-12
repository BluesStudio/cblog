package cn.edu.cqupt.cblog.service;

import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Article;

public interface ArticleService {

	public void create(Article article, BindingResult bindingResult);
	public void update(Article article, BindingResult bindingResult, Long clazzId);
}
