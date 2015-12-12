package cn.edu.cqupt.cblog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import libs.fastjson.com.alibaba.fastjson.JSON;

import com.alibaba.media.MediaConfiguration;
import com.alibaba.media.Result;
import com.alibaba.media.upload.MultipartCancelRequest;
import com.alibaba.media.upload.MultipartCompleteRequest;
import com.alibaba.media.upload.MultipartCompleteResponse;
import com.alibaba.media.upload.MultipartInitRequest;
import com.alibaba.media.upload.MultipartInitResponse;
import com.alibaba.media.upload.MultipartUploadRequest;
import com.alibaba.media.upload.MultipartUploadResponse;
import com.alibaba.media.upload.UploadClient;
import com.alibaba.media.upload.UploadPolicy;
import com.alibaba.media.upload.UploadRequest;
import com.alibaba.media.upload.UploadResponse;
import com.alibaba.media.upload.UploadTokenClient;
import com.alibaba.media.upload.impl.DefaultUploadClient;
import com.alibaba.media.upload.impl.DefaultUploadTokenClient;

public class FileUploadUtil {
    private static final Integer PART_SIZE = 100 * 1024;

    private static final UploadClient client;

    private static String TOKEN;

    static {
        /**
         * 初始化 MediaConfiguration
         * 配置图片服务的AK:           AccessKey、AccessKeySecret
         * 配置图片服务的namespace:
         */
        MediaConfiguration configuration = new MediaConfiguration();
        configuration.setType(MediaConfiguration.TYPE_TOP);
        configuration.setAk("23185093");
        configuration.setSk("e2aa2dfe9fe12e7521578285fad7f499");
        configuration.setNamespace("xiaofeig");
        UploadTokenClient tokenClient = new DefaultUploadTokenClient(configuration);

        /**
         * 为用户指定上传策略
         * 下面的上传策略指定了:
         *      用户上传文件允许覆盖
         *      该用户凭证的失效时间为当前时间之后的一个小时, 在之后的一个小时之内Token都可以作为用户的上传凭证
         *      失效时间设置为-1时表示永不失效
         */
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);

        /**
         * 请求Token服务,为该用户申请该上传策略对应的Token
         */
        TOKEN = tokenClient.getUploadToken(uploadPolicy);

        /**
         * 初始化 UploadClient
         */
        client = new DefaultUploadClient();
    }

    /**
     * 运行示例代码的入口
     */
