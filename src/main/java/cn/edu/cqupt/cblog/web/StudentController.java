package cn.edu.cqupt.cblog.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.domain.Student;
import cn.edu.cqupt.cblog.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * 创建学生生成表单
	 * @since 2015-12-10
	 * */
	@RequestMapping(value="/create",method=RequestMethod.GET, produces="text/html")
	public String createForm(){
		return "admin-members-add";
	}
	
	/**
	 * 提交创建的学生
	 * */
	@RequestMapping(value="/create", method=RequestMethod.POST, produces="text/html")
	public String create(@ModelAttribute("student") Student student, BindingResult bindingResult, HttpSession session, Model model){
		Clazz clazz=((Admin)session.getAttribute("admin")).getClazz();
		student.setClazz(clazz);
		studentService.create(student, bindingResult);
		
		if(bindingResult.hasErrors()){
			for(ObjectError error:bindingResult.getAllErrors()){
				//System.out.println(error.getCode()+":"+error.getDefaultMessage());
				model.addAttribute(error.getCode(), error.getDefaultMessage());
			}
			return "admin-members-add";
		}
		return "redirect:/students/list";
	}
	@RequestMapping(value="/admin-members", method=RequestMethod.GET, produces="text/html")
	public String list(){
		return "admin-members";
	}
	
	@RequestMapping("/admin-members-apply")
	public String admin_members_apply(){
		return "admin-members-apply";
	}
	
	//这个方法可增加一些参数
	/**
	 * 学生分页
	 * */
	@RequestMapping(value="/list",method=RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> listToJson(@RequestParam(value="page", required=false) Integer page, @RequestParam(value="size", required=false) Integer size, @RequestParam(value="sortFieldName", required=false) String sortFieldName, @RequestParam(value="sortOrder", required=false) String sortOrder, @RequestParam(value="clazzName", required=false) String clazzName, Model model){
		Integer pageNum=page==null? 1:page;
		Integer sizeNum=size==null? 15:size;
		String sortFieldNameStr=sortFieldName==null? "id":sortFieldName;
		String sortOrderStr=sortOrder==null? "DESC":sortOrder;
		
		int firstResult=(pageNum-1)*sizeNum;
		int maxResults=sizeNum;
		List<Student> students=null;
		long recordNum=0L;
		if(!(clazzName==null||clazzName.trim().equals(""))){
			Map<String, Object> properties=new HashMap<String, Object>();
			properties.put("clazz.clazzName", clazzName);
			students=Student.findStudentEntriesByProperties(firstResult, maxResults, sortFieldNameStr, sortOrderStr, properties);
			recordNum=Student.countStudents(properties);
		}else{
			students=Student.findStudentEntries(firstResult, maxResults, sortFieldNameStr, sortOrderStr);
			recordNum=Student.countStudents();
		}
		long maxPage=recordNum%sizeNum==0? recordNum/sizeNum:recordNum/sizeNum+1;
		JSONObject json=new JSONObject();
		json.put("page", pageNum);
		json.put("maxPage", maxPage);
		JSONArray jsonArr=new JSONArray();
		for(Student student:students){
			JSONObject subJson=new JSONObject();
			subJson.put("id", student.getId());
			subJson.put("clazzId", student.getClazz().getId());
			subJson.put("stuId", student.getStuId());
			subJson.put("stuName", student.getStuName());
			subJson.put("age", student.getAge());
			subJson.put("gender", student.getGender());
			subJson.put("stuImg", student.getStuImg());
			subJson.put("motto", student.getMotto());
			jsonArr.add(subJson);
		}
		json.put("students", jsonArr);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(json.toString(), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces="text/html")
	public String delete(){
		return "";
	}
}
