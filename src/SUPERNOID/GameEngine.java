package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;

public class GameEngine {

    //Reference to Blocks[} array need to check collision with blocks
    private Block[] blocks;

    //Constructor
    public GameEngine(Block[] blocks) {
        this.blocks = blocks;
    }

    //verify if the paddle have reach the limit of the game area
    public static void paddleCollisionDetectWall(Paddle paddle, int SPEED) {
        if (paddle.getPositionX() < 378 && paddle.getPositionX() > 60) {
            paddle.setPosition(SPEED);
        } else if (paddle.getPositionX() <= 60) {
            paddle.setPosition(10);
        } else if (paddle.getPositionX() >= 378) {
            paddle.setPosition(-10);
        }
    }

    //verify the collision between the ball and the paddle
    public void paddleCollisionBall(Ball ball, Paddle paddle) {
        if (ball.getPositionY() > paddle.getPositionY() - Grid.PADDING && ballInTheLimitXPaddle(ball, paddle)) {
            ball.setY(-ball.getY());
            ball.move();
        }
    }

    //verify if the ball touch the Paddle in Axis X
    private boolean ballInTheLimitXPaddle(Ball ball, Paddle paddle) {
        return ball.getPositionX() >= paddle.getPositionX() - Grid.PADDING &&
                ball.getPositionX() <= paddle.getPositionX() + paddle.getWidth();
    }

    //verify if the ball have reach the limit of the game area
    private boolean ballCollisionDetectWall(Ball ball) {
        return ball.getPositionX() > 55 && ball.getPositionX() < 550
                && ball.getPositionY() > 55 && ball.getPositionY() < 900;
    }

    //verify the collision between the ball and all the blocks
    private boolean ballCollisionBlocks(Ball ball) {
        // (RectA.X1 < RectB.X2 && RectA.X2 > RectB.X1 &&
        //        RectA.Y1 < RectB.Y2 && RectA.Y2 > RectB.Y1)
        boolean result = false;
        for (Block block : blocks) {
            if (!block.isDestroyed()) {
                result = (block.getPositionX() < (ball.getPositionX() + ball.getWidth()) &&
                        (block.getPositionX() + block.getWidth()) > ball.getPositionX() &&
                        block.getPositionY() < (ball.getPositionY() + ball.getHeight()) &&
                        (block.getPositionY() + block.getHeight()) > ball.getPositionY());
                if (result) {
                    block.setDestroyed();
                }
            }

/*            System.out.println(block.getPositionX() < ball.getPositionX() + ball.getWidth());
            System.out.println(block.getPositionX() + block.getWidth() > ball.getPositionX());
            System.out.println(block.getPositionY() < ball.getPositionY() + ball.getHeight());
            System.out.println(block.getPositionY() + block.getHeight() > ball.getPositionY());*/
        }
       // System.out.println(" ** " + !result);
        return !result;
    }

    //verify if the ball can continue the direction or move to another one.
    private void nextBallDirection(Ball ball) {

        //if the y of the ball reach 900 or more, is delete
        if (ball.getPositionY() >= 900) {
            ball.setDead();
            return;
        }

        //if the ball didn't hit the wall, continue in the same direction
        if (ballCollisionDetectWall(ball)) {
            ball.move();
        } else if (ball.getPositionX() >= 550 && ball.getPositionY() < 900 && ball.getPositionY() > 55) {
            ball.setX(-ball.getX());
            ball.move();
        } else if (ball.getPositionX() <= 55 && ball.getPositionY() > 55 && ball.getPositionY() < 900) {
            ball.setX(-ball.getX());
            ball.move();
        } else if (ball.getPositionY() >= 55 && ball.getPositionX() < 550 && ball.getPositionX() > 55) {
            ball.setY(-ball.getY());
            ball.move();
        }

    }

    //make the ball move
    public void moveBall(Ball ball, Paddle paddle) {
        if(ball.isAlive()) {
            ballCollisionBlocks(ball);
            paddleCollisionBall(ball, paddle);
            nextBallDirection(ball);
        }
    }
}
