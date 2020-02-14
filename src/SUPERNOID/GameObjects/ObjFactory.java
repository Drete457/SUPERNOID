package SUPERNOID.GameObjects;

import SUPERNOID.Grid;

public class ObjFactory {

    private static final int BLOCK_TOP_PADDING = 80;
    private static final int BLOCK_LEFT_PADDING = 90;


    public static Ball getNewBall(Paddle paddle) {
        //return new Ball(paddle.getX(), paddle.getY(), "ball.png");
        return null;
    }

    public static Paddle getNewPaddle(Grid grid) {
        //return new Paddle(grid.getX() / 2, grid.getY() / 2, "Paddle.png");
        return null;
    }

    public static Block[] getNewBlocks(int numberOfColumns, int numberOfRows, int initalVerticalPos, int initialHorizontalPos) {
        Block[] blocks = new Block[numberOfColumns * numberOfRows];

        int index = -1;

        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            for (int colNumber = 0; colNumber < numberOfColumns; colNumber++) {

                index++;

                System.out.println(index);
                blocks[index] = new Block((colNumber * Block.BLOCKWIDTH) + BLOCK_LEFT_PADDING + initialHorizontalPos,
                        (rowNumber * Block.BLOCKHEIGHT) + BLOCK_TOP_PADDING + initalVerticalPos);
            }
        }

        return blocks;
    }


}
