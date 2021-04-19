package org.academiadecodigo.rapunshells.game.gfx;

import org.academiadecodigo.rapunshells.game.CollisionDetector;
import org.academiadecodigo.rapunshells.game.Sound;
import org.academiadecodigo.rapunshells.game.bart.Bart;
import org.academiadecodigo.rapunshells.game.obstacle.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    private boolean hasBeenDeleted = false;
    private boolean restarted = false;
    private boolean started = false;
    private int countTogenerate;
    private int generateCount = 0;
    private int jumpCount = 0;
    private int limitTogenerate = 50;
    private final int PADDING = 10;
    private final int SCREEN_HEIGHT = 650;
    private final int SCREEN_WIDTH = 1300;

    private Bart bart;
    private CollisionDetector collisionDetector = new CollisionDetector();
    private Control control;
    private LinkedObjects allObstacles = new LinkedObjects();
    private Obstacle[] obstacles;
    private Picture background;
    private Picture finalBackground;
    private Picture gameOverBackground;
    private Picture initialBackground;
    private Picture startBackground;
    private Rectangle mainGrid;
    private Sound gameOver;
    private Sound theme;

    private final String[] backgroundPaths = {"resources/background/frame02.png", "resources/background/frame03.png",
            "resources/background/frame04.png", "resources/background/frame05.png", "resources/background/frame06.png",
            "resources/background/frame07.png", "resources/background/frame08.png", "resources/background/frame09.png",
            "resources/background/frame10.png", "resources/background/frame11.png", "resources/background/frame12.png",
            "resources/background/frame13.png", "resources/background/frame14.png", "resources/background/frame15.png",
            "resources/background/frame16.png", "resources/background/frame17.png", "resources/background/frame18.png",
            "resources/background/frame19.png", "resources/background/frame20.png", "resources/background/frame21.png",
            "resources/background/frame22.png", "resources/background/frame23.png", "resources/background/frame24.png",
            "resources/background/frame25.png", "resources/background/frame26.png", "resources/background/frame27.png",
            "resources/background/frame28.png", "resources/background/frame29.png", "resources/background/frame30.png",
            "resources/background/frame31.png", "resources/background/frame32.png", "resources/background/frame33.png",
            "resources/background/frame34.png", "resources/background/frame35.png", "resources/background/frame36.png",
            "resources/background/frame37.png", "resources/background/frame38.png", "resources/background/frame39.png",
            "resources/background/frame40.png", "resources/background/frame41.png", "resources/background/frame42.png",
            "resources/background/frame43.png", "resources/background/frame44.png", "resources/background/frame45.png",
            "resources/background/frame46.png", "resources/background/frame47.png", "resources/background/frame48.png",
            "resources/background/frame49.png", "resources/background/frame50.png", "resources/background/frame51.png",
            "resources/background/frame52.png", "resources/background/frame53.png", "resources/background/frame54.png",
            "resources/background/frame55.png", "resources/background/frame56.png", "resources/background/frame57.png",
            "resources/background/frame58.png", "resources/background/frame59.png", "resources/background/frame60.png",
            "resources/background/frame61.png", "resources/background/frame62.png", "resources/background/frame01.png"
    };

    private final String[] initialBackgroundPaths = {"resources/initialbackground/frame2.png",
            "resources/initialbackground/frame3.png", "resources/initialbackground/frame4.png",
            "resources/initialbackground/frame5.png", "resources/initialbackground/frame6.png",
            "resources/initialbackground/frame7.png", "resources/initialbackground/frame8.png",
            "resources/initialbackground/frame9.png", "resources/initialbackground/frame10.png"
    };

    private final String[] startBackgroundPaths = {"resources/initialbackground/loopframe12.png",
            "resources/initialbackground/loopframe11.png"
    };

    private final String[] gameOverBackgroundPaths = {"resources/gameover/BartEndScreen2.png",
            "resources/gameover/BartEndScreen3.png", "resources/gameover/BartEndScreen4.png",
            "resources/gameover/BartEndScreen5.png", "resources/gameover/BartEndScreen6.png",
            "resources/gameover/BartEndScreen7.png", "resources/gameover/BartEndScreen8.png",
            "resources/gameover/BartEndScreen9.png", "resources/gameover/BartEndScreen10.png"
    };

    private final String[] finalBackgroundPaths = {"resources/gameover/BartEndScreen12Loop.png",
            "resources/gameover/BartEndScreen11Loop.png"
    };

    public Screen() {
        mainGrid = new Rectangle(PADDING, PADDING, SCREEN_WIDTH, SCREEN_HEIGHT);
        background = new Picture(PADDING, PADDING, "resources/background/frame01.png");
        initialBackground = new Picture(PADDING, PADDING, "resources/initialbackground/frame1.png");
        startBackground = new Picture(PADDING, PADDING, "resources/initialbackground/loopframe11.png");
        gameOverBackground = new Picture(PADDING, PADDING, "resources/gameover/BartEndScreen1.png");
        finalBackground = new Picture(PADDING, PADDING, "resources/gameover/BartEndScreen11Loop.png");
        control = new Control(this);
        theme = new Sound("/resources/sound/simpsons_theme.wav");
        gameOver = new Sound("/resources/sound/game_over.wav");
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isRestarted() {
        return restarted;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void setRestarted(boolean restarted) {
        this.restarted = restarted;
    }

    public void start() throws InterruptedException {
        initialBackground.draw();

        theme.play(true);
        theme.loop();

        for (int i = 0; i < initialBackgroundPaths.length; i++) {
            Thread.sleep(200);
            initialBackground.load(initialBackgroundPaths[i]);
        }

        startBackground.draw();

        while (!isStarted()) {
            for (int i = 0; i < startBackgroundPaths.length; i++) {
                Thread.sleep(200);
                startBackground.load(startBackgroundPaths[i]);
            }
        }

        if (isStarted()) {
            init();
        }
    }

    public void restart() throws InterruptedException {
        gameOverBackground.draw();

        for (int i = 0; i < gameOverBackgroundPaths.length; i++) {
            Thread.sleep(200);
            gameOverBackground.load(gameOverBackgroundPaths[i]);
        }

        finalBackground.draw();

        while (!isRestarted()) {
            for (int i = 0; i < finalBackgroundPaths.length; i++) {
                Thread.sleep(200);
                finalBackground.load(finalBackgroundPaths[i]);
            }
        }

        if (isRestarted()) {
            gameOver.stop();

            theme.play(true);
            theme.loop();

            restarted = false;
            init();
        }
    }

    public void removeAllObstacles(){
        for (Obstacle obstacles: allObstacles) {
            allObstacles.remove(obstacles);
            obstacles.getFakeObject().delete();
        }
        bart.getFakeBart().delete();
    }

    public void init() throws InterruptedException {
        int index = 0;

        bart = new Bart();

        mainGrid.draw();
        background.draw();

        collisionDetector.setBart(bart);
        collisionDetector.setAllObstacles(allObstacles);

        Obstacle a = new Obstacle(ObstacleType.MAGGIE, Lanes.LANE1);
        allObstacles.add(a);

        while (!bart.isCrashed()) {
            countTogenerate++;

            bart.movementLeft();
            bart.bartDown();
            bart.movementRight();
            bart.bartSequence(3);
            bart.getFakeBart().delete();
            bart.getFakeBart().draw();

            generateCount++;

            Thread.sleep(50);

            if (countTogenerate % 150 == 0) {

                if (limitTogenerate > 10) {
                    limitTogenerate -= 10;
                    System.out.println("LEVEL INCREASED");

                } else {
                    if(limitTogenerate>3) {
                        System.out.println("LEVEL INCREASED");
                        limitTogenerate--;
                    }
                }
            }

            if (generateCount > limitTogenerate) {
                allObstacles.add(ObstacleFactory.createObstacle());
                generateCount = 0;
            }

            background.load(backgroundPaths[index]);
            index++;
            if (index == (backgroundPaths.length - 1)) {
                index = 0;
            }




                for (Obstacle ob : allObstacles) {
                    ob.move();

                    if (ob.getFakeObject().getX() < ob.getRemoveX()) {
                        allObstacles.remove(ob);
                    }



                    if (collisionDetector.checkCrash(ob)) {
                        bart.setCrashed(true);

                        theme.stop();

                        gameOver.play(true);
                        gameOver.loop();

                        bart.getFakeBart().translate(200, 40);
                        bart.getFakeBart().load("resources/bartfall1.png");

                        Thread.sleep(150);

                        bart.getFakeBart().translate(200, 30);
                        bart.getFakeBart().load("resources/bartfall2.png");

                        Thread.sleep(1000);

                        background.delete();
                        countTogenerate = 0;
                        limitTogenerate = 50;
                        removeAllObstacles();
                        restart();
                    }
                }

            if (bart.isJumping()) {

                if (jumpCount == 0) {
                    bart.setFakeBartJump1();
                    bart.moveUp(60);
                }

                jumpCount++;

                if (jumpCount == 8) {
                    bart.setFakeBartJump2();
                    bart.moveDown(20);
                }

                if (jumpCount == 15) {
                    bart.moveDown(40);
                    bart.setJumping(false);
                    jumpCount = 0;
                    bart.setFakeBartToNormal();
                }
            }
        }

        System.out.println("GAME OVER");
    }

}
