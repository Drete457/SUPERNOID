package SUPERNOID.GameObjects;

import SUPERNOID.GridPosition;

public class Ball extends GameObject {

    private static final int BALLSPEED = 10;
    private int hitDamage = 10;
    private GridPosition position;
    private boolean moving = false;

    public Ball(double xPos, double yPos, String image){
        super(xPos, yPos, image);
    }

    public void damageBlock(Block block) {
        block.hit(hitDamage);
    }

    public GridPosition getPosition() {
        return position;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
