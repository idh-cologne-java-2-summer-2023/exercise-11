package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	ATM atm;

	@BeforeEach
	void setUp() {
		atm = new ATM();
	}

	@Test
	void testValueSplitting() throws IllegalInputException {
		assertArrayEquals(new int[] { 4, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(2000));
		assertArrayEquals(new int[] { 200, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(100000));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1 }, atm.convertToBills(5));
		assertArrayEquals(new int[] { 11, 0, 0, 1, 0, 0, 1 }, atm.convertToBills(5555));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 1, 1 }, atm.convertToBills(15));
		assertArrayEquals(new int[] { 0, 0, 1, 0, 2, 0, 0 }, atm.convertToBills(140));
	}

	@Test
	void testNegativeInput() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-313));
	}

	@Test
	void testNonDividableInput() {
		assertThrows(IllegalInputException.class, () -> {
			atm.convertToBills(3);
		});
	}

}