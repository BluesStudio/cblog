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

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ArticleComment {

    /**
     */
    @NotNull
    @Size(max = 2000)
    private String content;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date articleCommentDate;

    /**
     */
    @ManyToOne
    private Student student;

    /**
     */
    @ManyToOne
    private Article article;

	public String getContent() {
        return this.content;
    }

	public void setContent(String content) {
        this.content = content;
    }

	public Date getArticleCommentDate() {
        return this.articleCommentDate;
    }

	public void setArticleCommentDate(Date articleCommentDate) {
        this.articleCommentDate = articleCommentDate;
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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("content", "articleCommentDate", "student", "article");

	public static final EntityManager entityManager() {
        EntityManager em = new ArticleComment().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countArticleComments() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ArticleComment o", Long.class).getSingleResult();
    }

	public static List<ArticleComment> findAllArticleComments() {
        return entityManager().createQuery("SELECT o FROM ArticleComment o", ArticleComment.class).getResultList();
    }

	public static List<ArticleComment> findAllArticleComments(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ArticleComment o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ArticleComment.class).getResultList();
    }

	public static ArticleComment findArticleComment(Long id) {
        if (id == null) return null;
        return entityManager().find(ArticleComment.class, id);
    }

	public static List<ArticleComment> findArticleCommentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ArticleComment o", ArticleComment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<ArticleComment> findArticleCommentEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ArticleComment o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ArticleComment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ArticleComment attached = ArticleComment.findArticleComment(this.id);
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
    public ArticleComment merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ArticleComment merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
