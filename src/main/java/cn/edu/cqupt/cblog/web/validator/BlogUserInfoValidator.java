package cn.edu.cqupt.cblog.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.edu.cqupt.cblog.domain.BlogUser;

public class BlogUserInfoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(BlogUser.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BlogUser blogUser=(BlogUser)target;	
		if(blogUser==null){
			
		}
	}

	
}
