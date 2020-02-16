package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture picture;
    public static final int BLOCKWIDTH = 40;
    public static final int BLOCKHEIGHT = 15;

    //Returns the energy of the block. After a block is hit, this value decreases, if this value is zero, block is destroyed
    private int blockEnergy;

    //if true, block is destroyed, it must be deleted
    private boolean destroyed = false;

    //Constructor
    public Block(double xPos, double yPos) {
        BlockType randomBlock = BlockType.values()[(int) (Math.random() * BlockType.values().length)];
        picture = new Picture(xPos, yPos, randomBlock.getImage());
    }

    //return the amount of energy that a block has
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
        picture.draw();
    }

    //destroyed setter, deletes image when block is destroyed
    public void setDestroyed() {
        this.destroyed = true;

        // if block was destroyed, delete its picture from canvas
        picture.delete();
    }

    public void deletePictureBlock() { picture.delete(); }

    //Get Picture
    public void getPicture() { picture.draw(); };

    //Set Picture
    public void setPicture(String url) {
        this.picture.load(url);
    }

    //Returns a random block image
    private enum BlockType {
        BLUE("resources/Images/photo-blocks/audrey_40x30.gif"),
        BROWN("resources/Images/photo-blocks/catarina_40x30.gif"),
        GREEN("resources/Images/photo-blocks/christina_40x30.gif"),
        CYAN("resources/Images/photo-blocks/pedro_40x30.gif"),
        LIME("resources/Images/photo-blocks/priscila_40x30.gif"),
        MAGENTA("resources/Images/photo-blocks/vando_40x30.gif"),
        ORANGE("resources/Images/photo-blocks/audrey_40x30.gif"),
        PINK("resources/Images/photo-blocks/catarina_40x30.gif"),
        RED("resources/Images/photo-blocks/christina_40x30.gif"),
        YELLOW("resources/Images/photo-blocks/priscila_40x30.gif");

        private String image;

        BlockType(String image) {
            this.image = image;
        }

        String getImage() {
            return image;
        }

    }

}
