package gui;

import models.Formula1Driver;

import java.util.Comparator;

public class comparePointsAscending implements Comparator<Formula1Driver>{
        @Override
        public int compare(Formula1Driver o1, Formula1Driver o2) {
            return o1.totalPoints - o2.totalPoints;
        }

}
