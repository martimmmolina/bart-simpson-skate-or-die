package org.academiadecodigo.rapunshells.game;

public  class Position {
        private int x;
        private int y;

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public void addX(int amount){
            x += amount;
        }

        public void subX(int amount){
            x -= amount;
        }

        public void addY(int amount){
            y += amount;
        }

        public void subY(int amount){
            y += amount;
        }

    public boolean equals(Position pos){
        if(pos.getX() == this.getX() && pos.getY() == this.getY()){
                return true;
            }
            return false;
        }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
