package com.jpa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.userId =:userId"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username=:username"),
    @NamedQuery(name = "User.findUsers", query = "SELECT u FROM User u "),///buna da bax 
    @NamedQuery(name = "User.count", query = "SELECT COUNT(u.userId) FROM User u"),
    @NamedQuery(name = "User.findUserInfoByUsername", query = "SELECT new com.jpa.model.UserInfo(u.username,u.userDetail.firstName,u.userDetail.lastName,u.userDetail.birthOfDate)"
            + "FROM User u WHERE u.username=:username")

})
public class User implements Serializable {

    public static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) ///bura bax yaddan cixmasin findByid gore
    private UserDetail userDetail;

    public User() {
    }

    public User(String username, String password, Date creationDate) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

}
