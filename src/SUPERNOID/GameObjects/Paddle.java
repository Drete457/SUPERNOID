package SUPERNOID.GameObjects;

import SUPERNOID.GameEngine;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paddle implements KeyboardHandler{

    private final int SPEED = 8;
    private final int positionX = 110;
    private final int positionY = 780;
    private final int growX = -100;
    private final int growY = -10;
    private Picture picture;
    private GameEngine engine = new GameEngine();

    public Paddle() {
        picture = new Picture(positionX, positionY, "SUPERNOID/GameObjects/Images/general/monitor.png");
        picture.grow(growX,growY);
        picture.draw();
    }

    public int getWidth() { return picture.getWidth(); }

    public int getHeight() { return picture.getHeight(); }

    public void setPosition(int width) { picture.translate(width,0);}

    public int getPositionX(){ return picture.getX(); }

    public void setPositionX(){ picture.delete(); }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
      switch (keyboardEvent.getKey()){
          case KeyboardEvent.KEY_LEFT:
              if (paddleVerificationWall()==true) {
                  setPosition(-SPEED);
              } else { setPosition(SPEED); }
          break;
          case KeyboardEvent.KEY_RIGHT:
              if (paddleVerificationWall()==true) {
                  setPosition(SPEED);
              } else { setPosition(-SPEED); }
          break;
      }
    }
    private boolean paddleVerificationWall(){ return engine.checkCollisionsPaddle(this); }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}

/*
   void move() {

        x += dx;

        if (x <= 0) {

            x = 0;
        }

        if (x >= Commons.WIDTH - imageWidth) {

            x = Commons.WIDTH - imageWidth;
        }
    }

    void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 1;
        }
    }

    void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }

    private void resetState() {

        x = Commons.INIT_PADDLE_X;
        y = Commons.INIT_PADDLE_Y;
    }
}
 */
