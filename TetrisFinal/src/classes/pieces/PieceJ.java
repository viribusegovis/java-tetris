package classes.pieces;

import classes.Block;
import classes.Empty;

public class PieceJ extends Piece {


    public PieceJ(){
        super(new Block[][]{
                {new Empty() , new Block('J')      }
                ,{new Empty() , new Block('J')     }
                ,{new Block('J') , new Block('J')}
        },0,0);

    }
}
