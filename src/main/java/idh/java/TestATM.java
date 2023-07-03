package idh.java;


import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

public class TestATM {

	ATM myATM;
	
	@BeforeEach
	void setup() {
		myATM = new ATM();
	}
	
	
	@Test
	void testLargestBills() throws IllegalInputException {
		
		assertArrayEquals(new int[] {1,0,0,0,0,0,0}, myATM.convertToBills(500));
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, myATM.convertToBills(5));
		assertArrayEquals(new int[] {0,1,1,0,1,0,1}, myATM.convertToBills(325));
		assertArrayEquals(new int[] {11,2,0,1,0,1,1}, myATM.convertToBills(5965));
	}
	
	
	@Test
	void testNegativeNumb() throws IllegalInputException {
		
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, myATM.convertToBills(-1));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, myATM.convertToBills(-25));
	}
	
	
	@Test
	public void testIllegalInput() {
		
	    assertThrows(IllegalInputException.class, () -> {myATM.convertToBills(7);});
	    assertThrows(IllegalInputException.class, () -> {myATM.convertToBills(2);});
	}
	
}
