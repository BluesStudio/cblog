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
public class Tease {

    /**
     */
    @NotNull
    @Size(max = 200)
    private String content;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date teaseDate;

    /**
     */
    @ManyToOne
    private Student sender;

    /**
     */
    @ManyToOne
    private Student receiver;

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

	public String getContent() {
        return this.content;
    }

	public void setContent(String content) {
        this.content = content;
    }

	public Date getTeaseDate() {
        return this.teaseDate;
    }

	public void setTeaseDate(Date teaseDate) {
        this.teaseDate = teaseDate;
    }

	public Student getSender() {
        return this.sender;
    }

	public void setSender(Student sender) {
        this.sender = sender;
    }

	public Student getReceiver() {
        return this.receiver;
    }

	public void setReceiver(Student receiver) {
        this.receiver = receiver;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("content", "teaseDate", "sender", "receiver");

	public static final EntityManager entityManager() {
        EntityManager em = new Tease().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countTeases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Tease o", Long.class).getSingleResult();
    }

	public static List<Tease> findAllTeases() {
        return entityManager().createQuery("SELECT o FROM Tease o", Tease.class).getResultList();
    }

	public static List<Tease> findAllTeases(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Tease o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Tease.class).getResultList();
    }

	public static Tease findTease(Long id) {
        if (id == null) return null;
        return entityManager().find(Tease.class, id);
    }

	public static List<Tease> findTeaseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Tease o", Tease.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Tease> findTeaseEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Tease o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Tease.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Tease attached = Tease.findTease(this.id);
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
    public Tease merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Tease merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
