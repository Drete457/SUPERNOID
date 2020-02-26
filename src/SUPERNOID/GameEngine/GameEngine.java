package SUPERNOID.GameEngine;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;
import SUPERNOID.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameEngine {

    //memorise the score
    private int score;

    //use to write the score in the screen
    private Text scoreText;
    private int lives = 3;
    private boolean gameOver = false;

    //if someone won the game
    private boolean winner = false;

    //memorise the game over and the winner image
    private Picture gOver;
    private Picture winnerScreen;

    //return the picture of the game over
    public Picture getGOver() {
        return gOver;
    }

    //return if the player have win or not
    public boolean isWinner() {
        return winner;
    }

    //put the winner tru
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    //return the winner screen
    public Picture getWinnerScreen() {
        return winnerScreen;
    }

    //put how many lives the player still have
    public void setLives(int lives) {
        this.lives = lives;
    }

    //update the score
    public void setScore(int score) {
        this.score = score;
    }

    //return if is gameover
    public boolean isGameOver() {
        return gameOver;
    }

    //make the game over true
    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    //verify if the paddle has reached the limit of the game area
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
        if (ball.getPositionY() >= (paddle.getPositionY() - Grid.PADDING) && ballInTheLimitXPaddle(ball, paddle)) {
            ball.setY(-ball.getY());
        }
        if (ball.getPositionY() >= (paddle.getPositionY() - Grid.PADDING+0.8)){
            ball.setY(3);
            ball.move();
        }
    }

    //verify if the ball touched the Paddle in Axis X
    private boolean ballInTheLimitXPaddle(Ball ball, Paddle paddle) {
        return ball.getPositionX() >= (paddle.getPositionX() - Grid.PADDING) &&
                ball.getPositionX() <= (paddle.getPositionX() + paddle.getWidth() + Grid.PADDING-3);
    }

    //verify if the ball has reached the limit of the game area
    private boolean ballCollisionDetectWall(Ball ball) {
        return ball.getPositionX() > 55 && ball.getPositionX() < 550
                && ball.getPositionY() > 55;
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
                    block.hit();
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
    private void nextBallDirection(Ball ball, Grid grid, Paddle paddle) {

        //if the y of the ball reach 820 or more, is deleted
        if (ball.getPositionY() >= 820) { ball.setDead(); lives--; loseLives(grid, ball, paddle);return;}

        //if the ball didn't hit the wall, continue in the same direction
        if (ballCollisionDetectWall(ball)) { ball.move(); }
        else if (ball.getPositionX() >= 550 && ball.getPositionY() < 900 && ball.getPositionY() > 45) {
            ball.setX(-ball.getX()); ball.move();}
        else if (ball.getPositionX() <= 55 && ball.getPositionY() > 55 && ball.getPositionY() < 900) {
            ball.setX(-ball.getX()); ball.move();}
        else if (ball.getPositionY() >= 55 && ball.getPositionX() < 550 && ball.getPositionX() > 55) {
            ball.setY(-ball.getY()); ball.move();}
    }

    //make the ball move
    public void moveBall(Ball ball, Paddle paddle, Block[] blocks, Grid grid) {
        if (ball.isAlive()) {
            ballCollisionBlocks(ball, blocks);
            paddleCollisionBall(ball, paddle);
            nextBallDirection(ball, grid, paddle);
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

    //verify how many lives the player still have and make the correct action
    private void loseLives(Grid grid, Ball ball, Paddle paddle) {
        switch(lives) {
            case 2:
                grid.delete();
                grid.draw2hearts();
                resetBall(ball, paddle);
                break;
            case 1:
                grid.delete();
                grid.draw1heart();
                resetBall(ball, paddle);
                break;
            case 0:
                gameOver = true;
                gOver = new Picture(Grid.PADDING, Grid.PADDING, "resources/Images/general/game_over_900x900.jpg");
                gOver.draw();
                grid.drawAllSkulls();
                score();
                break;
        }
    }

    //draw winner screen
    public void win() {
        if(winner) {
            winnerScreen = new Picture(Grid.PADDING, Grid.PADDING, "resources/Images/general/winner_900x900.jpg");
            winnerScreen.draw();
            score();
        }
    }

    //reset the ball to the middle of the paddle
    public void resetBall(Ball ball, Paddle paddle) {

        //verify the position of the ball and move the ball back to the paddle
        double x = -ball.getPositionX()+paddle.getPositionX()+(paddle.getWidth()/2-Grid.PADDING);
        double y = -ball.getPositionY()+(paddle.getPositionY()-Grid.PADDING*1.5);

        // put the new values for the movement of the ball
        ball.setX(x); ball.setY(y);

        //force the ball to the new position
        ball.move();

        //give the ball the new velocity and direction
        ball.setX(0); ball.setY(0); ball.draw();

        //make the paddle impossible to move.
        Ball.stopMovement();

        //make the ball alive
        ball.setAlive();
    }
}
