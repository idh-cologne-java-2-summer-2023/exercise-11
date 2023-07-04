package idh.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import idh.java.ATM.IllegalInputException;

public class ATMTest {
	ATM atm;
	
	@Before
	void setup() {
		this.atm = new ATM();
	}
	
	@Test
	void testConvertToBills() throws IllegalInputException {
		assertArrayEquals(new int[] {2,1,0,0,0,0,0}, atm.convertToBills(1200));
		assertArrayEquals(new int[] {0,0,0,0,0,1,1}, atm.convertToBills(15));
		assertArrayEquals(new int[] {6966,1,1,1,2,0,1}, atm.convertToBills(3483395));
		assertArrayEquals(new int[] {2,1,0,0,0,0,0}, atm.convertToBills(1200));
	}
	
	@Test
	void testNegativeAmount() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, atm.convertToBills(-200));
	}
	
	@Test
	void testException() {
		assertThrows(IllegalInputException.class, () -> atm.convertToBills(7));
	}
	
}
