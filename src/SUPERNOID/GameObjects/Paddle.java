package SUPERNOID.GameObjects;

import SUPERNOID.GridPosition;

public class Paddle extends GameObject {

    private static final int PADDLESPEED = 10;
    private GridPosition position;
    private int width;
    private int height;

    public Paddle(double xPos, double yPos, String image){
        super(xPos, yPos, image);
    }

    public GridPosition getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPosition(GridPosition position) {
        this.position = position;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
