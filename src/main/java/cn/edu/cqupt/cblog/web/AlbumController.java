package cn.edu.cqupt.cblog.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Album;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.util.FileUploadUtil;

import com.alibaba.media.Result;
import com.alibaba.media.upload.UploadResponse;

@Controller
@RequestMapping("/albums")
public class AlbumController {

	/**
	 * 创建相册生成表单
	 * @since 2015-12-10
	 * */
	@RequestMapping(value="/create", produces="text/html", method=RequestMethod.GET)
	public String createForm(){
		return "admin-album-upload";
	}
	
	/**
	 * 提交创建的相册
	 * */
	@RequestMapping(value="/create", method=RequestMethod.POST, produces="text/html")
	public String create(@ModelAttribute("imageFile") MultipartFile imageFile,@ModelAttribute("albumDate") Date albumDate, BindingResult bindingResult, HttpSession session){
		System.out.println("albumController.create post");
		System.out.println("imageFile:"+imageFile.getOriginalFilename());
		
		String filename=imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf(".")+1);
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
		System.out.println("albumController.create:"+file.getAbsolutePath());
		Clazz clazz=null;
		try {
			FileOutputStream out=new FileOutputStream(file);
			InputStream in=imageFile.getInputStream();
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b))>0){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			Result<UploadResponse> result=FileUploadUtil.uploadFile(file,"cblog",filename);
System.out.println("url:"+result.getData().getUrl().toString());
			
			Album album=new Album();
			album.setAlbumDate(albumDate);
			album.setImage(filename);
			clazz=((Admin)session.getAttribute("admin")).getClazz();
			album.setClazz(clazz);
			album.persist();
System.out.println("filename:"+filename);
			
			/*if(clazz.getAlbums()==null){
				clazz.setAlbums(new HashSet<Album>());
			}
			clazz.getAlbums().add(album);
			clazz.merge();*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/albums?clazzId="+clazz.getId();
	}
	
	
	/*@RequestMapping(value="/{id}", produces="text/html")
	public String show(@PathVariable("id") Long id, Model model){
		model.addAttribute("album", Album.findAlbum(id));
		return "class-article";
	}*/

	@RequestMapping(value="/admin-album")
	public String list(){
		return "admin-album";
	}
	
	/**
	 * 文章分页
	 * */
	@RequestMapping(value="/list",method=RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> list(@RequestParam(value="page", required=false) Integer page, @RequestParam(value="size", required=false) Integer size, @RequestParam(value="sortFieldName", required=false) String sortFieldName, @RequestParam(value="sortOrder", required=false) String sortOrder, @RequestParam(value="clazzName", required=false) String clazzName, Model model){
		Integer pageNum=page==null? 1:page;
		Integer sizeNum=size==null? 15:size;
		String sortFieldNameStr=sortFieldName==null? "albumDate":sortFieldName;
		String sortOrderStr=sortOrder==null? "DESC":sortOrder;
		
		int firstResult=(pageNum-1)*sizeNum;
		int maxResults=sizeNum;
		List<Album> albums=null;
		long recordNum=0L;
		System.out.println("clazzName:"+clazzName);
		if(!(clazzName==null||clazzName.trim().equals(""))){
			Map<String, Object> properties=new HashMap<String, Object>();
			properties.put("clazz.clazzName", clazzName);
			albums=Album.findAlbumEntriesByProperties(firstResult, maxResults, sortFieldNameStr, sortOrderStr, properties);
			System.out.println("albums.size()....:"+albums.size());
			recordNum=Album.countAlbums(properties);
		}else{
			albums=Album.findAlbumEntries(firstResult, maxResults, sortFieldNameStr, sortOrderStr);
			recordNum=Album.countAlbums();
		}
		long maxPage=recordNum%sizeNum==0? recordNum/sizeNum:recordNum/sizeNum+1;
		
		JSONObject json=new JSONObject();
		json.put("page", pageNum);
		json.put("maxPage", maxPage);
		JSONArray jsonArr=new JSONArray();
		for(Album album:albums){
			JSONObject subJson=new JSONObject();
			subJson.put("id", album.getId());
			subJson.put("clazzId", album.getClazz().getId());
			DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
			subJson.put("albumDate", format.format(album.getAlbumDate()));
			subJson.put("image", album.getImage());
			jsonArr.add(subJson);
		}
		json.put("albums", jsonArr);
System.out.println("json.toString:"+json.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(json.toString(), headers, HttpStatus.OK);
	}	
	
}
