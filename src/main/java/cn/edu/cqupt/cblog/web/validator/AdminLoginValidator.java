package cn.edu.cqupt.cblog.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.edu.cqupt.cblog.domain.Admin;

@Component
public class AdminLoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Admin.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target==null){
			errors.reject("admin.username.required", "用户名不能为空");
			errors.reject("admin.passwd.required", "密码不能为空");
		}else{
			Admin admin=(Admin)target;
			if(admin.getUsername()==null||admin.getUsername().trim().equals("")){
				errors.reject("admin.username.required", "用户名不能为空");
			}
			if(admin.getPasswd()==null||admin.getPasswd().trim().equals("")){
				errors.reject("admin.passwd.required", "密码不能为空");
			}
		}
	}

	
	
}
