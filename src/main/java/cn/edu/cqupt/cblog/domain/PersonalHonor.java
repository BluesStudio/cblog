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
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class PersonalHonor {

    /**
     */
    @NotNull
    @Size(max = 100)
    private String award;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date personalHonorDate;

    /**
     */
    @ManyToOne
    private Student student;

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("award", "personalHonorDate", "student");

	public static final EntityManager entityManager() {
        EntityManager em = new PersonalHonor().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPersonalHonors() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PersonalHonor o", Long.class).getSingleResult();
    }

	public static List<PersonalHonor> findAllPersonalHonors() {
        return entityManager().createQuery("SELECT o FROM PersonalHonor o", PersonalHonor.class).getResultList();
    }

	public static List<PersonalHonor> findAllPersonalHonors(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PersonalHonor o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PersonalHonor.class).getResultList();
    }

	public static PersonalHonor findPersonalHonor(Long id) {
        if (id == null) return null;
        return entityManager().find(PersonalHonor.class, id);
    }

	public static List<PersonalHonor> findPersonalHonorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PersonalHonor o", PersonalHonor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<PersonalHonor> findPersonalHonorEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PersonalHonor o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PersonalHonor.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            PersonalHonor attached = PersonalHonor.findPersonalHonor(this.id);
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
    public PersonalHonor merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PersonalHonor merged = this.entityManager.merge(this);
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

	public String getAward() {
        return this.award;
    }

	public void setAward(String award) {
        this.award = award;
    }

	public Date getPersonalHonorDate() {
        return this.personalHonorDate;
    }

	public void setPersonalHonorDate(Date personalHonorDate) {
        this.personalHonorDate = personalHonorDate;
    }

	public Student getStudent() {
        return this.student;
    }

	public void setStudent(Student student) {
        this.student = student;
    }
}
