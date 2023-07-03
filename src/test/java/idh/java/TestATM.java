package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import idh.java.ATM.IllegalInputException;


public class TestATM {
	
	@Test
	void testStueckelung() throws IllegalInputException {
		//Habe versuch ATM Objekt mit BeforeEach anzulegen 
		//aber konnte in keiner Testmethode darauf zugreifen(???)
		ATM atm = new ATM();
										//500, 200, 100, 50   20    10    5
		int [] exp = new int [] {0,        0,      0,     0,    1,     1,     0};
		
		//Kleine Zahlen
		assertArrayEquals(exp, atm.convertToBills(30));
		
		exp[5] = 0;
		exp[4] = 2;
		assertArrayEquals(exp, atm.convertToBills(40));
		
		exp[5] = 1;
		exp[4] = 0;
		exp[3] = 1;
		assertArrayEquals(exp, atm.convertToBills(60));
		
		exp[5] = 0;
		exp[4] = 2;
		assertArrayEquals(exp, atm.convertToBills(90));
		
		//Grosse Zahlen
											//500, 200, 100, 50   20    10    5
		int [] expBig = new int [] {20,    0,      0,     0,    0,     0,     0};
		assertArrayEquals(expBig, atm.convertToBills(10000));
		
		expBig[2] = 1;
		expBig[3] = 1;
		expBig[4] = 1;
		assertArrayEquals(expBig, atm.convertToBills(10170));
		
		expBig[0] = 200;
		expBig[2] = 0;
		expBig[3] = 0;
		expBig[4] = 0;
		assertArrayEquals(expBig, atm.convertToBills(100000));
		
		expBig[0] = 2000;
		assertArrayEquals(expBig, atm.convertToBills(1000000));
		
	}
	
	@Test
	void testNegative() throws IllegalInputException {
		ATM atm = new ATM();
		int [] exp = new int [] {0, 0, 0, 0, 0, 0, 0};
		
		assertArrayEquals(exp, atm.convertToBills(-10));
	}

	@Test
	void testInputNotDivisibleByFive() {
		ATM atm = new ATM();
		
		try {
			atm.convertToBills(7);
		} 
		catch (Exception IllegalInputException) {
			System.out.println("Dies ist die Ausgabe der erwarteten Exception");
		}
	}
























}
