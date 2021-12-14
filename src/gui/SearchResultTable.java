package gui;

import models.Formula1Driver;
import models.Race;

import javax.swing.*;
import java.util.ArrayList;

import static main.Formula1ChampionshipManager.driverArrayList;
import static main.Formula1ChampionshipManager.raceArrayList;

public class SearchResultTable extends JPanel {
    Object[] record;
    int driverRaceCount = 0;
    Formula1Driver formula1Driver;
    ArrayList<String> raceDates = new ArrayList<>();
    ArrayList<Integer> racePositions = new ArrayList<>();
    Race race;
    String driverName;

    public SearchResultTable() {
        driverName = MenuGUI.textField.getText();
        for (Formula1Driver driver : driverArrayList) {
            if (driver.name.equals(driverName)) {
                formula1Driver = driver;
                break;
            }
        }
        String[] columnNames = {"Date", "Position"};

        int noOfRecords = formula1Driver.participatedRaceCount;
        Object[][] data = new Object[noOfRecords][2];

        for (int raceCount = 0; raceCount < raceArrayList.size() - 1; raceCount++) {
            race = raceArrayList.get(raceCount);
            for (int driverCount = 0; driverCount < 10; driverCount++) {
                if (race.endPositions[driverCount].equals(driverName)) {
                    raceDates.add(race.date);
                    racePositions.add(driverCount);
                    record = new String[]{race.date, String.valueOf(driverCount)};
                    data[driverRaceCount] = record;
                    break;
                }
            }
        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to this panel.
        add(scrollPane);
    }

}
