package idh.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	ATM myATM;
	
	@BeforeEach
	void setup() {
		myATM = new ATM ();
	}
		
	@Test
	void testValueOfBills() throws IllegalInputException {
		assertArrayEquals(new int[] {1,0,0,0,0,0}, myATM.convertToBills(200));
		assertArrayEquals(new int[] {0,0,1,1,0,1}, myATM.convertToBills(75));
		assertArrayEquals(new int[] {2,1,1,0,0,1}, myATM.convertToBills(555));
		assertArrayEquals(new int[] {52,1,1,1,1,1}, myATM.convertToBills(10585));
		assertArrayEquals(new int[] {0,0,0,0,0,1}, myATM.convertToBills(5));
	}
	
	@Test
	void testNegativeInput() throws IllegalInputException  {
		assertArrayEquals(new int[] {0,0,0,0,0,0}, myATM.convertToBills(-200));
	}
	
	@Test
	void testDivisible() {
		assertThrows(IllegalInputException.class, () -> {myATM.convertToBills(7);});
	}

}
