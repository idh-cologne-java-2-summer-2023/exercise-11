package idh.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

class TestATM {

	@Test
	void arrayTest() throws IllegalInputException {
		ATM atm = new ATM();
		int[] test = {0,0,0,0,1,0,1};
		assertArrayEquals(test, atm.convertToBills(25));
		int[] test2 = {0,1,1,1,0,0,0};
		assertArrayEquals(test2, atm.convertToBills(350));
		int[] test3 = {0,0,1,0,0,1,0};
		assertArrayEquals(test3, atm.convertToBills(110));
		int[] test4 = {0,0,0,1,0,1,1};
		assertArrayEquals(test4, atm.convertToBills(65));
	}
	
	@Test
	void negativeNumberTest() throws IllegalInputException {
		ATM atm = new ATM();
		int[] test = {0,0,0,0,0,0,0};
		assertArrayEquals(test, atm.convertToBills(-5));
	}
	
	@Test
	void notfive() {
		ATM atm = new ATM();
		assertThrows(IllegalInputException.class, () -> {atm.convertToBills(8);});
	}

}
