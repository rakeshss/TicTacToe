package com.tictactoe;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';
	private int size = 3;

	public String play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();
		setBox(x, y, lastPlayer);

		if (anyWinner()) {
			return lastPlayer + " is the winner";
		}
		return "No winner";

	}

	private Boolean anyWinner() {
		// vertical
		for (int i = 0; i < size; i++) {
			if (board[0][i] == lastPlayer && board[1][i] == lastPlayer && board[2][i] == lastPlayer) {
				return true;
			}
		}

		// horizontal
		for (int i = 0; i < size; i++) {
			if (board[i][0] == lastPlayer && board[i][1] == lastPlayer && board[i][2] == lastPlayer) {
				return true;
			}
		}

		// diagonal
		if (board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer) {
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

	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.play(2, 1);
		t.play(2, 1);
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}

}
