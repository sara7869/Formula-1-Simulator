package gui;

import models.Formula1Driver;

import java.util.Comparator;

public class ComparatorFirstPositionsDescending implements Comparator<Formula1Driver> {
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        return o2.firstPositionCount - o1.firstPositionCount;
    }

}
