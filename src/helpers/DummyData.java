package helpers;

import models.Property;
import models.PropertyType;
import models.User;
import models.UserType;

import java.util.ArrayList;

public class DummyData {
    public static ArrayList<User> fetchDummyUsers(){
        ArrayList<User> users = new ArrayList<>();

        User a = new User("sdf1","Viktor Todorov","test@test.com","123456", UserType.BROKER);
        User b = new User("sdf1","Georgi Todorov","test@test.com","111111",UserType.MANAGER);
        User c = new User("sdf1","Ivan Todorov","test@test.com","222222",UserType.ADMIN);
        User d = new User("sdf1","Todor Todorov","test@test.com","333333",UserType.BROKER);

        users.add(a);
        users.add(b);
        users.add(c);
        users.add(d);


        return users ;
    }

    public static ArrayList<Property> fetchDummyProperties() {
        ArrayList<Property> properties = new ArrayList<>();

        Property pr1 = new Property("1", PropertyType.HOUSE, 1400, 15000000.0);
        pr1.setImageName("property.jpeg");
        Property pr2 = new Property("2", PropertyType.FLAT, 80, 200000.0);
        pr2.setImageName("property2.jpeg");

        properties.add(pr1);
        properties.add(pr2);

        return properties;
    }
}
