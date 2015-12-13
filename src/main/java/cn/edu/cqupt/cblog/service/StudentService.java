package cn.edu.cqupt.cblog.service;

import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Student;

public interface StudentService {
	
	public void create(Student student, BindingResult bindingResult);

}
