package main;

import models.ChampionshipManager;
import models.Formula1Driver;
import models.Race;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

    static Scanner scanner = new Scanner(System.in);
    private String[] positions = new String[10];
    public static ArrayList<Formula1Driver> driverArrayList = new ArrayList<Formula1Driver>();
    public static ArrayList<Race> raceArrayList = new ArrayList<Race>();
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public int printMenu() {
        // The menu is displayed in the console

        System.out.println("""

                Pick one from the following.

                1: Add a new driver to the championship
                2: Delete a driver and the team that the driver belongs to from the championship
                3: Change the driver for an existing constructor team
                4: Display the various statistics for a selected existing driver
                5: Display the Formula 1 Driver Table
                6: Add a race completed with its date and the positions that all the drivers achieved
                7: Save all the information to a file
                8: Recover the previous state of the program the next time the application starts
                9: Start GUI
                10: Exit the program

                Enter a choice.""");

        // The user input inputInfoCorrect is returned
        return scanner.nextInt();
    }

    public void addDriver() {
        Formula1Driver formula1Driver;
        boolean driverAdded = false;
        String inputInfoCorrect = "N";
        String driverToBeAdded = "Y";
        String name = "";
        String team = "";
        String location = "";
        int firstPositionCount = 0;
        int secondPositionCount = 0;
        int thirdPositionCount = 0;
        int totalPoints = 0;
        int participatedRaceCount = 0;

        int count1 = 0;

        while (driverToBeAdded.equals("Y")) {
            inputInfoCorrect = "N";
            while (inputInfoCorrect.equals("N")) {

                System.out.println("\nEnter the following details.");
                System.out.println("\nName of the driver to add:");
                if (count1 == 0) {
                    scanner.nextLine();
                }
                name = scanner.nextLine();
                System.out.println("\nTeam/Manufacturer for the new driver:");
                team = scanner.nextLine();
                System.out.println("\nLocation of the new driver:");
                location = scanner.nextLine();
                System.out.println("\nNumber of first positions held by the new driver:");
                firstPositionCount = scanner.nextInt();
                System.out.println("\nNumber of second positions held by the new driver:");
                secondPositionCount = scanner.nextInt();
                System.out.println("\nNumber of third positions held by the new driver:");
                thirdPositionCount = scanner.nextInt();
                System.out.println("\nTotal points the new driver:");
                totalPoints = scanner.nextInt();
                System.out.println("\nNumber of races the new driver has participated in:");
                participatedRaceCount = scanner.nextInt();

                System.out.println("\nName: " + name);
                System.out.println("Team/Manufacturer: " + team);
                System.out.println("Location: " + location);
                System.out.println("First Position Count: " + firstPositionCount);
                System.out.println("Second Position Count: " + secondPositionCount);
                System.out.println("Third Position Count: " + thirdPositionCount);
                System.out.println("Total Points: " + totalPoints);
                System.out.println("Participated Race Count: " + participatedRaceCount);

                System.out.println("\nAre these details correct? Press Y to confirm or N to re-enter.");
                inputInfoCorrect = scanner.nextLine();
                count1 = count1 + 1;
            }

            for (int count = 0; count < (driverArrayList.size()); count++) {
                if (driverArrayList.get(count).name == name) {
                    System.out.println("\nThis driver has already been added to the championship.");
                    driverAdded = false;
                } else {
                    if (driverArrayList.get(count).team == team) {
                        System.out.println("\nThis team/manufacturer already has another driver.");
                    }
                }
            }

            formula1Driver = new Formula1Driver(name, team, location, firstPositionCount, secondPositionCount,
                    thirdPositionCount, totalPoints, participatedRaceCount);
            driverArrayList.add(driverArrayList.size(), formula1Driver);

            displayDriverTable();

            if (driverAdded == false) {
                System.out.println("\nDo you want to add another driver? Press Y if yes or N if no.");
                driverToBeAdded = scanner.nextLine();
            }

        }

    }

    public void deleteDriver() {
        String driverName;
        boolean driverRemoved = false;
        String name = "";

        if (driverArrayList.size() == 0) {
            System.out.println("All booths are empty.");
        } else {
            displayDriverTable();
            System.out.println("");
            System.out.println("Enter the name of the driver you want to remove.");
            scanner.nextLine();
            name = scanner.nextLine();
            for (int count = 0; count < driverArrayList.size(); count++) {

                driverName = driverArrayList.get(count).name;
                if (driverName.equals(name)) {
                    driverArrayList.remove(count);
                    driverRemoved = true;
                    System.out.println("Driver " + driverName + " has been removed.");
                    displayDriverTable();
                }
            }
            if (!driverRemoved) {
                System.out.println("Driver not found.");
            }
        }
    }

    public void changeDriver() {
        String team;
        String driverTeam;
        String name;
        boolean driverRemoved = false;
        displayDriverTable();
        System.out.println("\nEnter the team/manufacturer you want to change the driver for:");
        scanner.nextLine();
        team = scanner.nextLine();
        for (int count = 0; count < driverArrayList.size(); count++) {
            driverTeam = driverArrayList.get(count).team;
            if (driverTeam.equals(team)) {
                System.out.println("Enter the name of the new driver.");
                name = scanner.nextLine();
                driverArrayList.get(count).name = name;
                driverRemoved = true;
                System.out.println("Driver has been changed for team " + team);
                displayDriverTable();
            }
        }
        if (!driverRemoved) {
            System.out.println("Team not found.");
        }

    }

    public void displayStatistics() {
        if (driverArrayList.size() == 0) {
            System.out.println("There are no added drivers.");
        } else {
            displayDriverTable();
            System.out.println("\nEnter the name of the driver.");
            scanner.nextLine();
            String name = scanner.nextLine();
            for (Formula1Driver formula1Driver : driverArrayList) {
                if (formula1Driver.name.equals(name)) {
                    System.out.println("\nName: " + formula1Driver.name);
                    System.out.println("Location: " + formula1Driver.location);
                    System.out.println("Team: " + formula1Driver.team);
                    System.out.println("First Position Count: " + formula1Driver.firstPositionCount);
                    System.out.println("Second Position Count: " + formula1Driver.secondPositionCount);
                    System.out.println("Third Position Count: " + formula1Driver.thirdPositionCount);
                    System.out.println("Total Points: " + formula1Driver.totalPoints);
                    System.out.println("Participated Race Count: " + formula1Driver.participatedRaceCount);
                    break;
                }
            }
        }

    }

    public void displayDriverTable() {
        Collections.sort(driverArrayList, new comparePointsDescending());
        System.out.println(
                "\nName\t|\tTeam\t|\tLocation\t|\tFirst Positions\t|\tSecond Positions\t|\tThird Positions\t|\tTotal Points\t|\tParticipated Races");
        for (Formula1Driver formula1Driver : driverArrayList) {
            System.out.println(formula1Driver.name + "\t|\t" + formula1Driver.team + "\t|\t" + formula1Driver.location
                               + "\t|\t" + formula1Driver.firstPositionCount + "\t|\t" + formula1Driver.secondPositionCount
                               + "\t|\t" + formula1Driver.thirdPositionCount + "\t|\t" + formula1Driver.totalPoints + "\t|\t"
                               + formula1Driver.participatedRaceCount);
        }

    }

    public void addRace() {
        String date = "";
        int count;
        String inputInfoCorrect;
        String raceToBeAdded = "Y";
        int count1 = 0;
        boolean driverInList = false;
        int points;
        String team;
        String location;
        Formula1Driver formula1Driver;
        int arrayListCount = 0;

        initialisePositions();
        while (raceToBeAdded.equals("Y")) {
            inputInfoCorrect = "N";
            while (inputInfoCorrect.equals("N")) { // operation iteration
                // Get user input
                System.out.println("Enter the date of the race in the format yyyy/mm/dd.");
                if (count1 == 0) {
                    scanner.nextLine();
                }
                date = scanner.nextLine();
                System.out.println("Enter the name of the drivers at the following positions.");

                for (int position = 1; position < 11; position++) {
                    count = position - 1;
                    System.out.print(position + " : ");
                    positions[count] = scanner.nextLine();
                }

                System.out.println("\n");
                // display positions and get confirmation

                for (int position = 1; position < 11; position++) {
                    count = position - 1;
                    System.out.println(position + " : " + positions[count]);
                }
                System.out.println("\nAre these details correct? Press Y to confirm or N to re-enter.");
                inputInfoCorrect = scanner.nextLine();
                count1 = count1 + 1;
            }

            for (int count2 = 0; count2 < 10; count2++) {
                driverInList = false;

                for (int count3 = 0; count3 < driverArrayList.size(); count3++) {
                    if (driverArrayList.get(count3).name.equals(positions[count2])) {
                        driverInList = true;
                        arrayListCount = count3;
                        break;
                    }
                }
                if (!driverInList) {
                    System.out.println("Driver " + positions[count2] + " is new. Please enter their team/manufacturer name:");
                    team = scanner.nextLine();
                    System.out.println("Enter their location:");
                    location = scanner.nextLine();

                    formula1Driver = new Formula1Driver(positions[count2], team, location, 0, 0, 0, 0, 0);
                    driverArrayList.add(formula1Driver);
                    arrayListCount = driverArrayList.size() - 1;
                }
                formula1Driver = driverArrayList.get(arrayListCount);
                switch (count2) {
                    case 0 -> {
                        points = 25;
                        formula1Driver.firstPositionCount++;
                    }
                    case 1 -> {
                        points = 18;
                        formula1Driver.secondPositionCount++;
                    }
                    case 2 -> {
                        points = 15;
                        formula1Driver.thirdPositionCount++;
                    }
                    case 3 -> points = 12;
                    case 4 -> points = 10;
                    case 5 -> points = 8;
                    case 6 -> points = 6;
                    case 7 -> points = 4;
                    case 8 -> points = 2;
                    case 9 -> points = 1;
                    default -> throw new IllegalStateException("Unexpected value: " + count2);
                }

                formula1Driver.totalPoints = formula1Driver.totalPoints + points;
                formula1Driver.participatedRaceCount++;
            }

            Race race = new Race(date, positions);
            raceArrayList.add(race);
            System.out.println("\nRace added.");

            System.out.println("\nDo you want to add another race? Press Y if yes or N if no.");
            raceToBeAdded = scanner.nextLine();

        }

    }

    private void initialisePositions() {
        for (int count = 0; count < 9; count++) {
            positions[count] = "";
        }
    }

    public void saveInfoToFile() throws IOException {
        fileWriter = new FileWriter("current_driver_information.txt");
        bufferedWriter = new BufferedWriter(fileWriter);

        for (Formula1Driver formula1Driver : driverArrayList) {
            String[] recordArray = new String[]{formula1Driver.name, formula1Driver.team, formula1Driver.location,
                    String.valueOf(formula1Driver.firstPositionCount),
                    String.valueOf(formula1Driver.secondPositionCount),
                    String.valueOf(formula1Driver.thirdPositionCount), String.valueOf(formula1Driver.totalPoints),
                    String.valueOf(formula1Driver.participatedRaceCount)};
            String record = String.join(";", recordArray);
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        }

        String divider = "----";
        bufferedWriter.write(divider);
        bufferedWriter.newLine();

        for (Race race : raceArrayList) {
            String[] recordArray = new String[]{
                    race.date, race.positions[0], race.positions[1], race.positions[2], race.positions[3],
                    race.positions[4], race.positions[5], race.positions[6], race.positions[7], race.positions[8],
                    race.positions[9]};
            String record = String.join(";", recordArray);
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        }

        System.out.println("Program data written to file.");
        bufferedWriter.close();

    }

    public void recoverPreviousState() throws IOException {
        Formula1Driver formula1Driver;
        Race race;
        String[] recordArray;
        String[] positions = new String[10];
        Boolean dividerReached = false;

        try {
            fileReader = new FileReader("current_driver_information.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                if (line.equals("----")){
                    dividerReached = true;
                    break;
                }
                recordArray = line.split(";");
                formula1Driver = new Formula1Driver(recordArray[0], recordArray[1], recordArray[2],
                        Integer.parseInt(recordArray[3]), Integer.parseInt(recordArray[4]),
                        Integer.parseInt(recordArray[5]), Integer.parseInt(recordArray[6]),
                        Integer.parseInt(recordArray[7]));
                driverArrayList.add(driverArrayList.size(), formula1Driver);
                line = bufferedReader.readLine();
            }
            if (dividerReached = true){
                recordArray = line.split(";");
                String date = recordArray[0];
                for (int count = 0; count < 10; count++) {
                    positions = Arrays.copyOfRange(recordArray,1,10);
                }
                race = new Race(date,positions);
//                formula1Driver = new Formula1Driver(recordArray[0], recordArray[1], recordArray[2],
//                        Integer.parseInt(recordArray[3]), Integer.parseInt(recordArray[4]),
//                        Integer.parseInt(recordArray[5]), Integer.parseInt(recordArray[6]),
//                        Integer.parseInt(recordArray[7]));
                raceArrayList.add(raceArrayList.size(), race);
            }

            bufferedReader.close();
            displayDriverTable();
            System.out.println("\nPrevious state recovered.");
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
            return;
        }
    }

    // Exit the program
    public void exitProgram() {
        System.out.println("Program exited.");
    }
}
