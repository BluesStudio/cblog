package cn.edu.cqupt.cblog.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
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
public class Admin {

    /**
     */
    @NotNull
    @Column(unique = true)
    @Size(min=3, max = 20)
    private String username;

    /**
     */
    @NotNull
    @Size(min = 6, max = 60)
    private String passwd;

    /**
     */
    @ManyToOne
    private Clazz clazz;

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "passwd", "clazz");

	public static final EntityManager entityManager() {
        EntityManager em = new Admin().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	
	public static long countAdmins() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Admin o", Long.class).getSingleResult();
    }

	public static List<Admin> findAllAdmins() {
        return entityManager().createQuery("SELECT o FROM Admin o", Admin.class).getResultList();
    }

	public static List<Admin> findAllAdmins(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Admin o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Admin.class).getResultList();
    }

	public static Admin findAdmin(Long id) {
        if (id == null) return null;
        return entityManager().find(Admin.class, id);
    }
	
	/**
	 * @since 2015-12-09
	 * 新增根据用户名查找
	 * */
	public static Admin findAdminByUsername(String username){
		String jpaQuery="select o from Admin o where o.username = :username";
		Admin admin=null;
		try{
			admin=entityManager().createQuery(jpaQuery, Admin.class)
									.setParameter("username", username)
									.getSingleResult();
		}catch(NoResultException e){
			System.err.println("Admin.findAdminByUsername(username) 未找到相关实体信息");
		}
		return admin;
	}
	

	public static List<Admin> findAdminEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Admin o", Admin.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Admin> findAdminEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Admin o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Admin.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Admin attached = Admin.findAdmin(this.id);
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
    public Admin merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Admin merged = this.entityManager.merge(this);
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

	public Clazz getClazz() {
        return this.clazz;
    }

	public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
