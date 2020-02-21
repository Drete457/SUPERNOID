package SUPERNOID.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture picture;
    private String path;
    public static final int BLOCKWIDTH = 40;
    public static final int BLOCKHEIGHT = 15;

    //Returns the energy of the block. After a block is hit, this value decreases, if this value is zero, block is destroyed
    private int blockEnergy;

    //if true, block is destroyed, it must be deleted
    private boolean destroyed = false;

    //Constructor
    public Block(double xPos, double yPos) {
        BlockType randomBlock = BlockType.values()[(int) (Math.random() * BlockType.values().length)];
        path = randomBlock.getImage().substring(0, randomBlock.getImage().length()-4);
        picture = new Picture(xPos, yPos, randomBlock.getImage());
        setBlockEnergy();
    }

    //return the amount of energy that a block has
    public int getBlockEnergy() {
        return blockEnergy;
    }

    //Block Energy Setter
    public void setBlockEnergy() {
        this.blockEnergy = (int) (Math.random()*6);
    }

    //Method to call when the ball hits the block
    public void hit() {
        //decrease energy and if its <= 0, set destroyed to true
        blockEnergy --;
        setPictureDestruction();
        if (blockEnergy <= 0) {
            setDestroyed();
            // if block was destroyed, delete its picture from canvas.
            picture.delete();
        }
    }

    //make the block have the correct image based in the live remaining
    private void setPictureDestruction() {
        String newPath = path;
        if (blockEnergy == 4) {
            setPicture(newPath + "-1.png");
            return;
        }
        if (blockEnergy == 3) {
            setPicture(newPath + "-2.png");
            return;
        }
        if (blockEnergy == 2) {
            setPicture(newPath + "-3.png");
            return;
        }
        if (blockEnergy == 1) {
            setPicture(newPath + "-4.png");
            return;
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
