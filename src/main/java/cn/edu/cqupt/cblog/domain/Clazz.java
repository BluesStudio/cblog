package cn.edu.cqupt.cblog.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Clazz {

    /**
     */
    @NotNull
    @Size(max = 50)
    private String clazzName;

    /**
     */
    @Size(max = 50)
    private String school;

    /**
     */
    @Size(max = 100)
    private String major;

    /**
     */
    private String flagImg;

    /**
     */
    private String song;

    /**
     */
    @Size(max = 200)
    private String songTitle;

    /**
     */
    private String lyric;

    /**
     */
    private String songImg;

    /**
     */
    private String overview;

    /**
     */
    private String clazzImg;

    /**
     */
    private String slogan;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<Student>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Article> articles = new HashSet<Article>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<Album>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<PersonalHonor> personalHonors = new HashSet<PersonalHonor>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<HonorWall> honorWalls = new HashSet<HonorWall>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ClazzHonor> clazzHonors = new HashSet<ClazzHonor>();

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

	public String getClazzName() {
        return this.clazzName;
    }

	public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

	public String getSchool() {
        return this.school;
    }

	public void setSchool(String school) {
        this.school = school;
    }

	public String getMajor() {
        return this.major;
    }

	public void setMajor(String major) {
        this.major = major;
    }

	public String getFlagImg() {
        return this.flagImg;
    }

	public void setFlagImg(String flagImg) {
        this.flagImg = flagImg;
    }

	public String getSong() {
        return this.song;
    }

	public void setSong(String song) {
        this.song = song;
    }

	public String getSongTitle() {
        return this.songTitle;
    }

	public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

	public String getLyric() {
        return this.lyric;
    }

	public void setLyric(String lyric) {
        this.lyric = lyric;
    }

	public String getSongImg() {
        return this.songImg;
    }

	public void setSongImg(String songImg) {
        this.songImg = songImg;
    }

	public String getOverview() {
        return this.overview;
    }

	public void setOverview(String overview) {
        this.overview = overview;
    }

	public String getClazzImg() {
        return this.clazzImg;
    }

	public void setClazzImg(String clazzImg) {
        this.clazzImg = clazzImg;
    }

	public String getSlogan() {
        return this.slogan;
    }

	public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

	public Set<Student> getStudents() {
        return this.students;
    }

	public void setStudents(Set<Student> students) {
        this.students = students;
    }

	public Set<Article> getArticles() {
        return this.articles;
    }

	public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

	public Set<Album> getAlbums() {
        return this.albums;
    }

	public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

	public Set<PersonalHonor> getPersonalHonors() {
        return this.personalHonors;
    }

	public void setPersonalHonors(Set<PersonalHonor> personalHonors) {
        this.personalHonors = personalHonors;
    }

	public Set<HonorWall> getHonorWalls() {
        return this.honorWalls;
    }

	public void setHonorWalls(Set<HonorWall> honorWalls) {
        this.honorWalls = honorWalls;
    }

	public Set<ClazzHonor> getClazzHonors() {
        return this.clazzHonors;
    }

	public void setClazzHonors(Set<ClazzHonor> clazzHonors) {
        this.clazzHonors = clazzHonors;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("clazzName", "school", "major", "flagImg", "song", "songTitle", "lyric", "songImg", "overview", "clazzImg", "slogan", "students", "articles", "albums", "personalHonors", "honorWalls", "clazzHonors");

	public static final EntityManager entityManager() {
        EntityManager em = new Clazz().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countClazzes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Clazz o", Long.class).getSingleResult();
    }

	public static List<Clazz> findAllClazzes() {
        return entityManager().createQuery("SELECT o FROM Clazz o", Clazz.class).getResultList();
    }

	public static List<Clazz> findAllClazzes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Clazz o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Clazz.class).getResultList();
    }

	public static Clazz findClazz(Long id) {
        if (id == null) return null;
        return entityManager().find(Clazz.class, id);
    }

	public static List<Clazz> findClazzEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Clazz o", Clazz.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Clazz> findClazzEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Clazz o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Clazz.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Clazz attached = Clazz.findClazz(this.id);
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
    public Clazz merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Clazz merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
