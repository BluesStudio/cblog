package cn.edu.cqupt.cblog.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Student {

    /**
     */
    @NotNull
    @Column(unique = true)
    @Size(max = 50)
    private String username;

    /**
     */
    @NotNull
    @Size(max = 100)
    private String passwd;

    /**
     */
    @NotNull
    @Size(max = 50)
    private String access;

    /**
     */
    @NotNull
    @Size(max = 50)
    private String stuId;

    /**
     */
    @ManyToOne
    private Clazz clazz;

    /**
     */
    private String stuName;

    /**
     */
    private Integer age;

    /**
     */
    private String gender;

    /**
     */
    private String stuImg;

    /**
     */
    private String motto;

    /**
     */
    @ManyToOne
    private BlogUser blogUser;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Tease> send = new HashSet<Tease>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Tease> receive = new HashSet<Tease>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ArticleComment> articleComments = new HashSet<ArticleComment>();
}
