package sh.satamahaku.domain;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
// satamna on kirja
@Entity
@Table(name = "HARBOUR")

public class Harbour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long harbourid;
    private String name;
    private String coordinates;
    private Integer numberOfPlaces;
    private String description;

    @ManyToOne
    @JoinColumn(name = "harboyrTypeid")
    @JsonIgnoreProperties("harbours")
    private HarbourType harbourType;

    @ManyToMany
    @JoinTable(name = "FAVOURITE",
    joinColumns = @JoinColumn(name = "harbourid"),
    inverseJoinColumns = @JoinColumn(name = "userid"))
    private List <User> favouriteByUser;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "harbourServices")
    @JsonIgnoreProperties("harbourServices")
    private List<Service> services;

    

// Constructors

public Harbour() {
    this.harbourid = null;
    this.name = null;
    this.coordinates = null;
    this.numberOfPlaces = null;
    this.description = null;
}


    public Harbour(String name, String coordinates, Integer numberOfPlaces, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfPlaces = numberOfPlaces;
        this.description = description;
    }


//Setters

    public void setFavouriteByUser(List<User> favouriteByUser) {
        this.favouriteByUser = favouriteByUser;
    }

    public void setHarbourType(HarbourType harbourType) {
        this.harbourType = harbourType;
    }
    public void setHarbourid(Long harbourid) {
        this.harbourid = harbourid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

// Getters

    public List<User> getFavouriteByUser() {
        return favouriteByUser;
    }

    public HarbourType getHarbourType() {
        return harbourType;
    }

    public Long getHarbourid() {
        return harbourid;
    }
    public String getName() {
        return name;
    }
    public String getCoordinates() {
        return coordinates;
    }
    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }
    public String getDescription() {
        return description;
    }

    public List<Service> getServices() {
        return services;
    }

    //toString

    @Override
    public String toString() {
        return "Harbour [harbourid=" + harbourid + ", name=" + name + ", coordinates=" + coordinates
                + ", numberOfPlaces=" + numberOfPlaces + ", description=" + description + "]";
    }


    
}
