package idh.java;
 import org.junit.jupiter.api.Assertions;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;



 public class TestMyAtm {

     private ATM atm;

     @BeforeEach
     public void setup() {
         atm = new ATM();
     }

     @Test
     public void TestTeilbar() throws idh.java.ATM.IllegalInputException  {
         int amount = 200;
         int[] expected = {0, 1, 0, 0, 0, 0, 0}; // Expecting one 200 bill
         Assertions.assertArrayEquals(expected, atm.convertToBills(amount));
     }

     @Test
     public void TestNegativ() throws idh.java.ATM.IllegalInputException {
         int amount = -100;
         int[] expected = {0, 0, 0, 0, 0, 0, 0}; // Expecting an array of zeros
         Assertions.assertArrayEquals(expected, atm.convertToBills(amount));
     }

     @Test
     public void TestNichtTeilbar() {
         int amount = 123;
         Assertions.assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(amount));
     }


 }
 //