package helpers;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MultiLineTableCellRenderer extends JList<String> implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //make multi line where the cell value is String[]
        if (value instanceof String[]) {
            setListData((String[]) value);
        }

        //cell backgroud color when selected
        if (isSelected) {
            setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            setBackground(UIManager.getColor("Table.background"));
        }

        setFont(new Font("Helvetica", Font.PLAIN, 18));
        setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        return this;
    }
}
