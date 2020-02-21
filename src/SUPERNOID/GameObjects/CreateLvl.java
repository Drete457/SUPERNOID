package SUPERNOID.GameObjects;

import SUPERNOID.Game;

public class CreateLvl {

    //draw the first lvl
    public void loadLevel1(Block [] blocks, Game game) {

        //verify if the lvl is new or restart
        if (game.restart) {
        for (Block newborns : blocks) { newborns.deletePictureBlock(); newborns = null; game.restart = false; } }
        else { for (Block newborns : blocks) { newborns = null; } }

        //Creates each block in its respective position
        ObjFactory.startingIndex = 0;
        ObjFactory.getNewBlocks(11, 5, 50, 0, game); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(11, 5, 150, 0, game); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(5, 3, 250, 120, game); // 5 x 3 = 15 blocks

        //draw the blocks
        game.drawBlocks();
    }

    //draw the second lvl
    public void loadLevel2(Block [] blocks, Game game) {

      //reset all position on the array
      for (Block newborns : blocks) { newborns = null; }

        //Creates each block in its respective position
        ObjFactory.startingIndex = 0;
        ObjFactory.getNewBlocks(11, 5, 50, 0, game); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(5, 1, 150, 120, game); // 5 x 1 = 05 blocks
        ObjFactory.getNewBlocks(5, 2, 250, 120, game); // 5 x 2 = 10 blocks
        ObjFactory.getNewBlocks(11, 5, 350, 0, game); // 11 x 5 = 55 blocks

        //draw the blocks
        game.drawBlocks();
    }

    //draw the third lvl
    public void loadLevel3(Block [] blocks, Game game) {

        //reset all position on the array
        for (Block newborns : blocks) { newborns = null; }

        //Creates each block in its respective position
        ObjFactory.startingIndex = 0;
        ObjFactory.getNewBlocks(11, 5, 50, 0, game); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(5, 3, 150, 120, game); // 5 x 3 = 15 blocks
        ObjFactory.getNewBlocks(11, 3, 250, 0, game); // 11 x 3 = 33 blocks
        ObjFactory.getNewBlocks(11, 2, 350, 0, game); // 11 x 2 = 22 blocks

        //draw the blocks
        game.drawBlocks();
    }

    //draw the four lvl
    public void loadLevel4(Block [] blocks, Game game) {

        //reset all position on the array
        for (Block newborns : blocks) { newborns = null; }

        //Creates each block in its respective position
        ObjFactory.startingIndex = 0;
        ObjFactory.getNewBlocks(11, 3, 50, 0, game); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(5, 3, 150, 120, game); // 5 x 3 = 15 blocks
        ObjFactory.getNewBlocks(11, 2, 250, 0, game); // 11 x 2 = 22 blocks
        ObjFactory.getNewBlocks(11, 3, 350, 0, game); // 11 x 3 = 33 blocks
        ObjFactory.getNewBlocks(11, 2, 450, 0, game); // 11 x 2 = 22 blocks

        //draw the blocks
        game.drawBlocks();
    }

    //draw the fiver lvl
    public void loadLevel5(Block [] blocks, Game game) {

        //reset all position on the array
        for (Block newborns : blocks) { newborns = null; }

        //Creates each block in its respective position
        ObjFactory.startingIndex = 0;
        ObjFactory.getNewBlocks(11, 5, 50, 0, game); // 11 x 5 = 55 blocks
        ObjFactory.getNewBlocks(11, 3, 150, 0, game); // 11 x 3 = 33 blocks
        ObjFactory.getNewBlocks(11, 2, 250, 0, game); // 11 x 2 = 22 blocks
        ObjFactory.getNewBlocks(5, 3, 350, 120, game); // 5 x 3 = 15 blocks

        //draw the blocks
        game.drawBlocks();
    }
}
