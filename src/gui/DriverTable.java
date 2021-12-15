package gui;

import javax.swing.*;

import static main.Formula1ChampionshipManager.driverArrayList;

public class DriverTable extends JPanel {
    Object[] record;

    DriverTable() {
        //Names of columns
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

        //Add records to data
        for (int count = 0; count < driverArrayList.size(); count++) {
            record = new Object[]{
                    driverArrayList.get(count).name,
                    driverArrayList.get(count).team,
                    driverArrayList.get(count).location,
                    driverArrayList.get(count).firstPositionCount,
                    driverArrayList.get(count).secondPositionCount,
                    driverArrayList.get(count).thirdPositionCount,
                    driverArrayList.get(count).totalPoints,
                    driverArrayList.get(count).participatedRaceCount};
            data[count] = record;
        }

        //Create a table and add the columns and the data
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to this panel.
        add(scrollPane);
    }

}