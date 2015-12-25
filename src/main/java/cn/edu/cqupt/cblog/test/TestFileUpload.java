package cn.edu.cqupt.cblog.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import cn.edu.cqupt.cblog.util.FileUploadUtil;

import com.alibaba.media.Result;
import com.alibaba.media.upload.UploadRequest;
import com.alibaba.media.upload.UploadResponse;

public class TestFileUpload {

	public static void main(String[] args) throws IOException{
		File file=new File("e:/home/imageTemp/4ecab72ca0b84103a60e3f96152a7145.png");
		InputStream in=new FileInputStream(file);
		Result<UploadResponse> result=null;
		result=FileUploadUtil.uploadFile(in, file.length(), "cblog", "helloekkkknheng.png");
		in.close();
		System.out.println(result.getHttpStatus());
		System.out.println(result.getData().getName());
		System.out.println(result.getData().getUrl());
	}
}
