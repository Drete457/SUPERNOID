package SUPERNOID;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 08/02/2020.
 */
public class Grid {

    public static final int PADDING = 10;

    private double height;
    private double width;
    private Rectangle rectangle;
    private Picture picture;

    public Grid(double width, double height) {
        this.width = width;
        this.height = height;

    }

    //desenhar a janela de jogo
    public void init(String url) {
        rectangle = new Rectangle(PADDING, PADDING, width, height);
        rectangle.draw();
        picture = new Picture(PADDING, PADDING, url);
        picture.draw();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    
}
