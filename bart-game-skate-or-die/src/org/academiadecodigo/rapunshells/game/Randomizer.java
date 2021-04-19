package org.academiadecodigo.rapunshells.game;

public class Randomizer {
    public static int generateNumber(int max){
        return (int) (Math.random()*max);
    }
    public static int generateNumberWithout0(int max){
        return generateNumber(max)+1;
    }
}
