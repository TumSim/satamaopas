package sh.satamahaku.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HARBOURTYPE")

public class HarbourType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long harboyrTypeid;
    private String harbourType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "harbourid")
    @JsonIgnoreProperties("harbourType")
    private List <Harbour> harbours;

    



    //Constructors

    public HarbourType() {
        this.harboyrTypeid = null;
        this.harbourType = null;
    }

    public HarbourType(String harbourType) {
        this.harbourType = harbourType;
    }
    
    // Getters

    public Long getHarboyrTypeid() {
        return harboyrTypeid;
    }
    public String getHarbourType() {
        return harbourType;
    }

    public List<Harbour> getHarbours() {
        return harbours;
    }


    //Setters

    public void setHarboyrTypeid(Long harboyrTypeid) {
        this.harboyrTypeid = harboyrTypeid;
    }
    public void setHarbourType(String harbourType) {
        this.harbourType = harbourType;
    }

    public void setHarbours(List<Harbour> harbours) {
        this.harbours = harbours;
    }

    //toString

    @Override
    public String toString() {
        return "HarbourType [harboyrTypeid=" + harboyrTypeid + ", harbourType=" + harbourType + "]";
    }

    


    
}
