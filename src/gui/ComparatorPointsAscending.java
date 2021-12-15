package gui;

import models.Formula1Driver;

import java.util.Comparator;

public class ComparatorPointsAscending implements Comparator<Formula1Driver> {
    @Override
    //Sort the points of drivers in ascending order
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        return o1.totalPoints - o2.totalPoints;
    }

}
