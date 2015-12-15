package cn.edu.cqupt.cblog.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cqupt.cblog.domain.Album;
import cn.edu.cqupt.cblog.domain.Article;

public class EntityManagerTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		Map<String, Object> properties=new HashMap<String, Object>();
		properties.put("clazz.clazzName", "0401306");
		List<Album> albums=Album.findAlbumEntriesByProperties(0, 15, "albumDate", "ASC", properties);
		System.out.println(albums.size());
	}

}
