package cn.edu.cqupt.cblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.BlogUser;
import cn.edu.cqupt.cblog.service.BlogUserService;
import cn.edu.cqupt.cblog.web.validator.BlogUserLoginValidator;
import cn.edu.cqupt.cblog.web.validator.BlogUserRegisterValidator;

@Service
public class BlogUserServiceImpl implements BlogUserService {

	@Autowired
	private BlogUserRegisterValidator blogUserRegisterValidator;
	@Autowired
	private BlogUserLoginValidator blogUserLoginValidator;
	
	public BlogUserRegisterValidator getBlogUserRegisterValidator() {
		return blogUserRegisterValidator;
	}
	public void setBlogUserRegisterValidator(
			BlogUserRegisterValidator blogUserRegisterValidator) {
		this.blogUserRegisterValidator = blogUserRegisterValidator;
	}
	public BlogUserLoginValidator getBlogUserLoginValidator() {
		return blogUserLoginValidator;
	}
	public void setBlogUserLoginValidator(
			BlogUserLoginValidator blogUserLoginValidator) {
		this.blogUserLoginValidator = blogUserLoginValidator;
	}
	@Override
	public void register(BlogUser blogUser, BindingResult result) {
		blogUserRegisterValidator.validate(blogUser, result);
		if(!result.hasErrors()){
			Map<String, Object> blogUserProperties=new HashMap<String, Object>();
			blogUserProperties.put("username", blogUser.getUsername());
			boolean flag=false;
			if(BlogUser.findBlogUsersByProperties(blogUserProperties).size()!=0){
				result.reject("blogUser.username.required", "该用户名已存在");
				flag=true;
			}
			if(!flag){
				blogUser.persist();
			}
		}
	}
	
	@Override
	public void login(BlogUser blogUser, BindingResult result) {
		blogUserLoginValidator.validate(blogUser, result);
		if(!result.hasErrors()){
			Map<String, Object> property=new HashMap<String, Object>();
			property.put("username", blogUser.getUsername());
			if(BlogUser.findBlogUsersByProperties(property).size()==0){
				result.reject("blogUser.username.required", "该用户名尚未注册");
			}else{
				Map<String, Object> properties=new HashMap<String, Object>();
				properties.put("username", blogUser.getUsername());
				properties.put("passwd", blogUser.getPasswd());
				List<BlogUser> blogUsers=BlogUser.findBlogUsersByProperties(properties);
				if(blogUsers.size()==0){
					result.reject("blogUser.passwd.required", "密码错误");
				}else{
					blogUser.setId(blogUsers.get(0).getId());
				}
			}
		}
	}

}
