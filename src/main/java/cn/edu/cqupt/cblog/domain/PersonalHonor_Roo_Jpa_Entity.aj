// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.edu.cqupt.cblog.domain;

import cn.edu.cqupt.cblog.domain.PersonalHonor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect PersonalHonor_Roo_Jpa_Entity {
    
    declare @type: PersonalHonor: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long PersonalHonor.id;
    
    @Version
    @Column(name = "version")
    private Integer PersonalHonor.version;
    
    public Long PersonalHonor.getId() {
        return this.id;
    }
    
    public void PersonalHonor.setId(Long id) {
        this.id = id;
    }
    
    public Integer PersonalHonor.getVersion() {
        return this.version;
    }
    
    public void PersonalHonor.setVersion(Integer version) {
        this.version = version;
    }
    
}
