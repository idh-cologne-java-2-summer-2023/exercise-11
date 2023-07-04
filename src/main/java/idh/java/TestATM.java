package idh.java;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;
public class TestATM {

	ATM tATM = new ATM();
	public static void main() {
		
	
			
		}
//Testing for bad input
	@Test
	@BeforeAll
	void startup() {
		ATM tATM = new ATM();
		assertThrows(IllegalInputException.class,() -> tATM.convertToBills(0)); 
		
	}
//Testing for  amounts of cash
	@Test 
	void billSize() throws IllegalInputException {
		ATM tATM = new ATM();
		int [] minFive =  {0,0,0,0,0,0};
		int [] pluFive = {1,0,0,0,0,0};
		int[] pluFiveHundred = {0,0,0,0,1,2};
		assertArrayEquals(pluFive, tATM.convertToBills(5));
		assertArrayEquals(minFive, tATM.convertToBills(-5));
		assertArrayEquals(pluFiveHundred, tATM.convertToBills(500));
	
		
	}
	

}
