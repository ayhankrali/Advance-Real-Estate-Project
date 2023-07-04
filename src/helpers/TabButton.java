package helpers;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class TabButton extends JButton {
    public TabButton(String text) {
        super(text);

        setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        setBorderPainted(true);
        setBackground(Color.white);
    }
}
