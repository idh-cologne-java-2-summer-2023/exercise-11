package idh.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	
	ATM atm = new ATM();
	
	@Test
	void fuenfer() throws IllegalInputException {
		int[] arr = atm.convertToBills(2000);
		 assertTrue(arr[7] < 2);
	}

	@Test
	void zehner() throws IllegalInputException {
		int[] arr = atm.convertToBills(2000);
		 assertTrue(arr[6] < 2);
	}
	
	@Test
	void zwanziger() throws IllegalInputException {
		int[] arr = atm.convertToBills(2000);
		 assertTrue(arr[5] < 3);
	}
	
	@Test
	void fuenfziger() throws IllegalInputException {
		int[] arr = atm.convertToBills(2000);
		 assertTrue(arr[4] < 2);
	}
	
	@Test
	void hunderter() throws IllegalInputException {
		int[] arr = atm.convertToBills(2000);
		 assertTrue(arr[3] < 2);
	}
	
	@Test
	void zweihunderter() throws IllegalInputException {
		int[] arr = atm.convertToBills(2000);
		 assertTrue(arr[2] < 3);
	}

}
