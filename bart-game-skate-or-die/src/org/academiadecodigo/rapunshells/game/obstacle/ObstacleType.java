package org.academiadecodigo.rapunshells.game.obstacle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum ObstacleType {

    MAGGIE(2, "resources/maggiefirst.png",380,260,435,-80,true),
    BUS(4,"resources/busfirst.png",370,-120,250,-480,false),
    COMICBOOK_GUY(2,"resources/comicbookguy.png",370,260,335,-100,false),
    KRUSTY_THE_CLOWN(2,"resources/krustytheclown.png",340,220,335,-100,false),//a340
    MARTIN(2,"resources/martin.png",370,250,335,-100,true),
    MILLHOUSE(2,"resources/milhouse.png",370,250,335,-100,true),//-80a
    POLICEMEN(2,"resources/policeman.png",350,230,335,-100,false),
    SCIENTIST(2,"resources/scientist.png",360,270,335,-100,false),
    ITCHY_SCRATCHY(2,"resources/itchyandscratchy(1).png",370,260,335,-100,true);


    private int speed;
    private Picture picture;
    private String string;
    private int rangeCrashMaxX;
    private int rangeCrashMinX;
    private int initialY;
    private int removeX;
    private boolean isJumpable;


    ObstacleType(int speed, String picture, int rangeCrashMaxX, int rangeCrashMinX, int initialY, int removeX, boolean isJumpable){
        this.speed = speed;
        this.picture = new Picture();
        this.string = picture;
        this.rangeCrashMaxX = rangeCrashMaxX;
        this.rangeCrashMinX = rangeCrashMinX;
        this.initialY = initialY;
        this.removeX = removeX;
        this.isJumpable = isJumpable;



    }
    public int getSpeed() {
        return speed;
    }

    public boolean isJumpable() {
        return isJumpable;
    }
    public int getRemoveX() {
        return removeX;
    }

    public int getInitialY() {
        return initialY;
    }

    public int getRangeCrashMaxX() {
        return rangeCrashMaxX;
    }

    public int getRangeCrashMinX() {
        return rangeCrashMinX;
    }

    public String getString(){
        return string;
    }
}
