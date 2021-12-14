package main;

import gui.MenuGUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int choice = 0;

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        while (choice != 10) {

            choice = formula1ChampionshipManager.printMenu();

            switch (choice) {
                case 1 -> formula1ChampionshipManager.addDriver();
                case 2 -> formula1ChampionshipManager.deleteDriver();
                case 3 -> formula1ChampionshipManager.changeDriver();
                case 4 -> formula1ChampionshipManager.displayStatistics();
                case 5 -> formula1ChampionshipManager.displayDriverTable();
                case 6 -> formula1ChampionshipManager.addRace();
                case 7 -> formula1ChampionshipManager.saveInfoToFile();
                case 8 -> formula1ChampionshipManager.recoverPreviousState();
                case 9 -> new MenuGUI().initialiseUI();
                case 10 -> formula1ChampionshipManager.exitProgram();
                default -> {
                    System.out.println("Enter a valid choice.");
                    choice = formula1ChampionshipManager.printMenu();
                }

            }

        }
    }
}
