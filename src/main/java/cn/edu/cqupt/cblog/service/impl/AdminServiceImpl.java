package cn.edu.cqupt.cblog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.service.AdminService;
import cn.edu.cqupt.cblog.web.validator.AdminLoginValidator;
import cn.edu.cqupt.cblog.web.validator.AdminRegisterValidator;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRegisterValidator adminRegisterValidator;
	@Autowired
	private AdminLoginValidator adminLoginValidator;
	
	public AdminRegisterValidator getAdminRegisterValidator() {
		return adminRegisterValidator;
	}
	public void setAdminRegisterValidator(
			AdminRegisterValidator adminRegisterValidator) {
		this.adminRegisterValidator = adminRegisterValidator;
	}

	
	
	public AdminLoginValidator getAdminLoginValidator() {
		return adminLoginValidator;
	}
	public void setAdminLoginValidator(AdminLoginValidator adminLoginValidator) {
		this.adminLoginValidator = adminLoginValidator;
	}
	@Override
	public void register(Admin admin, BindingResult result) {
		adminRegisterValidator.validate(admin, result);
		if(!result.hasErrors()){
			Map<String, String> adminProperties=new HashMap<String, String>();
			adminProperties.put("username", admin.getUsername());
			Map<String, String> clazzProperties=new HashMap<String, String>();
			clazzProperties.put("clazzName", admin.getClazz().getClazzName());
			boolean flag=false;
			if(Admin.findAdminsByProperties(adminProperties).size()!=0){
				result.reject("admin.username.required", "该用户名已存在");
				flag=true;
			}
			if(Clazz.findClazzsByProperties(clazzProperties).size()!=0){
				result.reject("admin.clazz.clazzName.required", "该班级名称已存在");
				flag=true;
			}
			if(!flag){
				admin.getClazz().persist();
				admin.persist();
			}
		}
	}
	
	@Override
	public void login(Admin admin, BindingResult result) {
		adminLoginValidator.validate(admin, result);
		if(!result.hasErrors()){
			Map<String, String> property=new HashMap<String, String>();
			property.put("username", admin.getUsername());
			if(Admin.findAdminsByProperties(property).get(0)==null){
				result.reject("admin.username.required", "该用户名尚未注册");
			}else{
				Map<String, String> properties=new HashMap<String, String>();
				properties.put("username", admin.getUsername());
				properties.put("passwd", admin.getPasswd());
				Admin adminTemp=Admin.findAdminsByProperties(properties).get(0);
				if(adminTemp==null){
					result.reject("admin.passwd.required", "密码错误");
				}else{
					admin.setId(adminTemp.getId());
				}
			}
		}
	}

	
}
