package gui;

import models.Race;

import java.util.Comparator;

public class ComparatorRaceDatesAscending implements Comparator<Race> {
    @Override
    //Sort the dates of races in ascending order
    public int compare(Race o1, Race o2) {
        return o1.date.compareTo(o2.date);
    }
}
