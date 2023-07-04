package frame;

import screens.HomeScreen;
import screens.LoginScreen;
import screens.UsersScreen;

public class AdvancedRealEstateRouter {
    public AdvancedRealEstateFrame frame ;

    public AdvancedRealEstateRouter(AdvancedRealEstateFrame frame){
         this.frame = frame;
    }

    public void showLogin(){
        LoginScreen login = new LoginScreen(this.frame);
        this.frame.setContentPane(login);
        this.frame.validate();
    }
    public void showHome(){
        HomeScreen home = new HomeScreen(this.frame);
        this.frame.setContentPane(home);
        this.frame.validate();

    }
    public void showUsersTable(){
        UsersScreen usersScreen = new UsersScreen(this.frame);
        usersScreen.createUsersTable();
        this.frame.setContentPane(usersScreen);
        this.frame.validate();
    }


}
