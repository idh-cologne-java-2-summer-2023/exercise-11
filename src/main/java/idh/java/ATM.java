package idh.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BANK  {
	
	
	int cash = 100;
		
	
	int[] value_of_bills = new int[] {500, 200, 100, 50, 20, 10, 5};

	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int amount) {
		
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		
		if (amount % 5 > 0) {
			System.out.println("Sorry, this amount cannot be expressed in bills.");
			return;
		}
		
		
		int[] bills = new int[] {0, 0, 0, 0, 0, 0, 0};
		try {
			bills = convertToBills(amount);
		} catch (IllegalInputException e) {
			// this should not happen, since we're verifying it before
			e.printStackTrace();
		}
		
		// generate the printout string
		StringBuilder b = new StringBuilder();
		b.append("Ok, you'll get ");
		int i;
		for (i = 0; i < value_of_bills.length-1; i++) {
			b.append(bills[i]).append(" ").append(value_of_bills[i]).append("s, ");
		}
		b.append(" and ").append(bills[i]).append(" ").append(value_of_bills[i]);
		System.out.println(b.toString());

		cash += amount;
		
	};


	protected int[] convertToBills(int amount) throws IllegalInputException {
		// illegal amount
		if (amount < 0)
			return new int[] {0,0,0,0,0,0,0};
		
		// return array for the different bill types
		int[] r = new int[7];
		
		// iterate over the possible pill types
		// order is important here! Need to go from largest to smallest.
		for (int i = 0;  i < value_of_bills.length; i++) {
			r[i] = amount / value_of_bills[i];
			amount = amount % value_of_bills[i];		
		}
		if (amount > 0) {
			throw new IllegalInputException();
		}
		return r;
	}
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		BANK bank = new BANK();
		bank.run();
	};
	
	class IllegalInputException extends Exception {

		private static final long serialVersionUID = 1L;
		
	}
	
}
