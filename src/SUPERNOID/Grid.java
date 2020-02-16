package SUPERNOID;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    //Padding of 10
    public static final int PADDING = 10;

    //memorise the background
    private Picture picture;

    private Picture heart1;
    private Picture heart2;
    private Picture heart3;

    private Picture skull1;
    private Picture skull2;
    private Picture skull3;

    //initiate the constructor of the grid
    public Grid() {
        picture = new Picture(PADDING, PADDING, "resources/Images/general/field_900x900_c.jpg");
        heart1 = new Picture(665, 650, "resources/Images/general/heart_62x62.png");
        heart2 = new Picture(725, 650, "resources/Images/general/heart_62x62.png");
        heart3 = new Picture(788, 650, "resources/Images/general/heart_62x62.png");
        skull1 = new Picture(665, 650, "resources/Images/general/skull_62x62.png");
        skull2 = new Picture(725, 650, "resources/Images/general/skull_62x62.png");
        skull3 = new Picture(788, 650, "resources/Images/general/skull_62x62.png");
        picture.draw();
        drawAllHearts();
    }

    public void drawAllHearts() {
        delete();
        heart1.draw();
        heart2.draw();
        heart3.draw();
    }

    public void delete() {
        heart3.delete();
        heart2.delete();
        heart1.delete();
        skull1.delete();
        skull2.delete();
        skull3.delete();
    }

    public void draw2hearts() {
        delete();
        heart1.draw();
        heart2.draw();
        skull3.draw();
    }

    public void draw1heart() {
        delete();
        heart1.draw();
        skull2.draw();
        skull3.draw();
    }

    public void drawAllSkulls() {
        delete();
        skull1.draw();
        skull2.draw();
        skull3.draw();
    }


}
