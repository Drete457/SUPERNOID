package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Paddle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager implements KeyboardHandler {

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

    //Memorise the paddle reference
    private Paddle paddle;

    //memorise the game
    private Game game;

    private Ball ball;

    private GameEngine engine;

    private FirstMenu firstMenu;

    private boolean first = true;

    KeyboardManager(Game game, Paddle paddle, Ball ball, GameEngine engine, FirstMenu firstMenu) {
        this.paddle = paddle;
        this.game = game;
        this.ball = ball;
        this.engine = engine;
        this.firstMenu = firstMenu;
        keyboardGame = new Keyboard(this);

        //run the code for the left key
        keyPressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyPressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardGame.addEventListener(keyPressedLeft);

        //run the code for the right key
        keyPressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyPressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardGame.addEventListener(keyPressedRight);

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
    }

    //listen the keyboard so is possible to restart the game make the paddle move using the keyboard
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            //Run the paddle to the left
            case KeyboardEvent.KEY_LEFT:

                //verify if the ball is already moving
                if ( Ball.getMovement() ) { GameEngine.paddleCollisionDetectWall(paddle, -paddle.getSPEED()); }
                break;

            //run the paddle top the right
            case KeyboardEvent.KEY_RIGHT:
                //verify if the ball is already moving
                if ( Ball.getMovement() ) { GameEngine.paddleCollisionDetectWall(paddle, paddle.getSPEED()); }
                break;

            //new game and restart the game
            case KeyboardEvent.KEY_N:
                //catch the error of the null ball
                try {
                        if (engine.isGameOver()) {
                            engine.getGOver().delete();
                        }
                        if (engine.isWinner()) {
                            engine.getWinnerScreen().delete();
                        }
                        game.restart();
                }catch (InterruptedException e) {
                    //restart tha ball again if the null ball occur
                    ball = new Ball(paddle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //exit the game
            case KeyboardEvent.KEY_E:
                System.exit(0);
                break;

            //trows the ball
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
