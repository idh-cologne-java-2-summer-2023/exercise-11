
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import idh.java.ATM.IllegalInputException;

public class ATMTest {
    
    private ATM atm;
    
    @Before
    public void setUp() {
        atm = new ATM();
    }
    
    @Test
    public void testConvertToBills_ValidAmount() {
       
        int amount = 900;
        int[] expected = {0, 0, 3, 1, 0, 0, 0};
        try {
            int[] result = atm.convertToBills(amount);
            assertArrayEquals(expected, result);
        } catch (IllegalInputException e) {
            fail("No exception should be thrown for a valid amount.");
        }
    }
    
    @Test
    public void testConvertToBills_InvalidAmount() {
       
        int amount = 663;
        try {
            atm.convertToBills(amount);
            fail("An exception should be thrown for an invalid amount.");
        } catch (IllegalInputException e) {
            
        }
    }
    
    @Test
    public void testConvertToBills_NegativeAmount() {
      
        int amount = -100;
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        try {
            int[] result = atm.convertToBills(amount);
            assertArrayEquals(expected, result);
        } catch (IllegalInputException e) {
            fail("No exception should be thrown for a negative amount.");
        }
    }
    
    @Test
    public void testConvertToBills_MinimumAmount() {
    
        int amount = 0;
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        try {
            int[] result = atm.convertToBills(amount);
            assertArrayEquals(expected, result);
        } catch (IllegalInputException e) {
            fail("No exception should be thrown for the minimum amount.");
        }
    }
    
    @Test
    public void testConvertToBills_MaximumAmount() {
       
        int amount = Integer.MAX_VALUE;
        
        try {
            atm.convertToBills(amount);
        } catch (IllegalInputException e) {
            fail("No exception should be thrown for the maximum amount.");
        }
    }
    
}