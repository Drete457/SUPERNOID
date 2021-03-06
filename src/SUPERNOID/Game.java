package SUPERNOID;

import SUPERNOID.GameEngine.GameEngine;
import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.CreateLvl;
import SUPERNOID.GameObjects.Paddle;
import SUPERNOID.Grid.Grid;
import SUPERNOID.Sound.Sound;

public class Game {

    //Print the BackGround
    private Grid backGround;

    //create the class that give the sound
    private Sound soundClip = new Sound();

    //Array of Blocks for this game
    public Block[] blocks;

    //Print the paddle
    private Paddle paddle;

    //print the ball
    private Ball ball;

    //Create the game engine
    private GameEngine engine;

    //Create the Create level
    private CreateLvl lvl;

    //memorise the current lvl in the game
    private int currentLvl;

    //memorise if the game was restart or not
    public static boolean restart = false;

    //Game Constructor
    Game(int totalBlocks) {
        this.backGround = new Grid();
        blocks = new Block[totalBlocks];
        this.paddle = new Paddle();
        this.engine = new GameEngine();
        this.ball = new Ball(paddle);
        lvl = new CreateLvl();
    }

    //Draw the background
    private void backGround() {
        engine.scoreDraw();
    }

    //method to create the blocks
    public void drawBlocks() {

        //Draw blocks after creating them
        for (Block singleBlock : blocks) {
            singleBlock.getPicture();
            singleBlock.resetDestroyed();
        }
    }

    //Methods - Game Start
    public void start() throws Exception {

        //draw the ScoreBoard
        backGround();

        //start the background sound
        soundClip.startIntroMusic();

        //create the first game
        nextLvl();

        //cycle that verify the movement of the ball and the collision of the blocks, paddle and ball
        while (true) {

            //count how many block are dead
            int totalBlocksDead = 0;
            for (Block newborns : blocks) { if ( newborns.isDestroyed() ) { totalBlocksDead++; } }

            //start the next lvl
            if (totalBlocksDead == blocks.length) { nextLvl(); resetBallPaddle(); }

            //verify the collision between the ball, block and the grid
            engine.moveBall(ball, paddle, blocks, backGround);
            Thread.sleep(2);
        }
    }

    //restart the game method
    public void restart() throws Exception {

        //change the value of the restart for true
        restart = true;

        //set game over or winner false
        engine.setGameOver(false);
        engine.setWinner(false);

        //used to make the first lvl just respawn the blocks, and not create news one
        currentLvl = 0;

        //create the score and start the same
        engine.setScore(0);
        engine.score();

        //reset the counter live to 3 and draw them
        engine.setLives(3);
        backGround.drawAllHearts();

        //reset the position of the ball and the paddle
        resetBallPaddle();

        //draw the blocks again on new game
        lvl.loadLevel1(blocks,this);
    }

    //reset the ball to the middle of the paddle and the paddle to the middle of the screen
    private void resetBallPaddle() {
        //verify the position of the paddle and give the new position
        double xPaddle = -paddle.getPositionX()+Paddle.positionX;

        //put the paddle at the center of the screen
        paddle.setPosition(xPaddle);

        //verify the position of the ball and move the ball back to the paddle
        double xBall = -ball.getPositionX()+paddle.getPositionX()+(paddle.getWidth()/2-Grid.PADDING);
        double yBall = -ball.getPositionY()+(paddle.getPositionY()-Grid.PADDING*1.5);

        // put the new values for the movement of the ball
        ball.setX(xBall); ball.setY(yBall);

        //force the ball to the new position
        ball.move();

        //give the ball the new velocity and direction
        ball.setX(0); ball.setY(0); ball.draw();

        //make the paddle impossible to move.
        Ball.stopMovement();

        //make the ball alive
        ball.setAlive();
    }

    //if the player win, create the next lvl.
    private void nextLvl(){
        if ( currentLvl == 0 ) { lvl.loadLevel1(blocks,this); currentLvl = 1; }
        else if ( currentLvl == 1 ) { lvl.loadLevel2(blocks,this); currentLvl = 2; }
        else if ( currentLvl == 2 ) { lvl.loadLevel3(blocks, this); currentLvl = 3; }
        else if ( currentLvl == 3 ) { lvl.loadLevel4(blocks,this); currentLvl = 4; }
        else if ( currentLvl == 4 ) { lvl.loadLevel5(blocks, this); currentLvl = 5; }
        else if ( currentLvl == 5 ) { engine.setWinner(true); engine.win(); }
    }

    //return this object game
    public Game getGame(){
        return this;
    }

    //return the object paddle
    public Paddle getPaddle(){
        return paddle;
    }

    //return the object Game Engine
    public GameEngine getEngine(){
        return engine;
    }

    //return the object ball
    public Ball getBall(){
        return ball;
    }
}



