package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture picture;
    public static final int BLOCKWIDTH = 40;
    public static final int BLOCKHEIGHT = 15;

    private int blockEnergy = 10;
    private boolean destroyed = false;

    public Block(double xPos, double yPos) {
        BlockType randomBlock = BlockType.values() [(int) (Math.random() * BlockType.values().length)];
        picture = new Picture(xPos, yPos, randomBlock.getImage());
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

    private enum BlockType {
        BLUE("SUPERNOID/GameObjects/Images/color-blocks/blue_40x15.jpg"),
        BROWN("SUPERNOID/GameObjects/Images/color-blocks/brown_40x15.jpg"),
        GREEN("SUPERNOID/GameObjects/Images/color-blocks/green_40x15.jpg"),
        CYAN("SUPERNOID/GameObjects/Images/color-blocks/light_blue_40x15.jpg"),
        LIME("SUPERNOID/GameObjects/Images/color-blocks/light_green_40x15.jpg"),
        MAGENTA("SUPERNOID/GameObjects/Images/color-blocks/magenta_40x15.jpg"),
        ORANGE("SUPERNOID/GameObjects/Images/color-blocks/orange_40x15.jpg"),
        PINK("SUPERNOID/GameObjects/Images/color-blocks/pink_40x15.jpg"),
        RED("SUPERNOID/GameObjects/Images/color-blocks/red_40x15.jpg"),
        YELLOW("SUPERNOID/GameObjects/Images/color-blocks/yellow_40x15.jpg");

        private String image;

        BlockType(String image){
            this.image = image;
        }

        String getImage() {
            return image;
        }

    }

}
