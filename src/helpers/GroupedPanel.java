package helpers;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class GroupedPanel extends JPanel {
    public GroupedPanel() {
        setLayout(null);
        setBackground(Color.white);
        setBorder(new MatteBorder(0, 0, 1, 0, Color.lightGray));
    }
}
