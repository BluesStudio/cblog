package cn.edu.cqupt.cblog.domain;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import javax.persistence.TypedQuery;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Album {

    /**
     */
    private String image;
    /**
     * 新增图片文件
     * @since 2015-12-12
     * */
    //private File imageFile;

    /**
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date albumDate;
    
    //新增
    @ManyToOne
    private Clazz clazz;
    /**
     */
    @Value("0")
    private Integer zan;

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

	
	public Clazz getClazz() {
		return clazz;
	}


	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
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

	public String getImage() {
        return this.image;
    }

	public void setImage(String image) {
        this.image = image;
    }

	public Date getAlbumDate() {
        return this.albumDate;
    }

	public void setAlbumDate(Date albumDate) {
        this.albumDate = albumDate;
    }

	public Integer getZan() {
        return this.zan;
    }

	public void setZan(Integer zan) {
        this.zan = zan;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("image", "albumDate", "zan");

	public static final EntityManager entityManager() {
        EntityManager em = new Album().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAlbums() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Album o", Long.class).getSingleResult();
    }
	///新增
	public static long countAlbums(Map<String, Object> properties) {
		StringBuilder jpaQueryBuilder=new StringBuilder();
		for(String key: properties.keySet()){
			jpaQueryBuilder.append(" and o."+key+" = :"+key.replace(".", ""));
		}
		String jpaQuery="SELECT COUNT(o) FROM Album o";
		if(jpaQueryBuilder.length()>0){
			jpaQuery+=" where"+jpaQueryBuilder.substring(4);;
		}
		Long result=0L;
		try{
			TypedQuery<Long> query=entityManager().createQuery(jpaQuery, Long.class);
			for(Entry<String, Object> entry: properties.entrySet()){
				query.setParameter(entry.getKey().replace(".", ""), entry.getValue());
			}
			//若无结果，返回一个size为0的list
			result=query.getSingleResult();
		//}catch(NoResultException e){//这里好奇怪，抛出这种异常怎么不行
		}catch(Exception e){
			// 未找到相关实体信息");
		}
		return result;
    }
	
	public static List<Album> findAllAlbums() {
        return entityManager().createQuery("SELECT o FROM Album o", Album.class).getResultList();
    }

	public static List<Album> findAllAlbums(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Album o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Album.class).getResultList();
    }

	public static Album findAlbum(Long id) {
        if (id == null) return null;
        return entityManager().find(Album.class, id);
    }
	/**
	 * @since 2015-12-10
	 * 新增，根据属性集查找
	 * */
	public static List<Album> findAlbumsByProperties(Map<String, Object> properties){
		
		StringBuilder jpaQueryBuilder=new StringBuilder();
		for(String key: properties.keySet()){
			jpaQueryBuilder.append(" and o."+key+" = :"+key.replace(".", ""));
		}
		String jpaQuery="select o from Album o";
		if(jpaQueryBuilder.length()>0){
			jpaQuery+=" where"+jpaQueryBuilder.substring(4);;
		}
		List<Album> albums=null;
		try{
			TypedQuery<Album> query=entityManager().createQuery(jpaQuery, Album.class);
			for(Entry<String, Object> entry: properties.entrySet()){
				query.setParameter(entry.getKey().replace(".", ""), entry.getValue());
			}
			//若无结果，返回一个size为0的list
			albums=query.getResultList();
		//}catch(NoResultException e){//这里好奇怪，抛出这种异常怎么不行
		}catch(Exception e){
			// 未找到相关实体信息");
		}
		return albums;
	}
	public static List<Album> findAlbumEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Album o", Album.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	/**
	 * 新增，根据属性集查找分页结果
	 * @since 2015-12-11
	 * */
	public static List<Album> findAlbumEntriesByProperties(int firstResult, int maxResults, String sortFieldName, String sortOrder, Map<String, Object> properties) {
		StringBuilder jpaQueryBuilder=new StringBuilder();
		for(String key: properties.keySet()){
			jpaQueryBuilder.append(" and o."+key+" = :"+key.replace(".", ""));//去掉参数中的.
		}
		String jpaQuery = "SELECT o FROM Album o";
		if(jpaQueryBuilder.length()>0){
			jpaQuery+=" where"+jpaQueryBuilder.substring(4);;
		}
		if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
		TypedQuery<Album> query=entityManager().createQuery(jpaQuery, Album.class).setFirstResult(firstResult).setMaxResults(maxResults);
		List<Album> albums=null;
		try{
			for(Entry<String, Object> entry: properties.entrySet()){
				query=query.setParameter(entry.getKey().replace(".", ""), entry.getValue());
			}
			//若无结果，返回一个size为0的list
			albums=query.getResultList();
		//}catch(NoResultException e){//这里好奇怪，抛出这种异常怎么不行
		}catch(Exception e){
			//未找到相关实体信息");
		}
		return albums;
    }
	
	public static List<Album> findAlbumEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Album o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Album.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Album attached = Album.findAlbum(this.id);
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
    public Album merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Album merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
