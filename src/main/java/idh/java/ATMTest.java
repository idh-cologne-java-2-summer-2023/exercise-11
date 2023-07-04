package idh.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ATMTest {
	
	private ATM atm;
	
	@Before
	public void setUp() {
		atm = new ATM();
	}

	@Test
	public void testConvertToBills_ValidAmount() throws ATM.IllegalInputException {
		int amount = 200;
		int[] expected = {0, 1, 0, 0, 0, 0, 0};
		int[] result = atm.convertToBills(amount);
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testConvertToBills_NegativeAmount() throws ATM.IllegalInputException {
		int amount = -100;
		int[] expected = {0, 0, 0, 0, 0, 0, 0};
		int[] result = atm.convertToBills(amount);
		assertArrayEquals(expected, result);
	}
	
	@Test(expected = ATM.IllegalInputException.class)
	public void testConvertToBills_NonDivisibleAmount() throws ATM.IllegalInputException {
		int amount = 123;
		atm.convertToBills(amount);
	}
	
	@Test
	public void testConvertToBills_LargestAmount() throws ATM.IllegalInputException {
		int amount = Integer.MAX_VALUE;
		int[] expected = {2, 3, 1, 1, 1, 0, 1};
		int[] result = atm.convertToBills(amount);
		assertArrayEquals(expected, result);
	}
}
