package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture picture;
    public static final int BLOCKWIDTH = 64;
    public static final int BLOCKHEIGHT = 32;

    private int blockEnergy = 10;
    private boolean destroyed = false;
    
    public Block(double xPos, double yPos, String url) {
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

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    //Get Picture
    public Picture getPicture() {
        return picture;
    }

    //Set Picture
    public void setPicture(String url) {
        this.picture.load(url);
    }

    private enum BlockList {
        BLUE("SUPERNOID/GameObjects/Images/color-blocks/blue_80x30.jpg"),
        BROWN("SUPERNOID/GameObjects/Images/color-blocks/brown_80x30.jpg"),
        GREEN("SUPERNOID/GameObjects/Images/color-blocks/green_80x30.jpg"),
        CYAN("SUPERNOID/GameObjects/Images/color-blocks/light_blue_80x30.jpg"),
        LIME("SUPERNOID/GameObjects/Images/color-blocks/light_green_80x30.jpg"),
        MAGENTA("SUPERNOID/GameObjects/Images/color-blocks/magenta_80x30.jpg"),
        ORANGE("SUPERNOID/GameObjects/Images/color-blocks/orange_80x30.jpg"),
        PINK("SUPERNOID/GameObjects/Images/color-blocks/pink_80x30.jpg"),
        RED("SUPERNOID/GameObjects/Images/color-blocks/red_80x30.jpg"),
        YELLOW("SUPERNOID/GameObjects/Images/color-blocks/yellow_80x30.jpg");

        private String image;

        BlockList(String image){
            this.image = image;
        }

        String getImage() {
            return this.image;
        }
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

