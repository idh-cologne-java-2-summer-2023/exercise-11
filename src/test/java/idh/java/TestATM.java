package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
    @Test
    void viable() throws IllegalInputException {
        ATM a = new ATM();
        int[] max = a.convertToBills(885);
        int[] ex1 = {1,1,1,1,1,1,1};
        assertArrayEquals(ex1, max);
        int[] min = a.convertToBills(5);
        int[] ex2 = {0,0,0,0,0,0,1};
        assertArrayEquals(ex2, min);
        int[] tenner = a.convertToBills(10);
        int[] ex3 = {0,0,0,0,0,1,0};
        assertArrayEquals(ex3, tenner);
        int[] twenty = a.convertToBills(20);
        int[] ex4 = {0,0,0,0,1,0,0};
        assertArrayEquals(ex4, twenty);
        int[] fifty = a.convertToBills(50);
        int[] ex5 = {0,0,0,1,0,0,0};
        assertArrayEquals(ex5, fifty);
        int[] houndred = a.convertToBills(100);
        int[] ex6 = {0,0,1,0,0,0,0};
        assertArrayEquals(ex6, houndred);
        int[] twohoundred = a.convertToBills(200);
        int[] ex7 = {0,1,0,0,0,0,0};
        assertArrayEquals(ex7, twohoundred);
        int[] fivehoundred = a.convertToBills(500);
        int[] ex8 = {1,0,0,0,0,0,0};
        assertArrayEquals(ex8, fivehoundred);
    }

    @Test
    void negative() throws IllegalInputException {
        ATM a = new ATM();
        int[] neg = a.convertToBills(-100);
        int[] ex = {0,0,0,0,0,0,0};
        assertArrayEquals(ex, neg);
    }

    @Test
    void exception() {
        assertThrows(IllegalInputException.class,() -> {ATM a = new ATM(); a.convertToBills(2);});
    }
}
