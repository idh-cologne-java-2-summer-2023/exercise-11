package idh.java;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import idh.java.ATM.IllegalInputException;

public class BankTest {
	
	//block foreach
	ATM atm;
	@BeforeEach
    public void setup() {
    	atm = new ATM();
    }
	
	int[] z = new int[] {0,0,0,0,0,0,0};
	int[] st = {0,0,0,0,1,0,1};
	int[] stk25 = {0,0,0,0,1,0,1};
	int[] stk2025 = {4,0,0,0,1,0,1};
	
	//working
	@Test
	public void testnegativeinput() throws IllegalInputException {
	    assertArrayEquals(new int[] {0,0,0,0,0,0,0},  atm.convertToBills(-200));
		}
	
	//working
	@Test
	void wierdnumber() {
		assertThrows(IllegalInputException.class, () -> {atm.convertToBills(77);});

	 	}
	
	//working
	@Test
	void stueckelung() throws IllegalInputException {
		assertArrayEquals(stk25,atm.convertToBills(25));
		assertArrayEquals(stk2025,atm.convertToBills(2025));
		}

	}
	

