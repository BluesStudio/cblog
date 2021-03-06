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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class AlbumComment {

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "MM")
    private Date albumCommentDate;

    /**
     */
    @NotNull
    @Size(max = 500)
    private String content;

    /**
     */
    @ManyToOne
    private Student student;

    /**
     */
    @ManyToOne
    private Article article;

	public Date getAlbumCommentDate() {
        return this.albumCommentDate;
    }

	public void setAlbumCommentDate(Date albumCommentDate) {
        this.albumCommentDate = albumCommentDate;
    }

	public String getContent() {
        return this.content;
    }

	public void setContent(String content) {
        this.content = content;
    }

	public Student getStudent() {
        return this.student;
    }

	public void setStudent(Student student) {
        this.student = student;
    }

	public Article getArticle() {
        return this.article;
    }

	public void setArticle(Article article) {
        this.article = article;
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("albumCommentDate", "content", "student", "article");

	public static final EntityManager entityManager() {
        EntityManager em = new AlbumComment().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAlbumComments() {
        return entityManager().createQuery("SELECT COUNT(o) FROM AlbumComment o", Long.class).getSingleResult();
    }

	public static List<AlbumComment> findAllAlbumComments() {
        return entityManager().createQuery("SELECT o FROM AlbumComment o", AlbumComment.class).getResultList();
    }

	public static List<AlbumComment> findAllAlbumComments(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM AlbumComment o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, AlbumComment.class).getResultList();
    }

	public static AlbumComment findAlbumComment(Long id) {
        if (id == null) return null;
        return entityManager().find(AlbumComment.class, id);
    }

	public static List<AlbumComment> findAlbumCommentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AlbumComment o", AlbumComment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<AlbumComment> findAlbumCommentEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM AlbumComment o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, AlbumComment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            AlbumComment attached = AlbumComment.findAlbumComment(this.id);
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
    public AlbumComment merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        AlbumComment merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
