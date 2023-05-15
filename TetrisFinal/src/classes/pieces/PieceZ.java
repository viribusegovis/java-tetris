package classes.pieces;

import classes.Block;
import classes.Empty;

public class PieceZ extends Piece {


    public PieceZ(){
        super(new Block[][]{
                {new Empty() , new Block('Z')      }
                ,{new Block('Z') , new Block('Z')      }
                ,{new Block('Z') , new Empty()}
        },0,0);

    }
}
