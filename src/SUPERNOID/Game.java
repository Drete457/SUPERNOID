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

public class Game {

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
    private Keyboard keyboard;
    //create the object that will receive the input left
    private KeyboardEvent keyPressedLeft = new KeyboardEvent();

    //create the object that will receive the input right
    private KeyboardEvent keyPressedRight = new KeyboardEvent();

    //create the object that will receive the input space
    private KeyboardEvent keyPressedSpace = new KeyboardEvent();

    //Game Constructor
    public Game(int totalBlocks) {
        this.backGround = new Grid();
        this.paddle = new Paddle();
        this.engine = new GameEngine();
        this.ball = new Ball(paddle);
        keyboard = new Keyboard(paddle);
        blocks = new Block[totalBlocks];
    }

    //Draw the back ground
    public Grid backGround() { return this.backGround; }

    //Draw the initial screen
    public void initScreen() {
        Hearts.drawAll();

    }

    public void loadLevel1() {
        ObjFactory.getNewBlocks(11,5, 50,0, this); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(11,5, 150,0, this); // 11 x 5 = 55 blocks - 100 total
        ObjFactory.getNewBlocks(5,3, 250, 120, this); // 5 x 3 = 15 blocks - 125 total
        drawBlocks();
    }

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

        //run the code for the space key
        keyPressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyPressedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyPressedSpace);

        //cicle that verify the movement of the ball and the collision of the blocks, paddle and ball
        while (ball.isAlive()) {
            engine.moveBall(ball,paddle);
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
        HEART2(new Picture(710, 665, "resources/Images/general/life_46x50_3.jpg")),
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
}


