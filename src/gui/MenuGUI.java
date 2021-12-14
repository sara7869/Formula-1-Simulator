package gui;

import main.Formula1ChampionshipManager;
import models.Formula1Driver;
import models.Race;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;

import static main.Formula1ChampionshipManager.driverArrayList;
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
    private String[] endingPositions = new String[10];
    private String[] startPositions = {null, null, null, null, null, null, null, null, null, null};
    protected static JTextField textField;

    public void initialiseUI() {

        frame = new JFrame("F1 Championship");

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
//        frame.setSize(1000,500);
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
        int index;
        Formula1Driver driver;
        int points = 12;
        String driverName;

        /**
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            //Check if at least 10 drivers have been added
            if (Formula1ChampionshipManager.driverArrayList.size() < 10) {
                System.out.println("At least 10 drivers are needed to add a race. Add more and try again.");
                return;
            }
            //Randomly generate ending positions
            for (int count = 0; count < 10; ) {
                boolean alreadyAdded = false;
                index = random.nextInt(10);
                driver = Formula1ChampionshipManager.driverArrayList.get(index);
                endingPositions[count] = driver.name;

                //checking whether unique
                for (int count2 = 0; count2 < count; count2++) {
                    if (endingPositions[count].equals(endingPositions[count2])) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (alreadyAdded) {
                    endingPositions[count] = null;
                } else count++;
            }

            //Randomly generate date of race
            int day = (int) (Math.random() * 30);
            int month = (int) (Math.random() * 12);
            String year = String.valueOf((int) (Math.random() * 10));
            year = "202" + year;
            String date = year + "/" + month + "/" + day;

            //Add race
            Race race = new Race(date, endingPositions, startPositions);
            raceArrayList.add(race);
            System.out.println("Race added.");

            //Update points, race counts and participation counts
            for (int driverCount = 0; driverCount < 10; driverCount++) {
                driverName = race.endPositions[driverCount];
                for (Formula1Driver formula1Driver : driverArrayList) {
                    if (formula1Driver.name.equals(driverName)) {
                        driver = formula1Driver;
                        break;
                    }
                }

                switch (driverCount) {
                    case 0 -> {
                        points = 25;
                        driver.firstPositionCount++;
                    }
                    case 1 -> {
                        points = 18;
                        driver.secondPositionCount++;
                    }
                    case 2 -> {
                        points = 15;
                        driver.thirdPositionCount++;
                    }
                    case 3 -> points = 12;
                    case 4 -> points = 10;
                    case 5 -> points = 8;
                    case 6 -> points = 6;
                    case 7 -> points = 4;
                    case 8 -> points = 2;
                    case 9 -> points = 1;
                    default -> throw new IllegalStateException("Unexpected value: " + driverCount);
                }

                driver.totalPoints = driver.totalPoints + points;
                driver.participatedRaceCount++;
            }


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
        int index;
        Formula1Driver driver;
        int points = 12;
        String driverName;

        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            //Check if at least 10 drivers have been added
            if (Formula1ChampionshipManager.driverArrayList.size() < 10) {
                System.out.println("At least 10 drivers are needed to add a race. Add more and try again.");
                return;
            }
            //Randomly generate starting positions
            for (int count = 0; count < 10; ) {
                boolean alreadyAdded = false;
                index = random.nextInt(10);
                driver = Formula1ChampionshipManager.driverArrayList.get(index);
                startPositions[count] = driver.name;

                //checking whether unique
                for (int count2 = 0; count2 < count; count2++) {
                    if (startPositions[count].equals(startPositions[count2])) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (alreadyAdded) {
                    startPositions[count] = null;
                } else count++;
            }

            //Use probabilities to find 1st place winner
            int winnerIndex = random.nextInt(100);
            if (winnerIndex<=40){
                endingPositions[0] = startPositions[0];
            }
            else if (winnerIndex<=70){
                endingPositions[0] = startPositions[1];
            }
            else if (winnerIndex<=80){
                endingPositions[0] = startPositions[3];
            }
            else if (winnerIndex<=90){
                endingPositions[0] = startPositions[4];
            }
            else if (winnerIndex<=92){
                endingPositions[0] = startPositions[5];
            }
            else if (winnerIndex<=94){
                endingPositions[0] = startPositions[6];
            }
            else if (winnerIndex<=96){
                endingPositions[0] = startPositions[7];
            }
            else if (winnerIndex<=98){
                endingPositions[0] = startPositions[8];
            }
            else {
                endingPositions[0] = startPositions[9];
            }
            //Finding the other ending positions
            for (int count = 1; count < 10; ) {
                boolean alreadyAdded = false;
                index = random.nextInt(10);
                driver = Formula1ChampionshipManager.driverArrayList.get(index);
                endingPositions[count] = driver.name;

                //checking whether unique
                for (int count2 = 0; count2 < count; count2++) {
                    if (endingPositions[count].equals(endingPositions[count2])) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (alreadyAdded) {
                    endingPositions[count] = null;
                } else count++;
            }

            System.out.println("Starting positions that were generated:");
            for (int count=0; count<10;count++){
                System.out.println(count+" : "+startPositions[count]);
            }

            //Randomly generate date of race
            int day = random.nextInt(30);
            int month = random.nextInt(12);
            String year = String.valueOf(random.nextInt(10));
            year = "202" + year;
            String date = year + "/" + month + "/" + day;

            //Add race
            Race race = new Race(date, endingPositions, startPositions);
            raceArrayList.add(race);
            System.out.println("Race added.");

            //Update points, race counts and participation counts
            for (int driverCount = 0; driverCount < 10; driverCount++) {
                driverName = race.endPositions[driverCount];
                for (Formula1Driver formula1Driver : driverArrayList) {
                    if (formula1Driver.name.equals(driverName)) {
                        driver = formula1Driver;
                        break;
                    }
                }

                switch (driverCount) {
                    case 0 -> {
                        points = 25;
                        driver.firstPositionCount++;
                    }
                    case 1 -> {
                        points = 18;
                        driver.secondPositionCount++;
                    }
                    case 2 -> {
                        points = 15;
                        driver.thirdPositionCount++;
                    }
                    case 3 -> points = 12;
                    case 4 -> points = 10;
                    case 5 -> points = 8;
                    case 6 -> points = 6;
                    case 7 -> points = 4;
                    case 8 -> points = 2;
                    case 9 -> points = 1;
                    default -> throw new IllegalStateException("Unexpected value: " + driverCount);
                }

                driver.totalPoints = driver.totalPoints + points;
                driver.participatedRaceCount++;
            }

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
            Collections.sort(raceArrayList, new ComparatorRaceDatesAscending());
            RaceTable raceTable = new RaceTable();
            raceTable.setOpaque(true);
            frame.setContentPane(raceTable);
            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }

    class Search implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel label = new JLabel("Enter driver name: ");
            // create a field with 25 chars width
            textField = new JTextField(25);
            JButton button = new JButton("Search");
            button.addActionListener(new DisplaySearchResultTable());

            frame.add(label);
            frame.add(textField);
            frame.add(button);
            frame.setSize(800, 350);
        }
    }

    class DisplaySearchResultTable extends JPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchResultTable searchResultTable = new SearchResultTable();
            searchResultTable.setOpaque(true);
            frame.setContentPane(searchResultTable);
            frame.setVisible(true);

        }
    }
}