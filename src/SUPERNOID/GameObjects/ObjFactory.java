package SUPERNOID.GameObjects;

import SUPERNOID.Game;

public class ObjFactory {

    public static void resetStartingIndex(){
        this.startingIndex = 0;
    }

    private static int startingIndex = 0;

    private static final int BLOCK_TOP_PADDING = 80;
    private static final int BLOCK_LEFT_PADDING = 90;

    //Create blocks for the game. The total number of blocks is numberOfColumns x numberOfRows
    public static void getNewBlocks(int numberOfColumns, int numberOfRows, int initialVerticalPos, int initialHorizontalPos, Game game) {
        //Initializes array with the total number of blocks
        Block[] blocks = new Block[numberOfColumns * numberOfRows];

        //index of the block object that will be created
        int index = startingIndex;

        //Create each block and save it in the corresponding index of the array
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {

            for (int colNumber = 0; colNumber < numberOfColumns; colNumber++) {
                game.blocks[index++] = new Block((colNumber * Block.BLOCKWIDTH) + BLOCK_LEFT_PADDING + initialHorizontalPos,
                        (rowNumber * Block.BLOCKHEIGHT) + BLOCK_TOP_PADDING + initialVerticalPos);

            }
            startingIndex = index;
        }
    }
}
