package org.academiadecodigo.rapunshells.game;

import org.academiadecodigo.rapunshells.game.bart.Bart;
import org.academiadecodigo.rapunshells.game.obstacle.LinkedObjects;
import org.academiadecodigo.rapunshells.game.obstacle.Obstacle;

public class CollisionDetector {
    private LinkedObjects allObstacles;
    private Bart bart;






    public boolean checkCrash(Obstacle obstacle){
        if(obstacle.isJumpable()){
            if((obstacle.getLane() == bart.getLane() && (obstacle.getFakeObject().getX() < obstacle.getRangeCrashMaxX() && obstacle.getFakeObject().getX()>obstacle.getRangeCrashMinX()))&& !bart.isJumping()){
                return true;
            }
            return false;
        }
        if(obstacle.getLane() == bart.getLane() && (obstacle.getFakeObject().getX() < obstacle.getRangeCrashMaxX() && obstacle.getFakeObject().getX()>obstacle.getRangeCrashMinX())){
            return true;
        }
        return false;
    }

    public void setBart(Bart bart) {
        this.bart = bart;
    }
    public void setAllObstacles(LinkedObjects allObstacles) {
        this.allObstacles = allObstacles;
    }
}
