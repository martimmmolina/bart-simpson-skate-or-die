package org.academiadecodigo.rapunshells.game.bart;

import org.academiadecodigo.rapunshells.game.Position;
import org.academiadecodigo.rapunshells.game.obstacle.LanableObject;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bart extends LanableObject implements KeyboardHandler {
        private Picture fakeBart;
        private Position pos = new Position();
        private final int INITIAL_X = 300;
        private final int INITIAL_Y = 370;
        private boolean isJumping = false;
        private boolean isCrashed = false;
        private int bartCount = 0;
        private boolean movedLeft = false;
        private boolean movedRight = false;
        private boolean isDown = false;
        private int downCounter = 0;


        public int getBartCount() {
                return bartCount;
        }

        public int getLane() {
                return lane;
        }


        public void moveUp(int amount){
                fakeBart.translate(0,-amount);
        }
        public void moveDown(int amount){
                fakeBart.translate(0,amount);
        }
        public void setCrashed(boolean crashed){
                isCrashed = crashed;
        }
        public boolean isCrashed(){
                return isCrashed;
        }
        public void setJumping(boolean jumping) {
                isJumping = jumping;
        }

        public boolean isJumping() {
                return isJumping;
        }

        //BART PICTURES SET load
        public void setFakeBartToNormal(){
                fakeBart.load("resources/Bart1Tiny.png");
        }
        public void setFakeBartJump2(){
                fakeBart.load("resources/BartJump2(1).png");
        }
        public void setFakeBartJump1() {
                fakeBart.load("resources/BartJump1.png");
        }
        public void bartSequence(int countMultiple){
               if(!isJumping && !isDown) {
                       if (bartCount == 0) {
                               fakeBart.load("resources/Bart1Tiny.png");
                       }
                       if (bartCount == countMultiple) {
                               fakeBart.load("resources/Bart2Tiny.png");
                       }
                       if (bartCount == countMultiple * 2) {
                               fakeBart.load("resources/Bart3Tiny.png");
                       }
                       if (bartCount == countMultiple * 3) {
                               fakeBart.load("resources/Bart4Tiny.png");
                       }
                       if (bartCount == countMultiple * 4) {
                               fakeBart.load("resources/Bart5Tiny.png");
                       }
                       if (bartCount == countMultiple * 5) {
                               fakeBart.load("resources/Bart6Tiny.png");
                       }
                       if (bartCount == countMultiple * 6) {
                               bartCount = 0;
                       }
                       bartCount++;
               }

        }

        public Bart(){
                fakeBart = new Picture(INITIAL_X,INITIAL_Y, "resources/Bart1TinyTest.png");
                fakeBart.draw();
                keyboardInit();
                lane = 1;
                pos.setX(INITIAL_X);
                pos.setY(INITIAL_Y);


        }
        public Picture getFakeBart(){
                return fakeBart;
        }

        public Position getPos(){
                return pos;
        }

        public void keyboardInit(){
                Keyboard keyboard = new Keyboard(this);

                KeyboardEvent rightKey = new KeyboardEvent();
                rightKey.setKey(KeyboardEvent.KEY_RIGHT);
                rightKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(rightKey);

                KeyboardEvent leftKey = new KeyboardEvent();
                leftKey.setKey(KeyboardEvent.KEY_LEFT);
                leftKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(leftKey);

                KeyboardEvent upKey = new KeyboardEvent();
                upKey.setKey(KeyboardEvent.KEY_UP);
                upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(upKey);

                KeyboardEvent downKey = new KeyboardEvent();
                downKey.setKey(KeyboardEvent.KEY_DOWN);
                downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(downKey);



        }
        public void bartDown(){
                if(isDown){
                        fakeBart.load("resources/BartDown.png");
                        if(downCounter == 0){
                        fakeBart.translate(0,17);}
                        downCounter++;
                        if(downCounter == 20){
                                fakeBart.translate(0,-17);
                                isDown = false;
                                downCounter = 0;
                        }


                }
        }

        public int checkLimit(){
                if(getLane() == 4){
                        return KeyboardEvent.KEY_LEFT;
                }
                if(getLane() == 1){
                        return KeyboardEvent.KEY_RIGHT;
                }
                return 1;

        }
        public void movementLeft(){
                if(movedLeft) {
                        if (getLane() == 1) {
                                fakeBart.translate(0, -50);
                        }
                        if (getLane() == 2) {
                                fakeBart.translate(0, -80);
                        }
                        if (getLane() == 3) {
                                fakeBart.translate(0, -60);
                        }
                        lane++;
                        movedLeft = false;
                }

        }
        public void movementRight(){
                if(movedRight){
                        if(getLane() == 2) {
                                fakeBart.translate(0, 50);
                        }
                        if(getLane() == 3) {
                                fakeBart.translate(0, 80);
                        }
                        if(getLane()==4){
                                fakeBart.translate(0,60);
                        }
                        lane--;
                        movedRight = false;
                }
        }



        public void keyPressed(KeyboardEvent var1) {
               if(checkLimit() == var1.getKey()){
                       return;
               }
                switch (var1.getKey()){
                        case KeyboardEvent.KEY_RIGHT:
                                movedRight = true;
                                break;
                        case KeyboardEvent.KEY_LEFT:
                                movedLeft = true;
                                break;
                        case KeyboardEvent.KEY_UP:
                                isJumping = true;
                                break;
                        case KeyboardEvent.KEY_DOWN:
                                isDown = true;
                                break;
                }

        }

        public void keyReleased(KeyboardEvent var1){

        }

}
