package SUPERNOID;

import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.ObjFactory;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Test {

    public static void main(String[] args) {
        Canvas canvas = Canvas.getInstance();
        Block[] blocks = new Block[10];
        blocks = ObjFactory.getNewBlocks(10);
        for (Block block: blocks){

        }
    }

}
