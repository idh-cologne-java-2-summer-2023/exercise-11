import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM;
import idh.java.ATM.IllegalInputException;

public class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setup() {
        atm = new ATM();
    }

    @Test
    public void testConvertToBillsWithDivisibleInput() throws IllegalInputException {
        int[] expected = {2, 1, 0, 1, 0, 0, 0};
        int[] result = atm.convertToBills(1350);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testConvertToBillsWithNegativeInput() throws IllegalInputException {
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        int[] result = atm.convertToBills(-100);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testConvertToBillsWithNonDivisibleInput() {
        Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(123);
        });
    }

    @Test
    public void testConvertToBillsWithSmallestPossibleInput() throws IllegalInputException {
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        int[] result = atm.convertToBills(0);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testConvertToBillsWithLargestPossibleInput() throws IllegalInputException {
        int[] expected = {2_000_000_000, 10_000_000, 0, 0, 0, 0, 0};
        int[] result = atm.convertToBills(Integer.MAX_VALUE);
        Assertions.assertArrayEquals(expected, result);
    }
}
