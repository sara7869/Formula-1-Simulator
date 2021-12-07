package main;

import models.Formula1Driver;

import java.util.Comparator;

public class comparePointsDescending implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        int result;
        result = o2.totalPoints - o1.totalPoints;
        if (result == 0) {
            result = o2.firstPositionCount - o1.firstPositionCount;
        }
        return result;
    }
}
