package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameEngine {

    //memorise the score
    private int score;

    //use to write the score in the scree
    private Text scoreText;
    private int lives = 4;

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setScore(int score) {
        this.score = score;
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
        if (ball.getX() == 1 && ball.getY() == 1 && ball.getPositionY() > paddle.getPositionY() - Grid.PADDING && ballInTheLimitXPaddle(ball, paddle)) {
            ball.setX(-ball.getX());
            ball.setY(-ball.getY());
        } else if (ball.getX() == -1 && ball.getY() == 1 && ball.getPositionY() > paddle.getPositionY() - Grid.PADDING && ballInTheLimitXPaddle(ball, paddle)) {
            ball.setX(-ball.getX());
            ball.setY(-ball.getY());
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
    private boolean ballCollisionBlocks(Ball ball, Block[] blocks) {
        boolean result = false;
        String direction;
        for (Block block : blocks) {
            if (!block.isDestroyed()) {
                result = (ball.getPositionX() < (block.getPositionX() + block.getWidth())
                        && (ball.getPositionX() + ball.getWidth()) > block.getPositionX()
                        && ball.getPositionY() < ( block.getPositionY() + block.getHeight())
                        && (ball.getPositionY() + ball.getHeight()) > block.getPositionY()
                );

                if (result) {
                    score += 10;
                    score();
                    block.setDestroyed();
                    direction = ball.getMovingDirection();
                    switch (direction) {
                        case "dirDownLeft":
                            if (ball.getPositionY() <= block.getPositionY()) {
                                ball.setY(-ball.getY());
                                break;
                            }
                            if (ball.getPositionX() >= block.getPositionX()) {
                                ball.setX(-ball.getX());
                                break;
                            }
                        case "dirDownRight":
                            if (ball.getPositionY() <= block.getPositionY()) {
                                ball.setY(-ball.getY());
                                break;
                            }
                            if (ball.getPositionX() <= block.getPositionX()) {
                                ball.setX(-ball.getX());
                                break;
                            }
                        case "dirUpRight":
                            if (ball.getPositionY() >= block.getPositionY()) {
                                ball.setY(-ball.getY());
                                break;
                            }
                            if (ball.getPositionX() <= block.getPositionX()) {
                                ball.setX(-ball.getX());
                                break;
                            }
                        case "dirUpLeft":
                            if (ball.getPositionY() >= block.getPositionY()) {
                                ball.setY(-ball.getY());
                                break;
                            }
                            if (ball.getPositionX() >= block.getPositionX()) {
                                ball.setX(-ball.getX());
                                break;
                            }
                    }
                }
            }
        }
        return result;
    }


    //verify if the ball can continue the direction or move to another one.
    private void nextBallDirection(Ball ball) {
        
        //if the y of the ball reach 820 or more, is delete
        if (ball.getPositionY() >= 820) { ball.setDead(); lives--; return;}

        //if the ball didn't hit the wall, continue in the same direction
        if (ballCollisionDetectWall(ball)) { ball.move(); }
        else if (ball.getPositionX() >= 550 && ball.getPositionY() < 900 && ball.getPositionY() > 55) {
            ball.setX(-ball.getX()); ball.move();}
        else if (ball.getPositionX() <= 55 && ball.getPositionY() > 55 && ball.getPositionY() < 900) {
            ball.setX(-ball.getX()); ball.move();}
        else if (ball.getPositionY() >= 55 && ball.getPositionX() < 550 && ball.getPositionX() > 55) {
            ball.setY(-ball.getY()); ball.move();}
    }

    //make the ball move
    public void moveBall(Ball ball, Paddle paddle, Block[] blocks) {
        if (ball.isAlive()) {
            ballCollisionBlocks(ball, blocks);
            paddleCollisionBall(ball, paddle);
            nextBallDirection(ball);
        }
    }

    //Draw initial score
    public Text scoreDraw() {
        scoreText = new Text(750, 485, "000");
        scoreText.setColor(Color.WHITE);
        scoreText.grow(50, 40);
        scoreText.draw();
        return scoreText;
    }

    //update score
    public void score() {
        scoreText.delete();
        scoreDraw().setText(score + "");
    }
}
