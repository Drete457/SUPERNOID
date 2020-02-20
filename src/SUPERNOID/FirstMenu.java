package SUPERNOID;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FirstMenu {

    Picture firstMenu = new Picture(Grid.PADDING, Grid.PADDING, "resources/Images/general/start_screen_900x900.jpg");

    public void draw(){
        firstMenu.draw();
    }

    public  void delete(){
        firstMenu.delete();
    }
}
