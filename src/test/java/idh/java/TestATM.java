package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	ATM myTestAtm;
	
	@BeforeEach
	void setup() {
		myTestAtm = new ATM();
	}
	
	@Test
	void negativeInput() throws IllegalInputException {
		int[] testArr = new int[] {0,0,0,0,0,0,0};
		for(int i=0; i<testArr.length; i++) {
			assertEquals(testArr[i], myTestAtm.convertToBills(-4)[i]);
		}
	}
	
	@Test
	void notDividedByFive() {
		assertThrows(IllegalInputException.class , () -> myTestAtm.convertToBills(74));
	}
	
	@Test
	void dividingMoney() throws IllegalInputException {
		int[] test1015 = new int[] {2,0,0,0,0,1,1};
		int[] test5 = new int[] {0,0,0,0,0,0,1};
		int[] test50 = new int[] {0,0,0,1,0,0,0};
		int[] test175 = new int[] {0,0,1,1,1,0,1};
		int[] test835 = new int[] {1,1,1,0,1,1,1};
		
		for(int i=0; i<test5.length; i++) {
			assertEquals(test1015[i], myTestAtm.convertToBills(1015)[i]);
			assertEquals(test5[i] , myTestAtm.convertToBills(5)[i]);
			assertEquals(test50[i] , myTestAtm.convertToBills(50)[i]);
			assertEquals(test175[i] , myTestAtm.convertToBills(175)[i]);
			assertEquals(test835[i] , myTestAtm.convertToBills(835)[i]);

		}
	}
}
