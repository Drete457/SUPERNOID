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

/*
 private void initBall() {

        xdir = 1;
        ydir = -1;

        loadImage.....;
        getImageDimensions......;
        resetState........;
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("ball.png");
        image = ii.getImage();
    }

    void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {

            setXDir(1);
        }

        if (x == Commons.WIDTH - imageWidth) {

            System.out.println(imageWidth);
            setXDir(-1);
        }

        if (y == 0) {

            setYDir(1);
        }
    }

    private void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(int x) {

        xdir = x;
    }

    void setYDir(int y) {

        ydir = y;
    }

    int getYDir() {

        return ydir;
    }
}
 */
