package classes;

public class BlockMatrix {

    protected Block[][] matrix ;

    /***
     * Default constructor - Creates a Empty 1x1 matrix
     */
    public BlockMatrix(){
        this.matrix = new Block[1][1];
    }
    public BlockMatrix(Block[][] matrix) {
        int lines = matrix.length;
        int cols = matrix[0].length;

        //initialize array
        this.matrix = new Block[lines][cols];

        //clone all blocks
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < cols; x++) {
                //calls get clone of each block
                this.matrix[y][x] = matrix[y][x].getClone();
            }
        }
    }


    public BlockMatrix(BlockMatrix bMAt){
        this.matrix = bMAt.matrix;
    }

    public Block[][] getMatrix() {
        return this.matrix;
    }

    public int getLines() {
        return this.matrix.length;
    }

    public int getColumns() {
        return this.matrix[0].length;
    }

    public BlockMatrix getClone() {
        return new BlockMatrix(this);
    }

    public void rotate() {
        Block[][] rotatedMatrix = new Block[this.getColumns()][this.getLines()];
        for (int i = 0; i < this.getLines(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                rotatedMatrix[j][this.getLines() - i - 1] = this.matrix[i][j].getClone();
            }
        }
        this.matrix = rotatedMatrix;
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder();
        for (int i = 0; i < this.getLines(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                str.append(matrix[i][j].getId()).append(" ");

            }
            str.append("\n");
        }
        return str.toString();
    }
}
