package idh.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class atmTest {

    private ATM atm;

    @Before
    public void setup() {
        atm = new ATM();
    }

    @Test
    public void testCashoutWithDivisibleInput() throws ATM.IllegalInputException {
        int amount = 750;
        int[] expectedBills = {1, 1, 0, 1, 0, 0, 0};

        int[] actualBills = atm.convertToBills(amount);

        Assert.assertArrayEquals(expectedBills, actualBills);
    }

    @Test
    public void testCashoutWithSmallestNumber() throws ATM.IllegalInputException {
        int amount = 0;
        int[] expectedBills = {0, 0, 0, 0, 0, 0, 0};

        int[] actualBills = atm.convertToBills(amount);

        Assert.assertArrayEquals(expectedBills, actualBills);
    }

    @Test
    public void testCashoutWithLargestNumber() throws ATM.IllegalInputException {
        int amount = Integer.MAX_VALUE;
        int[] expectedBills = {Integer.MAX_VALUE / 500, 0, 0, 0, 0, 0, 0};

        int[] actualBills = atm.convertToBills(amount);

        Assert.assertArrayEquals(expectedBills, actualBills);
    }

    @Test(expected = ATM.IllegalInputException.class)
    public void testCashoutWithNegativeInput() throws ATM.IllegalInputException {
        int amount = -100;

        atm.convertToBills(amount);
    }

    @Test(expected = ATM.IllegalInputException.class)
    public void testCashoutWithNonDivisibleInput() throws ATM.IllegalInputException {
        int amount = 123;

        atm.convertToBills(amount);
    }
}