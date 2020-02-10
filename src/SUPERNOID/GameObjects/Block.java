package SUPERNOID.GameObjects;

import SUPERNOID.GridPosition;

public class Block extends GameObject {

    public static final int BLOCKWIDTH = 64;
    public static final int BLOCKHEIGHT = 32;

    private int blockEnergy;
    private boolean destroyed = false;
    private GridPosition position;

    public Block(double xPos, double yPos, String image) {
        super(xPos, yPos, image);
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
}

