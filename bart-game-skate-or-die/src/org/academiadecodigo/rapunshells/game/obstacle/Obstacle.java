package org.academiadecodigo.rapunshells.game.obstacle;

import org.academiadecodigo.rapunshells.game.CollisionDetector;
import org.academiadecodigo.rapunshells.game.Position;
import org.academiadecodigo.rapunshells.game.gfx.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle extends LanableObject{
    private Position pos =new Position();
    private ObstacleType type;
    private Picture fakeObject;
    private int obstacleCounter = 0;
    private CollisionDetector detector;
    protected int rangeCrashMaxX;
    protected int rangeCrashMinX;
    private int removeX;
    private boolean isJumpable;
    private int speed;

    public int getLane() {
        return lane;
    }

    public int getRemoveX() {
        return removeX;
    }

    public boolean isJumpable() {
        return isJumpable;
    }

    public Obstacle(ObstacleType type, Lanes lane){
        this.type = type;
        fakeObject = new Picture(1300,type.getInitialY() - lane.getLaneValue(), type.getString() );
        fakeObject.draw();
        rangeCrashMaxX = type.getRangeCrashMaxX();
        rangeCrashMinX = type.getRangeCrashMinX();
        this.lane = lane.getLane();
        removeX = type.getRemoveX();
        isJumpable = type.isJumpable();
        speed = type.getSpeed();
    }


    public int getRangeCrashMaxX() {
        return rangeCrashMaxX;
    }

    public int getRangeCrashMinX() {
        return rangeCrashMinX;
    }

    public void addCounter(){
        obstacleCounter++;
    }
    public void resetCounter(){
        obstacleCounter = 0;
    }
    public void move(){
        fakeObject.translate(-10-10*speed,0);

    }
    public Picture getFakeObject(){
        return fakeObject;
    }

    public void setDetector(CollisionDetector detector){
        this.detector = detector;
    }
    public Position getPos() {
        return pos;
    }


}
