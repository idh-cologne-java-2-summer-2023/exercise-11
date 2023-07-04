package idh java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATMTests {

    @Test
    public void testConvertToBills_ValidAmount() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        
       
        int[] expected = new int[] {0, 0, 1, 0, 0, 1, 0}; 
        int[] actual = atm.convertToBills(205); 
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertToBills_NegativeAmount() throws ATM.IllegalInputException {
        ATM atm = new ATM();
        
     
        int[] expected = new int[] {0, 0, 0, 0, 0, 0, 0}; 
        int[] actual = atm.convertToBills(-100); 
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertToBills_NotDivisibleBy5() {
        ATM atm = new ATM();
        
     
        Assertions.assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(123); 
        });
    }
}

