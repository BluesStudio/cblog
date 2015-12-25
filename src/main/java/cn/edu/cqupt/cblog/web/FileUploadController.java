package cn.edu.cqupt.cblog.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.cqupt.cblog.util.MultipartFileResolver;

import com.alibaba.media.Result;
import com.alibaba.media.upload.UploadResponse;

@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String uploadFileForm(){
		return "hello";
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<String> uploadFile(@ModelAttribute("uploadFile") MultipartFile uploadFile){
		Result<UploadResponse> result=MultipartFileResolver.resolveMultipartFile(uploadFile);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>("{\"filename\":\""+result.getData().getName()+"\"}", headers, HttpStatus.OK);
	}
}
