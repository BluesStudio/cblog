package cn.edu.cqupt.cblog.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Admin {

    /**
     */
    @NotNull
    @Column(unique = true)
    @Size(max = 30)
    private String username;

    /**
     */
    @NotNull
    @Size(min = 6, max = 60)
    private String passwd;

    /**
     */
    @ManyToOne
    private Clazz clazz;
}
