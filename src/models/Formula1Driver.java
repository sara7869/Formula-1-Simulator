package models;

import models.Driver;

public class Formula1Driver extends Driver {
    public Formula1Driver(String nameOfDriver, String teamOfDriver, String locationOfDriver, int pos1Count, int pos2Count, int pos3Count, int totPoints, int paticipateCount) {
        name = nameOfDriver;
        team = teamOfDriver;
        location = locationOfDriver;
        firstPositionCount = pos1Count;
        secondPositionCount = pos2Count;
        thirdPositionCount = pos3Count;
        totalPoints = totPoints;
        participatedRaceCount = paticipateCount;
    }

}