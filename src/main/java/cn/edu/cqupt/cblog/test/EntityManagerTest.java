package cn.edu.cqupt.cblog.test;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cqupt.cblog.domain.Admin;

public class EntityManagerTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		EntityManager entityManager=Admin.entityManager();
		String jpaQuery="select o from Admin o where o.username = :username";
		Admin admin=entityManager.createQuery(jpaQuery, Admin.class)
								.setParameter("username", "jjj")
								.getSingleResult();
		System.out.println(ReflectionToStringBuilder.toString(admin, ToStringStyle.SIMPLE_STYLE));
	}

}
