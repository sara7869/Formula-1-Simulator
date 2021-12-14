package gui;

import javax.swing.*;

import static main.Formula1ChampionshipManager.raceArrayList;

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

        int noOfRecords = raceArrayList.size();
        Object[][] data = new Object[noOfRecords][11];

        for (int count = 0; count < raceArrayList.size()-1; count++) {
            var record = new Object[]{
                    raceArrayList.get(count).date,
                    raceArrayList.get(count).endPositions[0],
                    raceArrayList.get(count).endPositions[1],
                    raceArrayList.get(count).endPositions[2],
                    raceArrayList.get(count).endPositions[3],
                    raceArrayList.get(count).endPositions[4],
                    raceArrayList.get(count).endPositions[5],
                    raceArrayList.get(count).endPositions[6],
                    raceArrayList.get(count).endPositions[7],
                    raceArrayList.get(count).endPositions[8],
                    raceArrayList.get(count).endPositions[9]};
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
