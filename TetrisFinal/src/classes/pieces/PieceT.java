package classes.pieces;

import classes.Block;
import classes.Empty;

public class PieceT extends Piece {


    public PieceT(){
        super(new Block[][]{
                {new Empty() , new Block('T')}
                ,{new Block('T') , new Block('T')}
                ,{new Empty() , new Block('T')}
        },0,0);

    }
}
