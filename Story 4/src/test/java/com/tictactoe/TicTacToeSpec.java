package com.tictactoe;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class TicTacToeSpec {

	private TicTacToe testInstance;

	@BeforeEach
	public final void init() {
		testInstance = new TicTacToe();
	}

	@Test
	public void whenXOutsideBoardThenRuntimeException() {

		assertThrows(RuntimeException.class, () -> {
			testInstance.play(5, 2);
		});
	}

	@Test
	public void whenYOutsideBoardThenRuntimeException() {

		assertThrows(RuntimeException.class, () -> {
			testInstance.play(2, 5);
		});
	}

	@Test
	public void whenOccupiedThenShouldThrowRunTimeException() {
		testInstance.play(2, 1);

		assertThrows(RuntimeException.class, () -> {
			testInstance.play(2, 1);
		});
	}

	@Test
	public void givenFirstTurnWhenNextPlayerThenX() {
		assertThat('X', is(equalTo(testInstance.nextPlayer())));
	}

	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		testInstance.play(1, 1);
		assertThat('O', is(equalTo(testInstance.nextPlayer())));
	}

	@Test
	public void whenPlayThenNoWinner() {
		assertThat("No winner", is(equalTo(testInstance.play(1, 1))));
	}

	@Test
	public void whenPlayAndWholeVerticalLineThenWinner() {
		testInstance.play(1, 1); // X
		testInstance.play(1, 2); // 0
		testInstance.play(2, 1); // X
		testInstance.play(2, 2); // 0
		String actual = testInstance.play(3, 1); // X

		assertThat("X is the winner", is(equalTo(actual)));
	}

	@Test
	public void whenPlayAndWholeHorizontalLineThenWinner() {
		testInstance.play(1, 1); // X
		testInstance.play(2, 1); // 0
		testInstance.play(1, 2); // X
		testInstance.play(2, 3); // O
		String actual = testInstance.play(1, 3); // X

		assertThat("X is the winner", is(equalTo(actual)));
	}
	
	@Test
	public void whenPlayAndDiagonalLineThenWinner() {
		testInstance.play(1, 1); // X
		testInstance.play(2, 1); // 0
		testInstance.play(2, 2); // X
		testInstance.play(2, 3); // O
		String actual = testInstance.play(3, 3); // X

		assertThat("X is the winner", is(equalTo(actual)));
	}
	
	@Test
	public void whenAllBoxesAreFilledThenDraw() {
		testInstance.play(1, 1); // X
		testInstance.play(1, 2); // 0
		testInstance.play(1, 3); // X
		testInstance.play(2, 1); // O
		testInstance.play(2, 2); // X
		testInstance.play(2, 3); // O
		testInstance.play(3, 1); // X
		testInstance.play(3, 3); // O
		
		String actual = testInstance.play(3, 2); // X

		assertThat("The result is draw", is(equalTo(actual)));
	}
	
	
}
