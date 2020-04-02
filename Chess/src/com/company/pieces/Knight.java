package com.company.pieces;

import com.company.Board;
import com.company.Box;

public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    };
    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(end.getX() > 7 || end.getY() > 7) { // check if it is out of bound
            return false;
        }

        if(end.getCurPiece().isWhite() == this.isWhite()) { //if there is already a piece in the same color
            return false;
        }
        int xDiff = Math.abs(end.getX() - start.getX());
        int yDiff = Math.abs(end.getY() - start.getY());

        if((xDiff == 1  && yDiff == 2) || (yDiff == 1 && xDiff == 2)) {
            return true;
        }
        return false;
    }

}
