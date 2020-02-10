package SUPERNOID.GameObjects;

import SUPERNOID.Grid;

public class ObjFactory {

    public static Ball getNewBall(Paddle paddle) {
        return new Ball(paddle.getX(), paddle.getY(),"ball.png");
    }

    public static Paddle getNewPaddle(Grid grid){
        return new Paddle(grid.getX() / 2, grid.getY() /2, "Paddle.png");
    }

    public static Block[] getNewBlocks(int numberOfBlocks){
        Block[] blocks = new Block[numberOfBlocks];
        for (int i = 0; i < numberOfBlocks; i++) {
            blocks[i] = new Block(i * Block.BLOCKHEIGHT, i * Block.BLOCKWIDTH, "block.png");
        }
        return blocks;
    }

}
