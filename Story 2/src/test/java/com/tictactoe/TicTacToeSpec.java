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
		
		assertThrows(RuntimeException.class,() -> 
		{
			testInstance.play(5,2);
		});
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		
		assertThrows(RuntimeException.class,() -> 
		{
			testInstance.play(2,5);
		});
	}
	
	@Test
	public void whenOccupiedThenShouldThrowRunTimeException() {
		testInstance.play(2,1); 
		
		assertThrows(RuntimeException.class,() -> 
		{
			testInstance.play(2,1);
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
	
	
}
