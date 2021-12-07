package gui;

import main.Formula1ChampionshipManager;

import javax.swing.*;
import javax.swing.table.*;

public class DriverTable extends JPanel {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Driver Table");

    DriverTable() {
        String[] columnNames = {"Name",
                "Team",
                "Location",
                "First Position Count",
                "Second Position Count",
                "Third Position Count",
                "Total Points",
                "Participated Races Count"};

        Formula1ChampionshipManager qwe = new Formula1ChampionshipManager();

        int noOfRecords = Formula1ChampionshipManager.driverArrayList.size();
        int noOfFields = 8;
        Object[][] data = new Object[noOfRecords][noOfFields];

        for (int count = 0; count < Formula1ChampionshipManager.driverArrayList.size(); count++) {
            var record = new Object[]{
                    Formula1ChampionshipManager.driverArrayList.get(count).name,
                    Formula1ChampionshipManager.driverArrayList.get(count).team,
                    Formula1ChampionshipManager.driverArrayList.get(count).location,
                    Formula1ChampionshipManager.driverArrayList.get(count).firstPositionCount,
                    Formula1ChampionshipManager.driverArrayList.get(count).secondPositionCount,
                    Formula1ChampionshipManager.driverArrayList.get(count).thirdPositionCount,
                    Formula1ChampionshipManager.driverArrayList.get(count).totalPoints,
                    Formula1ChampionshipManager.driverArrayList.get(count).totalPoints};
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