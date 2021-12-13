package gui;

import main.Formula1ChampionshipManager;

import javax.swing.*;

public class RaceTable extends JPanel {
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

//        Formula1ChampionshipManager qwe = new Formula1ChampionshipManager();

        int noOfRecords = Formula1ChampionshipManager.raceArrayList.size();
        Object[][] data = new Object[noOfRecords][11];

//        int count = Formula1ChampionshipManager.raceArrayList.size() - 1;
        for (int count = 0; count < Formula1ChampionshipManager.raceArrayList.size(); count++) {
            var record = new Object[]{
//                Formula1ChampionshipManager.raceArrayList.get(count)
                    Formula1ChampionshipManager.raceArrayList.get(count).date,
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[0],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[1],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[2],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[3],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[4],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[5],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[6],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[7],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[8],
                    Formula1ChampionshipManager.raceArrayList.get(count).positions[9]};
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
