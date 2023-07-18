package idh.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ATMTest {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    void testConvertToBills_PositiveAmount() throws ATM.IllegalInputException {
        int amount = 745;
        int[] expectedBills = new int[]{1, 1, 2, 0, 2, 0, 1};
        Assertions.assertArrayEquals(expectedBills, atm.convertToBills(amount));
    }

    @Test
    void testConvertToBills_NegativeAmount() throws ATM.IllegalInputException {
        int amount = -100;
        int[] expectedBills = new int[]{0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expectedBills, atm.convertToBills(amount));
    }

    @Test
    void testConvertToBills_NonDivisibleByFive() {
        int amount = 17;
        Assertions.assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(amount));
    }
}

