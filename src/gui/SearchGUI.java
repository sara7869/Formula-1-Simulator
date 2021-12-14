package gui;

import javax.swing.*;

import static main.Formula1ChampionshipManager.raceArrayList;

public class SearchGUI {
    SearchGUI() {
        JFrame frame = new JFrame("Search for a driver");
        JLabel label = new JLabel("Enter driver name: ");
        // create a field with 25 chars width
        JTextField textField = new JTextField(25);
        JButton jButton = new JButton("Search");

        String driverName = textField.getText();

        for (int count1=0; count1 < raceArrayList.size() - 1;count1++){
            for (int count2=0;count2 < 10; count2++){
                if (raceArrayList.get(count1).endPositions[count2].equals(driverName)){
                    new SearchResultTable(raceArrayList.get(count1));
                }
            }
        }
    }

}
