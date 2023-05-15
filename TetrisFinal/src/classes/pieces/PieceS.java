package classes.pieces;
import classes.Block;
import classes.Empty;

public class PieceS extends Piece {


    public PieceS(){
        super(new Block[][]{
                {new Block('S') , new Empty()      }
                ,{new Block('S') , new Block('S')      }
                ,{new Empty() , new Block('S')}
        },0,0);

    }
}
