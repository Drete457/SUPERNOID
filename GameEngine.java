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

        //start the contructer
        public GameEngine(Ball ball, Blocks[] blocks) {
            this.ball = ball;
            this.blocks = blocks;

        }

        //run the method collisionDetect
        public void checkCollisions() {
            collisionDetect();
        }

        //verify if there any type of collision
        private void collisionDetect() {
            for (Blocks blocks : blocks) {
                if (ball.checkX(blocks) && ball.checkY(blocks) || blocks.checkX(ball) && blocks.checkY(ball)) {
                    if (ball.collied()) {
                        blocks.delete();
                        ball.setCurrentY(//directon, need to see how to make that);
                        continue;
                    }

                    blocks.delete();
                }
            }

        }
    }
}
