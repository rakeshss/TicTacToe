package com.tictactoe;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';
	private static final int SIZE = 3;

	public String play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();
		setBox(x, y, lastPlayer);

		if (anyWinner()) {
			return lastPlayer + " is the winner";
		} else if (isDraw()) {
			return "The result is draw";
		} else {
			return "No winner";
		}

	}

	private boolean isDraw() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (board[x][y] == '\0') {
					return false;
				}
			}
		}
		return true;
	}

	private Boolean anyWinner() {
		int playerTotal = lastPlayer * SIZE;

		// horizontal
		for (int i = 0; i < SIZE; i++) {
			if (board[i][0] == lastPlayer && board[i][1] == lastPlayer && board[i][2] == lastPlayer) {
				return true;
			}
		}

		// vertical: validating in different and slightly easier way than horizontal
		// check
		for (int i = 0; i < SIZE; i++) {
			if (board[0][i] + board[1][i] + board[2][i] == playerTotal) {
				return true;
			}
		}

		// diagonal
		if (board[0][0] + board[1][1] + board[2][2] == playerTotal) {
			return true;
		}

		return false;
	}

	private void setBox(int x, int y, char lastPlayer) {
		if (board[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Cell is already occupied");
		} else {
			board[x - 1][y - 1] = lastPlayer;
		}
	}

	private void checkAxis(int axis) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException("Co-ordinate is outside board");
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}

}
