package sh.satamahaku.domain;

public class HarbourType {
    private Long harboyrTypeid;
    private String harbourType;


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

    //Setters

    public void setHarboyrTypeid(Long harboyrTypeid) {
        this.harboyrTypeid = harboyrTypeid;
    }
    public void setHarbourType(String harbourType) {
        this.harbourType = harbourType;
    }

    //toString

    @Override
    public String toString() {
        return "HarbourType [harboyrTypeid=" + harboyrTypeid + ", harbourType=" + harbourType + "]";
    }

    


    
}
