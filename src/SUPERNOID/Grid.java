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
        Hearts.drawAll();
    }

    //tell the image of each heart
    private enum Hearts {

        //proprieties
        HEART1(new Picture(665, 665, "resources/Images/general/life_46x50_1.jpg")),
        HEART2(new Picture(710, 665, "resources/Images/general/life_46x50_2.jpg")),
        HEART3(new Picture(755, 665, "resources/Images/general/life_46x50_3.jpg")),
        HEART4(new Picture(800, 665, "resources/Images/general/life_46x50_4.jpg"));

        //memorise each heart
        private Picture pic;

        //constructed
        Hearts(Picture pic) {
            this.pic = pic;

        }

        //draw the Hearth's
        private static void drawAll() {
            HEART1.pic.draw();
            HEART2.pic.draw();
            HEART3.pic.draw();
            HEART4.pic.draw();
        }

        //delete the hearts every time the ball die
        public void livesLost(int livesLost) {

            switch (livesLost) {
                case 1:
                    Hearts.HEART4.pic.delete();
                    break;
                case 2:
                    Hearts.HEART3.pic.delete();
                    break;
                case 3:
                    Hearts.HEART2.pic.delete();
                    break;
                case 4:
                    Hearts.HEART1.pic.delete();
                    break;
            }
        }
    }
}
