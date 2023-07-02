package idh.java;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ATM  {
	// initial cash in the ATM
	int cash = 100000;
		
	// Which banknotes do we have?
	int[] value_of_bills = new int[] {500, 200, 100, 50, 20, 10, 5};

	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exits
	 * @throws IOException 
	 */
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the amount to withdraw: ");
		String line;
		while (!(line = br.readLine()).equals("exit")) {
			try {
				int amount = Integer.parseInt(line);
				cashout(amount);
				System.out.print("Enter the amount to withdraw: ");
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int amount) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		
		
		// withdraw
		int[] bills = new int[7];
		try {
			
			bills = convertToBills(amount);
		
		// generate the printout string
		StringBuilder b = new StringBuilder();
		b.append("Ok, you'll get ");
		int i;
		for (i = 0; i < value_of_bills.length-1; i++) {
			b.append(bills[i] + "x ").append(value_of_bills[i]).append("s, ");
		}
		b.append(bills[i] + "x ").append(value_of_bills[i] + "s");
		int count = 0;
		for (int e : bills) {
			count += e;
		}
		b.append("\ntotal amount of bills is " + count);
		System.out.println(b.toString());

		// subtract the entered amount from the available cash 
		cash -= amount;
		
		} catch (IllegalInputException e) {
			// this should not happen, since we're verifying it before
			e.printStackTrace();
		}
	};

	/**
	 * Converts an amount to an array with the number of bills of each value. 
	 * This function returns as few bills as possible, i.e., highest value first. 
	 * (this is not popular in reality ...).
	 * @param amount
	 * @return
	 * @throws IllegalInputException 
	 */
	protected int[] convertToBills(int amount) throws IllegalInputException {
		// return array for the different bill types
		int[] r = new int[7];
		
		if (amount == 0) return new int[] {0,0,0,0,0,0,0};
		if (amount % 5 == 0) {
			if (amount < 0) return new int[] {0,0,0,0,0,0,0};
			
			// iterate over the possible pill types
			// order is important here! Need to go from largest to smallest.
			for (int i = 0;  i < value_of_bills.length; i++) {
				r[i] = amount / value_of_bills[i];
				amount = amount % value_of_bills[i];		
			}
		}
		
		if (amount > 0) {
			throw new IllegalInputException();
		}
		return r;
	}
	
	
	/**
	 * Launches the ATM
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ATM atm = new ATM();
		atm.run();
	};
	
	class IllegalInputException extends Exception {

		private static final long serialVersionUID = 1L;
		
		
	}
	
}
