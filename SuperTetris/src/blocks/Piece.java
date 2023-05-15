package blocks;

/**
 *
 * @author Vasco
 */
public class Piece extends BlockMatrix {

    private int x;
    private int y;

    public Piece(Block[][] mat, int y, int x) {
        super(mat);
        this.setX(x);
        this.setY(y);
    }

    public Piece(Piece p) {
        this(p.getMatrix(), p.x, p.y);
    }

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

    public void moveLeft() {
        this.setX(this.getX() - 1);
    }

    public void moveRight() {
        this.setX(this.getX() + 1);
    }

    public void moveDown() {
        this.setY(this.getY() + 1);
    }

    @Override
    public Piece getClone() {
        return new Piece(this);
    }

    @Override
    public String toString() {
        return "(" + this.y + "," + this.x + ")" + "\n" + super.toString();
    }
}
