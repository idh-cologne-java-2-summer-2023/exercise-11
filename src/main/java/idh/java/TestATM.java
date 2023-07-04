package idh.java;
//import static org.junit.jupiter.api.Asertions.AssertEquals;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;
public class TestATM {

	ATM testATM = new ATM();
	public static void main() {
		
	
			
		}

	@Test
	@BeforeAll
	void startup() {
		ATM testATM = new ATM();
		assertTrue(cash < 0);
		
	}
	
	@Test 
	void billSize() {
		ATM testATM = new ATM();
		assertArrayEquals( bills > 0, cashout(amount));
	}
	

}
