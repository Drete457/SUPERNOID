package SUPERNOID;

/**
 * Created by codecadet on 08/02/2020.
 */
public class GridPosition {

    private double x;
    private double y;
    private Grid grid;
    private GameObject gameObj;

    public GridPosition(double x, double y, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    //public void

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
        //show();
    }
}
