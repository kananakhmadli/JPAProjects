package com.jpa.model;

import com.jpa.model.util.PhoneType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "UserDetail.findByUsername", query = "SELECT ud FROM UserDetail ud WHERE ud.user.username=:username"),
    @NamedQuery(name = "UserDetail.findWithAdvertismentByUsername", query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.advertisments WHERE ud.user.username=:username")
})
public class UserDetail implements Serializable {

    public final static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDetailId;
    private String firstName;
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    @ElementCollection
    @JoinTable(name = "userdetail_phonenumber", joinColumns = @JoinColumn(name = "userDetailId"))
    @MapKeyColumn(name = "phoneType")
    @Column(name = "phoneNumber")
    private Map<PhoneType, String> phoneNamber = new HashMap<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "userdetail_address", joinColumns = @JoinColumn(name = "userDetailId"))
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "userDetail", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Advertisment> advertisments = new ArrayList<>();

    @OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
    private User user;

    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, Date birthOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Map<PhoneType, String> getPhoneNamber() {
        return phoneNamber;
    }

    public void setPhoneNamber(Map<PhoneType, String> phoneNamber) {
        this.phoneNamber = phoneNamber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Advertisment> getAdvertisments() {
        return advertisments;
    }

    public void setAdvertisments(List<Advertisment> advertisments) {
        this.advertisments = advertisments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
