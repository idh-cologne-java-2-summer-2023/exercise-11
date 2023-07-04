package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {

	ATM myATM;

	public static void main(String[] args) {

	}

	@BeforeEach
	void setup() {
		this.myATM = new ATM();
	}

	@Test
	void testDivisibleByFive() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 1, 0, 1, 0, 0 }, this.myATM.convertToBills(120));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1 }, this.myATM.convertToBills(5));
		assertArrayEquals(new int[] { 0, 3, 0, 0, 0, 0, 0 }, this.myATM.convertToBills(600));
		assertArrayEquals(new int[] { 5, 0, 0, 0, 0, 0, 1 }, this.myATM.convertToBills(2505));
	}

	@Test
	void testNegativeAmount() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, this.myATM.convertToBills(-5));

	}

	@Test
	void testNonDivisibleByFive() {
		assertThrows(IllegalInputException.class, () -> {
			this.myATM.convertToBills(123);
		});
	}

}