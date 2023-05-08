package blocks;

/**
 *
 * @author Vasco
 */
public class BlockMatrix {
    
    Block[][] matrix;

    /**
     * Construtor with parameters with a strong relationship (agregation) the
     * constructor makes a clone of the parameter
     *
     * @param matrix
     */
    public BlockMatrix(Block[][] matrix) {
        //dimensions of the original matrix
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
    
    public BlockMatrix(BlockMatrix original) {
        this(original.matrix);
    }
    
    public BlockMatrix() {
        this(new Block[][]{{new Empty()}});
    }
    
    public Block[][] getMatrix() {
        return matrix;
    }
    
    public int getLines() {
        return matrix.length;
    }
    
    public int getColumns() {
        return matrix[0].length;
    }
    
    @Override
    public String toString() {
        String txt = "";

        //devia utilizar StringBuilder
        for (Block[] blocks : matrix) {
            for (Block block : blocks) {
                txt += block.toString() + " ";
            }
            txt += "\n";
        }
        
        return txt;
    }
    
    public BlockMatrix getClone() {
        return new BlockMatrix(this);
    }
    
    private static Block[][] rotateMatrix(Block[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // create a new array with swapped rows and columns
        Block[][] rotatedArr = new Block[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedArr[j][i] = arr[i][j];
            }
        }

        // reverse each row to complete the rotation
        for (int i = 0; i < cols; i++) {
            for (int j = 0, k = rows - 1; j < k; j++, k--) {
                Block temp = rotatedArr[i][j];
                rotatedArr[i][j] = rotatedArr[i][k];
                rotatedArr[i][k] = temp;
            }
        }
        
        return rotatedArr;
    }
    
    public void rotate() {
        this.matrix = rotateMatrix(matrix);
    }
    
}
