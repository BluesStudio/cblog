package cn.edu.cqupt.cblog.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class SuperAdmin {

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "passwd");

	public static final EntityManager entityManager() {
        EntityManager em = new SuperAdmin().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSuperAdmins() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SuperAdmin o", Long.class).getSingleResult();
    }

	public static List<SuperAdmin> findAllSuperAdmins() {
        return entityManager().createQuery("SELECT o FROM SuperAdmin o", SuperAdmin.class).getResultList();
    }

	public static List<SuperAdmin> findAllSuperAdmins(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SuperAdmin o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SuperAdmin.class).getResultList();
    }

	public static SuperAdmin findSuperAdmin(Long id) {
        if (id == null) return null;
        return entityManager().find(SuperAdmin.class, id);
    }

	public static List<SuperAdmin> findSuperAdminEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SuperAdmin o", SuperAdmin.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<SuperAdmin> findSuperAdminEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SuperAdmin o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SuperAdmin.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            SuperAdmin attached = SuperAdmin.findSuperAdmin(this.id);
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
    public SuperAdmin merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SuperAdmin merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
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
}
