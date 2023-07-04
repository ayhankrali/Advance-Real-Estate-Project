package screens;

import frame.AdvancedRealEstateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen extends BaseScreen {

    private JTextField emailField;
    private JTextField passwordField;
    public LoginScreen(AdvancedRealEstateFrame frame) {
        super(frame);
        setBackground(Color.WHITE);
         crateTitle();
         createCredentialsComponents();
         createLoginButton();
        
    }

    public void crateTitle(){
          JLabel titleLabel = new JLabel("Welcome ");
          titleLabel.setBounds(frame.getWidth()/2 - 100,100,200,70);
          titleLabel.setFont(new Font("Helvetica",Font.PLAIN,30));
          add(titleLabel);
    }

    public void createCredentialsComponents(){
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(frame.getWidth()/2 - 100,150,200,20);
        add(emailLabel);

        emailField = new JTextField("test@test.com");
        emailField.setBounds(frame.getWidth()/2 - 100,170,200,20);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(frame.getWidth()/2 - 100,190,200,20);
        add(passLabel);

        passwordField = new JPasswordField("123456");
        passwordField.setBounds(frame.getWidth()/2 - 100,210,200,20);
        add(passwordField);
    }

    public void createLoginButton(){
         JButton loginButton = new JButton("Login");
         loginButton.setBounds(frame.getWidth()/2 - 100,250,200,20);
         loginButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                boolean isValid = frame.dataProvider.loginUsers(emailField.getText(),passwordField.getText());
                if (isValid){
                    //Move to the next screen
                    frame.setSize(1000,850);
                   frame.router.showHome();

                } else {
                    //Show Error wrong email or pass
                    showErrorPopup("Wrong email or password!");
                }


             }
         });
         add(loginButton);
    }
}
