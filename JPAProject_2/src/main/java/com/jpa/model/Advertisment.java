package com.jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "Advertisment.findById", query = "SELECT a FROM Advertisment a LEFT JOIN FETCH a.educations WHERE a.adervtismentId=:adervtismentId"),
    @NamedQuery(name = "Advertisment.findByUsername", query = "SELECT a FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.advertisments a WHERE u.username=:username"),
    @NamedQuery(name = "Advertisment.findAdvertisments", query = "SELECT a FROM Advertisment a")

})
public class Advertisment implements Serializable {

    public static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adervtismentId;

    private String title;

    @Lob
    private String workDefinition;

    @Lob
    private String criteria;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date uppDate;

    private boolean enabled = false;

    private Date removeDate;

    @ManyToMany
    @JoinTable(name = "advertisment_education", joinColumns = @JoinColumn(name = "advertismentId"), inverseJoinColumns = @JoinColumn(name = "educationId"))
    private List<Education> educations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDetailId")
    private UserDetail userDetail;

    public Advertisment() {
    }

    public Advertisment(String title, String workDefinition, String criteria) {
        this.title = title;
        this.workDefinition = workDefinition;
        this.criteria = criteria;
    }

    public Integer getAdervtismentId() {
        return adervtismentId;
    }

    public void setAdervtismentId(Integer adervtismentId) {
        this.adervtismentId = adervtismentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkDefinition() {
        return workDefinition;
    }

    public void setWorkDefinition(String workDefinition) {
        this.workDefinition = workDefinition;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUppDate() {
        return uppDate;
    }

    public void setUppDate(Date uppDate) {
        this.uppDate = uppDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

}
