package models;

public class Race {
    private String date;
    private String[] positions = new String[10];

    public Race(String dateOfRace, String[] positionsOfRace) {
        date = dateOfRace;
        positions = positionsOfRace;
    }


}
