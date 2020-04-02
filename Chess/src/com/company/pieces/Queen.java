package com.company.pieces;

import com.company.Board;
import com.company.Box;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
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
        //Third move Diagonally
        //need to check if its positive / negative
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

        //move top-right 45 degree
        if(xDiff < -1 && yDiff > 1 && (Math.abs(xDiff) == yDiff)) {
            for(int i = 1; i < yDiff; i++) {
                if(board.getBox(start.getX() - i,start.getY() + i) != null) {
                    return false;
                }
            }
            return true;
        }

        //move right-done 45 degree
        if(xDiff > 1 && yDiff > 1 && (xDiff == yDiff)) {
            for(int i = 1; i < xDiff; i++) {
                if(board.getBox(start.getX() + i,start.getY() + i) != null) {
                    return false;
                }
            }
            return true;
        }

        //move left-done 45 degree
        if(xDiff > 1 && yDiff < -1 && (xDiff == Math.abs(yDiff))) {
            for(int i = 1; i < Math.abs(xDiff); i++) {
                if(board.getBox(start.getX() + i,start.getY() - i) != null) {
                    return false;
                }
            }
            return true;
        }

        //move left-top 45 degree
        if(xDiff < -1 && yDiff < -1 && (xDiff == yDiff)) {
            for(int i = 1; i < Math.abs(xDiff); i++) {
                if(board.getBox(start.getX() - i,start.getY() - i) != null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
