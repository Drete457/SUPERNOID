package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;


public class Game extends KeyboardEvent {

    //Properties
    //Print the BackGround
    private final Grid backGround;

    //Print the paddle
    private Paddle paddle;

    //print the ball
    private Ball ball;

    //Create the game engine
    private GameEngine engine;

    /*create the object that will receive the keyboard and
    create the object of the keyboard */
    private Keyboard keyboard;
    //create the object that will receive the input left
    private KeyboardEvent keyPressedLeft = new KeyboardEvent();

    //create the object that will receive the input right
    private KeyboardEvent keyPressedRight = new KeyboardEvent();

    //create the object that will receive the input space
    private KeyboardEvent keyPressedSpace = new KeyboardEvent();

    //Game Constructor
    public Game() {
        this.backGround = new Grid();
        this.paddle = new Paddle();
        this.engine = new GameEngine();
        this.ball = new Ball(paddle);
        keyboard = new Keyboard(paddle);
    }

    //Draw the back ground
    public Grid backGround(){
        return this.backGround;
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

            //run the code for the space key
            keyPressedSpace.setKey(KeyboardEvent.KEY_SPACE);
            keyPressedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(keyPressedSpace);

            while (ball.isAlive()){
                engine.moveBall(ball);
                Thread.sleep(20);
           }
        }
    }

