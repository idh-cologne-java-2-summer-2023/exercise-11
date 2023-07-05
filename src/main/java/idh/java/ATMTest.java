package idh.java;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import idh.java.ATM.IllegalInputException;

public class ATMTest {
	
	@Test
	public void testConvertToBills() throws IllegalInputException {
		ATM atm = new ATM();
		
		//Betrag ist durch 5 teilbar --> ein 100-Schein erwartet
		int amount1 = 100;
		int[] expected1 = new int[] {0, 0, 1, 0, 0, 0, 0};
		Assertions.assertArrayEquals(expected1, atm.convertToBills(amount1));
		
		//Betrag ist nicht durch 5 teilbar --> Exception erwartet
		int amount2 = 99;
		Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
			atm.convertToBills(amount2);
		});
		
		//Betrag ist negativ --> keine Scheine erwartet
		int amount3 = -100;
		int[]  expected3 = new int[] {0, 0, 0, 0, 0, 0, 0};
		Assertions.assertArrayEquals(expected3, atm.convertToBills(amount3));
	}
}