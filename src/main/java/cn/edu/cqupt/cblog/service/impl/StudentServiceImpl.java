package cn.edu.cqupt.cblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import cn.edu.cqupt.cblog.domain.Student;
import cn.edu.cqupt.cblog.service.StudentService;
import cn.edu.cqupt.cblog.web.validator.StudentValidator;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentValidator studentValidator;

	public StudentValidator getStudentValidator() {
		return studentValidator;
	}

	public void setStudentValidator(StudentValidator studentValidator) {
		this.studentValidator = studentValidator;
	}
	@Override
	public void create(Student student, BindingResult bindingResult) {
		studentValidator.validate(student, bindingResult);
		if(!bindingResult.hasErrors()){
			System.out.println("student.persist");
			student.persist();
		}
	}
}
