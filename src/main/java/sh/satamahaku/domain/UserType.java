package sh.satamahaku.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERTYPE")

public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userTypeid;
    private String userType;


    @OneToMany(mappedBy = "userType")
    @JsonIgnoreProperties("userType")
    private List <User> users;

    

//Constructors
    public UserType() {
        this.userTypeid = null;
        this.userType = null;
    }

    public UserType(String userType) {
        this.userType = userType;
    }

    //Getters

    public Long getUserTypeid() {
        return userTypeid;
    }

    public String getUserType() {
        return userType;
    }
    public List<User> getUsers() {
        return users;
    }

    //Setters

    public void setUserTypeid(Long userTypeid) {
        this.userTypeid = userTypeid;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserType [userTypeid=" + userTypeid + ", userType=" + userType + "]";
    }


}
