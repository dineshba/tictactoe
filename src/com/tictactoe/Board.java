package com.tictactoe;

public class Board {

    private Player[][] cell = new Player[3][3];
    private static Player NOBODY = Player.NOBODY;

    public Board() {
        
        this.previous_player = NOBODY;
        for (int i= 0; i < 3; i++) {
            for (int j= 0; j < 3; j++) {
                this.cell[i][j] = NOBODY;
            }
        }
    }

    private Player previous_player;

    public Boolean move(Player player, int x_position, int y_position) throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        if (isNotValidPosition(x_position, y_position)) {
            return false;
        }
        if (playerAt(x_position, y_position) == Player.NOBODY) {
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

    public Player playerAt(int x_position, int y_position) {
        if (!isNotValidPosition(x_position, y_position)) {
            return this.cell[x_position][y_position];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Player whoWon() throws IncompleteBoard {
        if (isDiagonallyEqual()) {
            return cell[0][0];
        }
        for(int i = 0; i < 3; i++) {
            if (isRowWiseEqual(i) || isColumnWiseEqual(i)) {
                return cell[i][0];
            }
        }
        if (!isCompleteBoard()) {
            throw new IncompleteBoard();
        }
        return Player.NOBODY;
    }

    private boolean isColumnWiseEqual(int column) {
        return (cell[0][column] == cell[1][column]) && (cell[1][column] == cell[2][column]);
    }

    private boolean isRowWiseEqual(int row) {
        return (cell[row][0] == cell[row][1]) && (cell[row][1] == cell[row][2]);
    }

    private boolean isDiagonallyEqual() {
        return (cell[0][0] == cell[1][1]) && (cell[1][1] == cell[2][2]);
    }

    public boolean isCompleteBoard() {
        int count = 0;
        for (int i= 0; i < 3; i++) {
            for (int j= 0; j < 3; j++) {
                if (this.cell[i][j] != NOBODY) {
                    count++;
                }
            }
        }
        System.out.println(count);
        if (count == 9) {
            return true;
        }
        return false;
    }
}
