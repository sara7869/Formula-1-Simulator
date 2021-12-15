package gui;

import models.Race;

import javax.swing.*;

import static main.Formula1ChampionshipManager.raceArrayList;

public class RaceTable extends JPanel {
    Race race;

    RaceTable() {
        //Names of columns
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

        //Add records to data
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

        //Create a table and add the columns and the data
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to this panel.
        add(scrollPane);

    }
}
