package cn.edu.cqupt.cblog.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

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
    @NotNull
    @Size(max = 50)
    private String school;

    /**
     */
    @NotNull
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
}
