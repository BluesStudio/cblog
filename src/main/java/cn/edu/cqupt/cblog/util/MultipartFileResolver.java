package cn.edu.cqupt.cblog.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.media.Result;
import com.alibaba.media.upload.UploadResponse;

public class MultipartFileResolver {

	public static Result<UploadResponse> resolveMultipartFile(MultipartFile multipartFile){
		String filename=multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
		filename=UUID.randomUUID().toString().replaceAll("-", "")+"."+filename;
		
		InputStream in=null;
		Result<UploadResponse> result=null;
		try {
			in = multipartFile.getInputStream();
			result=FileUploadUtil.uploadFile(in, multipartFile.getSize(), "cblog", filename);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
