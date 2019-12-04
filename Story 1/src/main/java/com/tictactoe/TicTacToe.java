package com.tictactoe;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };

	 
	// first version: before refactoring
	/*
	public void play(int x, int y) {
		if(x < 1 || x > 3) {
			throw new RuntimeException("X is outside board");
		}else if(y < 1 || y > 3) {
			throw new RuntimeException("Y is outside board");
		}
		
		if(board[x-1][y-1] != '\0') {
			throw new RuntimeException("Cell is already occupied");
		}else {
			board[x-1][y-1] = 'X';
		}
	}	
	
	*/

	public void play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		setBox(x, y);
	}

	private void setBox(int x, int y) {
		if (board[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Cell is already occupied");
		} else {
			board[x - 1][y - 1] = 'X';
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

}
