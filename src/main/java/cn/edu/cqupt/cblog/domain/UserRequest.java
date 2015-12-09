package cn.edu.cqupt.cblog.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class UserRequest {

    /**
     */
    private String clazzName;

    /**
     */
    private String stuName;

    /**
     */
    private String stuId;

    /**
     */
    private String reason;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date userRequestDate;

    /**
     */
    private String dispose;

    /**
     */
    @ManyToOne
    private BlogUser blogUser;

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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("clazzName", "stuName", "stuId", "reason", "userRequestDate", "dispose", "blogUser");

	public static final EntityManager entityManager() {
        EntityManager em = new UserRequest().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countUserRequests() {
        return entityManager().createQuery("SELECT COUNT(o) FROM UserRequest o", Long.class).getSingleResult();
    }

	public static List<UserRequest> findAllUserRequests() {
        return entityManager().createQuery("SELECT o FROM UserRequest o", UserRequest.class).getResultList();
    }

	public static List<UserRequest> findAllUserRequests(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM UserRequest o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, UserRequest.class).getResultList();
    }

	public static UserRequest findUserRequest(Long id) {
        if (id == null) return null;
        return entityManager().find(UserRequest.class, id);
    }

	public static List<UserRequest> findUserRequestEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM UserRequest o", UserRequest.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<UserRequest> findUserRequestEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM UserRequest o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, UserRequest.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            UserRequest attached = UserRequest.findUserRequest(this.id);
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
    public UserRequest merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        UserRequest merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String getClazzName() {
        return this.clazzName;
    }

	public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

	public String getStuName() {
        return this.stuName;
    }

	public void setStuName(String stuName) {
        this.stuName = stuName;
    }

	public String getStuId() {
        return this.stuId;
    }

	public void setStuId(String stuId) {
        this.stuId = stuId;
    }

	public String getReason() {
        return this.reason;
    }

	public void setReason(String reason) {
        this.reason = reason;
    }

	public Date getUserRequestDate() {
        return this.userRequestDate;
    }

	public void setUserRequestDate(Date userRequestDate) {
        this.userRequestDate = userRequestDate;
    }

	public String getDispose() {
        return this.dispose;
    }

	public void setDispose(String dispose) {
        this.dispose = dispose;
    }

	public BlogUser getBlogUser() {
        return this.blogUser;
    }

	public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }
}
