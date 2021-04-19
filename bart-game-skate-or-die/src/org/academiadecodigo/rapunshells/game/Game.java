package org.academiadecodigo.rapunshells.game;

import org.academiadecodigo.rapunshells.game.bart.Bart;
import org.academiadecodigo.rapunshells.game.gfx.Screen;
import org.academiadecodigo.rapunshells.game.obstacle.Obstacle;

public class Game {
    private Obstacle[] allObstacles;
    private Bart bart;
    private CollisionDetector detector;
    private int points;


    public void init(){
        //create obstacles, assigning collision detector to all of them
    }

    public void start() throws InterruptedException {
        Screen screen = new Screen();
        screen.init();
        new Bart();

    }

}