/*    public static void main(String[] args) throws IOException {
    	File file=new File("C:/Users/xiaofeig/Desktop/陈奕迅.jpg");
    	Result<UploadResponse> result=FileUploadUtil.uploadFile(file, "cblog/album", "陈奕迅.jpg");
    	System.out.println("---------------:"+result.getData().getUrl());
    	System.out.println(result.toString());
    }*/
    
    
    /**
     * @author xiaofeig
     * @description 上传图片的入口  
     * @param file 上传的文件
     * @param dir 上传文件至目录dir下
     * @param name 文件名
     * */
    public static Result<UploadResponse> uploadFile(File file,String dir,String name){
        UploadRequest uploadRequest = new UploadRequest(TOKEN);    	
        uploadRequest.setFile(file);
        uploadRequest.setDir(dir);
        uploadRequest.setName(name);
        Result<UploadResponse> result = client.upload(uploadRequest);
        /*if (result.isSuccess()) {
            // 调用接口成功,打印出上传接口的返回信息
            System.out.println(JSON.toJSONString(result.getData()));
        } else {
            // 调用接口失败,输出错误信息便于排查问题
            System.out.println(JSON.toJSONString(result));
        }*/
        return result;
    }

    /**
     * 实例一
     * 用户直接上传多媒体文件
     */
    public static void upload() {
        UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setFile(getFile("image/image.jpg"));
        uploadRequest.setDir("dir");
        uploadRequest.setName("upload");
        Result<UploadResponse> result = client.upload(uploadRequest);
        /*if (result.isSuccess()) {
            // 调用接口成功,打印出上传接口的返回信息
            System.out.println(JSON.toJSONString(result.getData()));
        } else {
            // 调用接口失败,输出错误信息便于排查问题
            System.out.println(JSON.toJSONString(result));
        }*/
    }

    /**
     * 实例二
     * 分片上传完整流程用于大文件上传
     * 注: 单片最小不能小于100KB,最后一片无大小限制s
     */
    public static void blockUpload() throws IOException {
        File contentFile = getFile("image/image.bmp");
        int partCount = (int) ((contentFile.length() - 1) / PART_SIZE + 1);
        if (partCount <= 1) {
            throw new IllegalArgumentException("at least two pieces of block. when using block upload." + PART_SIZE);
        }

        /**
         * 初始化分片上传
         * parts 用于记录每一个分片上传之后得到的ETag, 在最后完成分片上传时提供
         */
        InputStream in = new FileInputStream(contentFile);
        List<MultipartCompleteRequest.PartInfo> parts = new ArrayList<MultipartCompleteRequest.PartInfo>();
        MultipartInitRequest initRequest = new MultipartInitRequest(TOKEN);
        initRequest.setDir("dir");
        initRequest.setName("block");
        initRequest.setContentSize(PART_SIZE);
        initRequest.setContent(in);
        Result<MultipartInitResponse> multipartInitResult = client.multipartInit(initRequest);
        in.close();

        if (!multipartInitResult.isSuccess()) {
            // 初始化分片上传失败,直接退出
            System.out.println("MultipartInit failed. ErrorMsg: " + multipartInitResult.toString());
            return;
        } else {
            // 初始化成功,可以把ETag打印出来,ETag即各个片的MD5值
            System.out.println(multipartInitResult.getData().geteTag());
        }

        parts.add(new MultipartCompleteRequest.PartInfo(multipartInitResult.getData().getPartNumber(), multipartInitResult.getData().geteTag()));


        /**
         * 分片上传剩余分片
         */
        for (int i = 1; i < partCount; i++) {
            long start = PART_SIZE * i;
            long curPartSize = PART_SIZE < contentFile.length() - start ? PART_SIZE : contentFile.length() - start;

            in = new FileInputStream(contentFile);
            in.skip(start);
            MultipartUploadRequest uploadRequest = new MultipartUploadRequest(TOKEN);
            uploadRequest.setContentSize(curPartSize);
            uploadRequest.setId(multipartInitResult.getData().getId());
            uploadRequest.setUploadId(multipartInitResult.getData().getUploadId());
            uploadRequest.setPartNumber(i + 1);
            uploadRequest.setContent(in);
            Result<MultipartUploadResponse> uploadResult = client.multipartUpload(uploadRequest);
            in.close();

            if (!uploadResult.isSuccess()) {
                // 某个分片上传失败,打印错误信息;注: 这里为了演示方便没有重试,开发者可以根据自己情况决定是否重试
                System.out.println("MultipartUpload failed. ErrorMsg: " + uploadResult.toString());
                return;
            }

            parts.add(new MultipartCompleteRequest.PartInfo(uploadResult.getData().getPartNumber(), uploadResult.getData().geteTag()));
        }

        /**
         * 完成分片上传
         */
        MultipartCompleteRequest completeRequest = new MultipartCompleteRequest(TOKEN);
        completeRequest.setDir(multipartInitResult.getData().getDir());
        completeRequest.setName(multipartInitResult.getData().getName());
        completeRequest.setId(multipartInitResult.getData().getId());
        completeRequest.setUploadId(multipartInitResult.getData().getUploadId());
        completeRequest.setParts(parts);
        Result<MultipartCompleteResponse> completeResult = client.multipartComplete(completeRequest);
        if (!completeResult.isSuccess()) {
            // 完成分片接口调用失败,打印错误信息
            System.out.println(JSON.toJSONString(completeResult));
        } else {
            System.out.println(JSON.toJSONString("Multipart Upload Success.UploadId: " + multipartInitResult.getData().getUploadId()));
        }
    }

    /**
     * 实例三
     * 用户分片上传, 并在中途取消上传
     */
    public static void blockUploadCancel() throws IOException {
        File contentFile = getFile("image/image.bmp");
        int partCount = (int) ((contentFile.length() - 1) / PART_SIZE + 1);
        if (partCount <= 1) {
            throw new IllegalArgumentException("at least two pieces of block. when using block upload." + PART_SIZE);
        }

        /**
         * 初始化分片上传
         */
        InputStream input = new FileInputStream(contentFile);
        MultipartInitRequest initRequest = new MultipartInitRequest(TOKEN);
        initRequest.setDir("dir");
        initRequest.setName("block");
        initRequest.setContentSize(PART_SIZE);
        initRequest.setContent(input);
        Result<MultipartInitResponse> multipartInitResult = client.multipartInit(initRequest);
        input.close();
        if (!multipartInitResult.isSuccess()) {
            // 初始化分片上传失败,直接退出
            System.out.println("MultipartInit failed. ErrorMsg: " + multipartInitResult.toString());
            return;
        } else {
            // 初始化成功,可以把ETag打印出来,ETag即各个片的MD5值
            System.out.println(multipartInitResult.getData().geteTag());
        }

        /**
         * 取消分片上传
         */
        MultipartCancelRequest cancelRequest = new MultipartCancelRequest(TOKEN);
        cancelRequest.setDir(multipartInitResult.getData().getDir());
        cancelRequest.setName(multipartInitResult.getData().getName());
        cancelRequest.setId(multipartInitResult.getData().getId());
        cancelRequest.setUploadId(multipartInitResult.getData().getUploadId());
        client.multipartCancel(cancelRequest);
        System.out.println();
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 取出resource目录下的多媒体资源文件
     * 你也可以改写这个方法, 直接取出本地文件.
     *
     * @param path 相对目录
     */
    private static File getFile(String path) {
        URL url = FileUploadUtil.class.getClassLoader().getResource(path);
        assert url != null; //断言: 文件必须存在. 否则找不到上传文件, 程序会直接退出.
        return new File(url.getFile());
    }
}

