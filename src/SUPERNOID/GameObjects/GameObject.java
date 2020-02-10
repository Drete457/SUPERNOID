package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private double x;
    private double y;

    public GameObject(double x, double y, String url) {
        this.x = x;
        this.y = y;
        Picture picture = new Picture (x, y, url);
        picture.draw();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


}
