package cn.edu.cqupt.cblog.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.BlogUser;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.domain.Student;
import cn.edu.cqupt.cblog.domain.UserRequest;

@Controller
@RequestMapping("/userRequests")
public class UserRequestController {

	@RequestMapping("/admin-members-apply")
	public String list(HttpSession session, Model model){
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=admin.getClazz();
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazzName", clazz.getClazzName());
		List<UserRequest> userRequests=UserRequest.findUserRequestsByProperties(properties);
		model.addAttribute("userRequests", userRequests);
		return "admin-members-apply";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("dispose") String dispose, @ModelAttribute("userRequestId") Long userRequestId, HttpSession session, BindingResult bindingResult){
		Clazz clazz=((Admin)session.getAttribute("admin")).getClazz();
		UserRequest userRequest=UserRequest.findUserRequest(userRequestId);
		if(userRequest.getClazzName().equals(clazz.getClazzName())){
			if(dispose.equals("agree")){
				System.out.println("9999");
				userRequest.setDispose(dispose);
				BlogUser blogUser=userRequest.getBlogUser();
				
				//查看该班级是否有对应的学生，若没有，则使用blogUser初识的那个替代，如有，设置blogUser的student
				Map<String, Object> properties=new HashMap<String, Object>();
				properties.put("stuName", userRequest.getStuName());
				properties.put("stuId", userRequest.getStuId());
				properties.put("clazz.clazzName", userRequest.getClazzName());
				List<Student> students=Student.findStudentsByProperties(properties);
				if(students.size()==0){
					System.out.println("students.size:"+students.size());
					Student stu=blogUser.getStudent();
					System.out.println("blogUser:"+blogUser);
					stu.setStuName(userRequest.getStuName());
					stu.setStuId(userRequest.getStuId());
					stu.setClazz(clazz);
					stu.merge();
				}else{
					Student stu=students.get(0);
					blogUser.setStudent(stu);
					blogUser.merge();
				}
				System.out.println("5555555555");
			}else if(dispose.equals("disagree")){
				userRequest.setDispose(dispose);
			}
		}
		System.out.println("--------------");
		return "redirect:/userRequests/admin-members-apply";				
	}
}
