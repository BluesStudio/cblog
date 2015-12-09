package cn.edu.cqupt.cblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.service.AdminService;
import cn.edu.cqupt.cblog.web.validator.AdminRegisterValidator;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRegisterValidator adminRegisterValidator;
	
	public AdminRegisterValidator getAdminRegisterValidator() {
		return adminRegisterValidator;
	}
	public void setAdminRegisterValidator(
			AdminRegisterValidator adminRegisterValidator) {
		this.adminRegisterValidator = adminRegisterValidator;
	}

	@Override
	public void register(Admin admin, BindingResult result) {
		adminRegisterValidator.validate(admin, result);
		if(!result.hasErrors()){
			if(Admin.findAdminByUsername(admin.getUsername())!=null){
				result.reject("admin.username.required", "用户名已存在");
			}else{
				admin.persist();
			}
		}
	}

	
}
