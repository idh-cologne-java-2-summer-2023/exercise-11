package idh.java;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import idh.java.ATM.IllegalInputException;


public class TestClass {

	@Test
	public void testConvertToBills_NegativeNumber_ReturnsArrayOfZeros() throws IllegalInputException {
	    ATM atm = new ATM();
	    int[] expected = {0, 0, 0, 0, 0, 0, 0}; 
	    int[] actual = atm.convertToBills(-100);
	    assertArrayEquals(expected, actual);
	}
	@Test(expected = IllegalInputException.class)
	public void testConvertToBills_PositiveNumberNotDivisibleByFive_ThrowsIllegalInputException() throws IllegalInputException {
	    ATM atm = new ATM();
	    atm.convertToBills(123);
	}
	
}
