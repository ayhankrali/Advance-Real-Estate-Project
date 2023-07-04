package screens;


import javax.swing.*;
import java.util.ArrayList;

public class HomeRouter {
    public HomeScreen homeScreen;
    public ArrayList<JPanel> activePanels = new ArrayList<>();
    public HomeRouter(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    public void showUsersTable() {
        removeActivePanels();

        UsersScreen usersScreen = new UsersScreen(this.homeScreen.frame);
        usersScreen.setBounds(160, 81, homeScreen.frame.getWidth()-160, homeScreen.frame.getHeight()-108);
        usersScreen.createUsersTable();

        activate(usersScreen);
    }
    public void showProperties() {
        removeActivePanels();

        PropertiesScreen propertiesScreen = new PropertiesScreen(this.homeScreen.frame);
        propertiesScreen.setBounds(160, 81, homeScreen.frame.getWidth()-160, homeScreen.frame.getHeight()-108);
        propertiesScreen.createPropertiesTable();
        activate(propertiesScreen);
    }

    public void activate(JPanel panel) {
        //Adding the new panel to HomeScreen and to activePanels array
        //In order to remove it later when we open new tab
        homeScreen.add(panel);
        activePanels.add(panel);

        homeScreen.revalidate();
        homeScreen.repaint();
    }

    public void removeActivePanels() {
        for(JPanel panel : activePanels) {
            panel.removeAll();

            homeScreen.remove(panel);

            homeScreen.revalidate();
            homeScreen.repaint();
        }
    }
}

