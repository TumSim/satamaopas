package sh.satamahaku.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERTYPE")

public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userTypeid;
    private String userType;


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

    //Setters

    public void setUserTypeid(Long userTypeid) {
        this.userTypeid = userTypeid;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserType [userTypeid=" + userTypeid + ", userType=" + userType + "]";
    }

}
