Formula 1 Racing Championship Manager in Java
Overview
This project simulates the management of a Formula 1 racing championship. The system is designed to handle drivers, constructor teams, and their performance across races. It offers both a console-based menu and a graphical user interface (GUI) using Java Swing, allowing users to interact with the system and simulate random races. Data is stored between runs, and race results, along with driver statistics, are updated automatically.

Key Features
1. Driver and Team Management
Create and add drivers to the championship.
Each driver belongs to a unique constructor team (e.g., Ferrari, Mercedes).
Modify or delete drivers and their corresponding teams.
2. Championship Management
Record race results, assigning positions to drivers and updating their points.
Display statistics for individual drivers.
Automatically sort and display a championship table, showing drivers in descending order of points. Drivers with the most first-place wins take precedence in case of tied points.
3. File Persistence
Save championship data (driver, team, race statistics) to a file.
Load data from a saved file to resume operations from the previous session.
4. Graphical User Interface (GUI)
View the driver standings in a table.
Sort drivers by points or first-place finishes.
Simulate random races and update the standings with probabilistic outcomes.
Display completed races sorted by the date of occurrence.
Search for races a particular driver participated in and view their race performance.

How to Run
Clone the repository.
Open the project in your IDE.
Compile and run the main method in Formula1ChampionshipManager.
Use the console menu for text-based interactions, or launch the GUI from the menu for the graphical interface.
Console Menu Options
Create a new driver
Delete a driver and their team
Change a driver for an existing team
Display driver statistics
Display the driver standings table
Add race results
Save and load championship data
GUI Features
View sorted standings
Simulate random races
Search for race history of a specific driver
Display race results sorted by date
Points System
1st place: 25 points
2nd place: 18 points
3rd place: 15 points
4th place: 12 points
5th place: 10 points
6th place: 8 points
7th place: 6 points
8th place: 4 points
9th place: 2 points
10th place: 1 point
Saving and Loading
The application saves all driver and race information to a file upon request. When restarted, the system can load this file and continue from where it left off.
