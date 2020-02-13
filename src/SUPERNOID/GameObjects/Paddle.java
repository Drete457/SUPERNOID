package SUPERNOID.GameObjects;

import SUPERNOID.GameEngine;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paddle implements KeyboardHandler{

    //speed of the paddle
    private final int SPEED = 5;
    //the start position in X
    private final int positionX = 220;
    //the start position in Y
    private final int positionY = 800;
    //to memorise the paddle
    private Picture picture;

    //start the paddle object
    public Paddle() {
        picture = new Picture(positionX, positionY, "SUPERNOID/GameObjects/Images/general/monitor_180x41.png");
        picture.draw();
    }

    //get the Width of the paddle
    public int getWidth() { return picture.getWidth(); }

    //get the Height of the paddle
    public int getHeight() { return picture.getHeight(); }

    //print the new position of the paddle
    public void setPosition(int width) { picture.translate(width,0);}

    //get the X of the paddle
    public int getPositionX(){ return picture.getX(); }

    //make the paddle move using the keyboard
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_LEFT:
                if (GameEngine.paddleCollisionDetectWall(this)) { setPosition(-SPEED); } else { setPosition(SPEED*2); }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (GameEngine.paddleCollisionDetectWall(this)) { setPosition(SPEED); } else { setPosition(-SPEED*2); }
                break;
        }
    }

    //disable method
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}
