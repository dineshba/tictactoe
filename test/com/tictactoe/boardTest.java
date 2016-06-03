package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class boardTest {

    private int player;
    private int x_position;
    private int y_position;
    private Board board;

    @Before
    public void setUp() {
        x_position = 0;
        y_position = 0;
        player = 1;
        board = new Board();
    }
    @Test
    public void shouldReturnTrueIfPositionIsValid() {
        assertTrue(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnFalseIfPositionIsInValid() {
        y_position = 4;
        assertFalse(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnFalseIfPositionIsNegative() {
        x_position = -1;
        assertFalse(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnPlayerIfPlayerIsOccupied() {
        board.move(player, x_position, y_position);
        assertEquals(board.playerAt(x_position, y_position), player);
    }

    @Test
    public void shouldReturnZeroIfPlayerIsNotOccupied() {
        assertEquals(0, board.playerAt(x_position, y_position));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowErrorIfPositionIsInValid() {
        y_position = 4;
        board.playerAt(x_position, y_position);
    }

}
