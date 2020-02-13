package SUPERNOID;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 08/02/2020.
 */
public class Grid {

    public static final int PADDING = 10;
    private Picture picture;


    public Grid() {
        picture = new Picture(PADDING, PADDING, "resources/Images/general/field_900x900.gif");
        picture.draw();

    }


}
