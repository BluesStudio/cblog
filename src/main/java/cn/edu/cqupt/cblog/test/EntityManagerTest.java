package cn.edu.cqupt.cblog.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cqupt.cblog.domain.Article;

public class EntityManagerTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		String jpaQuery="select o from Article o where o.clazz.id = :clazzid";
		List<Article> articles=Article.entityManager().createQuery(jpaQuery, Article.class)
												.setParameter("clazzid", 2L)
												.getResultList();
		System.out.println(articles.size());
		
	}

}
