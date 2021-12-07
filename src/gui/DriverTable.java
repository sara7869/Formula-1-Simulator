package gui;

import javax.swing.*;

public class DriverTable extends JPanel{
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
        Object[][] data = {
//                {Main.formula1ChampionshipManager.driverArrayList.name},
                {"John", "Smith", "Manager", 35, 40000},
                {"Tom", "Bubble", "Developer", 22, 22000},
                {"Helen", "Hitchcock", "Project Leader", 30, 34000},
                {"Kate", "Silva", "Receptionist", 20, 18000},
                {"Susie", "White", "Developer", 25, 25000}
        };
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);

    }

}