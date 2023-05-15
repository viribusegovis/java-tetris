package classes;

import classes.pieces.*;

import java.util.Arrays;
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
        generateRandomPiece();

        // Set the matrix
        this.matrix = new BlockMatrix(emptyMatrix).getMatrix();
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
    }

    public boolean canMovePiece(int dx, int dy) {
        int newX = current.getX() + dx;
        int newY = current.getY() + dy;

        // Check if the new position is within the boundaries of the board
        if (newX < 0 || newX + current.getColumns() > getColumns() ||
                newY < 0 || newY + current.getLines() > getLines()) {
            return false; // Invalid position
        }

        // Check for obstacles in the target cells
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColumns(); x++) {
                Block block = current.getMatrix()[y][x];
                int targetX = newX + x;
                int targetY = newY + y;
                Block targetBlock = getMatrix()[targetY][targetX];
                if (block.getId()!='.' && targetBlock.getId()!='.') {
                    return false; // Obstacle found
                }
            }
        }

        return true; // Valid move
    }

    public void freezePiece() {
        // Get the position of the piece and update the corresponding blocks in the matrix
        int pieceX = current.getX();
        int pieceY = current.getY();

        Block[][] pieceMatrix = current.getMatrix();
        int pieceLines = pieceMatrix.length;
        int pieceColumns = pieceMatrix[0].length;

        // Update the matrix with the blocks of the piece
        for (int i = 0; i < pieceLines; i++) {
            for (int j = 0; j < pieceColumns; j++) {
                Block block = pieceMatrix[i][j];
                if (!(block instanceof Empty)) {
                    int boardX = pieceX + i;
                    int boardY = pieceY + j;
                    this.matrix[boardX][boardY] = block;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "current=" + current +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
