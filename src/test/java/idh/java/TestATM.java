package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	
	ATM myATM;
	
	@BeforeEach
	void setup() {
		myATM = new ATM();
	}
	
	@Test
	void testBills() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, myATM.convertToBills(5));
		assertArrayEquals(new int[] {0,0,0,0,0,1,0}, myATM.convertToBills(10));
		assertArrayEquals(new int[] {0,0,0,0,1,0,0}, myATM.convertToBills(20));
		assertArrayEquals(new int[] {0,0,0,1,0,0,0}, myATM.convertToBills(50));
		assertArrayEquals(new int[] {0,0,1,0,0,0,0}, myATM.convertToBills(100));
		assertArrayEquals(new int[] {0,1,0,0,0,0,0}, myATM.convertToBills(200));
		assertArrayEquals(new int[] {1,0,0,0,0,0,0}, myATM.convertToBills(500));
		assertArrayEquals(new int[] {1,0,0,0,0,0,1}, myATM.convertToBills(505));
		assertArrayEquals(new int[] {0,0,0,0,1,1,0}, myATM.convertToBills(30));
		assertArrayEquals(new int[] {1,1,1,1,1,1,1}, myATM.convertToBills(885));
		assertArrayEquals(new int[] {0,0,0,1,0,1,1}, myATM.convertToBills(65));
	}

	@Test
	void testNegative() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, myATM.convertToBills(-5));
	}
	
	@Test
	void testNotByFive() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, myATM.convertToBills(7));
	}
}
