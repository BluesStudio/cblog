package cn.edu.cqupt.cblog.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.edu.cqupt.cblog.domain.BlogUser;

@Component
public class BlogUserRegisterValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(BlogUser.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target==null){
			errors.reject("blogUser.username.required", "用户名不能为空");
			errors.reject("blogUser.passwd.required", "密码不能为空");
		}else{
			BlogUser blogUser=(BlogUser)target;
			if(blogUser.getUsername()==null||blogUser.getUsername().trim().equals("")){
				errors.reject("blogUser.username.required", "用户名不能为空");
			}else if(blogUser.getUsername().length()<3||blogUser.getUsername().length()>20){
				errors.reject("blogUser.username.required", "用户名长度只能为3-20");
			}
			if(blogUser.getPasswd()==null||blogUser.getPasswd().trim().equals("")){
				errors.reject("blogUser.passwd.required", "密码不能为空");
			}else if(blogUser.getPasswd().length()<6||blogUser.getPasswd().length()>60){
				errors.reject("blogUser.passwd.required", "密码长度只能为6-60");
			}
		}
	}
}
