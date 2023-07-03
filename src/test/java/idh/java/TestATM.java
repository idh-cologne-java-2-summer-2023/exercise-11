package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	
	
	// Test Input dividable by 5
	@Test
	void test() throws IllegalInputException {
		ATM myATM = new ATM();
		int[] socks = {1,0,0,0,0,0,0};
		assertArrayEquals(socks, myATM.convertToBills(5));
	}
		
		// Test Input is very high, not dividable by 5
		@Test
	void seven() throws IllegalInputException{
		ATM myATM = new ATM();
		int[] socks = {1,0,0,0,0,0,0};
		assertThrows(IllegalInputException.class, () ->
		myATM.convertToBills(7));
	}
		
		// Output is Array with 0 only 
		@Test
	void allZero() throws IllegalInputException {
		ATM myATM = new ATM();
		int[] socks = {0,0,0,0,0,0,0};
		assertEquals(socks, myATM.convertToBills(-5));
	}
}
  