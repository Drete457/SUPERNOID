package SUPERNOID.GameObjects;

import SUPERNOID.GameEngine;
import javafx.scene.shape.Circle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    //speed of the paddle
    private final int SPEED = 10;
    //the start position in X
    private final int positionX;
    //the start position in Y
    private final int positionY = 785;
    //to memorise the paddle
    private Picture picture;

    //start the paddle object
    public Ball(Paddle paddle) {
        positionX = paddle.getPositionX() + (paddle.getWidth()/2-8);
        picture = new Picture(positionX, positionY, "SUPERNOID/GameObjects/Images/general/ball_15x15.png");
        picture.draw();
    }

    //get the Width of the paddle
    public int getWidth() {
        return picture.getWidth();
    }

    //get the Hight of the paddle
    public int getHeight() {
        return picture.getHeight();
    }

    //print the new position of the paddle
    public void setPosition(int width) {
        picture.translate(width, 0);
    }

    //get the X of the paddle
    public int getPositionX() {
        return picture.getX();
    }


}
