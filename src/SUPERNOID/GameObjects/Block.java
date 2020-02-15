package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture picture;
    public static final int BLOCKWIDTH = 40;
    public static final int BLOCKHEIGHT = 15;

    //Returns the energy of the block. After a block is hit, this value decreases, if this value is zero, block is destroyed
    private int blockEnergy = 1;

    //if true, block is destroyed, it must be deleted
    private boolean destroyed = false;

    //Constructor
    public Block(double xPos, double yPos) {
        BlockType randomBlock = BlockType.values()[(int) (Math.random() * BlockType.values().length)];
        picture = new Picture(xPos, yPos, randomBlock.getImage());
    }

    //return the energy that block have
    public int getBlockEnergy() {
        return blockEnergy;
    }

    //Block Energy Setter
    public void setBlockEnergy(int blockEnergy) {
        this.blockEnergy = blockEnergy;
    }

    //Method to call when the ball hits the block
    public void hit(int damage) {
        //decrease energy and if its <= 0, set destroyed to true
        blockEnergy -= damage;
        if (blockEnergy <= 0) {
            destroyed = true;
            // if block was destroyed, delete its picture from canvas
            picture.delete();
        }
    }


    //get the Width of the block
    public int getWidth() {
        return picture.getWidth();
    }

    //get the Height of the block
    public int getHeight() {
        return picture.getHeight();
    }

    //get the X position of the block
    public int getPositionX() {
        return picture.getX();
    }

    //get the Y position of the block
    public int getPositionY() {
        return picture.getY();
    }


    //getter for destroyed
    public boolean isDestroyed() {
        return destroyed;
    }

    public void resetDestroyed() {
        this.destroyed = false;
    }

    //destroyed setter, deletes image when block is destroyed
    public void setDestroyed() {
        this.destroyed = true;
        // if block was destroyed, delete its picture from canvas
        picture.delete();
    }

    //Get Picture
    public Picture getPicture() {
        return picture;
    }

    //Set Picture
    public void setPicture(String url) {
        this.picture.load(url);
    }

    //Returns a random block image
    private enum BlockType {
        BLUE("resources/Images/color-blocks/blue_40x15.jpg"),
        BROWN("resources/Images/color-blocks/brown_40x15.jpg"),
        GREEN("resources/Images/color-blocks/green_40x15.jpg"),
        CYAN("resources/Images/color-blocks/light_blue_40x15.jpg"),
        LIME("resources/Images/color-blocks/light_green_40x15.jpg"),
        MAGENTA("resources/Images/color-blocks/magenta_40x15.jpg"),
        ORANGE("resources/Images/color-blocks/orange_40x15.jpg"),
        PINK("resources/Images/color-blocks/pink_40x15.jpg"),
        RED("resources/Images/color-blocks/red_40x15.jpg"),
        YELLOW("resources/Images/color-blocks/yellow_40x15.jpg");

        private String image;

        BlockType(String image) {
            this.image = image;
        }

        String getImage() {
            return image;
        }

    }

}
