package idh.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

	public class Atmtest {

	    @Test
	    public void testConvertToBills_ValidInput() throws ATM.IllegalInputException {
	        ATM atm = new ATM();

	        // Positive input values divisible by 5
	        int[] expected1 = new int[]{2, 0, 0, 0, 0, 0, 0}; // 2x 500
	        Assertions.assertArrayEquals(expected1, atm.convertToBills(1000));

	        int[] expected2 = new int[]{1, 1, 0, 0, 0, 0, 0}; // 1x 500, 1x 200
	        Assertions.assertArrayEquals(expected2, atm.convertToBills(700));

	        int[] expected3 = new int[]{0, 0, 1, 1, 1, 0, 0}; // 1x 100, 1x 50, 1x 20
	        Assertions.assertArrayEquals(expected3, atm.convertToBills(170));

	        int[] expected4 = new int[]{0, 0, 0, 2, 0, 0, 1}; // 2x 50, 1x 5
	        Assertions.assertArrayEquals(expected4, atm.convertToBills(105));

	        // Edge cases
	        int[] expected5 = new int[]{0, 0, 0, 0, 0, 0, 0}; // 0x any bill
	        Assertions.assertArrayEquals(expected5, atm.convertToBills(0));

	        int[] expected6 = new int[]{0, 0, 0, 0, 0, 0, 0}; // 0x any bill
	        Assertions.assertArrayEquals(expected6, atm.convertToBills(-100));

	        int[] expected7 = new int[]{0, 0, 0, 0, 0, 0, 2}; // 2x 5
	        Assertions.assertArrayEquals(expected7, atm.convertToBills(10));
	    }

	    @Test
	    public void testConvertToBills_InvalidInput() {
	        ATM atm = new ATM();

	        // Negative amount should throw IllegalInputException
	        Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
	            atm.convertToBills(-50);
	        });

	        // Amount not divisible by 5 should throw IllegalInputException
	        Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
	            atm.convertToBills(123);
	        });
	    }
	}



