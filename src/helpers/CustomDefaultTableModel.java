package helpers;

import javax.swing.JLabel;

public class CustomDefaultTableModel extends javax.swing.table.DefaultTableModel{

    public CustomDefaultTableModel(){

    }

    @Override

    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 0)return getValueAt(0, columnIndex).getClass();

        else return super.getColumnClass(columnIndex);

    }

}
