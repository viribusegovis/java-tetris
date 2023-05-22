package classes;

import classes.pieces.*;

import java.util.Random;

public class Board extends BlockMatrix{

    private Piece current;

    public Board(Block[][] mat, Piece current){
        super(mat);
        this.current = current;
    }

    public Board(int lines, int columns) {
        // Initialize the matrix with empty blocks
        Block[][] emptyMatrix = new Block[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0;     j < columns; j++) {
                emptyMatrix[i][j] = new Empty();
            }
        }

        // Generate a random piece

        // Set the matrix
        this.matrix = new BlockMatrix(emptyMatrix).getMatrix();
        generateRandomPiece();

    }


    public Board(Board b){
        this(b.getMatrix(), b.current);
    }

    public Piece getCurrent() {
        return current;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }

    public void generateRandomPiece() {
        Random random = new Random();
        int randomNumber = random.nextInt(7); // Generate a random number between 0 and 6

        // Create a new PieceX based on the random number
        switch (randomNumber) {
            case 0 -> current = new PieceI();
            case 1 -> current = new PieceJ();
            case 2 -> current = new PieceL();
            case 3 -> current = new PieceO();
            case 4 -> current = new PieceS();
            case 5 -> current = new PieceT();
            case 6 -> current = new PieceZ();
        }
        System.out.println("Game Lost: "+checkForLoss());
    }

    public boolean canMovePiece(int dy, int dx) {
        int newX = current.getX() + dx;
        int newY = current.getY() + dy;

        // Check if position is within board boundaries
        if (newX < 0 || newX + current.getColumns() > getColumns() ||
                newY < 0 || newY + current.getLines() > getLines()) {
            return false; // Invalid
        }

        // Check for obstacles in the target cells
        for (int x = 0; x < current.getColumns(); ++x) {
            for (int y = 0; y < current.getLines(); ++y) {
                Block block = current.getMatrix()[y][x];
                int targetX = newX + x;
                int targetY = newY + y;
                Block targetBlock = getMatrix()[targetY][targetX];
                if (block.getId()!='.' && targetBlock.getId()!='.') {
                    return false; // Obstacle found
                }
            }
        }

        return true; // Valid
    }

    public boolean canRotatePiece(Piece rotatedPiece) {

        // Get the current coordinates of the original piece
        int originalX = this.current.getX();
        int originalY = this.current.getY();

        // Iterate through the rotated piece's matrix
        for (int y = 0; y < rotatedPiece.getLines(); y++) {
            for (int x = 0; x < rotatedPiece.getColumns(); x++) {
                // Calculate coordinates in the board's matrix
                int newX = originalX + x;
                int newY = originalY + y;

                // Check for collision with walls or other blocks
                //TODO: Fix bug where the rotate kicks with the border but not with pieces
                if (
                        newX < 0
                        || newX >= this.getColumns()
                        || newY < 0
                        || newY >= this.getLines()
                        || this.matrix[newY][newX].equals(new Empty())) {
                return false; // Invalid

                }
            }
        }

        return true; // Valid
    }

    public void rotate(){
        Piece originalCurrent = current.getClone();
        Piece rotatedCurrent = originalCurrent.getClone();
        rotatedCurrent.rotate();

        //Check if it can rotate without wall-kick
        if(canRotatePiece(rotatedCurrent)){
            this.current = rotatedCurrent;
            return;
        }
        System.out.println("rotate, canMovePiece, Left : "+canMovePiece(0,-1));
        //If not then check if it needs to wall-kick left
        if (canMovePiece(0,-1)){

            int deltaSpace = rotatedCurrent.getColumns() - originalCurrent.getColumns();
            for (int x = 0; x < deltaSpace; x++) {
                rotatedCurrent.moveLeft();
            }
            this.current = rotatedCurrent;
            return;
        }

        //or right
        if (canMovePiece(0,1)){
            originalCurrent.moveRight();
            if (canRotatePiece(rotatedCurrent)){
                rotatedCurrent = originalCurrent.getClone();
                rotatedCurrent.rotate();
            }
        }
        //else it can't rotate
        else
            System.out.println("Cannot rotate");
    }

    public void freezePiece() {

        //Iterates the blocks of the current piece
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColumns(); x++) {
                //Checks if is Empty
                if( current.getMatrix()[y][x] instanceof Empty)
                    continue;

                //colocar um clone da peca na matriz
                matrix[y + current.getY()][x + current.getX()]
                        = current.getMatrix()[y][x].getClone();
            }
        }
    }

    public void moveLeft(){
        if (canMovePiece(0,-1)){
            current.moveLeft();
        }
    }

    public void moveRight(){
        if (canMovePiece(0,1)){
            current.moveRight();
        }
    }

    public void moveDown() {
        if (canMovePiece(1, 0)) {
            current.moveDown();
        }else{
            freezePiece();
            generateRandomPiece();
        }
    }

    public void fallDown() {
        System.out.println("fallDown called");
        while (canMovePiece(1 , 0 )){
            current.moveDown();
            System.out.println(canMovePiece(1 , current.getX() ));
         }
        freezePiece();
        generateRandomPiece();
    }

    public boolean checkForLoss(){

        // Check for obstacles in the target cells
        for (int x = 0; x < current.getColumns(); ++x) {
            for (int y = 0; y < current.getLines(); ++y) {
                if (this.matrix[x][y].getId()!='.') {
                    return true; // Continue
                }
            }
        }

        return false; // Lost
    }

    @Override
    public String toString() {
        Board b = new Board(this);
        b.freezePiece();
        StringBuilder str = new StringBuilder();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                str.append(b.matrix[y][x].toString()).append(' ');
            }
            str.append("\n");
        }
        return str.toString();
    }
}
