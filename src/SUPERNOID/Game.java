package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.ObjFactory;
import SUPERNOID.GameObjects.Paddle;
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

    /*create the object that will receive the keyboard and
    create the object of the keyboard */
    private Keyboard keyboard; //Keyboard for the paddle
    private Keyboard keyboardGame; //keyboard for the game menu

    //create the object that will receive the input left
    private KeyboardEvent keyPressedLeft = new KeyboardEvent();

    //create the object that will receive the input right
    private KeyboardEvent keyPressedRight = new KeyboardEvent();

    //create the object that will receive the input space
    private KeyboardEvent keyPressedNew = new KeyboardEvent();

    //create the object that will receive the input space
    private KeyboardEvent keyPressedExit = new KeyboardEvent();

    //Game Constructor
    public Game(int totalBlocks) {
        this.backGround = new Grid();
        this.paddle = new Paddle();
        this.engine = new GameEngine();
        this.ball = new Ball(paddle);
        keyboard = new Keyboard(paddle);
        keyboardGame = new Keyboard(this);
        blocks = new Block[totalBlocks];
    }

    //Draw the back ground
    public Grid backGround() { return this.backGround; }

    public void initLogos() { }

    //draw the first lvl
    public void loadLevel1() {
        ObjFactory.getNewBlocks(11,5, 50,0, this); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(11,5, 150,0, this); // 11 x 5 = 55 blocks - 100 total
        ObjFactory.getNewBlocks(5,3, 250, 120, this); // 5 x 3 = 15 blocks - 125 total
        drawBlocks();
    }

    //draw the second lvl
    public void loadLevel2(){
        ObjFactory.getNewBlocks(11,5, 50,0, this); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(5,3, 250, 120, this); // 5 x 3 = 15 blocks - 70 total
        ObjFactory.getNewBlocks(11,5, 350,0, this); // 11 x 5 = 55 blocks - 125 total
        drawBlocks();
    }

    public void drawBlocks(){
        //Draw blocks after creating them
        for (Block singleBlock : blocks) {
            singleBlock.getPicture().draw();
        }
    }

    //Methods - Game Start
    public void start() throws InterruptedException {

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

        //cycle that verify the movement of the ball and the collision of the blocks, paddle and ball
        while (ball.isAlive()) {
            engine.moveBall(ball,paddle);
            Thread.sleep(2);
        }
    }

    //restart the game method
    public void restart() {
        ball.delete();
        this.ball = new Ball(paddle);
        blocks = new Block[150];
    }

    //listen the keyboard so is possible to restart the game make the paddle move using the keyboard
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            //restart the game
            case KeyboardEvent.KEY_N:
                restart();
                break;

            //exit the game
            case KeyboardEvent.KEY_E:
                System.exit(0);
                break;
        }
    }

    //disable method
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}


