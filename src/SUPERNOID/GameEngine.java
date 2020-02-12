package SUPERNOID;

//import the object ball
import SUPERNOID.GameObjects.Ball;
//import the object Paddle and blocks
import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.Paddle;



public class GameEngine {

    //create the variable type Ball
    private Ball ball;
    //create the variable type Block
    private Block[] blocks;
    //create the variable type padle
    private Paddle paddle;

    //run the method collisionDetect
    public boolean checkCollisionsPaddle(Paddle paddle) {
        this.paddle = paddle;
        return paddleCollisionDetectWall();
    }

    private boolean paddleCollisionDetectWall() {
        if (paddle.getPositionX() < 360 && paddle.getPositionX() > 70) {
            return true;
        }
        return false;
    }

    //verify if there any type of collision
   /* private void collisionDetect() {
        for (Block block : blocks) {
            if (ball.checkX(block) && ball.checkY(block) || block.checkX(ball) && block.checkY(ball)) {
                if (ball.collied()) {
                    block.delete();
                    ball.setCurrentY(/*direction, need to see how to make that);
                 /*   ball.setCurrentX(...........................................);
                    continue;
                }

                block.delete();
            }
        }
    }
*/

}
