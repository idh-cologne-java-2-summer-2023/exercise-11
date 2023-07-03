package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class UnitTest {

    @Test
    void testCashoutWithEnoughCash() throws IllegalInputException {
        ATM atm = new ATM();
        atm.cash = 500; // Set the initial cash in the ATM to 500

        int[] expectedBills = new int[] { 1, 0, 0, 0, 0, 0, 0 };
        assertArrayEquals(expectedBills, atm.convertToBills(500));
    }

    @Test
    void testCashoutWithNotEnoughCash() {
        ATM atm = new ATM();
        atm.cash = 100; // Set the initial cash in the ATM to 100

        assertThrows(IllegalStateException.class, () -> {
            atm.cashout(200);
        });
    }

    @Test
    void testConvertToBills() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        assertArrayEquals(new int[] { 1, 1, 1, 1, 0, 0, 0 }, atm.convertToBills(870));
        assertArrayEquals(new int[] { 0, 1, 0, 0, 0, 0, 1 }, atm.convertToBills(505));
        assertArrayEquals(new int[] { 0, 0, 0, 0, 1, 1, 0 }, atm.convertToBills(30));
    }

    @Test
    void testConvertToBillsWithNegativeAmount() {
        ATM atm = new ATM();

        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(-100);
        });
    }

    @Test
    void testConvertToBillsWithInvalidAmount() {
        ATM atm = new ATM();

        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(7);
        });
    }
}
