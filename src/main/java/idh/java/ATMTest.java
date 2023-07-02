package idh.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATMTest {

    @Test
    public void testConvertToBills_PositiveAmount_DivisibleByFive() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        int[] result = atm.convertToBills(100); // Test with a divisible amount
        int[] expected = new int[]{0, 0, 0, 2, 0, 0, 0}; // Expected number of bills for each denomination
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testConvertToBills_PositiveAmount_NotDivisibleByFive() {
        ATM atm = new ATM();
        Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
            int[] result = atm.convertToBills(123); // Test with a non-divisible amount
        });
    }

    @Test
    public void testConvertToBills_NegativeAmount() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        int[] result = atm.convertToBills(-50); // Test with a negative amount
        int[] expected = new int[]{0, 0, 0, 0, 0, 0, 0}; // Expected result is an array of zeros
        Assertions.assertArrayEquals(expected, result);
    }

}