package SUPERNOID;

import SUPERNOID.GameObjects.Ball;
import SUPERNOID.GameObjects.Blocks;
import SUPERNOID.GameObjects.GameObjects;
import SUPERNOID.GameObjects.Paddle;

/**
 * Created by codecadet on 08/02/2020.
 */
public class Game {

    //Properties
    private Ball ball;
    private Paddle paddle;
    private Blocks blocks;


    //Game Constructor
    public Game(Ball ball, Paddle paddle, Blocks blocks) {
        this.ball = ball;
        this.paddle = paddle;
        this.blocks = blocks;



    }


    //Methods - Game Start
    public void start() {

    }



}
