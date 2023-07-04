package idh.java;

import org.junit.Test;
import org.junit.jupiter.api.Assertion;

import idh.java.ATM.IllegalInputException;

public class ATMTest {
	
	@Test
	public void testConvertToBills() throws IllegalInputException {
		ATM atm = new ATM();
		
		
		int Betrag = 100;// durch 5 teilbar
		int[] expected1 = new int[] {0, 0, 1, 0, 0, 0, 0};
		Assertion.assertArrayEquals(expected1, atm.convertToBills(Betrag));
		
		
		int Betrag1 = 1;// nicht durch 5 teilbar
		Assertion.assertThrows(ATM.IllegalInputException.class, () -> {
			atm.convertToBills(Betrag1);
		});
		
		
		int Betrag2 = -5; //Betrag ist negativ
		int[]  expected3 = new int[] {0, 0, 0, 0, 0, 0, 0};
	}
}