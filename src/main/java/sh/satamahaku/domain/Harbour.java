package sh.satamahaku.domain;

public class Harbour {

    private Long harbourid;
    private String name;
    private String coordinates;
    private Integer numberOfPlaces;
    private String description;


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

// Getters

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

    //toString

    @Override
    public String toString() {
        return "Harbour [harbourid=" + harbourid + ", name=" + name + ", coordinates=" + coordinates
                + ", numberOfPlaces=" + numberOfPlaces + ", description=" + description + "]";
    }


    
}
