package main;

import models.Formula1Driver;

import java.util.Comparator;

public class ComparatorPointsDescending implements Comparator<Formula1Driver> {
    @Override
    //Sort the drivers in descending order of points.
    //If equal, sort by first position count.
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        int result;
        result = o2.totalPoints - o1.totalPoints;
        if (result == 0) {
            result = o2.firstPositionCount - o1.firstPositionCount;
        }
        return result;
    }
}
