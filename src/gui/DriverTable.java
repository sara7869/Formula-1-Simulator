package gui;

import javax.swing.*;
import java.awt.*;

public class DriverTable extends JPanel{
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Driver Table");
    DriverTable() {
        String[] columnNames = {"First Name",
                "Last Name",
                "Position",
                "Age",
                "Salary"};
        Object[][] data = {
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