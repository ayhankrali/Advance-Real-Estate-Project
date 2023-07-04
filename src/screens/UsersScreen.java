package screens;

import frame.AdvancedRealEstateFrame;
import models.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class UsersScreen extends BaseScreen {
    private JTable usersTable;
    private DefaultTableModel usersTableModel;
    private boolean isSearchingUsers = false;
    private ArrayList<User> searchedUsers;

    public UsersScreen(AdvancedRealEstateFrame frame) {
        super(frame);
    }
    public void createUsersTable() {
        String[] columns = {"Name", "Email", "Type"};
        usersTableModel = new DefaultTableModel();
        usersTableModel.setColumnIdentifiers(columns);

        usersTable = new JTable(usersTableModel);
        usersTable.setRowHeight(40);

        JScrollPane usersTableScroll = new JScrollPane(usersTable);
        usersTableScroll.setBounds(0,0, frame.getWidth()-160, frame.getHeight()-108);
        add(usersTableScroll);

        fetchUsers();

    }

    public void fetchUsers() {
        usersTableModel.setRowCount(0);
        if (isSearchingUsers) {
            for(User user : searchedUsers) {
                String[] row = new String[3];
                row[0] = user.getFullName();
                row[1] = user.getEmail();
                row[2] = user.getUserType();
                usersTableModel.addRow(row);
            }
        } else {
            for(User user : frame.dataProvider.users) {
                String[] row = new String[3];
                row[0] = user.getFullName();
                row[1] = user.getEmail();
                row[2] = user.getUserType();
                usersTableModel.addRow(row);
            }
        }


    }

    public void searchUsers() {
//        isSearchingUsers = true;
//        searchedUsers = new ArrayList<>();
//
//        for(User user : frame.dataProvider.users) {
//            if(user.getFullName().toUpperCase().contains(searchField.getText().toUpperCase()) ||
//                user.getEmail().toUpperCase().contains(searchField.getText().toUpperCase())) {
//                System.out.println("Found: " + user.getFullName() + " Searching for: " + searchField.getText());
//                searchedUsers.add(user);
//            }
//        }
//
//        fetchUsers();
    }
}
