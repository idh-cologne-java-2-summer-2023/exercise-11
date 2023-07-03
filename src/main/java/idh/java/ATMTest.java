package idh.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import idh.java.ATM.IllegalInputException;

public class ATMTest {
	
	//verstehe das Prinzip, aber codetechnisch umsetzen kann ich es (noch) nicht.
	
	
	@Before
	   void setUp() {
		ATM atm = new ATM();
	}

	@Test
	public int[] testConvertToBigBills() {	
		
		int amount = 100;
		
		int[] value_of_bills = new int[] {500, 200, 100, 50, 20, 10, 5};
		
		int[] r = new int[7];
		
		for (int i = 0;  i < value_of_bills.length; i++) {
			r[i] = amount / value_of_bills[i];		
			System.out.println(r);
			return r;
		}
		return r;
	
		}
	
	
	    @Test
        public int[] negativeNumber() {	
        	
        int amount = -5;
		
		int[] value_of_bills = new int[] {500, 200, 100, 50, 20, 10, 5};
		
		int[] r = new int[7];
		
		if (amount < 0) {
			System.out.println(new int[] {0,0,0,0,0,0,0});
		} return new int[] {0,0,0,0,0,0,0};
     }
        
        
        
        @Test
        public void throwException() throws IllegalInputException {
        	
        	int amount = 4;
        	
        	if (amount > 0) {
    			System.out.println("New Illegal Exception.");
        }
        
}
}
	
		
		
	


