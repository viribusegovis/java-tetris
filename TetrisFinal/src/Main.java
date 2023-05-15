import classes.Block;
import classes.BlockMatrix;
import classes.Board;
import classes.Empty;
import classes.pieces.*;

public class Main {
    public static void main(String[] args) {
        testBlock();
        testBlockMatrix();
        testPiece();
        testPieceX();
    }

    private static void testBlock(){
        //construtor com parâmetros
        Block b1 = new Block('L');
        //construor cópia
        Block b2 = new Block(b1);
        //clonar um objeto
        Block b3 = b2.getClone();
        System.out.println("Construtores e clone");
        //tostring
        System.out.println("b1 = " + b1 + "\t b2 = " + b2 + "\t b3 = " + b3);
        //modificador
        b2.setId('X');
        System.out.println(" Modificador b2");
        System.out.println("b1 = " + b1 + "\t b2 = " + b2 + "\t b3 = " + b3);
    }

    private static void testBlockMatrix(){
        Block[][] bl = {
                {new Block('L'), new Empty()},
                {new Block('L'), new Empty()},
                {new Block('L'), new Block('L')},};
        BlockMatrix b1 = new BlockMatrix(bl);
        BlockMatrix b2 = b1.getClone();

        System.out.println("b1\n" + b1);
        System.out.println("b2\n" + b2);

        System.out.println("N. Linhas " + b1.getLines());
        System.out.println("N. colunas " + b1.getColumns());

        b2.rotate();
        System.out.println("Original b1\n" + b1);
        System.out.println("Rotate b2\n" + b2);
    }


    private static void testPiece(){
        Block[][] B = {
                {new Empty(), new Block('S'), new Block('S')},
                {new Block('S'), new Block('S'), new Empty()}
        };
        Piece p = new Piece(B, 1, 4);
        System.out.println("piece = " + p);
        p.moveRight();
        p.rotate();
        System.out.println("Right and rotate " + p);
    }

    private static void testPieceX(){
        Piece l = new PieceL();
        l.moveRight();
        System.out.println(l);
        Piece t = new PieceT();
        t.rotate();
        t.moveDown();
        System.out.println(t);
        Piece i= new PieceI();
        i.rotate();
        System.out.println(i);
        Piece o = new PieceO();
        o.rotate();
        System.out.println(o);
    }

    private static void testBoard(){
        Board b = new Board(10, 10);
        System.out.println("ORIGINAL \n" + b);
        for (int i = 0; i < 100; i++) {
            b.moveLeft();
        }
        b.moveLeft();
        System.out.println("Left \n" + b);
        for (int i = 0; i < 100; i++) {
            b.moveRight();
        }
        System.out.println("Right \n" + b);
        b.fallDown();
        System.out.println("FALL \n" + b);
        b.freezePiece();
        b.generateRandomPiece();
        System.out.println("Random \n" + b);
    }
}