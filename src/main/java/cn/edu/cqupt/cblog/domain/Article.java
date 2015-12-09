package cn.edu.cqupt.cblog.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

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
}
