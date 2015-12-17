package cn.edu.cqupt.cblog.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.edu.cqupt.cblog.domain.Article;

@Component
public class ArticleUpdateValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Article.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Article article=(Article)target;
		if(article==null){
			errors.reject("article_id_required", "修改的文章不存在");
			errors.reject("article_title_required", "题目不能为空");
			errors.reject("article_activityDate_required", "活动时间不能为空");
			errors.reject("article_site_required", "活动地点不能为空");
			errors.reject("article_participant_required", "参与者不能为空");
			errors.reject("article_content_required", "文章内容不能为空");
		}else{
			if(article.getTitle()==null||article.getTitle().trim().equals("")){
				errors.reject("article_title_required", "题目不能为空");
			}
			if(article.getActivityDate()==null){
				errors.reject("article_activityDate_required", "活动时间不能为空");
			}
			if(article.getSite()==null||article.getSite().trim().equals("")){
				errors.reject("article_site_required", "活动地点不能为空");
			}
			if(article.getParticipant()==null||article.getParticipant().trim().equals("")){
				errors.reject("article_participant_required", "参与者不能为空");	
			}
			if(article.getContent()==null||article.getContent().trim().equals("")){
				errors.reject("article_content_required", "文章内容不能为空");
			}
		}
		
	}

}
