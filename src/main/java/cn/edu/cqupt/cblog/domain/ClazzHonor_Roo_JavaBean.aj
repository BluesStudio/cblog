// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.edu.cqupt.cblog.domain;

import cn.edu.cqupt.cblog.domain.ClazzHonor;
import java.util.Date;

privileged aspect ClazzHonor_Roo_JavaBean {
    
    public String ClazzHonor.getHonorName() {
        return this.honorName;
    }
    
    public void ClazzHonor.setHonorName(String honorName) {
        this.honorName = honorName;
    }
    
    public Date ClazzHonor.getClazzHonorDate() {
        return this.clazzHonorDate;
    }
    
    public void ClazzHonor.setClazzHonorDate(Date clazzHonorDate) {
        this.clazzHonorDate = clazzHonorDate;
    }
    
}
