package com.tictactoe;

public class Board {

    private Players[][] cell = new Players[3][3];

    public Board() {
        Players nobody = Players.NOBODY;
        this.previous_player = nobody;
        for (int i= 0; i < 3; i++) {
            for (int j= 0; j < 3; j++) {
                this.cell[i][j] = nobody;
            }
        }
    }

    private Players previous_player;

    public Boolean move(Players player, int x_position, int y_position) throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        if (isNotValidPosition(x_position, y_position)) {
            return false;
        }
        if (playerAt(x_position, y_position) == Players.NOBODY) {
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

    public Players playerAt(int x_position, int y_position) {
        if (!isNotValidPosition(x_position, y_position)) {
            return this.cell[x_position][y_position];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
