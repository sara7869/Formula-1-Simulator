package gui;

import main.Formula1ChampionshipManager;
import models.Race;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static main.Formula1ChampionshipManager.raceArrayList;

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
    private String[] positions = new String[10];
    private int[] index = new int[10];
    String startPositions[]={null,null,null,null,null,null,null,null,null,null};

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
        MenuButtons menuButtons = new MenuButtons();
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

    class MenuButtons {
        public void buttons(Container container) {
            displayDriverTableButton = new JButton("Display the Formula 1 Driver Table");
            sortByPointsButton = new JButton("Sort the Driver Table in ascending order of points won by drivers");
            sortByFirstPositionButton = new JButton("Sort the Driver Table in descending order of the number of first position won in races");
            randomRaceButton = new JButton("Generate a random race");
            randomRaceWithProbabilityButton = new JButton("Generate a random race using probabilities to calculate the results");
            displayRacesButton = new JButton("Display all completed races in ascending order of date played");
            searchButton = new JButton("Search for all races that a given driver participated");

            displayDriverTableButton.addActionListener(new DriverTableDisplay());
            sortByPointsButton.addActionListener(new PointSort());
            sortByFirstPositionButton.addActionListener(new FirstPositionSort());
            randomRaceButton.addActionListener(new RandomRace());
            randomRaceWithProbabilityButton.addActionListener(new RandomRaceWithProbability());
            displayRacesButton.addActionListener(new RaceDisplay());
            searchButton.addActionListener(new Search());

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

    class DriverTableDisplay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//          Create and set up the content pane.
            DriverTable newContentPane = new DriverTable();
            newContentPane.setOpaque(true); // content panes must be opaque
            JButton backButton = new JButton("Back to menu");

            backButton.addActionListener(new BackToMenu());

            frame.setContentPane(newContentPane);
            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class BackToMenu implements ActionListener {
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
            MenuButtons menubuttons = new MenuButtons();
            frame.setContentPane(newContentPane);
            menubuttons.buttons(newContentPane);
            frame.setVisible(true);
        }
    }

    class PointSort implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(Formula1ChampionshipManager.driverArrayList, new ComparatorPointsAscending());
            DriverTable newContentPane = new DriverTable();
            newContentPane.setOpaque(true); // content panes must be opaque
            JButton backButton = new JButton("Back to menu");

            backButton.addActionListener(new BackToMenu());

            frame.setContentPane(newContentPane);
            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class FirstPositionSort implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(Formula1ChampionshipManager.driverArrayList, new ComparatorFirstPositionsDescending());
            DriverTable newContentPane = new DriverTable();
            newContentPane.setOpaque(true); // content panes must be opaque
            JButton backButton = new JButton("Back to menu");

            backButton.addActionListener(new BackToMenu());

            frame.setContentPane(newContentPane);
            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class RandomRace implements ActionListener {
        private boolean alreadyAdded = false;

        /**
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            //Check if at least 10 drivers have been added
            if (Formula1ChampionshipManager.driverArrayList.size() < 10) {
                System.out.println("At least 10 drivers are needed to add a race. Add more and try again.");
                return;
            }
            //Randomly generate positions
            for (int count = 0; count < 10; count++) {
//                index[count] = (int) (Math.random() * Formula1ChampionshipManager.driverArrayList.size());
//                random.nextInt(max + min) + min;
                int index = (int) (Math.random() * 10);
                positions[count] = Formula1ChampionshipManager.driverArrayList.get(index).name;

                //checking whether unique
                for (int count2 = 0; count2 < count; count2++) {
//                    if (index[count] == index[count2]) {
                    if (positions[count] == positions[count2]) {
                        alreadyAdded = true;
                        break;
                    }
                }
//                if (!alreadyAdded) {
//                    positions[count] = Formula1ChampionshipManager.driverArrayList.get(index[count]).name;
//                }
//                else {
//                    index[count]= 0;
//                }
                if (alreadyAdded) {
                    positions[count] = null;
                }
            }


            //Randomly generate date of race
            int day = (int) (Math.random() * 30);
            int month = (int) (Math.random() * 12);
            String year = String.valueOf((int) (Math.random() * 10));
            year = "202" + year;
            String date = year + "/" + month + "/" + day;

            //Add race
            Race race = new Race(date, positions, startPositions);
            raceArrayList.add(race);
            System.out.println("Race added.");

            //Display race
            RaceTable raceTable = new RaceTable();
            raceTable.setOpaque(true);
            JButton displayDriverTableButton = new JButton("Display Driver Table");

            displayDriverTableButton.addActionListener(new DriverTableDisplay());

            frame.setContentPane(raceTable);
            frame.add(displayDriverTableButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);

        }
    }

    class RandomRaceWithProbability implements ActionListener {
        private boolean alreadyAdded = false;

        public void actionPerformed(ActionEvent e) {
            //Check if at least 10 drivers have been added
            if (Formula1ChampionshipManager.driverArrayList.size() < 10) {
                System.out.println("At least 10 drivers are needed to add a race. Add more and try again.");
                return;
            }
            //Randomly generate positions
            for (int count = 0; count < 9; count++) {
                index[count] = (int) (Math.random() * Formula1ChampionshipManager.driverArrayList.size());
                for (int count2 = 0; count2 < count; count2++) {
                    if (index[count] == index[count2]) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    positions[count] = Formula1ChampionshipManager.driverArrayList.get(index[count]).name;
                }
            }

            //Randomly generate date of race
            int day = (int) (Math.random() * 30);
            int month = (int) (Math.random() * 12);
            String year = String.valueOf((int) (Math.random() * 10));
            year = "202" + year;
            String date = year + "/" + month + "/" + day;

            //Add race
            Race race = new Race(date, positions, startPositions);
            raceArrayList.add(race);
            System.out.println("Race added.");

            //Display race
            RaceTable raceTable = new RaceTable();
            raceTable.setOpaque(true);
            JButton displayDriverTableButton = new JButton("Display Driver Table");

            displayDriverTableButton.addActionListener(new DriverTableDisplay());

            frame.setContentPane(raceTable);
            frame.add(displayDriverTableButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);


        }
    }

    class RaceDisplay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RaceTable raceTable = new RaceTable();
            raceTable.setOpaque(true);
//            JButton backButton = new JButton("Back to menu");
//            backButton.addActionListener(new BackToMenu());

            frame.setContentPane(raceTable);
//            frame.add(backButton);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    static class Search implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}