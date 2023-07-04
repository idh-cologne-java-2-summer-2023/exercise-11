package idh.java;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import idh.java.ATM.IllegalInputException;


public class Scheine {
	
	public void testConvertToBills_NegativeNumber_ReturnsArrayOfZeros() throws IllegalInputException {
	    
		ATM atm = new ATM();
	    int[] expected = {0, 0, 0, 0, 0, 0, 0}; 
	    int[] actual = atm.convertToBills(-100);
	    Assertions.assertArrayEquals(expected, actual);
	}
	
	
	public void testConvertToBills_PositiveNumberNotDivisibleByFive_ThrowsIllegalInputException() throws IllegalInputException {
	    ATM atm = new ATM();
	    atm.convertToBills(123);
	}
}
