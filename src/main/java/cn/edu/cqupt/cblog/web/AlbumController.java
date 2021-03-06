package cn.edu.cqupt.cblog.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.edu.cqupt.cblog.util.MultipartFileResolver;

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
	public String create(@ModelAttribute("imageFile") MultipartFile imageFile,@ModelAttribute(value="albumDate") String albumDate, BindingResult bindingResult, HttpSession session, Model model){
		Result<UploadResponse> result=MultipartFileResolver.resolveMultipartFile(imageFile);
		if(result!=null&&result.getHttpStatus()==200){
			Album album=new Album();
			try {
				album.setAlbumDate(new SimpleDateFormat("yyyy-MM-dd").parse(albumDate));
			} catch (ParseException e) {
				e.printStackTrace();
				album.setAlbumDate(new Date());
			}
			album.setImage(result.getData().getName());
			Admin admin=(Admin)session.getAttribute("admin");
			Clazz clazz=admin.getClazz();
			album.setClazz(clazz);
			album.persist();
			model.addAttribute("message", "照片上传成功");
		}else{
			model.addAttribute("message", "照片上传失败");
		}
		model.addAttribute("url", "/cblog/albums/admin-album");
		model.addAttribute("redirectPage", "相册列表");
		return "redirect";
	}
	
	
	/*@RequestMapping(value="/{id}", produces="text/html")
	public String show(@PathVariable("id") Long id, Model model){
		model.addAttribute("album", Album.findAlbum(id));
		return "class-article";
	}*/

	@RequestMapping(value="/admin-album")
	public String list(HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Clazz clazz=Clazz.findClazz(admin.getClazz().getId());
		session.setAttribute("clazz", clazz);
		return "admin-album";
	}
	
	/**
	 * 相册分页
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
		if(!(clazzName==null||clazzName.trim().equals(""))){
			Map<String, Object> properties=new HashMap<String, Object>();
			properties.put("clazz.clazzName", clazzName);
			albums=Album.findAlbumEntriesByProperties(firstResult, maxResults, sortFieldNameStr, sortOrderStr, properties);
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
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(json.toString(), headers, HttpStatus.OK);
	}	
	
}
