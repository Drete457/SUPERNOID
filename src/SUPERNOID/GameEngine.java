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

 /*   //run the method collisionDetect
    public void checkCollisions() {
        collisionDetect();
        paddlecollisionDetect();
    }

    //verify if there any type of collision
    private void collisionDetect() {
        for (Block block : blocks) {
            if (ball.checkX(block) && ball.checkY(block) || block.checkX(ball) && block.checkY(ball)) {
                if (ball.collied()) {
                    block.delete();
                    ball.setCurrentY(*//*direction, need to see how to make that*//*);
                    ball.setCurrentX(...........................................);
                    continue;
                }

                block.delete();
            }
        }
    }

    private void paddlecollisionDetect() {
        if (paddle.checkX(ball) && paddle.checkY(ball) || ball.checkX(paddle) && ball.checkY(paddle)) {
            if (ball.collied) {
                ball.setCurrentY(..................................................);
                ball.setCurrentX(..................................................);
            }

        }
    }*/
}
