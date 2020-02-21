package SUPERNOID.Grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    //Padding of 10
    public static final int PADDING = 10;

    //memorise the background
    private Picture picture;

    //memorise the picture of the heart 1, 2 and 3
    private Picture heart1;
    private Picture heart2;
    private Picture heart3;

    //memorise the picture of the skull 1, 2 and 3
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

        //draw the grid
        picture.draw();

        //draw the hearts
        drawAllHearts();
    }

    //draw all the hearts in the screen
    public void drawAllHearts() {
        delete();
        heart1.draw();
        heart2.draw();
        heart3.draw();
    }

    //delete tall the hearts and skulls
    public void delete() {
        heart3.delete();
        heart2.delete();
        heart1.delete();
        skull1.delete();
        skull2.delete();
        skull3.delete();
    }

    //if the player loose one live, delete that heart and draw 1 skull
    public void draw2hearts() {
        delete();
        heart1.draw();
        heart2.draw();
        skull3.draw();
    }

    //if the player loose the second lives, delete 2 heart's and draw 2 skull's
    public void draw1heart() {
        delete();
        heart1.draw();
        skull2.draw();
        skull3.draw();
    }

    //if the player loose three lives, delete all hearts and draw 3 skull's
    public void drawAllSkulls() {
        delete();
        skull1.draw();
        skull2.draw();
        skull3.draw();
    }
}
