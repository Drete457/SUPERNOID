package SUPERNOID;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    //Padding of 10
    public static final int PADDING = 10;

    //memorise the background
    private Picture picture;

    //initiate the constructor of the grid
    public Grid() {
        picture = new Picture(PADDING, PADDING, "resources/Images/general/field_900x900_c.jpg");
        picture.draw();
    }
}
