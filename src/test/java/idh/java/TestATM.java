package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
	void testFives() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, testATM.convertToBills(5));
		assertArrayEquals(new int[] {0,0,0,0,1,0,1}, testATM.convertToBills(25));
		assertArrayEquals(new int[] {0,0,0,0,1,1,1}, testATM.convertToBills(35));
		assertArrayEquals(new int[] {0,0,1,0,0,0,0}, testATM.convertToBills(100));
		assertArrayEquals(new int[] {1,0,0,0,0,0,0}, testATM.convertToBills(500));
		assertArrayEquals(new int[] {1,0,1,1,2,0,1}, testATM.convertToBills(695));
		assertArrayEquals(new int[] {1,1,1,1,1,1,1}, testATM.convertToBills(885));
		assertArrayEquals(new int[] {1,2,0,1,2,0,1}, testATM.convertToBills(995));
		assertArrayEquals(new int[] {2,0,0,0,2,0,1}, testATM.convertToBills(1045));
	}
	
	@Test
	void testNegative() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-0));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-1));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-5));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-987));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-100000));		
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(-2147483648));
	}
	
	@Test
	void testNull() throws IllegalInputException {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, testATM.convertToBills(0));
	}
	
	@Test
	void testLargeNumbers() throws IllegalInputException {
		assertArrayEquals(new int[] {1977,1,0,0,1,0,1}, testATM.convertToBills(988725));
		assertArrayEquals(new int[] {2000000,0,0,0,0,0,0}, testATM.convertToBills(1000000000));
		assertArrayEquals(new int[] {4294967,0,1,0,2,0,1}, testATM.convertToBills(2147483645));		
	}
	
	@Test
	void testNoFives() throws IllegalInputException {
		assertThrows(IllegalInputException.class, () ->
    	testATM.convertToBills(1));
		assertThrows(IllegalInputException.class, () ->
        	testATM.convertToBills(73));
		assertThrows(IllegalInputException.class, () ->
    	testATM.convertToBills(2147483647));
	}
	
	

}
