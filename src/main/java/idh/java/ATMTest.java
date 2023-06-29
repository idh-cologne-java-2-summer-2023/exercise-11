package idh.java;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class ATMTest {
ATM myatm;
	
	
	public static void main(String[] args) {

	}
	@BeforeEach
    public void setup() {
    	myatm = new ATM();
    }
	@Test
	public void testmethod() throws IllegalInputException {
    assertArrayEquals(new int[] {1,0,0,0,0,0,0}, myatm.convertToBills(500));
    assertArrayEquals(new int[] {0,0,0,0,0,0,1}, myatm.convertToBills(5));
    assertArrayEquals(new int[] {20,1,0,1,0,0,0}, myatm.convertToBills(10250));
    assertArrayEquals(new int[] {1,1,1,1,1,1,1}, myatm.convertToBills(885));
	}
	@Test
	public void testnegativeinput() throws IllegalInputException {
    assertArrayEquals(new int[] {0,0,0,0,0,0,0},  myatm.convertToBills(-200));
	}
	@Test
	public void testdivisiblethroughfive(){
    assertThrows(IllegalInputException.class, () -> { myatm.convertToBills(4); });
	}
}
