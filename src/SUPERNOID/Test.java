package SUPERNOID;

import SUPERNOID.GameObjects.Block;
import SUPERNOID.GameObjects.ObjFactory;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {


    public static void main(String[] args) {
        Canvas canvas = Canvas.getInstance();
        Picture field = new Picture(10,10,"resources/Images/general/field_900x900.git");
        canvas.show(field);
        Block[] blocks = new Block[100];
        blocks = ObjFactory.getNewBlocks(11,5, 50,0);
        blocks = ObjFactory.getNewBlocks(11,5, 150,0);
        blocks = ObjFactory.getNewBlocks(5,3, 250, 120);

    }

}
