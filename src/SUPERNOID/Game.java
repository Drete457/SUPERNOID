package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;
import SUPERNOID.Sound.SoundClip;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    //Properties
    //Print the BackGround
    private final Grid backGround;

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

    /*create the object that will receive the keyboard and
    create the object of the keyboard */
    private Keyboard keyboard; //Keyboard for the paddle
    private Keyboard keyboardGame; //keyboard for the game menu

    //create the object that will receive the input left
    private KeyboardEvent keyPressedLeft = new KeyboardEvent();

    //create the object that will receive the input right
    private KeyboardEvent keyPressedRight = new KeyboardEvent();

    //create the object that will receive the input new game
    private KeyboardEvent keyPressedNew = new KeyboardEvent();

    //create the object that will receive the input exit
    private KeyboardEvent keyPressedExit = new KeyboardEvent();

    //create the object that will receive the input exit
    private KeyboardEvent keyPressedSpace = new KeyboardEvent();
    
    //memorise if the game was restarted or not
    private boolean reset =  false;

    //Game Constructor
    public Game(int totalBlocks) {
        this.backGround = new Grid();
        this.paddle = new Paddle();
        blocks = new Block[totalBlocks];
        this.engine = new GameEngine();
        this.ball = new Ball(paddle);
        keyboard = new Keyboard(paddle);
        keyboardGame = new Keyboard(this);
        lvl = new CreateLvl();
    }

    //Draw the background
    public Grid backGround() {
        engine.scoreDraw();
        return this.backGround;
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
    public void start() throws InterruptedException {

        SoundClip soundClip = new SoundClip();
        soundClip.playAudio();

        //create the first game
        nextLvl();

        //run the code for the left key
        keyPressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyPressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyPressedLeft);

        //run the code for the right key
        keyPressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyPressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyPressedRight);

        //run the code for the N key - New Game
        keyPressedNew.setKey(KeyboardEvent.KEY_N);
        keyPressedNew.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardGame.addEventListener(keyPressedNew);

        //run the code for the E key - Exit
        keyPressedExit.setKey(KeyboardEvent.KEY_E);
        keyPressedExit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardGame.addEventListener(keyPressedExit);

        //run the code for the space key - Start the ball
        keyPressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyPressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardGame.addEventListener(keyPressedSpace);

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
    public void restart() {

        //change the value of the restart for true
        restart = true;

        //set game over false
        engine.setGameOver(false);


        //used to make the first lvl just respawn the blocks, and not create new one
        reset = true;

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
        else if ( currentLvl == 5 ) {  }
    }

        //listen the keyboard so is possible to restart the game make the paddle move using the keyboard
        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {

                //restart the game
                case KeyboardEvent.KEY_N:
                    //catch the error of the null ball
                    try {
                        Thread.sleep(2);
                        if(engine.isGameOver()) {
                            engine.getGOver().delete();
                        }
                        Thread.sleep(2);
                        restart();
                    }catch (InterruptedException e) {
                        //restart tha ball again if the null ball occur
                        ball = new Ball(paddle);
                    }
                    break;

                //exit the game
                case KeyboardEvent.KEY_E:
                    System.exit(0);
                    break;

                //return to the first menu
                case KeyboardEvent.KEY_SPACE:

                    //verify if the ball is alive
                    if (ball.isAlive() && ball.getX() == 0 && ball.getY() == 0) {
                        ball.setY(-1);
                        ball.setX(1);
                        Ball.setMovement();
                    }
                    break;
            }
        }

        //disable method
        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }
    }



