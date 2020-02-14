package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball{

    //speed of the ball
    private final int SPEED = 20;
    //the start position in X
    private final int positionX;
    //the start position in Y
    private final int positionY = 785;
    //to memorise the ball
    private Picture picture;
    //memorise if the ball is alive or not
    private boolean alive = true;
    //movement of the ball in axis X
    private double x;
    //movement of the ball in axis Y
    private double y;

    //start the ball object
    public Ball(Paddle paddle) {
        positionX = paddle.getPositionX() + (paddle.getWidth()/2-8);
        picture = new Picture(positionX, positionY, "resources/Images/general/ball_15x15.png");
        x = 2;
        y = -2;
        picture.draw();
    }

    //return if the ball is alive
    public boolean isAlive() { return alive; }

    //kill the ball
    public void setAlive() { picture.delete(); alive = false; }

    //get the Width of the ball
    public int getWidth() {
        return picture.getWidth();
    }

    //get the Hight of the ball
    public int getHeight() {
        return picture.getHeight();
    }

    //print the new position of the ball
    public void move() { picture.translate(x,y); }

    //get the X of the ball
    public int getPositionX() { return picture.getX(); }

    //get the Y of the ball
    public int getPositionY() { return picture.getY(); }

    //memorise the new axis x
    public void setX(double x) { this.x=x; }

    //memorise the new axis y
    public void setY(double y) { this.y=y; }

    //write the new value in x, to be ready by the canvas.translate
    public double getX() { return x; }

    //write the new value in y, to be ready by the canvas.translate
    public double getY() { return y; }

}
