import javax.swing.*;

//public class DriverTable (JFrame frame){
//    String[] columnNames = {"First Name",
//                    "Last Name",
//                    "Position",
//                    "Age",
//                    "Salary"};
//            Object[][] data = {
//                    {"John", "Smith", "Manager", 35, 40000},
//                    {"Tom", "Bubble", "Developer", 22, 22000},
//                    {"Helen", "Hitchcock", "Project Leader", 30, 34000},
//                    {"Kate", "Silva", "Receptionist", 20, 18000},
//                    {"Susie", "White", "Developer", 25, 25000}
//            };
//            JTable table = new JTable(data, columnNames);
////            table.setFillsViewportHeight(true);
////            Create the scroll pane and add the table to it.
//            JScrollPane scrollPane = new JScrollPane(table);
//            //Add the scroll pane to this panel.
////            add(scrollPane);
//            // Create and set up the content pane.
//            JTableExample newContentPane = new JTableExample();
//            newContentPane.setOpaque(true); // content panes must be opaque
//            frame.setContentPane(newContentPane);
////}

import java.awt.*;

import javax.swing.*;

public class DriverTable {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello!");
    DriverTable(){
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null,Font.PLAIN,25));
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(420,420);

        frame.setLayout(null);

        frame.setVisible(true);

    }

}