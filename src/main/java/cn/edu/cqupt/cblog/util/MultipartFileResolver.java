package cn.edu.cqupt.cblog.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.media.Result;
import com.alibaba.media.upload.UploadResponse;

public class MultipartFileResolver {

	public static String resolveMultipartFile(MultipartFile multipartfile){
		String filename=multipartfile.getOriginalFilename().substring(multipartfile.getOriginalFilename().lastIndexOf(".")+1);
		String savePath="/home/imageTemp";
		File dir=new File(savePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		filename=UUID.randomUUID().toString().replaceAll("-", "")+"."+filename;
		
		File file=new File(dir, filename);
		try {
			FileOutputStream out=new FileOutputStream(file);
			InputStream in=multipartfile.getInputStream();
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b))>0){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			Result<UploadResponse> result=FileUploadUtil.uploadFile(file,"cblog",filename);
			//上传失败
			//..
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
}
