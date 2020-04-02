package com.company.pieces;

import com.company.Board;
import com.company.Box;

public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean isWhite) {
        this.setWhite(isWhite);
    }

    public boolean isKilled() {
        return this.killed;
    }

    public boolean isWhite() {
        return this.white;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }
    //why do we need to pass board, box and parameter
    public abstract boolean canMove(Board board, Box start, Box end);
}
