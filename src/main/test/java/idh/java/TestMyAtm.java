package idh.java;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyAtm {
    ATM testAtm;

    public static void main(String[] args){

    }
    @BeforeEach
    void setUp(){
        this.testAtm = new ATM();
    }


    @Test
    void inputDivisibleByFive() throws ATM.IllegalInputException{
        assertArrayEquals(new int[] {0,0,0,0,0,0,0}, this.testAtm.convertToBills(0));
        assertArrayEquals(new int[] {0,0,0,0,2,0,1}, this.testAtm.convertToBills(45));
        assertArrayEquals(new int[] {0,0,0,0,0,0,1}, this.testAtm.convertToBills(5));
        assertArrayEquals(new int[] {0,1,0,0,1,1,1}, this.testAtm.convertToBills(235));
        assertArrayEquals(new int[] {11,0,0,0,0,1,1}, this.testAtm.convertToBills(5515));
        assertArrayEquals(new int[] {6,2,0,1,2,0,1}, this.testAtm.convertToBills(3495));
    }
    @Test
    void negativeInput() throws ATM.IllegalInputException{
        assertArrayEquals(new int[] {0,0,0,0,0,0,0}, this.testAtm.convertToBills(-15));
        assertArrayEquals(new int[] {0,0,0,0,0,0,0}, this.testAtm.convertToBills(-100));
        assertArrayEquals(new int[] {0,0,0,0,0,0,0}, this.testAtm.convertToBills(-33));
        assertArrayEquals(new int[] {0,0,0,0,0,0,0}, this.testAtm.convertToBills(-0));
    }

    @Test
    void inputNotDivisibleByFive(){
        assertThrows(ATM.IllegalInputException.class, ()-> {this.testAtm.convertToBills(2);});
        assertThrows(ATM.IllegalInputException.class, ()-> {this.testAtm.convertToBills(999);});
    }



}
