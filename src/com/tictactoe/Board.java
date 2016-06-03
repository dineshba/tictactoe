package com.tictactoe;

public class Board {

    private int[][] cell = new int[3][3];

    public Boolean move(int player, int x_position, int y_position) {
        if (x_position >=3 || x_position < 0 || y_position >= 3 || y_position < 0) {
            return false;
        }
        this.cell[x_position][y_position] = player;
        return true;
    }

    public int playerAt(int x_position, int y_position) {
        return this.cell[x_position][y_position];
    }
}
