package idh.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATMTest {

	//Überprüft, ob eine Zahl sich durch 5 teilen lässt 
    @Test
    public void testConvertToBills_DivisibleByFive() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        int[] expected = {1, 0, 0, 0, 0, 0, 0}; 
        Assertions.assertArrayEquals(expected, atm.convertToBills(500));
    }

    //Überprüft, ob eine Zahl nicht durch 5 teilbar ist 
    @Test
    public void testConvertToBills_NotDivisibleByFive() {
        ATM atm = new ATM();
        Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(123);
        });
    }

    //Überprüft, ob für eine negative Zahl ein Array mit nullen zurückgegeben wird
    @Test
    public void testConvertToBills_NegativeInput() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        int[] expected = {0, 0, 0, 0, 0, 0, 0}; // All zeros
        Assertions.assertArrayEquals(expected, atm.convertToBills(-100));
    }
    
    //Überprüft, ob große Werte in erwarteten Stücken zurückgegeben werden 
    @Test
    public void testConvertToBills_LargestInput() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        int[] expected = {2000000000, 1000000000, 500000000, 100000000, 50000000, 10000000, 5000000};
        Assertions.assertArrayEquals(expected, atm.convertToBills(Integer.MAX_VALUE));
    }
}

