package SUPERNOID.GameObjects;

import SUPERNOID.Grid;

public class ObjFactory {


    private static final int BLOCK_TOP_PADDING = 50;
    private static final int BLOCK_LEFT_PADDING = 50;


    public static Ball getNewBall(Paddle paddle) {
        return new Ball(paddle.getX(), paddle.getY(), "ball.png");
    }

    public static Paddle getNewPaddle(Grid grid) {
        return new Paddle(grid.getX() / 2, grid.getY() / 2, "Paddle.png");
    }

    public static Block[] getNewBlocks(int numberOfBlocks) {
        String blockUrl = new String("SUPERNOID/GameObjects/Images/color-blocks/blue_80x30.jpg");
        Block[] blocks = new Block[numberOfBlocks];

        for (int i = 1; i <= 3 ; i++) {
            for (int j = 1; j <= 6 ; j++) {
                blocks[i] = new Block((j * (Block.BLOCKWIDTH)) + BLOCK_LEFT_PADDING, (i * (Block.BLOCKHEIGHT)+ BLOCK_TOP_PADDING) , blockUrl);
            }
        }

        return blocks;
    }

}
