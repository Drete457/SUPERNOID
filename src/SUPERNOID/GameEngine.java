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

    public void paddleCollisionBall(Ball ball, Paddle paddle){
        if (ball.getPositionY() >= paddle.getPositionY()-Grid.PADDING && ballInTheLimitXPaddle(ball,paddle)) {
            ball.setY(-ball.getY()); ball.move();}
    }

    //verify if the ball touch the Paddle in Axis X
    private boolean ballInTheLimitXPaddle(Ball ball, Paddle paddle){
        if (ball.getPositionX() >= paddle.getPositionX()-Grid.PADDING &&
           ball.getPositionX() <= paddle.getPositionX()+paddle.getWidth())
        { return true; }
        return false;
    }

    //verify if the ball have reach the limit of the game area
    private boolean ballCollisionDetectWall(Ball ball){
        if (ball.getPositionX() > 55 && ball.getPositionX() < 550
        && ball.getPositionY() > 55 && ball.getPositionY() < 900) { return true; }
        return false;
    }

    //verify the collision between the ball and all the blocks
    private boolean ballCollisionBlocks(Ball ball){ return false; }

    //verify if the ball can continue the direction or move to another one.
    private void nextBallDirection(Ball ball){

        //if the ball didn't hit the wall, continue in the same direction
        if (ballCollisionDetectWall(ball)){ ball.move();}
        else if ( ball.getPositionX() >= 550 && ball.getPositionY() < 900 && ball.getPositionY() > 55)
        { ball.setX(-ball.getX()); ball.move(); }
        else if ( ball.getPositionX() <= 55 && ball.getPositionY() > 55 && ball.getPositionY() < 900 )
        { ball.setX(-ball.getX()); ball.move(); }
        else if ( ball.getPositionY() >= 55 && ball.getPositionX() < 550 && ball.getPositionX() > 55 )
        { ball.setY(-ball.getY()); ball.move(); }

        //if the y of the ball reach 850 or more, is delete
        if ( ball.getPositionY() >= 850 )
        { ball.setAlive(); }
    }

    //make the ball move
    public void moveBall(Ball ball, Paddle paddle) {
        paddleCollisionBall(ball, paddle);
        nextBallDirection(ball);
    }
}
