package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

//Run as JUnit Test macht gar nichts und run as Maven test liefert nur "Build Success" und nicht ob die tests erfolgreich waren.
	//Ich hatte anfangs Probleme mit dem Import der org.junit in meine Klasse, also hängt das vielleicht zusammen. 
	//Leider weiß ich nicht, wie ich das lösen kann.

public class TestATM {
	ATM testATM;

	@BeforeEach
	void setup() {
		testATM = new ATM();
	}

	@Test
	void testBills() throws IllegalInputException {
		assertArrayEquals(new int[] { 2, 0, 0, 0, 0, 0 }, testATM.convertToBills(400));
		assertArrayEquals(new int[] { 1, 0, 1, 0, 0, 0 }, testATM.convertToBills(250));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 1 }, testATM.convertToBills(5));
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1, 1 }, testATM.convertToBills(385));
		assertArrayEquals(new int[] { 0, 0, 1, 0, 0, 0 }, testATM.convertToBills(50));
		assertArrayEquals(new int[] { 500, 0, 0, 0, 0, 1 }, testATM.convertToBills(10005));
	}

	@Test
	void testNegativeInput() throws IllegalInputException{
		assertArrayEquals(new int[] {0,0,0,0,0,0}, testATM.convertToBills(-100));
		assertArrayEquals(new int[] {0,0,0,0,0,0}, testATM.convertToBills(-1));
	}
	
	@Test
	void testNotDivisibleByFive() {
		assertThrows(IllegalInputException.class, () -> {testATM.convertToBills(67);});
		assertThrows(IllegalInputException.class, () -> {testATM.convertToBills(1);});
	}
}
