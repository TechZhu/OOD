package com.company.pieces;

import com.company.Board;
import com.company.Box;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(end.getX() > 7 || end.getY() > 7) { // check if it is out of bound
            return false;
        }

        if(end.getCurPiece().isWhite() == this.isWhite()) { //if there is already a piece in the same color
            return false;
        }

        //three scenarios
        //Second move Horizontally
        //need to check positive / negative
        int xDiff = end.getX() - start.getX();
        int yDiff = end.getY() - start.getY();

        //move right horizontally, when there is at least one space between them
        if(xDiff > 1 && yDiff == 0) {
            for(int i = start.getX() + 1; i < end.getX(); i++) {
                if(board.getBox(i,start.getY()) != null) {
                    return false;
                }
            }
        }

        //move left horizontally, when there is at least one space between them
        if(xDiff < -1 && yDiff == 0) {
            for(int i = start.getX() - 1; i > end.getX(); i--) {
                if(board.getBox(i,start.getY()) != null) {
                    return false;
                }
            }
        }

        //move up vertically, when there is at least one space between them
        if(xDiff == 0 && yDiff > 1) {
            for(int i = start.getY() + 1; i < end.getY(); i++) {
                if(board.getBox(start.getX(),i) != null) {
                    return false;
                }
            }
            return true;
        }

        //move done vertically, when there is at least one space between them
        if(xDiff == 0 && yDiff < - 1) {
            for(int i = start.getY() - 1; i > end.getY(); i--) {
                if(board.getBox(start.getX(),i) != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
