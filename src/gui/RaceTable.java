package gui;

import models.Race;

import javax.swing.*;

import static main.Formula1ChampionshipManager.raceArrayList;

public class RaceTable extends JPanel {
    Race race;

    RaceTable() {
        String[] columnNames = {"Date",
                "Position1",
                "Position2",
                "Position3",
                "Position4",
                "Position5",
                "Position6",
                "Position7",
                "Position8",
                "Position9",
                "Position10"};

        int noOfRecords = raceArrayList.size();
        Object[][] data = new Object[noOfRecords][11];

        for (int count = 0; count < raceArrayList.size(); count++) {
            race = raceArrayList.get(count);
            Object[] record = new Object[]{
                    race.date,
                    race.endPositions[0],
                    race.endPositions[1],
                    race.endPositions[2],
                    race.endPositions[3],
                    race.endPositions[4],
                    race.endPositions[5],
                    race.endPositions[6],
                    race.endPositions[7],
                    race.endPositions[8],
                    race.endPositions[9]};
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
