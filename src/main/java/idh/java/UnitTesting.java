package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import idh.java.ATM.IllegalInputException;

public class UnitTesting {
        ATM atm;

        @BeforeEach
        public void startTest() {
            atm = new ATM();
        }


        @Test
        public void testFunction() throws IllegalInputException {
            assertArrayEquals(new int[] {0,1,0,0,0,0,0}, atm.convertToBills(200));
            assertArrayEquals(new int[] {1,0,0,0,0,0,0}, atm.convertToBills(500));
            assertArrayEquals(new int[] {0,2,0,0,1,0,0}, atm.convertToBills(420));
            assertArrayEquals(new int[] {0,0,1,0,0,0,0}, atm.convertToBills(100));
            assertThrows(ATM.IllegalInputException.class, () -> {atm.convertToBills(777);});


        }

}
