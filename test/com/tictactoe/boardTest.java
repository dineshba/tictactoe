package com.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class boardTest {

    private int player;
    private int x_position;
    private int y_position;
    private Board board;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        x_position = 0;
        y_position = 0;
        player = 1;
        board = new Board();
    }

    @Test
    public void shouldReturnTrueIfPositionIsValid() throws PlayerAlreadyOccupied {
        assertTrue(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnFalseIfPositionIsInValid() throws PlayerAlreadyOccupied {
        y_position = 4;
        assertFalse(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnFalseIfPositionIsNegative() throws PlayerAlreadyOccupied {
        x_position = -1;
        assertFalse(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnPlayerIfPlayerIsOccupied() throws PlayerAlreadyOccupied {
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

    @Test
    public void shouldNotAllowToInsertIfAlreadyOccupied() throws PlayerAlreadyOccupied {
        thrown.expectMessage("Player is already occupied");
        board.move(player, x_position, y_position);
        board.move(player, x_position, y_position);
    }

}
