package idh.java;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
 * Case 1: divided by 5 + least amount of bills
 * to be continued probably after wednesdays deadline..
 * Case 2: negative input
 * Case 3: not div by 5 -> IllegalInputException
*/
public class TestATM {
	
	ATM atm = new ATM();
	
	//using convertToBills int[] and predicted and given
	
	@Test
	void case1() throws IllegalInputException {
		int[] pred = {5, 0, 0, 0, 1, 0, 1};
		int[] given = atm.convertToBills(2525);
		assertArrayEquals(pred,given);
	}
	
	@Test
	void case2() throws IllegalInputException {
		//tbc
	}
	
	@Test
	void case3() throws IllegalInputException {
		//tbc
	}

}
