package org.academiadecodigo.rapunshells.game.obstacle;

public enum Lanes {
    LANE1(1,0),
    LANE2(2,50),
    LANE3(3,130),
    LANE4(4,190);

    private int lane;
    private int laneValue;

    public int getLane() {
        return lane;
    }

    public int getLaneValue() {
        return laneValue;
    }

    Lanes(int lane, int laneValue){
        this.lane = lane;
        this.laneValue = laneValue;


    }
}
