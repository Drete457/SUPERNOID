package SUPERNOID.GameObjects;

import SUPERNOID.GridPosition;

public class Paddle extends GameObjects{

    private static final int PADDLESPEED = 10;
    private GridPosition position;

    public Paddle(double xPos, double yPos, String image){
        super(xPos, yPos, image);
    }

}
