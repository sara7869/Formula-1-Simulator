package gui;

import javax.swing.*;

import static main.Formula1ChampionshipManager.driverArrayList;

public class DriverTable extends JPanel {
//    JFrame frame = new JFrame();
//    JLabel label = new JLabel("Driver Table");

    DriverTable() {
        String[] columnNames = {"Name",
                "Team",
                "Location",
                "First Position Count",
                "Second Position Count",
                "Third Position Count",
                "Total Points",
                "Participated Races Count"};

        int noOfRecords = driverArrayList.size();
        int noOfFields = 8;
        Object[][] data = new Object[noOfRecords][noOfFields];

        for (int count = 0; count < driverArrayList.size(); count++) {
            var record = new Object[]{
                    driverArrayList.get(count).name,
                    driverArrayList.get(count).team,
                    driverArrayList.get(count).location,
                    driverArrayList.get(count).firstPositionCount,
                    driverArrayList.get(count).secondPositionCount,
                    driverArrayList.get(count).thirdPositionCount,
                    driverArrayList.get(count).totalPoints,
                    driverArrayList.get(count).totalPoints};
            data[count] = record;
        }
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to this panel.
        add(scrollPane);
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(100);
//        columnModel.getColumn(1).setPreferredWidth(200);
//        columnModel.getColumn(2).setPreferredWidth(100);
//        columnModel.getColumn(3).setPreferredWidth(300);
//        columnModel.getColumn(4).setPreferredWidth(600);
//        columnModel.getColumn(5).setPreferredWidth(600);
//        columnModel.getColumn(6).setPreferredWidth(600);
//        columnModel.getColumn(7).setPreferredWidth(300);
//        table.setSize(2000,400);
    }

}