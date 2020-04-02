package com.company;

public class Board {
    Box[][] boxes;

    public Board() {
        this.newBoard();
    }
    public void newBoard() {

    }
    public Box getBox(int x, int y) {
        return new Box(0,0, null);
    }
}
