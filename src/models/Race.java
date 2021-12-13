package models;

public class Race {
    public String date;
    public String[] positions = new String[10];

    public Race(String dateOfRace, String[] positionsOfRace) {
        date = dateOfRace;
        positions = positionsOfRace;
    }
}
