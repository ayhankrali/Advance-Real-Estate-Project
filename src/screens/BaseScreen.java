package screens;

import frame.AdvancedRealEstateFrame;

import javax.swing.*;
import java.awt.*;

public class BaseScreen extends JPanel {
    public AdvancedRealEstateFrame frame;

    public BaseScreen(AdvancedRealEstateFrame frame){
        this.frame = frame ;
        setLayout(null);
        setBackground(Color.WHITE);
    }


    public void showErrorPopup(String msg){
        JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.ERROR_MESSAGE);

    }

}
