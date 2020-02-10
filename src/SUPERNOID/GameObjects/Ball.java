package SUPERNOID.GameObjects;

import SUPERNOID.GridPosition;

public class Ball extends GameObjects {

    private static final int BALLSPEED = 10;
    private int hitDamage = 10;
    private GridPosition position;

    public Ball(double xPos, double yPos, String image){
        super(xPos, yPos, image);
    }

}
