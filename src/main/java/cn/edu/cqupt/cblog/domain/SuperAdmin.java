package cn.edu.cqupt.cblog.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class SuperAdmin {

    /**
     */
    @NotNull
    @Size(max = 50)
    private String username;

    /**
     */
    @NotNull
    @Size(max = 50)
    private String passwd;
}
