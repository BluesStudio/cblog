package cn.edu.cqupt.cblog.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.edu.cqupt.cblog.domain.Admin;

@Component
public class AdminRegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Admin.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target==null){
			errors.reject("admin.username.required", "用户名不能为空");
			errors.reject("admin.passwd.required", "密码不能为空");
			errors.reject("admin.clazz.clazzName.required", "班级名称不能为空");
		}else{
			Admin admin=(Admin)target;
			if(admin.getUsername()==null||admin.getUsername().trim().equals("")){
				errors.reject("admin.username.required", "用户名不能为空");
			}else if(admin.getUsername().length()<3||admin.getUsername().length()>20){
				errors.reject("admin.username.required", "用户名长度只能为3-20");
			}
			if(admin.getPasswd()==null||admin.getPasswd().trim().equals("")){
				errors.reject("admin.passwd.required", "密码不能为空");
			}else if(admin.getPasswd().length()<6||admin.getPasswd().length()>60){
				errors.reject("admin.passwd.required", "密码长度只能为6-60");
			}
			if(admin.getClazz()==null||admin.getClazz().getClazzName()==null||admin.getClazz().getClazzName().trim().equals("")){
				errors.reject("admin.clazz.clazzName.required", "班级名称不能为空");
			}else if(admin.getClazz().getClazzName().length()>50){
				errors.reject("admin.clazz.clazzName.required", "班级名称长度只能为1-50");
			}
		}
	}

	
	
}
