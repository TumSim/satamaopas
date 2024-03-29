package sh.satamahaku.domain;

public class Service {
    private Long serviceid;
    private String service;
    private String description;


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

    @Override
    public String toString() {
        return "Service [serviceid=" + serviceid + ", service=" + service + ", description=" + description + "]";
    }

    
}
