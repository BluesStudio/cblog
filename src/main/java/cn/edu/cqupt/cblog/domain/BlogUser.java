package cn.edu.cqupt.cblog.domain;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class BlogUser {

    /**
     */
    @NotNull
    @Size(max = 50)
    private String username;

    /**
     */
    @NotNull
    @Size(max = 50)
    private String passwd;

    /**
     */
    @OneToOne
    private Student student;

	public String getUsername() {
        return this.username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

	public String getPasswd() {
        return this.passwd;
    }

	public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

	public Student getStudent() {
        return this.student;
    }

	public void setStudent(Student student) {
        this.student = student;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "passwd", "student");

	public static final EntityManager entityManager() {
        EntityManager em = new BlogUser().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countBlogUsers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM BlogUser o", Long.class).getSingleResult();
    }

	public static List<BlogUser> findAllBlogUsers() {
        return entityManager().createQuery("SELECT o FROM BlogUser o", BlogUser.class).getResultList();
    }

	public static List<BlogUser> findAllBlogUsers(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM BlogUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, BlogUser.class).getResultList();
    }

	public static BlogUser findBlogUser(Long id) {
        if (id == null) return null;
        return entityManager().find(BlogUser.class, id);
    }
	/**
	 * @since 2015-12-10
	 * 新增，根据属性集查找
	 * */
	public static List<BlogUser> findBlogUsersByProperties(Map<String, Object> properties){
		
		StringBuilder jpaQueryBuilder=new StringBuilder();
		for(String key: properties.keySet()){
			jpaQueryBuilder.append(" and o."+key+" = :"+key.replace(".", ""));//去掉参数中的.
		}
		String jpaQuery="select o from BlogUser o";
		if(jpaQueryBuilder.length()>0){
			jpaQuery+=" where"+jpaQueryBuilder.substring(4);;
		}
		List<BlogUser> blogUsers=null;
		try{
			TypedQuery<BlogUser> query=entityManager().createQuery(jpaQuery, BlogUser.class);
			for(Entry<String, Object> entry: properties.entrySet()){
				query=query.setParameter(entry.getKey().replace(".", ""), entry.getValue());
			}
			//若无结果，返回一个size为0的list
			blogUsers=query.getResultList();
		//}catch(NoResultException e){//这里好奇怪，抛出这种异常怎么不行
		}catch(Exception e){
			//未找到相关实体信息");
		}
		return blogUsers;
	}
	public static List<BlogUser> findBlogUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM BlogUser o", BlogUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<BlogUser> findBlogUserEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM BlogUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, BlogUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            BlogUser attached = BlogUser.findBlogUser(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public BlogUser merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        BlogUser merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
