import models.ChampionshipManager;
import models.Formula1Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

    static Scanner scanner = new Scanner(System.in);
    public String[] positions = new String[10];
    static ArrayList<Formula1Driver> driverArrayList = new ArrayList<Formula1Driver>();
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
                5: Display the Formula 1 models.Driver Table
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
                System.out.println("\nmodels.Team/Manufacturer for the new driver:");
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
                System.out.println("models.Team/Manufacturer: " + team);
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
                    System.out.println("models.Driver " + driverName + " has been removed.");
                    displayDriverTable();
                }
            }
            if (!driverRemoved) {
                System.out.println("models.Driver not found.");
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
                System.out.println("models.Driver has been changed for team " + team);
                displayDriverTable();
            }
        }
        if (!driverRemoved) {
            System.out.println("models.Team not found.");
        }

    }

    public void displayStatistics() {
        if (driverArrayList.size() == 0) {
            System.out.println("There are no added drivers.");
        } else {
            System.out.println("Enter the name of the driver.");
            scanner.nextLine();
            String name = scanner.nextLine();
            for (int count = 0; count < driverArrayList.size(); count++) {
                if (driverArrayList.get(count).name == name) {
                    System.out.println("Name: " + driverArrayList.get(count).name);
                    System.out.println("Location: " + driverArrayList.get(count).location);
                    System.out.println("models.Team: " + driverArrayList.get(count).team);
                    System.out.println("First Position Count: " + driverArrayList.get(count).firstPositionCount);
                    System.out.println("Second Position Count: " + driverArrayList.get(count).secondPositionCount);
                    System.out.println("Third Position Count: " + driverArrayList.get(count).thirdPositionCount);
                    System.out.println("Total Points: " + driverArrayList.get(count).totalPoints);
                    System.out.println("Participated Race Count: " + driverArrayList.get(count).participatedRaceCount);
                    continue;
                }
            }
        }

    }

    public void displayDriverTable() {
        Collections.sort(driverArrayList,new compare());
        System.out.println(
                "\nName\t|\tmodels.Team\t|\tLocation\t|\tFirst Positions\t|\tSecond Positions\t|\tThird Positions\t|\tTotal Points\t|\tParticipated Races");
        for (Formula1Driver formula1Driver : driverArrayList) {
            System.out.println(formula1Driver.name + "\t|\t" + formula1Driver.team + "\t|\t" + formula1Driver.location
                    + "\t|\t" + formula1Driver.firstPositionCount + "\t|\t" + formula1Driver.secondPositionCount
                    + "\t|\t" + formula1Driver.thirdPositionCount + "\t|\t" + formula1Driver.totalPoints + "\t|\t"
                    + formula1Driver.participatedRaceCount);
        }

    }



    public void addRace() {
        String date;
        int position;
        String inputInfoCorrect = "N";
        String raceToBeAdded = "Y";
        boolean raceAdded = false;

        // String [] positions = new String[6];

        initialisePositions();
        while (raceToBeAdded.equals("Y")) {
            inputInfoCorrect = "N";
            while (inputInfoCorrect.equals("N")) { // operation iteration
                // Get user input
                System.out.println("Enter the date of the race in the format yyyy/mm/dd.");
                scanner.nextLine();
                date = scanner.nextLine();
                System.out.println("Enter the name of the drivers at the following positions.");

                for (int count = 0; count < 9; count++) {
                    position = count + 1;
                    System.out.print(position + " : ");
                    positions[position] = scanner.nextLine();
                }

                System.out.println("\n");
                // display positions and get confirmation

                for (int count = 0; count < 9; count++) {
                    position = count + 1;
                    System.out.println(position + " : " + positions[count]);
                }
                System.out.println("\nAre these details correct? Press Y to confirm or N to re-enter.");
                inputInfoCorrect = scanner.nextLine();
            }

            for (int count = 0; count < (driverArrayList.size()); count++) {
                // if (driverArrayList.get(count).secondPositionCount == date) {
                System.out.println("\nThis race has already been added.");
                raceAdded = false;
            }
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
            String[] recordArray = new String[] { formula1Driver.name, formula1Driver.team, formula1Driver.location,
                    String.valueOf(formula1Driver.firstPositionCount),
                    String.valueOf(formula1Driver.secondPositionCount),
                    String.valueOf(formula1Driver.thirdPositionCount), String.valueOf(formula1Driver.totalPoints),
                    String.valueOf(formula1Driver.participatedRaceCount) };
            String record = String.join(";", recordArray);
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        }
        System.out.println("Program data written to file.");
        bufferedWriter.close();

    }

    //
    public void recoverPreviousState() throws IOException {
        Formula1Driver formula1Driver;
        String[] recordArray;

        try {
            fileReader = new FileReader("current_driver_information.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                recordArray = line.split(";");
                formula1Driver = new Formula1Driver(recordArray[0], recordArray[1], recordArray[2],
                        Integer.parseInt(recordArray[3]), Integer.parseInt(recordArray[4]),
                        Integer.parseInt(recordArray[5]), Integer.parseInt(recordArray[6]),
                        Integer.parseInt(recordArray[7]));
                driverArrayList.add(driverArrayList.size(), formula1Driver);
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
