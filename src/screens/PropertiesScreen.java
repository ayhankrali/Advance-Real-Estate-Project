package screens;
import frame.AdvancedRealEstateFrame;
import helpers.*;
import helpers.Renderer;
import models.Property;

import javax.swing.*;
import java.awt.*;




public class PropertiesScreen extends BaseScreen {
    private JTable propertiesTable;
    private CustomDefaultTableModel propertiesTableModel;

    public PropertiesScreen(AdvancedRealEstateFrame frame) {
        super(frame);
        setBackground(Color.white);

        frame.dataProvider.properties = DummyData.fetchDummyProperties();
    }


    public void createPropertiesTable() {
        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();

        String[] columns = {"Photo", "Information"};

        propertiesTableModel = new CustomDefaultTableModel();
        propertiesTableModel.setColumnIdentifiers(columns);

        propertiesTable = new JTable(propertiesTableModel);
        propertiesTable.setSelectionBackground(Color.lightGray);
        propertiesTable.setDefaultRenderer(JLabel.class, new Renderer());
        propertiesTable.getColumnModel().getColumn(1).setCellRenderer(renderer);
        propertiesTable.setRowHeight(300);

        JScrollPane scrollPane = new JScrollPane(propertiesTable);
        scrollPane.setBounds(0,0, getWidth()-18, getHeight());
        add(scrollPane);

        fetchProperties();

    }

    private void fetchProperties() {
        //frame.dataProvider.properties
        for(Property property : frame.dataProvider.properties) {

            String offerNumber = String.format(" Offer Number: %s",property.getOfferNumber());
            String type = String.format(" Type: %s",property.getPropertyType());
            String size = String.format(" Size: %d",property.getSize());
            String created = String.format(" Created: %s",property.getYearCreated());
            String priceEU = String.format(" Price: %.2f EUR",property.getPriceEUR());
            String priceBG = String.format(" Price: %.2f BGN",property.getPriceBGN());
            String status = String.format(" Status: %s", property.isActive() ? "Active" : "Not Active");
            String deposited = String.format(" Deposited: %s",property.isDeposited() ? "Yes" : "No");
            String floor = String.format(" Floor: %d",property.getFloor());

            String[] info = {" ",offerNumber, type,size, created, priceEU, priceBG, status, deposited, floor};

            Object[] row = new Object[3];
            row[0] = CustomImage.loadImage(property.getImageName(),0,0,500,300);
            row[1] = info;
            propertiesTableModel.addRow(row);

        }
    }
}
