package frame;

import helpers.DummyData;
import models.Property;
import models.User;

import java.util.ArrayList;

public class AdvancedRealEstateDataProvider {

    public ArrayList<User> users ;
    public ArrayList<Property> properties;
    public User user ;
    public AdvancedRealEstateDataProvider(){
        this.users = DummyData.fetchDummyUsers();
    }

    //USERS METHODS
    public boolean loginUsers (String email,String pass){
        for (User user : users) {
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                this.user = user ;
                return true;

            }
        }
        return false;
    }

}
