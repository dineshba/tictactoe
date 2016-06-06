package com.tictactoe;

public class PlayerAlreadyPlayed extends Throwable {
    public PlayerAlreadyPlayed() {
        super("Player has already played");
    }
}
