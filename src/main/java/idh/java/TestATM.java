package idh.java;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;


public class TestATM {
	ATM testATM;

	@BeforeEach
	void setup() {
		testATM = new ATM();
	}

	@Test
	void testBills() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 2, 0, 0, 0, 0, 0}, testATM.convertToBills(400));
		assertArrayEquals(new int[] { 0, 1, 0, 1, 0, 0, 0 }, testATM.convertToBills(250));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1 }, testATM.convertToBills(5));
		assertArrayEquals(new int[] { 0, 1, 1, 1, 1, 1, 1 }, testATM.convertToBills(385));
		assertArrayEquals(new int[] { 0, 0, 0, 1, 0, 0, 0 }, testATM.convertToBills(50));
		//assertArrayEquals(new int[] { 0, 500, 0, 0, 0, 1, 0 }, testATM.convertToBills(10005));
	}

	@Test
	void testNegativeInput() throws IllegalInputException{
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-100));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-1));
	}
	
	@Test
	void testNotDivisibleByFive() {
		assertThrows(IllegalInputException.class, () -> {testATM.convertToBills(67);});
		assertThrows(IllegalInputException.class, () -> {testATM.convertToBills(1);});
	}
}
