package com.tictactoe;

public class Board {

    private int[][] cell = new int[3][3];

    public Boolean move(int player, int x_position, int y_position) throws PlayerAlreadyOccupied {
        if (isNotValidPosition(x_position, y_position)) {
            return false;
        }
        if (playerAt(x_position, y_position) == 0) {
            this.cell[x_position][y_position] = player;
        }
        else {
            throw new PlayerAlreadyOccupied();
        }
        return true;
    }

    private boolean isNotValidPosition(int x_position, int y_position) {
        return x_position >=3 || x_position < 0 || y_position >= 3 || y_position < 0;
    }

    public int playerAt(int x_position, int y_position) {
        if (!isNotValidPosition(x_position, y_position)) {
            return this.cell[x_position][y_position];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
