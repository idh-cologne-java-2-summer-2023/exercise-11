package idh.java;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class ATMTest {

	ATM myATM;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@BeforeEach
	void setup() {
		myATM = new ATM();
	}
	
	
	@Test
	void testInputZero() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, myATM.convertToBills(0));
	}
	
	@Test
	void testNegativeInput() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, myATM.convertToBills(-500));
	}
	
	@Test
	void testValidInputs() throws IllegalInputException {
		assertArrayEquals(new int[] {1,0,0,1,0,1,0}, myATM.convertToBills(560));
		assertArrayEquals(new int[] {20,2,0,1,1,0,1}, myATM.convertToBills(10475));
		assertArrayEquals(new int[] {0,1,1,0,1,1,0}, myATM.convertToBills(330));
	}
	
	@Test
	void testInvalidInput() throws IllegalInputException {
		assertThrows(IllegalInputException.class, () -> { myATM.convertToBills(3); });
	}

}
