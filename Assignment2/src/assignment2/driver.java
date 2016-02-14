/*
 * Name: Karime Saad
 *EID: ks38728
 *EE 422C lab time: TH 9:30-11am 
 */
package assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class driver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// if (args.length != 1) {
		// System.err.println("Error: Incorrect number of command line
		// arguments");
		// System.exit(-1);
		// } //TODO: remove this before turning in code

		/**
		 * Array of 10 customers created (0-9)
		 */

		Customer[] customers = new Customer[10];
		int numCustomers = 0;

		/**
		 * Some customers created for testing
		 */
		Customer Karime = new Customer("Karime", 1, "123 University");
		customers[numCustomers++] = Karime;
		Customer Juan = new Customer("Juan", 2, "232 University");
		customers[numCustomers++] = Juan;
		Customer Joe = new Customer("Joe", 3, "343 Main Street");
		customers[numCustomers++] = Joe;

		// String transaction = JOptionPane.showInputDialog("Please input a
		// value");

		// try
		{
			// FileReader freader = new FileReader(args[0]);
			// BufferedReader reader = new BufferedReader(freader);
			// for (String transaction = reader.readLine(); transaction != null;
			// transaction = reader.readLine()) {
			while (true) {

				String transaction = JOptionPane.showInputDialog("Please input a value");
				if (transaction == null) {
					System.exit(0);
				}
				/**
				 * Initialize variables.
				 */
				int customerId = -1;
				String transactionType = "";
				String tmp = "";
				double amount = -1;
				String accountType = "";
				String accountType2 = "";
				String tmp2 = "";
				int checkAmount = -1;

				/**
				 * Parsing process of transaction.
				 */

				try {
					customerId = Integer.parseInt(transaction.substring(0, 1));	//get customer ID
					transaction = transaction.substring(2, transaction.length());

					transactionType = transaction.substring(0, 1).toUpperCase(); //get transaction type
					transaction = transaction.substring(2, transaction.length());
					if (transaction.indexOf(' ') > 0){
						tmp = transaction.substring(0, transaction.indexOf(' ')); //parse string from beginning to next space -- tmp
					}

					for (int i = 0; i < tmp.length(); i++) {
						if (tmp.charAt(i) <= '0' || tmp.charAt(i) >= '9') { //does the tmp string contain numbers or a letter?
							checkAmount++; 
						} else {
							checkAmount = 0;
						}
					} 

					if (checkAmount <= 0) {	//tmp string contains 
						if(tmp != ""){
							accountType = tmp.toUpperCase();
							transaction = transaction.substring(1, transaction.length());
						} else {
							accountType = transaction;
						}
					} else {
						amount = Double.parseDouble(tmp);
						transaction = transaction.substring(transaction.indexOf(' ') + 1, transaction.length());
						accountType = transaction.substring(0, 1).toUpperCase();
						transaction = transaction.substring(1, transaction.length());
					}
					if (transaction.length() > 0) {
						accountType2 = transaction.substring(1, transaction.length()).toUpperCase(); // optional
						transaction = "";
					}
					
					if (customers[customerId] == null){
						System.out.println("Customer with unique ID: " + customerId + " has no bank accounts. ");
						continue;
					}

				} catch (Exception e) {
					System.out.println("Invalid transaction from input.\n");
					// System.out.println(e.getMessage());
					// System.out.println(e.getStackTrace());
					continue; // go to next Transaction. Do not break code,
					// continue.
				}


				
				/**
				 * Checks if transaction type is valid.
				 */
				switch (transactionType) {
				case "D":
					customers[customerId].depositToAccount(accountType, amount);
					break;
				case "W":
					customers[customerId].withdrawFromAccount(accountType, amount);
					break;
				case "I":
					customers[customerId].interestTransaction(accountType);
					break;
				case "T":
					customers[customerId].transferTransaction(accountType, accountType2, amount);
					break;
				case "G":
					System.out.println(customers[customerId].getName() + " has " + "$"
							+ customers[customerId].getBalanceTransaction(accountType) + ".");
					break;
				default:
					System.out.println("Invalid transaction type");
				}

				/**
				 * Displays to screen current summary of customer
				 */


				
				System.out.println("Current customer being serviced: " + customers[customerId].getName());
				System.out.println("Checking: " + customers[customerId].getCheckingAccount().balance);
				System.out.println("Savings: " + customers[customerId].getSavingsAccount().balance);
				System.out.println("Student Loan: " + customers[customerId].getStudentLoanAccount().balance);
				System.out.println("Auto Loan: " + customers[customerId].getAutoLoanAccount().balance);
				System.out.println();

				continue;
			}
		}
	}
}

// } catch (FileNotFoundException e) {
//// System.err.println("Error: File not found. Exiting...");
//// e.printStackTrace();
//// System.exit(-1);
// } catch (IOException e) {
// System.err.println("Error: IO exception. Exiting...");
//
// e.printStackTrace();
// System.exit(-1);
// }

// Karime.withdrawFromAccount("C", 100);
