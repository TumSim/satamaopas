package sh.satamahaku.domain;

public class UserType {
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
