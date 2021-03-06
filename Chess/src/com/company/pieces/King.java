package com.company.pieces;
import com.company.Board;
import com.company.Box;

public class King extends Piece{
    //private boolean isCastled;  will be implemented later
    public King(boolean isWhite) {
        super(isWhite);
    }
    @Override
    //Since we don't need to consider castling
    public boolean canMove(Board board, Box start, Box end) {
        if(end.getX() > 7 || end.getY() > 7) { // check if it is out of bound
            return false;
        }

        if(end.getCurPiece().isWhite() == this.isWhite()) { //if there is already a piece in the same color
            return false;
        }

        int moveDistance = Math.abs(end.getX() - start.getX()) + Math.abs(end.getY() - start.getY());

        return moveDistance == 1;
        //return isCastled(), will be implemented later
    }
}
