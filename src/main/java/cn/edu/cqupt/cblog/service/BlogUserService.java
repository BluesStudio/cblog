package cn.edu.cqupt.cblog.service;

import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.BlogUser;

public interface BlogUserService {
	public void register(BlogUser blogUser, BindingResult result);
	public void login(BlogUser blogUser, BindingResult result);
}
