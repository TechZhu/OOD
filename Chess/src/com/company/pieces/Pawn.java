package com.company.pieces;

import com.company.Board;
import com.company.Box;

public class Pawn extends Piece{
    public Pawn(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return true;
    }
}
