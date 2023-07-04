package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
	void leastBanknotes() throws IllegalInputException {
		int[] expected = new int[] {0, 0, 0, 1, 2, 0, 1}; 
        int[] actual = myATM.convertToBills(95); 
        assertArrayEquals(expected, actual);
	}
	
	@Test
	void leastBanknotes2() throws IllegalInputException {
		int[] expected = new int[] {0, 0, 0, 0, 0, 1, 1}; 
        int[] actual = myATM.convertToBills(15); 
        assertArrayEquals(expected, actual);
	}
	
	// hier sollte eine IllegalInputException geworfen werden
	@Test
	void testNegativeNumber() throws IllegalInputException {
		int[] expected = new int[] {0, 0, 0, 0, 0, 0, 0}; 
        int[] actual = myATM.convertToBills(-100); 
        assertArrayEquals(expected, actual);
	}
	
	
	@Test
	void testCashout() {
		assertThrows(IllegalInputException.class , () -> {myATM.convertToBills(6);});
	}
}
