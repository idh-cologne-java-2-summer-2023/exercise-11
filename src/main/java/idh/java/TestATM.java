package idh.java;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	ATM testATM;

	public static void main(String[] args) {

	}

	@BeforeEach
	public void setup() {
		testATM = new ATM();
	}

	@Test
	public void testDifferentValues() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1 }, testATM.convertToBills(5));
		assertArrayEquals(new int[] { 0, 0, 0, 1, 1, 1, 1 }, testATM.convertToBills(85));
		assertArrayEquals(new int[] { 1, 1, 0, 1, 0, 1, 1 }, testATM.convertToBills(765));
		assertArrayEquals(new int[] { 4, 2, 0, 1, 0, 0, 1 }, testATM.convertToBills(2455));
		assertArrayEquals(new int[] { 1495670, 2, 0, 0, 1, 0, 1 }, testATM.convertToBills(747835425));
		assertArrayEquals(new int[] { 2000000, 0, 0, 0, 0, 0, 0 }, testATM.convertToBills(1000000000));
	}

	@Test
	public void testDivisibleFive() {
		assertThrows(IllegalInputException.class, () -> {
			testATM.convertToBills(8);
		});
	}

	@Test
	public void testNegativeValue() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, testATM.convertToBills(-255));
	}
}