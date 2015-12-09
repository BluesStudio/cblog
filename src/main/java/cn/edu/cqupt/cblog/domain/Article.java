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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Article {

    /**
     */
    @NotNull
    @Size(max = 50)
    private String title;

    /**
     */
    @NotNull
    @Size(max = 50)
    private String participant;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date publishDate;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date activityDate;

    /**
     */
    @NotNull
    @Size(max = 50)
    private String site;

    /**
     */
    @NotNull
    @Size(max = 20000)
    private String content;

    /**
     */
    @ManyToOne
    private Clazz clazz;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ArticleComment> articleComments = new HashSet<ArticleComment>();

	public String getTitle() {
        return this.title;
    }

	public void setTitle(String title) {
        this.title = title;
    }

	public String getParticipant() {
        return this.participant;
    }

	public void setParticipant(String participant) {
        this.participant = participant;
    }

	public Date getPublishDate() {
        return this.publishDate;
    }

	public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

	public Date getActivityDate() {
        return this.activityDate;
    }

	public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

	public String getSite() {
        return this.site;
    }

	public void setSite(String site) {
        this.site = site;
    }

	public String getContent() {
        return this.content;
    }

	public void setContent(String content) {
        this.content = content;
    }

	public Clazz getClazz() {
        return this.clazz;
    }

	public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

	public Set<ArticleComment> getArticleComments() {
        return this.articleComments;
    }

	public void setArticleComments(Set<ArticleComment> articleComments) {
        this.articleComments = articleComments;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("title", "participant", "publishDate", "activityDate", "site", "content", "clazz", "articleComments");

	public static final EntityManager entityManager() {
        EntityManager em = new Article().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countArticles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Article o", Long.class).getSingleResult();
    }

	public static List<Article> findAllArticles() {
        return entityManager().createQuery("SELECT o FROM Article o", Article.class).getResultList();
    }

	public static List<Article> findAllArticles(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Article o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Article.class).getResultList();
    }

	public static Article findArticle(Long id) {
        if (id == null) return null;
        return entityManager().find(Article.class, id);
    }

	public static List<Article> findArticleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Article o", Article.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Article> findArticleEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Article o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Article.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Article attached = Article.findArticle(this.id);
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
    public Article merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Article merged = this.entityManager.merge(this);
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
}
