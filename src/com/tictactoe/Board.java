package com.tictactoe;

public class Board {

    private int[][] cell = new int[3][3];

    public Board() {
        this.previous_player = -1;
    }

    private int previous_player;

    public Boolean move(int player, int x_position, int y_position) throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        if (isNotValidPosition(x_position, y_position)) {
            return false;
        }
        if (playerAt(x_position, y_position) == 0) {
            if(player == this.previous_player) {
                throw new PlayerAlreadyPlayed();
            }
            this.cell[x_position][y_position] = player;
            this.previous_player = player;
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
