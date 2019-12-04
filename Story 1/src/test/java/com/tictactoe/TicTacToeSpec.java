package com.tictactoe;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class TicTacToeSpec {

	private TicTacToe testInstance;
	
	@Before
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
}
