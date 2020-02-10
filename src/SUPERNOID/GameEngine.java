package SUPERNOID;

//import the object ball
import SUPERNOID.GameObjects.Ball;
//import the object Paddle and blocks
import SUPERNOID.GameObjects.Blocks;
import SUPERNOID.GameObjects.Paddle;

/**
 * Created by codecadet on 08/02/2020.
 */
public class GameEngine {

    //create the variable type Ball
    private Ball ball;
    //create the variable type Blocks
    private Blocks[] blocks;
    //create the variable type padle
    private Paddle paddle;

    //start the contructer
    public GameEngine(Ball ball, Blocks[] blocks, Paddle paddle) {
        this.ball = ball;
        this.blocks = blocks;
        this.paddle = paddle;
    }

    //run the method collisionDetect
    public void checkCollisions() {
        collisionDetect();
        paddlecollisionDetect();
    }

    //verify if there any type of collision
    private void collisionDetect() {
        for (Blocks blocks : blocks) {
            if (ball.checkX(blocks) && ball.checkY(blocks) || blocks.checkX(ball) && blocks.checkY(ball)) {
                if (ball.collied()) {
                    blocks.delete();
                    ball.setCurrentY(/*direction, need to see how to make that*/);
                    ball.setCurrentX(...........................................);
                    continue;
                }

                blocks.delete();
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
    }
}
