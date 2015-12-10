package cn.edu.cqupt.cblog.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cqupt.cblog.domain.Clazz;

public class EntityManagerTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		Map<String, String> properties=new HashMap<String, String>();
		properties.put("clazzName", "0401306");
		List<Clazz> clazzs=Clazz.findClazzsByProperties(properties);
		System.out.println(ReflectionToStringBuilder.toString(clazzs, ToStringStyle.SIMPLE_STYLE));
	}

}
