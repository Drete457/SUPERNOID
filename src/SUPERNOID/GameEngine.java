package SUPERNOID;

import SUPERNOID.GameObjects.Paddle;

public class GameEngine {

    //verify if the paddle have reach the limit of the game area
    public static Boolean paddleCollisionDetectWall(Paddle paddle) {
        if (paddle.getPositionX() < 380 && paddle.getPositionX() > 60) {
        return true;
        }
        return false;
    }
}
