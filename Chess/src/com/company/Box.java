package com.company;

import com.company.pieces.Piece;

//a box in the chessBoard
public class Box {
    private Piece curPiece;
    private int x;
    private int y;

    public Box(int x, int y, Piece curPiece) {
        this.setX(x);
        this.setY(y);
        this.setCurPiece(curPiece);
    }

    public void setCurPiece(Piece curPiece) {
        this.curPiece = curPiece;
    }

    public Piece getCurPiece() {
        return curPiece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean setX(int x) {
        if(x > 7) {
            return false;
        }
        this.x = x;
        return true;
    }

    public boolean setY(int y) {
        if(y > 7) {
            return false;
        }
        this.y = y;
        return true;
    }
}
