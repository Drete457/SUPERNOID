package SUPERNOID.GameObjects;

import SUPERNOID.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture picture;
    public static final int BLOCKWIDTH = 64;
    public static final int BLOCKHEIGHT = 32;

    private int blockEnergy;
    private boolean destroyed = false;
    private GridPosition position;

    
    public Block(double xPos, double yPos, String url) {
        setPicture(url);
        picture = new Picture(xPos, yPos, url);
        picture.draw();
    }

    public int getBlockEnergy() {
        return blockEnergy;
    }

    public void setBlockEnergy(int blockEnergy) {
        this.blockEnergy = blockEnergy;
    }

    public void hit(int damage){
        blockEnergy -= damage;
        if (blockEnergy <= 0) {
            destroyed = true;
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setPosition(GridPosition position) {
        this.position = position;
    }

    //Get Picture
    public Picture getPicture() {
        return picture;
    }

    //Set Picture
    public void setPicture(String url) {
        this.picture.load(url);
    }

}

/* private void initBrick(int x, int y) {

        this.x = x;
        this.y = y;

        destroyed = false;

        loadImage();
        getImageDimensions();
    }

    private void loadImage() {

        Image Icon ii = new ImageIcon("src/resources/brick.png");
        image = ii.getImage();
    }

    boolean isDestroyed() {

        return destroyed;
    }

    void setDestroyed(boolean val) {

        destroyed = val;
    }
}*/

