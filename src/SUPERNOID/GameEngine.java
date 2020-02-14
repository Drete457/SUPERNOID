package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Paddle;

public class GameEngine {

    //verify if the paddle have reach the limit of the game area
    public static void paddleCollisionDetectWall(Paddle paddle, int SPEED) {
        if (paddle.getPositionX() < 378 && paddle.getPositionX() > 60) { paddle.setPosition(SPEED); }
        else if (paddle.getPositionX() <= 60) { paddle.setPosition(10); }
        else if (paddle.getPositionX() >= 378) { paddle.setPosition(-10); }

    }


    //verify if the ball have reach the limit of the game area
    private void ballCollisionDetectWall(Ball ball){
        if (ball.getPositionX() > 55 && ball.getPositionX() < 550
        && ball.getPositionY() > 55 && ball.getPositionY() < 900) {
        }
    }

    private void ballCollisionBlocs(Ball ball){}

    private void nextBallDirection(Ball ball){
        double x = ball.getPositionX();
        double y = ball.getPositionY();
        if (ball.getPositionX() < 0) {
            x = 1;}
        if (ball.getPositionX() > ball.getWidth() - 15) {
            x = -1; }
        if (ball.getPositionY() < 0) {
            y = 1; }
        if (ball.getPositionY() > ball.getHeight() - 15) {
            y = -1; }

         ball.setX(x);
         ball.setY(y);
         ball.move();
    }

    public void moveBall(Ball ball) {
       nextBallDirection(ball);
    }
}
