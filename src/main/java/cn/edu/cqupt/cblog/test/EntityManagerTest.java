package cn.edu.cqupt.cblog.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cqupt.cblog.domain.Admin;
import cn.edu.cqupt.cblog.domain.Clazz;

public class EntityManagerTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		Admin admin=Admin.findAdmin(1L);
		Clazz clazz=admin.getClazz();
		System.out.println(clazz.getClazzName());
	}

}
