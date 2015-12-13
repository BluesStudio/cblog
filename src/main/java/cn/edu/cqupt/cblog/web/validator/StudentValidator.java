package cn.edu.cqupt.cblog.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.edu.cqupt.cblog.domain.Student;

@Component
public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Student.class);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		Student student=(Student)target;
		if(student==null){
			errors.reject("article.stuName.required", "姓名不能为空");
			errors.reject("article.stuId.required", "学号不能为空");
			errors.reject("article.age.required", "年龄不能为空");
			errors.reject("article.gender.required", "性别不能为空");
			//errors.reject("article.motto.required", "座右铭不能为空");
			errors.reject("article.stuImg.required", "学生照片不能为空");
		}else{
			if(student.getStuName()==null||student.getStuName().trim().equals("")){
				errors.reject("article.stuName.required", "姓名不能为空");
			}
			if(student.getStuId()==null||student.getStuId().trim().equals("")){
				errors.reject("article.stuId.required", "学号不能为空");
			}
			if(student.getAge()==null){
				errors.reject("article.age.required", "姓名不能为空");
			}else if(student.getAge()<0||student.getAge()>200){
				errors.reject("article.age.required", "年龄参数错误");
			}
			if(student.getGender()==null||student.getGender().trim().equals("")){
				errors.reject("article.gender.required", "性别不能为空");
			}else if(!(student.getGender().equals("unknown")||student.getGender().equals("man")||student.getGender().equals("woman"))){
				errors.reject("article.gender.required", "性别参数错误");
			}
			
		}
		
	}
	
}
