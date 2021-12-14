package gui;

import models.Formula1Driver;
import models.Race;

import java.util.Comparator;

public class ComparatorRaceDatesAscending implements Comparator<Race> {
    @Override
    public int compare(Race o1, Race o2) {
        return o1.date.compareTo(o2.date);    }
}
