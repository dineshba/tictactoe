package com.tictactoe;

public class PlayerAlreadyOccupied extends Throwable {
    public PlayerAlreadyOccupied() {
        super("Player is already occupied");
    }
}
