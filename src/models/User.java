package models;

public class User {
    private String id;
    private String fullName;
    private String email;
    private String password;
    private int completedDeals;
    private UserType type ;


    public User(String id,String fullName, String email, String password,UserType type) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.completedDeals = 0 ;
        this.type = type;

    }

    public UserType getType() {
        return type;
    }

    public String getUserType(){
        switch (this.type){
            case ADMIN : return "Admin";
            case MANAGER: return "Manager";
            case BROKER: return "Broker";
            default: return "Unknown";

        }
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getCompletedDeals() {
        return completedDeals;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
