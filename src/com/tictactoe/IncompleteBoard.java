package com.tictactoe;

public class IncompleteBoard extends Throwable {
    public IncompleteBoard() {
        super("Incomplete board");
    }
}
