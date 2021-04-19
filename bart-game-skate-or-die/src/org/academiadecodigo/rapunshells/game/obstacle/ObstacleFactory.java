package org.academiadecodigo.rapunshells.game.obstacle;

import org.academiadecodigo.rapunshells.game.Randomizer;

public class ObstacleFactory {
    public static Obstacle createObstacle(){
        int random1 = Randomizer.generateNumber(ObstacleType.values().length);
        int random2 = Randomizer.generateNumber(4);

        switch (ObstacleType.values()[random1]){
        //switch (ObstacleType.MAGGIE){
            case BUS:
                return new Obstacle(ObstacleType.BUS,Randomizer.generateNumberWithout0(2) == 1 ? Lanes.LANE2:Lanes.LANE3 );
            case MARTIN:
                return new Obstacle(ObstacleType.MARTIN, Lanes.values()[random2]);
            case MAGGIE:
                return new Obstacle(ObstacleType.MAGGIE,Lanes.values()[random2]);
            case ITCHY_SCRATCHY:
                return new Obstacle(ObstacleType.ITCHY_SCRATCHY,Lanes.values()[random2]);
            case MILLHOUSE:
                return new Obstacle(ObstacleType.MILLHOUSE,Lanes.values()[random2]);
            case SCIENTIST:
                return new Obstacle(ObstacleType.SCIENTIST,Lanes.values()[random2]);
            case POLICEMEN:
                return new Obstacle(ObstacleType.POLICEMEN,Lanes.values()[random2]);
            case COMICBOOK_GUY:
                return new Obstacle(ObstacleType.COMICBOOK_GUY,Lanes.values()[random2]);
            case KRUSTY_THE_CLOWN:
                return new Obstacle(ObstacleType.KRUSTY_THE_CLOWN,Lanes.values()[random2]);
            default:
                System.out.println("AKJSANSIJFNASNFDKJANSDFJAN");
                return null;
        }

    }
}
