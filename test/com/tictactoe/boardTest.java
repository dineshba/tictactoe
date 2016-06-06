package com.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class boardTest {

    private Players player;
    private int x_position;
    private int y_position;
    private Board board;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        x_position = 0;
        y_position = 0;
        player = Players.PLAYER;
        board = new Board();
    }

    @Test
    public void shouldReturnTrueIfPositionIsValid() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        assertTrue(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnFalseIfPositionIsInValid() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        y_position = 4;
        assertFalse(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnFalseIfPositionIsNegative() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        x_position = -1;
        assertFalse(board.move(player, x_position, y_position));
    }

    @Test
    public void shouldReturnPlayerIfPlayerIsOccupied() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        board.move(player, x_position, y_position);
        assertEquals(board.playerAt(x_position, y_position), player);
    }

    @Test
    public void shouldReturnZeroIfPlayerIsNotOccupied() {
        assertEquals(Players.NOBODY, board.playerAt(x_position, y_position));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowErrorIfPositionIsInValid() {
        y_position = 4;
        board.playerAt(x_position, y_position);
    }

    @Test(expected = PlayerAlreadyOccupied.class)
    public void shouldNotAllowToInsertIfAlreadyOccupied() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        board.move(player, x_position, y_position);
        board.move(player, x_position, y_position);
    }

    @Test
    public void shouldNotAllowToInsertIfAlreadyOccupiedMessageVerification() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        thrown.expectMessage("Player is already occupied");
        board.move(player, x_position, y_position);
        board.move(Players.COMPUTER, x_position, y_position);
    }

    @Test(expected = PlayerAlreadyPlayed.class)
    public void shouldNotAllowConsecutiveMoveBySamePlayer() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        board.move(player, x_position, y_position);
        board.move(player, x_position + 1, y_position);
    }

    @Test
    public void shouldNotAllowConsecutiveMoveBySamePlayerMessageVerification() throws PlayerAlreadyOccupied, PlayerAlreadyPlayed {
        thrown.expectMessage("Player has already played");
        board.move(player, x_position, y_position);
        board.move(player, x_position + 1, y_position);
    }

}
