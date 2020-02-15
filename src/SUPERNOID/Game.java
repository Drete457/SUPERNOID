package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.ObjFactory;
import SUPERNOID.GameObjects.Paddle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
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

    //create the object that will receive the input new game
    private KeyboardEvent keyPressedNew = new KeyboardEvent();

    //create the object that will receive the input exit
    private KeyboardEvent keyPressedExit = new KeyboardEvent();

    //create the object that will receive the input exit
    private KeyboardEvent keyPressedSpace = new KeyboardEvent();

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
    public Grid backGround() {
        Hearts.drawAll();
        return this.backGround;
    }

    //Draw the initial screen
    public void initScreen() {
        Picture screen = new Picture(Grid.PADDING, Grid.PADDING, "resources/Images/general/startScreen_900x900_v1.jpg");
        screen.draw();
    }


    //draw the first lvl
    public void loadLevel1() {
        ObjFactory.startingIndex = 0;

        ObjFactory.getNewBlocks(11, 5, 50, 0, this); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(11, 5, 150, 0, this); // 11 x 5 = 55 blocks - 100 total
        ObjFactory.getNewBlocks(5, 3, 250, 120, this); // 5 x 3 = 15 blocks - 125 total
        drawBlocks();
    }

    //draw the second lvl
    public void loadLevel2() {
        ObjFactory.startingIndex = 0;
        ObjFactory.getNewBlocks(11, 5, 50, 0, this); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(5, 3, 250, 120, this); // 5 x 3 = 15 blocks - 70 total
        ObjFactory.getNewBlocks(11, 5, 350, 0, this); // 11 x 5 = 55 blocks - 125 total
        drawBlocks();
    }

    public void drawBlocks() {
        //Draw blocks after creating them
        for (Block singleBlock : blocks) {
            singleBlock.getPicture().draw();
            singleBlock.resetDestroyed();
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

        //run the code for the space key - First Menu
        keyPressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyPressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardGame.addEventListener(keyPressedExit);

        //cycle that verify the movement of the ball and the collision of the blocks, paddle and ball
        while (ball.isAlive()) {
            engine.moveBall(ball, paddle);
            Thread.sleep(2);
        }
    }

    //Draw initial score
    public Text scoreDraw() {
        Text score = new Text(750, 485, "000");
        score.setColor(Color.WHITE);
        score.grow(50, 40);
        score.draw();
        return score;
    }

    //update score
    public void score(String points) {
        //scoreDraw().delete();
        scoreDraw().setText(points);
    }


    public void livesLost(int livesLost) {

        switch (livesLost) {
            case 1:
                Hearts.HEART4.pic.delete();
                break;
            case 2:
                Hearts.HEART3.pic.delete();
                break;
            case 3:
                Hearts.HEART2.pic.delete();
                break;
            case 4:
                Hearts.HEART1.pic.delete();
                break;
        }
    }

    private enum Hearts {

        HEART1(new Picture(665, 665, "resources/Images/general/life_46x50_1.jpg")),
        HEART2(new Picture(710, 665, "resources/Images/general/life_46x50_2.jpg")),
        HEART3(new Picture(755, 665, "resources/Images/general/life_46x50_3.jpg")),
        HEART4(new Picture(800, 665, "resources/Images/general/life_46x50_4.jpg"));

        private Picture pic;

        Hearts(Picture pic) {
            this.pic = pic;

        }

        private static void drawAll() {
            HEART1.pic.draw();
            HEART2.pic.draw();
            HEART3.pic.draw();
            HEART4.pic.draw();
        }
    }

        //restart the game method
        public void restart() {
        double x = -ball.getPositionX()+paddle.getPositionX()+(paddle.getWidth()/2-Grid.PADDING);
        double y = -ball.getPositionY()+(paddle.getPositionY()-Grid.PADDING*1.5);

        // put the new values for the movement of the ball
        ball.setX(x); ball.setY(y);

        //force the ball to the new position
        ball.move();

        //give the ball the new velocity and direction
        ball.setX(1); ball.setY(-1);
        ball.draw();
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

                //return to the first menu
                case KeyboardEvent.KEY_SPACE:
                    //put code here
                    break;
            }
        }

        //disable method
        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }

    }



