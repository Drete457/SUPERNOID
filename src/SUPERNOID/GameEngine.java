package SUPERNOID;

//import the object ball
import SUPERNOID.GameObjects.Ball;
//import the object Paddle and blocks
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;

/**
 * Created by codecadet on 08/02/2020.
 */
public class GameEngine {

    //create the variable type Ball
    private Ball ball;
    //create the variable type Block
    private Block[] blocks;
    //create the variable type padle
    private Paddle paddle;

    //start the contructer
    public GameEngine(Ball ball, Block[] blocks, Paddle paddle) {
        this.ball = ball;
        this.blocks = blocks;
        this.paddle = paddle;
    }


}
