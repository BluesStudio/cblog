package cn.edu.cqupt.cblog.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ClazzHonor {

    /**
     */
    @NotNull
    @Size(max = 100)
    private String honorName;

    @ManyToOne
    private Clazz clazz;
    
    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date clazzHonorDate;

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

	
	
	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String getHonorName() {
        return this.honorName;
    }

	public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

	public Date getClazzHonorDate() {
        return this.clazzHonorDate;
    }

	public void setClazzHonorDate(Date clazzHonorDate) {
        this.clazzHonorDate = clazzHonorDate;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("honorName", "clazzHonorDate");

	public static final EntityManager entityManager() {
        EntityManager em = new ClazzHonor().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countClazzHonors() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ClazzHonor o", Long.class).getSingleResult();
    }

	public static List<ClazzHonor> findAllClazzHonors() {
        return entityManager().createQuery("SELECT o FROM ClazzHonor o", ClazzHonor.class).getResultList();
    }

	public static List<ClazzHonor> findAllClazzHonors(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ClazzHonor o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ClazzHonor.class).getResultList();
    }

	public static ClazzHonor findClazzHonor(Long id) {
        if (id == null) return null;
        return entityManager().find(ClazzHonor.class, id);
    }

	public static List<ClazzHonor> findClazzHonorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ClazzHonor o", ClazzHonor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<ClazzHonor> findClazzHonorEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ClazzHonor o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ClazzHonor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ClazzHonor attached = ClazzHonor.findClazzHonor(this.id);
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
    public ClazzHonor merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ClazzHonor merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
