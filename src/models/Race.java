package models;

public class Race {
    public String date;
    public String[] endPositions;
    public String[] startPositions;

    public Race(String dateOfRace, String[] endPositionsOfRace, String[] startPositionsOfRace) {
        date = dateOfRace;
        endPositions = endPositionsOfRace;
        startPositions = startPositionsOfRace;
    }
}
