package gui;

import main.Formula1ChampionshipManager;
import main.comparePointsDescending;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class MenuGUI extends Container {

    private JFrame frame;
    private JLabel labelMenu;
    private JButton displayDriverTableButton;
    private JButton sortByPointsButton;
    private JButton sortByFirstPositionButton;
    private JButton randomRaceButton;
    private JButton randomRaceWithProbabilityButton;
    private JButton displayRacesButton;
    private JButton searchButton;

    public void initialiseUI() {

        frame = new JFrame("FrameExample");

        //Create the Welcome labels
        JLabel labelWelcome = new JLabel("Welcome to the Formula 1 racing car championship.");
        labelMenu = new JLabel("Select one of the following options.");

        //Create the menu buttons
//        displayDriverTableButton = new JButton("Display the Formula 1 Driver Table");
//        sortByPointsButton = new JButton("Sort the Driver Table in ascending order of points won by drivers");
//        sortByFirstPositionButton = new JButton("Sort the Driver Table in descending order of the number of first position won in races");
//        randomRaceButton = new JButton("Generate a random race");
//        randomRaceWithProbabilityButton = new JButton("Generate a random race using probabilities to calculate the results");
//        displayRacesButton = new JButton("Display all completed races in ascending order of date played");
//        searchButton = new JButton("Search for all races that a given driver participated");

        //Add action listeners to the menu buttons
//        displayDriverTableButton.addActionListener(new displayDriverTable());
//        sortByPointsButton.addActionListener(new sortByPoints());
//        sortByFirstPositionButton.addActionListener(new sortByFirstPosition());
//        randomRaceButton.addActionListener(new randomRace());
//        randomRaceWithProbabilityButton.addActionListener(new randomRaceWithProbability());
//        displayRacesButton.addActionListener(new displayRaces());
//        searchButton.addActionListener(new search());

        Container container = frame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(labelWelcome);
        menuButtons menuButtons = new menuButtons();
        menuButtons.buttons(container);
//        container.add(labelMenu);
//        container.add(displayDriverTableButton);
//        container.add(sortByPointsButton);
//        container.add(sortByFirstPositionButton);
//        container.add(randomRaceButton);
//        container.add(randomRaceWithProbabilityButton);
//        container.add(displayRacesButton);
//        container.add(searchButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

//    class openNewWindow implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == myButton) {
//                NewWindow myWindow = new NewWindow();
//            }
//        }
//    }

    class menuButtons{
        public void buttons(Container container){
            displayDriverTableButton = new JButton("Display the Formula 1 Driver Table");
            sortByPointsButton = new JButton("Sort the Driver Table in ascending order of points won by drivers");
            sortByFirstPositionButton = new JButton("Sort the Driver Table in descending order of the number of first position won in races");
            randomRaceButton = new JButton("Generate a random race");
            randomRaceWithProbabilityButton = new JButton("Generate a random race using probabilities to calculate the results");
            displayRacesButton = new JButton("Display all completed races in ascending order of date played");
            searchButton = new JButton("Search for all races that a given driver participated");

            displayDriverTableButton.addActionListener(new displayDriverTable());
            sortByPointsButton.addActionListener(new sortByPoints());
            sortByFirstPositionButton.addActionListener(new sortByFirstPosition());
            randomRaceButton.addActionListener(new randomRace());
            randomRaceWithProbabilityButton.addActionListener(new randomRaceWithProbability());
            displayRacesButton.addActionListener(new displayRaces());
            searchButton.addActionListener(new search());

            container.add(labelMenu);
            container.add(displayDriverTableButton);
            container.add(sortByPointsButton);
            container.add(sortByFirstPositionButton);
            container.add(randomRaceButton);
            container.add(randomRaceWithProbabilityButton);
            container.add(displayRacesButton);
            container.add(searchButton);
        }
    }

    class displayDriverTable implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//          Create and set up the content pane.
            DriverTable newContentPane = new DriverTable();
            newContentPane.setOpaque(true); // content panes must be opaque
            JButton backButton = new JButton("Back to menu");

            backButton.addActionListener(new backToMenu());

            frame.setContentPane(newContentPane);
            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class backToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuGUI newContentPane = new MenuGUI();
//            newContentPane.add(labelMenu);
//            newContentPane.add(displayDriverTableButton);
//            newContentPane.add(sortByPointsButton);
//            newContentPane.add(sortByFirstPositionButton);
//            newContentPane.add(randomRaceButton);
//            newContentPane.add(randomRaceWithProbabilityButton);
//            newContentPane.add(displayRacesButton);
//            newContentPane.add(searchButton);
//            newContentPane.setOpaque(true); // content panes must be opaque
            menuButtons menubuttons = new menuButtons();
            frame.setContentPane(newContentPane);
            menubuttons.buttons(newContentPane);
            frame.setVisible(true);
        }
    }

    class sortByPoints implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(Formula1ChampionshipManager.driverArrayList, new comparePointsAscending());
            DriverTable newContentPane = new DriverTable();
            newContentPane.setOpaque(true); // content panes must be opaque
            JButton backButton = new JButton("Back to menu");

            backButton.addActionListener(new backToMenu());

            frame.setContentPane(newContentPane);
            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class sortByFirstPosition implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(Formula1ChampionshipManager.driverArrayList, new compareFirstPositionsDescending());
            DriverTable newContentPane = new DriverTable();
            newContentPane.setOpaque(true); // content panes must be opaque
            JButton backButton = new JButton("Back to menu");

            backButton.addActionListener(new backToMenu());

            frame.setContentPane(newContentPane);
            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class randomRace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class randomRaceWithProbability implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class displayRaces implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class search implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
//}
//
//}
//import java.awt.event .*;
//import javax.swing .*;
//
//        public class gui.MenuGUI implements ActionListener {
//            JFrame frame = new JFrame();
//            JButton myButton = new JButton("New Window");
//
//            gui.MenuGUI() {
//                myButton.setBounds(100, 160, 200, 40);
//                myButton.setFocusable(false);
//                myButton.addActionListener(this);
//                frame.add(myButton);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setSize(420, 420);
//                frame.setLayout(null);
//                frame.setVisible(true);
//            }
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == myButton) {
//                    frame.dispose();
//                    gui.DriverTable myWindow = new gui.DriverTable();
//                }
//            }
//
//        }
