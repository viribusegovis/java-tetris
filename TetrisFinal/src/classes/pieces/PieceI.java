package classes.pieces;

import classes.Block;

public class PieceI extends Piece {


    public PieceI(){
        super(new Block[][]{
                {new Block('I')}
                ,{new Block('I')}
                ,{new Block('I')}
                ,{new Block('I')}

        },0,0);

    }
}
