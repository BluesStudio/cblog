package cn.edu.cqupt.cblog.domain;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
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
public class Student {

    /**
     */
    @Column(unique = true)
    @Size(max = 50)
    private String username;

    /**
     */
    @Size(max = 100)
    private String passwd;

    /**
     */
    @Size(max = 50)
    private String access;

    /**
     */
    @Size(max = 50)
    private String stuId;

    /**
     */
    @ManyToOne
    private Clazz clazz;

    /**
     */
    private String stuName;

    /**
     */
    private Integer age;

    /**
     */
    private String gender;

    /**
     */
    private String stuImg;

    /**
     */
    private String motto;

    /**
     */
    @ManyToOne
    private BlogUser blogUser;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Tease> send = new HashSet<Tease>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Tease> receive = new HashSet<Tease>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ArticleComment> articleComments = new HashSet<ArticleComment>();

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "passwd", "access", "stuId", "clazz", "stuName", "age", "gender", "stuImg", "motto", "blogUser", "send", "receive", "articleComments");

	public static final EntityManager entityManager() {
        EntityManager em = new Student().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countStudents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Student o", Long.class).getSingleResult();
    }
	///新增
	public static long countStudents(Map<String, Object> properties) {
		StringBuilder jpaQueryBuilder=new StringBuilder();
		for(String key: properties.keySet()){
			jpaQueryBuilder.append(" and o."+key+" = :"+key.replace(".", ""));
		}
		String jpaQuery="SELECT COUNT(o) FROM Student o";
		if(jpaQueryBuilder.length()>0){
			jpaQuery+=" where"+jpaQueryBuilder.substring(4);;
		}
		Long result=0L;
		try{
			TypedQuery<Long> query=entityManager().createQuery(jpaQuery, Long.class);
			for(Entry<String, Object> entry: properties.entrySet()){
				query.setParameter(entry.getKey().replace(".", ""), entry.getValue());
			}
			//若无结果，返回一个size为0的list
			result=query.getSingleResult();
		//}catch(NoResultException e){//这里好奇怪，抛出这种异常怎么不行
		}catch(Exception e){
			// 未找到相关实体信息");
		}
		return result;
    }
	public static List<Student> findAllStudents() {
        return entityManager().createQuery("SELECT o FROM Student o", Student.class).getResultList();
    }

	public static List<Student> findAllStudents(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Student o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Student.class).getResultList();
    }

	public static Student findStudent(Long id) {
        if (id == null) return null;
        return entityManager().find(Student.class, id);
    }

	public static List<Student> findStudentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Student o", Student.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
	/**
	 * 新增，根据属性集查找分页结果
	 * @since 2015-12-11
	 * */
	public static List<Student> findStudentEntriesByProperties(int firstResult, int maxResults, String sortFieldName, String sortOrder, Map<String, Object> properties) {
		StringBuilder jpaQueryBuilder=new StringBuilder();
		for(String key: properties.keySet()){
			jpaQueryBuilder.append(" and o."+key+" = :"+key.replace(".", ""));//去掉参数中的.
		}
		String jpaQuery = "SELECT o FROM Student o";
		if(jpaQueryBuilder.length()>0){
			jpaQuery+=" where"+jpaQueryBuilder.substring(4);;
		}
		if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
		TypedQuery<Student> query=entityManager().createQuery(jpaQuery, Student.class).setFirstResult(firstResult).setMaxResults(maxResults);
		List<Student> students=null;
		try{
			for(Entry<String, Object> entry: properties.entrySet()){
				query=query.setParameter(entry.getKey().replace(".", ""), entry.getValue());
			}
			//若无结果，返回一个size为0的list
			students=query.getResultList();
		//}catch(NoResultException e){//这里好奇怪，抛出这种异常怎么不行
		}catch(Exception e){
			//未找到相关实体信息");
		}
		return students;
    }
	public static List<Student> findStudentEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Student o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Student.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Student attached = Student.findStudent(this.id);
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
    public Student merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Student merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
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

	public String getAccess() {
        return this.access;
    }

	public void setAccess(String access) {
        this.access = access;
    }

	public String getStuId() {
        return this.stuId;
    }

	public void setStuId(String stuId) {
        this.stuId = stuId;
    }

	public Clazz getClazz() {
        return this.clazz;
    }

	public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

	public String getStuName() {
        return this.stuName;
    }

	public void setStuName(String stuName) {
        this.stuName = stuName;
    }

	public Integer getAge() {
        return this.age;
    }

	public void setAge(Integer age) {
        this.age = age;
    }

	public String getGender() {
        return this.gender;
    }

	public void setGender(String gender) {
        this.gender = gender;
    }

	public String getStuImg() {
        return this.stuImg;
    }

	public void setStuImg(String stuImg) {
        this.stuImg = stuImg;
    }

	public String getMotto() {
        return this.motto;
    }

	public void setMotto(String motto) {
        this.motto = motto;
    }

	public BlogUser getBlogUser() {
        return this.blogUser;
    }

	public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }

	public Set<Tease> getSend() {
        return this.send;
    }

	public void setSend(Set<Tease> send) {
        this.send = send;
    }

	public Set<Tease> getReceive() {
        return this.receive;
    }

	public void setReceive(Set<Tease> receive) {
        this.receive = receive;
    }

	public Set<ArticleComment> getArticleComments() {
        return this.articleComments;
    }

	public void setArticleComments(Set<ArticleComment> articleComments) {
        this.articleComments = articleComments;
    }
}
