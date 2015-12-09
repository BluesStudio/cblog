package cn.edu.cqupt.cblog.service;

import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Admin;


public interface AdminService {

	public void register(Admin admin, BindingResult result);
}
