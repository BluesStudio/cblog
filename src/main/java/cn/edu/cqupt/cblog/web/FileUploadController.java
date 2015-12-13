package cn.edu.cqupt.cblog.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.cqupt.cblog.util.FileUploadUtil;

import com.alibaba.media.Result;
import com.alibaba.media.upload.UploadResponse;

@Controller
public class FileUploadController {
	
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
	public ResponseEntity<String> uploadFile(@ModelAttribute("uploadFile") MultipartFile uploadFile){
		String filename=uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".")+1);
		/*if(!(filename.equals("bmp")||filename.equals("gif")||filename.equals("jpeg")||filename.equals("jpg")||filename.equals("png"))){
			break;
		}*/
		
		String savePath="/home/imageTemp";
		File dir=new File(savePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		filename=UUID.randomUUID().toString().replaceAll("-", "")+"."+filename;
		
		File file=new File(dir, filename);
		try {
			FileOutputStream out=new FileOutputStream(file);
			InputStream in=uploadFile.getInputStream();
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b))>0){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			Result<UploadResponse> result=FileUploadUtil.uploadFile(file,"cblog",filename);
System.out.println("url:"+result.getData().getUrl().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>("{\"filename\":\""+filename+"\"}", headers, HttpStatus.OK);
	}
}
