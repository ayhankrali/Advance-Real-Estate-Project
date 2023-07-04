package screens;

import frame.AdvancedRealEstateFrame;
import helpers.CustomImage;
import helpers.GroupedPanel;
import helpers.PlaceholderTextField;
import helpers.TabButton;
import models.UserType;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class HomeScreen extends BaseScreen{
    private HomeRouter router;


    private JRadioButton filterOffersRadioButton;
    private JRadioButton filterAllOffersRadioButton;
    private JRadioButton filterActiveRadioButton;
    private JRadioButton filterAllRadioButton;
    private JRadioButton filterDepositedRadioButton;
    private JRadioButton filterSoldRadioButton ;

    private GroupedPanel headerPanel;
    private GroupedPanel filterPanel ;

    private PlaceholderTextField searchField ;


    private JLabel userNameLabel;
    private JLabel userPositionLabel;

    public HomeScreen(AdvancedRealEstateFrame frame) {
        super(frame);


        router = new HomeRouter(this);

        createLogo();
        createHeader();
        createSideTabs();

        router.showProperties();

    }


    public void createLogo() {
        JLabel logo = CustomImage.loadImage("logo.png", 30, 30, 100, 100);
        add(logo);

        JPanel separator = new JPanel();
        separator.setBounds(160, 80, 1, 60);
        separator.setBackground(Color.lightGray);
        add(separator);
    }


    public void createHeader() {
        headerPanel = new GroupedPanel();
        headerPanel.setBounds(160, 0, frame.getWidth()-160, 80);
        add(headerPanel);

        searchField = new PlaceholderTextField();
        searchField.setPlaceholder("Search for anything...");
        searchField.setBounds(40, 20, 200, 40);
        headerPanel.add(searchField);

        createFilterCheckBoxes();
        createLoggedUserInfo();
    }

    public void createFilterCheckBoxes() {
        filterPanel = new GroupedPanel();
        filterPanel.setBounds(searchField.getX() + searchField.getWidth() + 10, 0, 350, 80);
        headerPanel.add(filterPanel);

        filterOffersRadioButton = new JRadioButton("My Offers");
        filterOffersRadioButton.setBounds(8, 16, 100, 20);
        filterOffersRadioButton.setBackground(Color.white);
        filterPanel.add(filterOffersRadioButton);

        filterAllOffersRadioButton = new JRadioButton("All Offers");
        filterAllOffersRadioButton.setBounds(8, 40, 100, 20);
        filterAllOffersRadioButton.setBackground(Color.white);
        filterPanel.add(filterAllOffersRadioButton);

        filterActiveRadioButton = new JRadioButton("Active");
        filterActiveRadioButton.setBounds(120, 16, 80, 20);
        filterActiveRadioButton.setBackground(Color.white);
        filterPanel.add(filterActiveRadioButton);

        filterAllRadioButton = new JRadioButton("All");
        filterAllRadioButton.setBounds(120, 40, 80, 20);
        filterAllRadioButton.setBackground(Color.white);
        filterPanel.add(filterAllRadioButton);

        filterDepositedRadioButton = new JRadioButton("Deposited");
        filterDepositedRadioButton.setBounds(210, 16, 100, 20);
        filterDepositedRadioButton.setBackground(Color.white);
        filterPanel.add(filterDepositedRadioButton);

        filterSoldRadioButton = new JRadioButton("Sold");
        filterSoldRadioButton.setBounds(210, 40, 100, 20);
        filterSoldRadioButton.setBackground(Color.white);
        filterPanel.add(filterSoldRadioButton);

        ButtonGroup offerGroup = new ButtonGroup();
        offerGroup.add(filterOffersRadioButton);
        offerGroup.add(filterAllOffersRadioButton);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(filterActiveRadioButton);
        statusGroup.add(filterAllRadioButton);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(filterDepositedRadioButton);
        typeGroup.add(filterSoldRadioButton);
    }

    public void createLoggedUserInfo() {
        GroupedPanel userInfoPanel = new GroupedPanel();
        userInfoPanel.setBounds(filterPanel.getX() + filterPanel.getWidth() + 10, 0, 350, 80);
        headerPanel.add(userInfoPanel);

        JLabel userPhoto = CustomImage.loadImage("user.png", 30, 15, 50, 50);
        userInfoPanel.add(userPhoto);

        userNameLabel = new JLabel(frame.dataProvider.user.getFullName());
        userNameLabel.setBounds(86, 20, userInfoPanel.getWidth()-80, 20);
        userInfoPanel.add(userNameLabel);

        userPositionLabel = new JLabel(frame.dataProvider.user.getUserType());
        userPositionLabel.setBounds(86, 40, userInfoPanel.getWidth()-80, 20);
        userInfoPanel.add(userPositionLabel);
    }

    public void createSideTabs() {
        GroupedPanel groupedButtonsPanel = new GroupedPanel();
        groupedButtonsPanel.setBounds(0, 140, 161, frame.getHeight() - 40);
        groupedButtonsPanel.setBorder(new MatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        add(groupedButtonsPanel);

        TabButton propertiesButton = new TabButton("Properties");
        propertiesButton.setBounds(0,0, 160, 40);
        groupedButtonsPanel.add(propertiesButton);

        TabButton clientsButton = new TabButton("Clients");
        clientsButton.setBounds(0,propertiesButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(clientsButton);

        TabButton addButton = new TabButton("Add");
        addButton.setBounds(0,clientsButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(addButton);

        TabButton editButton = new TabButton("Edit");
        editButton.setBounds(0,addButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(editButton);

        TabButton deleteButton = new TabButton("Delete");
        deleteButton.setBounds(0,editButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(deleteButton);

        TabButton scheduleButton = new TabButton("Schedule");
        scheduleButton.setBounds(0,deleteButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(scheduleButton);

        TabButton docsButton = new TabButton("Documents");
        docsButton.setBounds(0,scheduleButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(docsButton);

        TabButton dealsButton = new TabButton("Deals");
        dealsButton.setBounds(0,docsButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(dealsButton);

        TabButton profileButton = new TabButton("Profile");
        profileButton.setBounds(0,dealsButton.getY()+40, 160, 40);
        groupedButtonsPanel.add(profileButton);

         if (frame.dataProvider.user.getType()== UserType.ADMIN){
             TabButton usersButton = new TabButton("Users");
             usersButton.setBounds(0,profileButton.getY()+40,160,40);
             groupedButtonsPanel.add(usersButton);
         }


    }



}
