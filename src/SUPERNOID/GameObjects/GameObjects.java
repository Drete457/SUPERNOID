package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObjects {

    public GameObjects(double x, double y, String url) {
        Picture picture = new Picture (x, y, url);
        picture.draw();
    }
}
