package cn.edu.cqupt.cblog.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.activerecord.RooJpaActiveRecord;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class UserRequest {

    /**
     */
    private String clazzName;

    /**
     */
    private String stuName;

    /**
     */
    private String stuId;

    /**
     */
    private String reason;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date userRequestDate;

    /**
     */
    private String dispose;

    /**
     */
    @ManyToOne
    private BlogUser blogUser;
}
