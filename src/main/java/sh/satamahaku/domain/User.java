package sh.satamahaku.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;

    @ManyToMany(mappedBy = "favouriteByUser")
    private List <Harbour> favoriteHarbours;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("users")
    @JoinColumn(name = "userTypeid")
    private UserType userType;

    

    //Constructors

    public User() {
        this.userid = null;
        this.userName = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.passwordHash = null;
    }

    public User(String userName, String firstName, String lastName, String email, String passwordHash) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    //Setters
    
    public Long getUserid() {
        return userid;
    }
    public String getUserName() {
        return userName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Harbour> getFavoriteHarbours() {
        return favoriteHarbours;
    }
    public UserType getUserType() {
        return userType;
    }

    //Setters

    public void setFavoriteHarbours(List<Harbour> favoriteHarbours) {
        this.favoriteHarbours = favoriteHarbours;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
                + lastName + ", email=" + email + ", passwordHash=" + passwordHash + "]";
    }



    

}
