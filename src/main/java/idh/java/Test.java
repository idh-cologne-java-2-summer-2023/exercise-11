package idh.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test {
	
	
	
	public void testConvertToBills_durchfünf() throws ATM.IllegalInputException {
		ATM atm = new ATM();
		int[]expected = {1, 0, 0, 0, 0, 0, 0};
		Assertions.assertArrayEquals(expected, atm.convertToBills(500));
	}
	
	
	public void testConvertToBills_nichtdurchfünf() {
		ATM atm = new ATM();
		Assertions.assertThrows (ATM.IllegalInputException.class, () -> {
		atm.convertToBills(123);
	});
}
	
	
	public void testConvertToBills_negativeAusgabe() throws ATM.IllegalInputException {
	ATM atm = new ATM();
	int[] expected = {0, 0, 0, 0, 0, 0, 0}; // All zeros 
	Assertions.assertArrayEquals(expected, atm.convertToBills (-100));
	}
	//überprüft, ob große Werte in erwarteten Stücken zurückgegeben werden
	
	public void testConvertToBills_großeAusgabe() throws ATM.IllegalInputException { 
	ATM atm = new ATM();
	int[] expected = {2000000000, 1000000000,50000000, 100000000, 50000000, 10000000, 5000000}; 
	Assertions.assertArrayEquals(expected, atm.convertToBills (Integer.MAX_VALUE));
	}

}

