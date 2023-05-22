package classes.pieces;

import classes.Block;
import classes.BlockMatrix;

public class Piece extends BlockMatrix {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece(Block[][] matrix, int x, int y){
        super(matrix);
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y+")\n" + super.toString();
    }

    public Piece(Piece p){
        this(p.getMatrix(), p.x,p.y);
    }

    public Piece getClone() {
        return new Piece(this);
    }

    public void moveLeft(){
        this.setX(this.getX()-1);
    }

    public void moveRight(){
        this.setX(this.getX()+1);
    }

    public void moveDown(){
        this.setY(this.getY()+1);
    }
}
