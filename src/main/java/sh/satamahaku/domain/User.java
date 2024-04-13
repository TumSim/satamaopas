package sh.satamahaku.domain;

import java.util.List;
import java.util.ArrayList;

import org.apache.tomcat.util.digester.ArrayStack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "FAVOURITE",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "harbourid"))
    private List<Harbour> favoriteHarbours = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("users")
    @JoinColumn(name = "userTypeid")
    private UserType userType;

    // public void addHarbours(Harbour harbours){
    //     harbourServices.add(harbours);
    // }

    public void addFavoriteHarbour(Harbour favoriteHarbourToAdd){ // adding Harbour to users favorite list
        favoriteHarbours.add(favoriteHarbourToAdd);
    }

    public void removeFavoriteHarbour(Harbour harbour) {
        favoriteHarbours.remove(harbour);
        harbour.getFavouriteByUser().remove(this);
    }

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
