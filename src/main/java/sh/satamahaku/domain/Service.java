package sh.satamahaku.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICE")

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceid;
    private String service;
    private String description;

    @ManyToMany
    @JsonIgnoreProperties("services")
    @JoinTable(name = "HARBOURSERVICE",
        joinColumns = @JoinColumn(name = "serviceid"),
        inverseJoinColumns = @JoinColumn(name = "harbourid"))
    private List <Harbour> harbourServices;

    //Constructors

    public Service() {
        this.serviceid = null;
        this.service = null;
        this.description = null;
    }

    public Service(String service, String description) {
        this.service = service;
        this.description = description;
    }

    //Setters
    
    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }
    public void setService(String service) {
        this.service = service;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setHarbourServices(List<Harbour> harbourServices) {
        this.harbourServices = harbourServices;
    }

    //Getters

    public Long getServiceid() {
        return serviceid;
    }
    public String getService() {
        return service;
    }
    public String getDescription() {
        return description;
    }

    public List<Harbour> getHarbourServices() {
        return harbourServices;
    }

    @Override
    public String toString() {
        return "Service [serviceid=" + serviceid + ", service=" + service + ", description=" + description + "]";
    }



    
}
